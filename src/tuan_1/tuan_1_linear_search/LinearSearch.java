/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package tuan_1.tuan_1_linear_search;

import java.util.Random;

/**
 *
 * @author nguye
 */
public class LinearSearch {
    
    private int[] array;

    public LinearSearch(int n) {
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
    // ham tim kiem 
    public int findValue(int x){
         for(int i = 0; i < array.length; i++){
            if(array[i]==x) return i;
        }
         return -1;
    }
    
}
