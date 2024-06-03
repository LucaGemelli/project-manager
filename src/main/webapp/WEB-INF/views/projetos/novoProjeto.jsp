<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Novo Projeto</title>
    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="/webjars/bootstrap/5.3.0/css/bootstrap.min.css">
    <script src="/webjars/jquery/3.6.0/jquery.min.js"></script>
    <script src="/webjars/bootstrap/5.3.0/js/bootstrap.bundle.min.js"></script>
    <script src="/webjars/popper.js/2.11.6/umd/popper.min.js"></script>
</head>
<body>

<div class="container mt-4">
    <h1>Novo Projeto</h1>
    <form action="/projetos" method="post">
        <div class="mb-3">
            <label for="nome" class="form-label">Nome do Projeto</label>
            <input type="text" class="form-control" id="nome" name="nome" required>
        </div>
        <div class="mb-3">
            <label for="dataInicio" class="form-label">Data de Início</label>
            <input type="date" class="form-control" id="dataInicio" name="dataInicio" required>
        </div>
        <div class="mb-3">
            <label for="dataPrevisaoFim" class="form-label">Previsão de Término</label>
            <input type="date" class="form-control" id="dataPrevisaoFim" name="dataPrevisaoFim" required>
        </div>
        <div class="mb-3">
            <label for="orcamento" class="form-label">Orçamento</label>
            <input type="number" class="form-control" id="orcamento" name="orcamento" required>
        </div>
        <div class="mb-3">
            <label for="status" class="form-label">Status</label>
            <select class="form-select" id="status" name="status" required>
                <option value="EM_ANDAMENTO">Em Andamento</option>
                <option value="CONCLUIDO">Concluído</option>
                <option value="CANCELADO">Cancelado</option>
            </select>
        </div>
        <button type="submit" class="btn btn-primary">Salvar</button>
    </form>
</div>
</body>
</html>
