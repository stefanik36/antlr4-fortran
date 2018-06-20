package com.agh.a2f.fortran.app.translators;

import com.agh.a2f.fortran.generated.fortran77Parser;
import com.stefanik.cod.controller.COD;
import com.stefanik.cod.controller.CODFactory;
import org.antlr.v4.runtime.BufferedTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

import static org.bytedeco.javacpp.LLVM.*;

public abstract class MemoryAllocationTranslator extends AssignmentAndArithmeticTranslator {
    private static final COD cod = CODFactory.get();

    public MemoryAllocationTranslator(BufferedTokenStream tokens) {
        super(tokens);
    }

    /////////**START** MEMORY ALLOCATING BLOCK

    //TODO alokacja pamięci dla real // XDDDD


    @Override
    public void enterTypeStatement(fortran77Parser.TypeStatementContext ctx) {
        megaStack.startSection();
    }

    @Override
    public void exitTypeStatement(fortran77Parser.TypeStatementContext ctx) {
        megaStack.endSection();
    }

    @Override
    public void enterIntConstantExpr(fortran77Parser.IntConstantExprContext ctx) {
        if (megaStack.wantData()) {
            megaStack.push(ctx.getText());
            ctx.children = null;
            //pozbycie się wchodzenia głębiej
        }
    }


    private LLVMValueRef assignFunctionArguments(String sName, LLVMValueRef var) {
        Map<String, Integer> copy = new HashMap<>(functionArguments);
        LLVMValueRef llvmValueRef = var;

        for(Map.Entry<String, Integer> e :copy.entrySet()){
            if (e.getKey().equals(sName)) {
                functionArguments.remove(e.getKey());


                LLVMValueRef param = LLVMGetParam(valueRefs.get(executableUnitName), e.getValue());
                LLVMBuildStore(builder, param, var);
            }
        }
        return llvmValueRef;
    }

    @Override
    public void enterTypeStatementNameList(fortran77Parser.TypeStatementNameListContext ctx) {
        cod.c().off().i("enterTypeStatementNameList", ctx.children.stream().map(ParseTree::getText).collect(Collectors.toList()));
        for (fortran77Parser.TypeStatementNameContext name : ctx.typeStatementName()) {
            String sName = preventFuncName(name.getText());

            LLVMValueRef var = LLVMBuildAlloca(builder, LLVMInt32Type(), sName);
            var = assignFunctionArguments(sName, var);
            valueRefs.put(sName, var);

        }
    }

    @Override
    public void exitTypeStatementNameCharList(fortran77Parser.TypeStatementNameCharListContext ctx) {
        Integer length = Integer.valueOf(megaStack.popString());

        for (fortran77Parser.TypeStatementNameCharContext name : ctx.typeStatementNameChar()) {
            LLVMValueRef var = LLVMBuildAlloca(builder, LLVMArrayType(LLVMInt8Type(), length), name.getText());
            valueRefs.put(name.getText(), var);
        }
    }

    /////////**END** MEMORY ALLOCATING BLOCK

}