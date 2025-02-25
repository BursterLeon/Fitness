package people;
import utils.*;
import tracker.*;

public class User {
    private String name;
    private int age;
    private String gender;
    private double height;
    private double weight;
    public enum Goal {high,medium,low}
    Goal goal;

    public String getName() {return name;}
    public int getAge() {return age;}
    public String getGender() {return gender;}
    public double getHeight() {return height;}
    public double getWeight() {return weight;}
    public Goal getGoal() {return goal;}

    public User (String name, int age, String gender,double height,double weight, Goal goal){
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.height = height;
        this.weight = weight;
        this.goal = goal;
    }

    public double getBMI() {
        return weight/(height*height);
    }
    public void updateGoal (Goal newGoal) {
        if (newGoal == this.goal)
            throw new RuntimeException("Goal is already set to " + this.goal);
        if (Utility.isNullOrWhiteSpace(goal.toString()))
            throw new IllegalArgumentException("Goal cannot be null or empty");
        if (!(goal==Goal.low || goal==Goal.medium || goal==Goal.high))
            throw new RuntimeException("Goal must be low or medium or high");
        this.goal = newGoal;
    }

    //needs to be implemented
    public double getCaloriesRequired () {
        return 0;
    }
}
