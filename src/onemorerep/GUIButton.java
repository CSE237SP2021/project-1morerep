package onemorerep;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


public class GUIButton {
	//Constant dimensions
	private static final int WIDTH = 100;
	private static final int HEIGHT = 40;
	
	private static final int X = 200;
	private static final int Y = 300;
	
	private JButton button;
	
	public GUIButton(String text, GUI gui) {
		button = new JButton();
		button.setBounds(X, Y, WIDTH, HEIGHT);
		button.addActionListener(gui);
		button.setText(text);
		button.setFocusable(false);
	}
	
	public JButton getButton() {
		return button;
	}
	
	public void show() {
		button.setVisible(true);
	}
	
	public void hide() {
		button.setVisible(false);
	}
}
