package onemorerep;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;



public class GUI extends JFrame implements ActionListener {
	
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
	GUIButton sexNextButton;

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
		
		sexNextButton = new GUIButton("Next", this);
		this.addComponent(sexNextButton.getButton());
		
		//Initilalizing Radio Buttons
		
		//Initializing all Panels
		this.initializeWelcomePanel();
		this.initializeTextAreaPanel();
		
		//Initializing all Labels
		this.initializeWelcomeLabel();
		this.initializeTextAreaLabel();
		
		//Initializing textField
		personalInfoTextField = new JTextField();
		personalInfoTextField.setBounds(100, 200, 300, 40);
		personalInfoTextField.setVisible(false);
		this.addComponent(personalInfoTextField);
	}
	
	public void initializeWelcomePanel() {
		welcomePanel = new JPanel();
		welcomePanel.setBounds(0, 0, 500, 250);
		welcomePanel.setBackground(new Color(0xE3DAC9));
		welcomePanel.setLayout(new BorderLayout()); //BorderLayout acts like JFrame layout. JPanel uses FlowLayout
		this.addComponent(welcomePanel);
	}
	
	public void initializeWelcomeLabel() {
		JLabel welcomeLabel = new JLabel();
		welcomeLabel.setText("Welcome to 1MoreRep!");
		welcomeLabel.setHorizontalAlignment(SwingConstants.CENTER);
		welcomeLabel.setVerticalAlignment(SwingConstants.BOTTOM);
		welcomeLabel.setFont(new Font("Helvetica", Font.PLAIN, 30));
		welcomePanel.add(welcomeLabel);
	}
	
	public void initializeTextAreaPanel() {
		textAreaPanel = new JPanel();
		textAreaPanel.setLayout(new BorderLayout());
		textAreaPanel.setBounds(0, 0, 500, 200);
		textAreaPanel.setBackground(new Color(0xE3DAC9));
		textAreaPanel.setVisible(false);
		this.addComponent(textAreaPanel);
	}
	
	public void initializeTextAreaLabel() {
		textAreaLabel = new JLabel();
		textAreaLabel.setText("Please choose what time of the day it is.");
		textAreaLabel.setHorizontalAlignment(SwingConstants.CENTER);
		textAreaLabel.setVerticalAlignment(SwingConstants.BOTTOM);
		textAreaLabel.setFont(new Font("Helvetica", Font.PLAIN, 20));
		textAreaLabel.setVisible(false);
		textAreaPanel.add(textAreaLabel);
	}
	
	
	public void makeGUIVisible() {
		frame.setVisible(true);
	}
	
	public void addComponent(JComponent component) {
		frame.add(component);
	}
	
	//Frame configurations
	public void configureGUIFrame() {
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
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource() == letsGoButton.getButton()) {
			letsGoButton.hide();
			welcomePanel.setVisible(false);
			textAreaLabel.setVisible(true);
			textAreaPanel.setVisible(true);

			textAreaLabel.setText("<html>" + "Good Morning! You can calculate your basic BMR with your personal information here." + "</html>");			
			
			//Show Calculate BMR button
			calcBMRButton.show();
		}
		else if(e.getSource() == calcBMRButton.getButton()) {
			//Hide CalcBMR and Back buttons
			calcBMRButton.hide();
			
			//Change textAreaLabel text
			textAreaLabel.setText("Please enter your name");
			//Show nameNextButton
			nameNextButton.show();
			//Show nameTextField
			personalInfoTextField.setVisible(true);
		}
		else if(e.getSource() == nameNextButton.getButton()) {
			//Set username instance variable
			this.user.setName(personalInfoTextField.getText());
			
			//Hide nameNextButton
			nameNextButton.hide();
			
			//Set textAreaLabel to be greeting of the name
			textAreaLabel.setText("<html>" + "Hello," + this.user.getName() + "! Please enter your age." + "</html>");
			
			personalInfoTextField.setText("");
			
			//Show ageNextButton
			ageNextButton.show();
		}
	}
	
}
