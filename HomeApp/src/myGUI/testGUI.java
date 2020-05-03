package myGUI;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class testGUI {

	
	/*
	 * This is used to test the version getters/setters
	 * 
	 */
	@Test
	void testVersion() {
		homeGUI gui = new homeGUI();
		
		// Make sure that setting a normal version works
		gui.setVersion(5.0);
		assertTrue(gui.getVersion() == 5.0);
		
		// Make sure that trying to set a negative number doesn't change the version
		gui.setVersion(-5.0);
		assertTrue(gui.getVersion() == 5.0);
	}
	
	@BeforeEach
	void setUp() throws Exception {
		System.out.println("setting up...");
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	void testMain() {
		fail("Not yet implemented");
	}

	@Test
	void testHomeGUI() {
		fail("Not yet implemented");
	}

}
