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
public class login_page {

	public static void main(String[] args) {
		JFrame frame = new JFrame("Login");
		frame.setSize(400,330);
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
		headerLabel.setText("LOGIN"); 
		panel.add(headerLabel);
		
		JLabel userLabel = new JLabel("User");
		userLabel.setBounds(10, 10, 80, 25);
		panel.add(userLabel);

		JTextField userText = new JTextField(20);
		userText.setBounds(100, 10, 160, 25);
		panel.add(userText);

		JLabel passwordLabel = new JLabel("Password");
		passwordLabel.setBounds(10, 40, 80, 25);
		panel.add(passwordLabel);

		JPasswordField passwordText = new JPasswordField(20);
		passwordText.setBounds(100, 40, 160, 25);
		panel.add(passwordText);
		
		JLabel SecQues = new JLabel("Role");
		SecQues.setBounds(10, 90, 40, 25);
		panel.add(SecQues);
		
		String[] petStrings = { "User", "Trainer", "Admin" };
		//Create the combo box, select item at index 4.
		//Indices start at 0, so 4 specifies the pig.
		JComboBox SecQues1 = new JComboBox(petStrings);
		SecQues1.setSelectedIndex(2);
		//petList.addActionListener(this);
		SecQues1.setBounds(50, 95, 100, 20);
		panel.add(SecQues1);
		
		JButton loginButton4 = new JButton("Login");
		loginButton4.setBounds(50, 150, 80, 20);
		panel.add(loginButton4);
		
		JButton loginButton5 = new JButton("Reset Password");
		loginButton5.setBounds(150, 150, 180, 20);
		panel.add(loginButton5);

		//JButton registerButton = new JButton("register");
		//registerButton.setBounds(180, 130, 80, 25);
		//panel.add(registerButton);


	}

}
