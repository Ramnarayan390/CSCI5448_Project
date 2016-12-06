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

import controllers.Controller;
import controllers.DbSearch;

//import org.hibernate.Query;
//import org.hibernate.Session;
//import org.hibernate.SessionFactory;
//import org.hibernate.cfg.Configuration;

import models.*;


public class CreateClientProfileView extends View implements ActionListener{

	private JFrame frame;
	private JPanel panel;
	
	private JLabel userLabel;
	private JTextField userText;
	private JLabel passwordLabel;
	private JPasswordField passwordText;
	private JLabel emailLabel;
	private JTextField emailText;
	private JLabel nameLabel;
	private JTextField nameText;
	private JLabel LocationLabel;
	private JTextField locationText;	
	private JLabel SecQues;
	private JComboBox secQuesText;
	private JTextField secAnsText;
	private JLabel heightLabel;
	private JTextField heightText;
	private JLabel weightLabel;
	private JTextField weightText;
	private JLabel ageLabel;
	private JTextField ageText;
	private JRadioButton Male;
	private JRadioButton Female;

	private JButton submitButton;
	
		
	public CreateClientProfileView(Controller controller) 
	{
		super(controller);
		frame = new JFrame("Client Profile Page");
		frame.setSize(700,500);
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
		passwordLabel.setBounds(300, 10, 80, 25);
		panel.add(passwordLabel);

		passwordText = new JPasswordField(20);
		passwordText.setBounds(400, 10, 160, 25);
		panel.add(passwordText);
		
		nameLabel = new JLabel("Full Name");
		nameLabel.setBounds(10, 40, 80, 25);
		panel.add(nameLabel);

		nameText = new JTextField(20);
		nameText.setBounds(100, 40, 160, 25);
		panel.add(nameText);
		
		emailLabel = new JLabel("Email");
		emailLabel.setBounds(300, 40, 80, 25);
		panel.add(emailLabel);

		emailText = new JTextField(20);
		emailText.setBounds(400, 40, 160, 25);
		panel.add(emailText);
		
		LocationLabel = new JLabel("Location");
		LocationLabel.setBounds(10, 70, 80, 25);
		panel.add(LocationLabel);

		locationText = new JTextField(20);
		locationText.setBounds(100, 70, 160, 25);
		panel.add(locationText);
		
		JLabel Gender = new JLabel("Gender");
		Gender.setBounds(300, 70, 80, 25);
		panel.add(Gender);
		
		Male = new JRadioButton("Male");
		Male.setBounds(400, 70, 80, 25);
		panel.add(Male);
		
		Female = new JRadioButton("Female");
		Female.setBounds(500,70, 80, 25);
		panel.add(Female);
		    
		
		SecQues = new JLabel("Security Question");
		SecQues.setBounds(10, 100, 133, 25);
		panel.add(SecQues);
		
		String[] petStrings = { "Why did the chicken cross the road?", "Can you smell what the Rock is cooking?", "Who let the dogs out?", "How many feet do you have?" };
		//Create the combo box, select item at index 4.
		//Indices start at 0, so 4 specifies the pig.
		secQuesText = new JComboBox(petStrings);
		secQuesText.setSelectedIndex(3);
		//petList.addActionListener(this);
		secQuesText.setBounds(161, 102, 334, 20);
		panel.add(secQuesText);
		
	
		JLabel Answer = new JLabel("Answer");
		Answer.setBounds(10, 130, 80, 25);
		panel.add(Answer);

		secAnsText = new JTextField(20);
		secAnsText.setBounds(100, 130, 160, 25);
		panel.add(secAnsText);
		
		

		heightLabel = new JLabel("Height");
		heightLabel.setBounds(10, 160, 80, 25);
		panel.add(heightLabel);

		heightText = new JTextField(20);
		heightText.setBounds(100, 160, 160, 25);
		panel.add(heightText);
		
		weightLabel = new JLabel("Weight");
		weightLabel.setBounds(10, 190, 80, 25);
		panel.add(weightLabel);

		weightText = new JTextField(20);
		weightText.setBounds(100, 190, 160, 25);
		panel.add(weightText);
		
		
		ageLabel = new JLabel("Age");
		ageLabel.setBounds(10, 220, 80, 25);
		panel.add(ageLabel);

		ageText = new JTextField(20);
		ageText.setBounds(100, 220, 160, 25);
		panel.add(ageText);
		
		
		submitButton = new JButton("Submit");
		submitButton.setBounds(265, 400, 100, 40);
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
		String username = userText.getText();
		String name = "ahahah";
		String gender;
		String email = emailText.getText();
		String location = locationText.getText();
		String securityQuestion;
		String securityAnswer = secAnsText.getText();;
		String password = new String(passwordText.getPassword());
		
		if (Male.isSelected())
			gender = "MALE";
		else
			gender = "FEMALE";
		
		securityQuestion = secQuesText.getSelectedItem().toString();

		
		
		
		
		Session session = controller.createDBSesssion(controller.getUserDB());
				
		JOptionPane dialogBox = new JOptionPane();
		List result;
		DbSearch db = new DbSearch(controller);	
		System.out.println("Username : " + username);
		result = db.searchDBList("Client","username",username);
		if (!result.isEmpty())
		{
			dialogBox.showMessageDialog(frame, "Duplicate username : Enter username and try again");
		}
		else
		{	//create user
			double height = Double.parseDouble(heightText.getText());
			int weight = Integer.parseInt(weightText.getText()); 
			int age = Integer.parseInt(ageText.getText());	
			
			
			controller.fsystem.createProfile(height, weight, age, username, name, gender, email, location, securityQuestion, securityAnswer, password);
			session.save(controller.fsystem.getUser());
			session = controller.closeDBSession(session);
			controller.display("Trainer","homePage");
		}
	}
	
	@Override
	public void setVisible(Boolean visiblity)
	{
		frame.setVisible(visiblity);
	}

}