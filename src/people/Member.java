package people;
import utils.*;

public abstract class Member {
    private String name;
    private int age;
    private String gender;
    private double height;
    private double weight;
    private int id;

    public String getName() {return name;}
    public int getAge() {return age;}
    public String getGender() {return gender;}
    public double getHeight() {return height;}
    public double getWeight() {return weight;}
    public int getId() {return id;}

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
