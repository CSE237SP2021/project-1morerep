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
		assertEquals(1, foodLog.getNumberOfFood(), "Number of food is correct or not. Expected 1");
	}
	
	@Test
	void testTotalCalories() {
		FoodLog foodLog = new FoodLog();
		Food apple = new Food("Apple", 95);
		Food cookie = new Food("Cookie", 195);
		foodLog.addFood(apple);
		foodLog.addFood(cookie);
		foodLog.displayFoodLog();
		assertEquals(290, foodLog.getTotalCalories(), "Total calories of all food in the foodLog is correct or not. Expected 290");
	}

}
