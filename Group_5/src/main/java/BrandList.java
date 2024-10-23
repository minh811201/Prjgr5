/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Admin
 */
import java.io.*;
import java.util.*;
class BrandList {

    private List<Brand> brands = new ArrayList<>();

    public boolean loadFromFile(String filename) {
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length == 4) {
                    String brandID = parts[0].trim();
                    String brandName = parts[1].trim();
                    String soundBrand = parts[2].trim();
                    double price = Double.parseDouble(parts[3].trim());
                    brands.add(new Brand(brandID, brandName, soundBrand, price));
                }
            }
            return true;
        } catch (IOException e) {
            System.err.println("Error reading file: " + e.getMessage());
            return false;
        }
    }

    public boolean saveToFile(String filename) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filename))) {
            for (Brand brand : brands) {
                writer.write(brand.toString() + "\n");
            }
            return true;
        } catch (IOException e) {
            System.err.println("Error writing file: " + e.getMessage());
            return false;
        }
    }

    public int searchID(String bID) {
        for (int i = 0; i < brands.size(); i++) {
            if (brands.get(i).getBrandID().equals(bID)) {
                return i;
            }
        }
        return -1;
    }

    public Brand getUserChoice() {
        Scanner sc = new Scanner(System.in);
        for (int i = 0; i < brands.size(); i++) {
            System.out.println((i + 1) + ". " + brands.get(i));
        }
        System.out.print("Enter your choice: ");
        int choice = sc.nextInt();
        if (choice > 0 && choice <= brands.size()) {
            return brands.get(choice - 1);
        }
        return null;
    }

    public void addBrand() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter Brand ID: ");
        String brandID = sc.nextLine();
        if (searchID(brandID) != -1) {
            System.out.println("Brand ID already exists.");
            return;
        }
        System.out.print("Enter Brand Name: ");
        String brandName = sc.nextLine();
        System.out.print("Enter Sound Brand: ");
        String soundBrand = sc.nextLine();
        System.out.print("Enter Price: ");
        double price = sc.nextDouble();
        brands.add(new Brand(brandID, brandName, soundBrand, price));
    }

    public void updateBrand() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter Brand ID to update: ");
        String brandID = sc.nextLine();
        int pos = searchID(brandID);
        if (pos == -1) {
            System.out.println("Brand not found.");
            return;
        }
        Brand brand = brands.get(pos);
        System.out.print("Enter new Brand Name (leave blank to keep current): ");
        String brandName = sc.nextLine();
        if (!brandName.isBlank()) {
            brand.setBrandName(brandName);
        }
        System.out.print("Enter new Sound Brand (leave blank to keep current): ");
        String soundBrand = sc.nextLine();
        if (!soundBrand.isBlank()) {
            brand.setSoundBrand(soundBrand);
        }
        System.out.print("Enter new Price (or 0 to keep current): ");
        double price = sc.nextDouble();
        if (price > 0) {
            brand.setPrice(price);
        }
    }

    public void listBrands() {
        for (int i = 0; i < brands.size(); i++) {
            System.out.println((i + 1) + ". " + brands.get(i));
        }
    }
}
