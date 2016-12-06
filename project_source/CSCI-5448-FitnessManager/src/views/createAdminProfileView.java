package views;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import org.hibernate.Session;

import controllers.controller;
import controllers.dbSearch;

//import org.hibernate.Query;
//import org.hibernate.Session;
//import org.hibernate.SessionFactory;
//import org.hibernate.cfg.Configuration;

import models.*;


public class createAdminProfileView extends view implements ActionListener{

	private JFrame frame;
	private JPanel panel;
	
	private JLabel userLabel;
	private JTextField userText;
	private JLabel passwordLabel;
	private JPasswordField passwordText;
	private JLabel emailLabel;
	private JTextField emailText;
	private JLabel LocationLabel;
	private JTextField locationText;	
	private JLabel SecQues;
	private JComboBox secQuesText;
	private JTextField secAnsText;
	private JLabel adminCodeLabel;
	private JTextField adminRole;
	private JButton submitButton;
	
		
	public createAdminProfileView(controller controller) 
	{
		super(controller);
		frame = new JFrame("Admin Profile");
		frame.setSize(650,350);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		panel = new JPanel();
		frame.getContentPane().add(panel);
		placeComponents();

		frame.setVisible(true);
	}

	private void placeComponents() {

		panel.setLayout(null);

		userLabel = new JLabel("User");
		userLabel.setBounds(10, 10, 80, 25);
		panel.add(userLabel);

		userText = new JTextField(20);
		userText.setBounds(100, 10, 160, 25);
		panel.add(userText);

		passwordLabel = new JLabel("Password");
		passwordLabel.setBounds(10, 40, 80, 25);
		panel.add(passwordLabel);

		passwordText = new JPasswordField(20);
		passwordText.setBounds(100, 40, 160, 25);
		panel.add(passwordText);
		
		emailLabel = new JLabel("Email");
		emailLabel.setBounds(300, 10, 80, 25);
		panel.add(emailLabel);

		emailText = new JTextField(20);
		emailText.setBounds(400, 10, 160, 25);
		panel.add(emailText);
		
		LocationLabel = new JLabel("Location");
		LocationLabel.setBounds(300, 40, 80, 25);
		panel.add(LocationLabel);

		locationText = new JTextField(20);
		locationText.setBounds(400, 40, 160, 25);
		panel.add(locationText);
		
		SecQues = new JLabel("Security Question");
		SecQues.setBounds(10, 73, 140, 25);
		panel.add(SecQues);
		
		String[] petStrings = { "Why did the chicken cross the road?", "Can you smell what the Rock is cooking?", "Who let the dogs out?", "How many feet do you have?" };
		//Create the combo box, select item at index 4.
		//Indices start at 0, so 4 specifies the pig.
		secQuesText = new JComboBox(petStrings);
		secQuesText.setSelectedIndex(3);
		//petList.addActionListener(this);
		secQuesText.setBounds(160, 75, 282, 20);
		panel.add(secQuesText);
		
		//JTextField userText3 = new JTextField(20);
		//userText3.setBounds(100, 70, 160, 25);
		//panel.add(userText3);
		
		JLabel Answer = new JLabel("Answer");
		Answer.setBounds(10, 107, 80, 25);
		panel.add(Answer);

		secAnsText = new JTextField(20);
		secAnsText.setBounds(100, 107, 160, 25);
		panel.add(secAnsText);
		

		adminCodeLabel = new JLabel("Admin Code");
		adminCodeLabel.setBounds(10, 150, 80, 25);
		panel.add(adminCodeLabel);

		adminRole = new JTextField(20);
		adminRole.setBounds(100, 150, 160, 25);
		panel.add(adminRole);
		
		
		submitButton = new JButton("Submit");
		submitButton.setBounds(280, 250, 95, 40);
		panel.add(submitButton);
		this.register();
		
	}
	
	public void register() {
		
		this.submitButton.addActionListener(this);		
	}
	
	public void actionPerformed(ActionEvent actionEvent)	
	{
		//String skills = skillsText.getText();
		//String Summary = summaryText.getText();		
		//String name = "ahahah";
		//String gender;
		
		String username = userText.getText();
		String email = emailText.getText();
		String location = locationText.getText();
		String securityQuestion;
		String securityAnswer = secAnsText.getText();
		String AdminRole = adminRole.getText();
		String password = new String(passwordText.getPassword());		
		String name = "name";
		String gender = "N/A";
		securityQuestion = secQuesText.getSelectedItem().toString();
		
		Session session = controller.createDBSesssion(controller.getUserDB());
		
		JOptionPane dialogBox = new JOptionPane();
		List result;
		dbSearch db = new dbSearch(controller);	
		System.out.println("Username : " + username);
		result = db.searchDBList("Admin","username",username);
		if (!result.isEmpty())
		{
			dialogBox.showMessageDialog(frame, "Duplicate username : Enter username and try again");
		}
		else{
		
			controller.fsystem.createProfile(AdminRole, username, name, gender, email, location, securityQuestion, securityAnswer, password);
			session.save((Admin)controller.fsystem.getUser());
			session = controller.closeDBSession(session);
			controller.display("Admin", "homePage");
		}
		
	}
	
	@Override
	public void setVisible(Boolean visiblity)
	{
		frame.setVisible(visiblity);
	}

}