package com.agh.a2f.fortran.app;

import com.agh.a2f.fortran.app.translators.AllLLVMTranslator;
import com.agh.a2f.fortran.generated.fortran77Lexer;
import com.agh.a2f.fortran.generated.fortran77Parser;
import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.misc.Interval;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.ParseTreeWalker;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

import static org.bytedeco.javacpp.LLVM.*;

public class App {

    public static void main(String[] args) throws IOException {
        String path = "code/fortran/doLoop.f90";
//        String path = "code/fortran/write.f90";
//        String path = "code/fortran/addExample.f";


        System.out.println("===================== FORTRAN FILE ======================");
        CharStream i = CharStreams.fromFileName(path);
        System.out.print(i.getText(new Interval(0, i.size())));

        App app = new App();
        app.start(i);

//        IrBuilderExample.executeExample();

    }

    private void start(CharStream is) {
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





//            f_to_py translator = new f_to_py(tokens);
//            walker.walk(translator, tree);
            System.out.println(); // print a \n after translation


//            System.out.println("===================== END 2  ======================");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    static void blankModule() {
        LLVMModuleRef myModule = LLVMModuleCreateWithName("myModule");

    }


}
