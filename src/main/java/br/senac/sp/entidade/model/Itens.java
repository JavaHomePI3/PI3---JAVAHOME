package br.senac.sp.entidade.model;

import java.util.ArrayList;
import java.util.List;

public class Itens <T>{
    private int id;
    private Carrinho carrinho;

    public Itens(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Carrinho getCarrinho() {
        return carrinho;
    }

    public void setCarrinho(Carrinho carrinho) {
        this.carrinho = carrinho;
    }
}
