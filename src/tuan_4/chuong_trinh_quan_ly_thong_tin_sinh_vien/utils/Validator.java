package tuan_4.chuong_trinh_quan_ly_thong_tin_sinh_vien.utils;

import java.util.Scanner;
import tuan_4.chuong_trinh_quan_ly_thong_tin_sinh_vien.model.Course;
import tuan_4.chuong_trinh_quan_ly_thong_tin_sinh_vien.model.Student;

public class Validator {
    static Scanner sc = new Scanner(System.in);
    // check chi so mang
    public static int checkNum(String msg){
        System.out.println(msg);
        while(true){
            try{
            int num = Integer.parseInt(sc.nextLine());
            if(num<=0){
                System.out.println("Please input number greater than 0");
                continue;
            }
            return num;
        }catch(NumberFormatException e){
            System.out.println("Not valid. Re enter a integer number");
        }
        }
    }
    // check cac phan tu cua ma tran
    public static double checkElement(String msg){
        System.out.println(msg);
        while(true){
            try{
            double num = Double.parseDouble(sc.nextLine());
            return num;
        }catch(NumberFormatException e){
            System.out.println("Not valid. Re enter a number");
        }
        }
    }
    // xac nhan them vao
    public static String checkAgree(String msg){
        System.out.println(msg);
        while(true){
                String choice = sc.nextLine();
                if(choice.equalsIgnoreCase("y")||choice.equalsIgnoreCase("n")){
                    return choice;
                }else{
                    System.out.println("Only Y or N. Re enter:");
                }
        }
    }
    

    // checkName
    public static String checkName(String msg){
        System.out.println(msg);
        while(true){
            String name = sc.nextLine();
            if(name.matches("^[a-zA-Z ]+$")){
                return name;
            }else{
                System.out.println("Not valid. Try again");
            }
        }
    }
    // check course
    public static Course checkCourse(String msg){
        System.out.println(msg);
        while(true){
            System.out.println("1.Java \n 2.Net \n 3.C/C++");
            int choice = checkNum("Enter your choice of course (Only 1,2,3)");
            switch (choice) {
                case 1:
                    return Course.JAVA;
                case 2:
                    return Course.DOT_NET;
                case 3:
                    return Course.C_CPP;
                default:
                    System.out.println("Not valid");
            }
        }
    }
    
    // nhap du lieu
    public static Student inputStudent(){
        System.out.println("Input id: ");
        String id = sc.nextLine();
        Student p = updateStudent();
        p.setId(id);
        return p;
    }
    //update
    public static Student updateStudent(){
        String name = checkName("Input name: ");
        int sem = checkNum("Input semester: ");
        Course c = checkCourse("Choice your course: ");
        return new Student("", name, sem, c);
    }

    
}
