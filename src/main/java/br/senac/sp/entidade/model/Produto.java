package br.senac.sp.entidade.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author Vitoria Cristina
 * 
 */
public class Produto{
    
    private String codigobarrasprod;

    private double valorprod;

    private String nomeprod;

    private Date dtCadastro;

    private String descricaoprod;

    private int qtdestoque;

    private int itensvenda;

    public int getIdloja() {
        return idloja;
    }

    public void setIdloja(int idloja) {
        this.idloja = idloja;
    }
    
    private int idloja;

    private String categoriaprod;

    private java.util.List<Produto> listaProd = new ArrayList<Produto>();

    public List<Produto> getListaProd() {
        return listaProd;
    }

    public void setListaProd(Produto produtos) {
        listaProd.add(produtos);
    }

    public int getItensvenda() {
        return itensvenda;
    }

    public void setItensvenda(int itensvenda) {
        this.itensvenda = itensvenda;
    }

    public Produto(String nomeprod, double valorprod, String codigobarrasprod, String descricaoprod, int qtdestoque, String categoriaprod, int idloja) {
        this.codigobarrasprod = codigobarrasprod;
        this.nomeprod = nomeprod;
        this.valorprod = valorprod;
        this.descricaoprod = descricaoprod;
        this.qtdestoque = qtdestoque;
        this.categoriaprod = categoriaprod;
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

    public Produto obterLista(String nome) {
        if (!listaProd.isEmpty()) {
            for (int i = 0; i < listaProd.size(); i++) {
                if (listaProd.get(i) != null && listaProd.get(i).nomeprod.toUpperCase().contains(nome.toUpperCase())) {
                    return listaProd.get(i);

                }
            }
        }
        return null;
    }

}
