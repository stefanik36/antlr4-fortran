package com.agh.a2f.fortran.app.translators;

import com.agh.a2f.fortran.generated.fortran77Parser;
import org.antlr.v4.runtime.BufferedTokenStream;

import static org.bytedeco.javacpp.LLVM.*;

abstract class WriteTranslator extends LoopTranslator {
    WriteTranslator(BufferedTokenStream tokens) {
        super(tokens);
    }


    @Override
    public void enterWriteStatement(fortran77Parser.WriteStatementContext ctx) {
        megaStack.startSection();
    }

    @Override
    public void exitWriteStatement(fortran77Parser.WriteStatementContext ctx) {


        megaStack.endSection();
    }
}
