package mainPackage;
import people.Customer;
import people.Trainer;
import tracker.CalorieTracker;
import utils.*;
import exceptions.*;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello and welcome, let us set up your account together.");
        Scanner scanner = new Scanner(System.in);
        UserInputHandler userInputHandler = new UserInputHandler(scanner);

        String name = userInputHandler.getName();
        int age = userInputHandler.getAge();
        String gender = userInputHandler.getGender();
        double height = userInputHandler.getHeight();
        double weight = userInputHandler.getWeight();
        Customer.Goal goal = userInputHandler.getGoal();
        int activityLevel = userInputHandler.GetActivityLevel();

        System.out.println("User Information: ");
        System.out.println("Name: "+ name);
        System.out.println("Age: " + age);
        System.out.println("Gender: "+gender);
        System.out.println("Height: " + height);
        System.out.println("Weight: " + weight);
        System.out.println("Goal: "+ goal);
        System.out.println("AcitivityLevel "+ activityLevel);

        CaloriesInputHandler caloriesInputHandler = new CaloriesInputHandler();

        int caloriesConsumed = caloriesInputHandler.readCaloriesInput();
        int caloriesExpended = caloriesInputHandler.readCaloriesOutput();
        CalorieTracker calorieTracker = new CalorieTracker(0,caloriesConsumed, caloriesExpended);

        // //////////////////
        scanner.close();
        Customer customer = new Customer(name, age, gender, height, weight, (int) (Math.random() * 100), goal, activityLevel);
    }
}