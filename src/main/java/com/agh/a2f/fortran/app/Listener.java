package com.agh.a2f.fortran.app;

import com.agh.a2f.fortran.generated.fortran77BaseListener;
import com.agh.a2f.fortran.generated.fortran77Parser;
import com.stefanik.cod.controller.COD;
import com.stefanik.cod.controller.CODFactory;

public class Listener extends fortran77BaseListener {
    private static final COD cod = CODFactory.get();

    @Override
    public void exitProgram(fortran77Parser.ProgramContext ctx) {

        cod.i(ctx.executableUnit());
    }

    @Override
    public void exitPrintStatement(fortran77Parser.PrintStatementContext ctx) {
        cod.i(ctx.ioList(0));
    }

    @Override
    public void enterMainProgram(fortran77Parser.MainProgramContext ctx) {
        cod.i(ctx.subprogramBody());
    }
}
