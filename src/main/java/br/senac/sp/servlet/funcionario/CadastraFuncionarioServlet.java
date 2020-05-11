package br.senac.sp.servlet.funcionario;
import br.senac.sp.entidade.dao.FuncionarioDAO;
import br.senac.sp.entidade.enums.ConvertStringForGenero;
import br.senac.sp.entidade.enums.ConvertStringForUf;
import br.senac.sp.entidade.enums.Genero;
import br.senac.sp.entidade.enums.Uf;
import br.senac.sp.entidade.exception.FuncionarioException;
import br.senac.sp.entidade.model.Funcionario;
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
/**
 *
 * @author joao.lucas
 */
@WebServlet(name = "CadastraFuncionarioServlet", value = "/CadastroFuncionario")
public class CadastraFuncionarioServlet extends HttpServlet{
        private static String INSERIR_OU_EDITAR = "/cadastroFuncionario.jsp";
    private static String LISTA_FUNCIONARIO = "/listaFuncionario.jsp";
    private FuncionarioDAO dao = new FuncionarioDAO();
     @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        RequestDispatcher view = request.getRequestDispatcher(INSERIR_OU_EDITAR);
        String acao = request.getParameter("action");
        if (acao != null) {
            switch (acao) {
                case "listar":
                    view = configuraListaDeFuncionarios(request, view);
                    break;
                case "deletar":
                    view = deletaFuncionario(request);
                    break;
                case "editar":
                    view = editaFuncionario(request);
                    break;
            }
        }
        view.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        Funcionario funcionario = criaFuncionario(request);
        String acao = request.getParameter("acao");

        try {
            if (acao != null){
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
            request.setAttribute("funcionarios", listaDeFuncionario);
            view = request.getRequestDispatcher(LISTA_FUNCIONARIO);
        } catch (FuncionarioException e) {
            e.printStackTrace();
        }
        return view;
    }

    private RequestDispatcher deletaFuncionario(HttpServletRequest request) {
        int id = Integer.parseInt(request.getParameter("id"));
        try {
            dao.removerFuncionario(id);
        } catch (SQLException e) {
            System.out.println("Erro ao deletar funcionario!");
            e.printStackTrace();
        }
        return request.getRequestDispatcher(LISTA_FUNCIONARIO);
    }

    private RequestDispatcher editaFuncionario(HttpServletRequest request) {
        int idUsuario = Integer.parseInt(request.getParameter("id"));
        request.setAttribute("funcionario", dao.buscaFuncionarioPeloId(idUsuario));
        request.setAttribute("action","editar");
        RequestDispatcher view = request.getRequestDispatcher(INSERIR_OU_EDITAR);
        return view;
    }


    private Funcionario criaFuncionario(HttpServletRequest request) {
        Funcionario funcionario = new Funcionario();

        funcionario.setNomeUsuario(request.getParameter("nomeFuncionario"));
        funcionario.setSobrenomeUsuario(request.getParameter("sobrenomeFuncionario"));
        funcionario.setCpf(request.getParameter("cpfCFuncionario"));
        funcionario.setEmail(request.getParameter("emailFuncionario"));
        funcionario.setGenero(ConvertStringForGenero.parse(request.getParameter("generoFuncionario")));
        String dataDeNascimento = request.getParameter("data_nascimento");
        funcionario.setDataNascimento(dataDeNascimento);
        funcionario.setTelefone(request.getParameter("telefoneFuncionario"));
        funcionario.setCep(request.getParameter("cepFuncionario"));
        funcionario.setRua(request.getParameter("ruaFuncionario"));
        funcionario.setBairro(request.getParameter("bairroFuncionario"));
        funcionario.setComplemento(request.getParameter("complementoFuncionario"));
        funcionario.setCidade(request.getParameter("cidadeFuncionario"));
        funcionario.setNumero(Integer.parseInt(request.getParameter("numeroFuncionario")));
        funcionario.setEstado(ConvertStringForUf.parse(request.getParameter("ufFuncionario")));
        return funcionario;
    }
}