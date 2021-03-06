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
import java.awt.Font;

public class TrainerHomepageView extends View implements ActionListener {
	
	private JFrame frame;
	private JPanel panel;
	private JLabel headerLabel;
	private JLabel verifiedLabel;
	private JButton updateButton;
	private JButton deleteButton;
	private JButton viewButton;
	private JButton editButton;
	private JButton logoutButton;


	

	public TrainerHomepageView(Controller controller) {
		super(controller);
		frame = new JFrame("Trainer Homepage");
		frame.setSize(600,500);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		panel = new JPanel();
		frame.getContentPane().add(panel);
		placeComponents();

		frame.setVisible(true);
	}

	private void placeComponents() {

		panel.setLayout(null);
		
		headerLabel = new JLabel("Welcome  " + controller.fsystem.user.getUsername()); 
		headerLabel.setFont(new Font("Dialog", Font.BOLD, 16));
		headerLabel.setBounds(200,10,200,19);
		panel.add(headerLabel);
		
		verifiedLabel = new JLabel("Verification Pending");
		verifiedLabel.setBounds(50,51,150,30);
		verifiedLabel.setForeground(Color.RED);
		panel.add(verifiedLabel);
		
		updateButton = new JButton("Update profile");
		updateButton.setBounds(50, 108, 180, 50);
		panel.add(updateButton);
		
		deleteButton = new JButton("Delete Profile");
		deleteButton.setBounds(250, 108, 180, 50);
		panel.add(deleteButton);
		
		logoutButton = new JButton("Logout");
		logoutButton.setBounds(175, 292, 180, 50);
		panel.add(logoutButton);
		
		
		viewButton = new JButton("View Schedule");
		viewButton.setBounds(50, 197, 180, 50);
		panel.add(viewButton);
		
		editButton = new JButton("Edit Schedule");
		editButton.setBounds(250, 197, 180, 50);
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
			this.logoutButton.addActionListener(this);
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
		
			}
			else if (actionEvent.getActionCommand() == "Edit Schedule")
			{
		
				System.out.println("Edit Clicked");
				((TrainerSystem)controller.fsystem).editSchedule(controller);
				//controller.view = new startupView(controller);
			
			}
			else if (actionEvent.getActionCommand() == "View Schedule")
			{
		
				System.out.println("View Clicked");
				((TrainerSystem)controller.fsystem).viewSchedule();
				//controller.view = new startupView(controller);
			
			}
			else if (actionEvent.getActionCommand() == "Logout")
			{
				controller.view.setVisible(false);
				controller.view = new StartupView(controller);	
			
			}

		}

	}


