package onemorerep;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;



public class GUI extends JFrame implements ActionListener {
	
	//Constants for frame dimensions
	private static final int FRAME_WIDTH = 500;
	private static final int FRAME_HEIGHT = 500;

	private JFrame frame;
	
	JPanel welcomePanel;
	JButton letsGoButton;
	JLabel textAreaLabel;
	JPanel textAreaPanel;
	JButton calcBMRButton;

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

	public GUI() {
		frame = new JFrame();
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
		
	}
	
}
