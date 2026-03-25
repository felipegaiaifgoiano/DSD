package com.exemplo.produtos.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import java.util.List;

// Controlador -> próximas aulas
@Controller
public class PaginaController {
 	
	// GET -> próximas aulas
    @GetMapping("/")
    public String homePage(Model model) {

    	// Exemplo 1
        model.addAttribute("nome", "Felipe");
        
        // Exemplos 2 e 7
        model.addAttribute("vip", true);
        
        // Exemplo 3
        List<String> produtos = List.of("Cadeira", "Mesa", "Notebook");
        model.addAttribute("produtos", produtos);

        // Exemplo 5
        Produto p1 = new Produto();
        p1.nome ="Geladeira";
        p1.preco = "2099.10";

        Produto p2 = new Produto();
        p2.nome ="Fogão";
        p2.preco = "579.39";
        
        Produto p3 = new Produto();
        p3.nome ="Microondas";
        p3.preco = "899.99";

        List<Produto> produtosC = List.of(p1, p2, p3);
        model.addAttribute("produtosC", produtosC);
        
        // Exemplo 6
        model.addAttribute("cliente", new Cliente("João","john@gmail.com"));

    	return "index";
    }
    
    // POST -> próximas aulas
    @PostMapping("/salvar")
    public String salvar(@ModelAttribute Cliente cliente) {
        return "index";
    }
}