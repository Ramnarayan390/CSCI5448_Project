package views;

import java.awt.event.ActionEvent;
import controllers.*;
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
	
	public fitnessInfoView(controller controller) 
	{
		super(controller);
		frame = new JFrame("Today's Fitness Info");
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
		headerLabel.setBounds(150,10,200,50);
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
		
		String[] columns = new String[] {
	            "Id", "Name", "Verify"
	        };
	         
	        //actual data for the table in a 2d array
	        Object[][] data = new Object[][] {
	            {"1", "John", false },
	            {"2", "Rambo", false },
	            {"3", "Zorro", false },
	        };
	         
	        final Class[] columnClass = new Class[] {
	            String.class, String.class, Boolean.class
	        };
	 
	        //create table model with data
	        DefaultTableModel model = new DefaultTableModel(data, columns) {
	 
	            @Override
	            public boolean isCellEditable(int row, int column)
	            {
	                return true;
	            }
	 
	            @Override
	            public Class<?> getColumnClass(int columnIndex)
	            {
	                return columnClass[columnIndex];
	            }
	        };
	         
	        JTable table = new JTable(model);
	         
	        table.setBounds(20, 150, 400, 200);
			panel.add(table);
		
		
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