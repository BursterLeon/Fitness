package mainPackage;

import exceptions.*;
import people.Customer;
import people.Member;
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
                System.out.println("Enter your Name: ");
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
    private int getValidInt() {
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
                System.out.println("Enter your age: ");
                int age = getValidInt();
                scanner.nextLine();

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
                System.out.println("Enter your Gender (Male/Female): ");
                String gender = scanner.nextLine().trim();


                if (gender.isEmpty()) {
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

    // Handling the users input for Height
    public double getHeight(boolean metricSystem) {
        while (true) {
            try {
            	if (metricSystem) {
            		System.out.println("Enter your height in meters. (e.g. 1.7 = 1.7 meters)");
            		  
            	} else {
            		System.out.println("Enter your height in feet. (e.g. 5.6 = 5.6 ft)");
            	}
            	
            	String height = scanner.nextLine().trim().toLowerCase();
            	
                /**  Old code I am replacing
                // Checking if the height is in Centimeters
                if (height.endsWith("cm")) {
                    // converting the string to integer and removing the "cm" string at the end
                    String heightStr = height.replace("cm", "").trim();
                    
                    
                    // Using regex to ensure only integers are accepted
                    if (!height.matches("\\d+")) {
                        throw new NumberFormatException("Invalid format, please try again");
                    }
                    */

                    
                    
                    // Using regex to ensure only double or whole number are accepted
                    if (!height.matches("\\d+(\\.\\d+)?")) {
                        throw new NumberFormatException("Invalid format, please try again");
                    }
                    
                    if(metricSystem) {
                    	double heightCM = Double.parseDouble(height) * 100;
                    	if (heightCM < 50 || heightCM > 300) {
                    		throw new IllegalArgumentException("Quit messing around and enter a valid height!");
                    	}
                    }  else {
                    	double heightFT = Double.parseDouble(height);
                        if (heightFT < 2.0 || heightFT > 8.0) {
                            throw new IllegalArgumentException("Quit messing around and enter a valid height!");
                        }
                    }

                    return Double.parseDouble(height);
                
                /** Previous code I am replaceing.
                // If the user inputs a double value in feet
                else if (height.endsWith("ft")) {
                    String heightStr = height.replace("ft", "").trim();
				*/
              
            } catch (NumberFormatException e) {
                System.out.println("Invalid format. Please enter a valid height.");
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    // Function to handle valid input for double weight

    public double getValidDouble() {
        while (true) {
            try {
                if (!scanner.hasNextDouble()) {
                    throw new WrongInputException("Input Must be double");
                }
                double value = scanner.nextDouble();
                scanner.nextLine();
                return value;
            } catch (WrongInputException e) {
                System.out.println(e.getMessage());
                scanner.nextLine();


            }
        }
    }

    public double getWeight(boolean metricSystem) {
        while (true) {
            try {
            	if(metricSystem) {
            		System.out.println("Please enter your weight in kilos (eg. 64.7 = 64.7 kgs)");
            	} else {
            		System.out.println("Please enter your weight in pounds (eg. 167.4 = 167.4 lbs)");
            	}
                
                double weight = getValidDouble();
                if (weight < 0 || weight > 300 ) {
                    throw new Exception("Invalid input!! ");
                }
                return weight;

            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public int GetActivityLevel(){
        while(true){
            try{
                System.out.println("Enter your Activity Level From (1-7): ");
                int activityLevel = getValidInt();
                if (activityLevel < 1 || activityLevel > 7 ){
                    throw new InvalidActivityLevelException("Invalid Activity Level. The activity Level should be between (1 -7) ");
                }
                return activityLevel;

            }catch(InvalidActivityLevelException e){
                System.out.println(e.getMessage());
            }
        }
    }
    // Get inputs

    // Function for the Goal
    public Customer.Goal getGoal() {
        while (true) {
            try {
                System.out.println("What's your goal? \n 1. Type '1' to Lose Weight \n 2. Type '2' to Gain Muscle \n 3. Type '3' to Maintain Fitness");
                String goalInput = scanner.nextLine().trim();
                if (Utility.isNullOrWhiteSpace(goalInput)) {
                    throw new NullWhiteSpaceException("The goal cannot be blank");
                }
                switch (goalInput) {
                    case "1":
                        return Customer.Goal.looseWeight;
                    case "2":
                        return Customer.Goal.gainMuscles;

                    case "3":
                        return Customer.Goal.stayHealthy;
                    default:
                        throw new InvalidGoalException("Invalid Goal");
                }


            } catch (NullWhiteSpaceException | InvalidGoalException e) {
                System.out.println(e.getMessage());
            }
        }
    }
    
    
    //new method to see if user wants to proceed in the metric system 
    public boolean usesMetricSystem() {
    	while(true) {
    		try {
    			System.out.println("Would you like to enter the system in the metric system (kilos & meters)? Or the imperial system (pounds and feet)? Enter 1: Metric, Enter 2: Imperial):");
    			String input  = scanner.nextLine().trim();
    		
    			if (Utility.isNullOrWhiteSpace(input)) {
    				throw new NullWhiteSpaceException("The goal cannot be blank");
    			}
    			
    			if (Integer.parseInt(input) > 2 || Integer.parseInt(input) < 1) {
    				throw new NumberFormatException();
    			}
    			if (Integer.parseInt(input) == 1) {
    				System.out.println("Understood, values will be in the metric system.");
    				return true;
    			} else {
    				System.out.println("Understood, values will be in the imperial system.");
    				return false;
    			}
    			
    		} catch (NullWhiteSpaceException e) {
    			System.out.println(e.getMessage());
    		} catch(NumberFormatException e) {
    			System.out.println("Please enter integer values 1 or 2");
    		}
    	}
    }

    // Function for the Activity Level

}
