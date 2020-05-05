<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page contentType="text/html" pageEncoding="UTF-8" %>
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

            <td><a href="CadastroCliente?action=editar&id=<c:out value="${cliente.id}"/>">Editar</a></td>
            <td>
                <button type="button" class="btn btn-danger" data-toggle="modal" data-target="#exampleModal"
                        onclick="passarIdModal(<c:out value="${cliente.id}"/>)">
                    Deletar
                </button>
            </td>
        </tr>
    </c:forEach>
    </tbody>
</table>
<center>
    <a class="btn btn-primary" href="index.jsp" role="button">Voltar</a>
</center>
<script>
    var id;
    var success = () => {
        alert("Cliente deletado.")
        setTimeout(function() {window.location.href = "CadastroCliente?action=listar";}, 500);
    };

    function passarIdModal(id) {
        this.id = id;
    }

    function deletarCliente() {
        if (id != null){
            let url = "CadastroCliente?action=deletar&id="+id;
            $.ajax({
                type: "GET",
                success: success,
                url: url
            });
        }else{
            alert("Id do cliente não encontrado.")
        }
    }

</script>
<!-- Button trigger modal -->


<!-- Modal -->
<div class="modal fade" id="exampleModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel"
     aria-hidden="true">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title" id="exampleModalLabel">Deletar Cliente</h5>
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>
            </div>
            <div class="modal-body">
                Tem certeza que deseja deletar esse cliente?<br>
                Uma vez deletado não tera como recuperar,<br>
                devera ser realizado um novo cadastro do mesmo!<br>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-secondary" data-dismiss="modal">Cancelar</button>
                <a href="#" class="btn btn-danger" onclick="deletarCliente()">Deletar</a>
            </div>
        </div>
    </div>
</div>

<c:import url="footer.jsp"/>