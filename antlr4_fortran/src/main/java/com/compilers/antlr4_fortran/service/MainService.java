package com.compilers.antlr4_fortran.service;

import com.compilers.antlr4_fortran.model.Request;
import com.compilers.antlr4_fortran.model.Response;
import com.compilers.antlr4_fortran.util.app.App;
import com.compilers.antlr4_fortran.util.app.Preprocessor;
import org.springframework.stereotype.Service;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.ArrayList;

@Service
public class MainService {


    public Response run(Request fortran) {
        Response response = new Response();
        System.out.println(fortran);

        ArrayList<String> lines = Preprocessor.runString(fortran.getFortranCode());
        StringBuilder program = new StringBuilder();
        lines.forEach(l -> program.append(l).append("\n"));

        InputStream is = new ByteArrayInputStream(program.toString().getBytes());
        App app = new App();
        app.start(is);


        //TODO

        response.setLlvm("LLVM \nCODE");
        response.setResult("RESULT \nDATA");

        return response;
    }
}
