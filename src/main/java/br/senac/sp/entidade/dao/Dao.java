package br.senac.sp.entidade.dao;

import java.sql.SQLException;
import java.util.List;

public interface Dao<T> {
    boolean inserir(T entidade) throws SQLException;
    List<T> buscar() throws SQLException;
    boolean editar(T entidade) throws SQLException;;
    boolean remover(T entidade) throws SQLException;;;
}
