package onemorerep;

import java.util.Scanner;

public class Menu {

	private Scanner keyboardIn;
	
	public Menu() {
		keyboardIn = new Scanner(System.in);
	}
	
	private void displayMainMenu() {
		System.out.println("Welcome to 1MoreRep!");
		
		System.out.println("Please select an option:");
		System.out.println("1. Beginning of the day");
		System.out.println("2. End of the day");
	}
	
	/*
	 * Processing methods
	 */
	private void processMainMenu(int selectedOption) {
		if(selectedOption == 1) {
			processBeginningOfTheDayMenu();
		} else {
			// Go to calculate Calories for the say
			processEndOfTheDayMenu();
		}
	}
	
	
	private void processBeginningOfTheDayMenu() {
		// Go to create a user and calculate BMR
		String name = getUserName();
		int age = getUserAge();
		double weight = getUserWeight();
		double height = getUserHeight();
		
		
		int sex = getUserSex();
		
		User user = new User(name, age, weight, height, sex);
		calculateAndDisplayBMRResult(user);
	}
	
	private void processEndOfTheDayMenu() {
		//To be filled out later.
	}
	
	
	private void calculateAndDisplayBMRResult(User user) {
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
		
		this.processMainMenu(selectedOption);
		
		this.keyboardIn.close();
	}
	
	
	public static void main(String[] args) {
		Menu oneMoreRepMenu = new Menu();
		oneMoreRepMenu.runMenu();
	}

}
