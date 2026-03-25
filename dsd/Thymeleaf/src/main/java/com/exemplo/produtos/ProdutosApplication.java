package com.exemplo.produtos;

import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletRegistration;
import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;
import org.springframework.web.context.ContextLoaderListener;

public class ProdutosApplication implements WebApplicationInitializer {

    @Override
    public void onStartup(ServletContext servletContext) {
        // 1. Cria o contexto da aplicação Spring e registra a configuração Java
        AnnotationConfigWebApplicationContext context = new AnnotationConfigWebApplicationContext();
        context.register(WebConfig.class); 
        context.setServletContext(servletContext);
        servletContext.addListener(new ContextLoaderListener(context));

        // 2. Cria e registra o DispatcherServlet
        DispatcherServlet dispatcherServlet = new DispatcherServlet(context);
        ServletRegistration.Dynamic registration = servletContext.addServlet("dispatcher", dispatcherServlet);

        // 3. Configura o DispatcherServlet
        registration.setLoadOnStartup(1);
        registration.addMapping("/");
        registration.setInitParameter("throwExceptionIfNoHandlerFound", "true");
     }
}