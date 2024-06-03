<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Lista de Membros</title>
    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="<c:url value='/webjars/bootstrap/5.3.0/css/bootstrap.min.css' />">
</head>
<body>

<div class="container mt-4">
    <h1>Lista de Membros</h1>
    <table class="table">
        <thead>
            <tr>
                <th scope="col">Projeto</th>
                <th scope="col">Pessoa</th>
                <th scope="col">Ações</th>
            </tr>
        </thead>
        <tbody>
            <!-- Iteração sobre a lista de membros -->
            <c:forEach items="${membros}" var="membro">
                <tr>
                    <td>${membro.projeto.nome}</td>
                    <td>${membro.pessoa.nome}</td>
                    <td>
                        <!-- Botão de ação (opcional para membros) -->
                        <a href="#" class="btn btn-danger btn-sm">Remover Membro</a>
                    </td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
    <!-- Link para associar novo membro -->
    <a href="/membros/novo" class="btn btn-success">Associar Membro</a>
</div>

<!-- Bootstrap JS (opcional, dependendo do uso de componentes JS) -->
<script src="<c:url value='/webjars/jquery/3.6.0/jquery.min.js' />"></script>
<script src="<c:url value='/webjars/popper.js/2.11.6/umd/popper.min.js' />"></script>
<script src="<c:url value='/webjars/bootstrap/5.3.0/js/bootstrap.min.js' />"></script>

</body>
</html>
