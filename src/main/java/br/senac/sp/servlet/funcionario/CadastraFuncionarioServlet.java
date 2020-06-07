package br.senac.sp.servlet.funcionario;
import br.senac.sp.entidade.dao.FuncionarioDao;
import br.senac.sp.entidade.enums.*;
import br.senac.sp.entidade.exception.FuncionarioException;
import br.senac.sp.entidade.model.Funcionario;
import br.senac.sp.servlet.login.filter.JWTUtil;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author joao.lucas
 */
@WebServlet(name = "CadastraFuncionarioServlet", value = "/CadastroFuncionario")
public class CadastraFuncionarioServlet extends HttpServlet{
        private static String INSERIR_OU_EDITAR = "/cadastroFuncionario.jsp";
    private static String LISTA_FUNCIONARIO = "/listaFuncionario.jsp";
    private FuncionarioDao dao = new FuncionarioDao();
     @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        RequestDispatcher view = request.getRequestDispatcher(INSERIR_OU_EDITAR);
        String acao = request.getParameter("action").trim();

            switch (acao) {
                case "listar":
                    view = configuraListaDeFuncionarios(request, view);
                    break;
                case "deletar":
                    view = deletaFuncionario(request,response);
                    break;
                case "editar":
                    view = editaFuncionario(request);
                    break;
            }
            view.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        String acao = "";
        if (request.getParameter("action") != null){
            acao = request.getParameter("action");
        }

        Funcionario funcionario = criaFuncionario(request,acao);


        try {
            if (acao.equals("editar")){
                dao.editar(funcionario);
            }else {
                dao.inserir(funcionario);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        response.sendRedirect("CadastroFuncionario?action=listar");
    }

    private RequestDispatcher configuraListaDeFuncionarios(HttpServletRequest request, RequestDispatcher view) {
        try {
            List<Funcionario> listaDeFuncionario = dao.buscar();
            request.setAttribute("clientes", listaDeFuncionario);
            view = request.getRequestDispatcher(LISTA_FUNCIONARIO);
        } catch (FuncionarioException e) {
            e.printStackTrace();
        }
        return view;
    }

    private RequestDispatcher deletaFuncionario(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("id").trim());
        try {
            Funcionario funcionario = dao.buscaFuncionarioPeloId(id);
            if (request.getSession().getAttribute(JWTUtil.TOKEN_USER_NAME).equals(funcionario.getEmail())){
                response.setStatus(401);
            }else{
                dao.removerFuncionario(id);
                response.setStatus(200);
            }
        } catch (SQLException e) {
            System.out.println("Erro ao deletar funcionario!");
            e.printStackTrace();
        }
        return request.getRequestDispatcher(LISTA_FUNCIONARIO);
    }

    private RequestDispatcher editaFuncionario(HttpServletRequest request) {
        int idUsuario = Integer.parseInt(request.getParameter("id"));
        request.setAttribute("funcionario", dao.buscaFuncionarioPeloId(idUsuario));
        return request.getRequestDispatcher(INSERIR_OU_EDITAR);
    }


    private Funcionario criaFuncionario(HttpServletRequest request, String acao) {
        Funcionario funcionario = new Funcionario();
        funcionario.setNomeUsuario(request.getParameter("nomeFuncionario").trim());
        funcionario.setSobrenomeUsuario(request.getParameter("sobrenomeFuncionario").trim());
        funcionario.setCpf(request.getParameter("cpfFuncionario").trim());
        if (request.getParameter("emailFuncionario") != null){
            funcionario.setEmail(request.getParameter("emailFuncionario").trim());
        }
        if (!request.getParameter("senha").trim().isEmpty()){
            funcionario.setSenha(SenhaUtils.criar(request.getParameter("senha").trim()));
        }
        funcionario.setGenero(ConvertStringForGenero.parse(request.getParameter("generoFuncionario").trim()));
        funcionario.setDepartamento(ConvertStringForDepartamento.parse(request.getParameter("departamento").trim()));
        funcionario.setGenero(ConvertStringForGenero.parse(request.getParameter("generoFuncionario").trim()));
        funcionario.setDataNascimento(request.getParameter("data_nascimento").trim());
        funcionario.setTelefone(request.getParameter("telefone").trim());
        funcionario.setCep(request.getParameter("cepFuncionario").trim());
        funcionario.setRua(request.getParameter("ruaFuncionario").trim());
        funcionario.setBairro(request.getParameter("bairroFuncionario").trim());
        funcionario.setComplemento(request.getParameter("complementoFuncionario").trim());
        funcionario.setCidade(request.getParameter("cidadeFuncionario").trim());
        funcionario.setNumero(Integer.parseInt(request.getParameter("numeroFuncionario").trim()));
        funcionario.setEstado(ConvertStringForUf.parse(request.getParameter("ufFuncionario").trim()));
        funcionario.setSalario(Double.valueOf(request.getParameter("salario")));
        return funcionario;
    }
}