package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;

public class Login {
	
	private JFrame frame = new JFrame();
	private JPanel panel = new JPanel();
	private JButton guestButton = makeGuestButton();
	private JButton loginButton = makeLoginButton();
	private JPasswordField pinField = makePinField();
	
	public Login() {
		
		// Create the frame and add the panel
		frame.setSize(230,150);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		frame.add(panel);
		
		panel.setLayout(null);

		// Make and add the "PIN:" label beside text box
		JLabel pin = new JLabel("PIN:");
		pin.setBounds(10,20,80,25);
		panel.add(pin);
		
		// Add buttons and field to main panel
		panel.add(pinField);
		panel.add(guestButton);
		panel.add(loginButton);
		
		frame.setVisible(true);
	}
	
	/**
	 * Constructs the "Guest" button
	 * 
	 * @author Chase Alder
	 * @return the guest button for bypassing login
	 */
	public JButton makeGuestButton() {
		JButton guestButton = new JButton("Guest");
		guestButton.setBounds(10,50,100,40);
		
		// ActionListener still needs to be filled out.
		guestButton.addActionListener( 
			new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					
				}
			}
		);
		
		return guestButton;
	}
	
	/**
	 * Constructs the "Login" button
	 * 
	 * @author Chase Alder
	 * @return the login button for logging in with a PIN
	 */
	public JButton makeLoginButton() {
		JButton loginButton = new JButton("Login");
		loginButton.setBounds(115,50,100,40);
		
		// Code what button does here
		loginButton.addActionListener( 
			new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					
				}
			}
		);
		
		return loginButton;
	}
	
	/**
	 * Constructs a password field for PIN entry (login)
	 * 
	 * @author Chase Alder
	 * @return a password entry field
	 */
	public JPasswordField makePinField() {
		JPasswordField pinField = new JPasswordField();
		pinField.setBounds(50,20,165,25);
		return pinField;
	}
}

