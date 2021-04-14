package tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import onemorerep.Bicycling;
import onemorerep.JumpingRope;
import onemorerep.Pushups;
import onemorerep.Running;
import onemorerep.Situps;
import onemorerep.Squats;
import onemorerep.Swimming;
import onemorerep.User;
import onemorerep.Walking;

class ExerciseTest {

	@Test
	void testJumpingRope() {
		User user = new User("Jing", 23, 49, 163, 2);
		JumpingRope jumpingRope = new JumpingRope("JumpingRope", 25, user);
		int caloriesBurned = (int) Math.round(jumpingRope.caloriesBurned());
		assertEquals(253, caloriesBurned, "Calories burned from JumpingRope calculation for female 1 is incorrect. Expected 253");
	}
	
	@Test
	void testRunning() {
		Running running = new Running("Running", 25);
		User user = new User("Jing", 23, 49, 163, 2);
		int caloriesBurned = (int) Math.round(running.caloriesBurned(user));
		assertEquals(210, caloriesBurned, "Calories burned from Running calculation for female 1 is incorrect. Expected 210");
	}
	
	@Test
	void testSwimming() {
		Swimming swimming = new Swimming("JumpingRope", 25);
		User user = new User("Jing", 23, 49, 163, 2);
		int caloriesBurned = (int) Math.round(swimming.caloriesBurned(user));
		assertEquals(124, caloriesBurned, "Calories burned from Swimming calculation for female 1 is incorrect. Expected 124");
	}
	
	@Test
	void testWalking() {
		Walking walking = new Walking("JumpingRope", 25);
		User user = new User("Jing", 23, 49, 163, 2);
		int caloriesBurned = (int) Math.round(walking.caloriesBurned(user));
		assertEquals(92, caloriesBurned, "Calories burned from Walking calculation for female 1 is incorrect. Expected 92");
	}

	@Test
	void testSquats() {
		Squats squats = new Squats("Squats", 25);
		User user = new User("Jing", 23, 49, 163, 2);
		int caloriesBurned = (int) Math.round(squats.caloriesBurned(user));
		assertEquals(118, caloriesBurned, "Calories burned from Squats calculation for female 1 is incorrect. Expected 118");
	}
	
	@Test
	void testPushups() {
		Pushups pushups = new Pushups("Pushups", 25);
		User user = new User("Jing", 23, 49, 163, 2);
		int caloriesBurned = (int) Math.round(pushups.caloriesBurned(user));
		assertEquals(172, caloriesBurned, "Calories burned from Pushups calculation for female 1 is incorrect. Expected 172");
	}
	
	@Test
	void testSitups() {
		Situps situps = new Situps("Situps", 25);
		User user = new User("Jing", 23, 49, 163, 2);
		int caloriesBurned = (int) Math.round(situps.caloriesBurned(user));
		assertEquals(172, caloriesBurned, "Calories burned from Situps calculation for female 1 is incorrect. Expected 172");
	}
	
	@Test
	void testBicycling() {
		Bicycling bicycling = new Bicycling("Bicycling", 25);
		User user = new User("Jing", 23, 49, 163, 2);
		int caloriesBurned = (int) Math.round(bicycling.caloriesBurned(user));
		assertEquals(150, caloriesBurned, "Calories burned from Bicycling calculation for female 1 is incorrect. Expected 150");
	}
	
}
