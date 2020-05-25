package view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

import javax.swing.*;

import controller.runProgram;


/** This is a popup window you can access from the Toolbox page. It contains the user's name and email, which can both
 * be changed via the "update" button. It also allows the user to see the 'about' page, as well as import and export
 * your data (currently just your name and email).
 * 
 * @author chasealder
 *
 */
public class SettingsPopup extends JFrame {
	
	JPanel panel = new JPanel();
	GridBagConstraints gbc = new GridBagConstraints();
	
	// These are here because they need to be accessible by the "update" button
	JTextField userEmail;
	JTextField userName;
	
	/** Creates the settings window
	 * 
	 * @author chasealder
	 */
	public SettingsPopup() {
		panel.setLayout(new GridBagLayout());
		panel.setPreferredSize(new Dimension(500, 250));
		
		buildPanel();
		
		this.setLayout(new BorderLayout());
		this.add(panel, BorderLayout.CENTER);
		this.pack();
		this.setVisible(true);
	}
	
	/** Adds all the elements to the panel
	 * 
	 * @author chasealder
	 */
	public void buildPanel() {
		addName();
		addEmail();
		addUpdateButton();
		addImportButton();
		addSaveButton();
		addExportButton();
		addAboutButton();
	}
	
	/** Adds the name label and box
	 * 
	 * @author chasealder
	 */
	public void addName() {
		
		// This is for the "Name: " label
		gbc.insets = new Insets(0,50,0,0);
		gbc.weightx = 1;
		gbc.weighty = 1;
		gbc.gridx = 0;
		gbc.gridy = 0;
		gbc.gridwidth = 1;
		gbc.fill = GridBagConstraints.HORIZONTAL;
		
		JLabel name = new JLabel("Name: ");
		panel.add(name,gbc);
		
		// This is for the userName text field
		gbc.insets = new Insets(0,0,0,50);
		gbc.weightx = 1;
		gbc.weighty = 1;
		gbc.gridx = 1;
		gbc.gridy = 0;
		gbc.gridwidth = 2;
		gbc.fill = GridBagConstraints.HORIZONTAL;
		
		userName = new JTextField(runProgram.getName());
		panel.add(userName,gbc);
	}
	
	/** Adds the email label and box
	 * 
	 * @author chasealder
	 */
	public void addEmail() {
		
		// This is for the "Email: " label
		gbc.insets = new Insets(0,50,0,0);
		gbc.weightx = 1;
		gbc.weighty = 1;
		gbc.gridx = 0;
		gbc.gridy = 1;
		gbc.gridwidth = 1;
		gbc.fill = GridBagConstraints.HORIZONTAL;
		
		JLabel email = new JLabel("Email: ");
		panel.add(email,gbc);
		
		// This is for the userEmail text field
		gbc.insets = new Insets(0,0,0,50);
		gbc.weightx = 1;
		gbc.weighty = 1;
		gbc.gridx = 1;
		gbc.gridy = 1;
		gbc.gridwidth = 2;
		gbc.fill = GridBagConstraints.HORIZONTAL;
		
		userEmail = new JTextField(runProgram.getEmail());
		panel.add(userEmail,gbc);
	}
	
	/** This button updates the name/email to what is currently in the boxes.
	 * 
	 * @author chasealder
	 */
	public void addUpdateButton() {
		gbc.insets = new Insets(0,0,0,0);
		gbc.weightx = 1;
		gbc.weighty = 1;
		gbc.gridx = 3;
		gbc.gridy = 0;
		gbc.gridwidth = 1;
		gbc.gridheight = 2;
		gbc.fill = GridBagConstraints.BOTH;
		
		JButton update = new JButton("UPDATE");
		
		// If this button is clicked, make a new user with what is in the boxes currently and update the main User.
		update.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				runProgram.setUser(userName.getText(), userEmail.getText());
			}
		});
		
		panel.add(update,gbc);
	}
	
	/** This is used to import user data from a file into the program. Reads from an exported file.
	 * 
	 * @author chasealder
	 */
	public void addImportButton() {
		gbc.insets = new Insets(0,0,0,0);
		gbc.weightx = 1;
		gbc.weighty = 1;
		gbc.gridx = 0;
		gbc.gridy = 2;
		gbc.gridwidth = 1;
		gbc.gridheight = 1;
		gbc.fill = GridBagConstraints.BOTH;
		
		JButton importButton = new JButton("IMPORT");
		
		importButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFileChooser jfc = new JFileChooser();
				jfc.setCurrentDirectory(new File(System.getProperty("user.home")));
				int result = jfc.showOpenDialog(panel);
				
				// If the user clicks the final "open" button
				if (result == JFileChooser.APPROVE_OPTION) {
					
					// Pass it to the import function
					runProgram.importData(jfc.getSelectedFile());
					
					// Update the window
					userName.setText(runProgram.getName());
					userEmail.setText(runProgram.getEmail());
				}
			}
		});
		
		panel.add(importButton,gbc);
	}
	
	/** This may be useless. Used to save the current user data to your current user file.
	 * 
	 * @author chasealder
	 */
	public void addSaveButton() {
		gbc.insets = new Insets(0,0,0,0);
		gbc.weightx = 1;
		gbc.weighty = 1;
		gbc.gridx = 1;
		gbc.gridy = 2;
		gbc.gridwidth = 1;
		gbc.gridheight = 1;
		gbc.fill = GridBagConstraints.BOTH;
		
		JButton saveButton = new JButton("SAVE TO FILE");	
		panel.add(saveButton,gbc);
	}
	
	/** Adds the export button to the panel. Used to export user data to a text file.
	 * 
	 * @author chasealder
	 */
	public void addExportButton() {
		gbc.insets = new Insets(0,0,0,0);
		gbc.weightx = 1;
		gbc.weighty = 1;
		gbc.gridx = 2;
		gbc.gridy = 2;
		gbc.gridwidth = 1;
		gbc.gridheight = 1;
		gbc.fill = GridBagConstraints.BOTH;
		
		JButton exportButton = new JButton("EXPORT");
		
		exportButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFileChooser jfc = new JFileChooser();
				jfc.setCurrentDirectory(new File(System.getProperty("user.home")));
				int result = jfc.showSaveDialog(panel);
				
				// If the user clicks the final "save" button
				if (result == JFileChooser.APPROVE_OPTION) {
					
					// Make a file object
					File exportFile = jfc.getSelectedFile();
					
					// Make a filewriter and write the user/email to the file
					try {
						FileWriter fw = new FileWriter(exportFile.getPath());
						fw.write(runProgram.exportData());
						fw.flush();
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
			}
		});
		
		panel.add(exportButton,gbc);
	}
	
	/** Adds the about button. Displays version info and team info
	 * 
	 * @author chasealder
	 */
	public void addAboutButton() {
		gbc.insets = new Insets(0,0,0,0);
		gbc.weightx = 1;
		gbc.weighty = 1;
		gbc.gridx = 3;
		gbc.gridy = 2;
		gbc.gridwidth = 1;
		gbc.gridheight = 1;
		gbc.fill = GridBagConstraints.BOTH;
		
		JButton about = new JButton("ABOUT");
		
		about.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, " Dragon Group About Box\n Home Application Ver " + "2.0"
						+ "\n Copyright @ 2020, UW Tacoma ", "About Us", JOptionPane.INFORMATION_MESSAGE);
			}
		});
		
		panel.add(about,gbc);
	}
}