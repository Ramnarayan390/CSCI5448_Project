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
public class trainer_home {

	public static void main(String[] args) {
		JFrame frame = new JFrame("Login Page");
		frame.setSize(850,850);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		JPanel panel = new JPanel();
		frame.add(panel);
		placeComponents(panel);

		frame.setVisible(true);
	}

	private static void placeComponents(JPanel panel) {

		panel.setLayout(null);

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
		
		JLabel emailLabel = new JLabel("Email");
		emailLabel.setBounds(300, 10, 80, 25);
		panel.add(emailLabel);

		JTextField userText1 = new JTextField(20);
		userText1.setBounds(400, 10, 160, 25);
		panel.add(userText1);
		
		JLabel LocationLabel = new JLabel("Location");
		LocationLabel.setBounds(300, 40, 80, 25);
		panel.add(LocationLabel);

		JTextField userText2 = new JTextField(20);
		userText2.setBounds(400, 40, 160, 25);
		panel.add(userText2);
		
		JLabel SecQues = new JLabel("Security Question");
		SecQues.setBounds(10, 70, 80, 25);
		panel.add(SecQues);
		
		String[] petStrings = { "Bird", "Cat", "Dog", "Rabbit", "Pig" };
		//Create the combo box, select item at index 4.
		//Indices start at 0, so 4 specifies the pig.
		JComboBox SecQues1 = new JComboBox(petStrings);
		SecQues1.setSelectedIndex(4);
		//petList.addActionListener(this);
		SecQues1.setBounds(100, 70, 100, 20);
		panel.add(SecQues1);
		
		//JTextField userText3 = new JTextField(20);
		//userText3.setBounds(100, 70, 160, 25);
		//panel.add(userText3);
		
		JLabel Answer = new JLabel("Answer");
		Answer.setBounds(300, 70, 80, 25);
		panel.add(Answer);

		JTextField userText4 = new JTextField(20);
		userText4.setBounds(400, 70, 160, 25);
		panel.add(userText4);
		
		JLabel Gender = new JLabel("Gender");
		Gender.setBounds(10, 100, 80, 25);
		panel.add(Gender);
		
		JRadioButton Male = new JRadioButton("Male");
		Male.setBounds(100, 100, 80, 25);
		panel.add(Male);
		
		JRadioButton Female = new JRadioButton("Female");
		Female.setBounds(190, 100, 80, 25);
		panel.add(Female);
		    
		
		JLabel Skills = new JLabel("Skills");
		Skills.setBounds(10, 200, 80, 25);
		panel.add(Skills);
		
		JTextArea textArea = new JTextArea(200, 200);
		JScrollPane scrollPane = new JScrollPane(textArea);
		
		scrollPane.setBounds(100, 200, 200, 200);
		panel.add(scrollPane);
		
		JLabel Summary = new JLabel("Summary");
		Summary.setBounds(10, 500, 80, 25);
		panel.add(Summary);
		
		JTextArea textArea1 = new JTextArea(500, 200);
		JScrollPane scrollPane1 = new JScrollPane(textArea1);
		
		scrollPane1.setBounds(100, 500, 500, 200);
		panel.add(scrollPane1);
		
		JButton loginButton = new JButton("Submit");
		loginButton.setBounds(400, 750, 80, 25);
		panel.add(loginButton);
		
		//JButton registerButton = new JButton("register");
		//registerButton.setBounds(180, 130, 80, 25);
		//panel.add(registerButton);


	}

}
