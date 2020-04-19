package br.senac.sp.servlet.cliente;

import br.senac.sp.entidade.dao.ClienteDAO;
import br.senac.sp.entidade.exception.ClienteException;
import br.senac.sp.entidade.model.Cliente;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;

/**
 *
 * @author walter_prata
 */
@WebServlet(name = "Cliente", urlPatterns = "/CadastroCliente")
public class CadastraClienteServlet extends HttpServlet {

    private static String INSERIR_OU_EDITAR = "/cadastroCliente.jsp";
    private static String LISTA_CLIENTE = "/listaCliente.jsp";
    private ClienteDAO dao;

    public CadastraClienteServlet() {
        dao = new ClienteDAO();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String forward = "";
        String acao = request.getParameter("acao");

        if (acao.equalsIgnoreCase("deletar")) {

            try {
                int idUsuario = Integer.parseInt(request.getParameter("idUsuario"));
                dao.removerCliente(idUsuario);
                forward = LISTA_CLIENTE;
                request.setAttribute("cliente", dao.buscar());
            } catch (SQLException ex) {
                Logger.getLogger(CadastraClienteServlet.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else if (acao.equalsIgnoreCase("editar")) {

            try {
                forward = INSERIR_OU_EDITAR;
                String cpf = request.getParameter("cpf");
                Cliente cliente = dao.buscarClientePeloCpf(cpf);
                request.setAttribute("user", cliente);
            } catch (SQLException ex) {
                Logger.getLogger(CadastraClienteServlet.class.getName()).log(Level.SEVERE, null, ex);
            }

        } else if (acao.equalsIgnoreCase("listar")) {
            forward = LISTA_CLIENTE;
            try {
                request.setAttribute("cliente", dao.buscar());
            } catch (ClienteException ex) {
                Logger.getLogger(CadastraClienteServlet.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            forward = INSERIR_OU_EDITAR;
        }

        RequestDispatcher view = request.getRequestDispatcher(forward);
        view.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Cliente cliente = new Cliente();
        cliente.setIdUsuario(Integer.parseInt(request.getParameter("id_usuario")));
        cliente.setNomeUsuario(request.getParameter("nome"));
        cliente.setSobrenomeUsuario(request.getParameter("sobrenome"));
        cliente.setCpf(request.getParameter("cpf"));
        cliente.setEmail(request.getParameter("email"));
        cliente.setGenero(request.getParameter("genero").charAt(0));
        try {
            Date dataNascimento = null;
            String teste = request.getParameter("data_nascimento");
            System.out.println(teste);
            if (request.getParameter("data_nascimento") != null) {
                dataNascimento = new SimpleDateFormat("dd/MM/yyyy").parse(request.getParameter("dob"));
            } else {
                dataNascimento = null;
            }
            cliente.setDataNascimento(dataNascimento);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        cliente.setTelefone(request.getParameter("sobrenome"));
        cliente.setCep(request.getParameter("sobrenome"));
        cliente.setRua(request.getParameter("sobrenome"));
        cliente.setBairro(request.getParameter("sobrenome"));
        cliente.setComplemento(request.getParameter("sobrenome"));
        cliente.setCidade(request.getParameter("sobrenome"));
        cliente.setNumero(Integer.parseInt(request.getParameter("numero")));
        cliente.setEstado(request.getParameter("estado"));
        
        try {
            RequestDispatcher view = request.getRequestDispatcher(LISTA_CLIENTE);
            request.setAttribute("clientes", dao.buscar());
            view.forward(request, response);
        } catch (ClienteException ex) {
            Logger.getLogger(CadastraClienteServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
        

    }
}
