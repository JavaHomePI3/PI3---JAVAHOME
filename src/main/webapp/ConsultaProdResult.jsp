<%-- 
    Document   : ConsultaProdResult
    Created on : 02/05/2020, 13:18:24
    Author     : Vitoria Cristina
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8" %>

<c:import url="header.jsp"/>

<div align="center">

    <div class="col-md-6 mb-3">
        <form class="needs-validation" novalidate action="${pageContext.request.contextPath}/AlterarProd" method="POST">

            <div class="row">
                <div class="col-md-4 mb-3">
                    <label>Código do Produto</label>
                    <input readonly name="codigoprod" type="text" class="form-control"
                           value="${resultado.codigoprod}" required>
                    <div class="invalid-feedback">
                        Código obrigatório
                    </div>
                </div>
                <div class="col-md-8 mb-3">
                    <label>Nome do Produto</label>
                    <input name="nomeprod" type="text" class="form-control"
                           value="${resultado.nomeprod}" required>
                    <div class="invalid-feedback">
                        Nome obrigatório
                    </div>
                </div>
                <div class="col-md-12 mb-3">
                    <label>Descrição do Produto</label>
                    <input name="descricaoprod" type="text" class="form-control"
                           value="${resultado.descricaoprod}" required>
                    <div class="invalid-feedback">
                        Descrição necessária
                    </div>
                </div>
                <div class="col-md-4 mb-3">
                    <label for="categoria">Categoria</label>
                    <select name="categoriaprod" class="custom-select d-block w-100" id="categoria" required>
                        <option><c:out value="${resultado.categoriaprod}"></c:out></option>
                        <option>Jogo</option>
                        <option>Brinde</option>
                        <option>Console</option>
                        <option>Outros</option>
                    </select>

                    <div class="invalid-feedback">
                        Favor selecionar a categoria.
                    </div>
                </div>

                <div class="col-md-4 mb-3">
                    <label for="valor">Valor</label>
                    <input name="valorprod" type="number" class="form-control" id="valor" value="${resultado.valorprod}"
                           required>
                    <div class="invalid-feedback">
                        Favor inserir o Valor.
                    </div>
                </div>
                <div class="col-md-4 mb-3">
                    <label for="qtdestoque">Quantidade</label>
                    <input name="qtdestoque" type="number" class="form-control" id="qtdestoque"
                           value="${resultado.qtdestoque}" required>
                    <div class="invalid-feedback">
                        Favor inserir a quantidade.
                    </div>
                </div>
            </div>

            <hr class="mb-4">
            <button class="btn btn-secondary btn-lg btn-block" type="submit" name="alterar" value="alterar">Alterar
            </button>
            <br>
            <button class="btn btn-secondary btn-lg btn-block" type="submit" name="excluir" value="excluir">Excluir
            </button>
        </form>
    </div>
</div>
<c:import url="footer.jsp"/>


