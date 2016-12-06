package controllers;

import org.hibernate.Session;
import org.hibernate.SessionFactory;


import models.*;
import views.*;

public abstract class FSystem {

	public User user;

	public User getUser() {
		return user;
	}
	
	public void setUser(User user) {
		this.user = user;
	}
	
	public void deleteProfile() {
	/*	SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		session.delete(this.user);
		session.getTransaction().commit();
		session.close();
		sessionFactory.close();*/
	}
	
	
	//public abstract void createProfile();
	public abstract void createProfile(boolean Verfied, String skills, String Summary, String username, String name, String gender, String email, String location, String securityQuestion, String securityAnswer, String password);
	//public abstract void createProfile(String...values);
	public abstract void createProfile(String AdminRole, String username, String name, String gender,String email, String location,String securityQuestion, String securityAnswer, String password);
	public abstract void createProfile(double height, int weight, int age, String username, String name, String gender, String email, String location, String securityQuestion, String securityAnswer, String password);
	public abstract View showOptions(String option, Controller controller);  //view view = new view();
	
	
}
