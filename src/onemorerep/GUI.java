package onemorerep;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;



public class GUI extends JFrame implements ActionListener {

	private static final long serialVersionUID = 1L; //Required for interface ActionListener
	
	//Constants for frame dimensions
	private static final int FRAME_WIDTH = 500;
	private static final int FRAME_HEIGHT = 500;

	private JFrame frame;
	private User user;
	
	JPanel welcomePanel;
	GUIButton letsGoButton;
	JLabel textAreaLabel;
	JPanel textAreaPanel;
	GUIButton calcBMRButton;

	JTextField personalInfoTextField; //TextField that will accept name, age, weight, height
	
	ButtonGroup sexButtonGroup;
	JPanel sexButtonsPanel;
	JRadioButton maleButton;
	JRadioButton femaleButton;
	
	JLabel BMRResultLabel;
	
	GUIButton nameNextButton;
	GUIButton ageNextButton;
	GUIButton weightNextButton;
	GUIButton heightNextButton;

	public GUI(User user) {
		frame = new JFrame();
		this.user = user;
		
		//Initializing all buttons
		letsGoButton = new GUIButton("Let's Go!", this);
		this.addComponent(letsGoButton.getButton());
		
		calcBMRButton = new GUIButton("Calculate BMR", this);
		this.addComponent(calcBMRButton.getButton());
		
		nameNextButton = new GUIButton("Next", this);
		this.addComponent(nameNextButton.getButton());
		
		ageNextButton = new GUIButton("Next", this);
		this.addComponent(ageNextButton.getButton());
		
		weightNextButton = new GUIButton("Next", this);
		this.addComponent(weightNextButton.getButton());
		
		heightNextButton = new GUIButton("Next", this);
		this.addComponent(heightNextButton.getButton());

		//Initilalizing Radio Buttons
		this.initializeSexRadioButtons();
				
		//Initializing all Panels
		this.initializeWelcomePanel();
		this.initializeTextAreaPanel();
		this.initializeSexButtonsPanel();
		
		//Initializing all Labels
		this.initializeWelcomeLabel();
		this.initializeTextAreaLabel();
		
		//Initializing textField
		this.intializePersonalInfoTextField();
	}
	
	
	//Initializing functions ----------------------------------------------
	
	private void intializePersonalInfoTextField() {
		personalInfoTextField = new JTextField();
		personalInfoTextField.setBounds(100, 200, 300, 40);
		personalInfoTextField.setVisible(false);
		this.addComponent(personalInfoTextField);
	}
	
	private void initializeSexButtonsPanel() {
		sexButtonsPanel = new JPanel();
		sexButtonsPanel.setBounds(0, 200, 500, 100);
		sexButtonsPanel.setBackground(new Color(0xE3DAC9));
		sexButtonsPanel.add(maleButton);
		sexButtonsPanel.add(femaleButton);
		sexButtonsPanel.setVisible(false);
		this.addComponent(sexButtonsPanel);
	}
	
	private void initializeSexRadioButtons() {
		maleButton = new JRadioButton("Male");
		femaleButton = new JRadioButton("Female");
		
		maleButton.addActionListener(this);
		femaleButton.addActionListener(this);
		
		sexButtonGroup = new ButtonGroup();
		sexButtonGroup.add(maleButton);
		sexButtonGroup.add(femaleButton);
	}
	
	private void initializeWelcomePanel() {
		welcomePanel = new JPanel();
		welcomePanel.setBounds(0, 0, 500, 250);
		welcomePanel.setBackground(new Color(0xE3DAC9));
		welcomePanel.setLayout(new BorderLayout()); //BorderLayout acts like JFrame layout. JPanel uses FlowLayout
		this.addComponent(welcomePanel);
	}
	
	private void initializeWelcomeLabel() {
		JLabel welcomeLabel = new JLabel();
		welcomeLabel.setText("Welcome to 1MoreRep!");
		welcomeLabel.setHorizontalAlignment(SwingConstants.CENTER);
		welcomeLabel.setVerticalAlignment(SwingConstants.BOTTOM);
		welcomeLabel.setFont(new Font("Helvetica", Font.PLAIN, 30));
		welcomePanel.add(welcomeLabel);
	}
	
