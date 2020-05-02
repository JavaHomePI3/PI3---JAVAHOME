<%-- 
    Document   : ConsultaProd
    Created on : 02/05/2020, 13:13:34
    Author     : Vitoria Cristina
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <!-- Bootstrap core CSS -->
        <link href="vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">

        <!-- Custom fonts for this template 
        <link href="https://fonts.googleapis.com/css?family=Saira+Extra+Condensed:100,200,300,400,500,600,700,800,900" rel="stylesheet">
        <link href="https://fonts.googleapis.com/css?family=Open+Sans:300,300i,400,400i,600,600i,700,700i,800,800i" rel="stylesheet">
        <link href="vendor/font-awesome/css/font-awesome.min.css" rel="stylesheet">
        <link href="vendor/devicons/css/devicons.min.css" rel="stylesheet">
        <link href="vendor/simple-line-icons/css/simple-line-icons.css" rel="stylesheet">-->

        <!-- Custom styles for this template -->
        <link href="css/topodapagina.css" rel="stylesheet">
    <form name = "ConsultaProd" action="${pageContext.request.contextPath}/ConsultaProd" method="POST" >

        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Consultar Produto</title>
    </head>
    <body id="page-top">
        <form>

            <%@include  file="header.jsp" %>

            <div align ="center">
                <br>
                <br>

                <h1 >Consultar Produto</h1>
                <br>
                <h2>Digite o código do produto</h2>


                <div class="col-md-5 order-md-1">

                    <input class="form-control" type="text" name="ConsultaProd" form-control required/>
                    <div class="invalid-feedback" style="width: 100%;">
                        Valor obrigatório.
                    </div>
                    <br>
                    <input type="submit" name="pesquisar" value ="Pesquisar" /><br><br>

                </div>        

                <footer class="my-5 pt-5 text-muted text-center text-small">
                    <p class="mb-1">&copy; JavaHome - PI III</p>
                    <ul class="list-inline">
                        <li class="list-inline-item"><a href="#">Privacidade</a></li>
                        <li class="list-inline-item"><a href="#">Termos</a></li>
                        <li class="list-inline-item"><a href="https://www.google.com">Suporte</a></li>
                    </ul>
                </footer>
            </div>
    </body>
    <script>


        var resultado = "${resultado}"

        var prodalterado = "${prodAlterado}"


        if (resultado == "Produto não encontado") {
            alert(resultado)

        } else if (prodalterado == "Produto Alterado") {
            
            alert(prodalterado)

        }



    </script>
</html>
