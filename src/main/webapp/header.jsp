<!DOCTYPE html>
<html>
<head>
    <title>Loja de jogos</title>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css">
</head>
<body id="page-top">
<header>
    <nav class="navbar navbar-expand-lg navbar-dark bg-primary container-fluid">
        <a class="navbar-brand" href="index.jsp">Navbar</a>
        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarTogglerDemo02" aria-controls="navbarTogglerDemo02" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>

        <div class="collapse navbar-collapse" id="navbarTogglerDemo02">
            <ul class="navbar-nav mr-auto mt-2 mt-lg-0">
                <li class="nav-item active">
                    <a class="nav-link" href="index.jsp">Home <span class="sr-only">(current)</span></a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="cadastroCliente.jsp">Cadastro de Cliente</a>
                </li>
                <li class="nav-item dropdown">
                    <a class="nav-link dropdown-toggle" href="#" id="navbarDropdownVenda" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                        Venda
                    </a>
                    <div class="dropdown-menu" aria-labelledby="navbarDropdownVenda">
                        <a class="dropdown-item" href="cadastraVenda">Realiza Venda</a>
                        <a class="dropdown-item" href="cadastraVenda">Consulta Venda</a>
                    </div>
                </li>
                <li class="nav-item dropdown">
                    <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                        Produtos
                    </a>
                    <div class="dropdown-menu" aria-labelledby="navbarDropdown">
                        <a class="dropdown-item" href="cadastraProduto">Cadastro Produto</a>
                        <a class="dropdown-item" href="consultaProduto">Consulta Produto</a>
                    </div>
                </li>
            </ul>
            <form class="form-inline my-2 my-lg-0">
                <input class="form-control mr-sm-2" type="search" placeholder="Search">
                <button class="btn btn-outline-success my-2 my-sm-0" type="submit">Search</button>
            </form>
        </div>
    </nav>
</header>
