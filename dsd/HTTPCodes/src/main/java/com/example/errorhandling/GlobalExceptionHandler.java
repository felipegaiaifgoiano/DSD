package com.example.errorhandling;

import org.springframework.web.bind.annotation.*;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.ui.Model;

@ControllerAdvice
class GlobalExceptionHandler {
    @ExceptionHandler(CustomException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public String handleCustomException(CustomException ex, Model model) {
        model.addAttribute("message", ex.getMessage());
        return "error/custom-error";
    }
}