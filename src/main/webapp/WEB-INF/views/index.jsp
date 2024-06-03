<!DOCTYPE html>
<html lang="pt-br">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Project Manager</title>
    <link rel="stylesheet" href="/webjars/bootstrap/5.3.0/css/bootstrap.min.css">
    <script src="/webjars/jquery/3.6.0/jquery.min.js"></script>
    <script src="/webjars/bootstrap/5.3.0/js/bootstrap.bundle.min.js"></script>
</head>
<body>
    <nav class="navbar navbar-expand-lg navbar-light bg-light">
        <a class="navbar-brand" href="#">Project Manager</a>
        <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarNav">
            <ul class="navbar-nav">
                <li class="nav-item">
                    <a class="nav-link active" aria-current="page" href="#">Home</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="projetos">Projetos</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="membros">Membros</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="#">Pessoas</a>
                </li>
            </ul>
        </div>
    </nav>

    <div class="container mt-5">
        <div class="jumbotron">
            <h1 class="display-4">Bem vindo ao Gerenciador de Projetos</h1>
            <p class="lead">Esse é um pequeno sistema somente para teste de código.</p>
            <hr class="my-4">
        </div>
    </div>

    <div class="container mt-5">
        <h2>Projects</h2>
        <table class="table table-striped">
            <thead>
                <tr>
                    <th scope="col">#</th>
                    <th scope="col">Project Name</th>
                    <th scope="col">Description</th>
                    <th scope="col">Status</th>
                </tr>
            </thead>
            <tbody>
                <tr>
                    <th scope="row">1</th>
                    <td>Project A</td>
                    <td>Description for Project A</td>
                    <td>Active</td>
                </tr>
                <tr>
                    <th scope="row">2</th>
                    <td>Project B</td>
                    <td>Description for Project B</td>
                    <td>Completed</td>
                </tr>
            </tbody>
        </table>
    </div>
</body>
</html>
