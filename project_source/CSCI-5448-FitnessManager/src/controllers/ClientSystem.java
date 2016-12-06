package controllers;

import models.*;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import org.hibernate.Query;
import org.hibernate.Session;

import models.*;
import views.*;

public class ClientSystem extends FSystem {

	
	public ClientSystem(Client client){
		super.setUser(client);		
	}
	
	public ClientSystem(){
		;		
	}
	
	public Client getUser()
	{
		return (Client) super.getUser();
	}
	
	@Override
	public view showOptions(String option, controller controller)
	{
		view currentView = null;
		if ( option.equals("createProfile") )
		{
			currentView = new createClientProfileView(controller);
			//view.setController(controller);
		}
		else if (option.equals("homePage"))
		{
			currentView = new clientHomepageView(controller);		
			//System.out.println("Show admin homepage");
		}
		else if (option.equals("fitnessInfo"))
		{
			currentView = new fitnessInfoView(controller);		
		}
		return currentView;	//
		
	}
	
	public void scheduleAppointment(controller controller)
	{
		dbSearch db = new dbSearch(controller);
		
		List result = db.searchDBList("Trainer");				
		ArrayList<Trainer> trainersList = (ArrayList<Trainer>) result;
		String formatString = "";
		for (int i = 0; i < trainersList.size(); i++)
		{
			formatString += (i+1) + " " + trainersList.get(i).getName() + "\n";
		}
		String trainerID = JOptionPane.showInputDialog(null, "Please enter the number of the trainer you wish to view the schedule of.\n" + formatString);
		int tID = Integer.parseInt(trainerID);
		tID--;
		String[] schedule = trainersList.get(tID).getSchedule();
		
		for (int i = 0; i < schedule.length; i++)
		{
			formatString += (i+1) + ". " + schedule[i] + "\n";
		}
		String scheduleID = JOptionPane.showInputDialog(null, "Please enter the number of the slot you would like to book:\n" + formatString);
		int sID = Integer.parseInt(scheduleID);
		trainersList.get(tID).addClientToSchedule(sID-1, super.getUser().getName());
		db.updateDB("Trainer", "Schedule", trainersList.get(tID).getSchedule(), trainersList.get(tID).getUsername());
		JOptionPane.showMessageDialog(null, "Appointment successfully added!");
	}

	public void createProfile(boolean verified, String skills, String Summary, String username, String name, String gender, String email, String location, String securityQuestion, String securityAnswer, String password)
	{
		System.out.println("wrong constructor");

	}
	
	public void createProfile(String AdminRole, String username, String name, String gender,String email, String location,String securityQuestion, String securityAnswer, String password)
	{
		//User user;
		//user = new Admin (AdminRole, username, name, gender, email, location, securityQuestion, securityAnswer, password);
		//super.setUser(user);	
		System.out.println("wrong constructor");

	}
	public void createProfile(double height, int weight, int age, String username, String name, String gender, String email, String location, String securityQuestion, String securityAnswer, String password)
	{
		User user;
		user = new Client (height, weight, age, username, name, gender, email, location, securityQuestion, securityAnswer, password);
		super.setUser(user);	
	}
}
