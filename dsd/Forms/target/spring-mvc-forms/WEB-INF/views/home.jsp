<!DOCTYPE html>
<html xmlns:th="http://www.thymeleaf.org">
<head>
    <meta charset="UTF-8">
    <title>Exemplo Spring MVC</title>
</head>
<body>
    <h1 th:text="${mensagem}">Mensagem padrão</h1>
    
    <!-- Formulario GET -->
    <h2>Teste GET</h2>
    <form action="/spring-mvc-forms/exemplo-get" method="get">
        <input type="text" name="nome" placeholder="Digite seu nome">
        <button type="submit">Enviar via GET</button>
    </form>
    
    <!-- Formulario POST -->
    <h2>Teste POST</h2>
    <form action="/spring-mvc-forms/exemplo-post" method="post">
        <input type="text" name="usuario" placeholder="Nome de usuario">
        <button type="submit">Enviar via POST</button>
    </form>
    
    <!-- Links para outras funcionalidades -->
    <p>
        <a href="/spring-mvc-forms/sessao">Ver sessao</a> | 
        <a href="/spring-mvc-forms/cookie">Ver cookie</a> | 
        <a href="/spring-mvc-forms/logout">Logout</a>
    </p>
</body>
</html>