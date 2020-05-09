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
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        VendaDao dao = new VendaDao();
        ClienteDAO clienteDao = new ClienteDAO();
        if (request.getParameter("action") != null) {
            String acao = request.getParameter("action");
            if (acao.equals("cliente")) {
                buscaCliente(request, response, dao, clienteDao);
            }else if(acao.equals("filial")){
                buscaPorFilial(request, response, dao, clienteDao);
            }
        }else{
            try {
                List<Venda> vendas = dao.buscar();
                colocaNomeDoClienteNaVenda(clienteDao, vendas);
                request.setAttribute("vendas", vendas);
            } catch (SQLException e) {
                e.printStackTrace();
            }

            RequestDispatcher requestDispatcher = request.getRequestDispatcher("/relatorio.jsp");
            requestDispatcher.forward(request, response);
        }
    }

    private void buscaPorFilial(HttpServletRequest request, HttpServletResponse response, VendaDao dao, ClienteDAO clienteDao) throws IOException {
        try {
            String nomeFilial = request.getParameter("nome").replace("%20"," ");
            List<Venda> vendasPorFilial = dao.buscarPor("filial",nomeFilial);
            for (Venda v: vendasPorFilial){
                Cliente cliente = clienteDao.buscaClientePeloId(v.getIdCliente());
                v.setNomeCliente(cliente.getNomeUsuario());
            }
            criaJsonResposta(response, vendasPorFilial);
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
            if (request.getParameter("cpf") != null){
                String cpfCliente = request.getParameter("cpf").trim();
                Cliente cliente = clienteDao.buscarClientePeloCpf(cpfCliente);
                List<Venda> vendasPorCliente = dao.buscarPorCliente(String.valueOf(cliente.getId()));
                colocaNomeDoClienteNaVenda(clienteDao,vendasPorCliente);
                criaJsonResposta(response, vendasPorCliente);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void colocaNomeDoClienteNaVenda(ClienteDAO clienteDao, List<Venda> vendas) {
        for (Venda v : vendas) {
            v.setNomeCliente(clienteDao.buscaClientePeloId(v.getIdCliente()).getNomeUsuario());
        }
    }
}
