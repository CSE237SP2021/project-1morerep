package tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import onemorerep.ExerciseLog;
import onemorerep.Food;
import onemorerep.FoodLog;
import onemorerep.JumpingRope;
import onemorerep.User;

class ExerciseLogTest {

	@Test
	void testAddExerciseToExerciseLog() {
		ExerciseLog exerciseLog = new ExerciseLog();
		User user = new User("Jing", 23, 49, 163, 2);
		JumpingRope jumpingRope = new JumpingRope("JumpingRope", 25, user);
		exerciseLog.addExercise(jumpingRope);
		int numberOfExercise = exerciseLog.getNumberOfExercise();
		assertEquals(1, numberOfExercise, "Number of exercise is incorrect. Expected 1");
	}
	
	@Test
	void testTotalCalories() {
		ExerciseLog exerciseLog = new ExerciseLog();
		User user = new User("Jing", 23, 49, 163, 2);
		JumpingRope jumpingRope1 = new JumpingRope("JumpingRope", 25, user);
		JumpingRope jumpingRope2 = new JumpingRope("JumpingRope", 35, user);
		exerciseLog.addExercise(jumpingRope1);
		exerciseLog.addExercise(jumpingRope2);
		exerciseLog.displayExerciseLog();
		int totalCalories = exerciseLog.getTotalCalories();
		assertEquals(607, totalCalories, "Total calories of all food in the foodLog is incorrect. Expected 607");
	}

}
