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
public enum Departamento {
    
    ADM("adm"),
    VENDAS("vendas"),
    BACKOFFICE("backoffice"),
    TI("ti");
    
    private String departamento;

    private Departamento(String departamento) {
        this.departamento = departamento;
    }

    public String getDepartamento() {
        return departamento;
    }
    
    
}
