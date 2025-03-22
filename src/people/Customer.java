package people;
import utils.*;

public class Customer extends Member {
    public enum Goal {looseWeight,gainMuscles,stayHealthy}
    private Goal goal;
    private final int activityLevel;
    private static int customerCount;

    public Goal getGoal() {return goal;}
    public int getActivityLevel() {return activityLevel;}

    public Customer(String name, int age, String gender, double height, double weight, int id, Goal goal, int activityLevel) {
        super(name, age, gender, height, weight, id);
        customerCount++;
        if (customerCount>100)
            throw new RuntimeException("Customer count exceeds 100");
        if (Utility.isNullOrWhiteSpace(goal.toString()))
            throw new IllegalArgumentException("Goal cannot be null or empty");
        if (!(goal==Goal.looseWeight || goal==Goal.gainMuscles || goal==Goal.stayHealthy))
            throw new RuntimeException("Goal must be looseWeight or gainMuscles or stayHealthy");
        this.goal = goal;
        if(!(activityLevel>0 && activityLevel<8))
            throw new RuntimeException("Activity must be between 1 and 7");
        this.activityLevel = activityLevel;
    }

    public double getBMI() {
        return getWeight()/(getHeight()*getHeight());
    }
    public void updateGoal (Goal newGoal) {
        if (newGoal == this.goal)
            throw new RuntimeException("Goal is already set to " + this.goal);
        if (Utility.isNullOrWhiteSpace(newGoal.toString()))
            throw new IllegalArgumentException("Goal cannot be null or empty");
        if (!(newGoal==Goal.looseWeight || newGoal==Goal.gainMuscles || newGoal==Goal.stayHealthy))
            throw new RuntimeException("Goal must be low or medium or high");
        this.goal = newGoal;
    }

    //needs to be implemented
    public double getCaloriesRequired () {
        return 0;
    }
    @Override
    public String toString() {
        return super.toString()+" Goal: "+getGoal()+" ActivityLevel: "+getActivityLevel();
    }
}
