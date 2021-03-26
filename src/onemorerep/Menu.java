package onemorerep;

import java.util.Scanner;

public class Menu {
	
	public static void main(String[] args) {
		System.out.println("Welcome to 1MoreRep!");
		
		System.out.println("Please select an option:");
		System.out.println("1. Beginning of the day");
		System.out.println("2. End of the day");
		
		Scanner keyboardIn = new Scanner(System.in);
		int selectedOption = keyboardIn.nextInt();
		
		if(selectedOption == 1) {
			// Go to create a user and calculate BMR
			System.out.println("Please enter your name");
			String name = keyboardIn.next();
			System.out.println("Hello, " + name);
			
			System.out.println("Please enter your age");
			int age = keyboardIn.nextInt();
			
			System.out.println("Please enter your weight (kg)");
			int weight = keyboardIn.nextInt();
			
			System.out.println("Please enter your height (cm)");
			int height = keyboardIn.nextInt();
			
			System.out.println("Please enter your sex");
			System.out.println("1. Male");
			System.out.println("2. Female");
			int sex = keyboardIn.nextInt();
			
			User user = new User(name, age, weight, height, sex);
			
			int bmr = user.calculateBMR();
			System.out.println("Your BMR is " + bmr);
		} else {
			// Go to calculate Calories for the say
		}
		
		keyboardIn.close();
	}

}
