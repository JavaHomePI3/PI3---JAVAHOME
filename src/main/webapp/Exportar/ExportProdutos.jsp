<%-- 
    Document   : ExportProdutos
    Created on : 02/05/2020, 15:21:26
    Author     : Vitoria Cristina
--%>

<%@page import="java.sql.ResultSet"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Export</title>
    </head>
    <body>
        <h1>Report Produtos</h1>


        <table>
            <tr>
                <td>Código do Produto</td>
                <td>Nome do Produto</td>
                <td>Valor do Produto</td>
                <td>Data de Cadastro do Produto</td>
                <td>Descricao do Produto</td>
                <td>Categoria do Produto</td>
                <td>Quantidade do Produto</td>
               <!-- <td>ID Loja</td>-->

            </tr>

            <%

                ResultSet exportar = (ResultSet) request.getAttribute("exportarprodutos");

                while (exportar.next()) {


            %>
            <tr>
                <td><%=exportar.getString("codigobarrasprod")%></td>
                <td><%=exportar.getString("nomeprod")%></td>
                <td>R$<%=exportar.getDouble("valor")%></td>
                <td><%=exportar.getString("datacadastroprod")%></td>
                <td><%=exportar.getString("descricaoprod")%></td>
                <td><%=exportar.getString("categoriaprod")%></td>
                <td><%=exportar.getInt("quantidadeprod")%></td>
               <!-- <td><%=exportar.getInt("idloja")%></td>-->

            </tr>   
            <%
                }
                response.setContentType("application/vnd.ms-excel");
                response.setHeader("Content-Disposition", "inline; filename=" + "Produtosreport.xls");
            %>
        </table>
    </body>
</html>
