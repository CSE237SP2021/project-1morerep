package onemorerep;

import java.util.ArrayList;
import java.util.List;

public class FoodLog {
	private List<Food> foodList;
	
	public FoodLog() {
		this.foodList = new ArrayList<>();
	}
	
	public void addFood(Food food) {
		foodList.add(food);
	}
	
	public int getNumberOfFood() {
		return foodList.size();
	}
	
	public int getTotalCalories() {
		int totalCalories = 0;
		for(Food food : foodList) {
			totalCalories += food.getCalories();
		}
		return totalCalories;
	}
	
	public void displayFoodLog() {
		System.out.println("There are " + getNumberOfFood() + " kinds of food ate today.");
		System.out.println("There are " + getTotalCalories() + " calories taken in today.");
		for(int i = 0; i < foodList.size(); i++) {
			System.out.print((i+1) + ". ");
			foodList.get(i).displayFood();
		}
	}

}
