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
        this.listCourseOnline = OnlineDAO.getInstance().selectAll();
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
    // ham load co so du lieu vao list
    public void load(){
        listCourse = CourseDAO.getInstance().selectAll();
        listCourseOnline = OnlineDAO.getInstance().selectAll();
        listCourseOffline = OfflineCourseDAO.getInstance().selectAll();
    }
    // them khoa hoc
    public void addOfflineCourse(OfflineCourse c){
        if(checkContain(c)) {
            CourseDAO.getInstance().add(c);
            OfflineCourseDAO.getInstance().add(c);
            load();
        }else{
            System.out.println("This course is contain in list");
        }
    }
    public void addOnlineCourse(OnlineCourse c){
        if(checkContain(c)) {
            CourseDAO.getInstance().add(c);
            OnlineDAO.getInstance().add(c);
            load();
        }else{
            System.out.println("This course is contain in list");
        }
    }
    // tim theo ten
    public void searchByName(String name){
        load();
        listSearch.clear();
        listSearch = listCourse.stream().filter(s->s.getCourseName().equalsIgnoreCase(name)).toList();
    }
    // tim kiem theo id
    public Course searchById(String id){
        listSearch.clear();
        return listCourse.stream().filter(s->s.getCourseID().equalsIgnoreCase(id)).findFirst().orElse(null);
    }
    // ham update online
    public void updateOnline(OnlineCourse c){
        if(!checkContain(c)){
            OnlineDAO.getInstance().update(c);
            CourseDAO.getInstance().update(c);
            load();
        } else System.out.println("Can not change! This course already contained");
    }
    // ham update offline
    public void updateOffline(OfflineCourse c){
        if(!checkContain(c)){
            OfflineCourseDAO.getInstance().update(c);
            CourseDAO.getInstance().update(c);
            load();
        }else System.out.println("Can not change! This course already contained");
    }
    //Xoa khoa hoc
    public void delete(Course c){
        CourseDAO.getInstance().delete(c);
        if(c instanceof OnlineCourse){
            OnlineDAO.getInstance().delete(new OnlineCourse("","","",c));
        }
        if(c instanceof OfflineCourse){
            OfflineCourseDAO.getInstance().delete(new OfflineCourse("","","",c));
        }
        load();

    }
}
