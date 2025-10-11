package tuan_3.binary_search;

import java.util.Random;

public class BinarySearch {
    private int[] array;
    private int size;
    // constructor
    public BinarySearch(){
        this.size = 1;
        array = new int[size];
    }
    public int[] getArray() {
        return array;
    }
    public int getSize() {
        return size;
    }
    public void setArray(int[] array) {
        this.array = array;
    }public void setSize(int size) {
        this.size = size;
    }
    // tao mang ngau nhien
    public void randomArray(){
        Random rand = new Random();
        for(int i = 0; i < size; i++){
            array[i] = rand.nextInt(size);
        }
    }
    // in mang
    public void printArray(){
        for(int i = 0; i < size; i++){
            System.out.print(array[i] + " ");
        }
        System.out.println();
    }
    // sap xep mang
    public void sortArray(){
        for(int i = 0; i < size - 1; i++){
            for(int j = i + 1; j < size; j++){
                if(array[i] > array[j]){
                    int temp = array[i];
                    array[i] = array[j];
                    array[j] = temp;
                }
            }
        }
    }
    // tim kiem nhi phan
    public int binarySearch(int key){
        int left = 0;
        int right = size - 1;
        while(left <= right){
            int mid = (left + right) / 2;
            if(array[mid] == key){
                return mid;
            } else if(array[mid] < key){
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return -1; // khong tim thay
    }

}
