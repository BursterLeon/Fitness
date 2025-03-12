package mainPackage;
import people.Customer;
import java.math.*;

import java.util.*;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.print("Hello and welcome, let us set up your account together.");

        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter your name: ");
        String name = scanner.nextLine();

        System.out.print("Enter your age: ");
        int age = scanner.nextInt();

        System.out.print("Enter your gender: ");
        String gender = scanner.nextLine();

        System.out.print("Enter your height: ");
        double height = scanner.nextDouble();

        System.out.print("Enter your weight: ");
        double weight = scanner.nextDouble();

        System.out.print("Whats your goal: ");
        //Customer.Goal goal = scanner.nextInt();

        System.out.print("Whats your activity level: ");
        int activityLevel = scanner.nextInt();

        Customer customer = new Customer (name, age, gender, height, weight, (int) (Math.random() * 100), Customer.Goal.high, activityLevel);

    }
}