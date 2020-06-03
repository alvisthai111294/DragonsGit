package model;

import java.util.ArrayList;
import java.util.Date;

/** this class is used to create a unique tool
 * 
 * @author chasealder
 *
 */
public class Tool {
	
	private String name; // Name of the tool
	private String serial; // Serial number of the tool
	private ArrayList<String> tags; // Array of tags associated with this tool
	private ArrayList<ToolLink> links; // Array of links that are associated with this tool
	private ArrayList<ToolFile> files; // Array of files that are associated with this tool
	private ArrayList<ToolReminder> reminders; // Array of date reminders
	

	/** Constructor to use if you have everything passed in
	 * 
	 * @author chasealder
	 */
	public Tool(String name, String serial, ArrayList<String> tags, ArrayList<ToolLink> links, ArrayList<ToolFile> files, ArrayList<ToolReminder> reminders) {
		
		// Transfer all variables
		this.name = name;
		this.serial = serial;
		this.tags = tags;
		this.links = links;
		this.files = files;
		this.reminders = reminders;
	}
	
	/** A constructor that just uses a name. Intitializes all other variables to empty arrays.
	 * 
	 * @author chasealder
	 */
	public Tool(String name, String serial, ArrayList<String> tags) {
		this.name = name;
		this.serial = serial;
		this.tags = tags;
		links = new ArrayList<ToolLink>();
		files = new ArrayList<ToolFile>();
		reminders = new ArrayList<ToolReminder>();
	}
	
	public String getName() {
		return name;
	}
	
	public String getSerial() {
		return serial;
	}
	
	/** Used to add a link to the link array
	 * 
	 * @author chasealder
	 * 
	 */
	public void addLink(String label, String link) {
		links.add(new ToolLink(label,link));
	}
	
	/** Used to remove links from the links array
	 * 
	 * @author chasealder
	 * 
	 * @param label is the label of the link you want to remove
	 * @return true if it was removed successfully
	 */
	public boolean removeLink(String label) {
		
		for (ToolLink tl : links) {
			if (tl.checkLabel(label)) {
				links.remove(tl);
				return true;
			}
		}	
		return false;
	}
	
	/** Used to add a file to the file array
	 * 
	 * @param label is the label you want to use for this file
	 * @param path is the full file path
	 */
	public void addFile(String label, String path) {
		files.add(new ToolFile(label,path));
	}
	
	/** Used to remove a file from the file array
	 * 
	 * @author chasealder
	 * 
	 * @param label is the label of the file you want to remove
	 * @return true if the removal worked, false otherwise
	 */
	public boolean removeFile(String label) {
		
		for (ToolFile tf : files) {
			if (tf.checkLabel(label)) {
				files.remove(tf);
				return true;
			}
		}
		return false;
	}
	
	/** Used to add a reminder to the reminder array
	 * 
	 * @author chasealder
	 * 
	 * @param piDate is the date of the reminder
	 * @param notes are the 'notes' that the user wants for that repair reminder
	 */
	public void addReminder(Date piDate, String notes) {
		reminders.add(new ToolReminder(piDate,notes));
	}
	
	/**
	 * 
	 * @return
	 */
	public boolean removeReminder() {
		return false;
	}
	
	/** Adds a tag to the tools tag list
	 * 
	 * @author chasealder
	 * 
	 * @param tagName is the tag to be added
	 * @return false if the tag already exists, true if it was added successfully
	 */
	public boolean addTag(String tagName) {
		
		// Make it lowercase for comparison and readability
		tagName = tagName.toLowerCase();
		
		// If the tag is already in the bunch, don't add it and return false
		if (tags.contains(tagName)) {
			return false;
		}
		
		// If the tag isn't already in the list, add it and return true
		tags.add(tagName);
		return true;
	}
	
	/** Used to remove tags from a tool
	 * 
	 * @author chasealder
	 * 
	 * @param tagName the tag to be removed
	 * @return boolean stating whether it worked or not
	 */
	public boolean removeTag(String tagName) {
		
		if (tags.contains(tagName)) {
			tags.remove(tagName);
			return true;
		}
		
		return false;
	}
	
	/** Tells you whether the name of this tool matches the passed in name
	 * 
	 * @author chasealder
	 * 
	 * @param piName is the name passed in to check if it is the same name as this object
	 * @return true if the names match, false otherwise
	 */
	public boolean checkName(String piName) {
		
		if (piName.equalsIgnoreCase(this.name)) {
			return true;
		}
		
		return false;
	}
	
	/** Used by the Toolbox to update allTags
	 * 
	 * @author chasealder
	 * 
	 * @return a shallow copy of this tool's tag list
	 */
	public ArrayList<String> getTags() {
		return (ArrayList<String>) tags.clone();
	}
}
