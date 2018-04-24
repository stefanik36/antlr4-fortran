package com.agh.a2f.fortran.app;

import com.agh.a2f.fortran.generated.fortran77Lexer;
import com.agh.a2f.fortran.generated.fortran77Parser;
import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;

import java.io.FileInputStream;
import java.io.IOException;

import static org.bytedeco.javacpp.LLVM.*;

public class App {

    public static void main(String[] args) {
        String path = "code/fortran/hello.f90";
//        String path = "code/fortran/fun01.f90";
        App app = new App();
        app.start(path);

//        IrBuilderExample.executeExample();

    }

    private void start(String path) {
        try {
            System.out.println("===================== START 2 ======================");

            ANTLRInputStream input = new ANTLRInputStream(
                    new FileInputStream(path));

            fortran77Lexer lexer = new fortran77Lexer(input);
            fortran77Parser parser = new fortran77Parser(new CommonTokenStream(lexer));
            parser.addParseListener(new Listener());

            // Start parsing
            parser.program();
            System.out.println("===================== END 2  ======================");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    static void blankModule() {
        LLVMModuleRef myModule = LLVMModuleCreateWithName("myModule");

    }


}
