package com.agh.a2f.fortranDeprecated.app;

import com.agh.a2f.fortranDeprecated.generated.fortran77Lexer;
import com.agh.a2f.fortranDeprecated.generated.fortran77Parser;
import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.bytedeco.javacpp.BytePointer;
import org.bytedeco.javacpp.LLVM;
import org.bytedeco.javacpp.Pointer;
import org.bytedeco.javacpp.PointerPointer;

import java.io.FileInputStream;
import java.io.IOException;

import static org.bytedeco.javacpp.LLVM.*;
import static org.bytedeco.javacpp.LLVM.LLVMDisposeBuilder;
import static org.bytedeco.javacpp.LLVM.LLVMDisposeExecutionEngine;

@Deprecated
public class App {

    public static void main(String[] args) {
        String path = "code/fortran/helo.f77";
//        String path = "code/fortran/fun01.f";
//        App app = new App();
//        app.start(path);


        IrBuilderExample.executeExample();
        //INITIALIZE ALL


    }

    private void start(String path) {
        try {
            System.out.println("===================== START ======================");

            ANTLRInputStream input = new ANTLRInputStream(
                    new FileInputStream(path));

            fortran77Lexer lexer = new fortran77Lexer(input);
            fortran77Parser parser = new fortran77Parser(new CommonTokenStream(lexer));
            parser.addParseListener(new Listener());

            // Start parsing
            parser.program();
            System.out.println("===================== END ======================");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Deprecated
    public static class IrBuilderExample {
        /**
         * declare extern int printf(char*, ...)
         * @param mod
         */


        static LLVMValueRef declareExternalPrintf(LLVMModuleRef mod){
            LLVMTypeRef printfArgsTyList[] = { LLVMPointerType(LLVMInt8Type(), 0) };
            LLVMTypeRef PrintfTy = LLVMFunctionType(LLVMInt32Type(),
                    new PointerPointer<>(printfArgsTyList),
                    0,
                    1// IsVarArg
            );

            return LLVMAddFunction(mod, "printf", PrintfTy);
        }

        static void printf(LLVMBuilderRef builder, LLVMValueRef printf, String str, String name){

            LLVMValueRef printfArgs[] = {LLVMBuildGlobalStringPtr(builder, str, name)};
            LLVMBuildCall(
                    builder,
                    printf,
                    new PointerPointer<>(printfArgs),
                    1,
                    "printf");
        }


        static void executeExample() {
            BytePointer error = new BytePointer((Pointer) null); // Used to retrieve messages from functions


            LLVMModuleRef mod = LLVMModuleCreateWithName("fac_module");

            //declare external
            LLVMValueRef printf = declareExternalPrintf(mod);


            //my funcition
            LLVMValueRef myFunc = LLVMAddFunction(mod, "print_jd", LLVMFunctionType(LLVMVoidType(), LLVMVoidType(), 0,0));
            LLVMBuilderRef myBuilder = LLVMCreateBuilder();
            LLVMBasicBlockRef myEntry = LLVMAppendBasicBlock(myFunc, "myFunc_entry");
            LLVMPositionBuilderAtEnd(myBuilder, myEntry);
            printf(myBuilder, printf, "Jestem prawdziwy", "true_print_str");
            LLVMBuildRetVoid(myBuilder);
            LLVMSetFunctionCallConv(myFunc, LLVMCCallConv);
            LLVMDisposeBuilder(myBuilder);


            //main fnction
            LLVMTypeRef[] fac_args = {LLVMInt32Type()};
            LLVMValueRef fac = LLVMAddFunction(mod, "main", LLVMFunctionType(LLVMInt32Type(), fac_args[0], 1, 0));
            LLVMSetFunctionCallConv(fac, LLVMCCallConv);
            LLVMValueRef n = LLVMGetParam(fac, 0);




            //initialization blocks
            LLVMBasicBlockRef entry = LLVMAppendBasicBlock(fac, "entry");
            LLVMBasicBlockRef iftrue = LLVMAppendBasicBlock(fac, "iftrue");
            LLVMBasicBlockRef iffalse = LLVMAppendBasicBlock(fac, "iffalse");
            LLVMBasicBlockRef end = LLVMAppendBasicBlock(fac, "end");
            LLVMBuilderRef builder = LLVMCreateBuilder();


            LLVMPositionBuilderAtEnd(builder, entry);
            LLVMValueRef If = LLVMBuildICmp(builder, LLVMIntEQ, n, LLVMConstInt(LLVMInt32Type(), 0, 0), "n == 0");
            LLVMBuildCondBr(builder, If, iftrue, iffalse);

            LLVMPositionBuilderAtEnd(builder, iftrue);
            LLVMValueRef res_iftrue = LLVMConstInt(LLVMInt32Type(), 1, 0);
            LLVMBuildBr(builder, end);

            LLVMPositionBuilderAtEnd(builder, iffalse);
            LLVMValueRef n_minus = LLVMBuildSub(builder, n, LLVMConstInt(LLVMInt32Type(), 1, 0), "n - 1");
            LLVMValueRef[] call_fac_args = {n_minus};
            LLVMValueRef call_fac = LLVMBuildCall(builder, fac, new PointerPointer<>(call_fac_args), 1, "fac(n - 1)");
            LLVMValueRef res_iffalse = LLVMBuildMul(builder, n, call_fac, "n * fac(n - 1)");
            LLVMBuildBr(builder, end);

            LLVMPositionBuilderAtEnd(builder, end);
            LLVMValueRef res = LLVMBuildPhi(builder, LLVMInt32Type(), "result");
            LLVMValueRef[] phi_vals = {res_iftrue, res_iffalse};
            LLVMBasicBlockRef[] phi_blocks = {iftrue, iffalse};
            LLVMAddIncoming(res, new PointerPointer<>(phi_vals), new PointerPointer<>(phi_blocks), 2);
            LLVMBuildCall(builder, myFunc, new PointerPointer<>(), 0, "");


            LLVMBuildRet(builder, res);

            LLVMVerifyModule(mod, LLVMAbortProcessAction, error);
            LLVMDisposeMessage(error); // Handler == LLVMAbortProcessAction -> No need to check errors

            LLVMDumpModule(mod); //print result to error
            LLVMWriteBitcodeToFile(mod, "f.bc"); //save to bytecode


            //RUN FUNCTION FUNC

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

            LLVMGenericValueRef exec_args = LLVMCreateGenericValueOfInt(LLVMInt32Type(), 10, 0);
            LLVMGenericValueRef exec_res = LLVMRunFunction(engine, fac, 1, exec_args);
            System.err.println();
            System.err.println("; Running fac(10) with JIT...");
            System.err.println("; Result: " + LLVMGenericValueToInt(exec_res, 0));

            LLVMDisposePassManager(pass);
            LLVMDisposeBuilder(builder);
            LLVMDisposeExecutionEngine(engine);
        }

        static void blankModule() {
            LLVMModuleRef myModule = LLVMModuleCreateWithName("myModule");

        }
    }
}
