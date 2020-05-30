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


public class ConexaoDB {
    static {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ConexaoDB.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static Connection getConexao() throws SQLException {

        //mysql://
        // user: b6ebe10989a5f3
        // senha: 1133ac46
        // host: us-cdbr-east-05.cleardb.net
        // /heroku_77b37ec5c6ca4dc?reconnect=true
        String dbURL = "jdbc:mysql://us-cdbr-east-05.cleardb.net/heroku_77b37ec5c6ca4dc?reconnect=true";
        String user = "b6ebe10989a5f3";
        String password = "1133ac46";
        return DriverManager.getConnection(dbURL, user, password);
    }
}
