/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.sp.servlet;

import br.senac.sp.db.ConexaoDB;
import br.senac.sp.entidade.dao.ProdutosDao;
import br.senac.sp.entidade.model.Produto;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Vitoria Cristina
 */
@WebServlet(name = "CadastrarProd", urlPatterns = {"/CadastrarProd"})

public class CadastrarProd extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        HttpSession sessao = request.getSession();

        ConexaoDB bancosessao = new ConexaoDB();
        String sessaoid = sessao.getId();

        String nomeprod = request.getParameter("nomeprod");
        String codigobarrasprod = request.getParameter("codigoprod");
        String descricaoprod = request.getParameter("descricaoprod");
        String categoriaprod = request.getParameter("categoriaprod");
        double valorprod = Double.parseDouble(request.getParameter("valorprod"));
        int qtdestoque = Integer.valueOf(request.getParameter("qtdestoque"));
        int idloja = bancosessao.idLoja(sessaoid);

        Produto produtos = new Produto(null, 0, null, null, 0, null, 0);

        ProdutosDao bancoprod = new ProdutosDao();

        boolean repetido = bancoprod.validacadastradoprod(codigobarrasprod);

        if (repetido == false) {
            produtos = new Produto(nomeprod, valorprod, codigobarrasprod, descricaoprod, qtdestoque, categoriaprod, idloja);

            bancoprod.gravarproduto(produtos);

            request.setAttribute("mensagem", "Produto Cadastrado com sucesso!");

            request.getRequestDispatcher("CadastrarProd.jsp").forward(request, response);

        } else {

            request.setAttribute("codigobarras", codigobarrasprod);
            
            request.setAttribute("mensagem", "Já Cadastrado");

            request.getRequestDispatcher("CadastrarProd.jsp").forward(request, response);

        }

    }

}

