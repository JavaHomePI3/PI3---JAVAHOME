<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:import url="header.jsp"/>

<c:set var="resultado" value="${requestScope.produtoEncontrado}"/>
<c:set var="idCliente" value="${requestScope.idCliente}"/>
<c:set var="idFuncionario" value="${requestScope.idFuncionario}"/>
<c:set var="idFilial" value="${requestScope.idFilial}"/>
<div class="container">
    <h1 align="center" style="margin: 20px;">Realizar Venda</h1>
    <hr>
    <div>
        <form action="cadastraVenda" method="post">
            <div class="form-row">
                <input type="hidden" value="<c:out value="${resultado.idProduto}"/>" name="idProduto">
                <div class="form-group col-md-6">
                    <label for="produtoNome">Nome do produto</label>
                    <input type="text" disabled class="form-control" id="produtoNome"
                           value="<c:out value="${resultado.nomeprod}"/>" required>
                </div>
                <div class="form-group col-md-6">
                    <label for="codigoProduto">Código de Barras</label>
                    <input type="text" disabled class="form-control" id="codigoProduto"
                           value="${resultado.codigobarrasprod}" required>
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
                    <input type="text" disabled class="form-control" id="precoProduto" placeholder="R$ 00,00"
                           value="${resultado.valorprod}" required>
                </div>
                <div class="form-group col">
                    <label for="inputState">Desconto</label>
                    <select id="inputState" class="form-control">
                        <option selected>Choose...</option>
                        <option>...</option>
                    </select>
                </div>
                <div class="form-group col">
                    <label for="estoquequantidade">Estoque</label>
                    <input type="text" class="form-control" id="estoquequantidade" name="estoquequantidade" disabled
                           value="${resultado.qtdestoque}" required>
                </div>
            </div>

            <a type="button" class="btn btn-primary" data-toggle="modal" data-target=".bd-example-modal-lg"
               style="color: white">Pesquisar
                produto
            </a>
            <input type="text" hidden value="adiciona" name="metodo">
            <c:if test="${resultado.qtdestoque > 0}">
                <button type="submit" class="btn btn-primary">Adicionar produto a Venda</button>
            </c:if>

            <c:if test="${resultado.qtdestoque == 0}">
                <div class="alert alert-danger" role="alert" style="margin-top: 20px;margin-bottom: 20px;">Produto sem
                    estoque!
                </div>
            </c:if>

        </form>
    </div>

    <div>
        <table class="table table-striped">
            <thead>
            <tr>
                <th scope="col">Código</th>
                <th scope="col">Nome</th>
                <th scope="col">Quantidade</th>
                <th scope="col">Preço unitário</th>
                <th scope="col">Categoria</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach var="carrinho" items="${requestScope.produto}">
                <tr>
                    <th scope="row">${carrinho.key.codigobarrasprod}</th>
                    <td>${carrinho.key.nomeprod}</td>
                    <td>${carrinho.value}</td>
                    <td>${carrinho.key.valorprod}</td>
                    <td>${carrinho.key.categoriaprod}</td>
                    <td>
                        <form action="cadastraVenda" method="Post">
                            <input type="hidden" name="idProduto" value="${carrinho.key.idProduto}">
                            <input type="hidden" name="metodo" value="remover">
                            <button type="submit" class="btn btn-primary">Remover</button>
                        </form>
                    </td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </div>
    <div class="form-row">
        <div class="col"><h2>Dados da venda</h2></div>
        <div class="col">
            <c:set var="totalVenda" value="${requestScope.precoTotal}"/>
            <form class="form-row" action="cadastraVenda" method="post">
                <div class="form-group col-md-6">
                    <label for="totalVenda">Total da venda</label>
                    <input type="email" class="form-control" id="totalVenda" placeholder="R$: 1000,00" disabled
                           value="<c:out value="${totalVenda}"/>">
                </div>
                <div class="form-group col-md-6">
                    <label for="cpfCliente">CPF cliente</label>
                    <input type="text" class="form-control" id="cpfCliente" name="cpf" placeholder="333-333-333-33" size="11">
                </div>
                <!-- dados para realizar a venda -->
                <input type="hidden" value="<c:out value="${idFuncionario}"/>" name="idFuncionario">
                <input type="hidden" value="<c:out value="${idFilial}"/>" name="idFilial">
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
    var quantidade = "${quantidadeValida}"

    if (mensagem == "Produto encontrado") {
        alert(mensagem + " : " + codigo)
    } else if (mensagem == "nao") {
        alert("Não foi encontrado protudo com esse código de barras!\nCódigo:" + codigo)
    } else if (mensagem == "erro add") {
        alert("Não foi possivel adicionar o protudo")
    } else if (mensagem == "Carrinho Vazio") {
        alert("O carrinho de compras não pode esta vazio!")
    } else if (mensagem == "Session Erro") {
        alert("Não foi encontrado informações sobre cliente,vendedor e filial.\nPor favor informe a equipe de desenvolvimento.")
    } else if (mensagem == "quantidade") {
        alert("O estoque não tem essa quantidade de produtos: " + quantidade)
    } else if (mensagem == "semProduto") {
        alert("Não foi encontrado o produto informado!")
    }else if (mensagem == "NC") {
        alert("O CPF informado não foi encontrado na base de dados\nPor favor informe um cpf valido!")
    }else if (mensagem == "vendido") {
        alert("Venda Realizada com sucesso!")
    }
</script>

<c:import url="footer.jsp"/>