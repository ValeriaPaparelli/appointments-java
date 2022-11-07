package main.dao;

import java.sql.SQLException;
import java.util.List;

public interface IDao<T>{
    public List<T> toList() throws SQLException;
    public T getById(int id) throws SQLException;
    public void add(T t) throws SQLException;
    public void update(T t);
    public void delete(int t) throws SQLException;

}
