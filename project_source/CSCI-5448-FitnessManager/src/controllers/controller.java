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

	//private Model model;
	public view view;
	public SessionFactory userDB;
	public FSystem fsystem;
	public String usertype;
	public systemFactory factory;
 
	//private ActionListener actionListner;
	
	public controller(view view)
	{
		
		this.view = view;
		factory = new systemFactory();		
		this.userDB = new Configuration().configure().buildSessionFactory();
	

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

	
	public boolean user_exists(String username)
	{
	
		Session session = createDBSesssion(this.userDB);		
		Query q = session.createQuery("from Trainer as T where T.username = :username");		
		q.setString("username",  username);
		List result = q.list();		
		session = closeDBSession(session);
		return !result.isEmpty();
	}
	
	public void login(String username, String password) //add type for login
	{
		
		//Session session = createDBSesssion(this.userDB);		
		//Query q = session.createQuery("from Trainer as T where T.username = :username");		
		//q.setString("username",  username);
		//List result = q.list();
		List result;
		dbSearch db = new dbSearch(this);
		System.out.print("usertype" + this.usertype + username);
		result = db.searchDBList(this.usertype,"username",username);
		System.out.print("result.get(0).username" + "db class works");
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
				this.fsystem.user = user;
				System.out.println("Login Successfull");
				display("Trainer","homePage");
				
				
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
		//System.out.println("DB almost");			
		//session = closeDBSession(session);
	}
	
	public void display(String userType, String displayType)
	{
		
		view.setVisible(false);
		if ( displayType.equals("login"))
		{
			
			System.out.println("login view");
			this.view = new loginPageView(this);
			//view.setController(this);
			
		}
		else
		{
			System.out.println("other view");
			//systemFactory factory = new systemFactory();
			//this.fsystem = factory.getSystem(userType);
			System.out.println("fsystem set");
			//view.setVisible(false);

			this.view = fsystem.showOptions(displayType,this);
			//view.setController(this);
		}
		
	}
	
	/*public void createProfile(String profileType, String display)
	{
		System.out.println("create profile");
		//systemFactory factory = new systemFactory();
		//this.fsystem = factory.getSystem(profileType);		
		System.out.println("got factory");
	}*/
	
	/*public void createProfile(String...values)
	{
		Session session = this.createDBSesssion(this.getUserDB());
		//this.fsystem.createProfile(false, skills, Summary, username, name, gender, email, location, securityQuestion, securityAnswer, password);
		this.fsystem.createProfile(values);
		session.save(this.fsystem.getUser());
		session = this.closeDBSession(session);
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