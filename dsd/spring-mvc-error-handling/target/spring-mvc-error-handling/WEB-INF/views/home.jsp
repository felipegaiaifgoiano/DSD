<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<html>
<head>
    <title>Spring MVC - Home</title>
</head>
<body>
    <h1>${message}</h1>
    
    <h2>Testar códigos de erro:</h2>
    <ul>
        <li><a href="trigger-error/400">400 Bad Request</a></li>
        <li><a href="trigger-error/403">403 Forbidden</a></li>
        <li><a href="trigger-error/404">404 Not Found</a></li>
        <li><a href="trigger-error/500">500 Internal Server Error</a></li>
    </ul>
</body>
</html>