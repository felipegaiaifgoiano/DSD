<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>Lista de Alunos</title>
</head>
<body>
    <h1>Alunos</h1>
    <ul>
        <c:forEach var="aluno" items="${alunos}">
            <li><strong>${aluno.nome}</strong> - ${aluno.curso}</li>
        </c:forEach>
    </ul>
</body>
</html>
