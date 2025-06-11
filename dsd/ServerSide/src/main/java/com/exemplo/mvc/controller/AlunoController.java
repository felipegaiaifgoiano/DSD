package com.exemplo.mvc.controller;

import com.exemplo.mvc.model.Aluno;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Arrays;
import java.util.List;

@Controller
public class AlunoController {

    @GetMapping("/alunos")
    public String listarAlunos(Model model) {
        List<Aluno> alunos = Arrays.asList(
            new Aluno("Ana", "Engenharia"),
            new Aluno("Carlos", "Direito"),
            new Aluno("Fernanda", "Medicina")
        );

        model.addAttribute("alunos", alunos);
        return "alunos";
    }
}