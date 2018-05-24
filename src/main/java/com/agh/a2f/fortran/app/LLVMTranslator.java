package com.agh.a2f.fortran.app;

import com.agh.a2f.fortran.app.util.Arithmetic;
import com.agh.a2f.fortran.app.util.Variable;
import com.agh.a2f.fortran.generated.fortran77BaseListener;
import com.agh.a2f.fortran.generated.fortran77Lexer;
import com.agh.a2f.fortran.generated.fortran77Parser;
import com.stefanik.cod.controller.COD;
import com.stefanik.cod.controller.CODFactory;
import org.antlr.v4.runtime.BufferedTokenStream;
import org.antlr.v4.runtime.RuleContext;
import org.antlr.v4.runtime.tree.ParseTree;
import org.bytedeco.javacpp.PointerPointer;

import java.util.*;
import java.util.stream.Collectors;

import static org.bytedeco.javacpp.LLVM.*;

public class LLVMTranslator extends fortran77BaseListener {
    private static final COD cod = CODFactory.get();

    private BufferedTokenStream tokens;

    public LLVMTranslator(BufferedTokenStream tokens) {
        this.tokens = tokens;
    }

    private LLVMModuleRef mod = null;
    private LLVMBuilderRef builder = null;

    private Stack<LLVMValueRef> stack = new Stack<>();
    private Stack<String> stringStack = new Stack<>();

    private Map<String, LLVMValueRef> valueRefs = new HashMap<>();

    private String currentFunction = null;

    //    private static Integer arithmeticStackIterator = 0;//TODO
    private Stack<List<String>> arithmeticComponentsStack = new Stack<>();
    private Map<String, LLVMValueRef> arithmeticMapResults = new HashMap<>();


    @Override
    public void enterProgramStatement(fortran77Parser.ProgramStatementContext ctx) {
        String name = ctx.NAME().getSymbol().getText();
        mod = LLVMModuleCreateWithName(name);
        LLVMValueRef mainFunc = LLVMAddFunction(mod,
                "main", LLVMFunctionType(LLVMVoidType(), LLVMVoidType(), 0, 0));
        valueRefs.put("main", mainFunc);
        currentFunction = "main";
        LLVMSetFunctionCallConv(mainFunc, LLVMCCallConv);
    }

    @Override
    public void exitProgram(fortran77Parser.ProgramContext ctx) {
//        System.out.println("\t-(9)exitProgram");
        LLVMDumpModule(mod);
        LLVMWriteBitcodeToFile(mod, "f2llvm.bc"); //save to bytecode

        LLVMFunctions.executeCode(mod, valueRefs.get("main"));

//        LLVMDisposeModule(mod);
    }


    /////////**START** MEMORY ALLOCATING BLOCK

    //TODO alokacja pamięci dla real

    @Override
    public void enterTypeStatementNameList(fortran77Parser.TypeStatementNameListContext ctx) {
        for (fortran77Parser.TypeStatementNameContext name : ctx.typeStatementName()) {
            LLVMValueRef var = LLVMBuildAlloca(builder, LLVMInt32Type(), name.getText());
            valueRefs.put(name.getText(), var);
        }
    }

    @Override
    public void exitTypeStatementNameCharList(fortran77Parser.TypeStatementNameCharListContext ctx) {
//        System.out.println("\t-(6)exitTypeStatementNameCharList");
        Integer length = Integer.valueOf(stringStack.pop()) + 1; // +1 because it dont work when table has the same length as string (PRINT ISSUE)

        for (fortran77Parser.TypeStatementNameCharContext name : ctx.typeStatementNameChar()) {
            LLVMValueRef var = LLVMBuildAlloca(builder, LLVMArrayType(LLVMInt8Type(), length), name.getText());
            valueRefs.put(name.getText(), var);
        }
    }

    /////////**END** MEMORY ALLOCATING BLOCK

    /////////**START** ASSIGNMENT BLOCK
    @Override
    public void enterCharacterWithLen(fortran77Parser.CharacterWithLenContext ctx) {
//        System.out.println("\t-(3)enterCharacterWithLen");
        super.enterCharacterWithLen(ctx);
    }

    @Override
    public void enterIntConstantExpr(fortran77Parser.IntConstantExprContext ctx) {
        stringStack.push(ctx.getText());
    }

