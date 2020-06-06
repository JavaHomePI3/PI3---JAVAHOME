package br.senac.sp.servlet.login.filter;

import javax.servlet.http.HttpServletRequest;

public class SessionUtils {
    public static boolean validSession(HttpServletRequest req) {
        return req.getSession(false) != null &&
                req.getSession().getAttribute(JWTUtil.TOKEN_HEADER) != null &&
                req.getSession().getAttribute(JWTUtil.TOKEN_USER_NAME) != null;
    }

    public static boolean routerAllowed(HttpServletRequest req) {
        return req.getRequestURI().contains("/login") ||
                req.getRequestURI().contains("/vendor") ||
                req.getRequestURI().contains("/css") ||
                req.getRequestURI().contains("/401.jsp") ||
                req.getRequestURI().contains("/404.jsp");
    }
}
