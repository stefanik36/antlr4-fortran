package com.agh.a2f.fortran.app;

import com.agh.a2f.fortran.generated.fortran77BaseListener;
import com.agh.a2f.fortran.generated.fortran77Parser;
import com.stefanik.cod.controller.COD;
import com.stefanik.cod.controller.CODFactory;
import org.antlr.v4.runtime.BufferedTokenStream;
import org.bytedeco.javacpp.BytePointer;
import org.bytedeco.javacpp.Pointer;

import static org.bytedeco.javacpp.LLVM.*;
import static org.bytedeco.javacpp.LLVM.LLVMInitializeNativeTarget;
import static org.bytedeco.javacpp.LLVM.LLVMModuleCreateWithName;

public class LLVMTranslator extends fortran77BaseListener {
    private static final COD cod = CODFactory.get();
    private BufferedTokenStream tokens;

    public LLVMTranslator(BufferedTokenStream tokens) {
        this.tokens = tokens;
    }


    @Override
    public void enterMainProgram(fortran77Parser.MainProgramContext ctx) {
        BytePointer error = new BytePointer((Pointer) null); // Used to retrieve messages from functions
        LLVMLinkInMCJIT();
        LLVMInitializeNativeAsmPrinter();
        LLVMInitializeNativeAsmParser();
        LLVMInitializeNativeDisassembler();
        LLVMInitializeNativeTarget();

        LLVMModuleRef mod = LLVMModuleCreateWithName("fac_module");

        //MAIN LLVM 
    }
}
