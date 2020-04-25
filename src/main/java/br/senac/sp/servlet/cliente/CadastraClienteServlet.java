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
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;

/**
 * @author walter_prata
 */
@WebServlet(name = "CadastraClienteServlet", urlPatterns = {"/CadastroCliente"})
public class CadastraClienteServlet extends HttpServlet {

    private static String INSERIR_OU_EDITAR = "/cadastroCliente.jsp";
    private static String LISTA_CLIENTE = "listaClientes.jsp";
    private static String LISTAR = "CadastroCliente?action=listar";
    private ClienteDAO dao = new ClienteDAO();

    public CadastraClienteServlet() {
        super();

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String forward = "";
        String acao = request.getParameter("action");
        List<Cliente> listaDeCliente = new ArrayList<>();
        if (acao.equalsIgnoreCase("deletar")) {

            try {
                int idUsuario = Integer.parseInt(request.getParameter("idUsuario"));
                String cpf = request.getParameter("cpf");
                dao.removerCliente(idUsuario);
                forward = LISTA_CLIENTE;
                request.setAttribute("cliente", dao.buscarClientePeloCpf(cpf));
            } catch (SQLException ex) {
                Logger.getLogger(CadastraClienteServlet.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else if (acao.equalsIgnoreCase("editar")) {

            try {
                forward = INSERIR_OU_EDITAR;
                String cpf = request.getParameter("cpf");
                Cliente cliente = dao.buscarClientePeloCpf(cpf);
                request.setAttribute("cliente", cliente);
            } catch (SQLException ex) {
                Logger.getLogger(CadastraClienteServlet.class.getName()).log(Level.SEVERE, null, ex);
            }

        } else if (acao.equalsIgnoreCase("listar")) {
            forward = LISTA_CLIENTE;
            try {
                listaDeCliente = dao.buscar();
                request.setAttribute("clientes", listaDeCliente);

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
        //cliente.setIdUsuario(Integer.parseInt(request.getParameter("id_usuario")));
        cliente.setNomeUsuario(request.getParameter("nomeCliente"));
        cliente.setSobrenomeUsuario(request.getParameter("sobrenomeCliente"));
        cliente.setCpf(request.getParameter("cpfCliente"));
        cliente.setEmail(request.getParameter("emailCliente"));
        cliente.setGenero(request.getParameter("generoCliente").charAt(0));
        //Date dataNascimento = null;
        String teste = request.getParameter("data_nascimento");
        System.out.println(teste);
//            if (request.getParameter("data_nascimento") != null) {
//                dataNascimento = new SimpleDateFormat("dd/MM/yyyy").parse(request.getParameter("dob"));
//            } else {
//                dataNascimento = null;
//            }
        cliente.setDataNascimento(teste);

        cliente.setTelefone(request.getParameter("telefoneCliente"));
        cliente.setCep(request.getParameter("cepCliente"));
        cliente.setRua(request.getParameter("ruaCliente"));
        cliente.setBairro(request.getParameter("bairroCliente"));
        cliente.setComplemento(request.getParameter("complementoCliente"));
        cliente.setCidade(request.getParameter("cidadeCliente"));
        cliente.setNumero(Integer.parseInt(request.getParameter("numeroCliente")));
        cliente.setEstado(request.getParameter("ufCliente"));

        try {
            String cpf = request.getParameter("cpfCliente");
            if(cpf == null || cpf.isEmpty())
            {
                dao.inserir(cliente);
            }
            else
            {
                cliente.setCpf(cpf);
                dao.editar(cliente);
            }


        } catch (SQLException e) {
            e.printStackTrace();
        }
        RequestDispatcher view = request.getRequestDispatcher(LISTA_CLIENTE);
        view.forward(request, response);
    }
}
