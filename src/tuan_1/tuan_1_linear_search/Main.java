/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package tuan_1.tuan_1_linear_search;

/**
 *
 * @author nguye
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        LinearSearch ln = new LinearSearch(Validator.checkNum("Nhap vao kich thuoc mang: "));
        ln.taoMang(Validator.checkNum("Nhap vao scope: "));
        ln.showArray();
        int kq = ln.findValue(Validator.checkNum("Nhap vao so can tim: "));
        if(kq>=0){
            System.out.println("Tim thay tai index "+kq);
        }else{
            System.out.println("Khong tim thay");
        }
        
    }
}
