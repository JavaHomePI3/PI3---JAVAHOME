
package br.senac.sp.entidade.dao;

import br.senac.sp.db.ConexaoDB;
import br.senac.sp.entidade.exception.ClienteException;
import br.senac.sp.entidade.model.Cliente;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;



public class ClienteDAO implements Dao<Cliente>{

    private Connection conn;
    private PreparedStatement stmt;
    private Statement st;
    private ResultSet rs;
    private ArrayList listaDeClientes = new ArrayList();
    
    @Override
    public boolean inserir(Cliente entidade) throws SQLException {
        
        try {
            conn = ConexaoDB.getConexao();
            String sql = "INSERT INTO cliente VALUES (default,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
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

            stmt.execute();
            
            return true;
        } catch (SQLException e) {
            throw new ClienteException("Erro ao Cadastrar Cliente!\nErro: " + e.getMessage());
        } finally {
            conn.close();
        }
        
    }

    @Override
    public List<Cliente> buscar() throws ClienteException {

        
        try {
            conn = ConexaoDB.getConexao();
            String sql = "SELECT * FROM cliente";
            stmt = conn.prepareStatement(sql);
            rs = stmt.executeQuery();

            while (rs.next()){
               Cliente cliente = new Cliente();
   
               cliente.setIdUsuario(rs.getInt("id"));
               cliente.setNomeUsuario(rs.getString("nome"));
               cliente.setSobrenomeUsuario(rs.getString("sobrenome"));
               cliente.setCpf(rs.getString("cpf"));
               cliente.setEmail(rs.getString("email"));
               cliente.setGenero(rs.getString("genero").charAt(0));
               cliente.setDataNascimento(rs.getString("data_nascimento"));
               cliente.setTelefone(rs.getString("telefone"));
               cliente.setCep(rs.getString("cep"));
               cliente.setRua(rs.getString("rua"));
               cliente.setBairro(rs.getString("bairro"));
               cliente.setComplemento(rs.getString("complemento"));
               cliente.setCidade(rs.getString("cidade"));
               cliente.setNumero(rs.getInt("numero"));
               cliente.setEstado(rs.getString("estado"));
               listaDeClientes.add(cliente);
            }

            rs.close();

        } catch (SQLException e) {
            throw new ClienteException("Erro ao Cadastrar Cliente!\nErro: " + e.getMessage());
        }
        return listaDeClientes;
    }

    @Override
    public boolean editar(Cliente entidade) throws SQLException {
        
         try {
            conn = ConexaoDB.getConexao();
            String sql = "UPDATE cliente SET " +
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
                     " WHERE cpf = ?";
            
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
            stmt.setString(15, entidade.getCpf());
            stmt.execute();
            
            return true;
        } catch (SQLException e) {
            throw new ClienteException("Erro ao Editar Cliente!\nErro: " + e.getMessage());
        } finally {
            conn.close();
        }
        
    }
    
    public Cliente buscarClientePeloCpf(String cpf) throws SQLException{
        Cliente cliente = new Cliente();
            
        try {
            String sql = "SELECT * FROM cliente WHERE cpf = ?";
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, cpf);
            rs = stmt.executeQuery();
            
            if(rs.next()){
               cliente.setIdUsuario(rs.getInt("id"));
               cliente.setNomeUsuario(rs.getString("nome"));
               cliente.setSobrenomeUsuario(rs.getString("sobrenome"));
               cliente.setCpf(rs.getString("cpf"));
               cliente.setEmail(rs.getString("email"));
               cliente.setGenero(rs.getString("genero").charAt(0));
               cliente.setDataNascimento(rs.getString("data_nascimento"));
               cliente.setTelefone(rs.getString("telefone"));
               cliente.setCep(rs.getString("cep"));
               cliente.setRua(rs.getString("rua"));
               cliente.setBairro(rs.getString("bairro"));
               cliente.setComplemento(rs.getString("complemento"));
               cliente.setCidade(rs.getString("cidade"));
               cliente.setNumero(rs.getInt("numero"));
               cliente.setEstado(rs.getString("estado"));
            }
          
        } catch (SQLException e) {
            throw new ClienteException("Erro ao Buscar Cliente!\nErro: " + e.getMessage());
        } finally {
            conn.close();
        }
        
        return cliente;
       
    }

    public void removerCliente(int idUsuario) throws SQLException {
        
         try {
           String sql = "DELETE FROM cliente where id = " + idUsuario;
           st = conn.createStatement();
           st.execute(sql);
  
            
        } catch (SQLException e) {
            throw new ClienteException("Erro ao Deletar Cliente!\nErro: " + e.getMessage());
        } finally {
            st.close();
        }
     
    }

    @Override
    public boolean remover(Cliente entidade) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
