package com.compilers.antlr4_fortran.service;

import com.compilers.antlr4_fortran.model.Request;
import com.compilers.antlr4_fortran.model.Response;
import com.compilers.antlr4_fortran.util.app.App;
import org.springframework.stereotype.Service;

@Service
public class MainService {


    public Response run(Request fortran) {
        Response response = new Response();
        System.out.println(fortran);

        App app = new App();
        String llvm = app.start(fortran.getFortranCode());


        //TODO
        response.setLlvm(llvm);
        response.setResult("RESULT \nDATA");

        return response;
    }
}
