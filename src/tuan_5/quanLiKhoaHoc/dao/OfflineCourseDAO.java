package tuan_5.quanLiKhoaHoc.dao;

import test_su_dung_jbdc.JDBC_Utils;
import tuan_5.quanLiKhoaHoc.model.Course;
import tuan_5.quanLiKhoaHoc.model.OfflineCourse;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
public class OfflineCourseDAO implements DAOInterface<OfflineCourse>{
    // goi ham nay ma khong can tao doi tuong cua lop nay, thay vi dung constructor
    // tuc la neu khai bao:
    //OfflineCourseDAO dao1 = OfflineCourseDAO.getInstance();
    //OfflineCourseDAO dao2 = OfflineCourseDAO.getInstance();
    // dao1 và dao2 cùng trỏ tới 1 đối tượng duy nhất
    // con neu tao bang constructor thi 2 cai nay se tro toi 2 vung nho khac nhau ,tuc 2 doi tuong khac nhau
    public static OfflineCourseDAO getInstance(){
        return new OfflineCourseDAO();
    }
    @Override
    public int add(OfflineCourse offlineCourse) {
        int result = 0;
        try{
            Connection con = JDBCUtils.getConnection();
            String sql = "INSERT INTO OfflineCourse(course_id, course_name, credits,begin_date,end_date,campus)"+
                    " VALUES (?,?,?,?,?,?)";
            PreparedStatement st = con.prepareStatement(sql);
            st.setString(1,offlineCourse.getCourseID());
            st.setString(2,offlineCourse.getCourseName());
            st.setInt(3,offlineCourse.getCredits());
            st.setString(4,offlineCourse.getBegin());
            st.setString(5,offlineCourse.getEnd());
            st.setString(6,offlineCourse.getCampus());
            // buoc 3: thuc thi cau lenh sql

            result = st.executeUpdate(sql);
            // buoc 4: xu li ket qua
            System.out.println("You excuted: "+sql);
            System.out.println("Have "+result+" changed");
            // buoc 5: ngat ket noi
            JDBCUtils.closeConnection(con);

        }catch (Exception e){
            e.printStackTrace();
        }
        return result;
    }
    @Override
    public int update(OfflineCourse offlineCourse) {
        int result = 0;
        try{
            Connection con = JDBCUtils.getConnection();
            String sql = "UPDATE OfflineCourse"+
                    " SET "+"course_id=?,"+"course_name=?,"+"credits=?,"+"begin_date=?,"+"end_date=?,"+"campus=? "+"WHERE course_id = ?";
            PreparedStatement st = con.prepareStatement(sql);
            st.setString(1,offlineCourse.getCourseID());
            st.setString(2,offlineCourse.getCourseName());
            st.setInt(3,offlineCourse.getCredits());
            st.setString(4,offlineCourse.getBegin());
            st.setString(5,offlineCourse.getEnd());
            st.setString(6,offlineCourse.getCampus());
            st.setString(7,offlineCourse.getCourseID());
            result = st.executeUpdate(sql);
            System.out.println("You excuted: "+sql);
            System.out.println("Have "+result+" changed");
            JDBCUtils.closeConnection(con);

        }catch (Exception e){
            e.printStackTrace();
        }
        return result;
    }
    @Override
    public int delete(OfflineCourse offlineCourse) {
        int result = 0;
        try{
            Connection con = JDBCUtils.getConnection();
            String sql = "DELETE FROM OfflineCourse"+
                    " WHERE course_id =? ";
            PreparedStatement st = con.prepareStatement(sql);
            st.setString(1,offlineCourse.getCourseID());
            result = st.executeUpdate(sql);
            System.out.println("You excuted: "+sql);
            System.out.println("Have "+result+" changed");
            JDBCUtils.closeConnection(con);

        }catch (Exception e){
            e.printStackTrace();
        }
        return result;
    }
    @Override
    public List<OfflineCourse> selectAll() {
        List<OfflineCourse> list = new ArrayList<>();
        // bat ngoai le
        try {
            Connection con = JDBCUtils.getConnection();
            String sql = "SELECT * FROM Course";
            PreparedStatement st = con.prepareStatement(sql);
            System.out.println(sql);
            // lay du lieu trong csdl va dua len chuong trinh
            ResultSet rs = st.executeQuery(sql); // day la 1 table co nhieu dong ben trong
            // buoc 4: xu li
            while (rs.next()) {
                // neu con du lieu next 1 phat, kieu tien toi thoi
                String id = rs.getString("course_id"); // lay ra cac gia tri trong cot course_id
                String name = rs.getString("course_name"); // lay ra cac gia tri cua cot course_name
                int credit = rs.getInt("credits");
                String begin = rs.getString("begin_date");
                String end = rs.getString("end_date");
                String campus = rs.getString("campus");
                OfflineCourse course = new OfflineCourse(begin,end,campus,new Course(id,name,credit));
                list.add(course);
            }
            JDBC_Utils.closeConnection(con);

        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }
}
