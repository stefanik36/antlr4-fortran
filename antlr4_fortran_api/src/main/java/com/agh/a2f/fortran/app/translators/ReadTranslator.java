package com.agh.a2f.fortran.app.translators;

import com.agh.a2f.fortran.app.util.LLVMFunctions;
import com.agh.a2f.fortran.generated.fortran77Parser;
import org.antlr.v4.runtime.BufferedTokenStream;
import org.bytedeco.javacpp.PointerPointer;

import static org.bytedeco.javacpp.LLVM.*;

abstract class ReadTranslator extends LoopTranslator {
    ReadTranslator(BufferedTokenStream tokens) {
        super(tokens);
    }

    private LLVMValueRef initialize() {
        final String scanfStr = "scanf";
        LLVMValueRef scanf = valueRefs.get(scanfStr);
        if (scanf == null) {
            scanf = LLVMFunctions.declareExternalScanf(mod);
            valueRefs.put(scanfStr, scanf);
        }
        return scanf;
    }

    @Override
    public void enterReadStatement(fortran77Parser.ReadStatementContext ctx) {
        megaStack.startSection();

    }

    @Override
    public void exitReadStatement(fortran77Parser.ReadStatementContext ctx) {
        LLVMValueRef scanf = initialize();

        String varName = ctx.ioList(0).getText();
        LLVMValueRef var = valueRefs.get(varName);
        LLVMValueRef args[] = {LLVMBuildGlobalString(builder, "%s", ""), var};
        LLVMValueRef printCall = LLVMBuildCall(builder, scanf, new PointerPointer<>(args), args.length, "");
        LLVMSetTailCall(printCall,0);

        megaStack.endSection();
    }
    /*
    //TODO XDDD no akurat
  6 %struct._IO_FILE = type { i32, i8*, i8*, i8*, i8*, i8*, i8*, i8*, i8*, i8*, i8*, i8*, %struct._IO_mark    er*, %struct._IO_FILE*, i32, i32, i64, i16, i8, [1 x i8], i8*, i64, i8*, i8*, i8*, i8*, i64, i32, [20     x i8] }
  7 %struct._IO_marker = type { %struct._IO_marker*, %struct._IO_FILE*, i32 }
  8
  9 @.str = private unnamed_addr constant [4 x i8] c"XD\0A\00", align 1
 10 @stdin = external global %struct._IO_FILE*, align 8
 11 @.str.1 = private unnamed_addr constant [4 x i8] c"%s\0A\00", align 1
 12
 13 ; Function Attrs: noinline nounwind optnone sspstrong uwtable
 14 define i32 @main() #0 {
 15   %1 = alloca i32, align 4
 16   %2 = alloca [50 x i8], align 16
 17   store i32 0, i32* %1, align 4
 18   %3 = call i32 (i8*, ...) @printf(i8* getelementptr inbounds ([4 x i8], [4 x i8]* @.str, i32 0, i32 0    ))
 19   %4 = getelementptr inbounds [50 x i8], [50 x i8]* %2, i32 0, i32 0
 20   %5 = load %struct._IO_FILE*, %struct._IO_FILE** @stdin, align 8
 21   %6 = call i8* @fgets(i8* %4, i32 10, %struct._IO_FILE* %5)
 22   %7 = getelementptr inbounds [50 x i8], [50 x i8]* %2, i32 0, i32 0
 23   %8 = call i32 (i8*, ...) @printf(i8* getelementptr inbounds ([4 x i8], [4 x i8]* @.str.1, i32 0, i32     0), i8* %7)
 24   ret i32 0
 25 }
 26
 27 declare i32 @printf(i8*, ...) #1
 28
 29 declare i8* @fgets(i8*, i32, %struct._IO_FILE*) #1

     */
}
