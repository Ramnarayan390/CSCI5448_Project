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
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class fitnessInfoView extends view implements ActionListener {

	private JFrame frame;
	private JPanel panel;
	private JLabel headerLabel;
	private JButton addButton;
	private JButton updateButton;
	private JButton delButton;
	private JButton homeButton;
	private JComboBox breakfastChoice;
	private JLabel breakfastText;
	private JComboBox lunchChoice;
	private JLabel lunchText;
	private JComboBox dinnerChoice;
	private JLabel dinnerText;
	private JComboBox distChoice;
	private JLabel distText;
	private JComboBox sleepChoice;
	private JLabel sleepText;
	
	public fitnessInfoView() 
	{
		frame = new JFrame("Today's Fitness Info");
		frame.setSize(850,850);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		panel = new JPanel();
		frame.add(panel);
		placeComponents();

		frame.setVisible(true);
	}

	private void placeComponents() {

		panel.setLayout(null);
		headerLabel = new JLabel(""); 
		headerLabel.setBounds(200,10,200,50);
		headerLabel.setText("Today's Fitness Info"); 
		panel.add(headerLabel);

		addButton = new JButton("Add");
		addButton.setBounds(20, 100, 90, 20);
		panel.add(addButton);
		
		updateButton = new JButton("Update");
		updateButton.setBounds(120, 100, 90, 20);
		panel.add(updateButton);
		
		delButton = new JButton("Delete");
		delButton.setBounds(220, 100, 90, 20);
		panel.add(delButton);
		
		homeButton = new JButton("Home");
		homeButton.setBounds(320, 100, 90, 20);
		panel.add(homeButton);
		
		breakfastText = new JLabel("Breakfast");
		breakfastText.setBounds(10, 200, 90, 25);
		panel.add(breakfastText);
		
		String[] calOptions = { "500", "1000", "1500", "2000", "2500", "3000" };
		//Create the combo box, select item at index 4.
		//Indices start at 0, so 4 specifies the pig.
		breakfastChoice = new JComboBox(calOptions);
		breakfastChoice.setSelectedIndex(5);
		//petList.addActionListener(this);
		breakfastChoice.setBounds(100, 200, 100, 20);
		panel.add(breakfastChoice);
		
		lunchText = new JLabel("Lunch");
		lunchText.setBounds(10, 300, 90, 25);
		panel.add(lunchText);
		
		lunchChoice = new JComboBox(calOptions);
		lunchChoice.setSelectedIndex(5);
		//petList.addActionListener(this);
		lunchChoice.setBounds(100, 300, 100, 20);
		panel.add(lunchChoice);
		
		dinnerText = new JLabel("Dinner");
		dinnerText.setBounds(10, 400, 90, 25);
		panel.add(dinnerText);
		
		dinnerChoice = new JComboBox(calOptions);
		dinnerChoice.setSelectedIndex(5);
		//petList.addActionListener(this);
		dinnerChoice.setBounds(100, 400, 100, 20);
		panel.add(dinnerChoice);
		
		distText = new JLabel("Distance walked");
		distText.setBounds(10, 500, 90, 25);
		panel.add(distText);
		
		distChoice = new JComboBox(calOptions);
		distChoice.setSelectedIndex(5);
		//petList.addActionListener(this);
		distChoice.setBounds(100, 500, 100, 20);
		panel.add(distChoice);
		
		sleepText = new JLabel("Hours Slept");
		sleepText.setBounds(10, 600, 90, 25);
		panel.add(sleepText);
		
		sleepChoice = new JComboBox(calOptions);
		sleepChoice.setSelectedIndex(5);
		//petList.addActionListener(this);
		sleepChoice.setBounds(100, 600, 100, 20);
		panel.add(sleepChoice);
		
		
		this.register();
	}
	
public void register() {
		
		this.addButton.addActionListener(this);
		this.updateButton.addActionListener(this);
		this.delButton.addActionListener(this);
		this.homeButton.addActionListener(this);
	}
	
	@Override
	public void setVisible(Boolean visiblity)
	{
		frame.setVisible(visiblity);
	}
	
	public void actionPerformed(ActionEvent actionEvent)
	{

		if (actionEvent.getActionCommand() == "Add")
		{
			System.out.println("Add Clicked");	
			//controller.login("HEY", "abc");			
		}
		else if (actionEvent.getActionCommand() == "Update")
		{
			System.out.println("Update Clicked");	
			//controller.login("HEY", "abc");			
		}
		else if (actionEvent.getActionCommand() == "Delete")
		{
			System.out.println("Delete Clicked");	
			//controller.login("HEY", "abc");			
		}
		else if (actionEvent.getActionCommand() == "Home")
		{
			System.out.println("Home Clicked");	
			//controller.login("HEY", "abc");			
		}
		
	}

}