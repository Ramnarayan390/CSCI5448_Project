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

import controllers.controller;

import javax.swing.JRadioButton;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;

public class loginPageView extends view implements ActionListener{
	
	private JFrame frame;
	private JPanel panel;
	private JLabel headerLabel;
	private JLabel userLabel;
	private JTextField userText; 
	private JLabel passwordLabel;
	private JPasswordField passwordText;
	private JLabel roleText;
	private JComboBox roleChoice;
	private JButton loginButton;
	private JButton resetButton;
	
	public loginPageView(controller controller){
		
		super(controller);
		frame = new JFrame("Login");
		frame.setSize(400,330);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		panel = new JPanel();
		frame.add(panel);
		placeComponents();

		frame.setVisible(true);
	}

	private void placeComponents() {

		panel.setLayout(null);
		//JLabel headerLabel;
		headerLabel = new JLabel("Login"); 
		headerLabel.setBounds(200,10,100,10);
		headerLabel.setText("LOGIN"); 
		panel.add(headerLabel);
		
		userLabel = new JLabel("User");
		userLabel.setBounds(10, 40, 80, 25);
		panel.add(userLabel);

		userText = new JTextField(20);
		userText.setBounds(100, 40, 160, 25);
		panel.add(userText);

		passwordLabel = new JLabel("Password");
		passwordLabel.setBounds(10, 70, 80, 25);
		panel.add(passwordLabel);

		passwordText = new JPasswordField(20);
		passwordText.setBounds(100, 70, 160, 25);
		panel.add(passwordText);
		
		roleText = new JLabel("Role");
		roleText.setBounds(10, 100, 40, 25);
		panel.add(roleText);
		
		String[] roleOptions = { "User", "Trainer", "Admin" };
		//Create the combo box, select item at index 4.
		//Indices start at 0, so 4 specifies the pig.
		roleChoice = new JComboBox(roleOptions);
		roleChoice.setSelectedIndex(2);
		//petList.addActionListener(this);
		roleChoice.setBounds(100, 105, 100, 20);
		panel.add(roleChoice);
		
		loginButton = new JButton("Login");
		loginButton.setBounds(50, 150, 80, 20);
		panel.add(loginButton);
		
		resetButton = new JButton("Reset Password");
		resetButton.setBounds(150, 150, 180, 20);
		panel.add(resetButton);

		//JButton registerButton = new JButton("register");
		//registerButton.setBounds(180, 130, 80, 25);
		//panel.add(registerButton);
		this.register();

	}
	
	public void register() {
		
		this.loginButton.addActionListener(this);
		this.resetButton.addActionListener(this);
	}
	
	@Override
	public void setVisible(Boolean visiblity)
	{
		frame.setVisible(visiblity);
	}
	
	public void actionPerformed(ActionEvent actionEvent)
	{
		String username;
		String password;
		
		username = userText.getText();
		password = new String(passwordText.getPassword());
		if (actionEvent.getActionCommand() == "Login")
		{
			System.out.println("Login Clicked");	
			controller.login(username, password);
		}
		else if (actionEvent.getActionCommand() == "Reset Password")
		{
			System.out.println("Reset Clicked");	
			//controller.login("HEY", "abc");			
		}
	}

}
