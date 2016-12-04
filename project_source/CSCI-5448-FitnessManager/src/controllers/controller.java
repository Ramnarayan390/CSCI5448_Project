package controllers;

//import java.awt.*;
import java.util.*;
import java.awt.event.*;
import javax.swing.*;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import models.*;
import views.*;

public class controller {

	private Model model;
	private view view;
	public SessionFactory userDB;
	public FSystem fsystem;
	public String name;

	//private ActionListener actionListner;
	
	public controller(Model model, view view)
	{
		this.model = model;
		this.view = view;
		
		//this.view.register();
		this.userDB = new Configuration().configure().buildSessionFactory();
		this.view.setController(this);
		this.name = "abc";
	}
	
	
	protected void finalize()
	{
		System.out.println("Controller Destructor");
		userDB.close();
	}
	public void control()
	{
		
		//view.getOkButton().addActionListener(this);
		//view.resetPasswordButton().addActionListener(this);


	}
	private void updateCount()
	{
		model.incrementX();

	}
	
	public boolean user_exists(String username)
	{
	
		Session session = createDBSesssion(this.userDB);		
		Query q = session.createQuery("from Trainer as T where T.username = :username");		
		q.setString("username",  username);
		List result = q.list();		
		session = closeDBSession(session);
		return !result.isEmpty();
	}
	
	public void login(String username, String password)
	{
		
		Session session = createDBSesssion(this.userDB);		
		Query q = session.createQuery("from Trainer as T where T.username = :username");		
		q.setString("username",  username);
		List result = q.list();
		
		
		if (result.isEmpty()) 
		{
			System.out.println("Incorrect Username");
		}
		else
		{

			User user = (User)result.get(0);			
			if(  user.verifyPass(password) )
			{
				System.out.println("Login Successfull");
				
				//do system factory here
				/*FSystem system = new TrainerSystem((Trainer)user); //based on the login type change this	
				view.setVisible(false);
				// view = null;
				this.view=system.showOptions("createProfile");
				view.setController(this);*/
			}
			else
			{
				System.out.println(user.username + "incorrect passowrd");
			}
		}
		System.out.println("DB almost");			
		session = closeDBSession(session);
	}
	
	public void display(String userType, String displayType)
	{
		
		if ( displayType.equals("login"))
		{
			view.setVisible(false);
			this.view = new loginView();
			view.setController(this);
			
		}
		else
		{
			systemFactory factory = new systemFactory();
			this.fsystem = factory.getSystem(userType);
			view.setVisible(false);
			this.view = fsystem.showOptions("createProfile");
			view.setController(this);
		}
		
	}
	
	/*public void createProfile(String profileType, String display)
	{
		System.out.println("create profile");
		//systemFactory factory = new systemFactory();
		//this.fsystem = factory.getSystem(profileType);		
		System.out.println("got factory");
	}*/
	
	public FSystem getFsystem() {
		return fsystem;
	}

	
	public SessionFactory getUserDB() {
		return userDB;
	}


	public Session createDBSesssion(SessionFactory sessionFactory)
	{
		//provides session instances
		System.out.println("1");
		Session session = sessionFactory.openSession();
		System.out.println("2");
		session.beginTransaction();
		System.out.println("3");
		return session;
	}
	
	public Session closeDBSession(Session session)
	{
		
        //commits transaction and closes session instance
		session.getTransaction().commit();
        session.close();        
		return null;
	}
}