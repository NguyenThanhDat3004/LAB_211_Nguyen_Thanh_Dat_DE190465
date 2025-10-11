/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tuan_4.short_tuan_4.model;

/**
 *
 * @author nguye
 */
public class Person {
    private String id;
    private String name;
    private String phoneNumber;
    private int yearOfBirth;
    private String major;
    // cons
    public Person(){
        this.id = "";
        this.name = "";
        this.phoneNumber = "";
        this.yearOfBirth = 0;
        this.major = "";
    }
    // cons day du

    public Person(String id, String name, String phoneNumber, int yearOfBirth, String major) {
        this.id = id;
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.yearOfBirth = yearOfBirth;
        this.major = major;
    }
    
    // get set

    public String getId() {
        return id;
    }

    public String getMajor() {
        return major;
    }

    public String getName() {
        return name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public int getYearOfBirth() {
        return yearOfBirth;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void setYearOfBirth(int yearOfBirth) {
        this.yearOfBirth = yearOfBirth;
    }
    @Override
    public String toString() {
        return id + "-" + name + "-" + phoneNumber + "-" + yearOfBirth + "-" + major;
    }
    
}
