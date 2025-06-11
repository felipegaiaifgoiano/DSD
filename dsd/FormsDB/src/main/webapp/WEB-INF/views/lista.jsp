<%@ include file="header.jspf" %>

<!DOCTYPE html>
<html lang="pt-BR">
<head>
    <meta charset="UTF-8" />
    <title>Lista de Produtos</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css" />
</head>
<body>
    <main>
        <h2>Produtos Cadastrados</h2>
        <table class="produtos-tabela">
            <thead>
                <tr>
                    <th>ID</th>
                    <th>Nome</th>
                    <th>Descrição</th>
                    <th>Preço (R$)</th>
                    <th>Arquivo</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach var="p" items="${produtos}">
                    <tr>
                        <td>${p.id}</td>
                        <td>${p.nome}</td>
                        <td>${p.descricao}</td>
                        <td>${p.preco}</td>
                        <td>
                            <c:if test="${not empty p.nomeArquivo}">
                                <a href="${pageContext.request.contextPath}/uploads/${p.nomeArquivo}" target="_blank" rel="noopener noreferrer">${p.nomeArquivo}</a>
                            </c:if>
                            <c:if test="${empty p.nomeArquivo}">
                                -
                            </c:if>
                        </td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
        <a class="btn-voltar" href="${pageContext.request.contextPath}/">Voltar</a>
    </main>
<%@ include file="footer.jspf" %>
</body>
</html>