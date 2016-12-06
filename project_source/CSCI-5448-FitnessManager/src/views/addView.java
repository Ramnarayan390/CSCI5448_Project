package views;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import java.awt.Font;

public class addView implements ActionListener {

	private JFrame frame;
	private JPanel panel;
	private JLabel headerLabel;
	private JButton addButton;
	private JButton updateButton;
	private JButton delButton;
	private JButton homeButton;
	private JComboBox typeText;
	private JLabel typeLabel;
	private JLabel valueLabel;
	private JLabel timeLabel;
	private JComboBox timeText;
	private JTextField valueText;
	private JButton submitButton;
	private static fitnessInfoView mainView;

	public addView(fitnessInfoView mainView) 
	{
		frame = new JFrame("Today's Fitness Info");
		frame.setSize(400,306);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		panel = new JPanel();
		frame.getContentPane().add(panel);
		placeComponents();

		frame.setVisible(true);
		this.mainView = mainView;
	}

	private void placeComponents() {

		panel.setLayout(null);
		headerLabel = new JLabel(""); 
		headerLabel.setFont(new Font("SansSerif", Font.BOLD, 16));
		headerLabel.setBounds(108,25,200,33);
		headerLabel.setText("Adding Fitness Info"); 
		panel.add(headerLabel);

		typeLabel = new JLabel("Type");
		typeLabel.setBounds(30, 70, 110, 25);
		panel.add(typeLabel);
		
		String[] Type = { "Breakfast", "Lunch", "Dinner", "Steps", "Miles" };
		//Create the combo box, select item at index 4.
		//Indices start at 0, so 4 specifies the pig.
		typeText = new JComboBox(Type);
		typeText.setSelectedIndex(2);
		//petList.addActionListener(this);
		typeText.setBounds(140, 72, 100, 20);
		panel.add(typeText);
		
		valueLabel = new JLabel("Value");
		valueLabel.setBounds(30, 100, 53, 25);
		panel.add(valueLabel);
		
		//String[] Value = { "1000", "1500", "2000", "2500", "3000" };
		
		
		//Create the combo box, select item at index 4.
		//Indices start at 0, so 4 specifies the pig.
		//valueText = new JComboBox(Value);
		//valueText.setSelectedIndex(4);
		//petList.addActionListener(this);
		
		valueText = new JTextField(20);
		valueText.setBounds(140, 100, 100, 20);
		panel.add(valueText);
		

		timeLabel = new JLabel("Time");
		timeLabel.setBounds(30, 130, 59, 25);
		panel.add(timeLabel);
		
		String[] Time = { "Morning", "Noon", "Night" };
		//Create the combo box, select item at index 4.
		//Indices start at 0, so 4 specifies the pig.
		timeText = new JComboBox(Time);
		timeText.setSelectedIndex(2);
		//petList.addActionListener(this);
		timeText.setBounds(140, 130, 100, 20);
		panel.add(timeText);
		
		submitButton = new JButton("Submit");
		submitButton.setBounds(140, 211, 100, 25);
		panel.add(submitButton);
		
		this.register();
	}
	
public void register() {
	this.submitButton.addActionListener(this);		
		

	}
	
	
	public void setVisible(Boolean visiblity)
	{
		frame.setVisible(visiblity);
	}
	
	public void actionPerformed(ActionEvent actionEvent)
	{
		//typeText.getSelectedItem().toString();
		//timeText.getSelectedItem().toString();
		//valueText.getText();
		this.mainView.yourAddRow(typeText.getSelectedItem().toString(),valueText.getText(), timeText.getSelectedItem().toString());
		this.setVisible(false);
		
	}

}