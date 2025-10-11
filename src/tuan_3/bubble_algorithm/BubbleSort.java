/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package tuan_3.bubble_algorithm;

import java.util.Random;

/**
 *
 * @author nguye
 */
public class BubbleSort {
    
    private int[] array;
    public int[] getArray() {
        return array;
    }
    public void setArray(int[] array) {
        this.array = array;
    }
    public BubbleSort(int n) {
        this.array = new int[n];
    }

    public void taoMang(int scope){
        Random r = new Random();
        for(int i = 0; i < array.length; i++){
            array[i] = r.nextInt(scope);
        }
    }
    public void showArray(){
        for (int i = 0; i < array.length; i++){
            System.out.print(array[i]+ " ");
        }
        System.out.println("");
    }
    // ham sap xep 
    public void sort(){
        int flag = 1;
        int count = 0;
        for(int i=0;i<array.length-1;i++){
            for(int j=0;j<array.length-i-1;j++){
                count++;
                if(array[j]>array[j+1]){
                    int temp = array[j];
                    array[j] = array[j+1];
                    array[j+1] = temp;
                    flag = 0;
                }
            }
            if(flag==1){
                break; // mang da duoc sap xep thi khong sort
            }
        }
        System.out.println("So lan so sanh: "+count);
    }
}
