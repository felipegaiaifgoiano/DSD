package com.example.errorhandling;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.HttpStatus;

@Controller
@RequestMapping("/error-demo")
class ErrorController {
    @GetMapping("/not-found")
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public String notFound() {
        return "error/404";
    }

    @GetMapping("/forbidden")
    @ResponseStatus(HttpStatus.FORBIDDEN)
    public String forbidden() {
        return "error/403";
    }

    @GetMapping("/server-error")
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public String serverError() {
        return "error/500";
    }

    @GetMapping("/bad-request")
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public String badRequest() {
        return "error/400";
    }

    @GetMapping("/unauthorized")
    @ResponseStatus(HttpStatus.UNAUTHORIZED)
    public String unauthorized() {
        return "error/401";
    }

    @GetMapping("/conflict")
    @ResponseStatus(HttpStatus.CONFLICT)
    public String conflict() {
        return "error/409";
    }

    @GetMapping("/custom-exception")
    public void throwCustomException() {
        throw new CustomException("Este é um erro customizado");
    }
}