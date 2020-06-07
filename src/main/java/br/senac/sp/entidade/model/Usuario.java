package br.senac.sp.entidade.model;

import br.senac.sp.entidade.enums.Genero;
import br.senac.sp.entidade.enums.Uf;

import java.util.Objects;

/**
 * @author Walter Prata
 */
public abstract class Usuario {

    private int idUsuario;
    private String nomeUsuario;
    private String sobrenomeUsuario;
    private String cpf;
    private String email;
    private Genero genero;
    private String dataNascimento;
    private String telefone;
    private String cep;
    private String rua;
    private String bairro;
    private String complemento;
    private String cidade;
    private int numero;
    private Uf estado;

    public Usuario(){}

    public Usuario(int idUsuario, String nomeUsuario, String sobrenomeUsuario, String cpf, String email,
                   Genero genero, String dataNascimento, String telefone, String cep, String rua,
                   String bairro, String complemento, String cidade, int numero, Uf estado) {

        this.idUsuario = idUsuario;
        this.nomeUsuario = nomeUsuario;
        this.sobrenomeUsuario = sobrenomeUsuario;
        this.cpf = cpf;
        this.email = email;
        this.genero = genero;
        this.dataNascimento = dataNascimento;
        this.telefone = telefone;
        this.cep = cep;
        this.rua = rua;
        this.bairro = bairro;
        this.complemento = complemento;
        this.cidade = cidade;
        this.numero = numero;
        this.estado = estado;
    }

    public int getId() {
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

    public String getSobrenomeUsuario() {
        return sobrenomeUsuario;
    }

    public void setSobrenomeUsuario(String sobrenomeUsuario) {
        this.sobrenomeUsuario = sobrenomeUsuario;
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

    public Genero getGenero() {
        return genero;
    }

    public void setGenero(Genero genero) {
        this.genero = genero;
    }

    public String getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(String dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getRua() {
        return rua;
    }

    public void setRua(String rua) {
        this.rua = rua;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getComplemento() {
        return complemento;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public Uf getEstado() {
        return estado;
    }

    public void setEstado(Uf estado) {
        this.estado = estado;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Usuario usuario = (Usuario) o;
        return idUsuario == usuario.idUsuario &&
                numero == usuario.numero &&
                Objects.equals(nomeUsuario, usuario.nomeUsuario) &&
                Objects.equals(sobrenomeUsuario, usuario.sobrenomeUsuario) &&
                Objects.equals(cpf, usuario.cpf) &&
                Objects.equals(email, usuario.email) &&
                genero == usuario.genero &&
                Objects.equals(dataNascimento, usuario.dataNascimento) &&
                Objects.equals(telefone, usuario.telefone) &&
                Objects.equals(cep, usuario.cep) &&
                Objects.equals(rua, usuario.rua) &&
                Objects.equals(bairro, usuario.bairro) &&
                Objects.equals(complemento, usuario.complemento) &&
                Objects.equals(cidade, usuario.cidade) &&
                estado == usuario.estado;
    }

    @Override
    public int hashCode() {
        return Objects.hash(idUsuario, nomeUsuario, sobrenomeUsuario, cpf, email, genero, dataNascimento, telefone, cep, rua, bairro, complemento, cidade, numero, estado);
    }
}
