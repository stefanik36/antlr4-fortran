package com.agh.a2f.fortran.app.translators;

import com.agh.a2f.fortran.generated.fortran77Parser;
import com.stefanik.cod.controller.COD;
import com.stefanik.cod.controller.CODFactory;
import org.antlr.v4.runtime.BufferedTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;

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

    @Override
    public void enterTypeStatementNameList(fortran77Parser.TypeStatementNameListContext ctx) {
        cod.c().off().i("enterTypeStatementNameList", ctx.children.stream().map(ParseTree::getText).collect(Collectors.toList()));
        for (fortran77Parser.TypeStatementNameContext name : ctx.typeStatementName()) {

            LLVMValueRef var = LLVMBuildAlloca(builder, LLVMInt32Type(), name.getText());
            valueRefs.put(name.getText(), var);

        }
    }

    @Override
    public void exitTypeStatementNameCharList(fortran77Parser.TypeStatementNameCharListContext ctx) {
        Integer length = Integer.valueOf(megaStack.popString()) + 1; // +1 because it dont work when table has the same length as string (PRINT ISSUE)

        for (fortran77Parser.TypeStatementNameCharContext name : ctx.typeStatementNameChar()) {
            LLVMValueRef var = LLVMBuildAlloca(builder, LLVMArrayType(LLVMInt8Type(), length), name.getText());
            valueRefs.put(name.getText(), var);
        }
    }

    /////////**END** MEMORY ALLOCATING BLOCK

}
