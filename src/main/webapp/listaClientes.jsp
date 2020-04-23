<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<c:import url="header.jsp"/>
<html>
    <head>
       <meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
    <br>
        <h1 align="center">Lista de Clientes</h1><br>
    </head>
<body>
    <table class="table table-striped">
        <thead>
            <tr>
                <th>ID</th>
                <th>Nome</th>
                <th>Sobrenome</th>
                <th>CPF</th>
                <th>Email</th>
                <th>Sexo</th>
                <th>Data Nascimento</th>
                <th>Telefone</th>
                <th>CEP</th>
                <th>Endere�o</th>
                <th>Numero</th>
                <th>Bairro</th>
                <th>Complemento</th>
                <th>Cidade</th>
                <th>Estado</th>
                   
                <th colspan=2>A豫o</th>
            </tr>
        </thead>
        <tbody>
            
            <c:forEach items="${clientes}" var="cliente">
                <tr>
                    <td><c:out value="${cliente.idUsuario}" /></td>
                    <td><c:out value="${cliente.nomeUsuario}" /></td>
                    <td><c:out value="${cliente.cpf}" /></td>
                    <td><c:out value="${cliente.email}" /></td>
                    <td><c:out value="${cliente.genero}" /></td>
                    <td><fmt:formatDate pattern="dd/MM/yyyy" value="${cliente.data_nascimento}" /></td>
                    <td><c:out value="${cliente.telefone}" /></td>
                    <td><c:out value="${cliente.cep}" /></td>
                    <td><c:out value="${cliente.rua}" /></td>
                    <td><c:out value="${cliente.numero}" /></td>
                    <td><c:out value="${cliente.bairro}" /></td>
                    <td><c:out value="${cliente.complemento}" /></td>
                    <td><c:out value="${cliente.cidade}" /></td>
                    <td><c:out value="${cliente.estado}" /></td>
                    
                    <td><a href="CadastroClienteServlet?acao=editar&idUsuario=<c:out value="${cliente.idUsuario}"/>">Editar</a></td>
                    <td><a href="CadastroClienteServlet?acao=deletar&idUsuario=<c:out value="${cliente.idUsuario}"/>">Deletar</a></td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
    <center>
    <a class="btn btn-primary" href="index.jsp" role="button">Voltar</a>
    </center>
</body>
</html>