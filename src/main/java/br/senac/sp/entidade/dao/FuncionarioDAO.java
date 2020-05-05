package br.senac.sp.entidade.dao;

import br.senac.sp.db.ConexaoDB;
import br.senac.sp.entidade.enums.ConvertStringForGenero;
import br.senac.sp.entidade.enums.ConvertStringForUf;
import br.senac.sp.entidade.exception.FuncionarioException;
import br.senac.sp.entidade.model.Funcionario;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author joao.lucas
 */

public class FuncionarioDAO {
    private Connection conn;
    private PreparedStatement stmt;
    private Statement st;
    private ResultSet rs;
    private ArrayList listaDeFuncionario = new ArrayList();
    
    @Override
    public boolean inserir(Funcionario entidade) throws SQLException {
        
        try {
            conn = ConexaoDB.getConexao();
            String sql = "INSERT INTO funcionario VALUES (default,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, entidade.getNomeUsuario());
            stmt.setString(2, entidade.getSobrenomeUsuario());
            stmt.setString(3, entidade.getCpf());
            stmt.setString(4, entidade.getEmail());
            stmt.setString(5, entidade.getGenero().toString());
            stmt.setString(6, entidade.getDataNascimento());
            stmt.setString(7, entidade.getTelefone());
            stmt.setString(8, entidade.getCep());
            stmt.setString(9, entidade.getRua());
            stmt.setString(10, entidade.getBairro());
            stmt.setString(11, entidade.getComplemento());
            stmt.setString(12, entidade.getCidade());
            stmt.setInt(13, entidade.getNumero());
            stmt.setString(14, entidade.getEstado());
            stmt.setString(15, entidade.getDepartamento());
            stmt.setString(16, entidade.getCargo());
            stmt.setDouble(17, entidade.getSalario());

            stmt.execute();
            
            return true;
        } catch (SQLException e) {
            throw new FuncionarioException("Erro ao Cadastrar Funcionario!\nErro: " + e.getMessage());
        } finally {
            conn.close();
        }
        
    }

    @Override
    public List<Funcionario> buscar() throws FuncionarioException {
        
        
        try {
            String sql = "SELECT * FROM funcionario";
            conn = ConexaoDB.getConexao();
            rs = st.executeQuery(sql);

            while (rs.next()){
               Funcionario funcionario = new Funcionario();
   
               funcionario.setIdUsuario(rs.getInt("id_funcionario"));
               funcionario.setNomeUsuario(rs.getString("nome"));
               funcionario.setSobrenomeUsuario(rs.getString("sobrenome"));
               funcionario.setCpf(rs.getString("cpf"));
               funcionario.setEmail(rs.getString("email"));
               funcionario.setGenero(rs.getString("genero").charAt(0));
               funcionario.setDataNascimento(rs.getString("data_nascimento"));
               funcionario.setTelefone(rs.getString("telefone"));
               funcionario.setCep(rs.getString("cep"));
               funcionario.setRua(rs.getString("rua"));
               funcionario.setBairro(rs.getString("bairro"));
               funcionario.setComplemento(rs.getString("complemento"));
               funcionario.setCidade(rs.getString("cidade"));
               funcionario.setNumero(rs.getInt("numero"));
               funcionario.setEstado(rs.getString("estado"));
               funcionario.setDepartamento(rs.getString("departamento"));
               funcionario.setCargo(rs.getString("cargo"));
               funcionario.setSalario(rs.getDouble("salario"));
               listaDefuncionario.add(funcionario);
            }

            rs.close();

        } catch (SQLException e) {
            throw new FuncionarioException("Erro ao listar Funcionario!\nErro: " + e.getMessage());
        }
        return listaDeFuncionario;
    }

