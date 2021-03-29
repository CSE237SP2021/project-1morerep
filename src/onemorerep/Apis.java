package onemorerep;

import java.util.Scanner;

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
		return keyboardIn.nextInt();
	}
	
	private static double getUserWeight(Scanner keyboardIn) {
		System.out.println("Please enter your weight (kg)");
		return keyboardIn.nextDouble();
	}
	
	private static double getUserHeight(Scanner keyboardIn) {
		System.out.println("Please enter your height (cm)");
		return keyboardIn.nextDouble();
	}
	
	private static int getUserSex(Scanner keyboardIn) {
		System.out.println("Please enter your sex");
		System.out.println("1. Male");
		System.out.println("2. Female");
		return keyboardIn.nextInt();
	}
	
	private static void calculateAndDisplayBMRResult(User user) {
		int bmr = user.calculateBMR();
		System.out.println("Your BMR is: " + bmr);
	}
	
	private boolean isValidAgeInput(int age) {
		return age >= 15 && age <= 80;
	}
	
	private boolean isValidSexInput(int sex) {
		return sex == 1 || sex == 2;
	}

}
