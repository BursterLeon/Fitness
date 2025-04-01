package people;
import utils.*;

public class Customer extends Member {
    public enum Goal {looseWeight,gainMuscles,stayHealthy}
    private Goal goal;
    private final int activityLevel;
    private static int customerCount;

    public Goal getGoal() {return goal;}
    public int getActivityLevel() {return activityLevel;}

    public Customer(String name, int age, String gender, double height, double weight, int id, Goal goal, int activityLevel, boolean usesMetricSystem) {
        super(name, age, gender, height, weight, id, usesMetricSystem);
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

    /** 
     * Commented this method out as I want to use the implementation I defined in the Class Member
     public double getBMI() {
        return getWeight()/(getHeight()*getHeight());
    }
    */
    public void updateGoal (Goal newGoal) {
        if (newGoal == this.goal)
            throw new RuntimeException("Goal is already set to " + this.goal);
        if (Utility.isNullOrWhiteSpace(newGoal.toString()))
            throw new IllegalArgumentException("Goal cannot be null or empty");
        if (!(newGoal==Goal.looseWeight || newGoal==Goal.gainMuscles || newGoal==Goal.stayHealthy))
            throw new RuntimeException("Goal must be low or medium or high");
        this.goal = newGoal;
    }

    
    
    //implemented for EC
    //BMR = Basal Metabolic Rate = Amount of calories a person will burn per day without any activity
    public double getBMR() {
    	//Calculate Based on Metric System or Imperial system
    	double height = this.getHeight(); //Height in ft or m
    	double weight = this.getWeight(); //Weight in kgs or lbs
    	int age = this.getAge();
    	if(!this.getMetricSystem()) {
    		//If it is in imperial system, you should convert their measurements to metric for the formula
    		height *= 30.48; //Conversion for ft --> cm
    		weight /= 2.205; //Conversion for lbs --> kgs
    	} else {
    		height *= 100; //Conversion for m --> cm
    		//Weight is already in kgs, no change needed
    	}
    	double bmr = 0;
    	if (this.getGender().equalsIgnoreCase("Male")) {
			//BMR = 88.362 + (13.397 x weight in kg) + (4.799 x height in cm) - (5.677 x age in years) for males
    		bmr = 88.362 + (13.397 * weight) + (4.799 * height) - (5.677 * age);
		} else {
			//BMR = 447.593 + (9.247 x weight in kg) + (3.098 x height in cm) - (4.330 x age in years) for females
			bmr = 447.593 + (9.247 * weight) + (3.098 * height) - (4.330 * age);
		}
    	return bmr;
    }
    public double getCaloriesRequired () {
    	double baseline = this.getBMR();
    	int lowerLimit;
    	int upperLimit;
        if( goal == Goal.looseWeight) {
        	//A deficit of ~300-500 calories is recommended to lose weight 
        	lowerLimit = (int) baseline - 500;
        	upperLimit = (int) baseline - 300;
        	
        	System.out.println("We reccomend you eat ~" + lowerLimit + "-" + upperLimit + " calories per day to lose weight.");
        	return (lowerLimit + upperLimit)/ 2;
        } else if (goal == Goal.gainMuscles) {
        	//A slight caloric surplus of ~200-300 calories and high protein intake (~.8 g per kilo/.4 g per lbs)  is recommended to gain weight and build muscle
        	lowerLimit = (int) baseline + 200;
        	upperLimit = (int) baseline + 300;
        	double gramsOfProtein = 0;
        	if (this.getMetricSystem()) {
        		gramsOfProtein = this.getWeight() * .8;
        	} else {
        		gramsOfProtein = this.getWeight()* .4;
        	}
        	System.out.println("We reccomend you eat ~" + lowerLimit + "-" + upperLimit + " calories per day with at least " + (int)gramsOfProtein + " grams of protein to gain muscle.");
        	return (lowerLimit + upperLimit)/ 2;
        } else if (goal == Goal.stayHealthy) {
        	//A person should eat at their maintenance calories to stay healthy
        	return baseline;
        } else {
        	System.out.println("Please set a goal. We can't calculate the amount of calories without a goal.");
        	return 0;
        }
        
    }
    @Override
    public String toString() {
        return super.toString()+" Goal: "+getGoal()+" ActivityLevel: "+getActivityLevel();
    }
}
