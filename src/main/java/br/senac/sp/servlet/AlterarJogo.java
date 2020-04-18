/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.sp.servlet;

import br.senac.sp.entidade.dao.JogoDao;
import br.senac.sp.entidade.model.Jogos;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Vitoria Cristina
 * 
 */
@WebServlet(name = "AlterarJogo", urlPatterns = {"/AlterarJogo"})

public class AlterarJogo extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        boolean deletado = false;
        JogoDao banco = new JogoDao();

        String alterar = String.valueOf(request.getParameter("alterar"));
        String excluir = String.valueOf(request.getParameter("excluir"));

        if (alterar.equals("alterar")) {

            String nome = request.getParameter("nome");
            String codigobarras = request.getParameter("codigo");
            String descricao = request.getParameter("descricao");
            String categoria= request.getParameter("categoria");
            double valor = Double.parseDouble(request.getParameter("valor"));
            int qtdestoque = Integer.valueOf(request.getParameter("qtdestoque"));
            int idloja = 0;
            Jogos jogo = new Jogos(null, 0, null, null, 0, null,0);

            jogo = new Jogos(nome, valor, codigobarras, descricao, qtdestoque, categoria, idloja);

            banco.atualizar(jogo);

            request.getRequestDispatcher("CadastradoSuccess.jsp").forward(request, response);

        } else if (excluir.equals("excluir")) {

            deletado = banco.deleta(String.valueOf(request.getParameter("codigo")));

            if (deletado == true) {
                request.getRequestDispatcher("Deletado.jsp").forward(request, response);

            }else{
                
                System.out.println("falhou na hora de deletar");
            }

        }

    }

}

