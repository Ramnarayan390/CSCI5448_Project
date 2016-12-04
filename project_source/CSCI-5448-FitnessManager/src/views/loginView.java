package views;

import controllers.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class loginView extends view implements ActionListener {

		
	private JFrame frame;
	private JLabel screenLabel;
	private JLabel userLabel;
	private JLabel passLabel;
	private JButton okButton;
	private JButton resetPasswordButton;
	private JPanel panel;
	private JPanel panel2;
	public JTextField userField;
	public JPasswordField passField;
	
	public loginView(controller controller)
	{
		
		super(controller);
		frame = new JFrame("login");
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(300, 300);
		//frame.getContentPane().setLayout(new Flow );
		panel = new JPanel();
		frame.add(panel);
		
		panel2 = new JPanel();
		//frame.add(panel2);
		
		//setBounds(x,y,width,height)
		//panel.setLayout(null);
		panel.setLayout(new BoxLayout(panel,BoxLayout.PAGE_AXIS));
		panel2.setLayout(new BoxLayout(panel2,BoxLayout.X_AXIS));
		
		screenLabel = new JLabel("Login");
		//screenLabel.setBounds(100,200,150,80);
		panel.add(screenLabel);
		
		
		userLabel = new JLabel("username");
		//userLabel.setBounds(100,300,50,25);
		panel.add(userLabel);
		
		userField = new JTextField(20);;
		panel.add(userField);
		
		
		passLabel = new JLabel("password");
		//passLabel.setBounds(100,400,50,25);
		panel.add(passLabel);
		
		passField = new JPasswordField(20);
		panel.add(passField);
		
		okButton = new JButton("OK");
		//userButton.setBounds(100,500,50,25);
		panel2.add(okButton);
		
		
		resetPasswordButton = new JButton("Reset Password");
		panel2.add(resetPasswordButton);
		panel.add(panel2);
		//frame.getContentPane().add(resetPasswordButton);
				
		frame.setVisible(true);
		this.register();
	
		
	}
	
	public void register() {
		
		this.okButton.addActionListener(this);
		this.resetPasswordButton.addActionListener(this);
	}
	

	/*public JButton getOkButton()
	{
		return okButton;
	}
	
	public JButton resetPasswordButton()
	{
		return resetPasswordButton;
	}
	
	@Override
	public void setVisible(Boolean visiblity)
	{
		frame.setVisible(visiblity);
	}*/
	
	//@Override
	public void actionPerformed(ActionEvent actionEvent)
	{
		String username;
		String password;
		
		username = userField.getText();
		password = new String(passField.getPassword());
		if (actionEvent.getActionCommand() == "OK")
		{
			System.out.println("OK Clicked");	
			controller.login("HEY", "abc");			
		}
	}
	
}