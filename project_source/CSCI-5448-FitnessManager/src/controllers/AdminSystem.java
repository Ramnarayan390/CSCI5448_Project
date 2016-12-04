package controllers;
import java.util.ArrayList;



import javax.swing.JOptionPane;

import models.*;
import views.*;


public class AdminSystem extends FSystem {

	public AdminSystem()
	{
		;
	}
	
	public AdminSystem(Trainer trainer){
		super.setUser(trainer);		
	}
	
	@Override
	public view showOptions(String option)
	{
		view currentView = null;
		if ( option.equals("createProfile") )
		{
			currentView = new createAdminProfileView();
			//view.setController(controller);
		}
		else if (option.equals("homePage"))
		{
			//currentView = new trainerHomepageView();		
		}
		return currentView;	//
		//view.main("ss");
		// TODO Auto-generated method stub		
	}
		
	
	public Admin getUser()
	{
		return (Admin) super.getUser();
	}
	
	public void createProfile(boolean verified, String skills, String Summary, String username, String name, String gender, String email, String location, String securityQuestion, String securityAnswer, String password)
	{
		System.out.println("wrong constructor");

	}
	
	public void createProfile(String AdminRole, String username, String name, String gender,String email, String location,String securityQuestion, String securityAnswer, String password)
	{
		User user;
		user = new Admin (AdminRole, username, name, gender, email, location, securityQuestion, securityAnswer, password);
		super.setUser(user);	
		
	}
	
}