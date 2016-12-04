package views;

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

public class clientHomepageView extends view implements ActionListener {
	
	private JFrame frame;
	private JPanel panel;
	private JLabel headerLabel;
	private JButton updateButton;
	private JButton deleteButton;
	private JButton dailyButton;
	private JButton fitnessButton;
	private JButton searchButton;
	private JButton rateButton;
	

	public clientHomepageView() {
		frame = new JFrame("Client Homepage");
		frame.setSize(500,500);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		panel = new JPanel();
		frame.add(panel);
		placeComponents();

		frame.setVisible(true);
	}

	private void placeComponents() {

		panel.setLayout(null);
		
		headerLabel = new JLabel(""); 
		headerLabel.setBounds(200,10,100,10);
		headerLabel.setText("Welcome User"); 
		panel.add(headerLabel);
		
		updateButton = new JButton("Update profile");
		updateButton.setBounds(50, 50, 180, 50);
		panel.add(updateButton);
		
		deleteButton = new JButton("Delete Profile");
		deleteButton.setBounds(250, 50, 180, 50);
		panel.add(deleteButton);
		
		dailyButton = new JButton("Manage Daily Info");
		dailyButton.setBounds(50, 150, 180, 50);
		panel.add(dailyButton);
		
		fitnessButton = new JButton("Manage Fitness Goals");
		fitnessButton.setBounds(250, 150, 180, 50);
		panel.add(fitnessButton);
		
		searchButton = new JButton("Search Trainers");
		searchButton.setBounds(50, 250, 180, 50);
		panel.add(searchButton);
		
		rateButton = new JButton("Rate Trainer");
		rateButton.setBounds(250, 250, 180, 50);
		panel.add(rateButton);

		//JButton registerButton = new JButton("register");
		//registerButton.setBounds(180, 130, 80, 25);
		//panel.add(registerButton);
		this.register();
	}
	
		public void register() {
			
			this.updateButton.addActionListener(this);
			this.deleteButton.addActionListener(this);
			this.dailyButton.addActionListener(this);
			this.fitnessButton.addActionListener(this);
			this.searchButton.addActionListener(this);
			this.rateButton.addActionListener(this);
			
		}
		
		@Override
		public void setVisible(Boolean visiblity)
		{
			frame.setVisible(visiblity);
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
			else if (actionEvent.getActionCommand() == "Manage Daily Info")
			{
				System.out.println("Manage Daily Info Clicked");	
				//controller.login("HEY", "abc");			
			}
			else if (actionEvent.getActionCommand() == "Manage Fitness Goals")
			{
				System.out.println("Manage Fitness Clicked");	
				//controller.login("HEY", "abc");			
			}
			else if (actionEvent.getActionCommand() == "Search Trainers")
			{
				System.out.println("Search Trainers Clicked");	
				//controller.login("HEY", "abc");			
			}
			else if (actionEvent.getActionCommand() == "Rate Trainer")
			{
				System.out.println("Rate Trainer Clicked");	
				//controller.login("HEY", "abc");			
			}
		}

	}

