package tuan_3.quick_sort;

import java.util.Random;

public class QuickSort {
    private int[] array;
    private int size;
    public int[] getArray() {
        return array;
    }
    public int getSize() {
        return size;
    }
    public void setArray(int[] array) {
        this.array = array;
    }
    public void setSize(int size) {
        this.size = size;
        array = new int[size]; // cap nhat lai kich thuoc mang
    }
    // tao mang ngau nhien
    public void randomArray() {
        Random  rand = new Random();
        for (int i = 0; i < size; i++) {
            array[i] = rand.nextInt(size);
        }
    }
    // in mang
    public void printArray() {
        for (int i = 0; i < size; i++) {
            System.out.print(array[i] + " ");
        }
        System.out.println();
    }
    // quick sort
    // phan hoach mang
    private int partition(int left, int right) {
        int pivot = array[right]; // chon diem chot la phan tu giua
        int i = left - 1;
        for (int j = left; j < right; j++) {
            if (array[j] <= pivot) {
                i++;
                // doi cho
                int temp = array[i];
                array[i] = array[j];
                array[j] = temp;
            }
        }
        // doi cho phan tu cuoi cung voi phan tu i+1
        int temp = array[i + 1];
        array[i + 1] = array[right];
        array[right] = temp;
        return i + 1;
    }
    // chon diem chot la phan tu cuoi cung
    public void quickSort(int left, int right) {
        if (left < right) {
            int pivot = partition(left, right);
            quickSort(left, pivot - 1);
            quickSort(pivot + 1, right);
        }
    }

}

