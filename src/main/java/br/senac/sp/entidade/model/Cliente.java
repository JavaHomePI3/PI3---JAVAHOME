
package br.senac.sp.entidade.model;

import br.senac.sp.entidade.enums.Genero;
import br.senac.sp.entidade.enums.Uf;

/**
 * @author Walter Prata
 */
public class Cliente extends Usuario {

    private Integer quantidadeCompras;

    public Cliente(){ }
    
    public Cliente(Integer quantidadeCompras, int idUsuario, String nomeUsuario, String sobreNomeUsuario,
                   String cpf, String email, Genero genero, String dataNascimento, String telefone, String cep,
                   String rua, String bairro, String complemento, String cidade, int numero, Uf estado) {
        super(idUsuario, nomeUsuario, sobreNomeUsuario, cpf, email, genero, dataNascimento, telefone, cep,
            rua, bairro, complemento, cidade, numero, estado);
        
        this.quantidadeCompras = 0;
    }

    public Integer getQuantidadeCompras() {
        return quantidadeCompras;
    }

    
}
