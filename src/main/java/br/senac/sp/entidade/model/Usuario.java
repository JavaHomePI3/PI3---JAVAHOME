package br.senac.sp.entidade.model;

import java.util.Date;

/**
 *
 * @author Walter Prata
 */
public abstract class Usuario {
    
  private int idUsuario;
  private String nomeUsuario;
  private String sobreNomeUsuario;   
  private String cpf;
  private String email;
  private Character genenero;
  private Date dataNascimento;
  private String telefone;
  private Endereco endereco;

    public Usuario(int idUsuario, String nomeUsuario, String sobreNomeUsuario, String cpf, String email, Character genenero, Date dataNascimento, String telefone, Endereco endereco) {
        this.idUsuario = idUsuario;
        this.nomeUsuario = nomeUsuario;
        this.sobreNomeUsuario = sobreNomeUsuario;
        this.cpf = cpf;
        this.email = email;
        this.genenero = genenero;
        this.dataNascimento = dataNascimento;
        this.telefone = telefone;
        this.endereco = endereco;
    }

  
  
  
  
    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getNomeUsuario() {
        return nomeUsuario;
    }

    public void setNomeUsuario(String nomeUsuario) {
        this.nomeUsuario = nomeUsuario;
    }

    public String getSobreNomeUsuario() {
        return sobreNomeUsuario;
    }

    public void setSobreNomeUsuario(String sobreNomeUsuario) {
        this.sobreNomeUsuario = sobreNomeUsuario;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Character getGenenero() {
        return genenero;
    }

    public void setGenenero(Character genenero) {
        this.genenero = genenero;
    }

    public Date getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(Date dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    
  
   
}
