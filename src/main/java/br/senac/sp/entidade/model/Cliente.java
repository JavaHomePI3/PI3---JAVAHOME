/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.sp.entidade.model;

import java.util.Date;

/**
 *
 * @author Walter Prata
 */
public class Cliente extends Usuario{
    
    private Integer quantidadeCompras;

    public Cliente(Integer quantidadeCompras, int idUsuario, String nomeUsuario, 
            String sobreNomeUsuario, String cpf, String email, Character genenero,
            Date dataNascimento, String telefone, Endereco endereco) {
        super(idUsuario, nomeUsuario, sobreNomeUsuario, cpf, email, genenero, 
                dataNascimento, telefone, endereco);
        
        this.quantidadeCompras = quantidadeCompras;
    }

    public Integer getQuantidadeCompras() {
        return quantidadeCompras;
    }

    public void setQuantidadeCompras(Integer quantidadeCompras) {
        this.quantidadeCompras = quantidadeCompras;
    }
    
    
    
    
    
}
