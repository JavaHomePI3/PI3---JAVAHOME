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
    public void init(FilterConfig filterConfig) throws ServletException { }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) servletRequest;
        HttpServletResponse res = (HttpServletResponse) servletResponse;

        System.out.println(req.getRequestURI());
        if (SessionUtils.routerAllowed(req)) {
            filterChain.doFilter(servletRequest, servletResponse);
        } else {
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
                res.sendRedirect("login");
                return;
            }

            try {
                    Jws<Claims> parser = JWTUtil.decode(token);
                    if (JWTUtil.verifyUser(userName, parser)) {
                        System.out.println("User request: " + parser.getBody().getSubject());
                        System.out.println("Token: " + token);
                        filterChain.doFilter(servletRequest, servletResponse);
                    }
            } catch (JwtException e) {
                res.sendRedirect("/401.jsp");
            }
        }
    }

    @Override
    public void destroy() { }
}
