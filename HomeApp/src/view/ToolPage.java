package view;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Frame;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import controller.runProgram;
import model.Tool;
import model.ToolFile;
import model.ToolLink;
import model.ToolReminder;

/** This is the page that you see after picking a tool from your toolbox.
 * 
 * @author chasealder
 *
 */
public class ToolPage extends JFrame {
	
	JPanel panel = new JPanel();
	GridBagConstraints gbc = new GridBagConstraints();
	
	// All buttons
	JButton goBack;
	JButton files;
	JButton links;
	JButton reminders;
	JButton edit;
	JButton delete;
	
	// Informational fields
	JLabel name;
	JLabel serial;
	JLabel tags;
	
	// This is the tool object that all data is taken from
	Tool tool;
	
	/** Constructor. Sets the dimensions and loads all the buttons.
	 * 
	 * @author chasealder
	 */
	public ToolPage(Tool piTool) {
		
		tool = piTool;
		
		panel.setLayout(new GridBagLayout());
		panel.setPreferredSize(new Dimension(1000, 500));
		
		buildPanel();
		
		this.setLayout(new BorderLayout());
		this.add(panel, BorderLayout.CENTER);
		this.pack();
		this.setVisible(true);
	}
	
	/** Adds all functionality to the panel
	 * 
	 * @author chasealder
	 */
	public void buildPanel() {
		addGoBackButton();
		addNameLabel();
		addSerialLabel();
		addTagsLabel();
		addFilesButton();
		addLinksButton();
		addRemindersButton();
		addEditButton();
		addDeleteButton();
	}
	
