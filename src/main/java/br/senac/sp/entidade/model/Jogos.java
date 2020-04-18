/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.sp.entidade.model;

import java.util.Date;

/**
 *
 * @author Vitoria Cristina
 */
public class Jogos {
     private String codigobarras;

    private double valor;

    private String nome;

    private String categoria;

    private Date dtCadastro;

    private String descricao;

    private int qtdestoque;

    private int idloja;

    public int getIdloja() {
        return idloja;
    }

    public void setIdloja(int idloja) {
        this.idloja = idloja;
    }

    public Jogos(String nome, double valor, String codigobarras, String descricao, int qtdestoque, String categoria, int idloja) {
        this.codigobarras = codigobarras;
        this.nome= nome;
        this.valor = valor;
        this.descricao = descricao;
        this.qtdestoque = qtdestoque;
        this.categoria = categoria;
        this.idloja = idloja;

    }

    public String getCodigobarras() {
        return codigobarras;
    }

    public void setCodigobarras(String codigobarras) {
        this.codigobarras = codigobarras;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public Date getDtCadastro() {
        return dtCadastro;
    }

    public void setDtCadastro(Date dtCadastro) {
        this.dtCadastro = dtCadastro;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public int getQtdestoque() {
        return qtdestoque;
    }

    public void setQtdestoque(int qtdestoque) {
        this.qtdestoque = qtdestoque;
    }
}

   

