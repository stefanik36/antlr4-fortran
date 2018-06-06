package com.agh.a2f.fortran.app;

import com.agh.a2f.fortran.app.translators.AllLLVMTranslator;
import com.agh.a2f.fortran.generated.fortran77Lexer;
import com.agh.a2f.fortran.generated.fortran77Parser;
import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
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
//        String path = "code/fortran/addExample.f";


        ArrayList<String> lines = Preprocessor.run(path);
        StringBuilder program = new StringBuilder();
        lines.forEach(l -> program.append(l).append("\n"));

        InputStream is = new ByteArrayInputStream(program.toString().getBytes());
        App app = new App();
        app.start(is);

//        IrBuilderExample.executeExample();

    }

    private void start(InputStream is) {
        try {
            System.out.println("===================== TRANSLATE ======================");
            ANTLRInputStream input = new ANTLRInputStream(is);

            fortran77Lexer lexer = new fortran77Lexer(input);

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
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    static void blankModule() {
        LLVMModuleRef myModule = LLVMModuleCreateWithName("myModule");

    }


}
