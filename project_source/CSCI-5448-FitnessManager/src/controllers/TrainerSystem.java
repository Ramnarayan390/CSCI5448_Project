package controllers;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import models.Trainer;

public class TrainerSystem extends FSystem {

	
	public TrainerSystem(Trainer trainer){
		super.setUser(trainer);		
	}
	
	@Override
	void showOptions()
	{
		createTrainerProfileView view = new createTrainerProfileView();
		//view.main("ss");
		// TODO Auto-generated method stub
		
	}
	
	public Trainer getUser()
	{
		return (Trainer) super.getUser();
	}

	
/*	public void viewSchedule()
	{
		ArrayList<String> schedule = this.getUser().getSchedule();
		
		String formatString = "";
		for (int i = 0; i < schedule.size(); i++)
		{
				formatString += (i+1) + ". " + schedule.get(i) + "\n";
		}
		JOptionPane.showMessageDialog(null, formatString);
	}*/
	
	private void editSchedule()
	{
		//this.viewSchedule();
		String dayToAdd = JOptionPane.showInputDialog(null, "What day would you like to add?");
		String timeToAdd = JOptionPane.showInputDialog(null, "What time would you like to add for " + dayToAdd + "?");

		//this.getUser().changeSchedule(dayToAdd, timeToAdd, this.getUser().getName());

		this.getUser().changeSchedule(dayToAdd, timeToAdd);

		JOptionPane.showMessageDialog(null, "Successfully Added!");
	}
	
}
