package model;

/** this class is used to create a unique tool
 * 
 * @author chasealder
 *
 */
public class Tool {
	
	private String name; // Name of the tool
	private String serial; // Serial number of the tool
	private String[] tags; // Array of tags associated with this tool
	private ToolLink[] links; // Array of links that are associated with this tool
	private ToolFile[] files; // Array of files that are associated with this tool
	private ToolReminder[] reminders; // Array of date reminders
	

	/** Constructor to use if you have everything passed in
	 * 
	 * @author chasealder
	 * 
	 */
	public Tool(String name, String serial, String[] tags, ToolLink[] links, ToolFile[] files, ToolReminder[] reminders) {
		
		// Transfer all variables
		this.name = name;
		this.serial = serial;
		this.tags = tags;
		this.links = links;
		this.files = files;
		this.reminders = reminders;
	}
	
	
}
