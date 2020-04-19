package br.senac.sp.entidade.model;

import java.util.Date;

/**
 * @author Vitoria Cristina
 * 
 */
public class Produto {
    private int idProduto;
    private String codigobarrasprod;

    private double valorprod;

    private String nomeprod;

    private Date dtCadastro;

    private String descricaoprod;

    private int qtdestoque;

    private int itensvenda;

    private int idloja;

    private String categoriaprod;


    public Produto() {
    }

    public Produto(String nomeprod, double valorprod, String codigobarrasprod, String descricaoprod, int qtdestoque, String categoriaprod) {
        this.codigobarrasprod = codigobarrasprod;
        this.nomeprod = nomeprod;
        this.valorprod = valorprod;
        this.descricaoprod = descricaoprod;
        this.qtdestoque = qtdestoque;
        this.categoriaprod = categoriaprod;
    }

    public int getIdProduto() {
        return idProduto;
    }

    public void setIdProduto(int idProduto) {
        this.idProduto = idProduto;
    }

    public String getCodigobarrasprod() {
        return codigobarrasprod;
    }

    public void setCodigobarrasprod(String codigobarrasprod) {
        this.codigobarrasprod = codigobarrasprod;
    }

    public int getItensvenda() {
        return itensvenda;
    }

    public void setItensvenda(int itensvenda) {
        this.itensvenda = itensvenda;
    }

    public int getIdloja() {
        return idloja;
    }

    public void setIdloja(int idloja) {
        this.idloja = idloja;
    }

    public String getCodigoprod() {
        return codigobarrasprod;
    }

    public String getCategoriaprod() {
        return categoriaprod;
    }

    public void setCategoriaprod(String categoriaprod) {
        this.categoriaprod = categoriaprod;
    }

    public void setCodigoprod(String codigoprod) {
        this.codigobarrasprod = codigoprod;
    }

    public double getValorprod() {
        return valorprod;
    }

    public void setValorprod(double valorprod) {
        this.valorprod = valorprod;
    }

    public String getNomeprod() {
        return nomeprod;
    }

    public void setNomeprod(String nomeprod) {
        this.nomeprod = nomeprod;
    }

    public Date getDtCadastro() {
        return dtCadastro;
    }

    public void setDtCadastro(Date dtCadastro) {
        this.dtCadastro = dtCadastro;
    }

    public String getDescricaoprod() {
        return descricaoprod;
    }

    public void setDescricaoprod(String descricaoprod) {
        this.descricaoprod = descricaoprod;
    }

    public int getQtdestoque() {
        return qtdestoque;
    }

    public void setQtdestoque(int qtdestoque) {
        this.qtdestoque = qtdestoque;
    }

}
