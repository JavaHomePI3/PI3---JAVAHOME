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
@WebServlet(name = "ConsultaProd", value = "/consultaProduto")
public class ConsultaProd extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) {
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String consultaProd = request.getParameter("ConsultaProd");
        ProdutosDao selectprod = new ProdutosDao();
        Produto produtos = new Produto(null, 0, null, null, 0, null);

        if (consultaProd.trim() != null) {

            produtos = selectprod.PesquisarProduto(consultaProd);

            System.out.println("to aqui");

        }

        if (produtos.getNomeprod() != null) {

            request.setAttribute("resultado", produtos);

            request.getRequestDispatcher("ConsultaProdResult.jsp").forward(request, response);

        } else {

            request.setAttribute("resultado", "Produto não encontado");

            request.getRequestDispatcher("ConsultaProd.jsp").forward(request, response);

        }

    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
