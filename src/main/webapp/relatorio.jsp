<%@    taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:import url="header.jsp"/>
<link rel="stylesheet" type="text/css"
      href="https://cdn.datatables.net/v/bs4/jszip-2.5.0/dt-1.10.20/af-2.3.4/b-1.6.1/b-colvis-1.6.1/b-flash-1.6.1/b-html5-1.6.1/b-print-1.6.1/cr-1.5.2/fc-3.3.0/fh-3.1.6/kt-2.5.1/r-2.2.3/rg-1.1.1/rr-1.2.6/sc-2.0.1/sp-1.0.1/sl-1.3.1/datatables.min.css"/>


<%@page contentType="text/html" pageEncoding="UTF-8" %>
<!-- End of Topbar -->
<!-- Custom styles for this page -->
<style>
    .linhaTabela:hover {
        color: #ffffff;
        background-color: #4e73df;
    }

    .linhaTabela {
        cursor: pointer;
    }
    .container-edit{
        margin-top: 30px;
    }
</style>
<div class="container-fluid container-edit">
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

                    <div class="form-group col-md-6" id="categoria-form" style="display: none;">
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
                         id="cpf-form" style="display: none;">
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
                            <th>Cliente</th>
                            <th>Código do funcionario</th>
                            <th>filial</th>
                            <th>preço total</th>
                            <th>Data da venda</th>
                        </tr>
                        </thead>
                        <tbody>
                        <c:forEach var="vendas" items="${requestScope.vendas}">
                            <tr class="linhaTabela" onclick="buscarDetalhesVenda(${vendas.idItens})" data-toggle="modal"
                                data-target=".bd-example-modal-lg">
                                <td>${vendas.id}</td>
                                <td>${vendas.idItens}</td>
                                <td>${vendas.nomeCliente}</td>
                                <td>${vendas.idVendedor}</td>
                                <td>${vendas.filial}</td>
                                <td>R$: ${vendas.precoTotal}</td>
                                <td>${vendas.dataDaVenda}</td>
                            </tr>
                        </c:forEach>

                        </tbody>
                    </table>
                    <div class="text-center">
                        <div class="spinner-border" id="loading"
                             style="width: 3rem; height: 3rem; position: absolute; display: none;" role="status">
                            <span class="sr-only">Loading...</span>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <div class="container-fluid">
        <div class="row">
            <!-- Earnings (Monthly) Card Example -->
            <div class="col">
                <div class="card border-left-primary shadow h-100 py-2">
                    <div class="card-body">
                        <div class="row no-gutters align-items-center">
                            <div class="col mr-2">
                                <div class="text-xs font-weight-bold text-primary text-uppercase mb-1">Valor total
                                </div>
                                <div class="spinner-border text-primary loadingValorTotal" role="status"
                                     style="display: none;">
                                    <span class="sr-only">Loading...</span>
                                </div>
                                <div class="h5 mb-0 font-weight-bold text-gray-800" id="valorTotal">R$: 000,00</div>
                            </div>
                            <div class="col-auto">
                                <i class="fas fa-calendar fa-2x text-gray-300"></i>
                            </div>
                        </div>
                        <!-- Card Body -->
                        <div class="card-body">
                            <div class="chart-pie pt-4 pb-2">
                                <canvas id="myPieChart"></canvas>
                            </div>
                            <div class="mt-4 text-center small">
                    <span class="mr-2">
                      <i class="fas fa-circle text-primary"></i> Total da venda
                    </span>
                                <span class="mr-2">
                      <i class="fas fa-circle text-success"></i> Mais vendido
                    </span>
                                <span class="mr-2">
                      <i class="fas fa-circle text-info"></i> Venda por filial
                    </span>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
            <div class="col">
                <!-- Card Body -->
                <div class="card-body">
                    <div class="chart-area">
                        <canvas id="myAreaChart"></canvas>
                    </div>
                </div>
            </div>
        </div>
    </div>

</div>
<div class="modal fade bd-example-modal-lg" tabindex="-1" role="dialog" aria-labelledby="myLargeModalLabel"
     aria-hidden="true">
    <div class="modal-dialog modal-lg">
        <div class="modal-content container">
            <div class="modal-body">
                <div class="container-fluid">
                    <div class="row">
                        <table class="table-responsive table-sm">
                            <thead>
                            <tr>
                                <th scope="col">id</th>
                                <th scope="col">código</th>
                                <th scope="col">valor unit</th>
                                <th scope="col">nome</th>
                                <TH scope="col">categoria</TH>
                                <th scope="col">qtd estoque</th>
                                <th scope="col">qtd venda</th>
                                <th scope="col">valor total</th>
                            </tr>
                            <tbody id="rootModal">

                            </tbody>
                            </thead>
                        </table>
                    </div>
                    <div class="row">
                        <div class="col-md-3 ml-auto">
                            <!-- TODO-->
                        </div>
                        <div class="col-md-2 ml-auto">
                            <!-- TODO-->
                        </div>
                    </div>
                    <div class="row">
                        <div class="col-md-6 ml-auto">
                            <!-- TODO-->
                        </div>
                    </div>
                    <div class="row">
                        <div class="col-sm-9">

                            <div class="row">
                                <div class="card border-left-primary shadow h-100 py-2">
                                    <div class="card-body">
                                        <div class="row no-gutters align-items-center">
                                            <div class="col mr-2" id="rootValorTotal">
                                                <div class="text-xs font-weight-bold text-primary text-uppercase mb-1">
                                                    Valor total
                                                </div>

                                            </div>
                                            <div class="col-auto">
                                                <i class="fas fa-calendar fa-2x text-gray-300"></i>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
<c:import url="footer.jsp"/>
<script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/pdfmake/0.1.36/pdfmake.min.js"></script>
<script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/pdfmake/0.1.36/vfs_fonts.js"></script>
<script type="text/javascript"
        src="https://cdn.datatables.net/v/bs4/jszip-2.5.0/dt-1.10.20/af-2.3.4/b-1.6.1/b-colvis-1.6.1/b-flash-1.6.1/b-html5-1.6.1/b-print-1.6.1/cr-1.5.2/fc-3.3.0/fh-3.1.6/kt-2.5.1/r-2.2.3/rg-1.1.1/rr-1.2.6/sc-2.0.1/sp-1.0.1/sl-1.3.1/datatables.min.js"></script>
<script>
    $(document).ready(function () {
        $("#dataTable").DataTable({
            dom: 'Bfrtip',
            buttons: {
                buttons: ['copy', 'csv', 'excel']
            }
        });

    })
</script>
<script src="js/relatorio/relatorio.js"></script>