    @Override
    public void enterAssignmentStatement(fortran77Parser.AssignmentStatementContext ctx) {
        if (ctx.expression() != null) {
            cod.c().off().i("enterAssignmentStatement: " + ctx.getText() + " | " + ctx.expression().getText());
            LLVMValueRef llvmValueRef = null;
            String strVal = ctx.expression().getText();
            if (Variable.isString(strVal)) {
                String val = Variable.getStringValue(strVal);
                llvmValueRef = LLVMConstString(val, val.length(), 1);
                cod.c().off().i("str: " + llvmValueRef.address());
            } else if (Variable.isInteger(strVal)) {
                llvmValueRef = LLVMConstInt(LLVMInt32Type(), Variable.getIntegerValue(strVal), 0);
                cod.c().off().i("int: " + llvmValueRef.address());
            } else if (Variable.isInMap(strVal, valueRefs)) {
                llvmValueRef = LLVMBuildLoad(builder, Variable.getFromMap(strVal, valueRefs), "");
                cod.c().off().i("var: " + llvmValueRef.address());
            }
            //Something else pushed/will push it to the stack?

            if (llvmValueRef != null) {
                cod.c().off().i("\t[" + stack.size() + "]PUSH ASSIGN: " + llvmValueRef.address());
                stack.push(llvmValueRef);
            }
        }
    }

    @Override
    public void exitAssignmentStatement(fortran77Parser.AssignmentStatementContext ctx) {
        if (ctx.children == null) return;
        cod.c().off().i("exitAssignmentStatement: " + ctx.getText() + " | REF: " + ctx.varRef().getText());
        String name = ctx.varRef().getText();
        Optional.ofNullable(valueRefs.get(name)).ifPresent(var -> {
            LLVMValueRef value = stack.pop();
            LLVMBuildStore(builder, value, var);
            cod.c().off().i("\tX: " + value.address());
            cod.c().off().i("\t[" + stack.size() + "]POP ASSIGN: " + value.address());
        });


    }

    /////////**EXIT** ASSIGNMENT BLOCK

    /////////**START** DISPLAY BLOCK

    @Override
    public void exitPrintStatement(fortran77Parser.PrintStatementContext ctx) {
        final String printfStr = "printf";
        LLVMValueRef printf = valueRefs.get(printfStr);
        if (printf == null) {
            printf = LLVMFunctions.declareExternalPrintf(mod);
            valueRefs.put(printfStr, printf);
        }

        List<LLVMValueRef> printfArgs = new ArrayList<>();
        StringJoiner formatJoiner = new StringJoiner("          ");

        for (fortran77Parser.IoListContext l : ctx.ioList()) {
            switch (l.getStop().getType()) {
                case fortran77Lexer.ICON: //number (?integer)
                    break;
                case fortran77Lexer.SCON: //string
                    formatJoiner.add("%s");
                    String cutedString = l.getText().substring(1, l.getText().length() - 1);
                    printfArgs.add(LLVMBuildGlobalString(builder, cutedString, ""));
                    break;
                case fortran77Lexer.NAME: //variables (? and others i think xd)
                    LLVMValueRef val = valueRefs.get(l.getText());
                    LLVMTypeRef valType = LLVMGetAllocatedType(val);

                    if (valType.equals(LLVMInt32Type())) {
                        LLVMValueRef loadedVal = LLVMBuildLoad(builder, val, "");
                        printfArgs.add(loadedVal);
                        formatJoiner.add("%d");
                    } else {
                        printfArgs.add(val);
                        formatJoiner.add("%s");
                    }

                    break;
                case fortran77Lexer.RPAREN: //math
                    //TODO odbieranie skądś wyliczonej wartości
                    break;
            }
            //TODO obsługa real
        }

        LLVMValueRef format = LLVMBuildGlobalString(builder, formatJoiner.toString(), "");
        printfArgs.add(0, format);
        LLVMValueRef[] printfArgsArr = printfArgs.toArray(new LLVMValueRef[printfArgs.size()]);
        LLVMBuildCall(builder, printf, new PointerPointer<>(printfArgsArr), printfArgsArr.length, "");
    }



    /*
     * ARITHMETIC
     */

    @Override
    public void enterAexpr0(fortran77Parser.Aexpr0Context ctx) {
        if (ctx.aexpr1().size() > 1) {
            arithmeticComponentsStack.push(ctx.aexpr1().stream()
                    .map(RuleContext::getText)
                    .collect(Collectors.toList())
            );
        }
    }


