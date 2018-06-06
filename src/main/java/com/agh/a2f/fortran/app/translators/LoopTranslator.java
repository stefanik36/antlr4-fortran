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
        megaStack.push(loopItrName);
    }// stack: $->orgLoopItrRef->loopItrName


    @Override
    public void enterDoBody(fortran77Parser.DoBodyContext ctx) {
        // stack: $->orgLoopItrRef->loopItrName
        LLVM.LLVMValueRef function = valueRefs.get(currentFunction);
        LLVMBasicBlockRef startLoop = LLVMGetInsertBlock(builder);
        LLVMPositionBuilderAtEnd(builder, startLoop);
        LLVM.LLVMBasicBlockRef forLoop = LLVMAppendBasicBlock(function, "loop");
        LLVMBuildBr(builder, forLoop);
        LLVMPositionBuilderAtEnd(builder, forLoop);
        LLVM.LLVMValueRef phi = LLVMBuildPhi(builder, LLVMInt32Type(), "");
        String varName = (String) megaStack.peek();
        valueRefs.put(varName, phi);
        megaStack.push(phi);
        megaStack.push(startLoop);
        megaStack.push(forLoop);

    }// stack: $->orgLoopItrRef->loopItrName->phi->startLoopBlock->loopBlock

    @Override
    public void exitDoBody(fortran77Parser.DoBodyContext ctx) {
        // stack: $->orgLoopItrRef->loopItrName->phi->startLoopBlock->loopBlock

            LLVMBasicBlockRef loopBlock = megaStack.popBlock();
            LLVMBasicBlockRef previousBlock = megaStack.popBlock();

            LLVMValueRef phi = megaStack.popValue();
            String varName = megaStack.popString();
            LLVMValueRef originalItrRef = megaStack.popValue();

            LLVMValueRef inc = megaStack.getSize() > 2 ? megaStack.popValue() : LLVMConstInt(LLVMInt32Type(), 1, 1);
            LLVMValueRef limit = megaStack.popValue();
            LLVMValueRef start = megaStack.popValue();

            LLVMValueRef incItr = LLVMBuildAdd(builder, phi, inc, "");
            LLVMValueRef[] phiValues = {start, incItr};
            LLVMBasicBlockRef[] phiBlocks = {previousBlock, loopBlock};
            LLVMAddIncoming(phi, new PointerPointer<>(phiValues), new PointerPointer<>(phiBlocks), 2);
            LLVMValueRef iF = LLVMBuildICmp(builder, LLVMIntSLT, incItr, limit, "");
            LLVMBasicBlockRef endForBlock = LLVMAppendBasicBlock(valueRefs.get(currentFunction), "end_loop");
            LLVMBuildCondBr(builder, iF, loopBlock, endForBlock);
            LLVMPositionBuilderAtEnd(builder, endForBlock);
            LLVMBuildStore(builder, phi, originalItrRef);

            valueRefs.put(varName, originalItrRef);
    } // stack: $
}
