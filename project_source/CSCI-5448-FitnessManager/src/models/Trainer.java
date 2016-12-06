package models;


import java.util.ArrayList;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;


@Entity
@Table(name="Trainer" )
public class Trainer extends User {

	@Column(name="Verified")
	public boolean Verified;
	@Column(name="Skills")
	public String Skills;
	@Column(name="Summary")
	public String Summary;
	@Column(name="Schedule")
	public String[] schedule;
	public Trainer()
	{
		;
	}
	public Trainer(boolean Verfied, String skills, String Summary, String username, String name, String gender, String email, String location, String securityQuestion, String securityAnswer, String password)
	{
		super(username, name, gender, email, location, securityQuestion, securityAnswer, password);
		this.Verified = Verfied;
		this.Skills = skills;
		this.Summary = Summary;
		this.schedule = new String[1];
		this.schedule[0] = "";
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
	
	public String[] getSchedule()
	{
		return this.schedule;
	}
	
	private void setSchedule(String[] schedule)
	{
		this.schedule = schedule;
	}
	
	public void addSchedule(String day, String time)
	{
		if (this.getSchedule()[this.getSchedule().length-1] != "")
		{
			String[] newSchedule = new String[this.getSchedule().length+1];
			for (int i=0;i<this.schedule.length;i++)
			{
				newSchedule[i] = getSchedule()[i];
			}	
			this.setSchedule(newSchedule);
		}
		this.getSchedule()[this.getSchedule().length-1] = day + " at " + time;
	}
	
	public void addClientToSchedule(int index, String name)
	{
		schedule[index] = schedule[index] + " is scheduled with " + name;
	}
	
}
