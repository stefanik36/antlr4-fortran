package com.compilers.antlr4_fortran_backend.service;

import com.agh.a2f.fortran.app.App;
import com.compilers.antlr4_fortran_backend.model.Request;
import com.compilers.antlr4_fortran_backend.model.Response;
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
