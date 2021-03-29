package tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import onemorerep.Food;
import onemorerep.FoodLog;

class FoodLogTest {

	@Test
	void testAddFoodToFoodLog() {
		FoodLog foodLog = new FoodLog();
		Food apple = new Food("Apple", 95);
		foodLog.addFood(apple);
		int numberOfFood = foodLog.getNumberOfFood();
		assertEquals(1, numberOfFood, "Number of food is incorrect. Expected 1");
	}
	
	@Test
	void testTotalCalories() {
		FoodLog foodLog = new FoodLog();
		Food apple = new Food("Apple", 95);
		Food cookie = new Food("Cookie", 195);
		foodLog.addFood(apple);
		foodLog.addFood(cookie);
		foodLog.displayFoodLog();
		int totalCalories = foodLog.getTotalCalories();
		assertEquals(290, totalCalories, "Total calories of all food in the foodLog is incorrect. Expected 290");
	}

}
