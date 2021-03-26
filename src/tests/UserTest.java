package tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import onemorerep.User;

class UserTest {

	/*
	 * BMR calculation
	 */
	@Test
	void testUserBMRFemale1() {
		User user = new User("Jing", 23, 49, 163, 2);
		int bmr = user.calculateBMR();
		assertEquals(1233, bmr, "BMR calculation for female 1 is incorrect. Expected 1233");
	}
	
	@Test
	void testUserBMRFemale2() {
		User user = new User("Maria", 80, 113.4, 162.56, 2);
		int bmr = user.calculateBMR();
		assertEquals(1589, bmr, "BMR calculation for female 2 is incorrect. Expected 1589");
	}
	
	@Test
	void testUserBMRMale1() {
		User user = new User("Shook", 40, 72.6, 182.8, 1);
		int bmr = user.calculateBMR();
		assertEquals(1674, bmr, "BMR calculation for male 1 is incorrect. Expected 1674");
	}
	
	@Test
	void testUserBMRMale2() {
		User user = new User("Arnold Schwarzenegger", 73, 106, 188, 1);
		int bmr = user.calculateBMR();
		assertEquals(1875, bmr, "BMR calculation for male 2 is incorrect. Expected 1875");
	}
	
	
	
}
