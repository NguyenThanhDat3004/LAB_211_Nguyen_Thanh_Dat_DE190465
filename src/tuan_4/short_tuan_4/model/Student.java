/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tuan_4.short_tuan_4.model;

/**
 *
 * @author nguye
 */
public class Student extends Person{
    private int startDate;
    private double score;
    // con
    public Student(){
        super();
        this.score = 0;
        this.startDate = 0;
    }
    // cons day du

    public Student(int startDate, double score,Person p) {
        super(p.getId(),p.getName(),p.getPhoneNumber(),p.getYearOfBirth(),p.getMajor());
        this.startDate = startDate;
        this.score = score;
    }
    
    // get

    public double getScore() {
        return score;
    }

    public int getStartDate() {
        return startDate;
    }
    // set 

    public void setScore(double score) {
        this.score = score;
    }

    public void setStartDate(int startDate) {
        this.startDate = startDate;
    }

    @Override
    public String toString() {
        return super.toString()+"-"+score+"-"+startDate;
    }
    
    
}
