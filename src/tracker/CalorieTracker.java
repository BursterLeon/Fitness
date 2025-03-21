package tracker;

public class CalorieTracker {
    private int dailyCalorieGoal;
    private int caloriesConsumed;
    private int caloriesExpended;

    // Create constructi
    public CalorieTracker(int dailyCalorieGoal, int caloriesConsumed, int caloriesExpended) {
        this.dailyCalorieGoal = dailyCalorieGoal;
        this.caloriesConsumed = caloriesConsumed;
        this.caloriesExpended = caloriesExpended;
    }
    public int getDailyCalorieGoal() {
        return dailyCalorieGoal;
    }//Get

    public int getCaloriesConsumed() {
        return caloriesConsumed;
    }

    public int getCaloriesExpended() {
        return caloriesExpended;
    }


    //Setter
    public void setDailyCalorieGoal(int dailyCalorieGoal) {
        if (dailyCalorieGoal < 0) {
            throw new IllegalArgumentException("Error, You calories can no negaticce please try again.");
        }
        this.dailyCalorieGoal = dailyCalorieGoal;
    }

    // Frmular calculate Caloríe consumm
    // Caloríe cosume use method Add up
    // Calculate total calories my fỏmula Calories = dailyCalorieGoal−(caloriesConsumed−caloriesExpended)
    public void addCaloriesConsumed(int calories) {
        if (calories < 0) {
            throw new IllegalArgumentException("Calories consumed cannot be negative.");
        }
        this.caloriesConsumed += calories;
    }

    // Method to add expended calories
    public void addCaloriesExpended(int calories) {
        if (calories < 0) {
            throw new IllegalArgumentException("Calories expended cannot be negative.");
        }
        this.caloriesExpended += calories;
    }

    // Method to get remaining calories that use the total colories by Take the goal minus all the calories exapnd
    public int getRemainingCalories() {
        return dailyCalorieGoal - (caloriesConsumed - caloriesExpended);
    }

    public Double getCaloriesGoalPercenatge(){

        double percentage = ((double) caloriesConsumed / (double) dailyCalorieGoal ) *100;
        return percentage;
    }

    // Reset daily calorie count so all of the consue and expand back to -
    public void resetDailyTracking() {
        this.caloriesConsumed = 0;
        this.caloriesExpended = 0;
    }

    // Display  Tracker
    public void displayCalorieSummary() {
        System.out.println("Daily Calorie Goal: " + dailyCalorieGoal);
        System.out.println("Calories Consumed: " + caloriesConsumed);
        System.out.println("Calories Expended: " + caloriesExpended);
        System.out.println("Remaining Calories: " + getRemainingCalories());
        System.out.println ("Your Progess today:" +getCaloriesGoalPercenatge() +"%");
    }
}
