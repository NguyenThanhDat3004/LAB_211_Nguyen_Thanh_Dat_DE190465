package tuan_1.tuan_1_dem_tu.view;

import java.util.Map;

import tuan_1.tuan_1_dem_tu.model.CountManagement;

public class CountView {
    // ham hien thi tu sau khi split
    public void displayWords(CountManagement CM){
        for (Map.Entry<String, Integer> entry : CM.getWordInfor().entrySet()) {
            System.out.print(entry.getKey() + ": " + entry.getValue()+", ");
        }
    }
    // hien thi thong tin ki tu
    public void displayCharacter(CountManagement CM){
        for (Map.Entry<Character, Integer> entry : CM.getCharacterInfor().entrySet()) {
            System.out.print(entry.getKey() + ": " + entry.getValue()+", ");
        }
    } 
}
