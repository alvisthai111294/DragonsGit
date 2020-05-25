package controller;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import model.Toolbox;
import view.SettingsPopup;
import view.ToolBoxPage;

/** This is the main controller. Currently, it runs the program and holds the username and email of the user.
 * Eventually, it will also hold the toolbox. It also stores the functionality for importing and exporting user data.
 * 
 * @author chasealder
 *
 */
public class runProgram {

	private static String name = "Thomas Widdley";
	private static String email = "WiddleyWinner@gmail.com";
	private static Toolbox toolbox;
	
	/** Runs the program
	 * 
	 * @author chasealder
	 */
	public runProgram() {
		
		// THIS AREA will do the loading of user data and authentification through a login page eventually
		
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
	
	/** Used to export user data to a text file
	 * 
	 * @author chasealder
	 * 
	 * @return a string containg user data to be outputted to a text file (export)
	 */
	public static String exportData() {
		return name + "\n" + email;
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
		
		String newName = sc.nextLine().trim();
		String newEmail = sc.nextLine().trim();
		
		name = newName;
		email = newEmail;
	}
}
