/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Admin
 */
import java.util.Scanner;
import java.io.*;
import java.util.ArrayList;
public class CarList {
    private ArrayList<Car> cars = new ArrayList<>();
    private BrandList brandList;
    public CarList(BrandList brandList) {
        this.brandList = brandList;
    }
    public boolean loadFromFile(String filename) {
        try {
            BufferedReader br = new BufferedReader(new FileReader(filename));
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(", ");
                if (parts.length == 5) {
                    String carID = parts[0];
                    String brandID = parts[1];
                    Brand brand = brandList.getBrandByID(brandID);
                    String color = parts[2];
                    String frameID = parts[3];
                    String engineID = parts[4];
                    Car car = new Car(carID, brand, color, frameID, engineID);
                    cars.add(car);
                }
            }
            br.close();
            return true;
        } catch (IOException e) {
            System.out.println("Error loading cars from file.");
            return false;
        }
    }
    public boolean saveToFile(String filename) {
        try {
            BufferedWriter bw = new BufferedWriter(new FileWriter(filename));
            for (Car car : cars) {
                bw.write(car.toString() + "\n");
            }
            bw.close();
            return true;
        } catch (IOException e) {
            System.out.println("Error saving cars to file.");
            return false;
        }
    }
    public void addCar(Car newCar) {
        if (searchByID(newCar.getCarID()) == -1) {
            cars.add(newCar);
            System.out.println("Car added successfully.");
        } else {
            System.out.println("Car ID already exists.");
        }
    }
    public int searchByID(String carID) {
        for (int i = 0; i < cars.size(); i++) {
            if (cars.get(i).getCarID().equals(carID)) {
                return i;
            }
        }
        return -1;  
    }
    public void listCars() {
        for (Car car : cars) {
            System.out.println(car);
            
        }
    }
    public void updateCar() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter car ID to update: ");
        String carID = sc.nextLine();
        int pos = searchByID(carID);
        if (pos < 0) {
            System.out.println("Car not found!");
        } else {
            Car carToUpdate = cars.get(pos);
            Brand newBrand = brandList.getUserChoice();
            carToUpdate.setBrand(newBrand);
            System.out.print("Enter new color (leave blank to keep current): ");
            String color = sc.nextLine();
            if (!color.isEmpty()) {
                carToUpdate.setColor(color);
            }
            System.out.print("Enter new frame ID (leave blank to keep current): ");
            String frameID = sc.nextLine();
            if (!frameID.isEmpty()) {
                carToUpdate.setFrameID(frameID);
            }
            System.out.print("Enter new engine ID (leave blank to keep current): ");
            String engineID = sc.nextLine();
            if (!engineID.isEmpty()) {
                carToUpdate.setEngineID(engineID);
            }
            System.out.println("Car updated successfully.");
        }
    }
}
