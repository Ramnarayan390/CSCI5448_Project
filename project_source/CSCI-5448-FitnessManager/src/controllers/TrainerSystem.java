package controllers;
import java.util.ArrayList;



import javax.swing.JOptionPane;

import models.*;
import views.*;


public class TrainerSystem extends FSystem {

	public TrainerSystem()
	{
		;
	}
	
	public TrainerSystem(Trainer trainer){
		super.setUser(trainer);		
	}
	
	@Override
	public View showOptions(String option, Controller controller)
	{
		View currentView = null;
		if ( option.equals("createProfile") )
		{
			currentView = new CreateTrainerProfileView(controller);
			//view.setController(controller);
		}
		else if (option.equals("homePage"))
		{
			currentView = new TrainerHomepageView(controller);		
		}		
		return currentView;	//
		//view.main("ss");
		// TODO Auto-generated method stub
		
	}
	
	
	
	public Trainer getUser()
	{
		return (Trainer) super.getUser();
	}
	
	public void createProfile(boolean verified, String skills, String Summary, String username, String name, String gender, String email, String location, String securityQuestion, String securityAnswer, String password)
	{
		User user;
		user = new Trainer(verified ,skills, Summary, username, name, gender, email, location, securityQuestion, securityAnswer, password);
		super.setUser(user);	
	}
	
	public void createProfile(String AdminRole, String username, String name, String gender,String email, String location,String securityQuestion, String securityAnswer, String password)
	{
		System.out.println("wrong constructor");
		
	}
	public void createProfile(double height, int weight, int age, String username, String name, String gender, String email, String location, String securityQuestion, String securityAnswer, String password)
	{
		System.out.println("wrong constructor");
	}
	public void viewSchedule()
	{
		String[] schedule = this.getUser().getSchedule();
		
		String formatString = "Your current schedule:\n";
		for (int i = 0; i < schedule.length; i++)
		{
				formatString += (i+1) + ". " + schedule[i] + "\n";
		}
		JOptionPane.showMessageDialog(null, formatString);
	}
	
	public void editSchedule(Controller controller)
	{
		DbSearch db = new DbSearch(controller);
		
		this.viewSchedule();
		String dayToAdd = JOptionPane.showInputDialog(null, "What day would you like to add?");
		String timeToAdd = JOptionPane.showInputDialog(null, "What time would you like to add for " + dayToAdd + "?");

		this.getUser().addSchedule(dayToAdd, timeToAdd);
		
		db.updateDB("Trainer", "Schedule", this.getUser().getSchedule(), this.getUser().getUsername());
		
		JOptionPane.showMessageDialog(null, "Successfully Added!");
	}
	
}
