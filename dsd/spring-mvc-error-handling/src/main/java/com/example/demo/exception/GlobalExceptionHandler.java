package com.example.demo.exception;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public String handleException(Exception ex, HttpServletRequest request, Model model) {
        model.addAttribute("error", ex.getMessage());
        model.addAttribute("status", HttpStatus.INTERNAL_SERVER_ERROR.value());
        model.addAttribute("path", request.getRequestURI());
        return "error/500";
    }

    @ExceptionHandler(CustomException.class)
    public String handleCustomException(CustomException ex, HttpServletRequest request, Model model) {
        model.addAttribute("error", ex.getMessage());
        model.addAttribute("status", ex.getStatus().value());
        model.addAttribute("path", request.getRequestURI());
        return "error/custom-error";
    }
}	