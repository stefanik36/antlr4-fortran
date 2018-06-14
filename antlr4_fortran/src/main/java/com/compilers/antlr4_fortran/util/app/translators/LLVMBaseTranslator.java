package com.compilers.antlr4_fortran.util.app.translators;

import com.compilers.antlr4_fortran.util.app.util.LLVMFunctions;
import com.compilers.antlr4_fortran.util.app.util.MegaStack;
import com.compilers.antlr4_fortran.util.generated.fortran77BaseListener;
import com.compilers.antlr4_fortran.util.generated.fortran77Parser;
import com.stefanik.cod.controller.COD;
import com.stefanik.cod.controller.CODFactory;
import org.antlr.v4.runtime.BufferedTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;
import org.bytedeco.javacpp.PointerPointer;

import static org.bytedeco.javacpp.LLVM.*;

import java.util.*;
import java.util.stream.Collectors;

abstract class LLVMBaseTranslator extends fortran77BaseListener {
    private static final COD cod = CODFactory.get();
    private BufferedTokenStream tokens;

    LLVMBaseTranslator(BufferedTokenStream tokens) {
        this.tokens = tokens;
    }

    LLVMModuleRef mod = null;
    LLVMBuilderRef builder = null;
    String executableUnitName = null;

    MegaStack megaStack = new MegaStack();
    Map<String, LLVMValueRef> valueRefs = new HashMap<>();

    List<String> functionArguments = new ArrayList<>();
    List<LLVMValueRef> functionArgumentsRef = new ArrayList<>();

    @Override
    public void enterProgram(fortran77Parser.ProgramContext ctx) {
        mod = LLVMModuleCreateWithName("TEST");
    }

    @Override
    public void enterProgramStatement(fortran77Parser.ProgramStatementContext ctx) {
//        executableUnitName
        cod.c().off().i(ctx.NAME().getSymbol().getText());
//        String name = ctx.NAME().getSymbol().getText();
        LLVMValueRef mainFunc = LLVMAddFunction(
                mod,
                "main",
                LLVMFunctionType(LLVMVoidType(), LLVMVoidType(), 0, 0)
        );

        valueRefs.put("main", mainFunc);
        executableUnitName = "main";
        LLVMSetFunctionCallConv(mainFunc, LLVMCCallConv);
    }

    @Override
    public void exitProgram(fortran77Parser.ProgramContext ctx) {
        LLVMDumpModule(mod);
        LLVMWriteBitcodeToFile(mod, "f2llvm.bc"); //save to bytecode

        LLVMFunctions.executeCode(mod, valueRefs.get("main"));

//        LLVMDisposeModule(mod);
    }

    @Override
    public void enterAintegerexpr(fortran77Parser.AintegerexprContext ctx) {
        long val = Long.valueOf(ctx.getText());
        LLVMValueRef valRef = LLVMConstInt(LLVMInt32Type(), val, 1);
        if (megaStack.wantData()) {
            megaStack.push(valRef);
        }
    }

    @Override
    public void enterVarRef(fortran77Parser.VarRefContext ctx) {
        String sName = preventFuncName(ctx.NAME().toString());
        LLVMValueRef valRef = valueRefs.get(sName);
        if (isFunctionCall(ctx)) {
            megaStack.startSection();
        }
        if (valRef != null && megaStack.wantData()) {
            megaStack.push(valRef);
        }
    }

    private boolean isFunctionCall(fortran77Parser.VarRefContext ctx) {
        return ctx.subscripts() != null;
    }

    protected String preventFuncName(String name) {
        if (name.equals(executableUnitName)) {
            return name + "Var";
        }
        return name;
    }

    @Override
    public void exitVarRef(fortran77Parser.VarRefContext ctx) {
        if (isFunctionCall(ctx)) {
            Stack<LLVMValueRef> args = new Stack<>();
            while (megaStack.size() > 0){
                args.push(megaStack.popValue());
            }


            LLVMValueRef func = args.pop();
            LLVMValueRef argsL[] = new LLVMValueRef[args.size()];
            args.toArray(argsL);
            functionArgumentsRef.addAll(args);

            LLVMValueRef result = LLVMBuildCall(builder, func, new PointerPointer<>(argsL), 1, "");
            megaStack.endSection();
            megaStack.push(result);
        }
    }

    @Override
    public void enterSubprogramBody(fortran77Parser.SubprogramBodyContext ctx) {
        cod.c().off().i("enterSubprogramBody",
                "entry_" + executableUnitName,
                valueRefs.entrySet().stream().map(Map.Entry::getKey).collect(Collectors.toList()),
                valueRefs.get(executableUnitName),
                ctx.children.stream().map(ParseTree::getText).collect(Collectors.toList())
        );

        LLVMBasicBlockRef entry = LLVMAppendBasicBlock(valueRefs.get(executableUnitName), "entry_" + executableUnitName);
        builder = LLVMCreateBuilder();
        LLVMPositionBuilderAtEnd(builder, entry);
    }

    @Override
    public void exitSubprogramBody(fortran77Parser.SubprogramBodyContext ctx) {
        cod.c().off().i("exitSubprogramBody", "entry_end_" + executableUnitName, executableUnitName, valueRefs.get(executableUnitName));
        String sName = preventFuncName(executableUnitName);
        if (executableUnitName.equals("main")) {
            LLVMBuildRet(builder, LLVMConstInt(LLVMInt32Type(), 0, 1));
        } else {
            LLVMValueRef vLoad = LLVMBuildLoad(builder, valueRefs.get(sName), "");
            LLVMBuildRet(builder, vLoad);
        }
        LLVMDisposeBuilder(builder);
        super.exitSubprogramBody(ctx);
    }
}
