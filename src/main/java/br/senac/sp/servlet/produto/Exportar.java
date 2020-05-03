/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.sp.servlet.produto;

import br.senac.sp.entidade.dao.ProdutosDao;
import br.senac.sp.entidade.model.Produto;
import java.awt.List;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Vitoria Cristina
 */
@WebServlet(name = "Exportar", urlPatterns = {"/Exportar"})
public class Exportar extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String exportartipo = request.getParameter("exportar");

        if (exportartipo.equals("ExportarProdutos")) {

            System.out.println("entrei aqui");

            ProdutosDao bancoprod = new ProdutosDao();

            ResultSet exportarprod = bancoprod.PesquisarProdutosGeral();

            if (exportarprod != null) {

                request.setAttribute("exportarprodutos", exportarprod);
                request.getRequestDispatcher("Exportar/ExportProdutos.jsp").forward(request, response);
            }

        }
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
