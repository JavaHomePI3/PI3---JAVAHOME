package br.senac.sp.entidade.dao;

import br.senac.sp.db.ConexaoDB;
import br.senac.sp.entidade.exception.VendasException;
import br.senac.sp.entidade.model.Produto;
import br.senac.sp.entidade.model.Venda;
import com.google.gson.Gson;

import java.sql.*;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class VendaDao implements Dao<Venda> {
    private final List<Venda> vendas = new ArrayList<>();
    private Connection conexao;

    @Override
    public boolean inserir(Venda entidade) throws VendasException {
        try {
            conexao = ConexaoDB.getConexao();
            String sqlValida;

            //verificar se o cliente existe
            sqlValida = "sELECT * FROM cliente where id =" + entidade.getIdCliente();
            buscaEntidade(sqlValida);

            //verificar se o funcuionario existe
            sqlValida = "sELECT * FROM funcionario where id =" + entidade.getIdVendedor();
            buscaEntidade(sqlValida);

            //criar iten
            //retornar id de itens
            int idIten = criaIten(entidade.getItens());

            //criar venda
            salvaNovaVemda(entidade, idIten);
            conexao.close();
            return true;
        } catch (SQLException e) {
            throw new VendasException("Erro ao Cadastrar Venda!\nErro: " + e.getMessage());
        }
    }

    public boolean inserirSemValidacao(Venda entidade) throws VendasException {
        try {
            conexao = ConexaoDB.getConexao();

            //criar iten
            //retornar id de itens
            int idIten = criaIten(entidade.getItens());

            //criar venda
            salvaNovaVemda(entidade, idIten);
            conexao.close();
            return true;
        } catch (SQLException e) {
            throw new VendasException("Erro ao Cadastrar Venda!\nErro: " + e.getMessage());
        }
    }

    private void salvaNovaVemda(Venda entidade, int idIten) throws SQLException {
        Calendar c = Calendar.getInstance();
        String sql = "insert into vendas values (default,?,?,?,?,?)";
        PreparedStatement ps = conexao.prepareStatement(sql);
        ps.setInt(1, idIten);
        ps.setInt(2, entidade.getIdCliente());
        ps.setInt(3, entidade.getIdVendedor());
        calculaPrecoTotal(entidade);
        ps.setDouble(4, entidade.getPrecoTotal());
        ps.setString(5, c.getTime().toString());
        ps.execute();
        ps.close();
    }

    private void calculaPrecoTotal(Venda entidade) {
        double precoTotal = 0;
        for (Produto produto : entidade.getItens()) {
            precoTotal += produto.getValorprod();
        }
        entidade.setPrecoTotal(precoTotal);
    }

    private void buscaEntidade(String sqlValida) throws VendasException {
        PreparedStatement preparedStatement;
        ResultSet existe;

        try {
            preparedStatement = conexao.prepareStatement(sqlValida);
            existe = preparedStatement.executeQuery();
            if (existe.next()) {
                preparedStatement.close();
                existe.close();
            } else {
                throw new SQLException();
            }
        } catch (SQLException e) {
            throw new VendasException("Erro ao Procurar entidade no banco \nErro: " + e.getMessage());
        }

    }

    @Override
    public List<Venda> buscar() throws SQLException {
        try {
            conexao = ConexaoDB.getConexao();
            String sql = "SELECT * FROM vendas";
            PreparedStatement preparedStatement = conexao.prepareStatement(sql);
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                vendas.add(new Venda(
                        rs.getInt("id"),
                        null,//falta fazer a logica para tratar o json
                        rs.getInt("id_cliente"),
                        rs.getInt("id_funcionario"),
                        rs.getDouble("preco_total"),
                        rs.getString("create_at")
                ));
            }

            preparedStatement.close();
            rs.close();
            if (vendas.isEmpty()) {
                throw new VendasException("Erro ao buscar produtos!");
            }
            return vendas;
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            conexao.close();
        }
        return null;
    }

    @Override
    public boolean editar(Venda entidade) {
        return false;
    }

    @Override
    public boolean remover(Venda entidade) {
        return false;
    }

    public int criaIten(List<Produto> itens) throws VendasException {
        try {
            Gson gson = new Gson();
            conexao = ConexaoDB.getConexao();
            String sql = "insert into itens values (default,?)";//tratar criar json para slavar no banco
            PreparedStatement preparedStatement = conexao.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            preparedStatement.setString(1, gson.toJson(itens));//itens vira um json
            preparedStatement.execute();
            ResultSet rs = preparedStatement.getGeneratedKeys();
            if (rs.next()) {
                conexao.close();
                return rs.getInt(1);
            } else {
                conexao.close();
                throw new SQLException();
            }

        } catch (SQLException e) {
            throw new VendasException("Erro ao Inserir itens no Banco.\nErro: " + e.getMessage());
        }

    }
}
