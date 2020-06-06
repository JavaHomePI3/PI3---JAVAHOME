package br.senac.sp.entidade.model;

import br.senac.sp.entidade.enums.Departamento;
import br.senac.sp.entidade.enums.Genero;
import br.senac.sp.entidade.enums.Uf;

/**
 *
 * @author Walter Prata
 */
public class Funcionario extends Usuario {
    
    private Departamento departamento;
    private Double salario;
    private String senha;
    public Funcionario(){}

    public Funcionario(Departamento departamento, Double salario, String cargo, int idUsuario, String nomeUsuario,
                       String sobreNomeUsuario, String cpf, String email, Genero genero, String dataNascimento,
                       String telefone, String cep, String rua, String bairro, String complemento,
                       String cidade, int numero, Uf estado) {
        super(idUsuario, nomeUsuario, sobreNomeUsuario, cpf, email, genero, dataNascimento, telefone,
                cep, rua, bairro, complemento, cidade, numero, estado);
        this.departamento = departamento;
        this.salario = salario;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
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
    
}
