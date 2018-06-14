package com.compilers.antlr4_fortran.util.app.translators;

import com.compilers.antlr4_fortran.util.app.util.Variable;
import com.compilers.antlr4_fortran.util.generated.fortran77Parser;
import com.stefanik.cod.controller.COD;
import com.stefanik.cod.controller.CODFactory;
import org.antlr.v4.runtime.BufferedTokenStream;
import org.antlr.v4.runtime.RuleContext;
import org.antlr.v4.runtime.tree.ParseTree;
import org.bytedeco.javacpp.PointerPointer;

import java.util.stream.Collectors;

import static org.bytedeco.javacpp.LLVM.*;
import static org.bytedeco.javacpp.LLVM.LLVMInt32Type;

public abstract class FunctionTranslator extends LoopTranslator {
    private static final COD cod = CODFactory.get();

    FunctionTranslator(BufferedTokenStream tokens) {
        super(tokens);
    }


    @Override
    public void enterFunctionStatement(fortran77Parser.FunctionStatementContext ctx) {
        executableUnitName = ctx.NAME().getText();

        LLVMTypeRef[] args = new LLVMTypeRef[ctx.namelist().identifier().size()];
        for (int i = 0; i < args.length; i++) {
            args[i] = LLVMInt32Type();
        }


        LLVMValueRef myFunc = LLVMAddFunction(
                mod,
                executableUnitName,
                LLVMFunctionType(LLVMInt32Type(), new PointerPointer<>(args), args.length, 0)
        );
        LLVMSetFunctionCallConv(myFunc, LLVMCCallConv);
        valueRefs.put(executableUnitName, myFunc);


        functionArguments.addAll(
                ctx.namelist().identifier().stream()
                        .map(RuleContext::getText)
                        .collect(Collectors.toList())
        );


//        cod.c().i("enterFunctionStatement", ctx.children.stream().map(ParseTree::getText).collect(Collectors.toList()));
//        for (fortran77Parser.TypeStatementNameContext name : ctx.typeStatementName()) {
//            String sName = preventFuncName(name.getText());
//
//            LLVMValueRef var = LLVMBuildAlloca(builder, LLVMInt32Type(), sName);
//            valueRefs.put(sName, var);
//
//        }

//        for (String name : ctx.namelist().identifier().stream().map(ParseTree::getText).collect(Collectors.toList())) {
//
////            if (",".equals(name)) {
////                argsFlag = false;
////            }
////            if (argsFlag) {
//            LLVMValueRef llvmValueRef = null;
//            if (Variable.isString(name)) {
//                String val = Variable.getStringValue(name);
//                llvmValueRef = LLVMConstString(val, val.length(), 1);
//                cod.c().i("str: " + llvmValueRef.address());
//            } else if (Variable.isInteger(name)) {
//                llvmValueRef = LLVMConstInt(LLVMInt32Type(), Variable.getIntegerValue(name), 0);
//                cod.c().i("int: " + llvmValueRef.address());
//            } else if (Variable.isInMap(name, valueRefs)) {
//                llvmValueRef = LLVMBuildLoad(builder, Variable.getFromMap(name, valueRefs), "");
//                cod.c().i("var: " + llvmValueRef.address());
//            }
//            //Something else pushed/will push it to the megaStack?
//
//            if (llvmValueRef != null) {
//                cod.c().i("\t[" + megaStack.size() + "]PUSH ASSIGN: " + llvmValueRef.address());
//                megaStack.push(llvmValueRef);
//            }
//
//
//            cod.c().i("NULL: " + name);

//                LLVMValueRef var = LLVMBuildAlloca(builder, LLVMInt32Type(), name);
//                functionStack.put(name, var);
//            }
//
//            if ("(".equals(name)) {
//                argsFlag = true;
//            }
//        }
    }

    @Override
    public void exitFunctionStatement(fortran77Parser.FunctionStatementContext ctx) {
//        cod.i("exitFunctionStatement: MS: " + megaStack.size());
    }

    @Override
    public void exitFunctionSubprogram(fortran77Parser.FunctionSubprogramContext ctx) {
//        cod.i("exitFunctionSubprogram: MS: " + megaStack.size());
    }
}
