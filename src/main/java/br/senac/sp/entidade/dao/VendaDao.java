package br.senac.sp.entidade.dao;

import br.senac.sp.db.ConexaoDB;
import br.senac.sp.entidade.exception.VendasException;
import br.senac.sp.entidade.model.Carrinho;
import br.senac.sp.entidade.model.Produto;
import br.senac.sp.entidade.model.Venda;
import com.google.gson.Gson;

import java.sql.*;
import java.util.*;

public class VendaDao implements Dao<Venda> {
    private final List<Venda> vendas = new ArrayList<>();
    private Connection conexao;

    @Override
    public boolean inserir(Venda entidade) throws SQLException {
        try {

            String sqlValida;

            //verificar se o cliente existe
            sqlValida = "sELECT * FROM cliente where id =" + entidade.getIdCliente();
            buscaEntidade(sqlValida);

            //verificar se o funcuionario existe
            sqlValida = "sELECT * FROM funcionario where id =" + entidade.getIdVendedor();
            buscaEntidade(sqlValida);

            //criar iten
            //retornar id de itens
            int idIten = criaIten(entidade.getCarrinho());

            //criar venda
            conexao = ConexaoDB.getConexao();
            salvaNovaVemda(entidade, idIten);

            return true;
        } catch (SQLException e) {
            throw new VendasException("Erro ao Cadastrar Venda!\nErro: " + e.getMessage());
        } finally {
            conexao.close();
        }
    }

    public boolean inserirSemValidacao(Venda entidade) throws SQLException {
        try {
            conexao = ConexaoDB.getConexao();

            //criar iten
            //retornar id de itens
            int idIten = criaIten(entidade.getCarrinho());

            //criar venda
            salvaNovaVemda(entidade, idIten);
            return true;
        } catch (SQLException e) {
            throw new VendasException("Erro ao Cadastrar Venda!\nErro: " + e.getMessage());
        } finally {
            conexao.close();
        }
    }

    private void salvaNovaVemda(Venda entidade, int idIten) throws SQLException {
        Calendar c = Calendar.getInstance();
        String sql = "insert into vendas values (default,?,?,?,?,?,now())";
        PreparedStatement ps = conexao.prepareStatement(sql);
        ps.setInt(1, idIten);
        ps.setInt(2, entidade.getIdCliente());
        ps.setInt(3, entidade.getIdVendedor());
        ps.setString(4, entidade.getFilial());
        ps.setDouble(5, entidade.getCarrinho().getPrecoTotal());
        ps.execute();
        ps.close();
    }

    private void buscaEntidade(String sqlValida) throws SQLException {
        PreparedStatement preparedStatement;
        ResultSet existe;

        try {
            conexao = ConexaoDB.getConexao();
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
        } finally {
            conexao.close();
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
                        rs.getInt("id_itens"),//falta fazer a logica para tratar o json
                        rs.getInt("id_cliente"),
                        rs.getInt("id_funcionario"),
                        rs.getString("filial"),
                        rs.getDouble("preco_total"),
                        rs.getDate("create_at")
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
        } finally {
            conexao.close();
        }
        return new ArrayList<>();
    }

    public List<Venda> buscarPorCliente(String idCliente) throws SQLException {
        try {
            conexao = ConexaoDB.getConexao();
            String sql = "SELECT * FROM vendas where id_cliente =" + idCliente;
            PreparedStatement preparedStatement = conexao.prepareStatement(sql);
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                vendas.add(new Venda(
                        rs.getInt("id"),
                        rs.getInt("id_itens"),//falta fazer a logica para tratar o json
                        rs.getInt("id_cliente"),
                        rs.getInt("id_funcionario"),
                        rs.getString("filial"),
                        rs.getDouble("preco_total"),
                        rs.getDate("create_at")
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
        } finally {
            conexao.close();
        }
        return null;
    }

    public List<Venda> buscarPor(String coluna, String buscaPor) throws SQLException {
        try {
            conexao = ConexaoDB.getConexao();
            String sql = "SELECT * FROM vendas where " + coluna + "=\"" + buscaPor + "\"";
            PreparedStatement preparedStatement = conexao.prepareStatement(sql);
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                vendas.add(new Venda(
                        rs.getInt("id"),
                        rs.getInt("id_itens"),//falta fazer a logica para tratar o json
                        rs.getInt("id_cliente"),
                        rs.getInt("id_funcionario"),
                        rs.getString("filial"),
                        rs.getDouble("preco_total"),
                        rs.getDate("create_at")
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
        } finally {
            conexao.close();
        }
        return null;
    }
    public String relatorioGeralVenda(int idVenda) throws SQLException {
        try {
            conexao = ConexaoDB.getConexao();
            String query = "SELECT * FROM vendas INNER JOIN itens ON vendas.id_itens = itens.id " +
                    "INNER JOIN cliente ON vendas.id_cliente = cliente.id " +
                    "INNER JOIN funcionario ON vendas.id_funcionario = funcionario.id WHERE vendas.id ="+idVenda;
            PreparedStatement preparedStatement = conexao.prepareStatement(query);

            ResultSet rs = preparedStatement.executeQuery();
            List<String> json = new ArrayList<>();
            while (rs.next()){
                for (int i=1; i <= 39; i++){
                        json.add(rs.getString(i));
                }
            }

            return new Gson().toJson(json);
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            conexao.close();
        }
        return null;
    }
    public String buscaItens(int idItens) throws SQLException {
        try {
            conexao = ConexaoDB.getConexao();
            String sql = "SELECT * FROM itens where id = " + idItens;
            PreparedStatement preparedStatement = conexao.prepareStatement(sql);
            ResultSet rs = preparedStatement.executeQuery();
            String json = "";

            while (rs.next()) {
                json = rs.getString("lista_intes");
            }
            System.out.println(json);
            preparedStatement.close();
            rs.close();

            return json;
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            conexao.close();
        }
        return "";
    }

    @Override
    public boolean editar(Venda entidade) {
        return false;
    }

    @Override
    public boolean remover(Venda entidade) {
        return false;
    }

    public int criaIten(Carrinho itens) throws SQLException {
        try {
            List<Produto> parseMapForList = parseMapForList(itens);
            Gson gson = new Gson();
            conexao = ConexaoDB.getConexao();
            String sql = "insert into itens values (default,?)";//tratar criar json para slavar no banco

            PreparedStatement preparedStatement = conexao.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            preparedStatement.setString(1, gson.toJson(parseMapForList));//itens vira um json
            preparedStatement.execute();
            ResultSet rs = preparedStatement.getGeneratedKeys();

            if (rs.next()) {
                return rs.getInt(1);
            } else {
                throw new SQLException();
            }

        } catch (SQLException e) {
            throw new VendasException("Erro ao Inserir itens no Banco.\nErro: " + e.getMessage());
        } finally {
            conexao.close();
        }
    }

    private List<Produto> parseMapForList(Carrinho itens) {
        List<Produto> parseMapForList = new ArrayList<>();
        for (Map.Entry<Produto, Integer> produto : itens.getCarrinho().entrySet()) {
            produto.getKey().setItensvenda(produto.getValue());
            parseMapForList.add(produto.getKey());
        }
        return parseMapForList;
    }
}
