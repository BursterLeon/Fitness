package mainPackage;
import people.Customer;
import utils.*;
import exceptions.*;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello and welcome, let us set up your account together.");

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
                    System.out.println("Enter your height: ");
                    if (!scanner.hasNextDouble())
                        throw new WrongInputException("Height must be an double");
                    double input = scanner.nextDouble();
                    if (input < 0)
                        throw new NegativeNumberException("Height cannot be negative");
                    height = input;
                    scanner.nextLine();
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
        scanner.close();
        Customer customer = new Customer(name, age, gender, height, weight, (int) (Math.random() * 100), goal, activityLevel);
    }
}