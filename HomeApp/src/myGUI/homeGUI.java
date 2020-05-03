package myGUI;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.JCheckBox;
import javax.swing.JToolBar;
import javax.swing.JTextArea;
import javax.swing.JTextPane;
import javax.swing.JMenuItem;
import javax.swing.JLabel;

public class homeGUI {

	private JFrame frame;
	private JTextField textField;
	private JButton btnUserProfile;
	private JButton btnNewButton_2;
	private JTextField txtYouOwnyn;
	private double version = 1.0;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			
			public void run() {
				try {
					homeGUI window = new homeGUI();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public homeGUI() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 800, 600);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JButton btnNewButton = new JButton("About Us");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, " Dragon Group About Box\n Home Application Ver "+getVersion()+"\n Copyright @ 2020, UW Tacoma ", "About Us" , JOptionPane.INFORMATION_MESSAGE);
				
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 17));
		btnNewButton.setBounds(0, 502, 120, 61);
		frame.getContentPane().add(btnNewButton);
		
		textField = new JTextField();
		textField.setBounds(10, 10, 381, 35);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		JButton btnNewButton_1 = new JButton("Search");
		btnNewButton_1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 17));
		btnNewButton_1.setBounds(401, 10, 104, 35);
		frame.getContentPane().add(btnNewButton_1);
		
		btnUserProfile = new JButton("User Profile");
		btnUserProfile.setFont(new Font("Tahoma", Font.PLAIN, 17));
		btnUserProfile.setBounds(515, 10, 271, 35);
		frame.getContentPane().add(btnUserProfile);
		
		btnNewButton_2 = new JButton("Photo");
		btnNewButton_2.setFont(new Font("Tahoma", Font.PLAIN, 17));
		btnNewButton_2.setBounds(10, 68, 244, 123);
		frame.getContentPane().add(btnNewButton_2);
		
		txtYouOwnyn = new JTextField();
		txtYouOwnyn.setFont(new Font("Tahoma", Font.PLAIN, 17));
		txtYouOwnyn.setText("You own? (Y/N)");
		txtYouOwnyn.setBounds(10, 201, 134, 100);
		frame.getContentPane().add(txtYouOwnyn);
		txtYouOwnyn.setColumns(10);
		
		JCheckBox chckbxNewCheckBox = new JCheckBox("Yes");
		chckbxNewCheckBox.setFont(new Font("Tahoma", Font.PLAIN, 16));
		chckbxNewCheckBox.setBounds(150, 232, 95, 21);
		frame.getContentPane().add(chckbxNewCheckBox);
		
		JCheckBox chckbxNewCheckBox_1 = new JCheckBox("No");
		chckbxNewCheckBox_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		chckbxNewCheckBox_1.setBounds(150, 255, 95, 21);
		frame.getContentPane().add(chckbxNewCheckBox_1);
		
		JButton btnNewButton_3 = new JButton("Add to your toolbox");
		btnNewButton_3.setFont(new Font("Tahoma", Font.PLAIN, 17));
		btnNewButton_3.setBounds(10, 326, 244, 51);
		frame.getContentPane().add(btnNewButton_3);
		
		JButton btnNewButton_4 = new JButton("Link To User Manual");
		btnNewButton_4.setFont(new Font("Tahoma", Font.PLAIN, 17));
		btnNewButton_4.setBounds(264, 324, 241, 53);
		frame.getContentPane().add(btnNewButton_4);
		
		JButton btnNewButton_5 = new JButton("Link To Measurements");
		btnNewButton_5.setFont(new Font("Tahoma", Font.PLAIN, 17));
		btnNewButton_5.setBounds(264, 263, 238, 51);
		frame.getContentPane().add(btnNewButton_5);
		
		JButton btnNewButton_5_1 = new JButton("Link To Warranty Info");
		btnNewButton_5_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton_5_1.setFont(new Font("Tahoma", Font.PLAIN, 17));
		btnNewButton_5_1.setBounds(264, 202, 238, 51);
		frame.getContentPane().add(btnNewButton_5_1);
		
		JButton btnNewButton_5_1_1 = new JButton("Warranty Notes");
		btnNewButton_5_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton_5_1_1.setFont(new Font("Tahoma", Font.PLAIN, 17));
		btnNewButton_5_1_1.setBounds(538, 202, 238, 51);
		frame.getContentPane().add(btnNewButton_5_1_1);
		
		JButton btnNewButton_5_1_2 = new JButton("Measurement Notes");
		btnNewButton_5_1_2.setFont(new Font("Tahoma", Font.PLAIN, 17));
		btnNewButton_5_1_2.setBounds(538, 263, 238, 51);
		frame.getContentPane().add(btnNewButton_5_1_2);
		
		JButton btnNewButton_5_1_3 = new JButton("User Manual Notes");
		btnNewButton_5_1_3.setFont(new Font("Tahoma", Font.PLAIN, 17));
		btnNewButton_5_1_3.setBounds(538, 326, 238, 51);
		frame.getContentPane().add(btnNewButton_5_1_3);
		
		JButton btnNewButton_5_1_3_1 = new JButton("General Notes");
		btnNewButton_5_1_3_1.setFont(new Font("Tahoma", Font.PLAIN, 17));
		btnNewButton_5_1_3_1.setBounds(401, 400, 238, 51);
		frame.getContentPane().add(btnNewButton_5_1_3_1);
		
		JLabel lblNewLabel = new JLabel("\tItem Name/ Brand Name");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblNewLabel.setBounds(365, 64, 222, 68);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblSerial = new JLabel("Serial#");
		lblSerial.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblSerial.setBounds(365, 126, 222, 68);
		frame.getContentPane().add(lblSerial);
	}
	
	/*
	 * Getter for the version variable (used in the about page)
	 */
	public double getVersion() {
		return version;
	}
	
	/*
	 * Used to set the version. Does not accept a negative number.
	 */
	public void setVersion(double ver) {
		
		// Make sure the version is positive before changing
		if (ver > 0.0)
			version = ver;	
	}
}
