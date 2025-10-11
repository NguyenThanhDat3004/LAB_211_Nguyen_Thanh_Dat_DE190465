/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tuan_2.chuong_trinh_tinh_chu_vi_va_dien_tich.controller;
import tuan_2.chuong_trinh_tinh_chu_vi_va_dien_tich.model.Circle;
import tuan_2.chuong_trinh_tinh_chu_vi_va_dien_tich.model.Rectangle;
import tuan_2.chuong_trinh_tinh_chu_vi_va_dien_tich.model.Triangle;
import tuan_2.chuong_trinh_tinh_chu_vi_va_dien_tich.utils.Tien_Ich;
import tuan_2.chuong_trinh_tinh_chu_vi_va_dien_tich.view.Solution;
public class App {
    // ham them data
    Circle ci;
    Triangle t;
    Rectangle r;
    
    public void enterData(){
        System.out.println("=====Calculator Shape Program=====");
        double a = Tien_Ich.checkNum("Please input side width of Rectangle:");
        double b = Tien_Ich.checkNum("Please input length of Rectangle:");
        r = new Rectangle(a, b);
        double c = Tien_Ich.checkNum("Please input radius of Circle:");
        ci = new Circle(c);
        double d,e,f;
        while(true){
            d = Tien_Ich.checkNum("Please input side A of Triangle:");
            e = Tien_Ich.checkNum("Please input side B of Triangle:");
            f = Tien_Ich.checkNum("Please input side C of Triangle:");
            if(Tien_Ich.checkTriangle(d, e, f)){
                t = new Triangle(d, e, f);
                break; // thoat lap neu oke
            }else{
            System.out.println("Not a 3 side of triangle, please try again");
        }
        }
        
    }
    // view nghiem
    public void viewSolution(){
        Solution s = new Solution();
        s.showSolution(ci, r, t);
    }
    public static void main(String[] args) {
        App a = new App();
        a.enterData();  
        a.viewSolution();
    }
}
