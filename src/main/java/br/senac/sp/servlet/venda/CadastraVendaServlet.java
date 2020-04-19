package br.senac.sp.servlet.venda;

import br.senac.sp.entidade.dao.ProdutosDao;
import br.senac.sp.entidade.model.Produto;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "cadastraVendaServlet", value = "/cadastraVenda")
public class CadastraVendaServlet extends HttpServlet {
    private List<Produto> listaProduto = new ArrayList<>();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String acao = request.getParameter("metodo");
        if (acao != null) {
            switch (acao) {
                case "vender":
                    break;
                case "adiciona":
                    adicionaProduto(request);
                    break;
                case "remover":
                    break;
            }
        }
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/cadastraVenda.jsp");
        requestDispatcher.forward(request, response);
    }

    private void adicionaProduto(HttpServletRequest request) {
        try {
            String idProduto = request.getParameter("idProduto");
            String quantidadeProduto = request.getParameter("quantidade");
            String codigo = request.getParameter("codigoDoProduto");
            ProdutosDao dao = new ProdutosDao();
            Produto resultado = dao.PesquisarProduto(codigo);
            if (resultado != null) {
                listaProduto.add(resultado);
                request.setAttribute("produto", listaProduto);
            } else {
                request.setAttribute("mensagem", "erro add");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String acao = request.getParameter("metodo");
        if (acao != null) {
            if (acao.equals("pesquisar")) {
                String codigoDoProduto = request.getParameter("codigoDoProduto");
                Produto produtoEncontrado = pesquisaProduto(codigoDoProduto);
                if (produtoEncontrado != null) {
                    request.setAttribute("produtoEncontrado", produtoEncontrado);
                } else {
                    request.setAttribute("mensagem", "nao");
                    request.setAttribute("codigobarras", codigoDoProduto);
                }
            }
        }
        request.setAttribute("produto", listaProduto);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/cadastraVenda.jsp");
        requestDispatcher.forward(request, response);
    }

    private Produto pesquisaProduto(String codigoDoProduto) {
        try {
            ProdutosDao daoProduto = new ProdutosDao();
            return daoProduto.PesquisarProduto(codigoDoProduto);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
