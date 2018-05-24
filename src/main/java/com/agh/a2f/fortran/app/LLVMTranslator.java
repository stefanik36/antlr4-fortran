package com.agh.a2f.fortran.app;

import com.agh.a2f.fortran.app.util.Arithmetic;
import com.agh.a2f.fortran.app.util.Variable;
import com.agh.a2f.fortran.generated.fortran77BaseListener;
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
import static org.bytedeco.javacpp.LLVM.LLVMModuleCreateWithName;

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

    private Map<String, LLVMValueRef> functions = new HashMap<>();

    private String currentFunction = null;

    //    private static Integer arithmeticStackIterator = 0;//TODO
    private Stack<List<String>> arithmeticComponentsStack = new Stack<>();
    private Map<String, LLVMValueRef> arithmeticMapResults = new HashMap<>();


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
        if (ctx.aexpr1().size() > 1) {
            List<String> componentsStrings = arithmeticComponentsStack.pop();

            List<LLVMValueRef> components = new ArrayList<>();
            for (String c : componentsStrings) {
                String component = removeBrackets(c);
                Optional<LLVMValueRef> optionalValue = Arithmetic.findValue(component, functions);
                if (optionalValue.isPresent()) {
                    components.add(optionalValue.get());
                } else {
                    LLVMValueRef nullableComponent = arithmeticMapResults.get(component);
                    if (nullableComponent != null) {

                        cod.i("\t[" + stack.size() + "]POP: " + stack.pop().hashCode());
                        components.add(arithmeticMapResults.get(component));

//                        arithmeticMapResults.remove(withoutBrackets);//TODO remove
                    } else {
                        throw new RuntimeException("no values in map");
                    }
                }
            }

            List<String> operators = ctx.children.stream()
                    .map(ParseTree::getText)
                    .filter(c -> c.equals("+") || c.equals("-"))
                    .collect(Collectors.toList());

            LLVMValueRef val = Arithmetic.resolveAddAndSub(components, operators, builder);
            cod.i("\t[" + stack.size() + "]PUSH: " + val.hashCode());
            stack.push(val);
            arithmeticMapResults.put(ctx.getText(), val);

        }
    }

    private String removeBrackets(String c) {
        String component = c;
        if (c.matches("\\(.*\\)")) {
            component = c.substring(1, c.length() - 1);
        }
        return component;
    }


    @Override
    public void enterProgramStatement(fortran77Parser.ProgramStatementContext ctx) {
        String name = ctx.NAME().getSymbol().getText();
        mod = LLVMModuleCreateWithName(name);
        LLVMValueRef mainFunc = LLVMAddFunction(mod,
                "main", LLVMFunctionType(LLVMVoidType(), LLVMVoidType(), 0, 0));
        functions.put("main", mainFunc);
        currentFunction = "main";
        LLVMSetFunctionCallConv(mainFunc, LLVMCCallConv);
    }

    @Override
    public void enterTypeStatementNameList(fortran77Parser.TypeStatementNameListContext ctx) {
        for (fortran77Parser.TypeStatementNameContext name : ctx.typeStatementName()) {
            LLVMValueRef var = LLVMBuildAlloca(builder, LLVMInt32Type(), name.getText());
            functions.put(name.getText(), var);
        }
    }

    @Override
    public void enterIntConstantExpr(fortran77Parser.IntConstantExprContext ctx) {
        stringStack.push(ctx.getText());
    }


