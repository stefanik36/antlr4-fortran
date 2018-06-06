package com.agh.a2f.fortran.app.translators;

import com.agh.a2f.fortran.generated.fortran77Parser;
import org.antlr.v4.runtime.BufferedTokenStream;

import java.util.List;
import java.util.Stack;

import static org.bytedeco.javacpp.LLVM.*;

abstract class ConditionalTranslator extends MemoryAllocationTranslator {
    public ConditionalTranslator(BufferedTokenStream tokens) {
        super(tokens);
    }

    @Override
    public void enterIfStatement(fortran77Parser.IfStatementContext ctx) {
        megaStack.startSection();
        LLVMValueRef fun = valueRefs.get(currentFunction);
        LLVMBasicBlockRef endBlock = LLVMAppendBasicBlock(fun, "end_block");
        megaStack.put(endBlock);
    }

    @Override
    public void exitIfStatement(fortran77Parser.IfStatementContext ctx) {
        LLVMBasicBlockRef endBlock = megaStack.popBlock();
        LLVMPositionBuilderAtEnd(builder, endBlock);
        megaStack.endSection();
    }


    @Override
    public void enterFirstIfBlock(fortran77Parser.FirstIfBlockContext ctx) {
        LLVMBasicBlockRef trueBlock = megaStack.popBlock();
        LLVMPositionBuilderAtEnd(builder, trueBlock);
    }

    @Override
    public void exitFirstIfBlock(fortran77Parser.FirstIfBlockContext ctx) {
        LLVMBasicBlockRef falseBlock = megaStack.popBlock();
        LLVMBasicBlockRef endBlock = megaStack.popBlock();
        megaStack.put(endBlock);
        megaStack.put(falseBlock);
        LLVMBuildBr(builder, endBlock);

    }

    @Override
    public void enterElseIfBlock(fortran77Parser.ElseIfBlockContext ctx) {
        enterFirstIfBlock(null);

    }

    @Override
    public void exitElseIfBlock(fortran77Parser.ElseIfBlockContext ctx) {
        exitFirstIfBlock(null);
    }

    @Override
    public void enterElseIfStatement(fortran77Parser.ElseIfStatementContext ctx) {
        LLVMBasicBlockRef falseBlockFinal = megaStack.popBlock();
        LLVMPositionBuilderAtEnd(builder, falseBlockFinal);

    }

    @Override
    public void exitElseIfStatement(fortran77Parser.ElseIfStatementContext ctx) {


        super.exitElseIfStatement(ctx);
    }

    @Override
    public void enterElseStatement(fortran77Parser.ElseStatementContext ctx) {
        LLVMBasicBlockRef falseBlock = megaStack.popBlock();
        LLVMPositionBuilderAtEnd(builder, falseBlock);
    }

    @Override
    public void exitElseStatement(fortran77Parser.ElseStatementContext ctx) {
        LLVMBasicBlockRef endBlock = (LLVMBasicBlockRef) megaStack.peek();
        LLVMBuildBr(builder, endBlock);
    }


    /////////**END** IF STATEMENT BLOCK

    @Override
    public void exitLogicalExpression(fortran77Parser.LogicalExpressionContext ctx) {
        LLVMValueRef fun = valueRefs.get(currentFunction);
        assert fun != null;

        LLVMBasicBlockRef trueBlock = LLVMAppendBasicBlock(fun, "");
        LLVMBasicBlockRef falseBlock = LLVMAppendBasicBlock(fun, "");
        LLVMValueRef iF = megaStack.popValue();
        LLVMBuildCondBr(builder, iF, trueBlock, falseBlock);
        megaStack.put(falseBlock);
        megaStack.put(trueBlock);

    }


    @Override
    public void exitLexpr0(fortran77Parser.Lexpr0Context ctx) {

        List ch = ctx.lexprSpec();
        int size = ch.size();
        if (size == 0) return;

        Stack<LLVMValueRef> exprStack = new Stack<>();

        for (int i = 0; i < size + 1; i++) {
            exprStack.push(megaStack.popValue());
        }

        for (fortran77Parser.LexprSpecContext node : ctx.lexprSpec()) {
            LLVMValueRef lVal = exprStack.pop();
            LLVMValueRef rVal = exprStack.pop();
            LLVMValueRef cmp;
            if (node.EQV() != null) {
                cmp = LLVMBuildICmp(builder, LLVMIntEQ, lVal, rVal, "");
            } else if (node.NEQV() != null) {
                cmp = LLVMBuildICmp(builder, LLVMIntNE, lVal, rVal, "");
            } else if (node.LAND() != null) {
                cmp = LLVMBuildAnd(builder, lVal, rVal, "");
            } else if (node.LOR() != null) {
                cmp = LLVMBuildOr(builder, lVal, rVal, "");
            } else return;
            exprStack.push(cmp);
        }
        LLVMValueRef resultExpr = exprStack.pop();
        megaStack.put(resultExpr);
    }


    @Override
    public void exitLexpr1(fortran77Parser.Lexpr1Context ctx) {
        if (ctx.LNOT() == null) return;
        LLVMValueRef cmp = megaStack.popValue();
        LLVMValueRef notCmp = LLVMBuildNot(builder, cmp, "");
        megaStack.put(notCmp);
    }

    @Override
    public void exitLexpr2(fortran77Parser.Lexpr2Context ctx) {
        int type = 0;
        if (ctx.EQ() != null) {
            type = LLVMIntEQ;
        } else if (ctx.NE() != null) {
            type = LLVMIntNE;
        } else if (ctx.LE() != null) {
            type = LLVMIntSLE;
        } else if (ctx.GT() != null) {
            type = LLVMIntSGT;
        } else if (ctx.GE() != null) {
            type = LLVMIntSGE;
        } else if (ctx.LT() != null) {
            type = LLVMIntSLT;
        } else return;

        LLVMValueRef rVal = megaStack.popValue();
        LLVMValueRef lVal = megaStack.popValue();


        //TODO jakoś lepiej ogarnąć kiedy jest zmienna i należy ją załadować?
        if (valueRefs.containsValue(lVal))
            lVal = LLVMBuildLoad(builder, lVal, "");
        if (valueRefs.containsValue(rVal))
            rVal = LLVMBuildLoad(builder, rVal, "");

        LLVMValueRef logic = LLVMBuildICmp(builder, type, lVal, rVal, "");
        megaStack.put(logic);
    }
}
