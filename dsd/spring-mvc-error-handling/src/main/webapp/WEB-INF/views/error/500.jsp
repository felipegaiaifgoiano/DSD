<!DOCTYPE html>
<html xmlns:th="http://www.thymeleaf.org">
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