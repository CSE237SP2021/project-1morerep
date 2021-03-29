package onemorerep;

import java.util.Scanner;

/* All methods for the menu options without sub menu, mainly Input/Output plus Object methods from User object, Food object... */
public class Apis {

	public static void calculateMyBMR(Scanner keyboardIn, User user) {
		String name = getUserName(keyboardIn);
		int age = getUserAge(keyboardIn);
		double weight = getUserWeight(keyboardIn);
		double height = getUserHeight(keyboardIn);
		int sex = getUserSex(keyboardIn);
		
		user = new User(name, age, weight, height, sex);
		calculateAndDisplayBMRResult(user);
	}
	
	
	public static void addFoodToFoodLog(Scanner keyboardIn, FoodLog foodLog) {
		String name = getFoodName(keyboardIn);
		int calories = getFoodCalories(keyboardIn);
		
		Food food = new Food(name, calories);
		foodLog.addFood(food);
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
