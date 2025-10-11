/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tuan_4.short_tuan_4.view;

import tuan_4.short_tuan_4.model.InforManagament;
import tuan_4.short_tuan_4.utils.Validator;

/**
 *
 * @author nguye
 */
public class Solution {
    public void displayTeacher(InforManagament m){
        Validator.display(m.getListTeacher());
    }
    // sinh vien
    public void displayStudent(InforManagament m){
        Validator.display(m.getListStudent());
    }
    // Person
    public void displaySearch(InforManagament m){
        Validator.display(m.getListSearch());
    }
    public void displayPerson(InforManagament m){
        Validator.display(m.getList());
    }
    
}
