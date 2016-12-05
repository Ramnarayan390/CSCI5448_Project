package controllers;

import models.*;

import java.util.ArrayList;


import javax.swing.JOptionPane;

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
	
	private void showFitness()
	{
		
	}
	
	private void addFitness()
	{
		
	}
	
	private void modifyFitness()
	{
		
	}
	
	private void deleteFitness()
	{
		
	}
	
	private void seeGoals()
	{
		
	}
	
	private void searchTrainers()
	{
		
	}
	
	private void scheduleAppointment()
	{
		//ArrayList<Trainer> trainersList = controller.searchDB("trainers");
/*		String formatString = "";
		for (int i = 0; i < trainersList.size(); i++)
		{
			formatString += i + " " + trainersList.get(i).getName();
		}
		String trainerID = JOptionPane.showInputDialog(null, "Please enter the number of the trainer you wish to view the schedule of.\n" + formatString);
		int tID = Integer.parseInt(trainerID);
		ArrayList<String> schedule = trainersList.get(tID).getSchedule();
		
		for (int i = 0; i < schedule.size(); i++)
		{
			formatString += (i+1) + ". " + schedule.get(i) + "\n";
		}
		String scheduleID = JOptionPane.showInputDialog(null, "Please enter the number of the slot you would like to book:\n" + formatString);
		int sID = Integer.parseInt(scheduleID);
		trainersList.get(tID).clientSchedule(sID, super.getUser().getName());
		JOptionPane.showMessageDialog(null, "Appointment successfully added!");*/
	}
	
	private void reviewTrainer()
	{
		
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
