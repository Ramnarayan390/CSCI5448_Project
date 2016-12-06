package controllers;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import models.*;
public class dbSearch {

	private controller controller;
	
	public dbSearch (controller controller){
		this.controller = controller;
	}
	
	public List searchDBList(String table, String fieldName, boolean fieldValue)
	{
		System.out.println("Query Begin");
		Session session = controller.createDBSesssion(controller.userDB);
		System.out.println("Query  :  " + "from " + table + " as T where T." + fieldName + "= :field" + "  fieldvalue : "+ fieldValue);
		Query q = session.createQuery("from " + table + " as T where T." + fieldName + "= :field");	
		System.out.println("Query2  " + "from " + table + " as T where T." + fieldName + "= :field");
		//q.setString("field",  fieldValue);
		q.setParameter("field",  fieldValue);
		
		
		List result = q.list();
		session = controller.closeDBSession(session);
		return result;
	}
	
	public List searchDBList(String table, String fieldName, String fieldValue)
	{
		System.out.println("Query Begin");
		Session session = controller.createDBSesssion(controller.userDB);
		System.out.println("Query  :  " + "from " + table + " as T where T." + fieldName + "= :field" + "  fieldvalue : "+ fieldValue);
		Query q = session.createQuery("from " + table + " as T where T." + fieldName + "= :field");	
		System.out.println("Query2  " + "from " + table + " as T where T." + fieldName + "= :field");
		q.setString("field",  fieldValue);		
		
		List result = q.list();
		session = controller.closeDBSession(session);
		return result;
	}
	
	public List searchDBList(String table)
	{
		//System.out.println("Query Begin");
		Session session = controller.createDBSesssion(controller.userDB);
		//System.out.println("Query  :  " + "from " + table + " as T where T." + fieldName + "= :field" + "  fieldvalue : "+ fieldValue);
		Query q = session.createQuery("from " + table);	
		//System.out.println("Query2  " + "from " + table + " as T where T." + fieldName + "= :field");		
		
		List result = q.list();
		session = controller.closeDBSession(session);
		return result;
	}
	
	public User searchDBUser(String table, String field)
	{
		Session session = controller.createDBSesssion(controller.userDB);
		Query q = session.createQuery("from" + table + "as T where T.field = :field");	
		q.setString("field",  field);
		List result = q.list();
		session = controller.closeDBSession(session);
		return (User)result.get(0);
	}
	
	
	
	public void updateDB(String table, String fieldName, boolean fieldValue)
	{
		String query;
		Session session = controller.createDBSesssion(controller.userDB);
		query = "UPDATE " + table + " set " + fieldName + "=:field";
				
		System.out.println(query);
		Query q = session.createQuery(query);
		q.setParameter("field",  fieldValue);
		//"FROM RoomTable AS E WHERE E.roomType = :Type and E.roomStatus =:Status";
		q.executeUpdate();
		session = controller.closeDBSession(session);			
	}
	
	public void updateDB(String table, String fieldName, boolean fieldValue, String username)
	{
		String query;
		Session session = controller.createDBSesssion(controller.userDB);
		query = "UPDATE " + table + " set " + fieldName + "=:field where username = :username";
				
		System.out.println(query);
		Query q = session.createQuery(query);
		q.setParameter("field",  fieldValue);
		q.setParameter("username",  username);
		//"FROM RoomTable AS E WHERE E.roomType = :Type and E.roomStatus =:Status";
		q.executeUpdate();
		session = controller.closeDBSession(session);			
	}
	
	public void updateDB(String table, String fieldName, Object[][] fieldValue, String username)
	{
		String query;
		Session session = controller.createDBSesssion(controller.userDB);
		query = "UPDATE " + table + " set " + fieldName + "=:field where username = :username";
				
		System.out.println(query);
		Query q = session.createQuery(query);
		q.setParameter("field",  fieldValue);
		q.setParameter("username",  username);
		//"FROM RoomTable AS E WHERE E.roomType = :Type and E.roomStatus =:Status";
		q.executeUpdate();
		session = controller.closeDBSession(session);			
	}
	
	public void updateDB(String table, String fieldName, ArrayList<String> fieldValue, String username)
	{
		String query;
		Session session = controller.createDBSesssion(controller.userDB);
		query = "UPDATE " + table + " set " + fieldName + "=:field where username = :username";
				
		System.out.println(query);
		Query q = session.createQuery(query);
		q.setParameter("field",  fieldValue);
		q.setParameter("username",  username);
		//"FROM RoomTable AS E WHERE E.roomType = :Type and E.roomStatus =:Status";
		q.executeUpdate();
		session = controller.closeDBSession(session);			
	}
	
}
