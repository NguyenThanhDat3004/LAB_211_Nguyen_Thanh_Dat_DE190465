/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tuan_4.short_tuan_4.utils;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Scanner;
import tuan_4.short_tuan_4.model.Person;
import tuan_4.short_tuan_4.model.Student;
import tuan_4.short_tuan_4.model.Teacher;

/**
 *
 * @author nguye
 */
public class Validator {
    // cac ham check
    // check ID
    static Scanner sc = new Scanner(System.in);
    public static String checkId(String msg){
        System.out.println(msg);
        
        while(true){
            try{
            String id = sc.nextLine();
            if(id.length()!=6){
                System.out.println("Re enter id with 6 digit");
                continue;
            }
            Integer.parseInt(id);
            return id;
        }catch(NumberFormatException e){
            System.out.println("Re enter id with 6 digit");
        }
        }
    }
    //check nhap ho ten
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
    // check so dien thoai
    public static String checkPhone(String msg){
        System.out.println(msg);
        while(true){
            try{
            String phoneNumber = sc.nextLine();
            if(phoneNumber.length()!=12){
                System.out.println("Re enter id with 12 digit");
                continue;
            }
            Long.parseLong(phoneNumber);
            return phoneNumber;
        }catch(NumberFormatException e){
            System.out.println("Not valid. Try again");
        }
        }
    }
    //check nam sinh
    public static int checkDate(String msg){
        System.out.println(msg);
        while(true){
            String phoneNumber = sc.nextLine();
            if(LocalDate.parse("01/01/"+phoneNumber,DateTimeFormatter.ofPattern("dd/MM/yyyy")).isAfter(LocalDate.now())){
                System.out.println("Not valid");
            }else{
                return Integer.parseInt(phoneNumber);
            }
        }
    }
    //check chuyen nganh
    public static String checkMajor(String msg){
        System.out.println(msg);
        while(true){
            String major = sc.nextLine();
            if(major.length()>30){
                System.out.println("Max is 30 character");
            }else{
                return major;
            }
        }
    }
    // check cho Student
    public static int checkStartYear(String msg,Person s){
        System.out.println(msg);
        while(true){
            String year = sc.nextLine();
            LocalDate d = LocalDate.parse("01/01/"+year, DateTimeFormatter.ofPattern("dd/MM/yyyy"));
            if(d.isAfter(LocalDate.parse("01/01/"+s.getYearOfBirth(), DateTimeFormatter.ofPattern("dd/MM/yyyy")))&&d.isBefore(LocalDate.now())){
                return Integer.parseInt(year);
            }else{
                System.out.println("Not valid");
            }
        }
    }
    //check diem dau vao
    public static int checkScore(String msg){
        System.out.println(msg);
        while(true){
            try{
            int score = Integer.parseInt(sc.nextLine());
            if(score<0||score>100){
                System.out.println("Not valid");
                continue;
            }
            return score;
        }catch(NumberFormatException e){
            System.out.println("Re enter");
        }
        }
    }
    //check cho giao vien
    // check so nam trong nghe
    public static int checkNumberOfExperience(String msg,Person t){
        System.out.println(msg);
        while(true){
            try{
            String numberYear = sc.nextLine();
            int hieu = LocalDate.now().getYear()-t.getYearOfBirth();
            if(Integer.parseInt(numberYear)<0||hieu<Integer.parseInt(numberYear)){
                System.out.println("Not valid");
                continue;
            }
            return Integer.parseInt(numberYear);
        }catch(NumberFormatException e){
            System.out.println("Re enter");
        }
        }
    }
    // check loai hop dong
    public static String checkTypeContract(String msg){
        System.out.println(msg);
        while(true){
            String type = sc.nextLine();
            if(type.equalsIgnoreCase("long")||type.equalsIgnoreCase("short")){
                return type;
            }else{
                System.out.println("Not valid");
            }
        }
        
    }
    // check he so luong
    public static double checkNumerOfSalary(String msg){
        System.out.println(msg);
        while(true){
            try{
            double num = Double.parseDouble(sc.nextLine());
            if(num<0){
                System.out.println("Not valid");
                continue;
            }
            return num;
        }catch(NumberFormatException e){
            System.out.println("Re enter");
        }
        }
        
    }
    // Nhap vao mot person
    public static Person enterPerson(){
            String id = checkId("Enter ID: ");
            String name = checkName("Enter name: ");
            String phoneNumber = checkPhone("Enter phone number: ");
            int date = checkDate("Enter year of birth: ");
            String major = checkMajor("Enter your major: ");
            return new Person(id, name, phoneNumber, date, major);
    }
    // Nhap vao mot student
    public static Student enterStudent(){
        Person p = enterPerson();
        int year = checkStartYear("Enter start date: ",p );
        double score = checkScore("Enter score: ");
        return new Student(year, score, p);
    }
    // Nhao vao mot teacher
    public static Teacher enterTeacher(){
        Person p = enterPerson();
        int year = checkNumberOfExperience("Enter number of experience: ", p);
        double number = checkNumerOfSalary("Enter Salary coefficient: ");
        String type = checkTypeContract("Enter type contract: ");
        return new Teacher(year, type, year, p);
    }
    // check so
    public static int checkNum(String msg){
        System.out.println(msg);
        while(true){
            try{
            int size = Integer.parseInt(sc.nextLine());
            if(size<=0){
                System.out.println("Not valid");
                continue;
            }
            return size;
        }catch(NumberFormatException e){
            System.out.println("Re enter");
        }
        }
        
    }
    // ham display
    public static void display(List a){
        if(a.isEmpty()) System.out.println("Empty");
        else {
            for(int i = 0;i<a.size();i++){
            System.out.println(a.get(i));
        }
        }
    }
}
