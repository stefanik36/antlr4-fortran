package com.agh.a2f.fortran.app.util;

import org.antlr.v4.runtime.tree.ParseTree;
import org.bytedeco.javacpp.BytePointer;
import org.bytedeco.javacpp.LLVM;
import org.bytedeco.javacpp.Pointer;
import org.bytedeco.javacpp.PointerPointer;

import static org.bytedeco.javacpp.LLVM.*;

public class LLVMFunctions {

    public static ParseTree skipSingleChildNodes(ParseTree node){
        ParseTree currentNode = node;
        while (currentNode.getChildCount() == 1){
            currentNode = currentNode.getChild(0);
        }
        return currentNode;
    }

    public static LLVM.LLVMValueRef declareExternalPrintf(LLVM.LLVMModuleRef mod){
        LLVM.LLVMTypeRef printfArgsTyList[] = { LLVMPointerType(LLVMInt8Type(), 0) };
        LLVM.LLVMTypeRef PrintfTy = LLVMFunctionType(LLVMInt32Type(),
                new PointerPointer<>(printfArgsTyList),
                0,
                1// IsVarArg
        );

        return LLVMAddFunction(mod, "printf", PrintfTy);
    }


    public static void executeCode(LLVMModuleRef mod, LLVMValueRef mainFunc){
        BytePointer error = new BytePointer((Pointer) null); // Used to retrieve messages from functions

        LLVMLinkInMCJIT();
        LLVMInitializeNativeAsmPrinter();
        LLVMInitializeNativeAsmParser();
        LLVMInitializeNativeDisassembler();
        LLVMInitializeNativeTarget();


        LLVMExecutionEngineRef engine = new LLVMExecutionEngineRef();
        if (LLVMCreateJITCompilerForModule(engine, mod, 2, error) != 0) {
            System.err.println(error.getString());
            LLVMDisposeMessage(error);
            System.exit(-1);
        }

        LLVMPassManagerRef pass = LLVMCreatePassManager();
        LLVMAddConstantPropagationPass(pass);
        LLVMAddInstructionCombiningPass(pass);
        LLVMAddPromoteMemoryToRegisterPass(pass);
        LLVMAddDemoteMemoryToRegisterPass(pass); // Demotes every possible value to memory
        LLVMAddGVNPass(pass);
        LLVMAddCFGSimplificationPass(pass);
        LLVMRunPassManager(pass, mod);

        System.out.println("============== EXECUTE TRANSLATED CODE ===============");
//        LLVMGenericValueRef exec_args = LLVMCreateGenericValueOfInt(LLVMInt32Type(), 10, 0);
        LLVMGenericValueRef exec_res = LLVMRunFunction(engine, mainFunc, 0, new PointerPointer());
//        System.err.println();
//        System.err.println("; Running fac(10) with JIT...");
//        System.err.println("; Result: " + LLVMGenericValueToInt(exec_res, 0));

        LLVMDisposePassManager(pass);
        LLVMDisposeExecutionEngine(engine);
    }

}
