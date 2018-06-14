package com.compilers.antlr4_fortran.util.app.util;

public class Function {
    public static boolean isFunction(String expression) {
        return expression.matches("[a-zA-Z0-9]*\\(.*\\)");
    }

    public static String getFunctionName(String str) {
        return str.split("\\(")[0];
    }
}
