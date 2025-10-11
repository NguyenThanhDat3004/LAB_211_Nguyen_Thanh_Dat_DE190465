package tuan_1.tuan_1_dem_tu.controller;

import java.util.Scanner;

import tuan_1.tuan_1_dem_tu.model.CountManagement;
import tuan_1.tuan_1_dem_tu.view.CountView;

public class CountController {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        CountManagement CM = new CountManagement();
        CountView CV = new CountView();
        System.out.println("Enter your content: ");
        String content = sc.nextLine();
        CM.splitWords(content);
        CV.displayWords(CM);
        System.out.println();
        CM.splitCharacter(content);
        CV.displayCharacter(CM);
    }
}
