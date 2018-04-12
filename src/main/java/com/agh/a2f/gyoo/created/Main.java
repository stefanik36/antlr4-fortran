package com.agh.a2f.gyoo.created;

import com.agh.a2f.gyoo.generated.GYOOLexer;
import com.agh.a2f.gyoo.generated.GYOOParser;
import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;

import java.io.FileInputStream;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        try {
            String path = "code/gyoo/p01.gyoo";

            ANTLRInputStream input = new ANTLRInputStream(
                    new FileInputStream(path));

            GYOOLexer lexer = new GYOOLexer(input);
            GYOOParser parser = new GYOOParser(new CommonTokenStream(lexer));
            parser.addParseListener(new MyListener());

            // Start parsing
            parser.program();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
