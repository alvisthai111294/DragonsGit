package view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import controller.runProgram;
import model.Tool;

/** This is the page that you see after picking a tool from your toolbox.
 * 
 * @author chasealder
 *
 */
public class ToolCreatePage extends JFrame {
	
	JPanel panel = new JPanel();
	GridBagConstraints gbc = new GridBagConstraints();
	
	// All buttons
	JButton goBack;
	JButton files;
	JButton links;
	JButton reminders;
	JButton save;
	JButton discard;
	
	// Informational fields
	JTextField name;
	JTextField serial;
	JTextField tags;
	
	/** Constructor. Sets the dimensions and loads all the buttons.
	 * 
	 * @author chasealder
	 */
	public ToolCreatePage() {
		
		panel.setLayout(new GridBagLayout());
		panel.setPreferredSize(new Dimension(1000, 500));
		
		buildPanel();
		
		this.setLayout(new BorderLayout());
		this.add(panel, BorderLayout.CENTER);
		this.pack();
		this.setVisible(true);
	}
	
	public void buildPanel() {
		addNameLabel();
		addSerialLabel();
		addTagsLabel();
		addFilesButton();
		addLinksButton();
		addRemindersButton();
		addSaveButton();
		addDiscardButton();
	}
	
	/** Creates the name box
	 * 
	 * @author chasealder
	 */
	public void addNameLabel() {
		gbc.insets = new Insets(0,200,0,200);
		gbc.weightx = 1;
		gbc.weighty = 1;
		gbc.gridx = 0;
		gbc.gridy = 1;
		gbc.gridwidth = 2;
		gbc.fill = GridBagConstraints.BOTH;
		
		name = new JTextField("(NAME)");
		panel.add(name,gbc);
	}
	
	/** Creates the serial number box
	 * 
	 * @author chasealder
	 */
	public void addSerialLabel() {
		gbc.insets = new Insets(0,200,0,200);
		gbc.weightx = 1;
		gbc.weighty = 1;
		gbc.gridx = 0;
		gbc.gridy = 2;
		gbc.gridwidth = 2;
		gbc.fill = GridBagConstraints.BOTH;
		
		serial = new JTextField("(SERIAL NUMBER)");
		panel.add(serial,gbc);
	}
	
	/** Creates the tags box
	 * 
	 * @author chasealder
	 */
	public void addTagsLabel() {
		gbc.insets = new Insets(0,200,0,200);
		gbc.weightx = 1;
		gbc.weighty = 1;
		gbc.gridx = 0;
		gbc.gridy = 3;
		gbc.gridwidth = 2;
		gbc.fill = GridBagConstraints.BOTH;
		
		tags = new JTextField("(ADD TAGS COMMA SEPARATED (NO SPACES))");
		panel.add(tags,gbc);
	}
	
	/** Creates the add files button
	 * 
	 * @author chasealder
	 */
	public void addFilesButton() {
		gbc.insets = new Insets(0,0,0,0);
		gbc.weightx = 1;
		gbc.weighty = 1;
		gbc.gridx = 0;
		gbc.gridy = 4;
		gbc.gridwidth = 2;
		gbc.fill = GridBagConstraints.BOTH;
		
		files = new JButton("Add Files");
		panel.add(files,gbc);
	}
	
	/** Creates the add links button
	 * 
	 * @author chasealder
	 */
	public void addLinksButton() {
		gbc.insets = new Insets(0,0,0,0);
		gbc.weightx = 1;
		gbc.weighty = 1;
		gbc.gridx = 0;
		gbc.gridy = 5;
		gbc.gridwidth = 2;
		gbc.fill = GridBagConstraints.BOTH;
		
		links = new JButton("Add Links");
		panel.add(links,gbc);
	}
	
	/** Creates the add reminders button
	 * 
	 * @author chasealder
	 */
	public void addRemindersButton() {
		gbc.insets = new Insets(0,0,0,0);
		gbc.weightx = 1;
		gbc.weighty = 1;
		gbc.gridx = 0;
		gbc.gridy = 6;
		gbc.gridwidth = 2;
		gbc.fill = GridBagConstraints.BOTH;
		
		reminders = new JButton("Add Reminders");
		panel.add(reminders,gbc);
	}
	
	/** Creates the edit button
	 * 
	 * @author chasealder
	 */
	public void addSaveButton() {
		gbc.insets = new Insets(0,0,0,0);
		gbc.weightx = 1;
		gbc.weighty = 1;
		gbc.gridx = 0;
		gbc.gridy = 7;
		gbc.gridwidth = 1;
		gbc.fill = GridBagConstraints.BOTH;
		
		save = new JButton("SAVE");
		
		// This is a temp variable so I can access the frame inside the action listener
		JFrame tempFrame = this;
		
		save.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				// Get the tags
				String tagText = tags.getText();
				ArrayList<String> riTags = new ArrayList<String>();
				
				for (String tag : tagText.split(",")) {
					riTags.add(tag.trim());
				}
				
				
				Tool newTool = new Tool(name.getText(),serial.getText(),riTags);
				runProgram.getToolbox().add(newTool);
				new ToolBoxPage();
				tempFrame.dispose();
			}
		});
		
		panel.add(save, gbc);
	}
	
	/** Creates the discard button
	 * 
	 * @author chasealder
	 */
	public void addDiscardButton() {
		gbc.insets = new Insets(0,0,0,0);
		gbc.weightx = 1;
		gbc.weighty = 1;
		gbc.gridx = 1;
		gbc.gridy = 7;
		gbc.gridwidth = 1;
		gbc.fill = GridBagConstraints.BOTH;
		
		discard = new JButton("DISCARD");
		
		// This is a temp variable so I can access the frame inside the action listener
		JFrame tempFrame = this;
		
		// This closes this window and reopens the toolbox
		discard.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new ToolBoxPage();
				tempFrame.dispose();
			}
		});
		
		panel.add(discard,gbc);
	}
}
