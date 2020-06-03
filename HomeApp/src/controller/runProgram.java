package controller;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.NoSuchElementException;
import java.util.Scanner;
import model.*;
import view.*;

/** This is the main controller. Currently, it runs the program and holds the username and email of the user.
 * Eventually, it will also hold the toolbox. It also stores the functionality for importing and exporting user data.
 * 
 * @author chasealder
 *
 */
public class runProgram {

	private static String name = "Guest";
	private static String email = "Guest";
	private static ArrayList<Tool> toolbox = new ArrayList<Tool>();
	private static ArrayList<String> allTags = new ArrayList<String>();
	
	/** Runs the program
	 * 
	 * @author chasealder
	 */
	public runProgram() {

		// Import data from the data file
		try {
			importData(new File("./datafile.txt"));
		} catch(NullPointerException e){ 
			
		}
		updateTags();
		
		new ToolBoxPage();
	}
	
	/** Changes the username and email
	 * 
	 * @author chasealder
	 * 
	 * @param piName passed in name
	 * @param piEmail passed in email
	 */
	public static void setUser(String piName, String piEmail) {
		name = piName;
		email = piEmail;
	}
	
	/** User's name getter
	 * 
	 * @author chasealder
	 * 
	 * @return user name
	 */
	public static String getName() {
		return name;
	}
	
	/** User's email getter
	 * 
	 * @author chasealder
	 * 
	 * @return user email
	 */
	public static String getEmail() {
		return email;
	}
	
	public static ArrayList<Tool> getToolbox() {
		return toolbox;
	}
	
	public static ArrayList<String> getTags() {
		return allTags;
	}
	
	/** Used to export user data to a text file
	 * 
	 * @author chasealder
	 * 
	 * @return a string containg user data to be outputted to a text file (export)
	 */
	public static String exportData() {
		
		String allData = name + "\n" + email + "\n" + toolbox.size();
		
		// For each tool, export it's data
		for (int i = 0; i < toolbox.size(); i++) {
			// output name and serial
			allData += "\n" + toolbox.get(i).getName();
			allData += "\n" + toolbox.get(i).getSerial();
			allData += "\n" + toolbox.get(i).getTags().size();
			
			for (int j = 0; j < toolbox.get(i).getTags().size(); j++) {
				allData += "\n" + toolbox.get(i).getTags().get(j);
			}
		}
		
		return 	allData;
	}
	
	/** Imports user data from a file.
	 * 
	 * @author chasealder
	 * 
	 */
	public static void importData(File importFile) {
		Scanner sc = null;
		
		try {
			sc = new Scanner(importFile);
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		// Instantiate the variables
		String newName;;
		String newEmail;
		
		// Try to read them in. If the file is empty, just set them to "Guest"
		try {
		newName = sc.nextLine().trim();
		newEmail = sc.nextLine().trim();
		} catch (NoSuchElementException e1) {
			newName = "Guest";
			newEmail = "Guest";
		}
		
		// Update the global variables
		name = newName;
		email = newEmail;
		
		// Read and parse the next line, which tells you how many tools there are
		int numTools = Integer.parseInt(sc.nextLine().trim());
		
		// Read all the tools in and add them to the toolbox
		for (int i = 0; i < numTools; i++) {
			// "read in" tool name, serial
			String riToolName = sc.nextLine().trim();
			String riToolSerial = sc.nextLine().trim();
			
			// Make a tag array and read in the number of tags
			ArrayList<String> riTags = new ArrayList<String>();
			int numTags = Integer.parseInt(sc.nextLine().trim());
			
			// Loop through and collect the tags
			for (int j = 0; j < numTags; j++) {
				riTags.add(sc.nextLine().trim());
			}
			
			toolbox.add(new Tool(riToolName,riToolSerial,riTags));
		}
	}
	
	/** Used for removing a tool from a users toolbox
	 * 
	 * @author chasealder
	 * 
	 * @param name should be the name of the tool you want to remove
	 * @return true or false based on whether the tool was removed
	 */
	public boolean removeTool(String name) {
		
		// Loop through all tools
		for (Tool t : toolbox) {
			
			// If the tool you're currently on has the same name you're looking for, remove it
			if (t.checkName(name)) {
				toolbox.remove(t);
				return true;
			}
		}
		
		// If the name is not found, return false to indicate nothing was found
		return false;
	}
	
	/** Used to add a tool to the toolbox
	 * 
	 * @author chasealder
	 * 
	 * @param newTool is the tool to be added
	 */
	public void addTool(Tool newTool) {
		
		// Add the tool
		toolbox.add(newTool);
		
		// Make sure to update the tag list since a new tool has been added
		this.updateTags();
	}
	
	
	/** This method refreshes the master tag list to make sure it's completely up to date, as well as sorts it
	 * 
	 * @author chasealder
	 * 
	 */
	public void updateTags() {
		
		allTags = new ArrayList<String>();
		
		// Parse through every tool
		for (Tool t : toolbox) {
			
			// Get a shallow copy of it's tag list
			ArrayList<String> temp = t.getTags();
			
			// Parse through every tag in that tools tag list
			for (String s : temp) {
				
				// If it's not in the master tag list, add it
				if (!allTags.contains(s)) {
					allTags.add(s);
				}
			}
		}
		
		Collections.sort(allTags);
	}
}
