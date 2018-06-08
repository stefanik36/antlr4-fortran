package com.agh.a2f.fortran.app.translators;

import com.agh.a2f.fortran.app.util.LLVMFunctions;
import com.agh.a2f.fortran.app.util.MegaStack;
import com.agh.a2f.fortran.generated.fortran77BaseListener;
import com.agh.a2f.fortran.generated.fortran77Parser;
import com.stefanik.cod.controller.COD;
import com.stefanik.cod.controller.CODFactory;
import com.sun.xml.internal.bind.v2.model.core.TypeRef;
import org.antlr.v4.runtime.BufferedTokenStream;
import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.tree.ParseTree;

import static org.bytedeco.javacpp.LLVM.*;

import java.util.HashMap;
import java.util.Map;
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

//    @Override
//    public void exitExecutableUnit(fortran77Parser.ExecutableUnitContext ctx) {
//        executableUnitName = null;
//    }

    @Override
    public void enterFunctionStatement(fortran77Parser.FunctionStatementContext ctx) {
        executableUnitName = ctx.NAME().getText();
        cod.i(ctx.children.stream().map(ParseTree::getText).collect(Collectors.toList()));
        //TODO type
        LLVMValueRef function = LLVMAddFunction(
                mod,
                executableUnitName,
                LLVMFunctionType(LLVMInt32Type(), LLVMInt32Type(), 0, 0));
        LLVMSetFunctionCallConv(function, 1);
        valueRefs.put(executableUnitName, function);
    }


    @Override
    public void exitFunctionStatement(fortran77Parser.FunctionStatementContext ctx) {
//        cod.i("exitFunctionStatement: "+ctx.getText());
//        currentFunction = null;
    }

    @Override
    public void enterFunctionSubprogram(fortran77Parser.FunctionSubprogramContext ctx) {
//        cod.i("enterFunctionSubprogram: "+ctx.getText()+" | "+ currentFunctionSubprogram);
//        cod.i("enterFunctionSubprogram: ",ctx.children.stream().map(ParseTree::getText).collect(Collectors.toList()));
//        currentFunctionSubprogram =
    }

    @Override
    public void enterTypeStatementNameList(fortran77Parser.TypeStatementNameListContext ctx) {
        cod.i(ctx.getText(), ctx.children.stream().map(ParseTree::getText).collect(Collectors.toList()));
    }

    @Override
    public void enterProgramStatement(fortran77Parser.ProgramStatementContext ctx) {
//        executableUnitName
        cod.i(ctx.NAME().getSymbol().getText());
        String name = ctx.NAME().getSymbol().getText();
        mod = LLVMModuleCreateWithName(name);
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
        String name = ctx.getText();
        LLVMValueRef valRef = valueRefs.get(name);
        if (valRef != null && megaStack.wantData()) {
            megaStack.push(valRef);
        }
    }


    @Override
    public void enterSubprogramBody(fortran77Parser.SubprogramBodyContext ctx) {
        cod.i("enterSubprogramBody",
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
        cod.i("exitSubprogramBody", "entry_end_" + executableUnitName);
        LLVMBuildRetVoid(builder);
        LLVMDisposeBuilder(builder);
        super.exitSubprogramBody(ctx);
    }
}
