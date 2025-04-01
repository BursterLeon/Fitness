package people;
import interfaces.comparableTrainer;
import people.Customer.Goal;
import utils.*;

import java.util.ArrayList;
import java.util.List;

public class Trainer extends Member implements comparableTrainer {
    private String specialization;
    private int experienceYears;
    private List<Integer> ratingList;
    private List<Customer> customerList;
    private static int count = 0;

    public Trainer (String name, int age, String gender, double height, double weight, int id, String specialization, int experienceYears,List<Customer> customerList) {
        super(name, age, gender, height, weight, id);
        count++;
        if (count > 100)
            throw new RuntimeException("More than 100 trainers are not supported");
        if (Utility.isNullOrWhiteSpace(specialization))
            throw new IllegalArgumentException();
        if (experienceYears < 0 || experienceYears > 100)
            throw new IllegalArgumentException();

        this.specialization = specialization;
        this.experienceYears = experienceYears;
        ratingList = new ArrayList<Integer>();

        if (customerList == null || customerList.isEmpty())
            throw new IllegalArgumentException();
        this.customerList = customerList;
    }

    public Trainer (String name, int age, String gender, double height, double weight, int id, String specialization, int experienceYears) {
        super(name, age, gender, height, weight, id);
        count++;
        if (count > 100)
            throw new RuntimeException("More than 100 trainers are not supported");
        if (Utility.isNullOrWhiteSpace(specialization))
            throw new IllegalArgumentException();
        if (experienceYears < 0 || experienceYears > 100)
            throw new IllegalArgumentException();

        this.specialization = specialization;
        this.experienceYears = experienceYears;
        ratingList = new ArrayList<Integer>();
        this.customerList = new ArrayList<Customer>();
    }
    //method could recommend specific food/nutrition, based on the customer and their goal
    
    public void createDietPlan (Customer customer) {
    	double totalCalories = customer.getCaloriesRequired();
    	double proteinCals = 0;
    	double carbsCals = 0;
    	double fatsCals = 0;
    
    	if(customer.getGoal() == Goal.looseWeight) {
    		//For weight loss, recommended macros are 35% calories from proteins, 40% calories from carbs, 25% calories from fats
    		proteinCals = totalCalories * .35;
    		carbsCals = totalCalories * .4;
    		fatsCals = totalCalories * .25;
    	} else if (customer.getGoal() == Goal.gainMuscles) {
    		//For weight/muscle gain, recommended macros are 35% calories from proteins, 35% calories from carbs, 30% calories from fats
    		proteinCals = totalCalories * .35;
    		carbsCals = totalCalories * .35;
    		fatsCals = totalCalories * .3;
    	} else if (customer.getGoal() == Goal.stayHealthy) {
    		//For weight maintenance, recommended macros are 30% calories from proteins, 40% calories from carbs, 30% calories from fats
    		proteinCals = totalCalories * .3;
    		carbsCals = totalCalories * .4;
    		fatsCals = totalCalories * .3;
    	}
    	System.out.println("For the diet breakdown, we reccomend that " + (int)proteinCals + " calories come from protein, " + (int)carbsCals + " calories come from carbohydrates and " + (int)fatsCals + " calories come from healthy fats.");
    }
    
    
    public void startWorkout (List<Customer> customerList) {}

    @Override
    public String getSpecialization() {
        return specialization;
    }

    @Override
    public int getExperienceYears() {
        return experienceYears;
    }

    @Override
    public double getAverageRating() {
        double sum = 0;

        for (int rating : ratingList) {
            sum += rating;
        }
        return sum/ratingList.size();
    }

    @Override
    public String getContactInfo() {
        return getName()+" "+getId();
    }
    @Override
    public String toString() {
        return super.toString()+" Specialization: "+specialization+" Experience Years: "+experienceYears+" AverageRating: "+getAverageRating();
    }
}
