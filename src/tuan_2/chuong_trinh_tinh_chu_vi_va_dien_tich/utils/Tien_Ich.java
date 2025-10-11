/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tuan_2.chuong_trinh_tinh_chu_vi_va_dien_tich.utils;

import java.util.Scanner;

/**
 *
 * @author nguye
 */
public class Tien_Ich {
    static Scanner sc = new Scanner(System.in);
    // ham check 3 canh cua 1 tam giac
    public static boolean checkTriangle(double a, double b, double c){
        if(a+b>c&&b+c>a&&a+c>b){
            return true;
        }
        return false;
    }
    public static double checkNum(String msg){
        System.out.println(msg);
        while(true){
            try{
            double num = Double.parseDouble(sc.nextLine());
            if(num<=0){
                System.out.println("Please input number greater than 0");
                continue;
            }
            return num;
        }catch(NumberFormatException e){
            System.out.println("Not valid. Re enter");
        }
        }
    }
}
