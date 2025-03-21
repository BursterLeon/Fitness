package mainPackage;
import exceptions.*;
import people.Customer;
import utils.Utility;

import java.util.Scanner;
import java.util.InputMismatchException;

public class CaloriesInputHandler {
    private Scanner scanner;
    public CaloriesInputHandler() {
        scanner = new Scanner(System.in);
    }
    public int readCalories() {
        System.out.println("Enter Calories: ");
        while (!scanner.hasNextInt()) {
            System.out.println("Invalid input! Please enter a valid Integer ");
            scanner.next();
        }
        return scanner.nextInt();
    }
}
