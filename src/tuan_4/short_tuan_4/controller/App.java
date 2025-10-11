/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tuan_4.short_tuan_4.controller;

import tuan_4.short_tuan_4.model.InforManagament;
import tuan_4.short_tuan_4.utils.Validator;
import tuan_4.short_tuan_4.view.Menu1;
import tuan_4.short_tuan_4.view.Solution;

/**
 *
 * @author nguye
 */
public class App extends Menu1{
    InforManagament m = new InforManagament();
    public App(){
        super("Information Managament", new String[]{
            "Teacher","Student","Person","Exit"
        });
    }

    @Override
    public void execute(int n) {
        switch(n){
            case 1:
                MenuTeacher t = new MenuTeacher(m);
                t.run();
                break;
            case 2:
                MenuStudent s = new MenuStudent(m);
                s.run();
                break;
            case 3:
                MenuPerson p = new MenuPerson(m);
                p.run();
                break;
            case 4:
                System.out.println("Exitting...");
                break;
            default:
                System.out.println("Choice is not valid! Try again!");
                break;
        }
    }
    // main
    public static void main(String[] args) {
        App a = new App();
        a.run();
    }
    
}
class MenuTeacher extends Menu1{
    private InforManagament m;
    Solution solu = new Solution();
    public MenuTeacher(InforManagament m){
        super("Teacher Information", new String[]{"Input","Print","Exit"});
        this.m = m;
    }
    @Override
    public void execute(int n) {
        switch (n) {
            case 1:
                m.addTeacher(Validator.enterTeacher());
                break;
            case 2:
                solu.displayTeacher(m);
                break;
            case 3:
                System.out.println("Exitting...");
                break;
            default:
                System.out.println("Choice is not valid! Try again!");
                break;
        }
    }
    
}
class MenuPerson extends Menu1{
    private InforManagament m;
    Solution solu = new Solution();
    public MenuPerson(InforManagament m){
        super("Person Information", new String[]{"Search","Print all","Exit"});
        this.m = m;
    }

    @Override
    public void execute(int n) {
        switch (n) {
            case 1:
                m.search(Validator.checkName("Enter name: "));
                solu.displaySearch(m);
                break;
            case 2:
                solu.displayPerson(m);
                break;
            case 3:
                System.out.println("Exitting...");
                break;
            default:
                System.out.println("Choice is not valid! Try again!");
                break;
        }
    }
    
}
class MenuStudent extends Menu1{
    private InforManagament m;
    Solution solu = new Solution();
    public MenuStudent(InforManagament m){
        super("Student Information", new String[]{"Input","Print","Exit"});
        this.m = m;
    }

    @Override
    public void execute(int n) {
        switch (n) {
            case 1:
                m.addStudent(Validator.enterStudent());
                break;
            case 2:
                solu.displayStudent(m);
                break;
            case 3:
                System.out.println("Exitting...");
                break;
            default:
                System.out.println("Choice is not valid! Try again!");
                break;
        }
    }
    
}