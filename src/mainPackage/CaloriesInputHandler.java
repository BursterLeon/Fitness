package mainPackage;
import exceptions.*;
import people.Customer;
import utils.Utility;

import java.util.Scanner;
import java.util.InputMismatchException;

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
}
