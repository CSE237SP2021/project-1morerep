package onemorerep;

import java.util.Scanner;

public class Menu {

	private Scanner keyboardIn;
	private User user;
	private FoodLog foodLog;
	
	public Menu() {
		keyboardIn = new Scanner(System.in);
		foodLog = new FoodLog();
	}
	
	private void displayMainMenu() {
		System.out.println("Welcome to 1MoreRep!");
		
		System.out.println("Please select an option:");
		System.out.println("1. Beginning of the day");
		System.out.println("2. End of the day");
		System.out.println("3. Quit");
	}
	
	/*
	 * Processing options from Main Menu
	 */
	private void processMainMenu(int selectedOption) {
		if(selectedOption == 1) {
			processBeginningOfTheDayMenu();
		} else if(selectedOption == 2){
			// Go to calculate Calories for the day
			processEndOfTheDayMenu();
		}
	}
	
	/*
	 * Processing Beginning of the Day Menu
	 * */
	private void processBeginningOfTheDayMenu() {
		// Go to create a user and calculate BMR
		displayBeginningOfTheDayMenu();
		int selectedBeginningOfTheDayMenuOption = keyboardIn.nextInt();
		while(selectedBeginningOfTheDayMenuOption != 2) {
			calulcateMyBMR();
			displayBeginningOfTheDayMenu();
			selectedBeginningOfTheDayMenuOption = keyboardIn.nextInt();
		}
	}

	private void calulcateMyBMR() {
		String name = getUserName();
		int age = getUserAge();
		double weight = getUserWeight();
		double height = getUserHeight();
		int sex = getUserSex();
		
		user = new User(name, age, weight, height, sex);
		calculateAndDisplayBMRResult();
	}

	private void displayBeginningOfTheDayMenu() {
		System.out.println("Good Morning!");
		System.out.println("1. Calculate my BMR");
		System.out.println("2. Back");
	}
	
	/*
	 * Processing End of the Day Menu
	 * */
	private void processEndOfTheDayMenu() {
		displayEndOfTheDayMenu();
		
		int selectedEndOfTheDayMenuOption = keyboardIn.nextInt();
		while(selectedEndOfTheDayMenuOption != 4) {
			if(selectedEndOfTheDayMenuOption == 1) {
				processFoodLogMenu();
			} else if(selectedEndOfTheDayMenuOption == 2) {
				System.out.println("Track your workout now!");
				//TO DO !!!
			} else {
				System.out.println("View your summary of the day!");
				//TO DO !!!
			}
			displayEndOfTheDayMenu();
			selectedEndOfTheDayMenuOption = keyboardIn.nextInt();
		}
		
	}

	/*
	 * Processing Food Log Menu
	 * */
	private void processFoodLogMenu() {
		displayFoodLogMenu();
		int selectedFoodLogMenuOption = keyboardIn.nextInt();
		while(selectedFoodLogMenuOption != 3) {
			if(selectedFoodLogMenuOption == 1) {
				addFoodToFoodLog();
			} else if(selectedFoodLogMenuOption == 2) {
				foodLog.displayFoodLog();
			}
			displayFoodLogMenu();
			selectedFoodLogMenuOption = keyboardIn.nextInt();
		}
	}

	private void addFoodToFoodLog() {
		System.out.println("Please enter food name");
		String name = keyboardIn.next();
		System.out.println("Please enter food calories");
		int calories = keyboardIn.nextInt();
		Food food = new Food(name, calories);
		foodLog.addFood(food);
	}

	private void displayFoodLogMenu() {
		System.out.println("Track your food intake now!");
		System.out.println("1. Enter a food");
		System.out.println("2. View food log summary");
		System.out.println("3. Back");
	}

	private void displayEndOfTheDayMenu() {
		System.out.println("Good evening!");
		System.out.println("1. Calculate calories taken from food");
		System.out.println("2. Calculate calories burned from workout");
		System.out.println("3. Summary of the day");
		System.out.println("4. Back");
	}
	
	
	private void calculateAndDisplayBMRResult() {
		int bmr = user.calculateBMR();
		System.out.println("Your BMR is: " + bmr);
	}
	
	
	/*
	 * Getting appropriate user input
	 */
	private int getUserStartOrEndOfDayOption() {
		return keyboardIn.nextInt();
	}
	
	private String getUserName() {
		System.out.println("Please enter your name");
		String name = keyboardIn.next();
		System.out.println("Hello, " + name);
		return name;
	}
	
	private int getUserAge() {
		System.out.println("Please enter your age");
		return keyboardIn.nextInt();
	}
	
	private double getUserWeight() {
		System.out.println("Please enter your weight (kg)");
		return keyboardIn.nextDouble();
	}
	
	private double getUserHeight() {
		System.out.println("Please enter your height (cm)");
		return keyboardIn.nextDouble();
	}
	
	private int getUserSex() {
		System.out.println("Please enter your sex");
		System.out.println("1. Male");
		System.out.println("2. Female");
		return keyboardIn.nextInt();
	}
	
	/*
	 * Validation methods
	 */
	public boolean isValidAgeInput(int age) {
		return age >= 15 && age <= 80;
	}
	
	public boolean isValidSexInput(int sex) {
		return sex == 1 || sex == 2;
	}
	
	
	
	public void runMenu() {
		this.displayMainMenu();
		
		int selectedOption = this.getUserStartOrEndOfDayOption();
		
		while(selectedOption != 3) {
			this.processMainMenu(selectedOption);
			this.displayMainMenu();
			selectedOption = this.getUserStartOrEndOfDayOption();
		}
		
		this.keyboardIn.close();
	}
	
	
	public static void main(String[] args) {
		Menu oneMoreRepMenu = new Menu();
		oneMoreRepMenu.runMenu();
	}

}
