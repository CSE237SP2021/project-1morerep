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
	private ExerciseLog exerciseLog;
	
	private JFrame frame;
	
	//Constants for frame dimensions
	private static final int FRAME_WIDTH = 500;
	private static final int FRAME_HEIGHT = 500;
	
	JRadioButton beginningButton;
	JRadioButton endOfTheDayButton;
	String username;
	int age;
	double weight;
	double height;
	int sex;
	
	JPanel welcomePanel;
	JButton letsGoButton;
	JLabel textAreaLabel;
	JPanel textAreaPanel;
	
	ButtonGroup buttonGroup;
	JPanel radioButtonsPanel;
	JButton calcBMRButton;
	JButton backButton;
	
	JTextField personalInfoTextField; //TextField that will accept name, age, weight, height
	
	ButtonGroup sexButtonGroup;
	JPanel sexButtonsPanel;
	JRadioButton maleButton;
	JRadioButton femaleButton;
	
	JLabel BMRResultLabel;
	
	JButton nameNextButton;
	JButton ageNextButton;
	JButton weightNextButton;
	JButton heightNextButton;
	JButton sexNextButton;
	
	
	public Entry() {
		user = new User();
//		user = new User("", 0, 0, 0, 0);
		menuMap = new HashMap<String, Menu>();
		frame = new JFrame();
		keyboardIn = new Scanner(System.in);
		foodLog = new FoodLog();
		exerciseLog = new ExerciseLog();
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
		
		//Welcome label panel
		welcomePanel = new JPanel();
		welcomePanel.setBounds(0, 0, 500, 250);
		welcomePanel.setBackground(new Color(0xE3DAC9));
		welcomePanel.setLayout(new BorderLayout()); //BorderLayout acts like JFrame layout. JPanel uses FlowLayout
		welcomePanel.add(welcomeLabel);
		
		
		//Main Menu Label

		textAreaLabel = new JLabel();
		textAreaLabel.setText("Please choose what time of the day it is.");
		textAreaLabel.setHorizontalAlignment(SwingConstants.CENTER);
		textAreaLabel.setVerticalAlignment(SwingConstants.BOTTOM);
		textAreaLabel.setFont(new Font("Helvetica", Font.PLAIN, 20));

		//Main Menu Question Panel that holds the label
		textAreaPanel = new JPanel();
		textAreaPanel.setLayout(new BorderLayout());
		textAreaPanel.setBounds(0, 0, 500, 200);
		textAreaPanel.setBackground(new Color(0xE3DAC9));
		textAreaPanel.add(textAreaLabel);
		
		//Panel for beginning and end of day radioButtons
		radioButtonsPanel = new JPanel();
		radioButtonsPanel.setBounds(0, 200, 500, 100);
		radioButtonsPanel.setBackground(new Color(0xE3DAC9));
		
		beginningButton = new JRadioButton("Beginning");
		endOfTheDayButton = new JRadioButton("End");
		
		beginningButton.addActionListener(this);
		endOfTheDayButton.addActionListener(this);
		
		//Group for beginning and end of day radio buttons
		buttonGroup = new ButtonGroup();
		buttonGroup.add(beginningButton);
		buttonGroup.add(endOfTheDayButton);
		
		radioButtonsPanel.add(beginningButton);
		radioButtonsPanel.add(endOfTheDayButton);
		
		
		
		//Panel for sex radioButtons
		sexButtonsPanel = new JPanel();
		sexButtonsPanel.setBounds(0, 200, 500, 100);
		sexButtonsPanel.setBackground(new Color(0xE3DAC9));
		
		maleButton = new JRadioButton("Male");
		femaleButton = new JRadioButton("Female");
		
		maleButton.addActionListener(this);
		femaleButton.addActionListener(this);
		
		//Group for beginning and end of day radio buttons
		sexButtonGroup = new ButtonGroup();
		sexButtonGroup.add(maleButton);
		sexButtonGroup.add(femaleButton);
		
		sexButtonsPanel.add(maleButton);
		sexButtonsPanel.add(femaleButton);
		
		

		//Calculate BMR Button and Back Button
		calcBMRButton = new JButton();
		calcBMRButton.setBounds(150, 300, 100, 40);
		calcBMRButton.addActionListener(this);
		calcBMRButton.setText("Calculate BMR");
		calcBMRButton.setFocusable(false);
		
		backButton = new JButton();
		backButton.setBounds(250, 300, 100, 40);
		backButton.addActionListener(this);
		backButton.setText("Back");
		backButton.setFocusable(false);
		
		
		//Personal Info textfield
		personalInfoTextField = new JTextField();
		personalInfoTextField.setBounds(100, 200, 300, 40);
		
		//Name Next button
		nameNextButton = new JButton();
		nameNextButton.setBounds(200, 300, 100, 40);
		nameNextButton.addActionListener(this);
		nameNextButton.setText("Next");
		nameNextButton.setFocusable(false);
		

		//Age Next button
		ageNextButton = new JButton();
		ageNextButton.setBounds(200, 300, 100, 40);
		ageNextButton.addActionListener(this);
		ageNextButton.setText("Next");
		ageNextButton.setFocusable(false);
		
		//Weight Next button
		weightNextButton = new JButton();
		weightNextButton.setBounds(200, 300, 100, 40);
		weightNextButton.addActionListener(this);
		weightNextButton.setText("Next");
		weightNextButton.setFocusable(false);
		
		//Height Next button
		heightNextButton = new JButton();
		heightNextButton.setBounds(200, 300, 100, 40);
		heightNextButton.addActionListener(this);
		heightNextButton.setText("Next");
		heightNextButton.setFocusable(false);
		
		//Frame configurations
		frame.setSize(FRAME_WIDTH, FRAME_HEIGHT);
		frame.setTitle("1MoreRep");
		frame.setLayout(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //Frame exists when clicked on close button
		frame.setResizable(false); //non-resizeable screen
		
		//Visibilities
		radioButtonsPanel.setVisible(false);
		textAreaLabel.setVisible(false);
		textAreaPanel.setVisible(false);
		calcBMRButton.setVisible(false);
		backButton.setVisible(false);
		personalInfoTextField.setVisible(false);
		nameNextButton.setVisible(false);
		ageNextButton.setVisible(false);
		weightNextButton.setVisible(false);
		heightNextButton.setVisible(false);
		sexButtonsPanel.setVisible(false);
		
		//Adding items to frame
		frame.add(welcomePanel);
		frame.add(letsGoButton);
		frame.add(textAreaPanel);
		frame.add(radioButtonsPanel);
		frame.add(calcBMRButton);
		frame.add(backButton);
		frame.add(nameNextButton);
		frame.add(personalInfoTextField);
		frame.add(ageNextButton);
		frame.add(weightNextButton);
		frame.add(heightNextButton);
		frame.add(sexButtonsPanel);
		

		//Finalize config
		frame.getContentPane().setBackground(new Color(0xE3DAC9));
		frame.setVisible(true); //Make frame visible.
		
//		Menu mainMenu = new Menu("Welcome to 1MoreRep!");
//		generateAllMenus(mainMenu);
//		
//		runMenu(mainMenu);
	}
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == beginningButton) {
			System.out.println("Clicked on beginning");
			//Hide the radio buttons
			radioButtonsPanel.setVisible(false);
			//Hide please choose what time of the day it is label
			textAreaLabel.setText("<html>" + "Good Morning! You can calculate your basic BMR with your personal information here." + "</html>");			
			
			//Show Back button
			backButton.setVisible(true);
			//Show Calculate BMR button
			calcBMRButton.setVisible(true);
			//Show Good morning...calculate BMR label
			
		}
		else if(e.getSource() == endOfTheDayButton) {
			//Show label that says endOfTheDay is only available through the command line or your Eclipse console.
		}
		else if(e.getSource() == nameNextButton) {
			//Set username instance variable
			username = personalInfoTextField.getText();
			
			//Hide nameNextButton
			nameNextButton.setVisible(false);
			
			//Set textAreaLabel to be greeting of the name
			textAreaLabel.setText("<html>" + "Hello," + this.username + "! Please enter your age." + "</html>");
			
			personalInfoTextField.setText("");
			
			//Show ageNextButton
			ageNextButton.setVisible(true);
		}
		else if(e.getSource() == ageNextButton) {
			//Set user age
			this.age = Integer.parseInt(personalInfoTextField.getText());
			
			//Hide ageNextButton
			ageNextButton.setVisible(false);
			//Reset textField
			personalInfoTextField.setText("");
			//Set textArea Label
			textAreaLabel.setText("<html>" + "Nice work," + this.username + "! Please enter your weight (kg)." + "</html>");
			
			//Show weightNextButton
			weightNextButton.setVisible(true);
		}
		else if(e.getSource() == weightNextButton) {
			//Set user weight
			this.weight = Double.parseDouble(personalInfoTextField.getText());
			//Hide weightNextButton
			weightNextButton.setVisible(false);
			//Reset TextField
			personalInfoTextField.setText("");
			//Set textArea label
			textAreaLabel.setText("<html>" + "Almost there," + this.username + ". Please enter your height (cm)." + "</html>");
			//Show heightNextButton
			heightNextButton.setVisible(true);
		}
		else if(e.getSource() == heightNextButton) {
			//Set user height
			this.height = Double.parseDouble(personalInfoTextField.getText());
			//Hide heightNextButton
			heightNextButton.setVisible(false);
			//Hide textField
			personalInfoTextField.setVisible(false);
			//Set textArea label
			textAreaLabel.setText("<html>" + "Last one. Please choose your sex." + "</html>");
			//Show sexButton group
			sexButtonsPanel.setVisible(true);
		}
		else if(e.getSource() == maleButton) {
			//Set user sex
			this.sex = 1;
			//Hide radiobuttons
			sexButtonsPanel.setVisible(false);
			//Set textAreaLabel with BMR calculated
			textAreaLabel.setText("Your BMR is: ");
		}
		else if(e.getSource() == femaleButton) {
			//Set user sex
			this.sex = 2;
			//Hide radiobuttons
			sexButtonsPanel.setVisible(false);
			//Set textAreaLabel with BMR calculated
			textAreaLabel.setText("Your BMR is: ");
		}
		else if(e.getSource() == calcBMRButton) {
			//Hide CalcBMR and Back buttons
			calcBMRButton.setVisible(false);
			backButton.setVisible(false);
			
			//Change textAreaLabel text
			textAreaLabel.setText("Please enter your name");
			//Show nameNextButton
			nameNextButton.setVisible(true);
			//Show nameTextField
			personalInfoTextField.setVisible(true);
		}
		else if(e.getSource() == backButton) {
			//Show the main menu
			textAreaLabel.setVisible(true);
			textAreaPanel.setVisible(true);
			radioButtonsPanel.setVisible(true);
			
			//Hide the current page
			backButton.setVisible(false);
			calcBMRButton.setVisible(false);
			textAreaLabel.setText("Please choose what time of the day it is.");
		}
		else if(e.getSource() == letsGoButton) {
			letsGoButton.setVisible(false);
			welcomePanel.setVisible(false);
		
			textAreaLabel.setVisible(true);
			textAreaPanel.setVisible(true);

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
		case "Summary of the day":
			Apis.displayCalorieBalance(foodLog, exerciseLog);
			break;
		case "Quit":
			System.out.println("Bye!");
			break;
		
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
