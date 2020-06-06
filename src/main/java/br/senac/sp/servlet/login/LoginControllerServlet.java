package br.senac.sp.servlet.login;

import br.senac.sp.entidade.dao.LoginDao;
import br.senac.sp.servlet.login.filter.JWTUtil;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "LoginControllerServlet", value = "/login")
public class LoginControllerServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if (req.getParameter("sair")!= null){
            req.getSession().invalidate();
        }
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("/login.jsp");
        requestDispatcher.forward(req, resp);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if (req.getParameter("email") != null && req.getParameter("password") != null ){
            Credentials credentials = new Credentials(req.getParameter("email").trim(),req.getParameter("password").trim());
            boolean auth = new LoginDao().auth(credentials);
            if(auth){
                String token = JWTUtil.create(credentials.getEmail());
                req.getSession().setAttribute(JWTUtil.TOKEN_HEADER,token);
                req.getSession().setAttribute(JWTUtil.TOKEN_USER_NAME,credentials.getEmail());
                resp.sendRedirect("index.jsp");
            } else{

                resp.sendRedirect("login");
            }
        }
    }
}
