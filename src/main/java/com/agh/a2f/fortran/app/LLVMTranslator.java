package com.agh.a2f.fortran.app;

import com.agh.a2f.fortran.generated.fortran77BaseListener;
import com.agh.a2f.fortran.generated.fortran77Lexer;
import com.agh.a2f.fortran.generated.fortran77Parser;
import org.antlr.v4.runtime.BufferedTokenStream;
import org.bytedeco.javacpp.PointerPointer;

import java.util.*;

import static org.bytedeco.javacpp.LLVM.*;
import static org.bytedeco.javacpp.LLVM.LLVMModuleCreateWithName;

public class LLVMTranslator extends fortran77BaseListener {
//    private static final COD cod = CODFactory.get();

    private BufferedTokenStream tokens;

    public LLVMTranslator(BufferedTokenStream tokens) {
        this.tokens = tokens;
    }

    private LLVMModuleRef mod = null;
    private LLVMBuilderRef builder = null;

    private Stack<LLVMValueRef> stack = new Stack<>();
    private Stack<String> stringStack = new Stack<>();
    private int stringStackCurrentBlock = 0;
    private int stackCurrentBlock = 0;

    private Stack<Integer> blockStack = new Stack<>();

    private Map<String, LLVMValueRef> valueRefs = new HashMap<>();

    private String currentFunction = null;


    @Override
    public void enterMainProgram(fortran77Parser.MainProgramContext ctx) {
    }


    @Override
    public void enterProgramStatement(fortran77Parser.ProgramStatementContext ctx) {
//        System.out.println("\t-(1)enterProgramStatement");
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

    @Override
    public void enterTypeStatementNameList(fortran77Parser.TypeStatementNameListContext ctx) {
//        System.out.println("\t-(2)enterTypeStatementNameList");
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
//        System.out.println("\t-(4)enterIntConstantExpr");
        stringStack.push(ctx.getText());
    }

    @Override
    public void enterExpression(fortran77Parser.ExpressionContext ctx) {
//        System.out.println("\t-(5)enterExpression");
        String strVal = ctx.getText();
        try {
            Integer val = Integer.valueOf(strVal);
            stack.push(LLVMConstInt(LLVMInt32Type(), val, 0));
        } catch (Exception ex) {
            stack.push(LLVMConstString(strVal.substring(1, strVal.length() - 1), strVal.length() - 2, 1));
        }
    }



    @Override
    public void exitAssignmentStatement(fortran77Parser.AssignmentStatementContext ctx) {
//        System.out.println("\t-(7)exitAssignmentStatement");
        if (ctx.children == null) return;
        String name = ctx.varRef().getText();
        Optional.ofNullable(valueRefs.get(name)).ifPresent(var -> {
            LLVMValueRef value = stack.pop();
            LLVMBuildStore(builder, value, var);
        });


    }

    /////////**EXIT** ASSIGNMENT BLOCK

    /////////**START** DISPLAY BLOCK

    @Override
    public void enterAexpr0(fortran77Parser.Aexpr0Context ctx) {
        super.enterAexpr0(ctx);
    }




    private void resetAndRememberStackPositions() {
        blockStack.push(stackCurrentBlock);
        blockStack.push(stringStackCurrentBlock);
        stackCurrentBlock = 0;
        stringStackCurrentBlock = 0;
    }

    private void restorePreviousStackPosition() {
        stringStackCurrentBlock = blockStack.pop();
        stackCurrentBlock = blockStack.pop();
    }

    @Override
    public void enterPrintStatement(fortran77Parser.PrintStatementContext ctx) {
        resetAndRememberStackPositions();

    }

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
                    String cutedString = l.getText().substring(1,l.getText().length()-1);
                    printfArgs.add(LLVMBuildGlobalString(builder, cutedString, ""));
                    break;
                case fortran77Lexer.NAME: //variables
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
                    break;
            }
        }

        LLVMValueRef format = LLVMBuildGlobalString(builder, formatJoiner.toString(), "");
        printfArgs.add(0,format);
        LLVMValueRef[] printfArgsArr = printfArgs.toArray(new LLVMValueRef[printfArgs.size()]);
        LLVMBuildCall(builder, printf, new PointerPointer<>(printfArgsArr), printfArgsArr.length, "");
        restorePreviousStackPosition();
    }







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
