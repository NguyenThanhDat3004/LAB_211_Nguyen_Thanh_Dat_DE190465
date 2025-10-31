package org.view;

import org.model.Fruit;
import org.model.User_Maganement;

public class Solution {
    public void displayFruit(User_Maganement m){
        int i = 1;
        for(Fruit t : m.getFruitList()){
            System.out.println(i + ". " + t);
            i++;
        }
    }
}
