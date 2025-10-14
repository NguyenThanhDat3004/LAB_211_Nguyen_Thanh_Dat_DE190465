/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tuan_5.quanLiKhoaHoc.view;

import tuan_5.quanLiKhoaHoc.model.CourseManagement;

/**
 *
 * @author nguye
 */
public class Solution {
    public void displayList(CourseManagement c){
        c.load();
        System.out.println("List of course: ");
        for(int i = 0;i<c.getListCourse().size();i++){
            System.out.println(c.getListCourse().get(i));
        }
        System.out.println("List of offline course: ");
        for(int i = 0;i<c.getListCourseOffline().size();i++){
            System.out.println(c.getListCourseOffline().get(i));
        }
        System.out.println("List of online course: ");
        for(int i = 0;i<c.getListCourseOnline().size();i++){
            System.out.println(c.getListCourseOnline().get(i));
        }
    }
    public void displayListSearch(CourseManagement c){
        System.out.println("Result: ");
        for(int i = 0;i<c.getListSearch().size();i++){
            System.out.println(c.getListSearch().get(i));
        }
    }
}
