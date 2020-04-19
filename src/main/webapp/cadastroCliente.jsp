
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<c:import url="header.jsp"/>
<link type="text/css"
    href="css/ui-lightness/jquery-ui-1.8.18.custom.css" rel="stylesheet" />
<script type="text/javascript" src="http://code.jquery.com/jquery-1.7.1.js"></script>
<script type="text/javascript" src="http://www.godtur.no/godtur/js/jquery-ui-1.8.18.custom.min.js"></script>

<h1>Formulário de Cadastro</h1>

<form action="CadastraClienteServlet" method="POST">
     <script>
        $(function() {
            $('input[name=data_nascimento]').datepicker();
        });
    </script>
    Nome:<input type="text" name="nome"/><br>
    Sobrenome:<input type="text" name="sobrenome"/><br>
    CPF:<input type="text" name="cpf"/><br>
    Email:<input type="email" name="email"/><br>
    Sexo:<select name="genero" >
        <option value="">Nenhum...</option>
        <option>MASCULINO</option>
        <option>FEMININO</option>
    </select><br>
    Data de Nascimento:<input
            type="text" placeholder="dd/MM/yyyy" name="dob" data-date-format="dd/MM/yyyy"
            value="<fmt:formatDate pattern="dd/MM/yyyy" value="${user.dob}" />" /><br>
    Telefone:<input type="tel" name="telefone"/><br>
    CEP:<input type="number" name="cep"/><br>
    Rua:<input type="text" name="rua"/><br>
    Bairo:<input type="text" name="bairro"/><br>
    Complemento:<input type="text" name="complemento"/><br>
    Cidade:<input type="text" name="cidade"/><br>
    Numero:<input type="number" name="numero"/><br>
    Estado:<input type="text" name="estado"/><br>


    <button type="submit" >Cadastrar</button>
    
</form>
            <a href="ListaClientes.jsp" >Lista</a>
<c:import url="footer.jsp"/>