package mainPackage;

public class FitnessPlan {

    public static String GetMuscle(double weight, int activityLevel, boolean metric){
    	if (metric) {
    		weight *= 2.2;
    	}
        double protein = weight * 1.0;
        double carbs = weight * 1.5;
        double fats = weight * 0.4;
        int calories = (int) ((weight* 16) + (activityLevel * 100));


        return  "\n Muscle Gain Plan \n" +
                " \n Calories Intake : " + calories +
                " \n Protein: "+  protein +
                " \n Carbs: "+ carbs +
                " \n Fats: " + fats;
    }

    public static String GetFitness(double weight, int activityLevel,boolean metric){
    	if (metric) {
    		weight *= 2.2;
    	}
        double protein = weight * 0.8;
        double carbs = weight * 1.2;
        double fats = weight * 0.3;
        int calories = (int)((weight* 14) + (activityLevel * 100));

        return "\n Fitness Maintance plan"+
                " \n Calories Intake: " + calories+
                " \n Carbs: " + carbs+
                " \n Fats: " + fats;
    }
}
