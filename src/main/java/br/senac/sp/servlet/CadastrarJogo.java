/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.sp.servlet;

import br.senac.sp.db.ConexaoDB;
import br.senac.sp.entidade.dao.JogoDao;
import br.senac.sp.entidade.model.Jogos;
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
 * 
 */
@WebServlet(name = "CadastrarJogo", urlPatterns = {"/CadastrarJogo"})

public class CadastrarJogo extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        HttpSession sessao = request.getSession();

        ConexaoDB bancosessao = new ConexaoDB();
        String sessaoid = sessao.getId();
        String nome = request.getParameter("nome");
        String codigobarras = request.getParameter("codigo");
        String descricao = request.getParameter("descricao");
        String categoria = request.getParameter("categoria");
        double valor = Double.parseDouble(request.getParameter("valor"));
        int qtdestoque = Integer.valueOf(request.getParameter("qtdestoque"));
        int idloja = bancosessao.idloja(sessaoid);

        Jogos jogo = new Jogos(null, 0, null, null, 0, null, 0);

        JogoDao banco = new JogoDao();

        int qtdjogocadastrado = banco.validacadastrado(codigobarras);

        if (qtdjogocadastrado == 0) {

            jogo = new Jogos(nome, valor, codigobarras, descricao, qtdestoque, categoria, idloja);

            banco.gravarjogo(jogo);

            request.setAttribute("mensagem", "Jogo Cadastrado com sucesso!");

            request.getRequestDispatcher("CadastrarJogo.jsp").forward(request, response);

        } else {

            request.setAttribute("codigobarras", codigobarras);
            request.setAttribute("mensagem", "Já Cadastrado");

            request.getRequestDispatcher("CadastrarJogo.jsp").forward(request, response);

        }

    }

}
