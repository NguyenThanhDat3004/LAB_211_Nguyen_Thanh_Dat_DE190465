package tuan_1.tuan_1_menu_giai_phuong_trinh.controller;

import java.util.Scanner;

import tuan_1.tuan_1_menu_giai_phuong_trinh.model.NumberManagement;
import tuan_1.tuan_1_menu_giai_phuong_trinh.view.Menu1;
import tuan_1.tuan_1_menu_giai_phuong_trinh.view.Solution;
import tuan_1.tuan_1_menu_giai_phuong_trinh.model.Number;

public class AppController extends Menu1{
    NumberManagement nm  = new NumberManagement();
    Scanner sc = new Scanner(System.in);
    Solution solution = new Solution();
    public AppController() {
        super("Menu giai phuong trinh", new String[]{
            "Giai phuong trinh bac nhat",
            "Giai phuong trinh bac hai"
        });
    }
    @Override
    public void execute(int n) {
        Number a = new Number();
        Number b = new Number();
        switch (n) {
            case 1:
                nm.clearList(); // clear tham so trong list
                a.setValue(inputNumber("Nhap a: ").getValue());
                b.setValue(inputNumber("Nhap b: ").getValue());
                nm.calculateEquation(a.getValue(), b.getValue());
                solution.displaySolution(nm);
                nm.thuThapThongTin();
                solution.inforNumber(nm);
                break;
            case 2:
                nm.clearList(); // clear tham so trong list
                a.setValue(inputNumber("Nhap a: ").getValue());
                b.setValue(inputNumber("Nhap b: ").getValue());
                Number c = new Number();
                c.setValue(inputNumber("Nhap c: ").getValue());;
                nm.calculateEquation2(a.getValue(), b.getValue(), c.getValue());
                solution.displaySolution(nm);
                nm.thuThapThongTin();
                solution.inforNumber(nm);
                break;
            default:
            System.out.println("Thoat chuong trinh");
                break;
        }
    }
    // ham nhap so
    public Number inputNumber(String msg){
        System.out.println(msg);
        int flag;
        Number num;
    do {
            flag=0;
            String b = sc.nextLine();
            num = new Number();
            // check valid
            if(num.checkIn(b) == null){
                flag=1;
                System.out.println("Khong phai so thuc, vui long nhap lai!");
            }else{
                num.setValue(num.checkIn(b));
                }
            } while (flag==1);
        nm.addElement(num);
        return num;
    }
    public static void main(String[] args) {
        AppController app = new AppController();
        app.run();
    }
}
