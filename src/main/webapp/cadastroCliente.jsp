<%@    taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:import url="header.jsp"/>
    <h1>Formulário de Cadastro</h1>
        <form action="CadastroClienteServlet" method="POST">
                Nome:<input type="text" name="nome"/><br>
               Email:<input type="text" name="email"/><br>
               <button type="submit" >Enviar</button>
        </form>
<c:import url="footer.jsp"/>