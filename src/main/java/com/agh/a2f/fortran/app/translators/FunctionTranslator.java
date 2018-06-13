package com.agh.a2f.fortran.app.translators;

import com.agh.a2f.fortran.generated.fortran77Parser;
import com.stefanik.cod.controller.COD;
import com.stefanik.cod.controller.CODFactory;
import org.antlr.v4.runtime.BufferedTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;
import org.bytedeco.javacpp.LLVM;

import java.util.stream.Collectors;

import static org.bytedeco.javacpp.LLVM.*;

public abstract class FunctionTranslator extends LoopTranslator {
    private static final COD cod = CODFactory.get();

    FunctionTranslator(BufferedTokenStream tokens) {
        super(tokens);
    }


    @Override
    public void enterFunctionStatement(fortran77Parser.FunctionStatementContext ctx) {
        executableUnitName = ctx.NAME().getText();







        LLVMValueRef myFunc = LLVMAddFunction(
                mod,
                executableUnitName,
                LLVMFunctionType(LLVMInt32Type(), LLVMInt32Type(), 0,0)
        );
        LLVMBuilderRef myBuilder = LLVMCreateBuilder();
        LLVMBasicBlockRef myEntry = LLVMAppendBasicBlock(myFunc, "myFunc_entry");
        LLVMPositionBuilderAtEnd(myBuilder, myEntry);
        LLVMBuildRetVoid(myBuilder);
        LLVMSetFunctionCallConv(myFunc, LLVMCCallConv);
        LLVMDisposeBuilder(myBuilder);
        builder = myBuilder;
//
//        //TODO type
//        LLVM.LLVMValueRef function = LLVMAddFunction(
//                mod,
//                executableUnitName,
//                LLVMFunctionType(LLVMInt32Type(), LLVMInt32Type(), 0, 0));
//
//        LLVMBasicBlockRef myEntry = LLVMAppendBasicBlock(function, executableUnitName+"_entry");
//        LLVMPositionBuilderAtEnd(builder, myEntry);
//
//        LLVMSetFunctionCallConv(function, 0);
//        LLVMDisposeBuilder(builder);
        valueRefs.put(executableUnitName, myFunc);
    }


    @Override
    public void exitFunctionStatement(fortran77Parser.FunctionStatementContext ctx) {
//        cod.i("exitFunctionStatement: MS: " + megaStack.size());
    }

    @Override
    public void exitFunctionSubprogram(fortran77Parser.FunctionSubprogramContext ctx) {
//        cod.i("exitFunctionSubprogram: MS: " + megaStack.size());
    }
}
