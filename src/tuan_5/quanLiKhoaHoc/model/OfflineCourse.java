/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tuan_5.quanLiKhoaHoc.model;

/**
 *
 * @author nguye
 */
public class OfflineCourse extends Course{
    private String begin; // ngay bat dau
    private String end; // ngay ket thuc
    private String campus; // co so hoc

    public OfflineCourse() {
        this.begin = "";
        this.end = "";
        this.campus = "";
    }
    // con 

    public OfflineCourse(String begin, String end, String campus, Course course) {
        super(course.getCourseID(), course.getCourseName(), course.getCredits());
        this.begin = begin;
        this.end = end;
        this.campus = campus;
    }
    // get set

    public String getCampus() {
        return campus;
    }

    public String getEnd() {
        return end;
    }

    public String getBegin() {
        return begin;
    }
    //instructor và campus không được rỗng
    //begin và end phải là ngày trong tương lai, và begin phải trước end

    public void setBegin(String begin) {
        this.begin = begin;
        
    }

    public void setEnd(String end) {
        this.end = end;
    }

    public void setCampus(String campus) {
        this.campus = campus;
    }

    @Override
    public String toString() {
        return super.toString()+"-"+ begin + "-"  + end + "-" +campus;
    }
}
