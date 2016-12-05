package models;

import java.util.ArrayList;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;


@Entity
@Table(name="Client" )
public class Client extends User {

	@Column(name="Height")
	public double height;
	@Column(name="Weight")
	public int weight;
	@Column(name="Age")
	public int age;

	public Client()
	{
		;
	}
	public Client(double height, int weight, int age, String username, String name, String gender, String email, String location, String securityQuestion, String securityAnswer, String password)
	{
		super(username, name, gender, email, location, securityQuestion, securityAnswer, password);
		this.height = height;
		this.weight = weight;
		this.age = age;	
	}
	
	public double getHeight()
	{
		return this.height;
	}
	
	public int getWeight()
	{
		return this.weight;
	}
	
	public int getAge()
	{
		return this.age;
	}
	
	public void setHeight(double height)
	{
		this.height = height;
	}
	
	public void setWeight(int weight)
	{
		this.weight = weight;
	}
	
	public void setAge(int age)
	{
		this.age = age;
	}
	
}
