<%@    taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:import url="header.jsp"/>
<%@page contentType="text/html" pageEncoding="UTF-8" %>
<!-- End of Topbar -->
<!-- Custom styles for this page -->
<div class="container-fluid">
    <!-- Page Heading -->
    <h1 class="h3 mb-2 text-gray-800">Relatórios</h1>
    <!-- Content Row -->
    <!-- Area Chart -->
    <div class="card-header py-3">
        <h6 class="m-0 font-weight-bold text-primary">Area De Relatório</h6>
        <!-- Topbar Search -->
    </div>
    <div class="card-body">
        <!-- Page Heading -->

        <!-- DataTales Example -->
        <div class="card shadow mb-4 container-fluid">
            <div class="card-header py-3 row">
                <div class="col">
                    <div class="form-check">
                        <input class="form-check-input" type="radio" name="exampleRadios" id="radioFilial"
                               value="option1" checked>
                        <label class="form-check-label" for="radioFilial">
                            filiais
                        </label>
                    </div>
                    <div class="form-check">
                        <input class="form-check-input" type="radio" name="exampleRadios" id="radioCatProd"
                               value="option2">
                        <label class="form-check-label" for="radioCatProd">
                            categoria de produtos
                        </label>
                    </div>
                    <div class="form-check disabled">
                        <input class="form-check-input" type="radio" name="exampleRadios" id="radioCliente"
                               value="option3">
                        <label class="form-check-label" for="radioCliente">
                            cliente
                        </label>
                    </div>
                </div>
                <div class="col">
                    <div class="form-group col-md-6" id="filial-form">
                        <label for="filial">Filial</label>
                        <select name="filial" class="custom-select d-block w-100" id="filial" required>
                            <option value="">Selecionar...</option>
                            <option value="São Paulo">São Paulo</option>
                            <option value="Campina">Campina</option>
                            <option value="Brasília">Brasília</option>
                            <option value="Joinville">Joinville</option>
                        </select>
                        <div class="input-group-append" style="margin-top: 5px;">
                            <button class="btn btn-primary" type="button" onclick="buscarFilial()">
                                <i class="fas fa-search fa-sm">Buscar</i>
                            </button>
                        </div>
                    </div>

                    <div class="form-group col-md-6" id="categoria-form">
                        <label for="categoria">Categoria de produtos</label>
                        <select name="categoria" class="custom-select d-block w-100" id="categoria" required>
                            <option value="">Selecionar...</option>
                            <option value="Jogos">Jogos</option>
                            <option value="Serviços">Serviços</option>
                        </select>

                        <div class="input-group-append" style="margin-top: 5px;">
                            <button class="btn btn-primary" type="button" onclick="buscarCategoria()">
                                <i class="fas fa-search fa-sm">Buscar</i>
                            </button>
                        </div>
                    </div>

                    <div class="form-inline mr-auto ml-md-3 my-2 my-md-0 mw-100 navbar-search"
                         id="cpf-form">
                        <div class="input-group">
                            <input type="text" class="form-control border-0 small" placeholder="CPF do clinete..."
                                   aria-label="Search" id="cpfCliente" aria-describedby="basic-addon2" maxlength="11">
                            <div class="input-group-append">
                                <button class="btn btn-primary" type="button" onclick="buscarCliente()">
                                    <i class="fas fa-search fa-sm"></i>
                                </button>
                            </div>
                        </div>
                    </div>
                </div>

            </div>
            <div class="card-body">
                <div class="table-responsive">
                    <table class="table table-bordered" id="dataTable" width="100%" cellspacing="0">
                        <thead>
                        <tr>
                            <th>Código da venda</th>
                            <th>Código do carrinho</th>
                            <th>id cliente</th>
                            <th>Código do funcionario</th>
                            <th>filial</th>
                            <th>preço total</th>
                            <th>Data da venda</th>
                        </tr>
                        </thead>
                        <tbody>
                        <c:forEach var="vendas" items="${requestScope.vendas}">
                            <tr>
                                <td>${vendas.id}</td>
                                <td>${vendas.idItens}</td>
                                <td>${vendas.nomeCliente}</td>
                                <td>${vendas.idVendedor}</td>
                                <td>${vendas.filial}</td>
                                <td>${vendas.precoTotal}</td>
                                <td>${vendas.dataDaVenda}</td>
                            </tr>
                        </c:forEach>

                        </tbody>
                    </table>
                    <div class="text-center">
                        <div class="spinner-border" id="loading" style="width: 3rem; height: 3rem; position: absolute; display: none;" role="status">
                            <span class="sr-only">Loading...</span>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>


<!-- /.container-fluid -->
<!-- Page level custom scripts -->
<script src="vendor/datatables/jquery.dataTables.min.js"></script>
<script src="vendor/datatables/dataTables.bootstrap4.min.js"></script>

<!-- Page level custom scripts -->
<script src="js/demo/datatables-demo.js"></script>
<c:import url="footer.jsp"/>
<script>
    $(document).ready(function () {
        $("#categoria-form").css("display", "none");
        $("#cpf-form").css("display", "none");

        $("#radioFilial").click(function () {
            $("#filial-form").css("display", "block");
            $("#categoria-form").css("display", "none");
            $("#cpf-form").css("display", "none");
        });

        $("#radioCatProd").click(function () {
            $("#filial-form").css("display", "none");
            $("#categoria-form").css("display", "block");
            $("#cpf-form").css("display", "none");
        });

        $("#radioCliente").click(function () {
            $("#filial-form").css("display", "none");
            $("#categoria-form").css("display", "none");
            $("#cpf-form").css("display", "inline-block");
        });
    });

    function buscarCliente() {
        let cpf = $('#cpfCliente').val();
        let url = "relatorio?action=cliente&cpf=" + cpf;
        $.ajax({
            type: 'GET',
            url: url,
            dataType: "json",
            beforeSend: function () {
                // setting a timeout
                $("#loading").css("display", "inline-block");
            },
            success: function (data) {
                controiHtml(data);
            },
            complete: function () {
                $("#loading").css("display", "none")
            },
        });

        function controiHtml(data) {
            var html = data.reduce(function (string, obj, i) {
                return string + "<tr> <td>" + obj.id + "</td><td>" + obj.idItens + "</td> <td>" + obj.nomeCliente + " </td> <td>" + obj.idVendedor + " </td> <td>" +
                    obj.filial + " </td> <td>" + obj.precoTotal + "</td> <td>" + obj.dataDaVenda + "</td></tr>";
            }, '');
            $("#dataTable tbody").html(html);
        }
    }

    function buscarFilial() {
        let filial = $('#filial');
        alert(filial.val())

    }

    function buscarCategoria() {
        let categoria = $('#categoria');
        alert(categoria.val())

    }

</script>