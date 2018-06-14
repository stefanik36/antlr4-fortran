package com.agh.a2f.fortran.app.translators;

import com.agh.a2f.fortran.app.util.LLVMFunctions;
import com.agh.a2f.fortran.app.util.MegaStack;
import com.agh.a2f.fortran.generated.fortran77BaseListener;
import com.agh.a2f.fortran.generated.fortran77Parser;
import org.antlr.v4.runtime.BufferedTokenStream;
import static org.bytedeco.javacpp.LLVM.*;

import java.nio.ByteBuffer;
import java.util.HashMap;
import java.util.Map;

abstract class LLVMBaseTranslator extends fortran77BaseListener {
    private BufferedTokenStream tokens;

    LLVMBaseTranslator(BufferedTokenStream tokens) {
        this.tokens = tokens;
    }

    LLVMModuleRef mod = null;
    LLVMBuilderRef builder = null;
    String currentFunction = null;


    MegaStack megaStack = new MegaStack();
    Map<String, LLVMValueRef> valueRefs = new HashMap<>();


    @Override
    public void enterProgramStatement(fortran77Parser.ProgramStatementContext ctx) {
        String name = ctx.identifier().getText();
        mod = LLVMModuleCreateWithName(name);
        LLVMValueRef mainFunc = LLVMAddFunction(mod,
                "main", LLVMFunctionType(LLVMVoidType(), LLVMVoidType(), 0, 0));
        valueRefs.put("main", mainFunc);
        currentFunction = "main";
        LLVMSetFunctionCallConv(mainFunc, LLVMCCallConv);
    }



    @Override
    public void enterAintegerexpr(fortran77Parser.AintegerexprContext ctx) {
        long val = Long.valueOf(ctx.getText());
        LLVMValueRef valRef = LLVMConstInt(LLVMInt32Type(), val, 1);
        if (megaStack.wantData()) {
            megaStack.push(valRef);
        }
    }

    @Override
    public void enterVarRef(fortran77Parser.VarRefContext ctx) {
        String name = ctx.getText();
        LLVMValueRef valRef = valueRefs.get(name);
        if (valRef != null && megaStack.wantData()) {
            megaStack.push(valRef);
        }
    }


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
