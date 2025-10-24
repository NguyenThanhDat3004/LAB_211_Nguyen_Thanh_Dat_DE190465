package tuan_6.view;

import tuan_6.model.Fruit;
import tuan_6.model.User_Maganement;

public class Solution {
    public void getListFruit(User_Maganement m){
        System.out.println("List of Fruit: ");
        for(Fruit fr : m.getListFruit()){
            System.out.println(fr);
        }
    }
}
