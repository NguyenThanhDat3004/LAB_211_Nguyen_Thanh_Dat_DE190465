package tuan_5.quanLiKhoaHoc.dao;
import tuan_5.quanLiKhoaHoc.model.Course;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CourseDAO implements  DAOInterface<Course> {

    public static CourseDAO getInstance() {
        return new CourseDAO();
    }

    @Override
    public int add(Course course) {
        int result;
        try {
            Connection co = JDBCUtils.getConnection();
            String sql = "INSERT INTO Course(course_id, course_name, credits)" +
                    " VALUES (?,?,?)";
            PreparedStatement st = co.prepareStatement(sql);
            st.setString(1,course.getCourseID());
            st.setString(2,course.getCourseName());
            st.setInt(3,course.getCredits());

            result = st.executeUpdate(); // tra ve so luong dong bi thay doi
            System.out.println("You excuted: " + sql);
            System.out.println("Have " + result + " changed");
            JDBCUtils.closeConnection(co);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return result;
    }
    @Override
    public int update(Course course) {
        int result;
        try {
            Connection co = JDBCUtils.getConnection();
            String sql = "UPDATE Course " +
                    " SET course_name=?, credits=? " +
                    " WHERE course_id=?";

            PreparedStatement st = co.prepareStatement(sql);
            st.setString(1, course.getCourseName());
            st.setInt(2, course.getCredits());
            st.setString(3, course.getCourseID());
            result = st.executeUpdate();
            System.out.println("You excuted: " + sql);
            System.out.println("Have " + result + " changed");
            // buoc 5: ngat ket noi
            JDBCUtils.closeConnection(co);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return result;
    }

    @Override
    public int delete(Course course) {
        int result;
        try {
            Connection co = JDBCUtils.getConnection();
            String sql = "DELETE FROM Course " +
                    "WHERE course_id=? ";
            PreparedStatement st = co.prepareStatement(sql);
            st.setString(1,course.getCourseID());
            result = st.executeUpdate(); // tra ve so luong dong bi thay doi
            System.out.println("You excuted: " + sql);
            System.out.println("Have " + result + " changed");
            JDBCUtils.closeConnection(co);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return result;
    }

    @Override
    public List<Course> selectAll() {
        List<Course> list = new ArrayList<>();
        // bat ngoai le
        try {
            // buoc 1: tao mot conect
            Connection con = JDBCUtils.getConnection();
            // buoc 2: tao mot stm
            Statement st = con.createStatement();
            // buoc 3: thuc thi sql
            String sql = "SELECT * FROM Course";
            System.out.println(sql);
            // lay du lieu trong csdl va dua len chuong trinh
            ResultSet rs = st.executeQuery(sql); // day la 1 table co nhieu dong ben trong
            // buoc 4: xu li
            while (rs.next()) {
                // neu con du lieu next 1 phat, kieu tien toi thoi
                String id = rs.getString("course_id"); // lay ra cac gia tri trong cot course_id
                String name = rs.getString("course_name"); // lay ra cac gia tri cua cot course_name
                int credit = rs.getInt("credits");
                Course course = new Course(id, name, credit);
                list.add(course);
            }
            // buoc 5: ngat ket noi
            JDBCUtils.closeConnection(con);

        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }
}