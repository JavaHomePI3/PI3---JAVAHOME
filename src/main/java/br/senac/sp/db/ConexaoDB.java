/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.sp.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author tiago.bscarton
 */
public class ConexaoDB {
    private static Connection CONEXAO;
    static {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ConexaoDB.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static Connection getConexao() throws SQLException {
        if ( CONEXAO == null){
            String dbURL = "jdbc:mysql://localhost/senac?useTimezone=true&serverTimezone=UTC";
            String user = "senac";
            String password = "senac";
            CONEXAO = DriverManager.getConnection(dbURL, user, password);
            return CONEXAO;
        }
       return CONEXAO;
    }

    public Connection getConnection() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public int idloja(String sessaoid) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public int idLoja(String sessaoid) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
