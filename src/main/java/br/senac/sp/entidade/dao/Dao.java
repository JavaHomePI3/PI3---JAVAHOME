package br.senac.sp.entidade.dao;

import br.senac.sp.entidade.exception.VendasException;

import java.sql.SQLException;
import java.util.List;

public interface Dao<T> {
    boolean inserir(T entidade) throws SQLException;
    List<T> buscar() throws SQLException;
    boolean editar(T entidade);
    boolean remover(T entidade);
}
