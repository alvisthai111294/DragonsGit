package controller;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.NoSuchElementException;
import java.util.Scanner;
import model.*;
import view.*;

/** This is the main controller. Currently, it runs the program and holds the username and email of the user, and
 *  also holds the toolbox. It also stores the functionality for importing and exporting user data.
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
		
		new ToolBoxPage("");
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
	
	/** Getter for the toolbox
	 * 
	 * @return main tool array
	 */
	public static ArrayList<Tool> getToolbox() {
		return toolbox;
	}
	
	/** Getter for the full tag list
	 * 
	 * @return complete tag list
	 */
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
		
		// Write the name and email, and then the number of tools
		String allData = name + "\n" + email + "\n" + toolbox.size();
		
		// For each tool, export it's data
		for (int i = 0; i < toolbox.size(); i++) {
			// output name and serial
			allData += "\n" + toolbox.get(i).getName();
			allData += "\n" + toolbox.get(i).getSerial();
			
			// Write the number of tags, and what they are
			allData += "\n" + toolbox.get(i).getTags().size();
			
			for (int j = 0; j < toolbox.get(i).getTags().size(); j++) {
				allData += "\n" + toolbox.get(i).getTags().get(j);
			}
			
			// Write the number of files, with it's label and path
			allData += "\n" + toolbox.get(i).getFiles().size();
			
			for (int j = 0; j < toolbox.get(i).getFiles().size(); j++) {
				allData += "\n" + toolbox.get(i).getFiles().get(j).getLabel();
				allData += "\n" + toolbox.get(i).getFiles().get(j).getPath();
			}
			
			// Write the number of Links, with it's label and URL
			allData += "\n" + toolbox.get(i).getLinks().size();
			
			for (int j = 0; j < toolbox.get(i).getLinks().size(); j++) {
				allData += "\n" + toolbox.get(i).getLinks().get(j).getLabel();
				allData += "\n" + toolbox.get(i).getLinks().get(j).getLink();
			}
			
			// Write the number of Links, with it's label and URL
			allData += "\n" + toolbox.get(i).getReminders().size();
			
			for (int j = 0; j < toolbox.get(i).getReminders().size(); j++) {
				allData += "\n" + toolbox.get(i).getReminders().get(j).getDate();
				allData += "\n" + toolbox.get(i).getReminders().get(j).getNotes();
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
			
			// Make a the arrays for tags, files, links, and reminders
			ArrayList<String> riTags = new ArrayList<String>();
			ArrayList<ToolFile> riFiles = new ArrayList<ToolFile>();
			ArrayList<ToolLink> riLinks = new ArrayList<ToolLink>();
			ArrayList<ToolReminder> riReminders = new ArrayList<ToolReminder>();
			
			// Get number of tags and read them in
			int numTags = Integer.parseInt(sc.nextLine().trim());
			
			for (int j = 0; j < numTags; j++) {
				riTags.add(sc.nextLine().trim());
			}
			
			// Get number of files and read them in
			int numFiles = Integer.parseInt(sc.nextLine().trim());
			
			for (int j = 0; j < numFiles; j++) {
				String label = sc.nextLine().trim();
				String path = sc.nextLine().trim();
				
				riFiles.add(new ToolFile(label,path));
			}
			
			// Get number of links and read them in
			int numLinks = Integer.parseInt(sc.nextLine().trim());
			
			for (int j = 0; j < numLinks; j++) {
				String label = sc.nextLine().trim();
				String link = sc.nextLine().trim();
				
				riLinks.add(new ToolLink(label,link));
			}
			
			// Get number of reminders and read them in
			int numReminders = Integer.parseInt(sc.nextLine().trim());
			
			for (int j = 0; j < numReminders; j++) {
				String label = sc.nextLine().trim();
				String date = sc.nextLine().trim();
				
				riReminders.add(new ToolReminder(label,date));
			}
			
			toolbox.add(new Tool(riToolName,riToolSerial,riTags,riLinks,riFiles,riReminders));
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
	public static void updateTags() {
		
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
