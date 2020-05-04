package myGUI;

import static org.junit.jupiter.api.Assertions.*;

import java.awt.FlowLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;

import javax.swing.border.EmptyBorder;

import org.junit.jupiter.api.Test;

class homeGUITest {
	/**
	 * Sample JFrame test.
	 */
	private JFrame frame;
	/**
	 * Sample JPanel test
	 */
	private JPanel pane;
	/**
	 * HomeGUI object for testing. Get the method thru this component.
	 */
	private homeGUI tester = new homeGUI();

	/**
	 * Set up a frame first
	 */
	protected void setUp() {
		// Create a frame with the test instance name as the title
		frame = new JFrame();
		pane = (JPanel) frame.getContentPane();
		pane.setLayout(new FlowLayout());
		pane.setBorder(new EmptyBorder(50, 50, 50, 50));

	}

	// Tear down the frame.
	protected void tearDown() {
		if (this.frame != null) {
			this.frame.dispose();
			this.frame = null;
		}
	}

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
	void testMainFrame() {
		fail("Not yet implemented");
	}

	@Test
	void testAboutButton() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for search test. Test passing a string through non interface
	 * environment .
	 */
	@Test
	void testSearchTextField() {
		String inputTest;

		frame = new JFrame();
		frame.setVisible(true);

		inputTest = tester.searchTextField("This is a test");
		// Check that you actually have access to your target components.
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

}
