package interfaces;

public interface comparableTrainer {
    String getName();

    // type of workout the trainer is specialized in
    String getSpecialization();

    int getExperienceYears();

    //user rating of the trainer
    double getAverageRating();

    String getContactInfo();
}
