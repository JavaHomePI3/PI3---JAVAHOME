package br.senac.sp.servlet.cliente;

import br.senac.sp.entidade.dao.ClienteDAO;
import br.senac.sp.entidade.enums.ConvertStringForGenero;
import br.senac.sp.entidade.enums.ConvertStringForUf;
import br.senac.sp.entidade.enums.Genero;
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
        request.setCharacterEncoding("UTF-8");
        RequestDispatcher view = request.getRequestDispatcher(INSERIR_OU_EDITAR);
        String acao = request.getParameter("action");
        if (acao != null) {
            switch (acao) {
                case "listar":
                    view = configuraListaDeClientes(request, view);
                    break;
                case "deletar":
                    view = deletaCliente(request);
                    break;
                case "editar":
                    view = editaCliente(request);
                    break;
            }
        }
        view.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        Cliente cliente = criaCliente(request);
        String acao = request.getParameter("acao");

        try {
            if (acao != null){
                dao.editar(cliente);
            }else {
                dao.inserir(cliente);
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

    private RequestDispatcher deletaCliente(HttpServletRequest request) {
        int id = Integer.parseInt(request.getParameter("id"));
        try {
            dao.removerCliente(id);
        } catch (SQLException e) {
            System.out.println("Erro ao deletar cliente!");
            e.printStackTrace();
        }
        return request.getRequestDispatcher(LISTA_CLIENTE);
    }

    private RequestDispatcher editaCliente(HttpServletRequest request) {
        int idUsuario = Integer.parseInt(request.getParameter("id"));
        request.setAttribute("cliente", dao.buscaClientePeloId(idUsuario));
        request.setAttribute("action","editar");
        RequestDispatcher view = request.getRequestDispatcher(INSERIR_OU_EDITAR);
        return view;
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
