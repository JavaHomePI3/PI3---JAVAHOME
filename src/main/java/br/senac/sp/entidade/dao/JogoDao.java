/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.sp.entidade.dao;

import br.senac.sp.db.ConexaoDB;
import br.senac.sp.entidade.model.Jogos;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author Vitoria Cristina
 */
public class JogoDao {
     private Connection conexao = null;

    Jogos jogo = new Jogos(null, 0, null, null, 0, null, 0);

    private java.util.List<Jogos> lista = new ArrayList<Jogos>();

    public void gravarjogo(Jogos jogos) {

        ConexaoDB bancoconexao = new ConexaoDB();

        try {

            Connection conexao = bancoconexao.getConnection();

            java.sql.Statement st = conexao.createStatement();
            st.executeUpdate("INSERT INTO jogos (codigobarras, nome,valor,"
                    + "datacadastro, descricao,categoria, quantidade, idloja)"
                    + " VALUES ('" + jogo.getCodigobarras()+ "','" + jogo.getNome()
                    + "'," + jogo.getValor()+ ",now(),'"
                    + jogo.getDescricao() + "','" + jogo.getCategoria() + "'," + jogo.getQtdestoque() + ","+jogo.getIdloja()+");");

            conexao.close();

        } catch (Exception e) {

            System.out.println("erro" + e.getMessage());

        }

    }

    public void atualizar(Jogos jogo) {

        ConexaoDB bancoconexao = new ConexaoDB();

        try {

            Connection conexao = bancoconexao.getConnection();

            java.sql.Statement st = conexao.createStatement();
            st.executeUpdate("UPDATE jogos set codigobarras = '" + jogo.getCodigobarras()+ "', nome = '" + jogo.getNome() + "',"
                    + "valor = " + jogo.getValor() + ",descricao = '" + jogo.getDescricao() + "',categoria = '" + jogo.getCategoria() + "',"
                    + "quantidade = " + jogo.getQtdestoque()+ " where codigobarras = '" + jogo.getCodigobarras()+ "'");

            conexao.close();

            System.out.println("fiz o update jogo");

        } catch (Exception e) {

            System.out.println("erro" + e.getMessage());

        }

    }

    public Jogos Pesquisar(String busca) {

        String select = "";

        ConexaoDB bancoconexao = new ConexaoDB();

        try {
            Class.forName("com.mysql.jdbc.Driver");

            conexao = bancoconexao.getConnection();

            java.sql.Statement st = conexao.createStatement();
            select = "select * from jogos where codigobarras = '" + busca.trim() + "'";
            ResultSet result = st.executeQuery(select);

            while (result.next()) {

                jogo.setCodigobarras(result.getString("codigobarras"));
                jogo.setNome(result.getString("nome"));
                jogo.setValor(result.getDouble("valor"));
                jogo.setDtCadastro(result.getDate("datacadastro"));
                jogo.setDescricao(result.getString("descricao"));
                jogo.setCategoria(result.getString("categoria"));
                jogo.setQtdestoque(result.getInt("quantidade"));


            }

            conexao.close();

        } catch (Exception e) {

            System.out.println("erro" + e.getMessage());

        }

        return jogo;
    }

    public int validacadastrado(String busca) {

        String select = "";

        int qtdjogocadastrado = 0;

        ConexaoDB bancoconexao = new ConexaoDB();

        try {
            Class.forName("com.mysql.jdbc.Driver");

            conexao = bancoconexao.getConnection();

            java.sql.Statement st = conexao.createStatement();
            select = "select count(*) quantidade from jogos where codigobarras = '" + busca + "'";
            ResultSet result = st.executeQuery(select);

            while (result.next()) {

                qtdjogocadastrado = result.getInt("quantidade");

            }

            conexao.close();

        } catch (Exception e) {

            System.out.println("erro" + e.getMessage());

        }

        return qtdjogocadastrado;
    }

    public boolean deleta(String codigobarras) {

        boolean deletado = false;

        ConexaoDB bancoconexao = new ConexaoDB();

        try {
            Class.forName("com.mysql.jdbc.Driver");

            conexao = bancoconexao.getConnection();

            java.sql.Statement st = conexao.createStatement();
            st.executeUpdate("delete from jogos where codigobarras = '" + codigobarras + "'");

            conexao.close();
            deletado = true;

        } catch (Exception e) {

            System.out.println("erro" + e.getMessage());

        }
        return deletado;

    }

    public ResultSet PesquisarJogoGeral() {

        String selectgeral = "";

        ConexaoDB bancoconexao = new ConexaoDB();

        try {
            Class.forName("com.mysql.jdbc.Driver");

            conexao = bancoconexao.getConnection();

            java.sql.Statement st = conexao.createStatement();
            selectgeral = "select * from jogos";
            ResultSet resultgeral = st.executeQuery(selectgeral);

            if (resultgeral != null) {
                return resultgeral;
            }

            conexao.close();

        } catch (Exception e) {

            System.out.println("erro" + e.getMessage());

        }
        return null;
    }

}
