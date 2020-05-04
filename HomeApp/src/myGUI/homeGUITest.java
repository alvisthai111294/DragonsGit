package myGUI;

import static org.junit.jupiter.api.Assertions.*;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;

import org.junit.Before;
import org.junit.jupiter.api.Test;

class homeGUITest {
	private JFrame frame;

	public homeGUITest() {
		frame = new JFrame();
		frame.setBounds(100, 100, 800, 600);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
	}

	/**
	 * This is used to test the version getters/setters
	 * 
	 * @author Chase Alder
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

	@Test
	void testHomeGUI() {
		fail("Not yet implemented");
	}

	@Test
	void testMain() {
		fail("Not yet implemented");
	}

	@Test
	void testMainFrame() {
		fail("Not yet implemented");
	}

	@Test
	void testAboutButton() {
		fail("Not yet implemented");
	}

	@Test
	void testSearchTextField() {
		String inputTest;
		String expResult;

		homeGUI tester = new homeGUI();

		frame = new JFrame();
		frame.setVisible(true);

		inputTest = tester.searchTextField("This is a test");

		assertNotNull("This is a test", inputTest);
	}

	@Test
	void testSearchButton() {
		fail("Not yet implemented");
	}

	@Test
	void testUserProfileButton() {
		fail("Not yet implemented");
	}

	@Test
	void testPhotoButton() {
		fail("Not yet implemented");
	}

	@Test
	void testYouOwnTextField() {
		fail("Not yet implemented");
	}

	@Test
	void testYesCheckBox() {
		fail("Not yet implemented");
	}

	@Test
	void testNoCheckBox() {
		fail("Not yet implemented");
	}

	@Test
	void testAddToolBoxButton() {
		fail("Not yet implemented");
	}

	@Test
	void testLinkToMenus() {
		fail("Not yet implemented");
	}

	@Test
	void testGeneralNotes() {
		fail("Not yet implemented");
	}

	@Test
	void testGeneralLabel() {
		fail("Not yet implemented");
	}

	@Test
	void testInitialize() {
		fail("Not yet implemented");
	}

	@Test
	void testGetVersion() {
		fail("Not yet implemented");
	}

	@Test
	void testSetVersion() {
		fail("Not yet implemented");
	}

}
