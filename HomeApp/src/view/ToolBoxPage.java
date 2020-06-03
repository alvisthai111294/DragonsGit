package view;

import java.awt.BorderLayout;
import java.awt.Dimension;
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
	private String chosenTag = "";
	private JButton addTool;
	private JButton settings;
	
	/** Constructor. Set the dimensions and add the buttons.
	 * 
	 * @author chasealder
	 * 
	 */
	public ToolBoxPage() {
		
		panel.setLayout(new GridBagLayout());
		panel.setPreferredSize(new Dimension(1000, 500));
		
		buildPanel();
		
		this.setLayout(new BorderLayout());
		this.add(panel, BorderLayout.CENTER);
		this.pack();
		this.setVisible(true);
	}
	
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
		
		for (int i = 0; i < runProgram.getTags().size(); i++) {
			tags.addItem(runProgram.getTags().get(i));
		}
		
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
	
	/** This method is going to add buttons for all the tools through some type of loop
	 * Currently has one placeholder tool.
	 * 
	 * 
	 */
	public void addToolButtons() {
		
		// This is to initialize all the buttons, and set up their action listeners
		for (int i = 0; i < runProgram.getToolbox().size(); i++) {
			
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
			
			newButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					tempFrame.dispose();
					new ToolPage(runProgram.getToolbox().get(passIn));
				}
			});
			
			// This is where you test for the tag. Not yet implemented
			if (chosenTag.equals("")) {
				panel.add(newButton,gbc);
			}
		}
	}
}
