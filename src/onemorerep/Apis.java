package onemorerep;

import java.util.Scanner;

/* All methods for the menu options without sub menu, mainly Input/Output plus Object methods from User object, Food object... */
public class Apis {

	public static void calculateMyBMR(Scanner keyboardIn, User user) {
		user.setName(getUserName(keyboardIn));
		user.setAge(getUserAge(keyboardIn));
		user.setWeight(getUserWeight(keyboardIn));
		user.setHeight(getUserHeight(keyboardIn));
		user.setSex(getUserSex(keyboardIn));

		calculateAndDisplayBMRResult(user);
	}
	
	
	public static void addFoodToFoodLog(Scanner keyboardIn, FoodLog foodLog) {
		String name = getFoodName(keyboardIn);
		int calories = getFoodCalories(keyboardIn);
		
		Food food = new Food(name, calories);
		foodLog.addFood(food);
		food.displayFood();
	}

	private static int getFoodCalories(Scanner keyboardIn) {
		System.out.println("Please enter food calories");
		int calories = keyboardIn.nextInt();
		while(!isPositiveIntInput(calories)) {
			System.out.println("Invalid input! Please enter again!");
			calories = keyboardIn.nextInt();
		}
		return calories;
	}
	
	public static void addExerciseToExerciseLog(Scanner keyboardIn, ExerciseLog exerciseLog, User user) {
		displayExerciseType();
		int exerciseType = getIntInput(keyboardIn, "Please enter exercise type 1~8");
		while(exerciseType < 1 || exerciseType > 8) {
			exerciseType = getIntInput(keyboardIn, "Invalid input! Please enter a number 1~8");
		}
		double duration = getDoubleInput(keyboardIn, "Please enter exercise duration (min)");
		
		Exercises exercise = null;
		switch(exerciseType) {
		case 1:
			exercise = new Bicycling("Bicycling", duration, user);
			break;
		case 2:
			exercise = new JumpingRope("JumpingRope", duration, user);
			break;
		case 3:
			exercise = new Pushups("Pushups", duration, user);
			break;
		case 4:
			exercise = new Running("Running", duration, user);
			break;
		case 5:
			exercise = new Situps("Situps", duration, user);
			break;
		case 6:
			exercise = new Squats("Squats", duration, user);
			break;
		case 7:
			exercise = new Swimming("Swimming", duration, user);
			break;
		default:
			exercise = new Walking("Walking", duration, user);
		}
		exerciseLog.addExercise(exercise);
		exercise.displayExercise();
	}


	private static void displayExerciseType() {
		System.out.println("1. Bicycling");
		System.out.println("2. JumpingRope");
		System.out.println("3. Pushups");
		System.out.println("4. Running");
		System.out.println("5. Situps");
		System.out.println("6. Squats");
		System.out.println("7. Swimming");
		System.out.println("8. Walking");
	}

	
	private static String getStringInput(Scanner keyboardIn, String prompt) {
		System.out.println(prompt);
		String string = keyboardIn.next();
		return string;
	}
	
	private static int getIntInput(Scanner keyboardIn, String prompt) {
		System.out.println(prompt);
		int intNumber = keyboardIn.nextInt();
		return intNumber;
	}
	
	private static double getDoubleInput(Scanner keyboardIn, String prompt) {
		System.out.println(prompt);
		Double doubleNumber = keyboardIn.nextDouble();
		return doubleNumber;
	}


	private static String getFoodName(Scanner keyboardIn) {
		System.out.println("Please enter food name");
		String name = keyboardIn.next();
		return name;
	}
	
	
	private static String getUserName(Scanner keyboardIn) {
		System.out.println("Please enter your name");
		String name = keyboardIn.next();
		System.out.println("Hello, " + name);
		return name;
	}
	
	private static int getUserAge(Scanner keyboardIn) {
		System.out.println("Please enter your age");
		int age = keyboardIn.nextInt();
		while(!isValidAgeInput(age)) {
			System.out.println("Invalid input! Please enter again!");
			age = keyboardIn.nextInt();
		}
		return age;
	}
	
	private static double getUserWeight(Scanner keyboardIn) {
		System.out.println("Please enter your weight (kg)");
		double weight = keyboardIn.nextDouble();
		while(!isPositiveDoubleInput(weight)) {
			System.out.println("Invalid input! Please enter again!");
			weight = keyboardIn.nextDouble();
		}
		return weight;
	}
	
	private static double getUserHeight(Scanner keyboardIn) {
		System.out.println("Please enter your height (cm)");
		double height = keyboardIn.nextDouble();
		while(!isPositiveDoubleInput(height)) {
			System.out.println("Invalid input! Please enter age between 15 and 80 (inclusive)!");
			height = keyboardIn.nextDouble();
		}
		return height;
	}
	
	private static int getUserSex(Scanner keyboardIn) {
		System.out.println("Please enter your sex");
		System.out.println("1. Male");
		System.out.println("2. Female");
		int sex = keyboardIn.nextInt();
		while(!isValidSexInput(sex)) {
			System.out.println("Invalid input! Please enter 1 or 2!");
			sex = keyboardIn.nextInt();
		}
		return sex;
	}
	
	private static void calculateAndDisplayBMRResult(User user) {
		int bmr = user.calculateBMR();
		System.out.println("Your BMR is: " + bmr);
	}
	
	private static boolean isValidAgeInput(int age) {
		return age >= 15 && age <= 80;
	}
	
	private static boolean isValidSexInput(int sex) {
		return sex == 1 || sex == 2;
	}
	
	private static boolean isPositiveIntInput(int value) {
		return value >= 0;
	}
	
	private static boolean isPositiveDoubleInput(double value) {
		return value >= 0;
	}

}
