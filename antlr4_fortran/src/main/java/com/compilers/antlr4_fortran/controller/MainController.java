package com.compilers.antlr4_fortran.controller;


import com.compilers.antlr4_fortran.model.Request;
import com.compilers.antlr4_fortran.model.Response;
import com.compilers.antlr4_fortran.service.MainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/api/main")
public class MainController {
    private final MainService service;

    @Autowired
    public MainController(MainService service) {
        this.service = service;
    }

    @RequestMapping(value = "/run", method = RequestMethod.POST)
    public ResponseEntity<?> search(
            @RequestBody Request fortran
    ) {
        Response r = service.run(fortran);
        return new ResponseEntity<>(r, HttpStatus.OK);
    }
}
