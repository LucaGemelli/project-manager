<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="pt-BR">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Lista de Projetos</title>
    <link rel="stylesheet" href="/webjars/bootstrap/5.3.0/css/bootstrap.min.css">
    <script src="/webjars/bootstrap/5.3.0/js/bootstrap.bundle.min.js"></script>
</head>
<body>

<div class="container mt-4">
    <h1>Lista de Projetos</h1>
    <table class="table">
        <thead>
            <tr>
                <th scope="col">#</th>
                <th scope="col">Nome</th>
                <th scope="col">Data de Início</th>
                <th scope="col">Previsão de Término</th>
                <th scope="col">Data Real de Término</th>
                <th scope="col">Orçamento</th>
                <th scope="col">Status</th>
                <th scope="col">Ações</th>
            </tr>
        </thead>
        <tbody>
            <!-- Iteração sobre a lista de projetos -->
            <c:forEach items="${projetos}" var="projeto">
                <tr>
                    <th scope="row">${projeto.id}</th>
                    <td>${projeto.nome}</td>
                    <td>${projeto.dataInicio}</td>
                    <td>${projeto.dataPrevisaoFim}</td>
                    <td>${projeto.dataFim}</td>
                    <td>${projeto.orcamento}</td>
                    <td>${projeto.status}</td>
                    <td>
                        <!-- Botões de ação -->
                        <a href="<c:url value='/projetos/editar/${projeto.id}' />" class="btn btn-primary btn-sm">Editar</a>
                        <a href="<c:url value='/projetos/excluir/${projeto.id}' />" class="btn btn-danger btn-sm">Excluir</a>
                    </td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
    <!-- Link para adicionar novo projeto -->
    <a href="/projetos/novo" class="btn btn-success">Novo Projeto</a>
</div>
</body>
</html>
