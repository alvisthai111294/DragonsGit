package model;

import java.util.Date;

/** This is an object that stores a reminder attached to a tool, along with the reminders notes/label
 * 
 * @author chasealder
 *
 */
public class ToolReminder {

	private String date; // The date that the reminder is for
	private String notes; // Any notes that the user may have added to the tool. Could be used as a basic label too
	
	/** Basic constructor
	 * 
	 * @author chasealder
	 * 
	 * @param date date to be saved
	 * @param notes the notes for the reminder
	 */
	public ToolReminder (String date, String notes) {
		this.setDate(date);
		this.setNotes(notes);
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getNotes() {
		return notes;
	}

	public void setNotes(String notes) {
		this.notes = notes;
	}
}
