package controllers;

import javax.print.DocFlavor.STRING;

public class SystemFactory {

	public FSystem getSystem(String type)
	{
		FSystem fsystem = null;
		
		if(type.equals("Trainer"))
		{
			fsystem  = new TrainerSystem();
			System.out.println("trainer system");
		}
		else if(type.equals("Admin"))
		{
			fsystem  = new AdminSystem();
			System.out.println("admin system");
		}
		else if(type.equals("Client"))
		{
			fsystem  = new ClientSystem();
			System.out.println("Client system");
		}
		else
		{
			System.out.println("null system");
		}
		return fsystem;
	}
}
