package com.example.demo;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletRegistration;

public class DemoApplication implements WebApplicationInitializer {
    
    @Override
    public void onStartup(ServletContext container) {
        AnnotationConfigWebApplicationContext context = new AnnotationConfigWebApplicationContext();
        context.register(WebConfig.class);
        
        ServletRegistration.Dynamic registration = container.addServlet("dispatcher", new DispatcherServlet(context));
        registration.setLoadOnStartup(1);
        registration.addMapping("/");
    }
}