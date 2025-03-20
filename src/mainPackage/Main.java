package mainPackage;
import people.Customer;
import tracker.CalorieTracker;
import utils.*;
import exceptions.*;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello and welcome, let us set up your account together.");
        Scanner scanner = new Scanner(System.in);
        UserInputHandler userInputHandler = new UserInputHandler(scanner);

        String name ="";
        int age = 0;
        String gender = "";
        double height = 0;
        double weight = 0;
        Customer.Goal goal=null;
        int activityLevel = 0;


        Scanner scanner = new Scanner(System.in);
        int numberInput = 0;
        while (numberInput<7) {
            try {
                if (numberInput==0) {
                    System.out.print("Enter your name: ");
                    String input = scanner.nextLine();
                    if (Utility.isNullOrWhiteSpace(input))
                        throw new Exception("Name cannot be empty");
                    name = input.trim();
                    numberInput++;
                }
                if (numberInput==1) {
                    System.out.print("Enter your age: ");
                    if (!scanner.hasNextInt())
                        throw new WrongInputException("Age must be an integer");
                    int input = scanner.nextInt();
                    if (input < 0)
                        throw new NegativeNumberException("Age cannot be negative");
                    age = input;
                    scanner.nextLine();
                    numberInput++;
                }

                if (numberInput==2) {
                    System.out.print("Enter your gender: ");
                    String input = scanner.nextLine();
                    if (Utility.isNullOrWhiteSpace(input))
                        throw new Exception();
                    if (!(input.equals("Male") || input.equals("Female")))
                        throw new Exception("Must be Male or Female");
                    gender = input.trim();
                    numberInput++;
                }

                if (numberInput==3) {
                    System.out.print("Enter your height: ");
                    while (true) {
                        if (!scanner.hasNextDouble()){
                            System.out.println("Height Must be double, Pleast Try again!");
                        scanner.nextLine();
                        continue;
                    }
                    double input = scanner.nextDouble();
                    scanner.nextLine();
                    if (input < 0) {
                        System.out.println("Height cannot be negative");
                        continue;
                    }
                    height = input;
                    break;
                }
                    numberInput++;
                }

                if (numberInput==4) {
                    System.out.println("Enter your weight: ");
                    if (!scanner.hasNextDouble())
                        throw new WrongInputException("Weight must be a double");
                    double input = scanner.nextDouble();
                    if (input < 0)
                        throw new NegativeNumberException("Weight cannot be negative");
                    weight = input;
                    scanner.nextLine();
                    numberInput++;
                }

                if (numberInput==5) {
                    System.out.println("Whats your goal?(Options are: looseWeight, gainMuscles, stayHealthy)");
                    String input = scanner.nextLine();
                    if (Utility.isNullOrWhiteSpace(input))
                        throw new NullWhiteSpaceException("Goal cannot be empty");
                    if (input.equals("looseWeight"))
                    {goal = Customer.Goal.looseWeight;
                    numberInput++;}
                    else if (input.equals("gainMuscles"))
                    {goal = Customer.Goal.gainMuscles;
                    numberInput++;}
                    else if (input.equals("stayHealthy"))
                    {goal = Customer.Goal.stayHealthy;
                    numberInput++;}
                    else
                        throw new InvalidGoalException("Invalid goal (must be one of looseWeight, gainMuscles, stayHealthy)");
                }

                if (numberInput==6) {
                    System.out.println("Whats your activity level: ");
                    if (!(scanner.hasNextInt()))
                        throw new WrongInputException("Activity Level must be an integer");
                    int input = scanner.nextInt();
                    if (!(input>0 && input<8))
                        throw new InvalidActivityLevelException("Activity must be between 1 and 7");
                    activityLevel = input;
                    scanner.nextLine();
                    numberInput++;
                }
            } catch (NullWhiteSpaceException e) {
                System.out.println(e.getMessage());
            } catch (NegativeNumberException e) {
                System.out.println(e.getMessage());
            } catch (WrongInputException e) {
                System.out.println(e.getMessage());
            } catch (InvalidGoalException e) {
                System.out.println(e.getMessage());
            } catch (InvalidActivityLevelException e) {
                System.out.println(e.getMessage());
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }

        // ////////////////////

        // Calories Tracker Display
        System.out.println("Calorie Tracker!");
        System.out.print("Enter your daily calorie goal: ");
        int dailyGoal = scanner.nextInt();
        scanner.nextLine();
        CalorieTracker tracker = new CalorieTracker(dailyGoal);

        boolean continueLoop = true;
        while (continueLoop) {
            // Pu the menu out for Calories tracking class
            // Use swuth optuin to display Caloríe Trạcer
            System.out.println("\nChoose an option:");
            System.out.println("1. Add Calories In");
            System.out.println("2. Add Calories Out4");
            System.out.println("3. View Calorie Summary");
            System.out.println("4. Reset Daily Tracking");
            System.out.println("5. Exit");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Enter calories In: ");
                    int consumed = scanner.nextInt();
                    tracker.addCaloriesConsumed(consumed); // Add by call the object add in the tracker class
                    System.out.println("Calories added successfully.");//after that output signal to add success
                    break;
                case 2:
                    System.out.print("Enter calories burned: ");
                    int expended = scanner.nextInt();
                    tracker.addCaloriesExpended(expended);
                    System.out.println("Calories burned added successfully.");
                    break;
                case 3:
                    tracker.displayCalorieSummary();
                    break;
                case 4:
                    tracker.resetDailyTracking();
                    System.out.println("Daily calorie tracking reset.");
                    break;
                case 5:
                    System.out.println("Exiting Calorie Tracker. Stay healthy!");
                    continueLoop = false;
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }

        // //////////////////
        scanner.close();
        Customer customer = new Customer(name, age, gender, height, weight, (int) (Math.random() * 100), goal, activityLevel);
    }
}