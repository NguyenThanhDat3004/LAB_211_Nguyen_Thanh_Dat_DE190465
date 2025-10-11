package tuan_5.quanLiKhoaHoc.dao;

import tuan_5.quanLiKhoaHoc.model.Course;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

public class CourseDAO implements  DAOInterface<Course>{

    public static CourseDAO getInstance(){
        return new CourseDAO();
    }

    @Override
    public int add(Course course) throws SQLException {
        // viet lai cho du 5 buoc
        // buoc 1: tao ket noi toi CSDL
        Connection co = JDBCUtils.getConnection();
        // buoc 2: tao ra doi tuong statement
        Statement st = co.createStatement();
        // buoc 3: thuc thi cau lenh SQL
        String sql = "INSERT INTO Course(course_id, course_name, credits)"
        return 0;
    }

    @Override
    public int update(Course course) {
        return 0;
    }

    @Override
    public int delete(Course course) {
        return 0;
    }

    @Override
    public List<Course> selectAll() {
        return List.of();
    }

    @Override
    public Course selectById(Course course) {
        return null;
    }

    @Override
    public List<Course> selectByCondition(String condition) {
        return List.of();
    }
}
