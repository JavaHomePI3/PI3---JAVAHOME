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

    public static final String EMAIL = "email";
    public static final String PASSWORD = "password";
    public static final String INDEX_JSP = "index.jsp";
    public static final String URL_LOGIN = "login";
    public static final String PAGE_LOGIN_JSP = "/login.jsp";
    public static final String SAIR = "sair";

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if (req.getParameter(SAIR)!= null){
            req.getSession().invalidate();
        }
        RequestDispatcher requestDispatcher = req.getRequestDispatcher(PAGE_LOGIN_JSP);
        requestDispatcher.forward(req, resp);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if (req.getParameter(EMAIL) != null && req.getParameter(PASSWORD) != null ){
            Credentials credentials = new Credentials(req.getParameter(EMAIL).trim(),req.getParameter(PASSWORD).trim());
            boolean auth = new LoginDao().auth(credentials);
            if(auth){
                String token = JWTUtil.create(credentials.getEmail());
                setAuth(req, credentials, token);
                resp.sendRedirect(INDEX_JSP);
            } else{
                resp.sendRedirect(URL_LOGIN);
            }
        }
    }

    private void setAuth(HttpServletRequest req, Credentials credentials, String token) {
        req.getSession().setAttribute(JWTUtil.TOKEN_HEADER,token);
        req.getSession().setAttribute(JWTUtil.TOKEN_USER_NAME,credentials.getEmail());
        req.getSession().setAttribute(JWTUtil.TOKEN_AUTH,credentials.getAuth());
    }
}
