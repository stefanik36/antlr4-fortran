package com.compilers.antlr4_fortran.util.app.translators;

import com.compilers.antlr4_fortran.util.app.util.LLVMFunctions;
import com.compilers.antlr4_fortran.util.generated.fortran77Parser;
import org.antlr.v4.runtime.BufferedTokenStream;

import static org.bytedeco.javacpp.LLVM.LLVMDumpModule;
import static org.bytedeco.javacpp.LLVM.LLVMPrintModuleToString;
import static org.bytedeco.javacpp.LLVM.LLVMWriteBitcodeToFile;

public class AllLLVMTranslator extends FunctionTranslator {
    public AllLLVMTranslator(BufferedTokenStream tokens) {
        super(tokens);
    }

    private String result = null;

    @Override
    public void exitProgram(fortran77Parser.ProgramContext ctx) {
        LLVMDumpModule(mod);
        result = LLVMPrintModuleToString(mod).getString();
        LLVMWriteBitcodeToFile(mod, "f2llvm.bc");
        LLVMFunctions.executeCode(mod, valueRefs.get("main"));
    }

    public String getResult(){
        return result;
    }
}
