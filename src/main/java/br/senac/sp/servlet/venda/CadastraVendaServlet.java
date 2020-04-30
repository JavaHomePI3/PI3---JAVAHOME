package br.senac.sp.servlet.venda;

import br.senac.sp.entidade.dao.ClienteDAO;
import br.senac.sp.entidade.dao.ProdutosDao;
import br.senac.sp.entidade.dao.VendaDao;
import br.senac.sp.entidade.model.Carrinho;
import br.senac.sp.entidade.model.Cliente;
import br.senac.sp.entidade.model.Produto;
import br.senac.sp.entidade.model.Venda;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Map;

@WebServlet(name = "cadastraVendaServlet", value = "/cadastraVenda")
public class CadastraVendaServlet extends HttpServlet {
    Carrinho carrinho = new Carrinho();
    private Integer idFuncionario;
    private Integer idFialial;

    @Override
    public void destroy() {
        super.destroy();
        carrinho = new Carrinho();
        //tem que limpar dados da seção também
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        sessionVenda();
        String acao = request.getParameter("metodo");
        configuraListaDeProdutos(request, acao);
        configuraAtributos(request);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/cadastraVenda.jsp");
        requestDispatcher.forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String acao = request.getParameter("metodo");
        configuraAcao(request, response, acao);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/cadastraVenda.jsp");
        requestDispatcher.forward(request, response);
    }

    private void configuraAcao(HttpServletRequest request, HttpServletResponse response, String acao) {
        if (acao != null) {
            switch (acao) {
                case "vender":
                    tentaRealizarVenda(request);
                    break;
                case "adiciona":
                    adicionaProduto(request, response);
                    break;
                case "remover":
                    removeProdutoDaLista(request);
                    break;
            }
        }
    }

    private void removeProdutoDaLista(HttpServletRequest request) {
        String idProduto = request.getParameter("idProduto");
        try {
            if (idProduto != null) {
                ProdutosDao dao = new ProdutosDao();
                Produto resultado = dao.PesquisarProdutoPorId(Integer.parseInt(idProduto));
                if(carrinho.removeProduto(resultado)){
                    atualizaListaDeProdutos(request);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void tentaRealizarVenda(HttpServletRequest request) {
        try {
            String cpf = "";
            if (request.getParameter("cpf") != null){
                cpf = request.getParameter("cpf");
            }
            Cliente clienteEncontrado = new ClienteDAO().buscarClientePeloCpf(cpf);
            Integer idCliente = null;
            if (clienteEncontrado != null){
                idCliente = clienteEncontrado.getId();
                if (idFuncionario != null && idFialial != null) {
                    VendaDao dao = new VendaDao();

                    if (!carrinho.getCarrinho().isEmpty()) {
                        Venda novaVenda = new Venda(idCliente, idFuncionario, idFialial, carrinho);
                        dao.inserir(novaVenda);
                        atualizaEstoque();
                        destroy();
                        request.setAttribute("mensagem", "vendido");
                    } else {
                        request.setAttribute("mensagem", "Carrinho Vazio");
                    }
                } else {
                    request.setAttribute("mensagem", "Session Erro");
                    System.out.println("Erro nas informações de Seção: idCliente,idFuncionario e idFilial.\ncliente: " + idCliente
                            + " - funcionario: " + idFuncionario + " - Filial: " + idFialial);
                }
            }else{
                request.setAttribute("mensagem", "NC");
                atualizaListaDeProdutos(request);
                System.out.println("Erro nas informações de Seção: idCliente,idFuncionario e idFilial.\ncliente: " + idCliente
                        + " - funcionario: " + idFuncionario + " - Filial: " + idFialial);
            }
        } catch (SQLException e) {
            System.out.print("Erro ao inserir venda: " + e.getMessage());
            throw new RuntimeException(e);
        }
    }

    private void atualizaEstoque() {
        ProdutosDao produtosDao = new ProdutosDao();
        for (Map.Entry<Produto, Integer> produto : carrinho.getCarrinho().entrySet()) {
            Produto attProduto = produto.getKey();
            attProduto.setQtdestoque(attProduto.getQtdestoque() - produto.getValue());
            produtosDao.atualizarprod(attProduto);
        }
    }

    private void adicionaProduto(HttpServletRequest request, HttpServletResponse response) {
        int quantidade = 0;
        try {
            String idProduto = request.getParameter("idProduto");
            String quantidadeProdutoVenda = request.getParameter("quantidade");
            if (idProduto != null && quantidadeProdutoVenda != null && Integer.parseInt(quantidadeProdutoVenda) > 0 && idProduto.matches("\\d")) {
                ProdutosDao dao = new ProdutosDao();
                Produto resultado = dao.PesquisarProdutoPorId(Integer.parseInt(idProduto));
                if (resultado != null) {
                    quantidade = Integer.parseInt(quantidadeProdutoVenda);
                    carrinho.adicionaProdutoAoCarrinho(resultado, quantidade);
                    atualizaListaDeProdutos(request);
                } else {
                    request.setAttribute("mensagem", "semProduto");
                }
            } else {
                request.setAttribute("mensagem", "erro add");
            }
        } catch (SQLException e) {
            e.printStackTrace();
            quantidadeInvalida(request, String.valueOf(quantidade));
        }
    }

    private void atualizaListaDeProdutos(HttpServletRequest request) {
        request.setAttribute("produto", carrinho.getCarrinho());
        request.setAttribute("precoTotal", carrinho.getPrecoTotal());
    }

    private void quantidadeInvalida(HttpServletRequest request, String quantidadeProduto) {
        request.setAttribute("quantidadeValida", quantidadeProduto);
        request.setAttribute("mensagem", "quantidade");
        atualizaListaDeProdutos(request);
    }

    private void configuraAtributos(HttpServletRequest request) {
        atualizaListaDeProdutos(request);
        request.setAttribute("idFuncionario", idFuncionario);
        request.setAttribute("idFilial", idFialial);
    }

    private void configuraListaDeProdutos(HttpServletRequest request, String acao) {
        if (acao != null) {
            if (acao.equals("pesquisar")) {
                String codigoDoProduto = request.getParameter("codigoDoProduto");
                Produto produtoEncontrado = pesquisaProduto(codigoDoProduto);
                if (produtoEncontrado != null) {
                    for (Map.Entry<Produto, Integer> produto : carrinho.getCarrinho().entrySet()) {
                        if (produto.getKey().equals(produtoEncontrado)) {
                            produtoEncontrado.setQtdestoque(produtoEncontrado.getQtdestoque() - produto.getValue());
                        }
                    }
                    request.setAttribute("produtoEncontrado", produtoEncontrado);
                } else {
                    request.setAttribute("mensagem", "nao");
                    request.setAttribute("codigobarras", codigoDoProduto);
                }
            }
        }
    }

    private void sessionVenda() {
        idFuncionario = 1;
        idFialial = 1;
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
