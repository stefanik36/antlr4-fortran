package com.compilers.antlr4_fortran.util.app.util;

import org.bytedeco.javacpp.LLVM;

import java.util.Map;

public class Variable {
    public static boolean isString(String expression) {
        return expression.matches("'.*'");
    }

    public static String getStringValue(String str) {
        return str.substring(1, str.length() - 1);
    }

    public static boolean isInteger(String strVal) {
        try {
            Integer.valueOf(strVal);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    public static Integer getIntegerValue(String strVal) {
        return Integer.valueOf(strVal);
    }

    public static boolean isInMap(String strVal, Map<String,LLVM.LLVMValueRef> functions) {
       return functions.containsKey(strVal);
    }

    public static LLVM.LLVMValueRef getFromMap(String strVal, Map<String,LLVM.LLVMValueRef> functions) {
        return functions.get(strVal);
    }
}
