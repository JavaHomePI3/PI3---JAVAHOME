package br.senac.sp.entidade.model;

import java.util.List;

public class Venda {
    private int id;
    private int idItens;
    private int idCliente;
    private int idVendedor;
    private double precoTotal;
    private String dataDaVenda;
    private List<Produto> itens;

    public Venda(int id, List<Produto> itens, int idCliente, int idVendedor, double precoTotal, String dataDaVenda) {
        this.id = id;
        this.itens = itens;
        this.idCliente = idCliente;
        this.idVendedor = idVendedor;
        this.precoTotal = precoTotal;
        this.dataDaVenda = dataDaVenda;
    }
    public Venda(int idCliente, int idVendedor,List<Produto> itens) {
        this.idCliente = idCliente;
        this.idVendedor = idVendedor;
        this.itens = itens;
    }

    public Venda(int idItens, int idCliente, int idVendedor, double precoTotal, String dataDaVenda) {
        this.idItens = idItens;
        this.idCliente = idCliente;
        this.idVendedor = idVendedor;
        this.precoTotal = precoTotal;
        this.dataDaVenda = dataDaVenda;
    }

    public Venda(List<Produto> itens, int idCliente, int idVendedor, double precoTotal, String dataDaVenda) {
        this.itens = itens;
        this.idCliente = idCliente;
        this.idVendedor = idVendedor;
        this.precoTotal = precoTotal;
        this.dataDaVenda = dataDaVenda;
    }

    public int getId() {
        return id;
    }

    public List<Produto> getItens() {
        return itens;
    }

    public void setItens(List<Produto> itens) {
        this.itens = itens;
    }

    public int getIdItens() {
        return idItens;
    }

    public void setIdItens(int idItens) {
        this.idItens = idItens;
    }

    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    public int getIdVendedor() {
        return idVendedor;
    }

    public void setIdVendedor(int idVendedor) {
        this.idVendedor = idVendedor;
    }

    public double getPrecoTotal() {
        return precoTotal;
    }

    public void setPrecoTotal(double precoTotal) {
        this.precoTotal = precoTotal;
    }

    public String getDataDaVenda() {
        return dataDaVenda;
    }

    public void setDataDaVenda(String dataDaVenda) {
        this.dataDaVenda = dataDaVenda;
    }
}
