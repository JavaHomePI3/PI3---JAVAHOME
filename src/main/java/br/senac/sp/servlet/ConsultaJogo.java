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
 */
@WebServlet(name = "ConsultaJogo", urlPatterns = {"/ConsultaJogo"})
public class ConsultaJogo extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String consultaJogo = request.getParameter("ConsultaJogo");

        JogoDao selectjogo = new JogoDao();

        Jogos jogos = new Jogos(null, 0, null, null, 0, null,0);
        
        if (consultaJogo.trim() != null) {
            jogos = selectjogo.Pesquisar(consultaJogo);

        }

        if (jogos.getNome()!= null) {

            request.setAttribute("resultado", jogos);

            request.getRequestDispatcher("ConsultaJogoResult.jsp").forward(request, response);

        } else {

            request.setAttribute("resultado", "Jogo não encontrado");

            request.getRequestDispatcher("ConsultaJogo.jsp").forward(request, response);

        }

    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
