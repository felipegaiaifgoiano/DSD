package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.example.demo.model.*;
import com.example.demo.repository.*;

@Controller
public class ProdutoController
{
    private final ProdutoRepository produtos;
    private final CategoriaRepository categorias;

    public ProdutoController(
        ProdutoRepository produtos,
        CategoriaRepository categorias)
    {
        this.produtos = produtos;
        this.categorias = categorias;
    }

    @GetMapping("/")
    public String index(
        Model model)
    {
        model.addAttribute(
            "produtos",
            produtos.findAll());

        model.addAttribute(
            "categorias",
            categorias.findAll());

        return "produtos";
    }

    @PostMapping("/salvar")
    public String salvar(
        String nome,
        Long categoriaId)
    {
        Categoria categoria =
            categorias.findById(
                categoriaId).orElse(null);

        Produto p =
            new Produto();

        p.setNome(nome);

        p.setCategoria(categoria);

        produtos.save(p);

        return "redirect:/";
    }
}