<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<html>
<head>
    <title>500 - Erro interno</title>
</head>
<body>
    <h1>Erro ${status} - Erro interno do servidor</h1>
    <p>${error}</p>
    <p>Path: ${path}</p>
    <a href="/">Voltar para a página inicial</a>
</body>
</html>