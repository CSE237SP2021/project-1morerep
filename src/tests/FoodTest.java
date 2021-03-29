package tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import onemorerep.Food;

class FoodTest {

	@Test
	void testFood() {
		Food apple = new Food("Apple", 95);
		int appleCalories = apple.getCalories();
		assertEquals(95, appleCalories, "Number of calories for apple is incorrect. Expected 95");
	}

}
