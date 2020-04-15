<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Realizar Venda</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css">
    <script>
        $('#myModal').on('shown.bs.modal', function () {
            $('#myInput').trigger('focus')
        })
    </script>
</head>
<body>
<header>
    <nav class="navbar navbar-expand-lg navbar-dark bg-primary container-fluid">
        <a class="navbar-brand" href="index.html">Navbar</a>
        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarTogglerDemo02"
                aria-controls="navbarTogglerDemo02" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>

        <div class="collapse navbar-collapse" id="navbarTogglerDemo02">
            <ul class="navbar-nav mr-auto mt-2 mt-lg-0">
                <li class="nav-item active">
                    <a class="nav-link" href="index.html">Home <span class="sr-only">(current)</span></a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="cadastroCliente.jsp">Cadastro de Cliente</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="cadastraVenda.jsp">Cadastro de Venda</a>
                </li>
            </ul>
            <form class="form-inline my-2 my-lg-0">
                <input class="form-control mr-sm-2" type="search" placeholder="Search">
                <button class="btn btn-outline-success my-2 my-sm-0" type="submit">Search</button>
            </form>
        </div>
    </nav>
</header>

<div class="container-fluid">
    <div class="">
        <div class="form-row">
            <div class="form-group col-md-6">
                <label for="produtoNome">Nome do produto</label>
                <input type="text" class="form-control" id="produtoNome">
            </div>
            <div class="form-group col-md-6">
                <label for="codigoProduto">Código de Barras</label>
                <input type="text" class="form-control" id="codigoProduto">
            </div>
        </div>
        <div class="form-row">
            <div class="form-group col">
                <label for="pesoProduto">Peso do produto</label>
                <input type="text" class="form-control" id="pesoProduto" placeholder="200gm">
            </div>
            <div class="form-group col">
                <label for="quantidadeProduto">Quantidade</label>
                <input type="number" class="form-control" id="quantidadeProduto">
            </div>
        </div>
        <div class="form-row">
            <div class="form-group col">
                <label for="precoProduto">Preço</label>
                <input type="text" class="form-control" id="precoProduto" placeholder="R$ 00,00">
            </div>
            <div class="form-group col">
                <label for="inputState">Desconto</label>
                <select id="inputState" class="form-control">
                    <option selected>Choose...</option>
                    <option>...</option>
                </select>
            </div>
            <div class="form-group col">
                <label for="inputZip">Seila</label>
                <input type="text" class="form-control" id="inputZip">
            </div>
        </div>
        <button type="button" class="btn btn-primary" data-toggle="modal" data-target=".bd-example-modal-lg">Pesquisar
            produto
        </button>
        <button type="submit" class="btn btn-primary">Adicionar produto a Venda</button>
    </div>
    <div>
        <table class="table table-striped">
            <thead>
            <tr>
                <th scope="col">#</th>
                <th scope="col">First</th>
                <th scope="col">Last</th>
                <th scope="col">Handle</th>
            </tr>
            </thead>
            <tbody>
            <tr>
                <th scope="row">1</th>
                <td>Mark</td>
                <td>Otto</td>
                <td>@mdo</td>
            </tr>
            <tr>
                <th scope="row">2</th>
                <td>Jacob</td>
                <td>Thornton</td>
                <td>@fat</td>
            </tr>
            <tr>
                <th scope="row">3</th>
                <td>Larry</td>
                <td>the Bird</td>
                <td>@twitter</td>
            </tr>
            </tbody>
        </table>
    </div>
    <div class="form-row">
        <div class="col"><h2>Dados da venda</h2></div>
        <div class="col">
            <form class="form-row" action="#">
                <div class="form-group col-md-6">
                    <label for="totalVenda">Total da venda</label>
                    <input type="email" class="form-control" id="totalVenda" placeholder="R$: 1000,00">
                </div>
                <div class="form-group col-md-6">
                    <label for="cpfCliente">CPF cliente</label>
                    <input type="password" class="form-control" id="cpfCliente" placeholder="333-333-333-33">
                </div>
                <button type="submit" class="btn btn-primary">Realizar Venda</button>
            </form>
        </div>
    </div>

</div>
<!-- Large modal -->
<div class="modal fade bd-example-modal-lg" tabindex="-1" role="dialog" aria-labelledby="myLargeModalLabel"
     aria-hidden="true">
    <div class="modal-dialog modal-lg">
        <div class="modal-content">
            <h1>Pesquisar Produtos</h1>
        </div>
    </div>
</div>
<script src="https://code.jquery.com/jquery-3.4.1.slim.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js"></script>
</body>
</html>
