package view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Frame;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import controller.runProgram;
import model.Tool;

/** This page displays all your tools. It also allows access to the settings page.
 * 
 * @author chasealder
 *
 */
public class ToolBoxPage extends JFrame {
	
	JPanel panel = new JPanel();
	GridBagConstraints gbc = new GridBagConstraints();
	
	// These are all UI elements
	private JComboBox<String> tags;
	private JButton addTool;
	private JButton settings;
	
	String tagChoice;
	
	/** Constructor. Set the dimensions and add the buttons.
	 * 
	 * @author chasealder
	 * 
	 */
	public ToolBoxPage(String tagChoice) {
		
		this.tagChoice = tagChoice;
		
		panel.setLayout(new GridBagLayout());
		panel.setPreferredSize(new Dimension(1000, 500));
		
		buildPanel();
		
		this.setLayout(new BorderLayout());
		this.add(panel, BorderLayout.CENTER);
		this.pack();
		this.setVisible(true);
	}
	
	/** This adds all the functionality to the panel
	 * 
	 * @author chasealder
	 */
	public void buildPanel() {
		addTagBox();
		addNewToolButton();
		addSettingsButton();
		addToolButtons();
	}
	
	/** Creates the dropdown menu that lists all the tags
	 * 
	 * @author chasealder
	 */
	public void addTagBox() {
		gbc.insets = new Insets(0,0,0,0);
		gbc.weightx = 1;
		gbc.weighty = 1;
		gbc.gridx = 0;
		gbc.gridy = 0;
		gbc.gridwidth = 2;
		gbc.fill = GridBagConstraints.BOTH;
		
		tags = new JComboBox<String>();
		
		// Add the option for no tag choice
		tags.addItem(".DEFAULT.");
		
		// Add all existing tags (no duplicates)
		for (int i = 0; i < runProgram.getTags().size(); i++) {
			tags.addItem(runProgram.getTags().get(i));
		}
		
		// This is a temp variable so I can access the frame inside the action listener
		JFrame tempFrame = this;
		
		// This is for when they click the button
		tags.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				// Get their selection
				String s = (String) tags.getSelectedItem();
				
				// If it's default, just reload a fresh page
				if (s.contentEquals(".DEFAULT.")) {
					tempFrame.dispose();
					new ToolBoxPage("");	
				}
				
				else {
					tempFrame.dispose();
					new ToolBoxPage(s);
				}
				
			}
		});
		
		panel.add(tags,gbc);
	}
	
	/** The "add new tool" button
	 * 
	 * @author chasealder
	 */
	public void addNewToolButton() {
		gbc.insets = new Insets(0,0,0,0);
		gbc.weightx = 0.4;
		gbc.weighty = 1;
		gbc.gridx = 2;
		gbc.gridy = 0;
		gbc.gridwidth = 1;
		gbc.fill = GridBagConstraints.HORIZONTAL;
		
		addTool = new JButton("+ New Tool");
		
		// This is a temp variable so I can access the frame inside the action listener
		JFrame tempFrame = this;
		
		// Clicking this button opens up the new tool window
		addTool.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new ToolCreatePage();
				tempFrame.dispose();
			}
		});
		
		panel.add(addTool,gbc);
	}
	
	/** Takes you to the settings page
	 * 
	 * @author chasealder
	 */
	public void addSettingsButton() {
		gbc.insets = new Insets(0,0,0,0);
		gbc.weightx = 0.4;
		gbc.weighty = 1;
		gbc.gridx = 3;
		gbc.gridy = 0;
		gbc.gridwidth = 1;
		gbc.fill = GridBagConstraints.HORIZONTAL;
		
		settings = new JButton("Settings");
		
		// Clicking this button opens up the settings window
		settings.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new SettingsPopup();
			}
		});
		
		panel.add(settings,gbc);
	}
	
	/** This adds all the relevant tool buttons to the panel
	 * 
	 * @author chasealder
	 * 
	 */
	public void addToolButtons() {
		
		// This is to initialize all the buttons, and set up their action listeners
		for (int i = 0; i < runProgram.getToolbox().size(); i++) {
			
			// Only add the buttons that have the tag the user has selected (unless there is no tag selected)
			if (runProgram.getToolbox().get(i).getTags().contains(tagChoice) || tagChoice.equals("")) {
				gbc.insets = new Insets(0,0,0,0);
				gbc.weightx = 1;
				gbc.weighty = 1;
				gbc.gridx = 0;
				// y location changes with each button added
				gbc.gridy = 1 + i;
				gbc.gridwidth = 4;
				gbc.fill = GridBagConstraints.BOTH;
				
				// Read the relevant information
				String toolName = runProgram.getToolbox().get(i).getName();
				String toolSerial = runProgram.getToolbox().get(i).getSerial();
				
				// Make the button with it's name
				JButton newButton = new JButton(toolName);
				
				// This must be final for the action listener I guess?
				final int passIn = i;
				
				JFrame tempFrame = this;
				
				// Dispose of the old page and refresh it if the user selects a tag
				newButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						tempFrame.dispose();
						new ToolPage(runProgram.getToolbox().get(passIn));
					}
				});
				
				// Add the button
				panel.add(newButton,gbc);
			}
		}
	}
}
