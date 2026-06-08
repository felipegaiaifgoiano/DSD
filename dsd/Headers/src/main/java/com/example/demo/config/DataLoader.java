package com.example.demo.config;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.example.demo.model.Categoria;
import com.example.demo.repository.CategoriaRepository;

@Configuration
public class DataLoader
{
    @Bean
    CommandLineRunner carregar(
        CategoriaRepository repo)
    {
        return args ->
        {
            if (repo.count() == 0)
            {
                Categoria c1 =
                    new Categoria();

                c1.setNome(
                    "Informática");

                repo.save(c1);

                Categoria c2 =
                    new Categoria();

                c2.setNome(
                    "Games");

                repo.save(c2);

                Categoria c3 =
                    new Categoria();

                c3.setNome(
                    "Escritório");

                repo.save(c3);
            }
        };
    }
}