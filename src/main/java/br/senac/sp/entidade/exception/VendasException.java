package br.senac.sp.entidade.exception;

import java.sql.SQLException;

public class VendasException extends SQLException {
    public VendasException(String message){
        super(message);
    }
}
