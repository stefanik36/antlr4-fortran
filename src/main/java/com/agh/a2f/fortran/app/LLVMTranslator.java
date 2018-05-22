package com.agh.a2f.fortran.app;

import com.agh.a2f.fortran.generated.fortran77BaseListener;
import com.agh.a2f.fortran.generated.fortran77Parser;
import org.antlr.v4.runtime.BufferedTokenStream;
import org.bytedeco.javacpp.BytePointer;
import org.bytedeco.javacpp.PointerPointer;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.Stack;

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

    private Map<String, LLVMValueRef> functions = new HashMap<>();

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
        functions.put("main", mainFunc);
        currentFunction = "main";
        LLVMSetFunctionCallConv(mainFunc, LLVMCCallConv);
    }

    @Override
    public void enterTypeStatementNameList(fortran77Parser.TypeStatementNameListContext ctx) {
//        System.out.println("\t-(2)enterTypeStatementNameList");
        for (fortran77Parser.TypeStatementNameContext name : ctx.typeStatementName()) {
            LLVMValueRef var = LLVMBuildAlloca(builder, LLVMInt32Type(), name.getText());
            functions.put(name.getText(), var);
        }
    }


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
    public void exitTypeStatementNameCharList(fortran77Parser.TypeStatementNameCharListContext ctx) {
//        System.out.println("\t-(6)exitTypeStatementNameCharList");
        Integer length = Integer.valueOf(stringStack.pop());

        for (fortran77Parser.TypeStatementNameCharContext name : ctx.typeStatementNameChar()) {
            LLVMValueRef var = LLVMBuildAlloca(builder, LLVMArrayType(LLVMInt8Type(), length), name.getText());
            functions.put(name.getText(), var);
        }
    }

    @Override
    public void exitAssignmentStatement(fortran77Parser.AssignmentStatementContext ctx) {
//        System.out.println("\t-(7)exitAssignmentStatement");
        if (ctx.children == null) return;
        String name = ctx.varRef().getText();
        Optional.ofNullable(functions.get(name)).ifPresent(var -> {
            LLVMValueRef value = stack.pop();
            LLVMBuildStore(builder, value, var);
        });


    }

    @Override
    public void enterPrintStatement(fortran77Parser.PrintStatementContext ctx) {
//        System.out.println("\t-(8)enterPrintStatement");
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

        LLVMValueRef it = functions.get("it");
        LLVMValueRef loadedItVal = LLVMBuildLoad(builder, it, "");

        LLVMValueRef kkk = functions.get("kkk");
//        LLVMValueRef loadedKkkVal = LLVMBuildLoad(builder,kkk,"");

        LLVMValueRef printfArgs[] = {LLVMBuildGlobalStringPtr(builder, txt, "no sam nie wiem"), kkk, loadedItVal};
        LLVMBuildCall(builder, printf, new PointerPointer<>(printfArgs), 3, "");

    }


    @Override
    public void exitProgram(fortran77Parser.ProgramContext ctx) {
//        System.out.println("\t-(9)exitProgram");
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
