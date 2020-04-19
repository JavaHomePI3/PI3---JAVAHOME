package br.senac.sp.servlet.venda;

import br.senac.sp.entidade.dao.VendaDao;
import br.senac.sp.entidade.model.Venda;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

@WebServlet(name = "cadastraVendaServlet",value = "/cadastraVenda")
public class CadastraVendaServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) {
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        VendaDao dao = new VendaDao();
        try {
            List<Venda> listaProduto = dao.buscar();
            request.setAttribute("produto",listaProduto);
            RequestDispatcher requestDispatcher = request.getRequestDispatcher("/cadastraVenda.jsp");
            requestDispatcher.forward(request,response);
        } catch (SQLException e) {
            Logger.getLogger(VendaDao.class.getName()).log(Level.SEVERE, null, e);
        }
    }
}
