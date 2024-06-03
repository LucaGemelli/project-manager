<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="pt-BR">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Lista de Membros</title>
    <link rel="stylesheet" href="/webjars/bootstrap/5.3.0/css/bootstrap.min.css">
    <script src="/webjars/jquery/3.6.0/jquery.min.js"></script>
    <script src="/webjars/bootstrap/5.3.0/js/bootstrap.bundle.min.js"></script>
    <script src="/webjars/popper.js/2.11.6/umd/popper.min.js"></script>
</head>
<body>

<div class="container mt-4">
    <h1>Lista de Membros</h1>
    <table class="table">
        <thead>
            <tr>
                <th scope="col">#</th>
                <th scope="col">Nome</th>
                <th scope="col">Cargo</th>
                <th scope="col">Data de Entrada</th>
                <th scope="col">Data de Saída</th>
                <th scope="col">Status</th>
                <th scope="col">Ações</th>
            </tr>
        </thead>
        <tbody>
            <!-- Iteração sobre a lista de membros -->
            <c:forEach items="${membros}" var="membro">
                <tr>
                    <th scope="row">${membro.id}</th>
                    <td>${membro.nome}</td>
                    <td>${membro.cargo}</td>
                    <td>${membro.dataEntrada}</td>
                    <td>${membro.dataSaida}</td>
                    <td>${membro.status}</td>
                    <td>
                        <!-- Botões de ação -->
                        <a href="<c:url value='/membros/editar/${membro.id}' />" class="btn btn-primary btn-sm">Editar</a>
                        <a href="<c:url value='/membros/excluir/${membro.id}' />" class="btn btn-danger btn-sm">Excluir</a>
                    </td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
    <!-- Link para adicionar novo membro -->
    <a href="/membros/novo" class="btn btn-success">Novo Membro</a>
</div>
</body>
</html>
