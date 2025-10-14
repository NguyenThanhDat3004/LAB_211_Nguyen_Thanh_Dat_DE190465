/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tuan_5.quanLiKhoaHoc.controller;
import tuan_5.quanLiKhoaHoc.model.Course;
import tuan_5.quanLiKhoaHoc.model.CourseManagement;
import tuan_5.quanLiKhoaHoc.model.OfflineCourse;
import tuan_5.quanLiKhoaHoc.model.OnlineCourse;
import tuan_5.quanLiKhoaHoc.utils.Validator;
import tuan_5.quanLiKhoaHoc.view.Menu1;
import tuan_5.quanLiKhoaHoc.view.Solution;

import java.util.Scanner;

/**
 *
 * @author nguye
 */
public class App extends Menu1{
    CourseManagement m = new CourseManagement();
    Solution so = new Solution();
    Scanner sc = new Scanner(System.in);
    // goi cons
    public App(){
        super("Course Management", new String[]{
            "Add online course/ offline course", "Update course", "Delete course", "Print all / online course / offline course" ,
            "Search information base on course name", "Exit"
        });
    }
    // override
    @Override
    public void execute(int n) {
        switch (n) {
            case 1:
                // them khoa hoc
                int i;
                System.out.println("Do you want add offline or online course? \n 1. Offline \n 2.Online \n Only 1 or 2 please");
                while(true){
                    i = Validator.checkNum("Enter you choice: ");
                    if(i==1||i==2) break; else System.out.println("Not valid");
                }
                switch (i) {
                    case 1:
                        System.out.println("Add Offline Course");
                        m.addOfflineCourse(Validator.inputOfflineCourse("Please enter information"));
                        break;
                    case 2:
                        System.out.println("Add Online Course");
                        m.addOnlineCourse(Validator.inputOnlineCourse("Please enter information"));
                        break;
                }
                break;
            case 2:
                // ham cap nhat
                System.out.println("Enter ID: ");
                String id= sc.nextLine();
                Course b = m.searchById(id);
                if(b!=null){
                    if(b instanceof OfflineCourse){
                        OfflineCourse c = Validator.updateInputOfflineCourse("Enter your update: ");
                        c.setCourseID(id);
                        m.updateOffline(c);
                    }
                    if(b instanceof OnlineCourse){
                        OnlineCourse c =  Validator.inputUpdateOnlineCourse("Enter your update: ");
                        c.setCourseID(id);
                        m.updateOnline(c);
                    }
                }else{
                    System.out.println("Can not find in list");
                }
                break;
            case 3:
                // ham  xoa
                System.out.println("Enter id course you want delete: ");
                String id1 = sc.nextLine();
                Course c = m.searchById(id1);
                if(c!=null) m.delete(c);
                else System.out.println("Can not find this id");
                break;
            case 4:
                System.out.println("Print all / online course / offline course");
                so.displayList(m);
                break;
            case 5:
                System.out.println("Search information base on course name");
                System.out.println("Enter name: ");
                String name = sc.nextLine();
                m.searchByName(name);
                so.displayListSearch(m);
                break;
            case 6: 
                System.out.println("Exitting");
                break;
            default:
                System.out.println("Not Vallid");
                break;
        }
    }
    
    // main chinh
    public static void main(String[] args) {
        App a = new App();
        a.run();
    }
}
