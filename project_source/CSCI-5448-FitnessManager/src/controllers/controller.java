package controllers;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import models.*;
import views.*;

public class controller implements ActionListener {

	private Model model;
	private view view;
	private SessionFactory userDB;
	

	//private ActionListener actionListner;
	
	public controller(Model model, view view)
	{
		this.model = model;
		this.view = view;	
		this.userDB = new Configuration().configure().buildSessionFactory();
	}
	
	protected void finalize()
	{
		userDB.close();
	}
	public void control()
	{
		view.getOkButton().addActionListener(this);
		view.resetPasswordButton().addActionListener(this);

	}
	private void updateCount()
	{
		model.incrementX();

	}
	
	
	
	public void actionPerformed(ActionEvent actionEvent)
	{
		System.out.println(actionEvent.getActionCommand());
		updateCount();
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