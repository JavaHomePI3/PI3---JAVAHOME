package br.senac.sp.token.filter;


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

        System.out.println(req.getRequestURI());
        if(req.getRequestURI().contains("/login") ||
                req.getRequestURI().contains("/vendor") ||
                req.getRequestURI().contains("/css" )){
            filterChain.doFilter(servletRequest, servletResponse);
        }else{
            String token = "";
            if (req.getSession(false) != null && req.getSession().getAttribute(JWTUtil.TOKEN_HEADER) != null){
                 token = req.getSession().getAttribute(JWTUtil.TOKEN_HEADER).toString();
            }

            if (token.trim().isEmpty()){
                token = req.getHeader(JWTUtil.TOKEN_HEADER);
            }

            if(token == null || token.trim().isEmpty()){
                res.sendRedirect("login");
                return;
            }

            try {
                Jws<Claims> parser = JWTUtil.decode(token);
                System.out.println("User request: "+ parser.getBody().getSubject());
                System.out.println("Token: "+ token);
                filterChain.doFilter(servletRequest, servletResponse);
            } catch (JwtException e) {
                res.sendRedirect("login");
            }
        }
    }

    @Override
    public void destroy() {

    }

}
