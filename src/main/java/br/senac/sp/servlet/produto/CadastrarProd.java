/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.sp.servlet.produto;

import br.senac.sp.entidade.dao.ProdutosDao;
import br.senac.sp.entidade.model.Produto;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 *
 * @author Vitoria Cristina
 */
@WebServlet(name = "CadastrarProd", value = "/cadastraProduto")

public class CadastrarProd extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String nomeprod = request.getParameter("nomeprod");
        String codigobarrasprod = request.getParameter("codigoprod");
        String descricaoprod = request.getParameter("descricaoprod");
        String categoriaprod = request.getParameter("categoriaprod");
        double valorprod = Double.parseDouble(request.getParameter("valorprod"));
        int qtdestoque = Integer.valueOf(request.getParameter("qtdestoque"));

        Produto produtos;
        ProdutosDao dao = new ProdutosDao();

        boolean repetido = dao.validacadastradoprod(codigobarrasprod);

        if (repetido == false) {
            produtos = new Produto(nomeprod, valorprod, codigobarrasprod, descricaoprod, qtdestoque, categoriaprod);

            dao.gravarproduto(produtos);

            request.setAttribute("mensagem", "Produto Cadastrado com sucesso!");
            request.getRequestDispatcher("CadastrarProd.jsp").forward(request, response);

        } else {

            request.setAttribute("codigobarras", codigobarrasprod);
            request.setAttribute("mensagem", "Já Cadastrado");
            request.getRequestDispatcher("CadastrarProd.jsp").forward(request, response);

        }

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/CadastrarProd.jsp");
        requestDispatcher.forward(request,response);
    }
}

