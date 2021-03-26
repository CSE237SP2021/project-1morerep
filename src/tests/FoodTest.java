package tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import onemorerep.Food;

class testFood {

	@Test
	void FoodTest() {
		Food apple = new Food("Apple", 95);
		assertEquals(95, apple.getCalories());
	}

}
