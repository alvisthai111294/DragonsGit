package model;

/** This is an object that stores a file path that is attached to a tool, as well as its label name.
 * 
 * @author chasealder
 *
 */
public class ToolFile {

	private String label; // The label that is used to represent the file path
	private String path; // The actual literal file path
	
	/** Basic constructor
	 * 
	 * @author chasealder
	 * 
	 * @param label is used to set the label shown to the user
	 * @param path is a filepath passed in to represent the file's location
	 */
	public ToolFile(String label, String path) {
		this.setLabel(label);
		this.setPath(path);
	}
	
	/** Compares a passed in label to the given label.
	 * 
	 * @param label to be checked against this object's label
	 * @return true if they're the same, false otherwise
	 */
	public boolean checkLabel(String label) {
		
		if (this.getLabel().equalsIgnoreCase(label)) {
			return true;
		}
		
		return false;
	}

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}
}
