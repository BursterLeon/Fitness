package tracker;
import java.util.ArrayList;
import java.util.Scanner;
import exceptions.*;
import utils.*;


public class Workout extends Exercise {
    private String name;
    private String targetMuscleGroup;
    private double caloriesBurnedPerMinute;
    // private ArrayList<String> exercises = new ArrayList();
    private ArrayList<Exercise> exercises = new ArrayList();

    // Initializing Workout object
    public Workout(String name, String targetMuscleGroup, double caloriesBurnedPerMinute,
    ArrayList<Exercise> exercises) {
        super(name, targetMuscleGroup, caloriesBurnedPerMinute);
        this.exercises = exercises;
    }


    // Getters
    public String getName() {
        return name;
    }

    public String getTargetMuscleGroup() {
        return targetMuscleGroup;
    }

    public double caloriesBurnedPerMin() {
        return caloriesBurnedPerMinute;
    }

    public ArrayList<Exercise> getExercises() {
        return new ArrayList<>(exercises);
    }

    

    public void startWorkout() {
        Scanner scanner = new Scanner(System.in);

        boolean flag = true;

        Exercise [] coreExerciseList = {
            new Exercise("Plank", "Core", 4.0),
            new Exercise("Bicycle Crunches", "Core", 9.0),
            new Exercise("Russian Twists", "Core", 7.0),
            new Exercise("Leg Raises", "Core", 5.0),
            new Exercise("Dead Bug", "Core", 5.0),
            new Exercise("Mountain Climbers", "Core", 10.0),
            new Exercise("Hollow Body Hold", "Core", 6.0)
        };

        Exercise [] cardioExerciseList = {
            new Exercise("Walking", "Cardio", 5.0),
            new Exercise("Running", "Core", 11.0),
            new Exercise("Cycling", "Core", 10.0),
            new Exercise("Jump Rope", "Core", 12.0)
        };


        System.out.println("Welcome to Workout!");
        System.out.println();
        
        while(flag == true) {

        try {
            System.out.println("Choose an option (1-6):");
            System.out.println("1. Core");
            System.out.println("2. Cardio");
            System.out.println("3. See workout list");
            System.out.println("4. Remove exercise");
            System.out.println("5. Calculate calories burned");
            System.out.println("6. Exit");
            System.out.print("Your choice: ");

            if(!scanner.hasNextInt()) {
            scanner.next();
            throw new WrongInputException("Input must be an integer");
            }

            int userChoice = scanner.nextInt();
            scanner.nextLine();

            switch(userChoice) {
                case 1: 
                    System.out.println("-------------------------------");
                    System.out.println("Choose a core exercise (1-8):");
                    for (int i = 0; i < coreExerciseList.length; i++) {
                        System.out.println((i + 1) + ". " + coreExerciseList[i].getName());
                    }
                    System.out.println((coreExerciseList.length + 1) + ". Cancel");
                    System.out.print("Your exercise: ");
                    
                    
                    if (!scanner.hasNextInt()) {
                        scanner.next();
                        throw new WrongInputException("Input must be an integer value.");
                    }

                    int userCoreChoice = scanner.nextInt();
                    scanner.nextLine();

                    if(userCoreChoice > 0 && userCoreChoice <= coreExerciseList.length) {
                        Exercise exercise = coreExerciseList[userCoreChoice  -1];
                        if(!exercises.contains(exercise)) {
                            exercises.add(exercise);
                            System.out.println(exercise.getName() + " has been added to your workout.");
                            System.out.println("-------------------------------");
                        } else {
                            System.out.println(exercise.getName() + " has already been added to your workout.");
                            System.out.println("-------------------------------");
                        }
                    } else if(userCoreChoice == coreExerciseList.length + 1) {
                        System.out.println("-------------------------------");
                        break;
                    } else {
                        throw new NegativeNumberException("Input cannot be negative.");
                    }
                    break;
                case 2:
                    System.out.println("-------------------------------");
                    System.out.println("Choose a cardio exercise (1-5):");
                    for (int i = 0; i < cardioExerciseList.length; i++) {
                        System.out.println((i + 1) + ". " + cardioExerciseList[i].getName());
                    }
                    System.out.println((cardioExerciseList.length + 1) + ". Cancel");
                    System.out.print("Your exercise: ");


                    if (!scanner.hasNextInt()) {
                        scanner.next();
                        throw new WrongInputException("Input must be an integer value.");
                    }

                    int userCardioChoice = scanner.nextInt();
                    scanner.nextLine();
                    

                    if(userCardioChoice > 0 && userCardioChoice <= cardioExerciseList.length) {
                        Exercise exercise = cardioExerciseList[userCardioChoice - 1];
                        if(!exercises.contains(exercise)) {
                            exercises.add(exercise);
                            System.out.println(exercise.getName() + " has been added to your workout.");
                            System.out.println("-------------------------------");
                        } else {
                            System.out.println(exercise.getName() + " has already been added to your workout.");
                            System.out.println("-------------------------------");
                        }
                    } else if(userCardioChoice == cardioExerciseList.length + 1) {
                        System.out.println("-------------------------------");
                        break;
                    } else {
                        System.out.println("Invalid input.  Try again.");
                    }
                    break;
                case 3:
                    if(exercises.isEmpty()) {
                        System.out.println("There are no exercises in your workout yet.");
                        System.out.println("-------------------------------");
                    } else {
                        System.out.println("Your workout exercises:");
                        for(Exercise exercise: exercises) {
                            System.out.println(exercise.getName());
                        }
                        System.out.println("-------------------------------");
                    }
                    break;
                case 4:
                    if(exercises.isEmpty()) {
                        System.out.println("There are no exercises in your workout yet.");
                        System.out.println("-------------------------------");
                    } else {
                        System.out.println("Which exercise do you want to remove from your workout?");
                        for(Exercise exercise: exercises) {
                            System.out.println(exercise.getName());
                        }

                        System.out.print("Enter the exercise name to remove: ");
                        
                        String selectedExercise = scanner.nextLine();
                
                        Exercise exerciseFound = null;
                        for(Exercise exercise: exercises) {
                            if(exercise.getName().equalsIgnoreCase(selectedExercise)) {
                                exerciseFound = exercise;
                                break;
                            }
                        }

                        if (exerciseFound != null) {
                            exercises.remove(exerciseFound);
                            System.out.println(exerciseFound.getName() + " has been removed from your workout.");
                            System.out.println("-------------------------------");
                        } else {
                            System.out.println("The exercise you've entered is not found in your workout.");
                            System.out.println("-------------------------------");
                        }
                    }
                    break;
                case 5:
                    if(exercises.isEmpty()) {
                        System.out.println("There are no exercises in your workout yet.");
                        System.out.println("-------------------------------");
                    } else {
                        System.out.println("Enter the duration of your workout in minutes:");

                        if(!scanner.hasNextDouble()) {
                            throw new WrongInputException("Input must be a double value.");
                        }

                        double userDuration = scanner.nextDouble();
                        scanner.nextLine();

                        

                        double totalCalories = 0.0;
                        for(Exercise exercise: exercises) {
                            totalCalories += calculateCaloriesBurned(exercise.getCaloriesBurnedPerMinute(), userDuration);
                        }

                        System.out.println("Total calories burned: " + totalCalories);
                        System.out.println("-------------------------------");

                    }
                    break;
                case 6:
                    System.out.println("-------------------------------");
                    System.out.println("Exiting Workout.");
                    System.out.println("-------------------------------");
                    flag = false;
                    scanner.close();
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
                    System.out.println("-------------------------------");
            } 

        } catch(NegativeNumberException e) {
            System.out.println(e.getMessage());
        } catch(WrongInputException e) {
            System.out.println(e.getMessage());
        } catch(Exception e) {
            System.out.println(e.getMessage());
        }
    
        }
    
        
        
    }

    public void addExercise(Exercise exercise) {
        exercises.add(exercise);
    }

    public void removeExercise(Exercise exercise) {
        exercises.remove(exercise);
    }

    public double calculateCaloriesBurned(double caloriesBurnedPerMinute, double duration) {
        return caloriesBurnedPerMinute * duration;
    }

    // @Override
    // public int calculate() {
    //     return 0;
    // }

    // @Override
    // public double getResult() {
    //     return 0.0;
    // }

}

