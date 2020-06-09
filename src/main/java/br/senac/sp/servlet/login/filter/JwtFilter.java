package br.senac.sp.servlet.login.filter;


import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.JwtException;
import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class JwtFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) servletRequest;
        HttpServletResponse res = (HttpServletResponse) servletResponse;
        if (SessionUtils.routerAllowed(req)) {
            filterChain.doFilter(servletRequest, servletResponse);
        } else {
            configuraAcesso(servletRequest, servletResponse, filterChain, req, res);
        }
    }

    private void configuraAcesso(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain, HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {
        validaAutorizacao(req, res);

        String token = "";
        String userName = "";

        if (SessionUtils.validSession(req)) {
            token = req.getSession().getAttribute(JWTUtil.TOKEN_HEADER).toString();
            userName = req.getSession().getAttribute(JWTUtil.TOKEN_USER_NAME).toString();
        }

        if (token.isEmpty()) {
            token = req.getHeader(JWTUtil.TOKEN_HEADER);
        }

        if (token == null || token.isEmpty()) {
            redireciona(res, "login");
            return;
        }

        try {
            redireciona(servletRequest, servletResponse, filterChain, token, userName);
        } catch (JwtException e) {
            redireciona(res, "401.jsp");
        }
    }

    private void redireciona(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain, String token, String userName) throws IOException, ServletException {
        Jws<Claims> parser = JWTUtil.decode(token);
        verificaToken(servletRequest, servletResponse, filterChain, token, userName, parser);
    }

    private void verificaToken(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain, String token, String userName, Jws<Claims> parser) throws IOException, ServletException {
        if (JWTUtil.verifyUser(userName, parser)) {
            System.out.println("User request: " + parser.getBody().getSubject());
            System.out.println("Token: " + token);
            filterChain.doFilter(servletRequest, servletResponse);
        }
    }

    private void validaAutorizacao(HttpServletRequest req, HttpServletResponse res) throws IOException {
        if (SessionUtils.authVendas(req)) {
            redireciona(res, "401.jsp");
        } else if (SessionUtils.authAdm(req)) {
            redireciona(res, "401.jsp");
        } else if (SessionUtils.authBackOffice(req)) {
            redireciona(res, "401.jsp");
        }
    }

    private void redireciona(HttpServletResponse res, String s) throws IOException {
        res.sendRedirect(s);
    }


    @Override
    public void destroy() {
    }
}
