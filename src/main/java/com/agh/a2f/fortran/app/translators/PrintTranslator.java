package com.agh.a2f.fortran.app.translators;

import com.agh.a2f.fortran.app.util.LLVMFunctions;
import com.agh.a2f.fortran.generated.fortran77Lexer;
import com.agh.a2f.fortran.generated.fortran77Parser;
import org.antlr.v4.runtime.BufferedTokenStream;
import org.bytedeco.javacpp.LLVM;
import org.bytedeco.javacpp.PointerPointer;

import java.util.*;
import static org.bytedeco.javacpp.LLVM.*;

abstract class PrintTranslator extends ConditionalTranslator {

    public PrintTranslator(BufferedTokenStream tokens) {
        super(tokens);
    }

    private List<LLVMValueRef> printfArgs = null;
    private StringBuilder formatJoiner = null;

    private LLVMValueRef initialize(){
        final String printfStr = "printf";
        LLVMValueRef printf = valueRefs.get(printfStr);
        if (printf == null) {
            printf = LLVMFunctions.declareExternalPrintf(mod);
            valueRefs.put(printfStr, printf);
        }
        return printf;
    }

    @Override
    public void enterPrintStatement(fortran77Parser.PrintStatementContext ctx) {
        megaStack.startSection(false);
    }

    @Override
    public void exitPrintStatement(fortran77Parser.PrintStatementContext ctx) {
        LLVMValueRef printf = initialize();

        printfArgs = new ArrayList<>();
        formatJoiner = new StringBuilder();

        for (fortran77Parser.IoListContext l : ctx.ioList()) {
            String txt = l.getText();
            switch (l.getStop().getType()) {
                case fortran77Lexer.ICON: //number (?integer)
                case fortran77Lexer.MYNUM:
                    prepareNumber(txt);
                    break;

                case fortran77Lexer.SCON: //string
                    prepareString(txt);
                    break;

                case fortran77Lexer.NAME: //variables (? and others i think xd)
                    prepareVariable(txt);

                    break;
                case fortran77Lexer.RPAREN: //math
                    prepareMathExpr(txt);
                    break;
            }
            //TODO obsługa real
        }

        LLVMValueRef format = LLVMBuildGlobalString(builder, formatJoiner.toString() + "\n", "");
        printfArgs.add(0, format);
        LLVMValueRef[] printfArgsArr = printfArgs.toArray(new LLVMValueRef[0]);
        LLVMValueRef printCall = LLVMBuildCall(builder, printf, new PointerPointer<>(printfArgsArr), printfArgsArr.length, "");
//        LLVMSetTailCall(printCall, 1);
        megaStack.endSection();
    }

    private void prepareNumber(String txt) {
        printfArgs.add(LLVMConstInt(LLVMInt32Type(), Long.valueOf(txt), 1));
        formatJoiner.append("          %d ");
    }

    private void prepareString(String txt) {
        formatJoiner.append("%s");
        String cutString = txt.substring(1, txt.length() - 1);
        printfArgs.add(LLVMBuildGlobalString(builder, cutString, ""));
    }

    private void prepareVariable(String txt) {
        LLVM.LLVMValueRef val = valueRefs.get(txt);
        LLVM.LLVMTypeRef valType = LLVMTypeOf(val);
        if (valType.equals(LLVMInt32Type())) {
            printfArgs.add(val);
            formatJoiner.append("          %d ");
        } else {
            valType = LLVMGetAllocatedType(val);
            if (valType.equals(LLVMInt32Type())) {
                LLVMValueRef loadedVal = LLVMBuildLoad(builder, val, "");
                printfArgs.add(loadedVal);
                formatJoiner.append("          %d ");
            } else {
                printfArgs.add(val);
                formatJoiner.append("%s");
            }
        }
    }

    private void prepareMathExpr(String txt) {
        //TODO odbieranie skądś wyliczonej wartości
    }

}
