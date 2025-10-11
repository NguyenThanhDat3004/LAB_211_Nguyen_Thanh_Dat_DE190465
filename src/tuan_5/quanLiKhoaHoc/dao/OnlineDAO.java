package tuan_5.quanLiKhoaHoc.dao;

import test_su_dung_jbdc.JDBC_Utils;
import tuan_5.quanLiKhoaHoc.model.Course;
import tuan_5.quanLiKhoaHoc.model.OnlineCourse;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class OnlineDAO implements DAOInterface<OnlineCourse> {
    public static CourseDAO getInstance(){
        return new CourseDAO();
    }
    @Override
    public int add(OnlineCourse onlineCourse) {
        int result = 0;
        try{
            Connection con = JDBCUtils.getConnection();
            String sql = "INSERT INTO OnlineCourse(course_id, course_name,credits,platform,note,instructors)"+
                    " VALUES (?,?,?,?,?,?)";
            PreparedStatement st = con.prepareStatement(sql);
            st.setString(1,onlineCourse.getCourseID());
            st.setString(2,onlineCourse.getCourseName());
            st.setInt(3,onlineCourse.getCredits());
            st.setString(4,onlineCourse.getPlatform());
            st.setString(5,onlineCourse.getNote());
            st.setString(6,onlineCourse.getInstructors());
            result = st.executeUpdate(sql);
            System.out.println("You executed: "+sql);
            System.out.println("Have "+result+" changed");
            JDBCUtils.closeConnection(con);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public int update(OnlineCourse onlineCourse) {
        int result = 0;
        // bat ngoai le
        try{
            Connection con = JDBCUtils.getConnection();
            String sql = "UPDATE OnlineCourse"+
                    " SET "+
                    " course_id = ?, "+" course_name = ?, "+" credits = ?, "+" platform = ?, "+" note = ?, "+" instructor = ?, "+" WHERE course_id= ?";
            PreparedStatement st = con.prepareStatement(sql);
            st.setString(1,onlineCourse.getCourseID());
            st.setString(2,onlineCourse.getCourseName());
            st.setInt(3,onlineCourse.getCredits());
            st.setString(4,onlineCourse.getPlatform());
            st.setString(5,onlineCourse.getNote());
            st.setString(6,onlineCourse.getInstructors());
            st.setString(7,onlineCourse.getCourseID());
            result = st.executeUpdate(sql);
            System.out.println("You executed: "+sql);
            System.out.println("Have "+result+" changed");
            JDBCUtils.closeConnection(con);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public int delete(OnlineCourse onlineCourse) {
        int result = 0;
        try{
            Connection con = JDBCUtils.getConnection();
            String sql = "DELETE FROM OnlineCourse"+
                    " WHERE course_id=?";
            PreparedStatement st = con.prepareStatement(sql);
            st.setString(1,onlineCourse.getCourseID());
            result = st.executeUpdate(sql);
            System.out.println("You executed: "+sql);
            System.out.println("Have "+result+" changed");
            JDBCUtils.closeConnection(con);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public List<OnlineCourse> selectAll() {
        List<OnlineCourse> list = new ArrayList<>();
        // bat ngoai le
        try {
            Connection con = JDBCUtils.getConnection();
            String sql = "SELECT * FROM Course";
            PreparedStatement st = con.prepareStatement(sql);
            System.out.println(sql);
            ResultSet rs = st.executeQuery(sql); // day la 1 table co nhieu dong ben trong
            while (rs.next()) {
                // neu con du lieu next 1 phat, kieu tien toi thoi
                String id = rs.getString("course_id");
                String name = rs.getString("course_name");
                int credit = rs.getInt("credits");
                String platform = rs.getString("platform");
                String note = rs.getString("note");
                String instructor = rs.getString("instructor");
                OnlineCourse course = new OnlineCourse(platform,note,instructor,new Course(id,name,credit));
                list.add(course);
            }
            JDBC_Utils.closeConnection(con);

        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }
    }
