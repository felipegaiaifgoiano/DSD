package com.example.demo;

import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletRegistration;
import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

public class DemoApplication implements WebApplicationInitializer {

    @Override
    public void onStartup(ServletContext servletContext) {
        // 1. Cria o contexto da aplicação Spring
        AnnotationConfigWebApplicationContext context = new AnnotationConfigWebApplicationContext();
        
        // 2. Registra a classe de configuração WebConfig
        context.register(WebConfig.class);
        
        // 3. Cria e configura o DispatcherServlet (front controller do Spring MVC)
        DispatcherServlet dispatcherServlet = new DispatcherServlet(context);
        
        // 4. Registra o DispatcherServlet no container Servlet
        ServletRegistration.Dynamic registration = servletContext.addServlet("dispatcher", dispatcherServlet);
        
        // 5. Configurações do Servlet
        registration.setLoadOnStartup(1); // Prioridade de inicialização
        registration.addMapping("/");     // Mapeia todas as URLs para o Spring MVC
        
        // (Opcional) Configuração para tratamento de exceções
        registration.setInitParameter("throwExceptionIfNoHandlerFound", "true");
    }
}