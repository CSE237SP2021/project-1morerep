package onemorerep;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Menu {
	private String message;
	private List<String> options;
	private Menu previousMenu;
	
	
	public Menu(String message) {
		this.message = message;
		this.options = new ArrayList<>();
	}
	
	public Menu(String message, Menu previousMenu) {
		this.message = message;
		this.options = new ArrayList<>();
		this.previousMenu = previousMenu;
	}
	
	public Menu(String message, List<String> options, Menu previousMenu) {
		this.message = message;
		this.options = options;
		this.previousMenu = previousMenu;
	}
	
	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public List<String> getOptions() {
		return options;
	}
	
	public int getNumberOfOptions() {
		return options.size();
	}
	
	public String getOption(int index) {
		return options.get(index-1);
	}

	public void setOptions(List<String> options) {
		this.options = options;
	}
	
	
	public void displayMenu() {
		System.out.println(this.message);
		for(int i = 0; i < options.size(); i++) {
			System.out.println((i+1) + ". " + options.get(i));
		}
	}
	
	
}
