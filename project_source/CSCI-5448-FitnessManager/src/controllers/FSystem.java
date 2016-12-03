package controllers;

import org.hibernate.Session;
import org.hibernate.SessionFactory;


import models.*;
import views.*;

public abstract class FSystem {

	private User user;

	public User getUser() {
		return user;
	}
	
	public void setUser(User user) {
		this.user = user;
	}
	
	public void deleteProfile() {
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		session.delete(this.user);
		session.getTransaction().commit();
		session.close();
		sessionFactory.close();
	}
	
	
	
	abstract void showOptions();  //view view = new view();
	
	
}
