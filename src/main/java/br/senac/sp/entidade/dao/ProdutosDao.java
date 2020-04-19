/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.sp.entidade.dao;

import br.senac.sp.db.ConexaoDB;
import br.senac.sp.entidade.model.Produto;

import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 * @author Vitoria Cristina
 */
public class ProdutosDao {
    private Connection conexao = null;
    final Produto produtos = new Produto(null, 0, null, null, 0, null);
    private java.util.List<Produto> listaProd = new ArrayList<Produto>();

    public void gravarproduto(Produto produtos) {

        try {

            conexao = ConexaoDB.getConexao();

            java.sql.Statement st = conexao.createStatement();
            st.executeUpdate("INSERT INTO produtos (codigobarrasprod, nomeprod,valor,"
                    + "datacadastroprod, descricaoprod,categoriaprod, quantidadeprod, idloja)"
                    + " VALUES ('" + produtos.getCodigoprod() + "','" + produtos.getNomeprod()
                    + "'," + produtos.getValorprod() + ",now(),'"
                    + produtos.getDescricaoprod() + "','" + produtos.getCategoriaprod() + "'," + produtos.getQtdestoque() + "," + produtos.getIdloja() + ");");

            conexao.close();

        } catch (Exception e) {

            System.out.println("erro" + e.getMessage());

        }

    }

    public void atualizarprod(Produto produtos) {

        try {

            conexao = ConexaoDB.getConexao();

            java.sql.Statement st = conexao.createStatement();
            st.executeUpdate("UPDATE PRODUTOS set codigobarrasprod = '" + produtos.getCodigoprod() + "', nomeprod = '" + produtos.getNomeprod() + "',"
                    + "valor = " + produtos.getValorprod() + ",descricaoprod = '" + produtos.getDescricaoprod() + "',categoriaprod = '" + produtos.getCategoriaprod() + "',"
                    + "quantidadeprod = " + produtos.getQtdestoque() + " where codigobarrasprod = '" + produtos.getCodigoprod() + "'");

            conexao.close();

            System.out.println("aqui no update" + produtos.getCodigoprod());
            System.out.println("fiz o update");

        } catch (Exception e) {

            System.out.println("erro" + e.getMessage());

        }

    }

    public Produto PesquisarProduto(String codigobarrasprod) {

        String select = "";

        try {

            conexao = ConexaoDB.getConexao();

            java.sql.Statement st = conexao.createStatement();
            select = "select * from produtos where codigobarrasprod = '" + codigobarrasprod.trim() + "'";
            ResultSet result = st.executeQuery(select);

            while (result.next()) {

                produtos.setCodigoprod(result.getString("codigobarrasprod"));
                produtos.setNomeprod(result.getString("nomeprod"));
                produtos.setValorprod(result.getDouble("valor"));
                produtos.setDtCadastro(result.getDate("datacadastroprod"));
                produtos.setDescricaoprod(result.getString("descricaoprod"));
                produtos.setCategoriaprod(result.getString("categoriaprod"));
                produtos.setQtdestoque(result.getInt("quantidadeprod"));
                produtos.setQtdestoque(result.getInt("idloja"));

                //produtos.setListaProd(produtos);

            }

            conexao.close();

        } catch (Exception e) {

            System.out.println("erro" + e.getMessage());

        }

        return produtos;
    }

    public boolean validacadastradoprod(String buscaprod) {

        boolean repetido = false;

        String selectprod = "";
        String selectpet = "";

        int qtdprodcadastrado = 0;
        int qtdpetcadastrado = 0;

        try {
            conexao = ConexaoDB.getConexao();

            java.sql.Statement stprod = conexao.createStatement();

            selectprod = "select count(*) quantidadeprod from produtos where codigobarrasprod = '" + buscaprod + "'";
            ResultSet resultprod = stprod.executeQuery(selectprod);

            while (resultprod.next()) {

                qtdprodcadastrado = resultprod.getInt("quantidadeprod");
                System.out.println(qtdpetcadastrado);

            }

            java.sql.Statement stpet = conexao.createStatement();

            selectpet = "select count(*) quantidade from jogos where codigobarras = '" + buscaprod + "'";
            ResultSet resultpet = stpet.executeQuery(selectpet);

            while (resultpet.next()) {

                qtdpetcadastrado = resultpet.getInt("quantidade");
                System.out.println(qtdpetcadastrado);

            }

            conexao.close();

        } catch (Exception e) {

            System.out.println("erro" + e.getMessage());

        }
        if (qtdpetcadastrado > 0 || qtdprodcadastrado > 0) {
            repetido = true;
        }

        return repetido;
    }

    public boolean deletaprod(String codigobarrasprod) {

        boolean deletado = false;

        try {
            conexao = ConexaoDB.getConexao();

            java.sql.Statement st = conexao.createStatement();
            st.executeUpdate("delete from produtos where codigobarrasprod = '" + codigobarrasprod + "'");

            conexao.close();
            deletado = true;

        } catch (Exception e) {

            System.out.println("erro" + e.getMessage());

        }
        return deletado;

    }

    public ResultSet PesquisarProdutosGeral() {

        String selectgeral = "";

        try {
            conexao = ConexaoDB.getConexao();

            java.sql.Statement st = conexao.createStatement();
            selectgeral = "select * from produtos";
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


