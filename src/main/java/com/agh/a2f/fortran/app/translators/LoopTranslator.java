package com.agh.a2f.fortran.app.translators;

import com.agh.a2f.fortran.generated.fortran77Parser;
import org.antlr.v4.runtime.BufferedTokenStream;
import org.bytedeco.javacpp.LLVM;
import org.bytedeco.javacpp.PointerPointer;

import static org.bytedeco.javacpp.LLVM.*;

abstract class LoopTranslator extends PrintTranslator {
    LoopTranslator(BufferedTokenStream tokens) {
        super(tokens);
    }


    @Override
    public void enterDoStatement(fortran77Parser.DoStatementContext ctx) {
        megaStack.startSection();
    }

    @Override
    public void exitDoStatement(fortran77Parser.DoStatementContext ctx) {
        megaStack.endSection();
    }

    @Override
    public void exitDoVarArgs(fortran77Parser.DoVarArgsContext ctx) {
        //TODO obsługa ujemnych parametrow i double?
        String loopItrName = ctx.variableName().getText();
        LLVM.LLVMValueRef orgLoopItrRef = valueRefs.get(loopItrName);
        if (orgLoopItrRef == null) throw new RuntimeException("Variable do not initialize");
        megaStack.push(orgLoopItrRef);
    }// stack: $->orgLoopItrRef->loopItrName


    @Override
    public void enterDoBody(fortran77Parser.DoBodyContext ctx) {
        // stack: $->orgLoopItrRef->loopItrName
        LLVM.LLVMValueRef function = valueRefs.get(currentFunction);

        LLVMValueRef itrVal = megaStack.popValue();
        LLVMValueRef inc = megaStack.getSize() > 2 ? megaStack.popValue() : LLVMConstInt(LLVMInt32Type(), 1, 1);
        LLVMValueRef limit = megaStack.popValue();
        LLVMValueRef initVal = megaStack.popValue();

        LLVMBuildStore(builder, initVal, itrVal);

        LLVM.LLVMBasicBlockRef forLoop = LLVMAppendBasicBlock(function, "loop");
        LLVMBuildBr(builder, forLoop);

        LLVMPositionBuilderAtEnd(builder, forLoop);



        LLVMValueRef loadedItr = LLVMBuildLoad(builder, itrVal,"");
        LLVMValueRef incItr = LLVMBuildAdd(builder, loadedItr, inc, "");

        LLVMBuildStore(builder,incItr, itrVal);
        LLVMValueRef iF = LLVMBuildICmp(builder, LLVMIntSLT, incItr, limit, "");

        LLVMBasicBlockRef bodyForBlock = LLVMAppendBasicBlock(valueRefs.get(currentFunction), "body_loop");
        LLVMBasicBlockRef endForBlock = LLVMAppendBasicBlock(valueRefs.get(currentFunction), "end_loop");
        LLVMBuildCondBr(builder, iF, bodyForBlock, endForBlock);
        LLVMPositionBuilderAtEnd(builder, bodyForBlock);

        megaStack.push(endForBlock);
        megaStack.push(forLoop);
    }// stack: $->orgLoopItrRef->loopItrName->phi->startLoopBlock->loopBlock

    @Override
    public void exitDoBody(fortran77Parser.DoBodyContext ctx) {
        // stack: $->orgLoopItrRef->loopItrName->phi->startLoopBlock->loopBlock


        LLVMBasicBlockRef forLoop = megaStack.popBlock();
        LLVMBuildBr(builder, forLoop);

        LLVMBasicBlockRef endForBlock = megaStack.popBlock();
        LLVMPositionBuilderAtEnd(builder, endForBlock);

    } // stack: $
}
