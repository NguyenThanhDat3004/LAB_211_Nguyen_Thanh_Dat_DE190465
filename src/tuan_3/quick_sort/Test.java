package tuan_3.quick_sort;

public class Test {
    public static void main(String[] args) {
        QuickSort qs = new QuickSort();
        qs.setSize(Validator.checkNum("Enter size: "));
        qs.setArray(new int[qs.getSize()]);
        qs.randomArray();
        qs.printArray();
        qs.quickSort(0, qs.getSize() - 1);
        qs.printArray();
    }
    
}
