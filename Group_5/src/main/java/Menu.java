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

public class Menu {
    // Method to display options and get user's choice
    public int int_getChoice(ArrayList<String> options) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Please choose an option:");
        for (int i = 0; i < options.size(); i++) {
            System.out.println((i + 1) + ". " + options.get(i));
        }
        System.out.print("Enter your choice (1-" + options.size() + "): ");

        int choice = -1;
        boolean validInput = false;
        while (!validInput) {
            try {
                choice = Integer.parseInt(sc.nextLine());
                if (choice >= 1 && choice <= options.size()) {
                    validInput = true;
                } else {
                    System.out.print("Invalid choice. Please enter a number between 1 and " + options.size() + ": ");
                }
            } catch (NumberFormatException e) {
                System.out.print("Invalid input. Please enter a number: ");
            }
        }
        return choice;
    }
}
