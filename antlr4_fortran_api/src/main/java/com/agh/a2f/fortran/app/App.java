package com.agh.a2f.fortran.app;

import com.agh.a2f.fortran.app.translators.AllLLVMTranslator;
import com.agh.a2f.fortran.generated.fortran77Lexer;
import com.agh.a2f.fortran.generated.fortran77Parser;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.misc.Interval;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.ParseTreeWalker;

import java.io.IOException;

import static org.bytedeco.javacpp.LLVM.*;

public class App {

    public static void main(String[] args) throws IOException {
        String path = "src/main/resources/code/fortran/xfunc.f90";
//        String path = "src/main/resources/code/fortran/doLoop.f90";
//        String path = "src/main/resources/code/fortran/doLoops.f";
//        String path = "src/main/resources/code/fortran/write.f90";
//        String path = "src/main/resources/code/fortran/addExample.f";


        System.out.println("===================== FORTRAN FILE ======================");
        CharStream i = CharStreams.fromFileName(path);
        System.out.print(i.getText(new Interval(0, i.size())));

        App app = new App();
        app.start(i);


    }

    public String start(String fortranCode){
        CharStream i = CharStreams.fromString(fortranCode);
        return start(i);
    }

    private String start(CharStream is) {
        try {
            System.out.println("===================== TRANSLATE ======================");
            fortran77Lexer lexer = new fortran77Lexer(is);

            fortran77Parser parser = new fortran77Parser(new CommonTokenStream(lexer));

//            parser.addParseListener(new Listener());

            ParseTree tree = parser.program();

            ParseTreeWalker walker = new ParseTreeWalker();

            CommonTokenStream tokens = new CommonTokenStream(lexer);

//            AssignmentAndArithmeticTranslator llvmTranslator = new AssignmentAndArithmeticTranslator(tokens);
            AllLLVMTranslator llvmTranslator = new AllLLVMTranslator(tokens);

            walker.walk(llvmTranslator, tree);

            return llvmTranslator.getResult();

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

}
