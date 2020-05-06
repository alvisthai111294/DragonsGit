package myGUI;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JButton;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.JCheckBox;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import tools.Tools;

import javax.swing.JLabel;

public class homeGUI {

	private JFrame frame;
	private JTextField searchTextField;
	private JButton userProfilButton;
	private JButton photoButton;
	private JTextField urOwnTextField;
	private double version = 1.0;

	/**
	 * Create the application.
	 */
	public homeGUI() {
		initialize();
	}

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {

			public void run() {
				setLookAndFeel();
				try {
					homeGUI window = new homeGUI();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Set the look and feel for the GUI program.
	 */
	private static void setLookAndFeel() {

		try {

			UIManager.setLookAndFeel("javax.swing.plaf.metal.MetalLookAndFeel");
			/* Turn off metal's use of bold fonts */
			UIManager.put("swing.boldMetal", Boolean.FALSE);

		} catch (final UnsupportedLookAndFeelException e) {
			System.out.println("UnsupportedLookAndFeelException");
		} catch (final ClassNotFoundException e) {
			System.out.println("ClassNotFoundException");
		} catch (final InstantiationException e) {
			System.out.println("InstantiationException");
		} catch (final IllegalAccessException e) {
			System.out.println("IllegalAccessException");
		}

	}

	/**
	 * Create new JFrame for main frame.
	 */
	public void mainFrame() {
		// Create main frame
		frame = new JFrame();
		frame.setBounds(100, 100, 800, 600);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

	}

	/**
	 * Create about button and add action listener.
	 */
	public void aboutButton() {
		// Create about button
		JButton aboutButton = new JButton("About Us");
		aboutButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, " Dragon Group About Box\n Home Application Ver " + getVersion()
						+ "\n Copyright @ 2020, UW Tacoma ", "About Us", JOptionPane.INFORMATION_MESSAGE);

			}
		});
		aboutButton.setFont(new Font("Tahoma", Font.PLAIN, 17));
		aboutButton.setBounds(0, 502, 120, 61);

