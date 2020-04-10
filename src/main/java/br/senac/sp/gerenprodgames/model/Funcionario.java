/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.sp.gerenprodgames.model;

import br.senac.sp.gerenprodgames.enums.Departamento;
import java.util.Date;

/**
 *
 * @author Walter Prata
 */
public class Funcionario extends Usuario {
    
    private Departamento departamento;
    private Double salario;
    private String cargo;

    public Funcionario(Departamento departamento, Double salario, String cargo,
            int idUsuario, String nomeUsuario, String sobreNomeUsuario, String cpf,
            String email, Character genenero, Date dataNascimento, String telefone,
            Endereco endereco) {
        
        super(idUsuario, nomeUsuario, sobreNomeUsuario, cpf, email, genenero, 
                dataNascimento, telefone, endereco);
        
        this.departamento = departamento;
        this.salario = salario;
        this.cargo = cargo;
    }

    public Departamento getDepartamento() {
        return departamento;
    }

    public void setDepartamento(Departamento departamento) {
        this.departamento = departamento;
    }

    public Double getSalario() {
        return salario;
    }

    public void setSalario(Double salario) {
        this.salario = salario;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }
    
}
