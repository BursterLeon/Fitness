package people;
import interfaces.comparableTrainer;
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
    public void createDietPlan (Customer customer) {}
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
