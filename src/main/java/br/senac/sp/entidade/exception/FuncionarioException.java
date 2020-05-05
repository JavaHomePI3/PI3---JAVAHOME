package br.senac.sp.entidade.exception;
/**
 *
 * @author joao.lucas
 */

import java.sql.SQLException;

public class FuncionarioException extends SQLException{
    public FuncionarioException(String message){
        super(message);
    }
}
