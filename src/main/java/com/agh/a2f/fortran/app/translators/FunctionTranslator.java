package com.agh.a2f.fortran.app.translators;

import com.agh.a2f.fortran.generated.fortran77Parser;
import com.stefanik.cod.controller.COD;
import com.stefanik.cod.controller.CODFactory;
import org.antlr.v4.runtime.BufferedTokenStream;

public abstract class FunctionTranslator extends LoopTranslator {
    private static final COD cod = CODFactory.get();
    FunctionTranslator(BufferedTokenStream tokens) {
        super(tokens);
    }

  
}
