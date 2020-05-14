package model;

/** This class is used to create an object that stores a internet link that is associated with an item, as well
 * as its label name.
 * 
 * @author chasealder
 *
 */
public class ToolLink {

	String label; // Label shown to user
	String link; // Web link attached to file
	
	/** Basic constructor
	 * 
	 * @author chasealder
	 * 
	 * @param label is used to set the label shown to the user
	 * @param link is the webpage link you want to save
	 */
	public ToolLink(String label, String link) {
		this.label = label;
		this.link = link;
	}
}
