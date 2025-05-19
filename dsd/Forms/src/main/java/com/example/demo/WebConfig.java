package com.example.demo;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ViewResolverRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration          // Indica que esta é uma classe de configuração Spring
@EnableWebMvc           // Habilita o Spring MVC
@ComponentScan(basePackages = "com.example.demo") // Escaneia componentes neste pacote
public class WebConfig implements WebMvcConfigurer {
    
    @Override
    public void configureViewResolvers(ViewResolverRegistry registry) {
        registry.jsp("/WEB-INF/views/", ".jsp"); // Configura JSP como view resolver
    }
}