    @Override
    public boolean editar(Funcionario entidade) throws SQLException {
        
         try {
            conn = ConexaoDB.getConexao();
            String sql = "UPDATE funcionario SET (" +
                     "nome = ?," +
                     "sobrenome = ?," +
                     "cpf = ?," +
                     "email = ?" +
                     "genero = ?" +
                     "data_nascimento = ?," +
                     "telefone = ?," +
                     "cep = ?," +
                     "rua = ?," +
                     "bairro = ?," +
                     "complemento = ?," +
                     "cidade = ?," +
                     "numero = ?," +
                     "estado = ?" +
                     "departamento = ?" +
                     "cargo = ?" +
                     "salario = ?" +
                     " WHERE id_usuario = ?";
            
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, entidade.getNomeUsuario());
            stmt.setString(2, entidade.getSobrenomeUsuario());
            stmt.setString(3, entidade.getCpf());
            stmt.setString(4, entidade.getEmail());
            stmt.setString(5, entidade.getGenero().toString());
            stmt.setString(6, entidade.getDataNascimento());
            stmt.setString(7, entidade.getTelefone());
            stmt.setString(8, entidade.getCep());
            stmt.setString(9, entidade.getRua());
            stmt.setString(10, entidade.getBairro());
            stmt.setString(11, entidade.getComplemento());
            stmt.setString(12, entidade.getCidade());
            stmt.setInt(13, entidade.getNumero());
            stmt.setString(14, entidade.getEstado());
            stmt.setString(15, entidade.getCargo());
            stmt.setString(16, entidade.getDepartamento());
            stmt.setDouble(17, entidade.getSalario());
            stmt.setInt(18, entidade.getIdUsuario());
            stmt.execute();
            
            return true;
        } catch (SQLException e) {
            throw new FuncionarioException("Erro ao Editar Funcionario!\nErro: " + e.getMessage());
        } finally {
            conn.close();
        }
        
    }
    
    public Funcionario buscarFuncionarioPeloCpf(String cpf) throws SQLException{
        Funcionario funcionario = new Funcionario();
            
        try {
            String sql = "SELECT * FROM funcionario WHERE cpf = ?";
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, cpf);
            rs = stmt.executeQuery();
            
            if(rs.next()){
               funcionario.setIdUsuario(rs.getInt("id_funcionario"));
               funcionario.setNomeUsuario(rs.getString("nome"));
               funcionario.setSobrenomeUsuario(rs.getString("sobrenome"));
               funcionario.setCpf(rs.getString("cpf"));
               funcionario.setEmail(rs.getString("email"));
               funcionario.setGenero(rs.getString("genero").charAt(0));
               funcionario.setDataNascimento(rs.getString("data_nascimento"));
               funcionario.setTelefone(rs.getString("telefone"));
               funcionario.setCep(rs.getString("cep"));
               funcionario.setRua(rs.getString("rua"));
               funcionario.setBairro(rs.getString("bairro"));
               funcionario.setComplemento(rs.getString("complemento"));
               funcionario.setCidade(rs.getString("cidade"));
               funcionario.setNumero(rs.getInt("numero"));
               funcionario.setEstado(rs.getString("estado"));
               funcionario.setDepartamento(rs.getString("departamento"));
               funcionario.setCargo(rs.getString("cargo"));
               funcionario.setSalario(rs.getDouble("salario"));
               listaDefuncionario.add(funcionario);
            }
          
        } catch (SQLException e) {
            throw new FuncionarioException("Erro ao Buscar Funcionario!\nErro: " + e.getMessage());
        } finally {
            conn.close();
        }
        
        return funcionario;
       
    }

    public void removerFuncionario(int idUsuario) throws SQLException {
        
         try {
           String sql = "DELETE FROM funcionario where id_funcionario = " + idUsuario;
           st = conn.createStatement();
           st.execute(sql);
  
            
        } catch (SQLException e) {
            throw new FuncionarioException("Erro ao Deletar Funcionario!\nErro: " + e.getMessage());
        } finally {
            st.close();
        }
    }
}
