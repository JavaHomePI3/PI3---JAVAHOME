package br.senac.sp.entidade.exception;

import java.sql.SQLException;

public class ClienteException extends SQLException {
    public ClienteException(String message){
        super(message);
    }
}
