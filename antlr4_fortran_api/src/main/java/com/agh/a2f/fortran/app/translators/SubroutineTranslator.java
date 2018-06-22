package com.agh.a2f.fortran.app.translators;

import com.agh.a2f.fortran.app.util.FunctionArgManager;
import com.agh.a2f.fortran.generated.fortran77Parser;
import com.agh.a2f.fortran.generated.fortran77Parser.*;
import org.antlr.v4.runtime.BufferedTokenStream;
import org.antlr.v4.runtime.RuleContext;
import org.apache.commons.lang3.ArrayUtils;
import org.bytedeco.javacpp.PointerPointer;
import java.util.*;
import java.util.stream.Collectors;

import static org.bytedeco.javacpp.LLVM.*;

public abstract class SubroutineTranslator extends FunctionTranslator {
    SubroutineTranslator(BufferedTokenStream tokens) {
        super(tokens);
    }


    @Override
    public void enterCallStatement(fortran77Parser.CallStatementContext ctx) {
        megaStack.startSection();
        super.enterCallStatement(ctx);
    }

    @Override
    public void exitCallStatement(fortran77Parser.CallStatementContext ctx) {
        LLVMValueRef sub = valueRefs.get(ctx.subroutineCall().identifier().getText());
        LLVMValueRef args[] = handleLoad(false);
        LLVMBuildCall(builder, sub, new PointerPointer<>(args), args.length, "");
        megaStack.endSection();
    }

    @Override
    public void enterSubroutineSubprogram(fortran77Parser.SubroutineSubprogramContext ctx) {
        megaStack.startSection();

        if(ctx.subroutineStatement().namelist() !=null) {
            this.args = ctx.subroutineStatement().namelist()
                    .identifier().stream().map(RuleContext::getText).collect(Collectors.toList());
        }
        String subName = ctx.subroutineStatement().identifier().getText();

        FunctionArgManager manager = new FunctionArgManager(ctx.subprogramBody(), this.args);

        LLVMTypeRef[] args = manager.getArgsTypeArray();

        LLVMValueRef fun = LLVMAddFunction(mod, subName, LLVMFunctionType(LLVMVoidType(), new PointerPointer<>(args), args.length, 0));

        executableUnitName = subName;
        functionType = FunctionType.SUBROUTINE;
        valueRefs.put(subName, fun);
    }

    @Override
    public void exitSubroutineSubprogram(fortran77Parser.SubroutineSubprogramContext ctx) {
        args = null;
        megaStack.endSection();
    }
}
