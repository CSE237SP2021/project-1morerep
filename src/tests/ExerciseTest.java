package tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import onemorerep.JumpingRope;
import onemorerep.Running;
import onemorerep.Swimming;
import onemorerep.User;
import onemorerep.Walking;

class ExerciseTest {

	@Test
	void testJumpingRope() {
		JumpingRope jumpingRope = new JumpingRope("JumpingRope", 25);
		User user = new User("Jing", 23, 49, 163, 2);
		int caloriesBurned = (int) Math.round(jumpingRope.caloriesBurned(user));
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

}
