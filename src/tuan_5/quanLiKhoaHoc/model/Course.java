/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package tuan_5.quanLiKhoaHoc.model;

/**
 *
 * @author nguye
 */
public class Course {

    private String courseID; // maKhoaHoc
    private String courseName; // ten khoa hoc
    private int credits; // tin chi
    // con 

    public Course() {
        this.courseID = "";
        this.courseName = "";
        this.credits = 0;
    }
    // con hoan chinh

    public Course(String courseID, String courseName, int credits) {
        this.courseID = courseID;
        this.courseName = courseName;
        this.credits = credits;
    }
    
    // get set

    public String getCourseID() {
        return courseID;
    }
    public String getCourseName() {
        return courseName;
    }
    public int getCredits() {
        return credits;
    }
    public void setCourseID(String courseID) {
        this.courseID = courseID;
    }
    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }
    public void setCredits(int credits) {
        this.credits = credits;
    }
    // courseName va courseID phai la duy nhat

    @Override
    public String toString() {
        return courseID + "-" + courseName + "-" +credits;
    }
}
