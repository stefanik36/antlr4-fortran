package com.compilers.antlr4_fortran_backend.controller;


import com.compilers.antlr4_fortran_backend.model.Request;
import com.compilers.antlr4_fortran_backend.model.Response;
import com.compilers.antlr4_fortran_backend.service.MainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/api/main")
public class MainController {
    private final MainService service;

    @Autowired
    public MainController(MainService service) {
        this.service = service;
    }

    @CrossOrigin(origins = "http://localhost:8000")
    @RequestMapping(value = "/run", method = RequestMethod.POST)
    public ResponseEntity<?> search(
            @RequestBody Request fortran
    ) {
        Response r = service.run(fortran);
        return new ResponseEntity<>(r, HttpStatus.OK);
    }
}
