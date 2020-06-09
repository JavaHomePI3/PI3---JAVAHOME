package br.senac.sp.servlet.login.filter;

import javax.servlet.http.HttpServletRequest;

public class SessionUtils {
    public static final String AUTH_VENDAS = "VENDAS";
    public static final String AUTH_ADM = "ADM";
    public static final String AUTH_BACK = "BACKOFFICE";

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

    public static boolean authVendas(HttpServletRequest req) {
        if (req.getSession().getAttribute(JWTUtil.TOKEN_AUTH) != null
                && req.getSession().getAttribute(JWTUtil.TOKEN_AUTH).equals(AUTH_VENDAS)) {
            return blockProduto(req) || blockFuncionario(req) || blockRelatorio(req);
        }
        return false;
    }

    public static boolean authAdm(HttpServletRequest req) {
        if (req.getSession().getAttribute(JWTUtil.TOKEN_AUTH) != null
                && req.getSession().getAttribute(JWTUtil.TOKEN_AUTH).equals(AUTH_ADM)) {
            return blockProduto(req)||blockCliente(req)||blockVenda(req);
        }
        return false;
    }
    public static boolean authBackOffice(HttpServletRequest req) {
        if (req.getSession().getAttribute(JWTUtil.TOKEN_AUTH) != null
                && req.getSession().getAttribute(JWTUtil.TOKEN_AUTH).equals(AUTH_BACK)) {
            return blockFuncionario(req)||blockVenda(req) || blockRelatorio(req);
        }
        return false;
    }

    private static boolean blockFuncionario(HttpServletRequest req){
        return  req.getRequestURI().contains("Funcionario")
                || req.getRequestURI().contains("funcionario");
    }

    private static boolean blockProduto(HttpServletRequest req){
        return  req.getRequestURI().contains("Produto")
                || req.getRequestURI().contains("produto");
    }

    private static boolean blockRelatorio(HttpServletRequest req){
        return  req.getRequestURI().contains("relatorio")
                || req.getRequestURI().contains("Relatorio");
    }

    private static boolean blockVenda(HttpServletRequest req){
        return  req.getRequestURI().contains("venda")
                || req.getRequestURI().contains("Venda");
    }

    private static boolean blockCliente(HttpServletRequest req){
        return  req.getRequestURI().contains("cliente")
                || req.getRequestURI().contains("Cliente");
    }
}
