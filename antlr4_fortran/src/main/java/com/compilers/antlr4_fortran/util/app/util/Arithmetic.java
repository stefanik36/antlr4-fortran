package com.compilers.antlr4_fortran.util.app.util;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import static org.bytedeco.javacpp.LLVM.*;

public class Arithmetic {


    public static LLVMValueRef resolveAddAndSub(List<LLVMValueRef> components, List<String> operators, LLVMBuilderRef builder) {
//        LLVMValueRef fVal = LLVMBuildLoad(builder, components.get(0),"");
        LLVMValueRef fVal = components.get(0);
        for (int i = 0; i < components.size() - 1; i++) {
            String op = operators.get(i);
            if ("+".equals(op)) {
                fVal = LLVMBuildAdd(builder, fVal, components.get(i + 1), i + op);
            } else if ("-".equals(op)) {
                fVal = LLVMBuildSub(builder, fVal, components.get(i + 1), i + op);
            } else {
                throw new RuntimeException("Unknown operator.");
            }
        }
        return fVal;
    }

    public static LLVMValueRef resolveMulAndDiv(List<LLVMValueRef> components, List<String> operators, LLVMBuilderRef builder) {
        LLVMValueRef fVal = components.get(0);
        for (int i = 0; i < components.size() - 1; i++) {
            String op = operators.get(i);
            if ("*".equals(op)) {
                fVal = LLVMBuildMul(builder, fVal, components.get(i + 1), i + op);
            } else if ("/".equals(op)) {
                fVal = LLVMBuildSDiv(builder, fVal, components.get(i + 1), i + op);
            } else {
                throw new RuntimeException("Unknown operator.");
            }
        }
        return fVal;
    }

    public static LLVMValueRef resolvePow(List<LLVMValueRef> components, List<String> operators, LLVMBuilderRef builder) {
        LLVMValueRef fVal = components.get(0);
        for (int i = 0; i < components.size() - 1; i++) {
            String op = operators.get(i);
            if ("**".equals(op)) {
                fVal = LLVMBuildNSWMul(builder, fVal, components.get(i + 1), i + op);//TODO POWER
            } else {
                throw new RuntimeException("Unknown operator.");
            }
        }
        return fVal;
    }

    public static Optional<LLVMValueRef> findValue(String name, Map<String, LLVMValueRef> functions, LLVMBuilderRef builder) {
        try {
            Integer val = Integer.valueOf(name);
            //TODO other types
            return Optional.ofNullable(LLVMConstInt(LLVMInt32Type(), val, 0));
        } catch (Exception e) {
            return Optional.ofNullable(LLVMBuildLoad(builder, functions.get(name), ""));
        }
    }

    public static String removeBrackets(String c) {
        String component = c;
        if (c.matches("\\(.*\\)")) {
            component = c.substring(1, c.length() - 1);
        }
        return component;
    }


}
