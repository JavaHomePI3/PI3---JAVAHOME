<%@ page import="java.util.List" %>
<%@ page import="br.senac.sp.entidade.Cliente" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@    taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:import url="header.jsp" />
<div class="container">
    <div>
        <form action="#">
            <div class="form-row">

                <input type="hidden" disabled value="" name="idProduto">
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
            <a type="button" class="btn btn-primary" data-toggle="modal" data-target=".bd-example-modal-lg" style="color: white">Pesquisar
                produto
            </a>
            <button type="submit" class="btn btn-primary">Adicionar produto a Venda</button>
        </form>

    </div>

    <div>
        <table class="table table-striped">
            <thead>
            <tr>
                <th scope="col">Código</th>
                <th scope="col">Nome</th>
                <th scope="col">Quantidade</th>
                <th scope="col">Preço</th>
            </tr>
            </thead>
            <tbody>
            <jsp:useBean id="dao" class="br.senac.sp.entidade.dao.ClienteDAO"/>
            <c:forEach var="cliente" items="${dao.clientes}">
                <tr>
                    <th scope="row">${cliente.id}</th>
                    <td>${cliente.nome}</td>
                    <td>${cliente.email}</td>
                    <td>@mdo</td>
                </tr>
            </c:forEach>
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

<c:import url="footer.jsp" />