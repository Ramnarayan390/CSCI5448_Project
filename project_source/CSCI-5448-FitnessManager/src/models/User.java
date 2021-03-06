package models;
import java.beans.Transient;
import java.util.ArrayList;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;


@MappedSuperclass
public class User {

	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="UID")
	public Long id;
	
	@Column(name="username")
	public String username;
	@Column(name="name")	
	public String name;
	@Column(name="gender")
	public String gender;
	@Column(name="email")
	public String email;
	@Column(name="location")
	public String location;
	@Column(name="securityQuestion")
	private String securityQuestion;
	@Column(name="securityAnswer")
	private String securityAnswer;
	@Column(name="password")
	protected String password;
	
	//@Transient
	//protected ArrayList<Subscriber> subscribers = new ArrayList<Subscriber>();
	public User()
	{;}
	public User(String username, String name, String gender, String email, String location, String securityQuestion, String securityAnswer, String password)	
	{
		this.username = username;
		this.name = name;
		this.gender = gender;
		this.email = email;
		this.location = location;
		this.securityQuestion = securityQuestion;
		this.securityAnswer = securityAnswer;
		this.password = password;		
	}
	public String getUsername() {
		return username;
	}
	
	public void setUsername(String username) {
		this.username = username;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getGender() {
		return gender;
	}
	
	public void setGender(String gender) {
		this.gender = gender;
	}
	
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	
	public String getSecurityQuestion() {
		return securityQuestion;
	}
	
	public void setSecurityQuestion(String securityQuestion) {
		this.securityQuestion = securityQuestion;
	}
	
	public boolean verifyPass(String password)
	{
		return password.equals(this.password);
		
	}
	
	public boolean verifySecurity(String securityAnswer)
	{
		return securityAnswer.equals(this.securityAnswer);
		
	}
	

	public void update(String string)
	{
	 ;
	}
	
	
}
