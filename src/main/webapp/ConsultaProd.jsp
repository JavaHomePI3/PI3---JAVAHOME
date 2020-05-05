<%-- 
    Document   : ConsultaProd
    Created on : 02/05/2020, 13:13:34
    Author     : Vitoria Cristina
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<c:import url="header.jsp"/>

<div align="center">

    <h1>Consultar Produto</h1>
    <br>
    <h2>Digite o código do produto</h2>


    <div class="col-md-5 order-md-1">
        <form action="consultaProduto" method="POST">
            <input class="form-control" type="text" name="ConsultaProd" form-control required/>
            <div class="invalid-feedback" style="width: 100%;">
                Valor obrigatório.
            </div>
            <br>
            <button type="submit">Pesquisar</button>
            <br><br>
        </form>
    </div>

</div>

<script>


    var resultado = "${resultado}"

    var prodalterado = "${prodAlterado}"


    if (resultado == "Produto não encontado") {
        alert(resultado)

    } else if (prodalterado == "Produto Alterado") {

        alert(prodalterado)

    }

</script>
<c:import url="footer.jsp"/>
