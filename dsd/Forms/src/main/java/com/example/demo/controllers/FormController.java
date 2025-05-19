package com.example.demo.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@Controller
public class FormController {

    // Rota raiz - Página inicial
	@GetMapping("/")
    public String home(Model model) {
        model.addAttribute("mensagem", "Bem-vindo ao exemplo Spring MVC!");
        return "home";
    }

    // Exemplo de GET simples
    @GetMapping("/exemplo-get")
    public String exemploGet(@RequestParam(name = "nome", required = false, defaultValue = "Visitante") String nome, Model model) {
    	System.out.println("Método executado! Nome: " + nome); // Para debug
    	model.addAttribute("mensagem", "Olá, " + nome + "! Este é um exemplo de GET.");
        return "home";
    }

    // Exemplo de POST simples
    @PostMapping("/exemplo-post")
    public String exemploPost(@RequestParam String usuario, Model model, HttpSession session) {
        // Armazenando na sessão
        session.setAttribute("usuarioLogado", usuario);
        
        model.addAttribute("mensagem", "Bem-vindo, " + usuario + "! Seu login foi realizado via POST.");
        return "home";
    }

    // Exemplo de manipulação de sessão
    @GetMapping("/sessao")
    public String exemploSessao(HttpSession session, Model model) {
        String usuario = (String) session.getAttribute("usuarioLogado");
        
        if (usuario != null) {
            model.addAttribute("mensagem", "Usuário na sessão: " + usuario);
        } else {
            model.addAttribute("mensagem", "Nenhum usuário na sessão.");
        }
        
        return "home";
    }

    // Exemplo de manipulação de cookies
    @GetMapping("/cookie")
    public String exemploCookie(HttpServletRequest request, HttpServletResponse response, Model model) {
        // Lendo cookies
        Cookie[] cookies = request.getCookies();
        int contadorVisitas = 0;

        if (cookies != null) {
            for (Cookie cookie : cookies) {
                if ("contador".equals(cookie.getName())) {
                    contadorVisitas = Integer.parseInt(cookie.getValue());
                    break;
                }
            }
        }

        // Incrementando contador
        contadorVisitas++;

        // Criando novo cookie
        Cookie novoCookie = new Cookie("contador", String.valueOf(contadorVisitas));
        novoCookie.setMaxAge(60 * 60 * 24 * 7); // 1 semana
        response.addCookie(novoCookie);

        model.addAttribute("mensagem", "Você visitou esta página " + contadorVisitas + " vezes.");
        return "home";
    }

    // Página para limpar sessão
    @GetMapping("/logout")
    public String logout(HttpSession session) {
        session.invalidate();
        return "redirect:/exemplo-get";
    }
}