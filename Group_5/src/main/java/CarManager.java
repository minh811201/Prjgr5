/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Admin
 */
import java.util.ArrayList;
import java.util.Scanner;

public class CarManager {
    private static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<String> options = new ArrayList<>();
        options.add("List all brands");
        options.add("Add a new brand");
        options.add("Search a brand by ID");
        options.add("Update a brand");
        options.add("Save brands to file");
        options.add("List all cars in ascending order of brand names");
        options.add("List cars based on a part of an input brand name");
        options.add("Add a car");
        options.add("Remove a car by ID");
        options.add("Update a car by ID");
        options.add("Save cars to file");

        BrandList brandList = new BrandList();
        brandList.loadFromFile("brands.txt");
        CarList carList = new CarList(brandList);
        carList.loadFromFile("cars.txt");

        Menu menu = new Menu();
        int choice;

        do {
            choice = menu.int_getChoice(options);
            switch (choice) {
                case 1:
                    brandList.listBrands();
                    break;
                case 2:
                    
                    break;
                case 3:
                    
                    break;
                case 4:
                    
                    break;
                case 5:
                    brandList.saveToFile("brands.txt");
                    break;
                case 6:
                    carList.listCars();
                    break;
                case 7:
                    System.out.print("Enter part of brand name: ");
                    String part = sc.nextLine();
                    carList.printBasedBrandName(part);
                    break;
                case 8:
                    
                    break;
                case 9:
                  
                    break;
                case 10:
                    
                    break;
                case 11:
                    carList.saveToFile("cars.txt");
                    break;
            }
        } while (choice > 0 && choice <= 11);
        sc.close();
    }
}