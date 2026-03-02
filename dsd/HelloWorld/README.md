# Spring MVC + Thymeleaf

Exemplo simples de aplicação Web usando Spring MVC (sem Spring Boot) e Thymeleaf.

## Rotas

- / → página estática
- /hello → página dinâmica com dados do controller

## Como funciona

O Controller recebe a requisição e retorna uma view Thymeleaf.
A página dinâmica recebe dados via Model.

## Executar no WildFly

1. mvn clean package
2. Deploy do arquivo .war no WildFly
3. Acessar:
   - / → estática
   - /hello → dinâmica
