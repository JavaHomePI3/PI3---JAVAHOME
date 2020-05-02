<%-- 
    Document   : ConsultaProdResult
    Created on : 02/05/2020, 13:18:24
    Author     : Vitoria Cristina
--%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page import="br.senac.sp.entidade.model.Produto"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
    <head>
        <!-- Bootstrap core CSS -->
        <link href="vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">

        <!-- Custom fonts for this template -->
        <link href="https://fonts.googleapis.com/css?family=Saira+Extra+Condensed:100,200,300,400,500,600,700,800,900" rel="stylesheet">
        <link href="https://fonts.googleapis.com/css?family=Open+Sans:300,300i,400,400i,600,600i,700,700i,800,800i" rel="stylesheet">
        <link href="vendor/font-awesome/css/font-awesome.min.css" rel="stylesheet">
        <link href="vendor/devicons/css/devicons.min.css" rel="stylesheet">
        <link href="vendor/simple-line-icons/css/simple-line-icons.css" rel="stylesheet">

        <!-- Custom styles for this template -->
        <link href="css/topodapagina.css" rel="stylesheet">

        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Consultar Produto</title>
    </head>
    <body id="page-top">
        <form>

            <%@include  file="header.jsp" %>

        </form> 

        <div align ="center">
            <br>
            <br>
            <br>

            <h1>Consultar Produto</h1>

            <input type="text" name="consultaprod" />
            <input type="submit" name="pesquisar" value ="Pesquisar" /><br><br>

        </div>   


        <div align ="center">
            <br>
            <br>
            <br>


            <div class="col-md-6 mb-3">
                <form class="needs-validation" novalidate action="${pageContext.request.contextPath}/AlterarProd" method="POST" >


                    <div class="row">
                        <div class="col-md-4 mb-3">
                            <label>Código do Produto</label>
                            <input readonly name="codigoprod" type="text" class="form-control" id="primeironome" value="${resultado.codigoprod}" required>
                            <div class="invalid-feedback">
                                Código obrigatório
                            </div>
                        </div>
                        <div class="col-md-8 mb-3">
                            <label>Nome do Produto</label>
                            <input name="nomeprod" type="text" class="form-control" id="primeironome" value="${resultado.nomeprod}" required>
                            <div class="invalid-feedback">
                                Nome obrigatório
                            </div>
                        </div>
                        <div class="col-md-12 mb-3">
                            <label>Descrição do Produto</label>
                            <input name="descricaoprod" type="text" class="form-control" id="primeironome"  value="${resultado.descricaoprod}" required>
                            <div class="invalid-feedback">
                                Descrição necessária
                            </div>
                        </div>
                        <div class="col-md-4 mb-3">
                            <label for="categoriaprod">Categoria</label>
                            <select name ="categoriaprod" class="custom-select d-block w-100" id="categoria" required>
                                <option><c:out value = "${resultado.categoriaprod}"></c:out></option>
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
                                <label for="valorprod">Valor</label>
                                <input name="valorprod" type="number" class="form-control" id="valor"  value="${resultado.valorprod}" required>
                            <div class="invalid-feedback">
                                Favor inserir o Valor.
                            </div>
                        </div>
                        <div class="col-md-4 mb-3">
                            <label for="qtdestoque">Quantidade</label>
                            <input name="qtdestoque" type="number" class="form-control" id="qtdestoque" value="${resultado.qtdestoque}" required>
                            <div class="invalid-feedback">
                                Favor inserir a quantidade.
                            </div>
                        </div>

                    </div>

                    <hr class="mb-4">
                    <button class="btn btn-secondary btn-lg btn-block" type="submit" name ="alterar" value = "alterar">Alterar</button>
                    <br>
                    <button class="btn btn-secondary btn-lg btn-block" type="submit" name ="excluir" value ="excluir" >Excluir</button>



                </form>
            </div>
        </div>


        <div align = "center">
            <input type ="button" value ="Voltar" onclick="history.back()">    
        </div>
        <footer class="my-5 pt-5 text-muted text-center text-small">
            <p class="mb-1">&copy; JavaHome - PI III</p>
            <ul class="list-inline">
                <li class="list-inline-item"><a href="#">Privacidade</a></li>
                <li class="list-inline-item"><a href="#">Termos</a></li>
                <li class="list-inline-item"><a href="https://www.google.com">Suporte</a></li>
            </ul>
        </footer>

    </body>
</html>


