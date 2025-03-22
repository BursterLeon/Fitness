package mainPackage;
import exceptions.*;
import people.Customer;
import utils.Utility;

import java.util.Scanner;
import java.util.InputMismatchException;
//Input calories
public class CaloriesInputHandler extends InputHandler {
    public CaloriesInputHandler() {
        super();
    }
    public int readCaloriesInput() {
        while (true) {
            try {
                System.out.println("Please enter the calories, you are consuming per day?");
                int caloriesInput = getValidInt();
                if (caloriesInput < 1)
                    throw new IllegalArgumentException("The calories must be greater than 0");
                return caloriesInput;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }
    public int readCaloriesOutput() {
        while (true) {
            try {
                System.out.println("Please enter the calories, you are burning per day?");
                int caloriesOutput = getValidInt();
                if (caloriesOutput < 1)
                    throw new IllegalArgumentException("The calories must be greater than 0");
                return caloriesOutput;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }


        public void promptCaloriesOption() {
            while (true) {
                System.out.println("\n📊 What would you like to enter?");
                System.out.println("1. Enter calories consumed (IN)");
                System.out.println("2. Enter calories burned (OUT)");
                System.out.println("3. Exit");

                int choice = getValidInt();

                switch (choice) {
                    case 1:
                        int caloriesIn = readCaloriesInput();
                        System.out.println("You entered: " + caloriesIn + " calories consumed.");
                        break;
                    case 2:
                        int caloriesOut = readCaloriesOutput();
                        System.out.println("You entered: " + caloriesOut + " calories burned.");
                        break;
                    case 3:
                        System.out.println(" Exiting calorie input...");
                        return;
                    default:
                        System.out.println("Invalid choice. Please choose 1, 2, or 3.");
                }
            }
        }
}