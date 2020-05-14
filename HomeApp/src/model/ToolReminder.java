package model;

import java.util.Date;

/** This is an object that stores a reminder attached to a tool, along with the reminders notes/label
 * 
 * @author chasealder
 *
 */
public class ToolReminder {

	Date reminderDate; // The date that the reminder is for
	String notes; // Any notes that the user may have added to the tool. Could be used as a basic label too
	
	/** Basic constructor
	 * 
	 * @author chasealder
	 * 
	 * @param date date to be saved
	 * @param notes the notes for the reminder
	 */
	public ToolReminder (Date date, String notes) {
		reminderDate = date;
		this.notes = notes;
	}
}
