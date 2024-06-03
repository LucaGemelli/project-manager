<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="pt-BR">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Lista de Pessoas</title>
    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="/webjars/bootstrap/5.3.0/css/bootstrap.min.css">
    <script src="/webjars/jquery/3.6.0/jquery.min.js"></script>
    <script src="/webjars/bootstrap/5.3.0/js/bootstrap.bundle.min.js"></script>
    <script src="/webjars/popper.js/2.11.6/umd/popper.min.js"></script>
</head>
<body>

<div class="container mt-4">
    <h1>Lista de Pessoas</h1>
    <table class="table">
        <thead>
            <tr>
                <th scope="col">#</th>
                <th scope="col">Nome</th>
                <th scope="col">Data de Nascimento</th>
                <th scope="col">CPF</th>
                <th scope="col">Funcionário</th>
                <th scope="col">Gerente</th>
                <th scope="col">Ações</th>
            </tr>
        </thead>
        <tbody>
            <!-- Iteração sobre a lista de pessoas -->
            <c:forEach items="${pessoas}" var="pessoa">
                <tr>
                    <th scope="row">${pessoa.id}</th>
                    <td>${pessoa.nome}</td>
                    <td>${pessoa.dataNascimento}</td>
                    <td>${pessoa.cpf}</td>
                    <td>${pessoa.funcionario ? 'Sim' : 'Não'}</td>
                    <td>${pessoa.gerente ? 'Sim' : 'Não'}</td>
                    <td>
                        <!-- Botões de ação -->
                        <a href="<c:url value='/pessoas/editar/${pessoa.id}' />" class="btn btn-primary btn-sm">Editar</a>
                        <a href="<c:url value='/pessoas/excluir/${pessoa.id}' />" class="btn btn-danger btn-sm">Excluir</a>
                    </td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
    <!-- Link para adicionar nova pessoa -->
    <a href="/pessoas/novo" class="btn btn-success">Nova Pessoa</a>
</div>
</body>
</html>
