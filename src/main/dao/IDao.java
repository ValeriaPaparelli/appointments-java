package main.dao;

import java.sql.SQLException;
import java.util.List;

public interface IDao<T>{
    public List<T> toList();
    public void add(T t) throws SQLException;
    public void update(T t);
    public void delete(int t);

}
