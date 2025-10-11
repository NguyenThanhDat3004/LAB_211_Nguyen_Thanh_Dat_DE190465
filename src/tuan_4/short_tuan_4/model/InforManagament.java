/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tuan_4.short_tuan_4.model;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.List;

/**
 *
 * @author nguye
 */
public class InforManagament {
    private List<Student> listStudent = new ArrayList();
    private List<Teacher> listTeacher = new ArrayList();
    private List<Person> list = new ArrayList<>();
    private List<Person> listSearch = new ArrayList<>();
    // get 

    public List<Person> getListSearch() {
        return listSearch;
    }
    
    public List<Student> getListStudent() {
        return listStudent;
    }

    public List<Teacher> getListTeacher() {
        return listTeacher;
    }

    public List<Person> getList() {
        return list;
    }
    
    public void addPerson(Person p){
        list.add(p);
    }
    //add list
    public void addTeacher(Teacher t){
        listTeacher.add(t);
        addPerson(t);
        // sap xep nam kinh nghiem giam
        listTeacher.sort(Comparator.comparing(Teacher::getYearOfExperience).reversed());
    }
    // add list hoc sinh
    public void addStudent(Student s){
        listStudent.add(s);
        addPerson(s);
        listStudent.sort(Comparator.comparing(Student::getStartDate));
    }
    // tim kiem
    public List<Person> search(String name){
        listSearch.clear();
        Predicate<Person> search = p->p.getName().equalsIgnoreCase(name);
        listSearch = listStudent.stream().filter(search).collect(Collectors.toList());
        listSearch.addAll(listTeacher.stream().filter(search).collect(Collectors.toList()));
        listSearch.sort(Comparator.comparing(Person::getYearOfBirth).reversed());
        return listSearch;
    }
}
