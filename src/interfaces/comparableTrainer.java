package interfaces;

public interface comparableTrainer {
    String getName();

    // Get the trainer's specialization (e.g., weightlifting, yoga, HIIT)
    String getSpecialization();

    // Get the trainer's years of experience
    int getExperienceYears();

    // Get the trainer's average user rating (1 to 5 stars)
    double getAverageRating();

    // Additional methods like contact details, availability, etc.
    String getContactInfo();
}
