package org.dao;
import java.sql.SQLException;
import java.util.List;
public interface DaoInterface<T> {
    public void add(T t) throws SQLException;
    public int update(T t);
    public int delete(T t);
    public List<T> selectAll();
}
