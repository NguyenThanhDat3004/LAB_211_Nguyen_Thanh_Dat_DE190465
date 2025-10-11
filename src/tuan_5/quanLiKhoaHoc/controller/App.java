/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tuan_5.quanLiKhoaHoc.controller;
import tuan_5.quanLiKhoaHoc.model.CourseManagement;
import tuan_5.quanLiKhoaHoc.utils.Validator;
import tuan_5.quanLiKhoaHoc.view.Menu1;
/**
 *
 * @author nguye
 */
public class App extends Menu1{
    CourseManagement m = new CourseManagement();
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

                break;
            case 3:
                break;
            case 4:
                break;
            case 5:
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
        
    }
}
