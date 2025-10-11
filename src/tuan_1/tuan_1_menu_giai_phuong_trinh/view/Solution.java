package tuan_1.tuan_1_menu_giai_phuong_trinh.view;

import tuan_1.tuan_1_menu_giai_phuong_trinh.model.NumberManagement;
import tuan_1.tuan_1_menu_giai_phuong_trinh.model.Number;

public class Solution {
    public void displaySolution(NumberManagement nm){
        if(nm.getResults().isEmpty()){
            System.out.println("Phuong trinh vo nghiem");
            return;
        }
        for(int i = 0;i<nm.getResults().size();i++){
            System.out.println("Nghiem "+(i+1)+": "+nm.getResults().get(i));
        }
    }
    public void inforNumber(NumberManagement nm){
        if(nm.getThamSo().isEmpty()){
                System.out.println("Chua nhap tham so");
                return;
            }
        System.out.print("Even number is: ");
        for (Number num : nm.getListSoChan()) {
            System.out.print(num+", ");
        }
        System.out.println("");
        System.out.print("Odd number is: ");
        for (Number num : nm.getListSoLe()) {
            System.out.print(num+", ");
        }
        System.out.println("");
        System.out.print("Perfect square number is: ");
        for (Number num : nm.getListSoChinhPhuong()) {
            System.out.print(num+", ");
        }
        System.out.println("");
    }
}
