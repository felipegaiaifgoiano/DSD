package com.example.demo.controller;

import com.example.demo.exception.CustomException;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class HomeController {

    @GetMapping("/")
    public String home(Model model) {
        model.addAttribute("message", "Bem-vindo ao Spring MVC!");
        return "home";
    }

    @GetMapping("/trigger-error/{code}")
    public String triggerError(@PathVariable int code) {
        switch (code) {
            case 400:
                throw new CustomException("Requisição inválida", HttpStatus.BAD_REQUEST);
            case 403:
                throw new CustomException("Acesso negado", HttpStatus.FORBIDDEN);
            case 404:
                throw new CustomException("Recurso não encontrado", HttpStatus.NOT_FOUND);
            case 500:
                throw new RuntimeException("Erro interno do servidor");
            default:
                throw new CustomException("Erro desconhecido", HttpStatus.I_AM_A_TEAPOT);
        }
    }
}