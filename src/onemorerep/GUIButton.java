package onemorerep;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


public class GUIButton extends JFrame implements ActionListener {
	//Constant dimensions
	private static final int WIDTH = 300;
	private static final int HEIGHT = 40;
	
	private static final int X = 200;
	private static final int Y = 300;
	
	private JButton button;
	
	public GUIButton(String text) {
		button = new JButton();
		button.setBounds(200, 300, 100, 40);
		button.addActionListener(this);
		button.setText(text);
		button.setFocusable(false);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
}
