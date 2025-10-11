/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tuan_2.matrix.view;

import tuan_2.matrix.model.Matrix;

/**
 *
 * @author nguye
 */
public class Solution {
    public void displayMatrix(double[][] data){
        for(int i=0; i<data.length; i++){
            for(int j=0; j<data[i].length; j++){
                System.out.print("[" + data[i][j] + "]" + " ");
            }
            System.out.println();
        }
    }
    // Display tung case
    public void printOperation(String title, String operator, Matrix m1, Matrix m2, Matrix result) {
    System.out.println("-----" + title + "-----");
    this.displayMatrix(m1.getData());
    System.out.println(operator);
    this.displayMatrix(m2.getData());
    System.out.println("=");
    this.displayMatrix(result.getData());
}
}
