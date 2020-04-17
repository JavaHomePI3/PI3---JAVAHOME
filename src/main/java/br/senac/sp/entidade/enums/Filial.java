/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.sp.entidade.enums;

/**
 *
 * @author Walter Prata
 */
public enum Filial {
    
    FILIALSP("filialSP"),
    FILIALRJ("filialRJ"),
    FILIALRS("filialRS"),
    FILIALMG("filialMG");
    
    private String filial;

    private Filial(String filial) {
        this.filial = filial;
    }

    public String getDepartamento() {
        return filial;
    }
    
    
}