		// Add About button to the frame
		frame.getContentPane().add(aboutButton);
	}

	/**
	 * Create a search text field, takes string input
	 */
	public String searchTextField(String input) {
		// Create a new search text field and set values
		searchTextField = new JTextField();
		searchTextField.setBounds(10, 10, 381, 35);

		// Add TextField to the frame
		frame.getContentPane().add(searchTextField);
		searchTextField.setColumns(10);

		return input;
	}

	/**
	 * Create search button. I need support and advice on this method. I dont know
	 * what to do with its structure yet.
	 */
	public void searchButton() {

		// Create search button
		JButton searchButton = new JButton("Search");

		// Add action listener on search button
		searchButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {

			}
		});
		searchButton.setFont(new Font("Tahoma", Font.PLAIN, 17));
		searchButton.setBounds(401, 10, 104, 35);

		// Adding the search button to the main frame
		frame.getContentPane().add(searchButton);
	}

	/**
	 * Create user profile. Waiting for future class support.
	 */
	public void userProfileButton() {
		// Create a User Profile button
		userProfilButton = new JButton("User Profile");
		userProfilButton.setFont(new Font("Tahoma", Font.PLAIN, 17));
		userProfilButton.setBounds(515, 10, 271, 35);

		// Add user profile button to main frame
		frame.getContentPane().add(userProfilButton);
	}

	/**
	 * Create photoButton. Waiting for future class development.
	 */
	public void photoButton() {

		// Create a photo button
		photoButton = new JButton("Photo");
		photoButton.setFont(new Font("Tahoma", Font.PLAIN, 17));
		photoButton.setBounds(10, 68, 244, 123);

		// Add photo button to the main frame
		frame.getContentPane().add(photoButton);
	}

	/**
	 * Create a text field and and to frame.
	 */
	public void youOwnTextField() {

		// Create your own text field
		urOwnTextField = new JTextField();
		urOwnTextField.setFont(new Font("Tahoma", Font.PLAIN, 17));
		urOwnTextField.setText("You own? (Y/N)");
		urOwnTextField.setBounds(10, 201, 134, 100);

		// Add your own text field to the panel
		frame.getContentPane().add(urOwnTextField);
		urOwnTextField.setColumns(10);
	}

	/**
	 * Create a check box return boolean. Boolean helps with controls for future
	 * implementation
	 * 
	 * @return condition return statement.
	 */
	public boolean checkBoxex(boolean check) {

		// Create Yes check box
		JRadioButton yesCheckBox = new JRadioButton("Yes");
		yesCheckBox.setFont(new Font("Tahoma", Font.PLAIN, 16));
		yesCheckBox.setBounds(150, 232, 95, 21);

		// Create no check box
		JRadioButton noCheckBox = new JRadioButton("No");
		noCheckBox.setFont(new Font("Tahoma", Font.PLAIN, 16));
		noCheckBox.setBounds(150, 255, 95, 21);

		// Add Yes check box to the panel
		frame.getContentPane().add(yesCheckBox);

		// Add no check box to the panel
		frame.getContentPane().add(noCheckBox);

		// This is false by default because I haven't add a tracker yet.
		return false;

	}

	/**
	 * Keep track if yes and no box is checked or not.
	 * 
	 * @return boolean indicate yes and no check box condition
	 */
	public boolean isChecked() {

		return false;
	}

	/**
	 * Create an add tool box button.
	 * 
	 * We I'm trying to do with this button is when it is clicked, it should create
	 * a new Object Tools and we can add it to some type of array too. Pretty much
	 * just laying down a path for future development. Nick
	 * 
	 * @param houseTool
	 * @return a house tool that the customer want to add.
	 */
	public Tools addToolBoxButton(Tools houseTool) {
		// Create add to your tool box button
		JButton addToolboxButton = new JButton("Add to your toolbox");
		addToolboxButton.setFont(new Font("Tahoma", Font.PLAIN, 17));
		addToolboxButton.setBounds(10, 326, 244, 51);
		// Add the add tool box button to the panel
		frame.getContentPane().add(addToolboxButton);

		return houseTool;
	}

	public void linkToMenus() {

		// Create user menu button
		JButton userMenuButton = new JButton("Link To User Manual");
		userMenuButton.setFont(new Font("Tahoma", Font.PLAIN, 17));
		userMenuButton.setBounds(264, 324, 238 , 51);
		// Add user menu button to the panel
		frame.getContentPane().add(userMenuButton);

		// Create link to measurement button
		JButton meansurementButton = new JButton("Link To Measurements");
		meansurementButton.setFont(new Font("Tahoma", Font.PLAIN, 17));
		meansurementButton.setBounds(264, 263, 238, 51);
		// Add measurement button to the panel
		frame.getContentPane().add(meansurementButton);

		JButton warrantyInfoButton = new JButton("Link To Warranty Info");

		// Add action listener to warranty button
		warrantyInfoButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		warrantyInfoButton.setFont(new Font("Tahoma", Font.PLAIN, 17));
		warrantyInfoButton.setBounds(264, 202, 238, 51);

		// Add warranty button to the panel
		frame.getContentPane().add(warrantyInfoButton);
	}

	/**
	 * This class create Jbutton for the notes. I'm leaving it as a void method for
	 * now. We will develop a separate class for the note later.
	 */
	public void generalNotes() {

		// Create warranty note button
		JButton warrantyNoteButton = new JButton("Warranty Notes");
		warrantyNoteButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		warrantyNoteButton.setFont(new Font("Tahoma", Font.PLAIN, 17));
		warrantyNoteButton.setBounds(538, 202, 238, 51);
		// Add warranty button note to the main frame
		frame.getContentPane().add(warrantyNoteButton);

		// Create measurement note button
		JButton measurementNoteButton = new JButton("Measurement Notes");
		measurementNoteButton.setFont(new Font("Tahoma", Font.PLAIN, 17));
		measurementNoteButton.setBounds(538, 263, 238, 51);
		// Add measurement note button to the panel
		frame.getContentPane().add(measurementNoteButton);

		// Create user manual button
		JButton userManualButton = new JButton("User Manual Notes");
		userManualButton.setFont(new Font("Tahoma", Font.PLAIN, 17));
		userManualButton.setBounds(538, 326, 238, 51);
		// Add user manual button to the panel
		frame.getContentPane().add(userManualButton);

		// Create general note button
		JButton generalNoteButton = new JButton("General Notes");
		generalNoteButton.setFont(new Font("Tahoma", Font.PLAIN, 17));
		generalNoteButton.setBounds(401, 400, 238, 51);
		// Add general note button to the frame
		frame.getContentPane().add(generalNoteButton);
	}

	/**
	 * This method create our labels and add it to the main frame. Waiting for Note
	 * class to be developed later.
	 */
	public void generalLabel() {

		// Create new item brand label
		JLabel itemBrandLabel = new JLabel("\tItem Name/ Brand Name");
		itemBrandLabel.setFont(new Font("Tahoma", Font.PLAIN, 17));
		itemBrandLabel.setBounds(365, 64, 222, 68);
		// Add item label to the panel
		frame.getContentPane().add(itemBrandLabel);

		// Create new serial panel
		JLabel serialPanel = new JLabel("Serial#");
		serialPanel.setFont(new Font("Tahoma", Font.PLAIN, 17));
		serialPanel.setBounds(365, 126, 222, 68);
		// Add serial panel to the main frame
		frame.getContentPane().add(serialPanel);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	public void initialize() {
		mainFrame();
		aboutButton();
		searchTextField(null);
		searchButton();
		userProfileButton();
		photoButton();
		youOwnTextField();
		
		//The problem with this is that we still can check 2 boxex at the same time.
		checkBoxex(true);

		// This add tool should take a Tools object. We are leaving this as null for
		// future development. Nick
		addToolBoxButton(null);
		linkToMenus();
		generalLabel();
		generalNotes();

	}

	/**
	 * Getter for the version variable (used in the about page)
	 * 
	 * @author Chase Alder
	 * @return the current version value
	 */
	public double getVersion() {
		return version;
	}

	/**
	 * Used to set the version. Does not accept a negative number.
	 * 
	 * @author Chase Alder
	 * @param ver The value that you wish to set the version to
	 */
	public void setVersion(double ver) {

		// Make sure the version is positive before changing
		if (ver > 0.0)
			version = ver;
	}
}
