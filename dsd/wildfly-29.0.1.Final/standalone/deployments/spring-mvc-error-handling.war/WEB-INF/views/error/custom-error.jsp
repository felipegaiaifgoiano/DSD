<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<html>
<head>
    <title>Erro ${status}</title>
</head>
<body>
    <h1>Erro ${status}</h1>
    <p>${error}</p>
    <p>Path: ${path}</p>
    <a href="/">Voltar para a página inicial</a>
</body>
</html>