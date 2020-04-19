/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.sp.servlet.produto;

import br.senac.sp.entidade.dao.ProdutosDao;
import br.senac.sp.entidade.model.Produto;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Vitoria Cristina
 */
@WebServlet(name = "AlterarProd", urlPatterns = {"/AlterarProd"})

public class AlterarProd extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        boolean deletado = false;
        ProdutosDao bancoprod = new ProdutosDao();

        String alterar = String.valueOf(request.getParameter("alterar"));
        String excluir = String.valueOf(request.getParameter("excluir"));

        
        

        if (alterar.equals("alterar")) {

            String nomeprod = request.getParameter("nomeprod");
            String codigobarrasprod = request.getParameter("codigoprod");
            String descricaoprod = request.getParameter("descricaoprod");
            String categoriaprod = request.getParameter("categoriaprod");
            double valorprod = Double.parseDouble(request.getParameter("valorprod"));
            int qtdestoque = Integer.valueOf(request.getParameter("qtdestoque"));
            int idloja = 0;
            Produto produtos = new Produto(null, 0, null, null, 0, null);

            produtos = new Produto(nomeprod, valorprod, codigobarrasprod, descricaoprod, qtdestoque, categoriaprod);

            bancoprod.atualizarprod(produtos);

            request.setAttribute("prodAlterado", "Produto Alterado");

            request.getRequestDispatcher("ConsultaProd.jsp").forward(request, response);

        } else if (excluir.equals("excluir")) {

            deletado = bancoprod.deletaprod(String.valueOf(request.getParameter("codigoprod")));

            if (deletado == true) {
                request.getRequestDispatcher("Deletado.jsp").forward(request, response);

            } else {

                System.out.println("falhou na hora de deletar");
            }

        }

    }

}

