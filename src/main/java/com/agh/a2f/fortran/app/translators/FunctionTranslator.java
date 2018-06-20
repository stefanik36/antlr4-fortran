package com.agh.a2f.fortran.app.translators;

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
    public void enterFunctionStatement(fortran77Parser.FunctionStatementContext ctx) {
        executableUnitName = ctx.identifier().getText();
        LLVMTypeRef[] args = new LLVMTypeRef[0];
        if(ctx.namelist() != null)
            args = new LLVMTypeRef[ctx.namelist().identifier().size()];

        for (int i =0;i<args.length;i++){
            args[i] = LLVMInt32Type();
        }

        LLVMValueRef myFunc = LLVMAddFunction(
                mod,
                executableUnitName,
                LLVMFunctionType(LLVMInt32Type(), new PointerPointer<>(args), args.length, 0)
        );
        LLVMSetFunctionCallConv(myFunc, LLVMCCallConv);
        valueRefs.put(executableUnitName, myFunc);

        int i = 0;
        for (String s : ctx.namelist().identifier().stream()
                .map(RuleContext::getText)
                .collect(Collectors.toList())
                ) {
            functionArguments.put(s, i);
            i++;
        }

        if(ctx.namelist() == null)
            return;
        for (String name : ctx.namelist().identifier().stream().map(ParseTree::getText).collect(Collectors.toList())) {

            LLVMValueRef llvmValueRef = null;
            if (Variable.isString(name)) {
                String val = Variable.getStringValue(name);
                llvmValueRef = LLVMConstString(val, val.length(), 1);
                cod.c().i("str: " + llvmValueRef.address());
            } else if (Variable.isInteger(name)) {
                llvmValueRef = LLVMConstInt(LLVMInt32Type(), Variable.getIntegerValue(name), 0);
                cod.c().i("int: " + llvmValueRef.address());
            } else if (Variable.isInMap(name, valueRefs)) {
                llvmValueRef = LLVMBuildLoad(builder, Variable.getFromMap(name, valueRefs), "");
                cod.c().i("var: " + llvmValueRef.address());
            }
            //Something else pushed/will push it to the megaStack?

            if (llvmValueRef != null) {
                cod.c().i("\t[" + megaStack.size() + "]PUSH ASSIGN: " + llvmValueRef.address());
                megaStack.push(llvmValueRef);
            }
        }
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
