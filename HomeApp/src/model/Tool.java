package model;

import java.util.ArrayList;

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
	 * 
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
	
	
	/** Adds a tag to the tools tag list
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
	
	public boolean removeTag() {
		return false;
	}
	
	/** Used to check the name instead of a getter
	 * 
	 * @author chasealder
	 * 
	 * @param piName is the name passed in to check if it is the same name as this object
	 * @return true if the names match, false otherwise
	 */
	public boolean checkName(String piName) {
		
		if (piName.equals(this.name)) {
			return true;
		}
		
		return false;
	}
	
	/** Used by the Toolbox to update allTags
	 * 
	 * @return a shallow copy of this tool's tag list
	 */
	public ArrayList<String> getTags() {
		
		return (ArrayList<String>) tags.clone();
	}
}
