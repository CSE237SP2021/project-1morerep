package onemorerep;

import java.awt.*;
import java.awt.event.*;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import javax.swing.*;

public class Entry extends JFrame implements ActionListener {
	// A hash map storing all menus, the key is the option name in the previous map, the value is the sub menu
	private Map<String, Menu> menuMap;
	private Scanner keyboardIn;
	private User user;
	private FoodLog foodLog;
	
	private JFrame frame;
	
	//Constants for frame dimensions
	private static final int FRAME_WIDTH = 500;
	private static final int FRAME_HEIGHT = 500;
	
	JRadioButton beginningButton;
	JRadioButton endOfTheDayButton;
	JPanel welcomePanel;
	JButton letsGoButton;
	JButton nextButton;
	JLabel mainMenuLabel;
	JPanel mainMenuQuestionPanel;
	ButtonGroup buttonGroup;
	JPanel radioButtonsPanel;
	
	public Entry() {
		menuMap = new HashMap<String, Menu>();
		frame = new JFrame();
		keyboardIn = new Scanner(System.in);
		foodLog = new FoodLog();
	}

	// Initialize all menus and run the main menu
	private void runEntry() {
		//Welcome label
		JLabel welcomeLabel = new JLabel();
		welcomeLabel.setText("Welcome to 1MoreRep!");
		welcomeLabel.setHorizontalAlignment(SwingConstants.CENTER);
		welcomeLabel.setVerticalAlignment(SwingConstants.BOTTOM);
		welcomeLabel.setFont(new Font("Helvetica", Font.PLAIN, 30));
		
		//Let's Go! Button
		letsGoButton = new JButton();
		letsGoButton.setBounds(200, 270, 100, 40);
		letsGoButton.addActionListener(this);
		letsGoButton.setText("Let's go!");
		letsGoButton.setFocusable(false);
		
		
		//Next Button
		nextButton = new JButton();
		nextButton.setBounds(200, 300, 100, 40);
		nextButton.addActionListener(e -> System.out.println("Next clicked"));
		nextButton.setText("Next");
		nextButton.setFocusable(false);
		

		//Welcome label panel
		welcomePanel = new JPanel();
		welcomePanel.setBounds(0, 0, 500, 250);
		welcomePanel.setBackground(new Color(0xE3DAC9));
		welcomePanel.setLayout(new BorderLayout()); //BorderLayout acts like JFrame layout. JPanel uses FlowLayout
		welcomePanel.add(welcomeLabel);
		
		
		//Main Menu Label
		mainMenuLabel = new JLabel();
		mainMenuLabel.setText("Please choose what time of the day it is.");
		mainMenuLabel.setHorizontalAlignment(SwingConstants.CENTER);
		mainMenuLabel.setVerticalAlignment(SwingConstants.BOTTOM);
		mainMenuLabel.setFont(new Font("Helvetica", Font.PLAIN, 20));

		//Main Menu Question Panel that holds the label
		mainMenuQuestionPanel = new JPanel();
		mainMenuQuestionPanel.setLayout(new BorderLayout());
		mainMenuQuestionPanel.setBounds(0, 0, 500, 200);
		mainMenuQuestionPanel.add(mainMenuLabel);
		
		//Panel for radioButtons
		radioButtonsPanel = new JPanel();
		radioButtonsPanel.setBounds(0, 200, 500, 100);
		
		beginningButton = new JRadioButton("Beginning");
		endOfTheDayButton = new JRadioButton("End");
		
		beginningButton.addActionListener(this);
		endOfTheDayButton.addActionListener(this);
		
		//Group for radio buttons
		buttonGroup = new ButtonGroup();
		buttonGroup.add(beginningButton);
		buttonGroup.add(endOfTheDayButton);
		
		radioButtonsPanel.add(beginningButton);
		radioButtonsPanel.add(endOfTheDayButton);
		
		
		//Frame configurations
		frame.setSize(FRAME_WIDTH, FRAME_HEIGHT);
		frame.setTitle("1MoreRep");
		frame.setLayout(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //Frame exists when clicked on close button
		frame.setResizable(false); //non-resizeable screen
		
		frame.add(welcomePanel);
		frame.add(letsGoButton);
		
		radioButtonsPanel.setVisible(false);
		mainMenuLabel.setVisible(false);
		mainMenuQuestionPanel.setVisible(false);
		nextButton.setVisible(false);
		frame.add(mainMenuQuestionPanel);
		frame.add(radioButtonsPanel);
		frame.add(nextButton);

		frame.getContentPane().setBackground(new Color(0xE3DAC9));
		frame.setVisible(true); //Make frame visible.
		
//		
//		Menu mainMenu = new Menu("Welcome to 1MoreRep!");
//		generateAllMenus(mainMenu);
//		
//		runMenu(mainMenu);
	}
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == beginningButton) {
			System.out.println("Clicked on beginning");
		}
		else if(e.getSource() == endOfTheDayButton) {
			System.out.println("End Of The Day clicked");
		}
		else if(e.getSource() == letsGoButton) {
			letsGoButton.setVisible(false);
			welcomePanel.setVisible(false);
		
			nextButton.setVisible(true);
			mainMenuLabel.setVisible(true);
			mainMenuQuestionPanel.setVisible(true);
			radioButtonsPanel.setVisible(true);
		}
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
