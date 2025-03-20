package mainPackage;

import utils.Utility;

import java.util.Scanner;
import java.util.InputMismatchException;

public class UserInputHandler {
    private Scanner scanner;

    public UserInputHandler(Scanner scanner) {
        this.scanner = scanner;
    }

    public String getName() {
        while (true) {
            try {
                System.out.print("Enter your Name: ");
                String name = scanner.nextLine().trim();

                // Checking if the input for the name is left blank
                if (Utility.isNullOrWhiteSpace(name)) {
                    throw new Exception("Name cannot be blank");
                }
                if (!name.matches("^[a-zA-Z ]+$")) {
                    throw new Exception("Name can only contain letters and spaces");
                }
                return name;
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }

        }
    }

    // Function For handling the correct input for User's Age
    public int getValidInt() {
        while (!scanner.hasNextInt()) {
            System.out.println("Invalid input! Please enter a valid Integer ");
            scanner.next();
        }
        return scanner.nextInt();
    }

    // Handling more exception cases for User's Age
    public int getAge() {
        while (true) {
            try {
                System.out.print("Enter your age: ");
                int age = getValidInt();
                if (age < 0) {
                    throw new IllegalArgumentException("Age Cannot be negative");
                }
                if (age > 100) {
                    throw new IllegalArgumentException("You cannot workout in this Age! Take Rest");
                }
                return age;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());

            }
        }
    }

    // Getting input for User's Gender

    public String getGender() {
        while (true) {
            try {
                System.out.print("Enter your Gender (Male/Female): ");
                String gender = scanner.nextLine().trim();
                if (Utility.isNullOrWhiteSpace(gender)) {
                    throw new Exception("Gender Cannot be empty!");
                }
                // Constraining Gender to Male or Female
                if (!(gender.equalsIgnoreCase("Male") || gender.equalsIgnoreCase("Female"))) {
                    throw new Exception("Must be Male Or Female");
                }
                return gender;
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public double getHeight() {
        while (true) {
            try {
                System.out.print("Enter your Height (e.g., '175 cm' or '4.9 ft'): ");
                String height = scanner.nextLine().trim().toLowerCase();

                // Checking if the height is in Centimeters
                if (height.endsWith("cm")) {
                    // converting the string to integer and removing the "cm" string at the end
                    String heightStr = height.replace("cm", "").trim();

                    // Using regex to ensure only integers are accepted
                    if (!heightStr.matches("\\d+")) {
                        throw new NumberFormatException("Invalid format, please try again");
                    }

                    int heightCM = Integer.parseInt(heightStr);
                    if (heightCM < 50 || heightCM > 300) {
                        throw new IllegalArgumentException("Quit messing around and enter a valid height!");
                    }

                    return heightCM; // return as integer in centimeters
                }

                // If the user inputs a double value in feet
                else if (height.endsWith("ft")) {
                    String heightStr = height.replace("ft", "").trim();

                    // Using regex to ensure only double or whole number are accepted
                    if (!heightStr.matches("\\d+(\\.\\d+)?")) {
                        throw new NumberFormatException("Invalid format, please try again");
                    }

                    double heightFT = Double.parseDouble(heightStr);
                    if (heightFT < 2.0 || heightFT > 8.0) {
                        throw new IllegalArgumentException("Quit messing around and enter a valid height!");
                    }

                    // Converting the height to Centimeters
                    return heightFT * 30.48; // return as double in centimeters
                }

                // For invalid input
                else {
                    throw new IllegalArgumentException("Invalid format! Use '175 cm' or '4.9 ft'");
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid format. Please enter a valid height.");
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }


}
