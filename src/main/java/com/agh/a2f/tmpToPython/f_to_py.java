package com.agh.a2f.tmpToPython;

import com.agh.a2f.fortran.generated.fortran77BaseListener;
import com.agh.a2f.fortran.generated.fortran77Parser;
import org.antlr.v4.runtime.misc.Interval;
import org.antlr.v4.runtime.BufferedTokenStream;
import org.antlr.v4.runtime.Token;

public class f_to_py extends fortran77BaseListener {
    BufferedTokenStream tokens;
    public static String tempFuncName;


    public f_to_py(BufferedTokenStream tokens) {

        this.tokens = tokens;
    }


    @Override
    public void enterAssignmentStatement(fortran77Parser.AssignmentStatementContext ctx) {
        // TODO Auto-generated method stub
        super.enterAssignmentStatement(ctx);
        String temp = ctx.getText();
        String temp2;

        temp2 = temp.replace(".false.", "False").replace(".true.", "True");
        System.out.print(temp2);

    }

    @Override
    public void enterPrintStatement(fortran77Parser.PrintStatementContext ctx) {


        System.out.print("print ");
        String delims = "print";
        String tobeparsed = ctx.getText();
        String temp = tobeparsed.replace("*,", "");
        String[] tokens = temp.split(delims);


        for (int i = 1; i < tokens.length; ++i) {

            System.out.print(tokens[i]);


        }


    }


    @Override
    public void enterReadStatement(fortran77Parser.ReadStatementContext ctx) {
        String delims = "[read,,]+";
        String tobeparsed = ctx.getText();
        String[] tokens = tobeparsed.split(delims);


        for (int i = 1; i < tokens.length; ++i) {

            if (tokens[i].equals("*"))
                continue;
            else {
                System.out.print(tokens[i]);
                System.out.println(" = input(\" \")");
            }
        }
    }

    @Override
    public void enterSeos(fortran77Parser.SeosContext ctx) {
        System.out.println(" ");
    }


    @Override
    public void enterParamassign(fortran77Parser.ParamassignContext ctx) {
        // TODO Auto-generated method stub
        System.out.print(ctx.getText());
        System.out.print(ctx.getParent());
        //super.enterParamassign(ctx);
    }


    @Override
    public void enterDoVarArgs(fortran77Parser.DoVarArgsContext ctx) {

        String temp = ctx.getText();
        String temp2 = temp.replace("<missing '='>", " ");
        temp2 = temp2.replace("do", "");

        if (temp2.contains("while")) {
            System.out.print(temp2);
        } else {

            String delims = "=";
            String[] tokens = temp2.split(delims);

            System.out.print("for ");

            for (int i = 0; i < tokens.length; ++i) {
                if (i < 1) {
                    System.out.print(tokens[i]);
                    System.out.print(" in xrange(");
                } else {
                    System.out.print(tokens[i]);
                }

            }

            System.out.print(")");
        }

        System.out.print(": #loop");

    }

    @Override
    public void exitDoStatement(fortran77Parser.DoStatementContext ctx) {
        System.out.print("#end loop");
    }

    @Override
    public void enterFunctionStatement(fortran77Parser.FunctionStatementContext ctx) {
        String temp = ctx.getText().replace("function", "def ").replaceAll("real|integer|\n|\r\n", "") + ": #function";
        String token[] = temp.split("def ");
        String token2[] = token[1].split("\\(");
        tempFuncName = token2[0];
        System.out.print(temp);

    }


    @Override
    public void exitFunctionSubprogram(fortran77Parser.FunctionSubprogramContext ctx) {
        System.out.println("#end function");
    }

    @Override
    public void enterReturnStatement(fortran77Parser.ReturnStatementContext ctx) {
        System.out.println(ctx.getText() + " " + tempFuncName);
    }

    @Override
    public void enterCallStatement(fortran77Parser.CallStatementContext ctx) {

        String temp = ctx.getText().replace("call", "");
        System.out.print(temp);
    }

    @Override
    public void enterSubroutineStatement(fortran77Parser.SubroutineStatementContext ctx) {
        String temp = ctx.getText().replace("subroutine", "def ").replaceAll("real|integer|\n|\r\n", "") + ": #function";
        String token[] = temp.split("def ");
        String token2[] = token[1].split("\\(");
        tempFuncName = token2[0];
        System.out.print(temp);

    }

    @Override
    public void exitSubroutineSubprogram(fortran77Parser.SubroutineSubprogramContext ctx) {
        System.out.println("#end function");
    }

    @Override
    public void enterDataStatementEntity(fortran77Parser.DataStatementEntityContext ctx) {
// TODO Auto-generated method stub
        super.enterDataStatementEntity(ctx);
        String token1 = ctx.dse1().getText().replace("/", "");
        String token2 = ctx.dse2().getText().replace("/", "");
        System.out.println(token1 + "=" + token2);
    }
}//end of class
