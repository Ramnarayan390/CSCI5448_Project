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

}
