
package br.senac.sp.entidade.dao;

import br.senac.sp.db.ConexaoDB;
import br.senac.sp.entidade.enums.ConvertStringForGenero;
import br.senac.sp.entidade.enums.ConvertStringForUf;
import br.senac.sp.entidade.exception.ClienteException;
import br.senac.sp.entidade.model.Cliente;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;


public class ClienteDAO implements Dao<Cliente> {

    private Connection conn;
    private PreparedStatement stmt;
    private Statement st;
    private ResultSet rs;


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
            stmt.setString(5, String.valueOf(entidade.getGenero()));
            stmt.setString(6, entidade.getDataNascimento());
            stmt.setString(7, entidade.getTelefone());
            stmt.setString(8, entidade.getCep());
            stmt.setString(9, entidade.getRua());
            stmt.setString(10, entidade.getBairro());
            stmt.setString(11, entidade.getComplemento());
            stmt.setString(12, entidade.getCidade());
            stmt.setInt(13, entidade.getNumero());
            stmt.setString(14, String.valueOf(entidade.getEstado()));

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
        List<Cliente> listaDeClientes = new ArrayList<>();
        try {
            conn = ConexaoDB.getConexao();
            String sql = "SELECT * FROM cliente";
            stmt = conn.prepareStatement(sql);
            rs = stmt.executeQuery();

            while (rs.next()) {
                Cliente cliente = new Cliente();

                cliente.setIdUsuario(rs.getInt("id"));
                cliente.setNomeUsuario(rs.getString("nome"));
                cliente.setSobrenomeUsuario(rs.getString("sobrenome"));
                cliente.setCpf(rs.getString("cpf"));
                cliente.setEmail(rs.getString("email"));
                cliente.setGenero(ConvertStringForGenero.parse(rs.getString("genero")));
                cliente.setDataNascimento(rs.getString("data_nascimento"));
                cliente.setTelefone(rs.getString("telefone"));
                cliente.setCep(rs.getString("cep"));
                cliente.setRua(rs.getString("rua"));
                cliente.setBairro(rs.getString("bairro"));
                cliente.setComplemento(rs.getString("complemento"));
                cliente.setCidade(rs.getString("cidade"));
                cliente.setNumero(rs.getInt("numero"));
                cliente.setEstado(ConvertStringForUf.parse(rs.getString("estado")));
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
            Cliente clienteEncontrado = buscarClientePeloCpf(entidade.getCpf());
            conn = ConexaoDB.getConexao();
            if (!entidade.equals(clienteEncontrado)) {

                String sql = "UPDATE cliente SET nome = ?,sobrenome = ?,cpf = ?" +
                        ",email = ?,genero = ?,data_nascimento = ?" +
                        ",telefone = ?,cep = ?,rua = ?,bairro = ?," +
                        "complemento = ?,cidade = ?,numero = ?,estado = ?WHERE cpf = ?";

                stmt = conn.prepareStatement(sql);
                stmt.setString(1, entidade.getNomeUsuario());
                stmt.setString(2, entidade.getSobrenomeUsuario());
                stmt.setString(3, entidade.getCpf());
                stmt.setString(4, entidade.getEmail());
                stmt.setString(5, String.valueOf(entidade.getGenero()));
                stmt.setString(6, entidade.getDataNascimento());
                stmt.setString(7, entidade.getTelefone());
                stmt.setString(8, entidade.getCep());
                stmt.setString(9, entidade.getRua());
                stmt.setString(10, entidade.getBairro());
                stmt.setString(11, entidade.getComplemento());
                stmt.setString(12, entidade.getCidade());
                stmt.setInt(13, entidade.getNumero());
                stmt.setString(14, String.valueOf(entidade.getEstado()));
                stmt.setString(15, entidade.getCpf());
                stmt.executeUpdate();
                return true;
            }
        } catch (SQLException e) {
            throw new ClienteException("Erro ao Editar Cliente!\nErro: " + e.getMessage());
        } finally {
            conn.close();
        }
        return false;
    }

    public Cliente buscaClientePeloId(int id) {
        try {
            conn = ConexaoDB.getConexao();

            String sql = "SELECT * FROM cliente WHERE id = ?";

            stmt = conn.prepareStatement(sql);
            stmt.setInt(1, id);

            rs = stmt.executeQuery();
            if (rs.next()) {
                Cliente cliente = new Cliente();
                cliente.setIdUsuario(rs.getInt("id"));
                cliente.setNomeUsuario(rs.getString("nome"));
                cliente.setSobrenomeUsuario(rs.getString("sobrenome"));
                cliente.setCpf(rs.getString("cpf"));
                cliente.setEmail(rs.getString("email"));
                cliente.setGenero(ConvertStringForGenero.parse(rs.getString("genero")));
                cliente.setDataNascimento(rs.getString("data_nascimento"));
                cliente.setTelefone(rs.getString("telefone"));
                cliente.setCep(rs.getString("cep"));
                cliente.setRua(rs.getString("rua"));
                cliente.setBairro(rs.getString("bairro"));
                cliente.setComplemento(rs.getString("complemento"));
                cliente.setCidade(rs.getString("cidade"));
                cliente.setNumero(rs.getInt("numero"));
                cliente.setEstado(ConvertStringForUf.parse(rs.getString("estado")));

                return cliente;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public Cliente buscarClientePeloCpf(String cpf) throws SQLException {
        conn = ConexaoDB.getConexao();
        Cliente cliente = null;

        try {
            String sql = "SELECT * FROM cliente WHERE cpf = ?";
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, cpf);
            rs = stmt.executeQuery();

            if (rs.next()) {
                cliente = new Cliente();
                cliente.setIdUsuario(rs.getInt("id"));
                cliente.setNomeUsuario(rs.getString("nome"));
                cliente.setSobrenomeUsuario(rs.getString("sobrenome"));
                cliente.setCpf(rs.getString("cpf"));
                cliente.setEmail(rs.getString("email"));
                cliente.setGenero(ConvertStringForGenero.parse(rs.getString("genero")));
                cliente.setDataNascimento(rs.getString("data_nascimento"));
                cliente.setTelefone(rs.getString("telefone"));
                cliente.setCep(rs.getString("cep"));
                cliente.setRua(rs.getString("rua"));
                cliente.setBairro(rs.getString("bairro"));
                cliente.setComplemento(rs.getString("complemento"));
                cliente.setCidade(rs.getString("cidade"));
                cliente.setNumero(rs.getInt("numero"));
                cliente.setEstado(ConvertStringForUf.parse(rs.getString("estado")));

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
