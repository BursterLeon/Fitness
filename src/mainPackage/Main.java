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
        int activityLevel = userInputHandler.GetActivityLevel();
        scanner.nextLine();
        int id = (int) (Math.random() * 1000);
        System.out.println("======Create Account Sucess ====== ");
        System.out.println("User Information: ");
        System.out.println("Name: " + name);
        System.out.println("Age: " + age);
        System.out.println("Gender: " + gender);
        System.out.println("Height: " + height);
        System.out.println("Weight: " + weight);
        System.out.println("AcitivityLevel " + activityLevel);
        System.out.println("================================= ");




        //Update to constructor of Customer
        Customer.Goal goal = userInputHandler.getGoal();
// Output the Data and let them know what they need to do to aachive their goal
        double weightGoal = 0;
        if (goal ==Customer.Goal.looseWeight){
            System.out.println("How many Pound you want to loss per week ?");

            weightGoal = userInputHandler.getValidDouble();

            if (weightGoal < 0 || weightGoal > 15) {
                throw new NumberFormatException("Invalid input! We suggest you loss from 1-5 pound per week to keep it healthy ");
            }


        }

        Customer m = new Customer(name, age, gender, height, weight, id, goal, activityLevel);
        if (goal ==Customer.Goal.looseWeight){
            m.setWeightLoss(weightGoal);
            System.out.println ("=======================");

            System.out.println("To reach your goal you have to burn about** " + m.getDayLoss()+ " Calories ** per week");
        }

        // int caloriesRecommend=;
        // Asking weight want to loss per week


        CaloriesInputHandler caloriesInputHandler = new CaloriesInputHandler();
        int dailyCalorieGoal = (int) (m.getDayLoss());
        // Get Customer Chose option to work



        //===========================Track or Exercíe============================================

        CalorieTracker calorieTracker = new CalorieTracker(dailyCalorieGoal, 0, 0);

        while (true){
        System.out.println(" /n1.Track your Calories \n 2.Workout \n 3.Exits");
        String goalInput = scanner.nextLine().trim();
        switch (goalInput) {
            case "1":
                int caloriesConsumed = caloriesInputHandler.readCaloriesInput();
                int caloriesExpended = caloriesInputHandler.readCaloriesOutput();
                calorieTracker.addCaloriesConsumed(caloriesConsumed);
                calorieTracker.addCaloriesExpended(caloriesExpended);
                int remainingCalories = calorieTracker.getRemainingCalories();
                System.out.println("To reach your goal, you have to burn ** " + remainingCalories + " Calories ** today.");
                calorieTracker.displayCalorieSummary();

                break;
            case "2":

            case "3":
                System.out.println("Exiting calorie tracker...");
                scanner.close();
                break;

            default:

        }


        //CalorieTracker calorieTracker = new CalorieTracker();

        // //////////////////
    }
    }
}