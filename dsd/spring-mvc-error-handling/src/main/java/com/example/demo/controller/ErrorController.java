package com.example.demo.controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ErrorController {

    @RequestMapping("/error")
    public String handleError(HttpServletRequest request, Model model) {
        Object status = request.getAttribute(RequestDispatcher.ERROR_STATUS_CODE);
        
        if (status != null) {
            int statusCode = Integer.parseInt(status.toString());
            
            if (statusCode == HttpStatus.NOT_FOUND.value()) {
                model.addAttribute("error", "Página não encontrada");
                model.addAttribute("status", statusCode);
                model.addAttribute("path", request.getAttribute(RequestDispatcher.ERROR_REQUEST_URI));
                return "error/404";
            } else if (statusCode == HttpStatus.INTERNAL_SERVER_ERROR.value()) {
                model.addAttribute("error", "Erro interno do servidor");
                model.addAttribute("status", statusCode);
                model.addAttribute("path", request.getAttribute(RequestDispatcher.ERROR_REQUEST_URI));
                return "error/500";
            }
        }
        
        model.addAttribute("error", "Ocorreu um erro");
        model.addAttribute("status", "Erro desconhecido");
        model.addAttribute("path", request.getAttribute(RequestDispatcher.ERROR_REQUEST_URI));
        return "error/custom-error";
    }
}