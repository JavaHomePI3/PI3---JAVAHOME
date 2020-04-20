<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:import url="header.jsp"/>
<div class="container">
    <div>
        <form action="cadastraVenda" method="post">
            <div class="form-row">
                <c:set var="resultado" value="${requestScope.produtoEncontrado}"/>
                <input type="hidden"  value="<c:out value="${resultado.idProduto}"/>" name="idProduto">
                <div class="form-group col-md-6">
                    <label for="produtoNome">Nome do produto</label>
                    <input type="text" disabled class="form-control" id="produtoNome" value="<c:out value="${resultado.nomeprod}"/>" required>
                </div>
                <div class="form-group col-md-6">
                    <label for="codigoProduto">Código de Barras</label>
                    <input type="text" disabled class="form-control" id="codigoProduto" value="<c:out value="${resultado.codigobarrasprod}"/>" required>
                </div>
            </div>
            <div class="form-row">
                <div class="form-group col">
                    <label for="pesoProduto">Peso do produto</label>
                    <input type="text" disabled class="form-control" id="pesoProduto" placeholder="200gm">
                </div>
                <div class="form-group col">
                    <label for="quantidadeProduto">Quantidade</label>
                    <input type="number" class="form-control" id="quantidadeProduto" name="quantidade" required>
                </div>
            </div>
            <div class="form-row">
                <div class="form-group col">
                    <label for="precoProduto">Preço</label>
                    <input type="text" disabled class="form-control" id="precoProduto" placeholder="R$ 00,00" value="<c:out value="${resultado.valorprod}"/>" required>
                </div>
                <div class="form-group col">
                    <label for="inputState">Desconto</label>
                    <select id="inputState" class="form-control">
                        <option selected>Choose...</option>
                        <option>...</option>
                    </select>
                </div>
                <div class="form-group col">
                    <label for="inputZip">Estoque</label>
                    <input type="text" class="form-control" id="inputZip" disabled value="<c:out value="${resultado.qtdestoque}"/>" required>
                </div>
            </div>

            <a type="button" class="btn btn-primary" data-toggle="modal" data-target=".bd-example-modal-lg"
               style="color: white">Pesquisar
                produto
            </a>
            <input type="text" hidden value="adiciona" name="metodo">
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
                <th scope="col">Categoria</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach var="produto" items="${requestScope.produto}">
                <tr>
                    <th scope="row">${produto.key.codigobarrasprod}</th>
                    <td>${produto.key.nomeprod}</td>
                    <td>${produto.value}</td>
                    <td>${produto.key.valorprod}</td>
                    <td>${produto.key.categoriaprod}</td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </div>
    <div class="form-row">
        <div class="col"><h2>Dados da venda</h2></div>
        <div class="col">
            <c:set var="totalVenda" value="${requestScope.precoTotal}"/>
            <form class="form-row" action="#">
                <div class="form-group col-md-6">
                    <label for="totalVenda">Total da venda</label>
                    <input type="email" class="form-control" id="totalVenda" placeholder="R$: 1000,00" disabled value="<c:out value="${totalVenda}"/>">
                </div>
                <div class="form-group col-md-6">
                    <label for="cpfCliente">CPF cliente</label>
                    <input type="password" class="form-control" id="cpfCliente" placeholder="333-333-333-33">
                </div>
                <input type="text" hidden value="vender" name="metodo">
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
            <div class="container">
                <form class="form-row" action="cadastraVenda" method="get" style="margin: 30px;">
                    <label for="codigoProdutoModal">Código de Barras</label>
                    <input type="text" class="form-control" id="codigoProdutoModal" name="codigoDoProduto">
                    <input type="text" hidden value="pesquisar" name="metodo">
                    <button type="submit" class="btn btn-primary">Buscar</button>
                </form>
            </div>
        </div>
    </div>
</div>
<script>
    var mensagem = "${mensagem}"
    var codigo = "${codigobarras}"

    if (mensagem == "Produto encontrado") {
        alert(mensagem +" : "+ codigo)
    } else if (mensagem == "nao") {
        alert("Não foi encontrado protudo com esse código de barras!\nCódigo:" + codigo)
    }else if (mensagem == "erro add") {
        alert("Não foi adicionar protudo")
    }
</script>
<c:import url="footer.jsp"/>