	private void initializeTextAreaPanel() {
		textAreaPanel = new JPanel();
		textAreaPanel.setLayout(new BorderLayout());
		textAreaPanel.setBounds(0, 0, 500, 200);
		textAreaPanel.setBackground(new Color(0xE3DAC9));
		textAreaPanel.setVisible(false);
		this.addComponent(textAreaPanel);
	}
	
	private void initializeTextAreaLabel() {
		textAreaLabel = new JLabel();
		textAreaLabel.setText("Welcome!");
		textAreaLabel.setHorizontalAlignment(SwingConstants.CENTER);
		textAreaLabel.setVerticalAlignment(SwingConstants.BOTTOM);
		textAreaLabel.setFont(new Font("Helvetica", Font.PLAIN, 20));
		textAreaLabel.setVisible(false);
		textAreaPanel.add(textAreaLabel);
	}
	
	
	
	//public functions ----------------------------------------------
	
	public void makeGUIVisible() {
		frame.setVisible(true);
	}
	
	public void addComponent(JComponent component) {
		frame.add(component);
	}
	
	//Frame configurations
	private void configureGUIFrame() {
		frame.setSize(FRAME_WIDTH, FRAME_HEIGHT);
		frame.setTitle("1MoreRep");
		frame.setLayout(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //Frame exists when clicked on close button
		frame.setResizable(false); //non-resizeable screen
		frame.getContentPane().setBackground(new Color(0xE3DAC9));
	}
	
	public void runGUI() {
		this.configureGUIFrame();
		this.makeGUIVisible();
	}
	
	
	
	//Action functions ----------------------------------------------
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource() == letsGoButton.getButton()) {
			this.handleClickLetsGoButton();
		}
		else if(e.getSource() == calcBMRButton.getButton()) {
			this.handleClickCalcBMRButton();
		}
		else if(e.getSource() == nameNextButton.getButton()) {
			this.handleClickNameNextButton();
		}
		else if(e.getSource() == ageNextButton.getButton()) {
			this.handleClickAgeNextButton();
		}
		else if(e.getSource() == weightNextButton.getButton()) {
			this.handleClickWeightNextButton();
		}
		else if(e.getSource() == heightNextButton.getButton()) {
			this.handleClickHeightNextButton();
		}
		else if(e.getSource() == maleButton) {
			this.handleClickMaleRadioButton();
		}
		else if(e.getSource() == femaleButton) {
			this.handleClickFemaleRadioButton();
		}
	}

	
	private void handleClickLetsGoButton() {
		letsGoButton.hide();
		welcomePanel.setVisible(false);
		textAreaLabel.setVisible(true);
		textAreaPanel.setVisible(true);

		textAreaLabel.setText("<html>" + "Good Morning! You can calculate your basic BMR with your personal information here." + "</html>");			
		
		//Show Calculate BMR button
		calcBMRButton.show();
	}
	
	private void handleClickCalcBMRButton() {
		//Hide CalcBMR and Back buttons
		calcBMRButton.hide();
		
		//Change textAreaLabel text
		textAreaLabel.setText("Please enter your name");
		//Show nameNextButton
		nameNextButton.show();
		//Show nameTextField
		personalInfoTextField.setVisible(true);
	}
	
	
	private void handleClickNameNextButton() {
		//Set username instance variable
		this.user.setName(personalInfoTextField.getText());
		
		//Hide nameNextButton
		nameNextButton.hide();
		
		//Set textAreaLabel to be greeting of the name
		textAreaLabel.setText("<html>" + "Hello," + this.user.getName() + "! Please enter your age (15-80)." + "</html>");
		
		personalInfoTextField.setText("");
		
		//Show ageNextButton
		ageNextButton.show();
	}
	
	
	private void handleClickAgeNextButton() {
		try {
			int age = Integer.parseInt(personalInfoTextField.getText());
			
			if(!Apis.isValidAgeInput(age)) {
				textAreaLabel.setText("<html>" + "Your age is out of the range 15-80." + "</html>");
			}
			else {
				//Set user age
				this.user.setAge(age);
				
				//Hide ageNextButton
				ageNextButton.hide();
				//Reset textField
				personalInfoTextField.setText("");
				//Set textArea Label
				textAreaLabel.setText("<html>" + "Nice work," + this.user.getName() + "! Please enter your weight (kg)." + "</html>");
				
				//Show weightNextButton
				weightNextButton.show();
			}
		}
		catch(NumberFormatException e1) {
			textAreaLabel.setText("<html>" + "Your input age is not a number. Please enter your age from 15-80." + "</html>");
		}
		catch(NullPointerException e2) {
			textAreaLabel.setText("<html>" + "Your input age is not a number. Please enter your age from 15-80." + "</html>");
		}
	}
	
	
	private void handleClickWeightNextButton() {
		try {
			double weight = Double.parseDouble(personalInfoTextField.getText());
			
			if(!Apis.isPositiveDoubleInput(weight)) {
				textAreaLabel.setText("<html>" + "Please enter a positive weight(kg)" + "</html>");
			}
			else {
				//Set user weight
				this.user.setWeight(weight);
				//Hide weightNextButton
				weightNextButton.hide();
				//Reset TextField
				personalInfoTextField.setText("");
				//Set textArea label
				textAreaLabel.setText("<html>" + "Almost there," + this.user.getName() + ". Please enter your height (cm)." + "</html>");
				//Show heightNextButton
				heightNextButton.show();
			}
		}
		catch(NumberFormatException e1) {
			textAreaLabel.setText("<html>" + "Your input weight is not a number. Please enter your weight(kg)" + "</html>");
		}
		catch(NullPointerException e2) {
			textAreaLabel.setText("<html>" + "Your input weight is not a number. Please enter your weight(kg)" + "</html>");
		}
	}
	
	
	private void handleClickHeightNextButton() {
		try {
			double height = Double.parseDouble(personalInfoTextField.getText());
			
			if(!Apis.isPositiveDoubleInput(height)) {
				textAreaLabel.setText("<html>" + "Please enter a positive height(cm)" + "</html>");
			}
			
			//Set user height
			this.user.setHeight(height);
			//Hide heightNextButton
			heightNextButton.hide();
			//Hide textField
			personalInfoTextField.setVisible(false);
			//Set textArea label
			textAreaLabel.setText("<html>" + "Last one. Please choose your sex." + "</html>");
			//Show sexButton group
			sexButtonsPanel.setVisible(true);
		}
		catch(NumberFormatException e1) {
			textAreaLabel.setText("<html>" + "Your input height is not a number. Please enter your height(cm)" + "</html>");
		}
		catch(NullPointerException e2) {
			textAreaLabel.setText("<html>" + "Your input height is not a number. Please enter your height(cm)" + "</html>");
		}
	}
	
	
	private void handleClickMaleRadioButton() {
		//Set user sex
		this.user.setSex(1);
		//Hide radiobuttons
		sexButtonsPanel.setVisible(false);
		//Set textAreaLabel with BMR calculated
		UserStorage.writeUser(this.user);
		textAreaLabel.setText("<html>" +  "Your BMR is: " + this.user.calculateBMR() + ". Don't quit this window to keep working on the console/command line" + "</html>");
	}
	
	private void handleClickFemaleRadioButton() {
		//Set user sex
		this.user.setSex(2);
		//Hide radiobuttons
		sexButtonsPanel.setVisible(false);
		//Set textAreaLabel with BMR calculated
		UserStorage.writeUser(this.user);
		textAreaLabel.setText("<html>" +  "Your BMR is: " + this.user.calculateBMR() + ". Don't quit this window to keep working on the console/command line" + "</html>");
	}
	
}
