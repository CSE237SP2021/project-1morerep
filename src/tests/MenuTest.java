package tests;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;

import org.junit.jupiter.api.Test;

import onemorerep.Menu;

class MenuTest {

	@Test
	void testMenu() {
		Menu menu = new Menu("I'm a test menu.", Arrays.asList("Option1", "Option2"), null);
		assertEquals("I'm a test menu.", menu.getMessage());
		int numberOfOptions = menu.getNumberOfOptions();
		assertEquals(2, numberOfOptions, "Number of options for the test menu is incorrect. Expected 2");
	}

}
