**Project Name: Fitness Tracker Application**

**Overview**

The Fitness Tracker App is a simple application designed to help users set health goals, calculate their calories, and keep track of their workout progress. Users can create an account, set their fitness goals,
 track how much calories they consume and burn, and perform various exercises to achieve their goals in a user-friendly interface.

**Design**

The project consists of several classes to function properly and take care of different parts of the system:

**1. Main Class:** Manages user interaction, helps user create their account, and gives them the option to track their calorie goals or start their workout.

**2. Trainer Class:** Represents a fitness trainer.  The trainers individually specialize in a specific goal such as losing weight or gaining muscle.  These could include exercises
such as cardio or strength training.

**3. Customer Class:** Represents the user of the app.  Stores the users' personal information and fitness goals.

**4. UserInputHandler Class:** Handles user input.  Prompts user to provide their personal information including their name, age, gender, height, weight, activity level, and fitness goal.

**5. CaloriesInputHandler Class:** Handles user input for calories consumed and burned during workouts.

**6. CalorieTracker Class:** Keeps track of calories consumed, burned, and logs the user's overall progress in achieving their fitness goal.

**7. Exercise Class:** Represents an exercise and stores information which consists of the name, target muscle group, and calories burned per minute.

**8. Workout Class:** Manages the list of exercises executed in a workout and calculates the calories burned during the workout.

**Installation Instructions**

To build and run the Fitness App locally:

**1. Clone the repository:**

git clone https://github.com/BursterLeon/Fitness.git

cd Fitness

**2. Make sure you have Java installed:**

The app requires Java 8 or above. You can check if you have Java installed by running:

java -version

If you don't have Java installed, you can download it from Oracle's official website.

**3. Compile and run the project:**

You can compile the project using javac and run it using java. Navigate to the project directory and run:

javac Main.java

java Main

**Usage**

**1. Account Creation:** 

The first step in using the app is to create an account. You will be prompted to provide your name, age, gender, height, weight, and activity level.

Example:

Enter your Name: John

Enter your age: 35

Enter your Gender (Male/Female): Male

Enter your Height (e.g., '175 cm' or '4.9 ft): 175cm

Please enter your weight in Pound (eg. 143.4 ) : 165

Enter your Activity Level From (1-7): 5

**2. Set a Goal:** 

After creating your account, you will set a fitness goal, such as losing weight or gaining muscle. The system will prompt you to specify how much weight you want to lose or gain.

**3. Navigating the Main Menu:**

Example:

1. Track your Calories

2. Workout

3. Exit

**4. Track Calories:** 

You can choose to track your calories. The app will require you to enter how many calories you’ve consumed and how many you've burned during exercise.

Example:

Please enter the calories, you are consuming per day?: 400

Please enter the calories, you are burning per day? 250

**5. Workout:** 

You can log a workout by specifying the exercise name, target muscle group, and calories burned per minute. The app will calculate the calories burned based on the duration of the exercise.

Example: 

Welcome to Workout!

Choose an option (1-6):
1. Core
2. Cardio
3. See workout list
4. Remove exercise
5. Calculate calories burned
6. Exit

Your choice: 3

**6. Exit:** 

You can exit the app at any time by selecting the "Exit" option in the main menu from step 3 above. 

**Contributions**

**Leon Burster:**
- Designed and implemented the **people** (Customer, Member, Trainer classes) and exceptions packages.

**Bao Truong:**
- Developed the **CalorieTracker** and **Exercise** class and helped in **handling user input** in the main package (UserInputHandler, CaloriesInputHandler).

**Aydan Kaneshiro:**
- Redesigned the **Exercise** class and integrated it with the **Workout** class, and implemented the **interfaces** (Trackable, Calculable).

**Mohd Ifranul Hoque:**
- Improved the **core functionality** and **handled user input** in the main package (UserInputHandler, CaloriesInputHandler, fitnessPlan). 

