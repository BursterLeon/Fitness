package mainPackage;

import people.*;
import interfaces.*;
import tracker.*;
import utils.*;
import exceptions.*;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Trainer Marc = new Trainer("Marc",28,"Male",180,70,85, "Cardio/looseWeight",3);
        Trainer Melissa = new Trainer("Melissa",24,"Female",165,60,90, "Strength/GainMuscles",2);
        Trainer Olivia = new Trainer("Olivia",34,"Female",170,60,95, "Yoga/HealthyLifestyle",8);

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

            System.out.println("To reach your goal you have to burn about ** " + m.getDayLoss()+ " Calories ** per week");
        } else if ( goal == Customer.Goal.gainMuscles){
            System.out.println(FitnessPlan.GetMuscle(weight, activityLevel));
        }else if (goal == Customer.Goal.stayHealthy){
            System.out.println(FitnessPlan.GetFitness(weight, activityLevel));
        }

        // int caloriesRecommend=;
        // Asking weight want to loss per week


        CaloriesInputHandler caloriesInputHandler = new CaloriesInputHandler();
        int dailyCalorieGoal = (int) (m.getDayLoss());
        // Get Customer Chose option to work



        //===========================Track or ExercÃ­e============================================

        CalorieTracker calorieTracker = new CalorieTracker(dailyCalorieGoal, 0, 0);

        while (true){
            System.out.println("1.Track your Calories \n 2.Workout \n 3.Exits");
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
                    //Aydan's part
                    String exerciseName = ".";
                    String targetMuscleGroup = ".";
                    double caloriesBurnedPerMinute = 0;
                    ArrayList<Exercise> exercises = new ArrayList<> ();
                    Exercise exercise = new Exercise(exerciseName, targetMuscleGroup, caloriesBurnedPerMinute);
                    Workout workout = new Workout (exerciseName,targetMuscleGroup,caloriesBurnedPerMinute,exercises);
                    workout.startWorkout();
                    break;

                case "3":
                    System.out.println("Exiting calorie tracker...");

                    return;

                default:
                    System.out.println("Please try again!");
            }

        }
    }
}
