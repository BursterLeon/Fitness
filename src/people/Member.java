package people;
import utils.*;

public abstract class Member {
    private String name;
    private int age;
    private String gender;
    private double height;
    private double weight;
    private int id;
    private double bmi;
    private double weightLoss;
    private double dayLoss;

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getGender() {
        return gender;
    }

    public double getHeight() {
        return height;
    }

    public double getWeight() {
        return weight;
    }

    public int getId() {
        return id;
    }

    public double getBmi() {

        if (height != 0) {
            bmi = weight / (height * height) * 1000;  // Calculate BMI
        } else {
            bmi = 0;
        }
        return bmi;
    }

    public double getWeightLoss() {
        return weightLoss;
    }
    //set it so it can calculate abse on input from user
    public void setWeightLoss(double weightLoss) {
        this.weightLoss = weightLoss;
    }
    public double getDayLoss() {
        //Calculate their calories they neeed to burn to achove their goal
        if (weightLoss <= 0) {
            dayLoss = 0;
        } else {
            dayLoss = (weightLoss * 3500) / 7;  // so here base on fact taht it wil cost 3500 cories burrn to loss 1 pound
        }
        return dayLoss;
    }


// Constructor
    public Member (String name, int age, String gender, double height, double weight, int id) {
        if (Utility.isNullOrWhiteSpace(name) || age < 0 || age > 100 || Utility.isNullOrWhiteSpace(gender) || height < 0|| weight < 0 || id < 0)
            throw new IllegalArgumentException();
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.height = height;
        this.weight = weight;
        this.id = id;
    }
    @Override
    public String toString() {
        return "Name: "+getName()+"Age: "+getAge()+"Gender: "+getGender()+"Height: "+getHeight()+"Weight: "+getWeight();
    }
}



