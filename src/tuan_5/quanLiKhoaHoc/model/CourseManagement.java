/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tuan_5.quanLiKhoaHoc.model;

import tuan_5.quanLiKhoaHoc.dao.CourseDAO;
import tuan_5.quanLiKhoaHoc.dao.OfflineCourseDAO;
import tuan_5.quanLiKhoaHoc.dao.OnlineDAO;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class CourseManagement {
    private List<Course> listCourse = new ArrayList<>();
    private List<OnlineCourse> listCourseOnline = new ArrayList<>();
    private List<OfflineCourse> listCourseOffline = new ArrayList<>();
    private List<Course> listSearch = new ArrayList<>();
    //con
    public CourseManagement(){
        this.listCourse = CourseDAO.getInstance().selectAll();
        this.listCourseOffline = OfflineCourseDAO.getInstance().selectAll();
        listCourseOnline = OnlineDAO.getInstance().selectAll();
    }
    // get set

    public List<Course> getListCourse() {
        return listCourse;
    }

    public List<OfflineCourse> getListCourseOffline() {
        return listCourseOffline;
    }

    public List<OnlineCourse> getListCourseOnline() {
        return listCourseOnline;
    }

    
    public List<Course> getListSearch() {
        return listSearch;
    }
    // kiem tra khoa hoc da ton tai 
    public boolean checkContain(Course c){
        Predicate<Course> containId = s -> s.getCourseID().equalsIgnoreCase(c.getCourseID());
        Predicate<Course> containName = s -> s.getCourseName().equalsIgnoreCase(c.getCourseName());
        Predicate<Course> contain = containId.and(containName);
        return listCourse.stream().filter(contain).collect(Collectors.toList()).isEmpty();
    }
    // them khoa hoc
    public void addOfflineCourse(OfflineCourse c){
        if(checkContain(c)) {
            CourseDAO.getInstance().add(c);
            OnlineDAO.getInstance().add(c);
        }else{
            System.out.println("This course is contain in list");
        }
    }
    public void addOnlineCourse(OnlineCourse c){
        if(checkContain(c)) {
            CourseDAO.getInstance().add(c);
            OnlineDAO.getInstance().add(c);
        }else{
            System.out.println("This course is contain in list");
        }
    }
    //Cập nhật thông tin khóa học
    public void update(Course c){
        if(checkContain(c)==true) {
            System.out.println("Can not find course");
        }else{
            System.out.println("This course is contain in list");
        }
    }
    //Xóa khóa học
    //
    //In ra danh sách tất cả / khóa học online / khóa học offline
    //
    //Tìm kiếm thông tin theo tên khóa học
    //
    //Thoát chương trình
    
}
