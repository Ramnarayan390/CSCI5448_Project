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

public class Controller {

	//private Model model;
	public View view;
	public SessionFactory userDB;
	public FSystem fsystem;
	public String usertype;
	public SystemFactory factory;
 
	//private ActionListener actionListner;
	
	public Controller(View view)
	{
		
		this.view = view;
		factory = new SystemFactory();		
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
		
		List result;
		DbSearch db = new DbSearch(this);
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

			}
			else
			{
				System.out.println(user.username + "incorrect passowrd");
			}
		}

	}
	
	public void display(String userType, String displayType)
	{
		
		view.setVisible(false);
		if ( displayType.equals("login"))
		{
			
			System.out.println("login view");
			this.view = new LoginPageView(this);

			
		}
		else
		{

			System.out.println("fsystem set");
			this.view = fsystem.showOptions(displayType,this);

		}
		
	}
	
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