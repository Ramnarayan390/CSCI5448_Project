package models;

public class Trainer extends User {

	public boolean Verified;
	public String skills;
	public String Summary;
	
	
	public boolean isVerified() {
		return Verified;
	}
	
	public void setVerified(boolean verified) {
		Verified = verified;
	}
	
	public String getSkills() {
		return skills;
	}
	
	public void setSkills(String skills) {
		this.skills = skills;
	}
	
	public String getSummary() {
		return Summary;
	}
	
	public void setSummary(String summary) {
		Summary = summary;
	}
	
	
	
}
