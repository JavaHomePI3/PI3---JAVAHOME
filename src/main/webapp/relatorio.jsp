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
                            <tr>
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
            <div class="col-xl-3 col-md-6 mb-4">
                <div class="card border-left-primary shadow h-100 py-2">
                    <div class="card-body">
                        <div class="row no-gutters align-items-center">
                            <div class="col mr-2">
                                <div class="text-xs font-weight-bold text-primary text-uppercase mb-1">Valor total
                                </div>
                                <div class="spinner-border text-primary" role="status" id="loadingValorTotal" style="display: none;">
                                    <span class="sr-only">Loading...</span>
                                </div>
                                <div class="h5 mb-0 font-weight-bold text-gray-800" id="valorTotal">R$: 000,00</div>
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
<c:import url="footer.jsp"/>
<script src="js/relatorio/relatorio.js"></script>