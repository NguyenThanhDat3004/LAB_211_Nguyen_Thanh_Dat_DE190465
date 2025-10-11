package tuan_2.chuong_trinh_may_tinh.view;

import tuan_2.chuong_trinh_may_tinh.model.BMI_Calculation;

public class Solution {
    public void display(BMI_Calculation bmiCalculation) {
        System.out.println("BMI number: "+bmiCalculation.calculateBMI());
        System.out.println("Status: "+bmiCalculation.getStatus().getMessage());
    }
}
