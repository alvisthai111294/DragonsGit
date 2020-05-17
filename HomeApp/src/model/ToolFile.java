package model;

/** This is an object that stores a file path that is attached to a tool, as well as its label name.
 * 
 * @author chasealder
 *
 */
public class ToolFile {

	String label; // The label that is used to represent the file path
	String path; // The actual literal file path
	
	/** Basic constructor
	 * 
	 * @author chasealder
	 * 
	 * @param label is used to set the label shown to the user
	 * @param path is a filepath passed in to represent the file's location
	 */
	public ToolFile(String label, String path) {
		this.label = label;
		this.path = path;
	}
	
	/** Compares a passed in label to the given label.
	 * 
	 * @param label to be checked against this object's label
	 * @return true if they're the same, false otherwise
	 */
	public boolean checkLabel(String label) {
		
		if (this.label.equalsIgnoreCase(label)) {
			return true;
		}
		
		return false;
	}
}
