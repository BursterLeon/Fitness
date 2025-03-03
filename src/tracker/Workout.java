package tracker;
import java.util.ArrayList;

public class Workout {
    private String name;
    private double duration;
    private List<Exercise> exercises = new ArrayList();

    public void startWorkout() {
        
    }

    public void addExercise(Exercise exercise) {
        exercises.add(exercise);
    }

    public void removeExercise(Exercise exercise) {
        exercises.remove(exercise);
    }



}

