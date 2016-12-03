package models;

import javax.persistence.AttributeOverride;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="soma_krishnamurthy_Book" )
public class Trainer extends User {

	@Column(name="Verified")
	public boolean Verified;
	@Column(name="Skills")
	public String Skills;
	@Column(name="Summary")
	public String Summary;
	
	
	public Trainer(boolean Verfied, String skills, String Summary, String username, String name, String gender, String email, String location, String securityQuestion, String securityAnswer, String password)
	{
		super(username, name, gender, email, location, securityQuestion, securityAnswer, password);
		this.Verified = Verfied;
		this.Skills = Skills;
		this.Summary = Summary;
		
	}
	public boolean isVerified() {
		return Verified;
	}
	
	public void setVerified(boolean verified) {
		Verified = verified;
	}
	
	public String getSkills() {
		return Skills;
	}
	
	public void setSkills(String skills) {
		this.Skills = skills;
	}
	
	public String getSummary() {
		return Summary;
	}
	
	public void setSummary(String summary) {
		Summary = summary;
	}
	
	
	
}
