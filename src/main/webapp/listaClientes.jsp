<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:import url="header.jsp"/>
    <h1 align="center">Lista de Clientes</h1><br>
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
            <th>Endere&ccedil;o</th>
            <th>Numero</th>
            <th>Bairro</th>
            <th>Complemento</th>
            <th>Cidade</th>
            <th>Estado</th>
            <th colspan=2>A&ccedil;&atilde;o</th>
        </tr>
        </thead>
        <tbody>

        <c:forEach items="${requestScope.clientes}" var="cliente">
            <tr>
                <td><c:out value="${cliente.id}" /></td>
                <td><c:out value="${cliente.nomeUsuario}" /></td>
                <td><c:out value="${cliente.sobrenomeUsuario}" /></td>
                <td><c:out value="${cliente.cpf}" /></td>
                <td><c:out value="${cliente.email}" /></td>
                <td><c:out value="${cliente.genero}" /></td>
                <td><c:out value="${cliente.dataNascimento}" /></td>
                <td><c:out value="${cliente.telefone}" /></td>
                <td><c:out value="${cliente.cep}" /></td>
                <td><c:out value="${cliente.rua}" /></td>
                <td><c:out value="${cliente.numero}" /></td>
                <td><c:out value="${cliente.bairro}" /></td>
                <td><c:out value="${cliente.complemento}" /></td>
                <td><c:out value="${cliente.cidade}" /></td>
                <td><c:out value="${cliente.estado}" /></td>

                <td><a href="CadastroCliente?action=editar&cpf=<c:out value="${cliente.cpf}"/>">Editar</a></td>
                <td><a href="CadastroCliente?action=deletar&idUsuario=<c:out value="${cliente.id}"/>">Deletar</a></td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
    <center>
        <a class="btn btn-primary" href="index.jsp" role="button">Voltar</a>
    </center>

<c:import url="footer.jsp"/>