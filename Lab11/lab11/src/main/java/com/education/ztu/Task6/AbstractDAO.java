package com.education.ztu.Task6;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public abstract class AbstractDAO<T> {
    protected Connection connection;

    public AbstractDAO(Connection connection) {
        this.connection = connection;
    }
    public abstract void create(T entity) throws SQLException;
    public abstract T read(int id) throws SQLException;
    public abstract void update(T entity) throws SQLException;
    public abstract void delete(int id) throws SQLException;
    public abstract List<T> getAll() throws SQLException;
}
