package views;

import java.awt.event.ActionEvent;
import models.*;
import controllers.*;


import java.util.*;
import java.awt.event.*;
import javax.swing.*;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
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

public class adminApproveProfileView extends view implements ActionListener {

	private JFrame frame;
	private JPanel panel;
	private JLabel headerLabel;
	private JButton addButton;
	private JButton updateButton;;
	private JButton logoutButton;
	private JTable table;
	private JLabel tableLabel;
	private DefaultTableModel model;
	private  Object[][] data;
	private List list;
	
	private int index;
	
	public adminApproveProfileView(controller controller) 
	{
		super(controller);
		frame = new JFrame("Admin Welcome");
		frame.setSize(500,500);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		panel = new JPanel();
		frame.add(panel);
		placeComponents();

		frame.setVisible(true);
	}

	private void placeComponents() {

		panel.setLayout(null);
		headerLabel = new JLabel(""); 
		headerLabel.setBounds(150,10,200,50);
		headerLabel.setText("Welcom Admin"); 
		panel.add(headerLabel);
		
		headerLabel = new JLabel("Unverfied trainer profiles"); 
		headerLabel.setBounds(20,120,200,20);
		panel.add(headerLabel);

		/*addButton = new JButton("Add");
		addButton.setBounds(20, 100, 90, 20);
		panel.add(addButton);*/
		
		updateButton = new JButton("Verify");
		updateButton.setBounds(90, 100, 90, 20);
		panel.add(updateButton);
		
		/*delButton = new JButton("Delete");
		delButton.setBounds(220, 100, 90, 20);
		panel.add(delButton);*/
		
		logoutButton = new JButton("LogOut");
		logoutButton.setBounds(220, 100, 90, 20);
		panel.add(logoutButton);
		
		String[] columns = new String[] {
	            "Id", "Name", "Verify"
	        };
	         
	        //actual data for the table in a 2d array
	        data = new Object[][] {	        };
	         
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
	         
	        table = new JTable(model);
	         
	        table.setBounds(20, 150, 400, 200);
			panel.add(table);
		this.index = 1;
		list = populateTable();
		this.register();
	}
	
	private List populateTable()
	{
		List<User> result;
		dbSearch db = new dbSearch(controller);
		result = db.searchDBList("Trainer","Verified",false);
		
		if (result.isEmpty())
			System.out.println("empty list");
		else
		{
			for(User temp : result)
			{
				
				System.out.println(temp.username);
				yourAddRow(new Integer(index++).toString(), temp.username,false);
			}
		}
		return result;
		
	}
	
	public void register() {
		
		//this.addButton.addActionListener(this);
		this.updateButton.addActionListener(this);
		//this.delButton.addActionListener(this);
		this.logoutButton.addActionListener(this);
	}
	
	@Override
	public void setVisible(Boolean visiblity)
	{
		frame.setVisible(visiblity);
		
	}
	
	public void actionPerformed(ActionEvent actionEvent)
	{

	/*	if (actionEvent.getActionCommand() == "Add")
		{
			System.out.println("Add Clicked");	
			yourAddRow(1,"2",true);
			//controller.login("HEY", "abc");			
		}*/
		if (actionEvent.getActionCommand() == "Verify")
		{
	
			dbSearch db = new dbSearch(controller);
			System.out.println("Update Clicked");	
			for (int i=0; i<table.getRowCount();i++)
			{
				if((boolean)table.getValueAt(i, 2))
				{
					System.out.println(table.getValueAt(i,1));
					db.updateDB("Trainer","Verified",true,(String)table.getValueAt(i,1));
					//reference : http://stackoverflow.com/questions/1117888/how-to-remove-a-row-from-jtable
					((DefaultTableModel)table.getModel()).removeRow(i);
				}
			}
		}
		else if (actionEvent.getActionCommand() == "LogOut")
		{
			//System.out.println("Home Clicked");	
			controller.view.setVisible(false);
			controller.view = new startupView(controller);	
			
		}

		
	}
	//Reference : http://stackoverflow.com/questions/3549206/how-to-add-row-in-jtable
	public void yourAddRow(String str1, String str2, boolean str3){
		  DefaultTableModel yourModel = (DefaultTableModel) table.getModel();
		  yourModel.addRow(new Object[]{str1, str2, str3});
		}

}