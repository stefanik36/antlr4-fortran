package com.agh.a2f.fortran.app.translators;

import com.agh.a2f.fortran.app.util.LLVMFunctions;
import com.agh.a2f.fortran.generated.fortran77Parser;
import org.antlr.v4.runtime.BufferedTokenStream;

import static org.bytedeco.javacpp.LLVM.LLVMDumpModule;
import static org.bytedeco.javacpp.LLVM.LLVMPrintModuleToString;

public class AllLLVMTranslator extends ReadTranslator {
    public AllLLVMTranslator(BufferedTokenStream tokens) {
        super(tokens);
    }

    private String result = null;

    @Override
    public void exitProgram(fortran77Parser.ProgramContext ctx) {
        LLVMDumpModule(mod);

        result = LLVMPrintModuleToString(mod).getString();

        LLVMFunctions.executeCode(mod, valueRefs.get("main"));
    }

    public String getResult(){
        return result;
    }
}