	/** Creates the "back to toolbox" button
	 * 
	 * @author chasealder
	 */
	public void addGoBackButton() {
		gbc.insets = new Insets(0,0,0,0);
		gbc.weightx = 1;
		gbc.weighty = 1;
		gbc.gridx = 0;
		gbc.gridy = 0;
		gbc.gridwidth = 2;
		gbc.fill = GridBagConstraints.BOTH;
		
		goBack = new JButton("Back to Toolbox");
		
		// This is a temp variable so I can access the frame inside the action listener
		JFrame tempFrame = this;
		
		// This closes this window and reopens the toolbox
		goBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new ToolBoxPage("");
				tempFrame.dispose();
			}
		});
		
		panel.add(goBack,gbc);
	}
	
	/** Creates the name label
	 * 
	 * @author chasealder
	 */
	public void addNameLabel() {
		gbc.insets = new Insets(0,425,0,0);
		gbc.weightx = 1;
		gbc.weighty = 1;
		gbc.gridx = 0;
		gbc.gridy = 1;
		gbc.gridwidth = 2;
		gbc.fill = GridBagConstraints.BOTH;
		
		name = new JLabel("Name: " + tool.getName());
		panel.add(name,gbc);
	}
	
	/** Creates the serial number label
	 * 
	 * @author chasealder
	 */
	public void addSerialLabel() {
		gbc.insets = new Insets(0,425,0,0);
		gbc.weightx = 1;
		gbc.weighty = 1;
		gbc.gridx = 0;
		gbc.gridy = 2;
		gbc.gridwidth = 2;
		gbc.fill = GridBagConstraints.BOTH;
		
		serial = new JLabel("Serial: " + tool.getSerial());
		panel.add(serial,gbc);
	}
	
	/** Creates the tags list
	 * 
	 * @author chasealder
	 */
	public void addTagsLabel() {
		gbc.insets = new Insets(0,425,0,0);
		gbc.weightx = 1;
		gbc.weighty = 1;
		gbc.gridx = 0;
		gbc.gridy = 3;
		gbc.gridwidth = 2;
		gbc.fill = GridBagConstraints.BOTH;
		
		String tagText = "";
		
		for (int i = 0; i < tool.getTags().size(); i++) {
			tagText += tool.getTags().get(i);
			
			// If it's the last tag, don't put the comma ;)
			if (i != tool.getTags().size()-1) {
				tagText += ", ";
			}
		}
		
		tags = new JLabel("Tags: " + tagText);
		panel.add(tags,gbc);
	}
	
	/** Creates the files button
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
		
		files = new JButton("Files");
		
		// This array is used to display the options in the dropdown menu
		String[] options = new String[tool.getFiles().size()];
		int i = 0;
		// Populate the above array with all associated ToolFile objects
		for ( ToolFile tf : tool.getFiles()) {
			options[i] = tf.getLabel();
			i++;
		}
		
		files.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				// This opens a window where they can pick which file to view
				String choice = (String)JOptionPane.showInputDialog(new Frame(),"Choose your file","File attachments", JOptionPane.PLAIN_MESSAGE,null, options,options[0]);
				
				// If they pick something valid...
				if ((choice != null) && (choice.length() > 0)) {
					
					// Get an empty string
					String data = "";
					
					// Fill the string with the file path
					for (ToolFile tf : tool.getFiles()) {
						if (tf.getLabel().equals(choice))
							data = tf.getPath();
					}
					
					// Display the file path
					JOptionPane.showMessageDialog(new Frame(), data);
				}
			}
		});
		
		panel.add(files,gbc);
	}
	
	/** Creates the links button
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
		
		links = new JButton("Links");
		
		// Make a normal string array (instead of arraylist) of all the link labels (Just their labels)
		String[] options = new String[tool.getLinks().size()];
		int i = 0;
		for ( ToolLink tl : tool.getLinks()) {
			options[i] = tl.getLabel();
			i++;
		}
		
		// Allow the user to click on a label and be shown it's relevant information
		links.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String choice = (String)JOptionPane.showInputDialog(new Frame(),"LINE","title", JOptionPane.PLAIN_MESSAGE,null, options,options[0]);
				
				// If they pick something valid...
				if ((choice != null) && (choice.length() > 0)) {
					
					// Get an empty string
					String data = "";
					
					// Fill the string with the website link
					for (ToolLink tl : tool.getLinks()) {
						if (tl.getLabel().equals(choice))
							data = tl.getLink();
					}
					
					// Display the file path
					JOptionPane.showMessageDialog(new Frame(), data);
				}
			}
		});
		
		panel.add(links,gbc);
	}
	
	/** Creates the reminders button
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
		
		reminders = new JButton("Reminders");
		
		// Make a normal string array (instead of arraylist) of all the reminder dates (Just their dates)
		String[] options = new String[tool.getReminders().size()];
		int i = 0;
		for ( ToolReminder tr : tool.getReminders()) {
			options[i] = tr.getDate();
			i++;
		}
		
		reminders.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String choice = (String)JOptionPane.showInputDialog(new Frame(),"LINE","title", JOptionPane.PLAIN_MESSAGE,null, options,options[0]);
				
				// If they pick something valid...
				if ((choice != null) && (choice.length() > 0)) {
					
					// Get an empty string
					String data = "";
					
					// Fill the string with the website link
					for (ToolReminder tr : tool.getReminders()) {
						if (tr.getDate().equals(choice))
							data = tr.getNotes();
					}
					
					// Display the file path
					JOptionPane.showMessageDialog(new Frame(), data);
				}
			}
		});
		
		panel.add(reminders,gbc);
	}
	
	/** Creates the edit button
	 * 
	 * @author chasealder
	 */
	public void addEditButton() {
		gbc.insets = new Insets(0,0,0,0);
		gbc.weightx = 1;
		gbc.weighty = 1;
		gbc.gridx = 0;
		gbc.gridy = 7;
		gbc.gridwidth = 1;
		gbc.fill = GridBagConstraints.BOTH;
		
		edit = new JButton("EDIT");
		
		// This is a temp variable so I can access the frame inside the action listener
		JFrame tempFrame = this;
		
		// This allows you to edit the item
		edit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new ToolCreatePage(tool);
				tempFrame.dispose();
			}
		});
		
		panel.add(edit, gbc);
	}
	
	/** Creates the delete button
	 * 
	 * @author chasealder
	 */
	public void addDeleteButton() {
		gbc.insets = new Insets(0,0,0,0);
		gbc.weightx = 1;
		gbc.weighty = 1;
		gbc.gridx = 1;
		gbc.gridy = 7;
		gbc.gridwidth = 1;
		gbc.fill = GridBagConstraints.BOTH;
		
		delete = new JButton("DELETE");
		
		// This is a temp variable so I can access the frame inside the action listener
		JFrame tempFrame = this;
		
		// This removes the item and closes the window
		delete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				runProgram.getToolbox().remove(tool);
				runProgram.updateTags();
				new ToolBoxPage("");
				tempFrame.dispose();
			}
		});
		
		panel.add(delete,gbc);
	}
}
