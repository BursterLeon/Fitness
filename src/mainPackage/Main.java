package mainPackage;

import tracker.CalorieTracker;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        // Calories Tracker Display
        System.out.println("Calorie Tracker!");
        System.out.print("Enter your daily calorie goal: ");
        int dailyGoal = scanner.nextInt();
        CalorieTracker tracker = new CalorieTracker(dailyGoal);

        while (true) {
            // Pu the menu out for Calories tracking class
            // Use swuth optuin to display Caloríe Trạcer
            System.out.println("\nChoose an option:");
            System.out.println("1. Add Calories In");
            System.out.println("2. Add Calories Out4");
            System.out.println("3. View Calorie Summary");
            System.out.println("4. Reset Daily Tracking");
            System.out.println("5. Exit");

            int choice = scanner.nextInt();

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
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}
