package com.agh.a2f.fortran.app.translators;

import com.agh.a2f.fortran.app.util.MegaStack;
import com.agh.a2f.fortran.generated.fortran77BaseListener;
import com.agh.a2f.fortran.generated.fortran77Parser;
import com.stefanik.cod.controller.COD;
import com.stefanik.cod.controller.CODFactory;
import org.antlr.v4.runtime.BufferedTokenStream;
import org.apache.commons.lang3.ArrayUtils;
import org.bytedeco.javacpp.PointerPointer;

import static org.bytedeco.javacpp.LLVM.*;

import java.util.*;

abstract class LLVMBaseTranslator extends fortran77BaseListener {
    private static final COD cod = CODFactory.get();
    private BufferedTokenStream tokens;

    LLVMBaseTranslator(BufferedTokenStream tokens) {
        this.tokens = tokens;
    }

    LLVMModuleRef mod = null;
    LLVMBuilderRef builder = null;
    String executableUnitName = null;

    MegaStack megaStack = new MegaStack();
    Map<String, LLVMValueRef> valueRefs = new HashMap<>();

    FunctionType functionType = null;
    List<String> args = null;


    enum FunctionType {
        MAIN, FUNCTION, SUBROUTINE
    }


    @Override
    public void enterProgram(fortran77Parser.ProgramContext ctx) {
        mod = LLVMModuleCreateWithName("TEST");
    }

    @Override
    public void enterProgramStatement(fortran77Parser.ProgramStatementContext ctx) {
//        executableUnitName
        cod.c().off().i(ctx.identifier().getText());
//        String name = ctx.NAME().getSymbol().getText();
        LLVMValueRef mainFunc = LLVMAddFunction(
                mod,
                "main",
                LLVMFunctionType(LLVMInt32Type(), LLVMVoidType(), 0, 0)
        );

        valueRefs.put("main", mainFunc);
        executableUnitName = "main";
        functionType = FunctionType.MAIN;
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
        String sName = preventFuncName(ctx.identifier().getText());
        LLVMValueRef valRef = valueRefs.get(sName);
        if (isFunctionCall(ctx)) {
            megaStack.startSection();
        }
        if (valRef != null && megaStack.wantData()) {
            megaStack.push(valRef);
        }
    }


    private boolean isFunctionCall(fortran77Parser.VarRefContext ctx) {
        return ctx.subscripts() != null;
    }

    protected String preventFuncName(String name) {
        if (name.equals(executableUnitName)) {
            return name + "Var";
        }
        return name;
    }

    @Override
    public void exitVarRef(fortran77Parser.VarRefContext ctx) {
        if (isFunctionCall(ctx)) {

            LLVMValueRef[] args = handleLoad(true);
            LLVMValueRef fun = megaStack.popValue();

            LLVMValueRef result = LLVMBuildCall(builder, fun, new PointerPointer<>(args), args.length, "");
            megaStack.endSection();
            megaStack.push(result);
        }
    }

    protected LLVMValueRef[] handleLoad(boolean isFunction){
        Stack<LLVMValueRef> args = new Stack<>();
        while (megaStack.size() > (isFunction? 1 : 0)) {
            LLVMValueRef val = megaStack.popValue();
            LLVMTypeRef type = LLVMGetAllocatedType(val);
            if(type != null && type.equals(LLVMInt32Type())){
                args.push(LLVMBuildLoad(builder, val, ""));
            }
            else{
                args.push(val);
            }
        }
        LLVMValueRef argsL[] = new LLVMValueRef[args.size()];
        args.toArray(argsL);
        ArrayUtils.reverse(argsL);
        return argsL;
    }


    @Override
    public void enterSubprogramBody(fortran77Parser.SubprogramBodyContext ctx) {

        LLVMBasicBlockRef entry = LLVMAppendBasicBlock(valueRefs.get(executableUnitName), "entry_" + executableUnitName);
        builder = LLVMCreateBuilder();
        LLVMPositionBuilderAtEnd(builder, entry);

    }



    @Override
    public void exitSubprogramBody(fortran77Parser.SubprogramBodyContext ctx) {
        switch (functionType) {
            case MAIN:
                LLVMBuildRet(builder, LLVMConstInt(LLVMInt32Type(), 0, 1));
                break;
            case FUNCTION:
                String sName = preventFuncName(executableUnitName);
                LLVMValueRef vLoad = LLVMBuildLoad(builder, valueRefs.get(sName), "");
                LLVMBuildRet(builder, vLoad);
                break;
            case SUBROUTINE:
                LLVMBuildRetVoid(builder);
                break;
        }
        LLVMDisposeBuilder(builder);
        super.exitSubprogramBody(ctx);
    }
}
