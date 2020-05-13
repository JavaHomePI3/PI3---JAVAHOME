package br.senac.sp.servlet.relatorio;

import br.senac.sp.entidade.dao.ClienteDAO;
import br.senac.sp.entidade.dao.VendaDao;
import br.senac.sp.entidade.model.Cliente;
import br.senac.sp.entidade.model.Venda;
import com.google.gson.Gson;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet(name = "RelatorioServlet", value = "/relatorio")
public class RelatorioServlet extends HttpServlet {
    private double valorTotal;
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        VendaDao dao = new VendaDao();
        ClienteDAO clienteDao = new ClienteDAO();

        if (request.getParameter("action") != null) {
            String acao = request.getParameter("action");
            if (acao.equals("cliente")) {
                buscaCliente(request, response, dao, clienteDao);
            } else if (acao.equals("filial")) {
                buscaPor(request, response, "nome", "filial", dao, clienteDao);
            } else if (acao.equals("categoria")) {
                buscaPor(request, response, "nome", "filial", dao, clienteDao);
            } else if (acao.equals("detalhes")) {
                pegaItensDaVenda(request, response, dao);
            }
        } else {
            try {
                List<Venda> vendas = dao.buscar();
                configuraListaDeVenda(clienteDao, vendas);
                request.setAttribute("vendas", vendas);
                request.setAttribute("valorTotal",valorTotal);
            } catch (SQLException e) {
                e.printStackTrace();
            }

            RequestDispatcher requestDispatcher = request.getRequestDispatcher("/relatorio.jsp");
            requestDispatcher.forward(request, response);
        }
    }

    private void pegaItensDaVenda(HttpServletRequest request, HttpServletResponse response, VendaDao dao) throws IOException {
        int idItens = Integer.parseInt(request.getParameter("CodigoItens"));
        try {
            String json = dao.buscaItens(idItens);
            response.setContentType("application/json");
            response.setCharacterEncoding("utf-8");
            response.getWriter().write(json);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void buscaPor(HttpServletRequest request, HttpServletResponse response, String parametro, String colunaSql, VendaDao dao, ClienteDAO clienteDao) throws IOException {
        try {
            String nomeFilial = request.getParameter(parametro).replace("%20", " ");
            List<Venda> resultados = dao.buscarPor(colunaSql, nomeFilial);
            for (Venda v : resultados) {
                Cliente cliente = clienteDao.buscaClientePeloId(v.getIdCliente());
                v.setNomeCliente(cliente.getNomeUsuario());
            }
            criaJsonResposta(response, resultados);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void criaJsonResposta(HttpServletResponse response, List<Venda> vendasPorFilial) throws IOException {
        String json = new Gson().toJson(vendasPorFilial);
        response.setContentType("application/json");
        response.setCharacterEncoding("utf-8");
        response.getWriter().write(json);
    }

    private void buscaCliente(HttpServletRequest request, HttpServletResponse response, VendaDao dao, ClienteDAO clienteDao) throws IOException {
        try {
            if (request.getParameter("cpf") != null) {
                String cpfCliente = request.getParameter("cpf").trim();
                Cliente cliente = clienteDao.buscarClientePeloCpf(cpfCliente);
                List<Venda> vendasPorCliente = dao.buscarPorCliente(String.valueOf(cliente.getId()));
                configuraListaDeVenda(clienteDao, vendasPorCliente);
                criaJsonResposta(response, vendasPorCliente);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void configuraListaDeVenda(ClienteDAO clienteDao, List<Venda> vendas) {
        valorTotal = 0;
        for (Venda v : vendas) {
            v.setNomeCliente(clienteDao.buscaClientePeloId(v.getIdCliente()).getNomeUsuario());
            valorTotal+= v.getPrecoTotal();
        }
    }
}
