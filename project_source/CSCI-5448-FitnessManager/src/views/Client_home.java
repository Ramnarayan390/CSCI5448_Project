package views;

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
public class Client_home {

	public static void main(String[] args) {
		JFrame frame = new JFrame("Client Homepage");
		frame.setSize(500,500);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		JPanel panel = new JPanel();
		frame.add(panel);
		placeComponents(panel);

		frame.setVisible(true);
	}

	private static void placeComponents(JPanel panel) {

		panel.setLayout(null);
		JLabel headerLabel;
		headerLabel = new JLabel(""); 
		headerLabel.setBounds(200,10,100,10);
		headerLabel.setText("Welcome User"); 
		panel.add(headerLabel);
		
		JButton loginButton = new JButton("Update profile");
		loginButton.setBounds(50, 50, 180, 50);
		panel.add(loginButton);
		
		JButton loginButton1 = new JButton("Delete Profile");
		loginButton1.setBounds(250, 50, 180, 50);
		panel.add(loginButton1);
		
		JButton loginButton2 = new JButton("Manage Daily Info");
		loginButton2.setBounds(50, 150, 180, 50);
		panel.add(loginButton2);
		
		JButton loginButton3 = new JButton("Manage Fitness Goals");
		loginButton3.setBounds(250, 150, 180, 50);
		panel.add(loginButton3);
		
		JButton loginButton4 = new JButton("Search Trainers");
		loginButton4.setBounds(50, 250, 180, 50);
		panel.add(loginButton4);
		
		JButton loginButton5 = new JButton("Rate Trainer");
		loginButton5.setBounds(250, 250, 180, 50);
		panel.add(loginButton5);

		//JButton registerButton = new JButton("register");
		//registerButton.setBounds(180, 130, 80, 25);
		//panel.add(registerButton);


	}

}
