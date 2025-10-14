/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tuan_5.quanLiKhoaHoc.model;

/**
 *
 * @author nguye
 */
public class OnlineCourse extends Course{
    private String platform; // nen tang hoc
    private String instructors; // ten giang vien
    private String note; // ghi chu
    // con

    public OnlineCourse() {
        super();
        this.platform = "";
        this.instructors = "";
        this.note = "";
    }

    public OnlineCourse(String platform, String instructors, String note, Course c) {
        super(c.getCourseID(), c.getCourseName(), c.getCredits());
        this.platform = platform;
        this.instructors = instructors;
        this.note = note;
    }
    
    // get set

    public String getInstructors() {
        return instructors;
    }

    public String getNote() {
        return note;
    }

    public String getPlatform() {
        return platform;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public void setInstructors(String instructors) {
        this.instructors = instructors;
    }

    public void setPlatform(String platform) {
        this.platform = platform;
    }


    @Override
    public String toString() {
        return  super.toString()+"-"+platform + "-" + instructors +"-"+ note ;
    }
}