    @Override
    public void exitAexpr0(fortran77Parser.Aexpr0Context ctx) {
        if (ctx.aexpr1() != null && ctx.aexpr1().size() > 1) {
            List<String> componentsStrings = arithmeticComponentsStack.pop();

            List<LLVMValueRef> components = getArithmeticComponents(componentsStrings, arithmeticMapResults);

            List<String> operators = ctx.children.stream()
                    .map(ParseTree::getText)
                    .filter(c -> c.equals("+") || c.equals("-"))
                    .collect(Collectors.toList());

            LLVMValueRef val = Arithmetic.resolveAddAndSub(components, operators, builder);
            cod.c().off().i("\t[" + stack.size() + "]PUSH ADD/SUB:  " + val.address());
//            LLVMBuildLoad(builder, val, "");

            stack.push(val);
            arithmeticMapResults.put(ctx.getText(), val);

        }
    }

    @Override
    public void enterAexpr1(fortran77Parser.Aexpr1Context ctx) {
        if (ctx.aexpr2().size() > 1) {
            arithmeticComponentsStack.push(ctx.aexpr2().stream()
                    .map(RuleContext::getText)
                    .collect(Collectors.toList())
            );
        }
    }


    @Override
    public void exitAexpr1(fortran77Parser.Aexpr1Context ctx) {
        if (ctx.aexpr2() != null && ctx.aexpr2().size() > 1) {
            List<String> componentsStrings = arithmeticComponentsStack.pop();

            List<LLVMValueRef> components = getArithmeticComponents(componentsStrings, arithmeticMapResults);

            List<String> operators = ctx.children.stream()
                    .map(ParseTree::getText)
                    .filter(c -> c.equals("*") || c.equals("/"))
                    .collect(Collectors.toList());

            LLVMValueRef val = Arithmetic.resolveMulAndDiv(components, operators, builder);
            cod.c().off().i("\t[" + stack.size() + "]PUSH MUL/DIV: " + val.address());

            stack.push(val);
            arithmeticMapResults.put(ctx.getText(), val);

        }
    }

    @Override
    public void enterAexpr3(fortran77Parser.Aexpr3Context ctx) {
        if (ctx.aexpr4().size() > 1) {
            arithmeticComponentsStack.push(ctx.aexpr4().stream()
                    .map(RuleContext::getText)
                    .collect(Collectors.toList())
            );
        }
    }


    @Override
    public void exitAexpr3(fortran77Parser.Aexpr3Context ctx) {
        if (ctx.aexpr4() != null && ctx.aexpr4().size() > 1) {
            List<String> componentsStrings = arithmeticComponentsStack.pop();

            List<LLVMValueRef> components = getArithmeticComponents(componentsStrings, arithmeticMapResults);

            List<String> operators = ctx.children.stream()
                    .map(ParseTree::getText)
                    .filter(c -> c.equals("**"))
                    .collect(Collectors.toList());

            LLVMValueRef val = Arithmetic.resolvePow(components, operators, builder);
            cod.c().off().i("\t[" + stack.size() + "]PUSH  POWER: " + val.address());

            stack.push(val);
            arithmeticMapResults.put(ctx.getText(), val);

        }
    }


    private List<LLVMValueRef> getArithmeticComponents(List<String> componentsStrings, Map<String, LLVMValueRef> resultsMap) {
        List<LLVMValueRef> components = new ArrayList<>();
        for (String c : componentsStrings) {
            String strVal = Arithmetic.removeBrackets(c);

            LLVMValueRef llvmValueRef = null;
            if (Variable.isInteger(strVal)) {
                llvmValueRef = LLVMConstInt(LLVMInt32Type(), Variable.getIntegerValue(strVal), 0);
            } else if (Variable.isInMap(strVal, valueRefs)) {
                llvmValueRef = LLVMBuildLoad(builder, Variable.getFromMap(strVal, valueRefs), "");
            } else if (Variable.isInMap(strVal, resultsMap)) {
                llvmValueRef = Variable.getFromMap(strVal, resultsMap);
//                    resultsMap.remove(strVal);//TODO remove from map {String, Id}
            } else {
                throw new RuntimeException("no values in map");
            }
            components.add(llvmValueRef);
        }
        return components;
    }

    /*
     * END OF ARITHMETIC
     */


    ////////SUBPROGRAM_BODY

    @Override
    public void enterSubprogramBody(fortran77Parser.SubprogramBodyContext ctx) {
        LLVMBasicBlockRef entry = LLVMAppendBasicBlock(valueRefs.get(currentFunction), "entry_" + currentFunction);
        builder = LLVMCreateBuilder();
        LLVMPositionBuilderAtEnd(builder, entry);
    }

    @Override
    public void exitSubprogramBody(fortran77Parser.SubprogramBodyContext ctx) {
        LLVMBuildRetVoid(builder);
        LLVMDisposeBuilder(builder);
        super.exitSubprogramBody(ctx);
    }
}
