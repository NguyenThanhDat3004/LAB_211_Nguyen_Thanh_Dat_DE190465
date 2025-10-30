package tuan_6.dao;

import java.sql.SQLException;
import java.util.List;

public interface DAOInterface<T> {
    public int add(T t) throws SQLException;
    public int update(T t);
    public int delete(T t);
    public List<T> selectAll();
}
