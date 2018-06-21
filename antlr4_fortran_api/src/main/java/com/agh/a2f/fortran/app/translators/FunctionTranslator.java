package com.agh.a2f.fortran.app.translators;

import com.agh.a2f.fortran.app.util.FunctionArgManager;
import com.agh.a2f.fortran.app.util.Variable;
import com.agh.a2f.fortran.generated.fortran77Parser;
import com.stefanik.cod.controller.COD;
import com.stefanik.cod.controller.CODFactory;
import com.stefanik.cod.service.creator.visualization.ObjectsVisualizer;
import org.antlr.v4.runtime.BufferedTokenStream;
import org.antlr.v4.runtime.RuleContext;
import org.antlr.v4.runtime.tree.ParseTree;
import org.bytedeco.javacpp.LLVM;
import org.bytedeco.javacpp.PointerPointer;

import java.util.Arrays;
import java.util.Stack;
import java.util.stream.Collectors;

import static org.bytedeco.javacpp.LLVM.*;
import static org.bytedeco.javacpp.LLVM.LLVMInt32Type;

public abstract class FunctionTranslator extends ReadTranslator {
    private static final COD cod = CODFactory.get();

    FunctionTranslator(BufferedTokenStream tokens) {
        super(tokens);
    }


    @Override
    public void enterFunctionSubprogram(fortran77Parser.FunctionSubprogramContext ctx) {
        megaStack.startSection();
        this.args = ctx.functionStatement().namelist().identifier().stream().map(RuleContext::getText).collect(Collectors.toList());
        String funName = ctx.functionStatement().identifier().getText();

        FunctionArgManager manager = new FunctionArgManager(ctx.subprogramBody(), this.args);

        LLVMTypeRef[] args = manager.getArgsTypeArray();

        LLVMValueRef fun = LLVMAddFunction(mod, funName, LLVMFunctionType(LLVMInt32Type(), new PointerPointer<>(args), args.length, 0));
        LLVMSetFunctionCallConv(fun, LLVMCCallConv);

        executableUnitName = funName;
        functionType = FunctionType.FUNCTION;
        valueRefs.put(funName, fun);
    }

    @Override
    public void exitFunctionSubprogram(fortran77Parser.FunctionSubprogramContext ctx) {
        this.args = null;
        megaStack.endSection();
    }
}
