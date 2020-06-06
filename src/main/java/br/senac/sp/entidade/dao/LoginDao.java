package br.senac.sp.entidade.dao;

import br.senac.sp.db.ConexaoDB;
import br.senac.sp.servlet.funcionario.SenhaUtils;
import br.senac.sp.servlet.login.Credentials;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class LoginDao {
    private Connection conn;
    private PreparedStatement stmt;
    private ResultSet rs;

    public boolean auth(Credentials credentials){
        try {
            conn = ConexaoDB.getConexao();
            String hash = SenhaUtils.criar(credentials.getPassword());
            String sql = "SELECT email,senha FROM funcionario where email='"+credentials.getEmail()+"'AND senha ='"+hash+"'";
            stmt = conn.prepareStatement(sql);
            rs = stmt.executeQuery();
            if (rs.first()){
                String axuEmail = rs.getString("email");
                String auxSenha = rs.getString("senha");
                System.out.println(axuEmail);
                return axuEmail.equals(credentials.getEmail()) && auxSenha.equals(hash) ;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            try {
                conn.close();
                rs.close();
                stmt.close();
            } catch (SQLException e) {
               throw new RuntimeException(e.getMessage());
            }
        }
        return false;
    }
}
