package br.senac.sp.entidade.model;

import java.util.Date;
import java.util.List;

public class Venda {
    private int id;
    private List<Produto> listaDeProdutos;
    private Cliente cliente;
    private Funcionario vendedor;
    private double totalDaVenda;
    private Date dataDaVenda;

    public int getId() {
        return id;
    }

    public List<Produto> getListaDeProdutos() {
        return listaDeProdutos;
    }

    public void setListaDeProdutos(List<Produto> listaDeProdutos) {
        this.listaDeProdutos = listaDeProdutos;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Funcionario getVendedor() {
        return vendedor;
    }

    public void setVendedor(Funcionario vendedor) {
        this.vendedor = vendedor;
    }

    public double getTotalDaVenda() {
        return totalDaVenda;
    }

    public void setTotalDaVenda(double totalDaVenda) {
        this.totalDaVenda = totalDaVenda;
    }

    public Date getDataDaVenda() {
        return dataDaVenda;
    }

    public void setDataDaVenda(Date dataDaVenda) {
        this.dataDaVenda = dataDaVenda;
    }
}
