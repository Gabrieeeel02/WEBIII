package com.gabrielcorrea.ProjetoFinal.control;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWordController {

    @GetMapping("/")
    public String index(){ return "Seja Bem vindo ao Sistema API Teste";}

}
