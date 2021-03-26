package tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import onemorerep.User;

class UserTest {

	@Test
	void testUserBMR() {
		User user = new User("Jing", 23, 49, 163, 2);
		int bmr = user.calculateBMR();
		assertEquals(1233, bmr);
	}

}
