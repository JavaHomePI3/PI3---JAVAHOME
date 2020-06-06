package br.senac.sp.token;

import br.senac.sp.token.filter.JWTUtil;
import com.google.gson.Gson;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "LoginControllerServlet", value = "/login")
public class LoginControllerServlet extends HttpServlet {

    private final String USERNAME = "admin@hotmail.com";
    private final String PASSWORD = "Admin81776279-9";

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

            if(this.USERNAME.equals(credentials.getEmail()) && this.PASSWORD.equals(credentials.getPassword())){
                String token = JWTUtil.create(credentials.getEmail());
                UserLogged me = new UserLogged();
                me.setUsername(credentials.getEmail());
                me.setToken(token);
                req.getSession().setAttribute(JWTUtil.TOKEN_HEADER,token);
                RequestDispatcher requestDispatcher = req.getRequestDispatcher("/index.jsp");
                requestDispatcher.forward(req, resp);
            } else{

                resp.sendRedirect("404.jsp");
            }
        }
    }
}
