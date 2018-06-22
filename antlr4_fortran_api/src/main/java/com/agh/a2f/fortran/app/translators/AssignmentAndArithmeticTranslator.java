package com.agh.a2f.fortran.app.translators;

import com.agh.a2f.fortran.app.util.Arithmetic;
import com.agh.a2f.fortran.app.util.Function;
import com.agh.a2f.fortran.app.util.Variable;
import com.agh.a2f.fortran.generated.fortran77Parser;
import com.stefanik.cod.controller.COD;
import com.stefanik.cod.controller.CODFactory;
import org.antlr.v4.runtime.BufferedTokenStream;
import org.antlr.v4.runtime.RuleContext;
import org.antlr.v4.runtime.tree.ParseTree;
import org.bytedeco.javacpp.BytePointer;
import org.bytedeco.javacpp.PointerPointer;

import java.util.*;
import java.util.stream.Collectors;

import static org.bytedeco.javacpp.LLVM.*;

abstract class AssignmentAndArithmeticTranslator extends LLVMBaseTranslator {
    private static final COD cod = CODFactory.get();


    //    private static Integer arithmeticStackIterator = 0;//TODO
    private Stack<List<String>> arithmeticComponentsStack = new Stack<>();
    private Map<String, LLVMValueRef> arithmeticMapResults = new HashMap<>();

    public AssignmentAndArithmeticTranslator(BufferedTokenStream tokens) {
        super(tokens);
    }

    /////////**START** ASSIGNMENT BLOCK


    @Override
    public void enterAssignmentStatement(fortran77Parser.AssignmentStatementContext ctx) {
        megaStack.startSection();
    }

    @Override
    public void exitAssignmentStatement(fortran77Parser.AssignmentStatementContext ctx) {
        if (ctx.expression() != null) {

            LLVMValueRef llvmValueRef = null;
            String strVal = ctx.expression().getText();
            if (Variable.isString(strVal)) {
                String val = Variable.getStringValue(strVal);
                llvmValueRef = LLVMConstString(val, val.length(), 1);
            } else if (Variable.isInteger(strVal)) {
                llvmValueRef = LLVMConstInt(LLVMInt32Type(), Variable.getIntegerValue(strVal), 0);
            } else if (Variable.isInMap(strVal, valueRefs)) {
                llvmValueRef = LLVMBuildLoad(builder, Variable.getFromMap(strVal, valueRefs), "");
            }
            else {
                llvmValueRef = megaStack.popValue();
//                throw new RuntimeException("Right side can't be compute. llvmValueRef is null");
            }
            //Something else pushed/will push it to the megaStack?

            String name = preventFuncName(ctx.varRef().getText());
            LLVMValueRef var = valueRefs.get(name);
            if(var == null)
                throw new RuntimeException("Variable named '" + name + "' not allocated!");
            LLVMBuildStore(builder, llvmValueRef, var);

        }
        megaStack.endSection();
    }


    @Override
    public void enterAexpr0(fortran77Parser.Aexpr0Context ctx) {
        if (ctx.aexpr1().size() > 1) {
            megaStack.startSection();
            arithmeticComponentsStack.push(ctx.aexpr1().stream()
                    .map(RuleContext::getText)
                    .collect(Collectors.toList())
            );
        }
    }


    @Override
    public void exitAexpr0(fortran77Parser.Aexpr0Context ctx) {
        if (ctx.aexpr1() != null && ctx.aexpr1().size() > 1) {
            List<String> componentsStrings = arithmeticComponentsStack.pop();

            List<LLVMValueRef> components = getArithmeticComponents(componentsStrings, arithmeticMapResults);

            List<String> operators = ctx.children.stream()
                    .map(ParseTree::getText)
                    .filter(c -> c.equals("+") || c.equals("-"))
                    .collect(Collectors.toList());

            LLVMValueRef val = Arithmetic.resolveAddAndSub(components, operators, builder);
            cod.c().off().i("\t[" + megaStack.size() + "]PUSH ADD/SUB:  " + val.address());
//            LLVMBuildLoad(builder, val, "");

            megaStack.push(val);
            arithmeticMapResults.put(ctx.getText(), val);

            LLVMValueRef result = megaStack.popValue();
            megaStack.endSection();
            megaStack.push(result);
        }

    }

    @Override
    public void enterAexpr1(fortran77Parser.Aexpr1Context ctx) {
        if (ctx.aexpr2().size() > 1) {
            arithmeticComponentsStack.push(ctx.aexpr2().stream()
                    .map(RuleContext::getText)
                    .collect(Collectors.toList())
            );
        }
    }


    @Override
    public void exitAexpr1(fortran77Parser.Aexpr1Context ctx) {
        if (ctx.aexpr2() != null && ctx.aexpr2().size() > 1) {
            List<String> componentsStrings = arithmeticComponentsStack.pop();

            List<LLVMValueRef> components = getArithmeticComponents(componentsStrings, arithmeticMapResults);

            List<String> operators = ctx.children.stream()
                    .map(ParseTree::getText)
                    .filter(c -> c.equals("*") || c.equals("/"))
                    .collect(Collectors.toList());

            LLVMValueRef val = Arithmetic.resolveMulAndDiv(components, operators, builder);
            cod.c().off().i("\t[" + megaStack.size() + "]PUSH MUL/DIV: " + val.address());

            megaStack.push(val);
            arithmeticMapResults.put(ctx.getText(), val);

        }
    }

    @Override
    public void enterAexpr3(fortran77Parser.Aexpr3Context ctx) {
        if (ctx.aexpr4().size() > 1) {
            arithmeticComponentsStack.push(ctx.aexpr4().stream()
                    .map(RuleContext::getText)
                    .collect(Collectors.toList())
            );
        }
    }


    @Override
    public void exitAexpr3(fortran77Parser.Aexpr3Context ctx) {
        if (ctx.aexpr4() != null && ctx.aexpr4().size() > 1) {
            List<String> componentsStrings = arithmeticComponentsStack.pop();

            List<LLVMValueRef> components = getArithmeticComponents(componentsStrings, arithmeticMapResults);

            List<String> operators = ctx.children.stream()
                    .map(ParseTree::getText)
                    .filter(c -> c.equals("**"))
                    .collect(Collectors.toList());

            LLVMValueRef val = Arithmetic.resolvePow(components, operators, builder);
            cod.c().off().i("\t[" + megaStack.size() + "]PUSH  POWER: " + val.address());
            megaStack.push(val);
            arithmeticMapResults.put(ctx.getText(), val);

        }
    }


    private List<LLVMValueRef> getArithmeticComponents(List<String> componentsStrings, Map<String, LLVMValueRef> resultsMap) {
        List<LLVMValueRef> components = new ArrayList<>();
        for (String c : componentsStrings) {
            String strVal = preventFuncName(Arithmetic.removeBrackets(c));

            LLVMValueRef llvmValueRef = null;
            if (Variable.isInteger(strVal)) {
                llvmValueRef = LLVMConstInt(LLVMInt32Type(), Variable.getIntegerValue(strVal), 0);
            } else if (Variable.isInMap(strVal, valueRefs)) {
                llvmValueRef = LLVMBuildLoad(builder, Variable.getFromMap(strVal, valueRefs), "");
            } else if (Variable.isInMap(strVal, resultsMap)) {
                llvmValueRef = Variable.getFromMap(strVal, resultsMap);
//                    resultsMap.remove(strVal);//TODO remove from map {String, Id}
            } else {
                llvmValueRef = megaStack.popValue(); //TODO check this out
//                throw new RuntimeException("no values in map");
            }
            components.add(llvmValueRef);
        }
        return components;
    }


}
