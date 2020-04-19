
package br.senac.sp.entidade.dao;

import br.senac.sp.db.ConexaoDB;
import br.senac.sp.entidade.model.Cliente;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;


public class ClienteDAO implements Dao<Cliente>{

    @Override
    public boolean inserir(Cliente entidade) {
        Connection con;
        try {
            con = ConexaoDB.getConexao();
            String sql = "insert into cliente values (default,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, entidade.getNomeUsuario());
            ps.setString(2, entidade.getSobrenomeUsuario());
            ps.setString(3, entidade.getCpf());
            ps.setString(4, entidade.getEmail());
            ps.setString(5, entidade.getGenero().toString());
            ps.setDate(6, (Date) entidade.getDataNascimento());
            ps.setString(7, entidade.getTelefone());
            ps.setString(8, entidade.getCep());
            ps.setString(9, entidade.getRua());
            ps.setString(10, entidade.getBairro());
            ps.setString(11, entidade.getComplemento());
            ps.setString(12, entidade.getCidade());
            ps.setInt(13, entidade.getNumero());
            ps.setString(14, entidade.getEstado());

            ps.execute();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    @Override
    public List<Cliente> buscar() {
        Connection con;
        ArrayList listaDeClientes = new ArrayList();
        try {
            con = ConexaoDB.getConexao();
            String sql = "SELECT * FROM cliente";
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            while (rs.next()){
//                listaDeClientes.add(new Cliente(
//                        rs.getInt("id"),
//                        rs.getString("nome"),
//                        rs.getString("email")
//                ));
            }

            ps.close();
            rs.close();

        } catch (SQLException ex) {
            Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listaDeClientes;
    }

    @Override
    public boolean editar(Cliente entidade) {
        return false;
    }

    @Override
    public boolean remover(Cliente entidade) {
        return false;
    }
}
