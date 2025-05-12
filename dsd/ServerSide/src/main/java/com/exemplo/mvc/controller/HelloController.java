package com.exemplo.mvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import com.exemplo.mvc.model.*;

@Controller
@RequestMapping("/hello")
public class HelloController {

    @GetMapping
    public String sayHello(Model model) {
        model.addAttribute("message", "Olá, mundo!");
        return "hello";
    }

    @GetMapping("/saudacao")
    public String saudacao(@RequestParam String nome, Model model) {
        model.addAttribute("mensagem", "Olá, " + nome);
        return "saudacao";
    }

    @GetMapping("/produto/{id}")
    public String getProduto(@PathVariable Long id, Model model) {
        model.addAttribute("id", id);
        return "produto";
    }

    @PostMapping("/cadastro")
    public String cadastrar(@ModelAttribute Usuario usuario, Model model) {
        model.addAttribute("usuario", usuario);
        return "resultado";
    }

    @GetMapping("/calculadora")
    public String somar(@RequestParam int a, @RequestParam int b, Model model) {
        int resultado = a + b;
        model.addAttribute("resultado", resultado);
        return "resultado";
    }
}
