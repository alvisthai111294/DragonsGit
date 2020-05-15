package model;

import java.util.ArrayList;

/** This is an array of tools
 * 
 * @author chasealder
 *
 */
public class Toolbox {

	String name;
	ArrayList<Tool> toolArr;
	ArrayList<String> allTags;
	
	/** Constructor for a new user toolbox. 
	 * 
	 *  @author chasealder
	 *  
	 *  @param name is the name of the user. The other two are blank to start out with.
	 */
	public Toolbox(String name) {
		this.name = name;
		toolArr = new ArrayList<Tool>();
		allTags = new ArrayList<String>();
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
		for (Tool t : toolArr) {
			
			// If the tool you're currently on has the same name you're looking for, remove it
			if (t.checkName(name)) {
				toolArr.remove(t);
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
	 * @param newTool
	 */
	public void addTool(Tool newTool) {
		
	}
	
	
	/** This method refreshes the master tag list to make sure it's completely up to date
	 * 
	 * @author chasealder
	 * 
	 */
	public void updateTags() {
		
		// Parse through every tool
		for (Tool t : toolArr) {
			
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
	}
}
