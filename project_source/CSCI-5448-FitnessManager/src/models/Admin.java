package models;

import java.util.ArrayList;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="Admin" )
public class Admin extends User{
	
	@Column(name="adminRole")
	private String adminRole;
	
	public Admin(String adminRole, String username, String name, String gender, String email, String location, String securityQuestion, String securityAnswer, String password)
	{
		super(username, name, gender, email, location, securityQuestion, securityAnswer, password);

		this.adminRole = adminRole;
	
	}

}
