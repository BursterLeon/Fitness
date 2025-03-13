package tracker;
import utils.*;
public class exercise {
    private String name;
    private String targetMuscleGroup;
    private int caloriesBurnedPerMinute;

    // Constructor
    public exercise(String name, String targetMuscleGroup, int caloriesBurnedPerMinute) {
        if (Utility.isNullOrWhiteSpace(name)) {
            throw new IllegalArgumentException("Name cannot be null or whitespace");

        }

        this.name = name;

        if (Utility.isNullOrWhiteSpace(targetMuscleGroup)) {
            throw new IllegalArgumentException("Name cannot be null or whitespace");

        }
        this.targetMuscleGroup = targetMuscleGroup;

        if (caloriesBurnedPerMinute < 0) {
            throw new IllegalArgumentException("Name cannot smaller than 0");

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

    public int getCaloriesBurnedPerMinute() {
        return caloriesBurnedPerMinute;
    }

    // Method to calculate calories burned in thí We calculate the caloried base on duration
    public int performExercise(int duration) {
        return caloriesBurnedPerMinute * duration;
    }

    // Method to display exercise details
    public void displayExerciseInfo() {
        System.out.println("Exercise: " + name);
        System.out.println("Target Muscle Group: " + targetMuscleGroup);
        System.out.println("Calories Burned Per Minute: " + caloriesBurnedPerMinute);
    }
}

