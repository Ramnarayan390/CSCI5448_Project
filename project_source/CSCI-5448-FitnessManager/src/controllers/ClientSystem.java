package controllers;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import models.*;
import views.*;

public class ClientSystem extends FSystem {

	
	public ClientSystem(Client client){
		super.setUser(client);		
	}
	
	public Client getUser()
	{
		return (Client) super.getUser();
	}
	
	@Override
	void showOptions()
	{
		// TODO Auto-generated method stub
		
	}
	
	private void showFitness()
	{
		
	}
	
	private void addFitness()
	{
		
	}
	
	private void modifyFitness()
	{
		
	}
	
	private void deleteFitness()
	{
		
	}
	
	private void seeGoals()
	{
		
	}
	
	private void searchTrainers()
	{
		
	}
	
	private void scheduleAppointment()
	{
		ArrayList<Trainer> trainersList = controller.searchDB("trainers");
		String formatString = "";
		for (int i = 0; i < trainersList.size(); i++)
		{
			formatString += i + " " + trainersList.get(i).getName();
		}
		String trainerID = JOptionPane.showInputDialog(null, "Please enter the number of the trainer you wish to view the schedule of.\n" + formatString);
		int tID = Integer.parseInt(trainerID);
		String[] schedule = trainersList.get(tID).getSchedule();
		
		for (int i = 0; i < schedule.length; i++)
		{
			formatString += (i+1) + ". " + schedule[i] + "\n";
		}
		String scheduleID = JOptionPane.showInputDialog(null, "Please enter the number of the slot you would like to book:\n" + formatString);
		int sID = Integer.parseInt(scheduleID);
		trainersList.get(tID).clientSchedule(sID, super.getUser().getName());
		JOptionPane.showMessageDialog(null, "Appointment successfully added!");
	}
	
	private void reviewTrainer()
	{
		
	}
}
