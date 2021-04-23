package tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import onemorerep.Apis;
import onemorerep.ExerciseLog;
import onemorerep.Food;
import onemorerep.FoodLog;
import onemorerep.JumpingRope;
import onemorerep.User;

class CalorieBalanceTest {

	@Test
	void testCalorieBalanceTest() {
		FoodLog foodLog = new FoodLog();
		Food apple = new Food("Apple", 95);
		Food cookie = new Food("Cookie", 195);
		foodLog.addFood(apple);
		foodLog.addFood(cookie);
		foodLog.displayFoodLog();
		int totalFoodCalories = foodLog.getTotalCalories();
		assertEquals(290, totalFoodCalories, "Total calories of all food in the foodLog is incorrect. Expected 290");
		
		ExerciseLog exerciseLog = new ExerciseLog();
		User user = new User("Jing", 23, 49, 163, 2);
		JumpingRope jumpingRope1 = new JumpingRope("JumpingRope", 25, user);
		JumpingRope jumpingRope2 = new JumpingRope("JumpingRope", 35, user);
		exerciseLog.addExercise(jumpingRope1);
		exerciseLog.addExercise(jumpingRope2);
		exerciseLog.displayExerciseLog();
		int totalExerciseCalories = exerciseLog.getTotalCalories();
		assertEquals(607, totalExerciseCalories, "Total calories of all exercise in the exerciseLog is incorrect. Expected 607");
		
		int calorieBalance = Apis.getCalorieBalance(foodLog, exerciseLog);
		assertEquals(317, calorieBalance, "Calorie balance of the day is incorrect. Expected 317");
	}

}
