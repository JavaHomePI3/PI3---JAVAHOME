<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<c:import url="header.jsp"/>
    <h1 align="center" style="margin: 20px;">Lista de Clientes</h1><br>
    <table class="table table-striped" style="margin: 5 auto;">
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

        <c:forEach var="cliente" items="${requestScope.clientes}">
                <tr>
                    <td>${cliente.id}</td>
                    <td>${cliente.nomeUsuario}</td>
                    <td>${cliente.sobrenomeUsuario}</td>
                    <td>${cliente.cpf}</td>
                    <td>${cliente.email}</td>
                    <c:if test="${cliente.genero != null}">
                        <td>${cliente.genero}</td>
                    </c:if>

                    <td>${cliente.dataNascimento}</td>
                    <td>${cliente.telefone}</td>
                    <td>${cliente.cep}</td>
                    <td>${cliente.rua}</td>
                    <td>${cliente.numero}</td>
                    <td>${cliente.bairro}</td>
                    <td>${cliente.complemento}</td>
                    <td>${cliente.cidade}</td>
                    <td>${cliente.estado}</td>

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