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
	private SessionFactory userDB;
	private FSystem fsystem;
	

	//private ActionListener actionListner;
	
	public controller(Model model, view view)
	{
		this.model = model;
		this.view = view;
		this.view.setController(this);
		//this.view.register();
		this.userDB = new Configuration().configure().buildSessionFactory();
	}
	
	protected void finalize()
	{
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
				FSystem system = new TrainerSystem((Trainer)user); //based on the login type change this	
				view.setVisible(false);
				// view = null;
				system.showOptions();
			}
			else
			{
				System.out.println(user.username + "incorrect passowrd");
			}
		}
			//System.out.println("OK Clicked");			
		session = closeDBSession(session);
	}
	
	
	public Session createDBSesssion(SessionFactory sessionFactory)
	{
		//provides session instances
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		return session;
	}
	
	public Session closeDBSession(Session session)
	{
		
        //commits transaction and closes session instance
		session.getTransaction().commit();
        session.close();        
		return session;
	}
}