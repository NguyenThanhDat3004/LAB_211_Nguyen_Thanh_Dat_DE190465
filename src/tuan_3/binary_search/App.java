package tuan_3.binary_search;

public class App {
    public static void main(String[] args) {
        BinarySearch bs = new BinarySearch();
        bs.setSize(Validator.checkNum("Enter size: "));
        // set lai mang voi size moi
        bs.setArray(new int[bs.getSize()]);
        // khong co dong 9 ben class kia la loi tiem an, crash
        bs.randomArray();
        bs.printArray();
        bs.sortArray();
        bs.printArray();
        int index = bs.binarySearch(Validator.checkNum("Enter key: "));
        if(index == -1){
            System.out.println("Not found");
        } else {
            System.out.println("Found at index: " + index);
        }
    }
}
