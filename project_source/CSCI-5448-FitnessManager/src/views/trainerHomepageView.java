package views;
import controllers.*;
import models.*;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;

public class trainerHomepageView extends view implements ActionListener {
	
	private JFrame frame;
	private JPanel panel;
	private JLabel headerLabel;
	private JLabel verifiedLabel;
	private JButton updateButton;
	private JButton deleteButton;
	private JButton viewButton;
	private JButton editButton;


	

	public trainerHomepageView(controller controller) {
		super(controller);
		frame = new JFrame("Trainer Homepage");
		frame.setSize(500,230);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		panel = new JPanel();
		frame.add(panel);
		placeComponents();

		frame.setVisible(true);
	}

	private void placeComponents() {

		panel.setLayout(null);
		
		headerLabel = new JLabel("welcome" + controller.fsystem.user.getUsername()); 
		headerLabel.setBounds(200,10,200,10);
		panel.add(headerLabel);
		
		verifiedLabel = new JLabel("Verification Pending");
		verifiedLabel.setBounds(50,20,150,30);
		verifiedLabel.setForeground(Color.RED);
		panel.add(verifiedLabel);
		
		updateButton = new JButton("Update profile");
		updateButton.setBounds(50, 50, 180, 50);
		panel.add(updateButton);
		
		deleteButton = new JButton("Delete Profile");
		deleteButton.setBounds(250, 50, 180, 50);
		panel.add(deleteButton);
		
		viewButton = new JButton("View Schedule");
		viewButton.setBounds(50, 150, 180, 50);
		panel.add(viewButton);
		
		editButton = new JButton("Edit Schedule");
		editButton.setBounds(250, 150, 180, 50);
		panel.add(editButton);
		

		updateButton.setEnabled(false);
		deleteButton.setEnabled(false);
		viewButton.setEnabled(false);
		editButton.setEnabled(false);

		this.register();
		//if( ((Trainer)(controller.fsystem.user)).Verified)
		if ( ((Trainer)controller.fsystem.user).Verified)
		{
			setVerified();
		}
	}
	
		public void register() {
			
			this.updateButton.addActionListener(this);
			this.deleteButton.addActionListener(this);
			this.viewButton.addActionListener(this);
			this.editButton.addActionListener(this);

			
		}
		
		@Override
		public void setVisible(Boolean visiblity)
		{
			frame.setVisible(visiblity);
		}
		
		public void setVerified()
		{
			updateButton.setEnabled(true);
			deleteButton.setEnabled(true);
			viewButton.setEnabled(true);
			editButton.setEnabled(true);
			verifiedLabel.setText("Verified");
			verifiedLabel.setForeground(Color.GREEN);
		}
		public void setName(String name)
		{
			this.headerLabel.setText("welcome" + name);
		}
		
		public void actionPerformed(ActionEvent actionEvent)
		{

			if (actionEvent.getActionCommand() == "Update profile")
			{
				System.out.println("Update profile Clicked");	
				//controller.login("HEY", "abc");			
			}
			else if (actionEvent.getActionCommand() == "Delete Profile")
			{
				System.out.println("Delete Profile Clicked");	
				//controller.login("HEY", "abc");			
			}
			else if (actionEvent.getActionCommand() == "View Schedule")
			{
				System.out.println("View Clicked");	
				//controller.login("HEY", "abc");			
			}
			else if (actionEvent.getActionCommand() == "Edit Schedule")
			{
				System.out.println("Edit Clicked");	
				//controller.login("HEY", "abc");			
			}

		}

	}


