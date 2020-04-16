/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.sp.entidade.model;

import br.senac.sp.entidade.enums.Departamento;
import java.util.Date;

/**
 *
 * @author Walter Prata
 */
public class Funcionario extends Usuario {
    
    private Departamento departamento;
    private Double salario;
    private String cargo;

    public Funcionario(Departamento departamento, Double salario, String cargo, int idUsuario, String nomeUsuario, 
            String sobreNomeUsuario, String cpf, String email, Character genero, Date dataNascimento, 
            String telefone, String cep, String rua, String bairro, String complemento, 
            String cidade, int numero, String estado) {
        super(idUsuario, nomeUsuario, sobreNomeUsuario, cpf, email, genero, dataNascimento, telefone,
                cep, rua, bairro, complemento, cidade, numero, estado);
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
