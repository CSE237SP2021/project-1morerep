package onemorerep;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Entry {
	// A hash map storing all menus, the key is the option name in the previous map, the value is the sub menu
	private Map<String, Menu> menuMap;
	private Scanner keyboardIn;
	private User user;
	private FoodLog foodLog;
	private ExerciseLog exerciseLog;
	
	// Constructor
	public Entry() {
		user = new User();
//		user = new User("", 0, 0, 0, 0);
		menuMap = new HashMap<String, Menu>();
		keyboardIn = new Scanner(System.in);
		foodLog = new FoodLog();
		exerciseLog = new ExerciseLog();
	}

	// Initialize all menus and run the main menu
	private void runEntry() {
		Menu mainMenu = new Menu("Welcome to 1MoreRep!");
		generateAllMenus(mainMenu);
		
		runMenu(mainMenu);
	}

	private void generateAllMenus(Menu mainMenu) {
		// Add options for the main menu
		mainMenu.setOptions(Arrays.asList("Beginning of the day", "End of the day", "Quit"));
		
		// Generate beginning of the day menu
		Menu beginningOfTheDayMenu = new Menu("Good Morning! You can calculate your basic BMR with your personal information here.", mainMenu);
		menuMap.put("Beginning of the day", beginningOfTheDayMenu);
		beginningOfTheDayMenu.setOptions(Arrays.asList("Calculate my BMR", "Back"));
		
		// Generate end of the day menu
		Menu endOfTheDayMenu = new Menu("Good evening! You can provide the food you eat and exercise you do today to calculate calories here.", mainMenu);
		menuMap.put("End of the day", endOfTheDayMenu);
		endOfTheDayMenu.setOptions(Arrays.asList("Calculate calories taken from food", "Calculate calories burned from workout", "Summary of the day", "Back"));
		
		// Generate food log menu
		Menu foodLogMenu = new Menu("Track your food intake now!");
		menuMap.put("Calculate calories taken from food", foodLogMenu);
		foodLogMenu.setOptions(Arrays.asList("Add a food", "View food log summary", "Back"));

		// Generate exercise log menu
		Menu exerciseLogMenu = new Menu("Track your workout now!");
		menuMap.put("Calculate calories burned from workout", exerciseLogMenu);
		// TO DO!!! Check exercise log options
		exerciseLogMenu.setOptions(Arrays.asList("Add an exercise", "View exercise log summary", "Back"));
		
//		// Generate exercise log menu
//		Menu exerciseTypeMenu = new Menu("Add an exercuse now!");
//		menuMap.put("Add an exercise", exerciseTypeMenu);
//		// TO DO!!! Check exercise log options
//		exerciseLogMenu.setOptions(Arrays.asList("Bicycling", "JumpingRope", "Pushups", "Running", "Situps", "Squats", "Swimming", "Walking"));
//		
	}

	private void runMenu(Menu menu) {
		menu.displayMenu();
		
		int selectedOption = keyboardIn.nextInt();
		// Process the option if the option is not quit or back
		while(selectedOption != menu.getNumberOfOptions()) {
			// Wait for the input until get the valid choice of option number
			while(selectedOption > menu.getNumberOfOptions() || selectedOption < 1) {
				System.out.println("Invalid input! Please enter again!");
				selectedOption = keyboardIn.nextInt();
			}
			
			String option = menu.getOption(selectedOption);
			processOption(option);
			
			menu.displayMenu();
			selectedOption = keyboardIn.nextInt();
		}
	}
	
	private void processOption(String option) {
		//if(menuMap.containsKey(option) && !option.equals("Add an exercise")) {
		if(menuMap.containsKey(option)) {
			runMenu(menuMap.get(option));
		} else {
			callAPI(option);
		}
	}
	
	private void callAPI(String option) {
		switch(option) {
		case "Calculate my BMR":
			Apis.calculateMyBMR(keyboardIn, user);
			break;
		case "Add a food":
			Apis.addFoodToFoodLog(keyboardIn, foodLog);;
			break;
		case "View food log summary":
			foodLog.displayFoodLog();
			break;
		case "Add an exercise":
			Apis.addExerciseToExerciseLog(keyboardIn, exerciseLog, user);
			break;
		case "View exercise log summary":
			exerciseLog.displayExerciseLog();
			break;
		case "Quit":
			System.out.println("Bye!");
			break;
		// TO DO!!! Add exercise log methods
		default:
			System.out.println("Not implemented yet.");
		}
		System.out.println("-----------------------");
	}
	
	public static void main(String[] args) {
		Entry entry = new Entry();
		entry.runEntry();
	}

}
