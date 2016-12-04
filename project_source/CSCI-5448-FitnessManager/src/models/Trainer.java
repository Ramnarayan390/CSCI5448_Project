package models;

import java.util.ArrayList;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;


@Entity
@Table(name="soma_krishnamurthy_Trainer" )
public class Trainer extends User {

	@Column(name="Verified")
	public boolean Verified;
	@Column(name="Skills")
	public String Skills;
	@Column(name="Summary")
	public String Summary;
	@Column(name="Schedule")
	public ArrayList<String> schedule;
	public Trainer()
	{
		;
	}
	public Trainer(boolean Verfied, String skills, String Summary, String username, String name, String gender, String email, String location, String securityQuestion, String securityAnswer, String password)
	{
		super(username, name, gender, email, location, securityQuestion, securityAnswer, password);
		this.Verified = Verfied;
		this.Skills = Skills;
		this.Summary = Summary;
		this.schedule = new ArrayList<String>();	
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
	
	public ArrayList<String> getSchedule()
	{
		return this.schedule;
	}
	
	public void addSchedule(String day, String time)
	{
		schedule.add(day + " at " + time);
	}
	
	public void clientSchedule(int index, String name)
	{
		schedule.set(index, schedule.get(index) + " is scheduled with " + name);
	}
	
}
