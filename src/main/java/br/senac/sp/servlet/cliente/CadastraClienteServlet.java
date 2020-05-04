package br.senac.sp.servlet.cliente;

import br.senac.sp.entidade.dao.ClienteDAO;
import br.senac.sp.entidade.enums.ConvertStringForGenero;
import br.senac.sp.entidade.enums.ConvertStringForUf;
import br.senac.sp.entidade.enums.Uf;
import br.senac.sp.entidade.exception.ClienteException;
import br.senac.sp.entidade.model.Cliente;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author walter_prata
 */
@WebServlet(name = "CadastraClienteServlet", value = "/CadastroCliente")
public class CadastraClienteServlet extends HttpServlet {

    private static String INSERIR_OU_EDITAR = "/cadastroCliente.jsp";
    private static String LISTA_CLIENTE = "/listaClientes.jsp";
    private ClienteDAO dao = new ClienteDAO();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher view = request.getRequestDispatcher(INSERIR_OU_EDITAR);
        String acao = request.getParameter("action");
        if (acao != null) {
            switch (acao) {
                case "listar":
                    view = configuraListaDeClientes(request, view);
                    break;
                case "deletar":
                    deletaCliente(request);
                    break;
                case "editar":
                    view = editaCliente(request, view);
                    break;
            }
        }
        view.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Cliente cliente = criaCliente(request);
        try {
            String cpf = request.getParameter("cpfCliente");
            if (cpf == null || cpf.isEmpty()) {
                dao.inserir(cliente);
            } else {
                cliente.setCpf(cpf);
                dao.editar(cliente);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        response.sendRedirect("CadastroCliente?action=listar");
    }

    private RequestDispatcher configuraListaDeClientes(HttpServletRequest request, RequestDispatcher view) {
        try {
            List<Cliente> listaDeCliente = dao.buscar();
            request.setAttribute("clientes", listaDeCliente);
            view = request.getRequestDispatcher(LISTA_CLIENTE);
        } catch (ClienteException e) {
            e.printStackTrace();
        }
        return view;
    }

    private RequestDispatcher editaCliente(HttpServletRequest request, RequestDispatcher view) {
        try {
            String cpf = request.getParameter("cpf");
            Cliente cliente = dao.buscarClientePeloCpf(cpf);
            request.setAttribute("cliente", cliente);
            view = request.getRequestDispatcher(INSERIR_OU_EDITAR);
        } catch (SQLException ex) {
            Logger.getLogger(CadastraClienteServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
        return view;
    }

    private void deletaCliente(HttpServletRequest request) {
        try {
            int idUsuario = Integer.parseInt(request.getParameter("idUsuario"));
            String cpf = request.getParameter("cpf");
            dao.removerCliente(idUsuario);
            request.setAttribute("cliente", dao.buscarClientePeloCpf(cpf));
        } catch (SQLException ex) {
            Logger.getLogger(CadastraClienteServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }


    private Cliente criaCliente(HttpServletRequest request) {
        Cliente cliente = new Cliente();

        cliente.setNomeUsuario(request.getParameter("nomeCliente"));
        cliente.setSobrenomeUsuario(request.getParameter("sobrenomeCliente"));
        cliente.setCpf(request.getParameter("cpfCliente"));
        cliente.setEmail(request.getParameter("emailCliente"));
        cliente.setGenero(ConvertStringForGenero.parse(request.getParameter("generoCliente")));

        String dataDeNascimento = request.getParameter("data_nascimento");
        cliente.setDataNascimento(dataDeNascimento);

        cliente.setTelefone(request.getParameter("telefoneCliente"));
        cliente.setCep(request.getParameter("cepCliente"));
        cliente.setRua(request.getParameter("ruaCliente"));
        cliente.setBairro(request.getParameter("bairroCliente"));
        cliente.setComplemento(request.getParameter("complementoCliente"));
        cliente.setCidade(request.getParameter("cidadeCliente"));
        cliente.setNumero(Integer.parseInt(request.getParameter("numeroCliente")));
        cliente.setEstado(ConvertStringForUf.parse(request.getParameter("ufCliente")));
        return cliente;
    }
}
