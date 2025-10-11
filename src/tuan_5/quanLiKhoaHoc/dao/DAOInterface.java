package tuan_5.quanLiKhoaHoc.dao;

import java.sql.SQLException;
import java.util.List;

public interface DAOInterface<T> {
    public int add(T t) throws SQLException;
    public int update(T t);
    public int delete(T t);
    public List<T> selectAll();
    public T selectById(T t);
    public List<T> selectByCondition(String condition);
}
