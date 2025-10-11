/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package tuan_3.bubble_algorithm;

/**
 *
 * @author nguye
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        BubbleSort sort = new BubbleSort(Validator.checkNum("Nhap vao kich thuoc mang: "));
        sort.taoMang(Validator.checkNum("Nhap vao scope: "));
        sort.showArray();
        sort.sort();
        sort.showArray();
        int [] a = {0,1,2,3,4,5,6,7,8,9};
        sort.setArray(a);
        sort.sort();
        sort.showArray();
    }
}
