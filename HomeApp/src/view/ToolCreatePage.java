package view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Frame;
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
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import controller.runProgram;
import model.*;

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
	
	// These are for updating the different attachments
	ArrayList<ToolFile> fileArr = new ArrayList<ToolFile>();
	ArrayList<ToolLink> linkArr = new ArrayList<ToolLink>();
	ArrayList<ToolReminder> reminderArr = new ArrayList<ToolReminder>();
	
	// This tells the program whether this window was created to edit an existing tool
	boolean editPage = false;
	Tool editTool;
	
	/** Constructor. Sets the dimensions and loads all the buttons.
	 * 
	 * @author chasealder
	 */
	public ToolCreatePage() {
		
		panel.setLayout(new GridBagLayout());
		panel.setPreferredSize(new Dimension(1000, 500));
		
		// Add all the buttons and functionality
		buildPanel();
		
		this.setLayout(new BorderLayout());
		this.add(panel, BorderLayout.CENTER);
		this.pack();
		this.setVisible(true);
	}
	
	/** This constructor is used for editing an existing tool
	 * 
	 * @author chasealder
	 * 
	 * @param toolToEdit is the tool you will be editing
	 */
	public ToolCreatePage(Tool toolToEdit) {
		
		editPage = true;
		
		panel.setLayout(new GridBagLayout());
		panel.setPreferredSize(new Dimension(1000, 500));
		
		// Add all the buttons and functionality
		buildPanel();
		
		// This is updating the fields with the tool to be edited's information
		this.editTool = toolToEdit;
		name.setText(editTool.getName());
		serial.setText(editTool.getSerial());
		fileArr = editTool.getFiles();
		linkArr = editTool.getLinks();
		reminderArr = editTool.getReminders();
		
		// Update the tags in the box
		String tagText = "";
		
		for (int i = 0; i < editTool.getTags().size(); i++) {
			tagText += editTool.getTags().get(i);
			
			// If it's the last tag, don't put the comma ;)
			if (i != editTool.getTags().size()-1) {
				tagText += ", ";
			}
		}
		
		tags.setText(tagText);
		
		this.setLayout(new BorderLayout());
		this.add(panel, BorderLayout.CENTER);
		this.pack();
		this.setVisible(true);
		
	}
	
	/** This adds all the buttons and functionality to the panel
	 * 
	 * @author chasealder
	 */
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
		
		tags = new JTextField("(ADD TAGS COMMA SEPARATED)");
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
		
		// This opens two dialog windows that take two relevant pieces of data from the user. Then an object is constructed and 
		// added to the file array.
		files.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String label = (String)JOptionPane.showInputDialog(new Frame(),"What is the file's label?","File attachments", JOptionPane.PLAIN_MESSAGE,null, null, null);
				String path = (String)JOptionPane.showInputDialog(new Frame(),"What is the file's path?","File attachments", JOptionPane.PLAIN_MESSAGE,null, null, null);
				
				fileArr.add(new ToolFile(label,path));
			}
		});
		
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
		
		// This opens two dialog windows that take two relevant pieces of data from the user. Then an object is constructed and 
		// added to the links array.
		links.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String label = (String)JOptionPane.showInputDialog(new Frame(),"What is the links label?","File attachments", JOptionPane.PLAIN_MESSAGE,null, null, null);
				String link = (String)JOptionPane.showInputDialog(new Frame(),"What is the links URL?","File attachments", JOptionPane.PLAIN_MESSAGE,null, null, null);
				
				linkArr.add(new ToolLink(label,link));
			}
		});
		
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
		
		// This opens two dialog windows that take two relevant pieces of data from the user. Then an object is constructed and 
		// added to the reminders array.
		reminders.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String date = (String)JOptionPane.showInputDialog(new Frame(),"What is the reminders date? (MM/DD/YYYY)","File attachments", JOptionPane.PLAIN_MESSAGE,null, null, null);
				String notes = (String)JOptionPane.showInputDialog(new Frame(),"What is are the details of the reminder?","File attachments", JOptionPane.PLAIN_MESSAGE,null, null, null);
				
				reminderArr.add(new ToolReminder(date,notes));
			}
		});
		
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
				
				// Split the tags on each comma
				for (String tag : tagText.split(",")) {
					riTags.add(tag.trim());
				}
				
				// This is for deleting the old copy if this is an edit of an existing tool
				if (editPage == true) {
					runProgram.getToolbox().remove(editTool);
				}
				
				Tool newTool = new Tool(name.getText(),serial.getText(),riTags,linkArr,fileArr,reminderArr);
				runProgram.getToolbox().add(newTool);
				runProgram.updateTags();
				
				new ToolBoxPage("");
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
				new ToolBoxPage("");
				tempFrame.dispose();
			}
		});
		
		panel.add(discard,gbc);
	}
}
