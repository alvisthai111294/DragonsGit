package view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

/** This page displays all your tools. It also allows access to the settings page.
 * 
 * @author chasealder
 *
 */
public class ToolBoxPage extends JFrame {
	
	JPanel panel = new JPanel();
	GridBagConstraints gbc = new GridBagConstraints();
	
	// These are all UI elements
	private JComboBox tags;
	private JButton add;
	private JButton settings;
	private JButton tool1, tool2, tool3, tool4, tool5, tool6, tool7, tool8, tool9;
	
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
		
		tags = new JComboBox();
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
		
		add = new JButton("+ New Tool");
		panel.add(add,gbc);
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
	 * 
	 */
	public void addToolButtons() {
		
	}
}
