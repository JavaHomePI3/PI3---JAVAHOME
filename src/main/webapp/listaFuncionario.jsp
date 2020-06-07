<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page contentType="text/html" pageEncoding="UTF-8" %>
<c:import url="header.jsp"/>
<style>
    #accordionSidebar{
        display: none;
    }
</style>
<h1 align="center" style="margin: 20px;">Lista de Funcionários</h1><br>
<div class="container-fluid table-responsive">
    <table class="table table-striped" style="overflow: auto;">
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
            <th>Departamento</th>
            <th>Salário</th>
            <th colspan=2>Ação</th>
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
                <c:if test="${cliente.genero == null}">
                    <td>N/A</td>
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
                <td>${cliente.departamento}</td>
                <td>${cliente.salario}</td>
                <td><a href="CadastroFuncionario?action=editar&id=<c:out value="${cliente.id}"/>">Editar</a></td>
                <td>
                    <button type="button" class="btn btn-danger" data-toggle="modal" data-target="#delete"
                            onclick="passarIdModal(<c:out value="${cliente.id}"/>)">
                        Deletar
                    </button>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>

<center>
    <a class="btn btn-primary" href="index.jsp" role="button">Voltar</a>
</center>
<script>
    var message = "${erro}"
        function erro(){
            alert("Você esta usando este usuário!")
            return
        }
    var id;
    var success = () => {
        alert("Funcionário deletado.")
        setTimeout(function() {window.location.href = "CadastroFuncionario?action=listar";}, 500);
    };

    function passarIdModal(id) {
        this.id = id;
    }

    function deletarCliente() {
        if (id != null){
            let url = "CadastroFuncionario?action=deletar&id="+id;
            $.ajax({
                type: "GET",
                error: erro(),
                success: success,
                url: url
            });
        }else{
            alert("Id do Funcionário não encontrado.")
        }
    }

</script>
<!-- Button trigger modal -->


<!-- Modal -->
<div class="modal fade" id="delete" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel"
     aria-hidden="true">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title" id="exampleModalLabel">Deletar Funcionário</h5>
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>
            </div>
            <div class="modal-body">
                Tem certeza que deseja deletar esse Funcionário?<br>
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