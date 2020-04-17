package br.senac.sp.entidade.model;

import java.util.ArrayList;
import java.util.List;

public class Itens <T>{
    private int id;
    private List<T> entidades = new ArrayList<>();

    public Itens(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<T> getEntidades() {
        return entidades;
    }

    public void setEntidades(List<T> entidades) {
        this.entidades = entidades;
    }
}
