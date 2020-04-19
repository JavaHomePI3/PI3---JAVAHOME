
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
       
        <title>Lista de Clientes</title>
    </head>
<body>
    <table border=1>
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
                <th>Endereço</th>
                <th>Numero</th>
                <th>Bairro</th>
                <th>Complemento</th>
                <th>Cidade</th>
                <th>Estado</th>
                   
                <th colspan=2>Ação</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach items="${cliente}" var="cliente">
                <tr>
                    <td><c:out value="${cliente.idUsuario}" /></td>
                    <td><c:out value="${cliente.nomeUsuario}" /></td>
                    <td><c:out value="${cliente.cpf}" /></td>
                    <td><c:out value="${cliente.email}" /></td>
                    <td><c:out value="${cliente.genero}" /></td>
                    <td><fmt:formatDate pattern="dd/MM/yyyy" value="${cliente.dataNascimento}" /></td>
                    <td><c:out value="${cliente.telefone}" /></td>
                    <td><c:out value="${cliente.cep}" /></td>
                    <td><c:out value="${cliente.rua}" /></td>
                    <td><c:out value="${cliente.numero}" /></td>
                    <td><c:out value="${cliente.bairro}" /></td>
                    <td><c:out value="${cliente.complemento}" /></td>
                    <td><c:out value="${cliente.cidade}" /></td>
                    <td><c:out value="${cliente.estado}" /></td>
                    
                    <td><a href="CadastroClienteServlet?action=editar=<c:out value="${cliente.idUsuario}"/>">Editar</a></td>
                    <td><a href="CadastroClienteServlet?action=deletar=<c:out value="${cliente.idUsuario}"/>">Deletar</a></td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
    <p><a href="index.jsp">Voltar</a></p>
</body>
</html>