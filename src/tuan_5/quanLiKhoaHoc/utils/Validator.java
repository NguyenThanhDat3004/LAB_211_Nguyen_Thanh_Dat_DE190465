package tuan_5.quanLiKhoaHoc.utils;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;
import tuan_5.quanLiKhoaHoc.model.Course;
import tuan_5.quanLiKhoaHoc.model.OfflineCourse;
import tuan_5.quanLiKhoaHoc.model.OnlineCourse;
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
    // check ngay begin
    public static String checkBegin(String msg){
        System.out.println(msg);
        String begin;
        while(true){
            try {
                begin  = sc.nextLine();
                if(LocalDate.parse(begin, DateTimeFormatter.ofPattern("dd/MM/yyyy")).isBefore(LocalDate.now())){
                    System.out.println("Begin date must after now!");
                    continue;
                }
                break;
            }catch(Exception e){
                System.out.println("Not valid");
            }
        }
        return begin;
    }
    // check ngay end
    public static String checkEnd(String msg,String begin){
        System.out.println(msg);
        String end;
        while(true){
            try {
                end  = sc.nextLine();
                if(LocalDate.parse(end, DateTimeFormatter.ofPattern("dd/MM/yyyy")).isBefore(LocalDate.now())){
                    System.out.println("Begin date must after now!");
                    continue;
                }
                if(LocalDate.parse(end, DateTimeFormatter.ofPattern("dd/MM/yyyy")).isBefore(LocalDate.parse(begin, DateTimeFormatter.ofPattern("dd/MM/yyyy")))){
                    System.out.println("End date must after begin date!");
                    continue;
                }
                break;
            }catch(Exception e){
                System.out.println("Not valid");
            }
        }
        return end;
    }
    // Nhap vao mot khoa hoc
    public static Course inputCourse(String msg){
        System.out.println("Enter ID Course: ");
        String id = sc.nextLine();
        System.out.println("Enter Name Course: ");
        String name = sc.nextLine();
        int credits = checkNum("Enter credits:");
        return new Course(id,name,credits);
    }
    // nhap vao khoa offline
    public static OfflineCourse inputOfflineCourse(String msg){
        Course c = inputCourse("Enter Information:");
        String begin = checkBegin("Enter begin date: ");
        String end = checkEnd("Enter End Date: ", begin);
        String campus = sc.nextLine();
        return new OfflineCourse(begin, end, campus, c);
    }
    // nhap vao khoa offline de update
    public static OfflineCourse updateInputOfflineCourse(String msg){
        System.out.println(msg);
        String id = "";
        String name = sc.nextLine();
        int credits = checkNum("Enter credits:");
        String begin = checkBegin("Enter begin date: ");
        String end = checkEnd("Enter End Date: ", begin);
        String campus = sc.nextLine();
        return new OfflineCourse(begin, end, campus, new Course(id,name,credits));
    }
    // nhap vao khoa online de update
    public static OnlineCourse inputUpdateOnlineCourse(String msg){
        System.out.println(msg);
        String id = "";
        String name = sc.nextLine();
        int credits = checkNum("Enter credits:");
        System.out.println("Please enter platform: ");
        String platform = sc.nextLine();
        System.out.println("Please enter instructors: ");
        String instructor = sc.nextLine();
        System.out.println("Please enter note: ");
        String note = sc.nextLine();
        return new OnlineCourse(platform, instructor, note, new Course(id,name,credits));
    }
    // nhap vao khoa online
    public static OnlineCourse inputOnlineCourse(String msg){
        Course c = inputCourse("Enter Information:");
        int credits = checkNum("Enter credits:");
        System.out.println("Please enter platform: ");
        String platform = sc.nextLine();
        System.out.println("Please enter instructors: ");
        String instructor = sc.nextLine();
        System.out.println("Please enter note: ");
        String note = sc.nextLine();
        return new OnlineCourse(platform, instructor, note, c);
    }
}
