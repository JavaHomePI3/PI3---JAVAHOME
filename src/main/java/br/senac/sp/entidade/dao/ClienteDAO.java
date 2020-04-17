
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


public class ClienteDAO {
    private ArrayList listaDeClientes;

    public static boolean cadastrarCliente(Cliente cliente) {
        boolean ok = false;
        Connection con;
        try {
            con = ConexaoDB.getConexao();
            String sql = "insert into cliente values (default,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, cliente.getNomeUsuario());
            ps.setString(2, cliente.getSobrenomeUsuario());
            ps.setString(3, cliente.getCpf());
            ps.setString(4, cliente.getEmail());
            ps.setString(5, cliente.getGenero().toString());
            ps.setDate(6, (Date) cliente.getDataNascimento());
            ps.setString(7, cliente.getTelefone());
            ps.setString(8, cliente.getCep());
            ps.setString(9, cliente.getRua());
            ps.setString(10, cliente.getBairro());
            ps.setString(11, cliente.getComplemento());
            ps.setString(12, cliente.getCidade());
            ps.setInt(13, cliente.getNumero());
            ps.setString(14, cliente.getEstado());
            
            ps.execute();
            ok = true;
        } catch (SQLException ex) {
            Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
       return ok;
    }

    public List<Cliente> getClientes(){
        Connection con;
        listaDeClientes = new ArrayList();
        try {
            con = ConexaoDB.getConexao();
            String sql = "SELECT * FROM cliente";
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            while (rs.next()){
//                listaDeClientes.add(new Cliente(
//                        rs.getInt("id"),
//                        rs.getInt("nomeUsuario"),
//                        rs.getString("sobreNome"),
//                        rs.getString("cpf"), 
//                        rs.getString("email"), 
//                        rs.getString("genero"),
//                        rs.getString("genero"),
//                        rs.getString("genero"),
//                        rs.getString("genero"),
//                        rs.getString("genero"),
//                        rs.getString("genero"),
//                        rs.getString("genero"),
//                        rs.getString("genero"),
//                        rs.getString("genero"),
//                        rs.getString("genero"),
//                        rs.getString("genero")));
               
            }
            ps.close();
            rs.close();

        } catch (SQLException ex) {
            Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listaDeClientes;
    }
}
