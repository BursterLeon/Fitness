package tracker;
import utils.*;
public class Exercise {
    private String name;
    private String targetMuscleGroup;
    private double caloriesBurnedPerMinute;


    // Constructor
    public Exercise(String name, String targetMuscleGroup, double caloriesBurnedPerMinute) {
        if (Utility.isNullOrWhiteSpace(name)) {
            throw new IllegalArgumentException("Name cannot be null or whitespace");


        }


        this.name = name;


        if (Utility.isNullOrWhiteSpace(targetMuscleGroup)) {
            throw new IllegalArgumentException("Name cannot be null or whitespace");


        }
        this.targetMuscleGroup = targetMuscleGroup;


        if (caloriesBurnedPerMinute < 0) {
            throw new IllegalArgumentException("Name cannot be smaller than 0");


        }
        this.caloriesBurnedPerMinute = caloriesBurnedPerMinute;
    }


    // Exception validate
    // Getters
    public String getName() {
        return name;
    }


    public String getTargetMuscleGroup() {
        return targetMuscleGroup;
    }


    public double getCaloriesBurnedPerMinute() {
        return caloriesBurnedPerMinute;
    }


    // Method to calculate calories burned in thí We calculate the caloried base on duration
    public double performExercise(double duration) {
        return caloriesBurnedPerMinute * duration;
    }


    // Method to display exercise details
    public void displayExerciseInfo() {
        System.out.println("Exercise: " + name);
        System.out.println("Target Muscle Group: " + targetMuscleGroup);
        System.out.println("Calories Burned Per Minute: " + caloriesBurnedPerMinute);
    }
}
