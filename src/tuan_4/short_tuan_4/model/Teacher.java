/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tuan_4.short_tuan_4.model;

/**
 *
 * @author nguye
 */
public class Teacher extends Person{
    private int yearOfExperience;
    private String typeContract;
    private int numberOfSalary;
    // cons

    public Teacher() {
        super();
        this.yearOfExperience = 0;
        this.typeContract = "";
        this.numberOfSalary = 0;
    }

    public Teacher(int yearOfExperience, String typeContract, int numberOfSalary,Person p) {
        super(p.getId(), p.getName(), p.getPhoneNumber(), p.getYearOfBirth(), p.getMajor());
        this.yearOfExperience = yearOfExperience;
        this.typeContract = typeContract;
        this.numberOfSalary = numberOfSalary;
    }
    
    // get

    public int getNumberOfSalary() {
        return numberOfSalary;
    }

    public String getTypeContract() {
        return typeContract;
    }

    public int getYearOfExperience() {
        return yearOfExperience;
    }
    // set

    public void setNumberOfSalary(int numberOfSalary) {
        this.numberOfSalary = numberOfSalary;
    }

    public void setTypeContract(String typeContract) {
        this.typeContract = typeContract;
    }

    public void setYearOfExperience(int yearOfExperience) {
        this.yearOfExperience = yearOfExperience;
    }

    @Override
    public String toString() {
        return super.toString()+"-"+yearOfExperience+"-"+typeContract+"-"+numberOfSalary;
    }
    
    
    
}