//    @Override
//    public void enterExpression(fortran77Parser.ExpressionContext ctx) {
//        cod.i(ctx.getText());
//        String strVal = ctx.getText();
//        LLVMValueRef llvmValueRef = null;
//        try {
//            Integer val = Integer.valueOf(strVal);
//            llvmValueRef = LLVMConstInt(LLVMInt32Type(), val, 0);
//        } catch (Exception ex) {
//            llvmValueRef = LLVMConstString(strVal.substring(1, strVal.length() - 1), strVal.length() - 2, 1);
//        } finally {
//            cod.i("[" + stack.size() + "]PUSH ASSIGN: " + llvmValueRef.hashCode());
//            stack.push(llvmValueRef);
//        }
//    }


    @Override
    public void exitTypeStatementNameCharList(fortran77Parser.TypeStatementNameCharListContext ctx) {
        Integer length = Integer.valueOf(stringStack.pop());

        cod.i("exitTypeStatementNameCharList: " + ctx.getText());

        for (fortran77Parser.TypeStatementNameCharContext name : ctx.typeStatementNameChar()) {
            LLVMValueRef var = LLVMBuildAlloca(builder, LLVMArrayType(LLVMInt8Type(), length), name.getText());
            functions.put(name.getText(), var);
        }
    }

    @Override
    public void enterAssignmentStatement(fortran77Parser.AssignmentStatementContext ctx) {
        cod.i("enterAssignmentStatement: " + ctx.getText() + " | " + ctx.expression().getText());

        LLVMValueRef llvmValueRef = null;
        String strVal = ctx.expression().getText();
        if (Variable.isString(strVal)) {
            String val = Variable.getStringValue(strVal);
            llvmValueRef = LLVMConstString(val, val.length(), 1);
            cod.i("str: " + llvmValueRef.address());
        } else if (Variable.isInteger(strVal)) {
            llvmValueRef = LLVMConstInt(LLVMInt32Type(), Variable.getIntegerValue(strVal), 0);
            cod.i("int: " + llvmValueRef.address());
            //TODO other types
        } else if (Variable.isVariable(strVal, functions)) {
            llvmValueRef = Variable.getVariable(strVal, functions);
            cod.i("var: " + llvmValueRef.address());
        }
        //Something else pushed/will push it to the stack?

        if (llvmValueRef != null) {
            cod.i("\t[" + stack.size() + "]PUSH ASSIGN: " + llvmValueRef.hashCode());
            stack.push(llvmValueRef);
        }


    }

    @Override
    public void exitAssignmentStatement(fortran77Parser.AssignmentStatementContext ctx) {
        if (ctx.children == null) return;
        cod.i("exitAssignmentStatement: " + ctx.getText() + " | REF: " + ctx.varRef().getText());
        String name = ctx.varRef().getText();
        Optional.ofNullable(functions.get(name)).ifPresent(var -> {
            LLVMValueRef value = stack.pop();
            LLVMBuildStore(builder, value, var);
            cod.i("\tX: " + value.address());
            cod.i("\t[" + stack.size() + "]POP ASSIGN: " + value.hashCode());
        });


    }

    @Override
    public void enterPrintStatement(fortran77Parser.PrintStatementContext ctx) {
        final String printfStr = "printf";
        LLVMValueRef printf = functions.get(printfStr);
        if (printf == null) {
            printf = LLVMFunctions.declareExternalPrintf(mod);
            functions.put(printfStr, printf);
        }
        //get first elem and print it

        String txt = ctx.ioList(0).getText().substring(1, ctx.ioList(0).getText().length() - 1) + " %s || %d \n";
        for (fortran77Parser.IoListContext l : ctx.ioList()) {
            l.getText();
        }

        LLVMValueRef it = functions.get("s3");
        cod.i("IT: " + it.address());
        cod.i(functions.entrySet().stream().map(Map.Entry::getKey).collect(Collectors.toList()));
        LLVMValueRef loadedItVal = LLVMBuildLoad(builder, it, "");

        LLVMValueRef kkk = functions.get("kkk");
//        LLVMValueRef loadedKkkVal = LLVMBuildLoad(builder,kkk,"");

        LLVMValueRef printfArgs[] = {LLVMBuildGlobalStringPtr(builder, txt, "no sam nie wiem"), kkk, loadedItVal};
        LLVMBuildCall(builder, printf, new PointerPointer<>(printfArgs), 3, "");

    }


    @Override
    public void exitProgram(fortran77Parser.ProgramContext ctx) {
        LLVMDumpModule(mod);
        LLVMWriteBitcodeToFile(mod, "f2llvm.bc"); //save to bytecode

        LLVMFunctions.executeCode(mod, functions.get("main"));

//        LLVMDisposeModule(mod);
    }


    ////////SUBPROGRAM_BODY

    @Override
    public void enterSubprogramBody(fortran77Parser.SubprogramBodyContext ctx) {
        LLVMBasicBlockRef entry = LLVMAppendBasicBlock(functions.get(currentFunction), "entry_" + currentFunction);
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
