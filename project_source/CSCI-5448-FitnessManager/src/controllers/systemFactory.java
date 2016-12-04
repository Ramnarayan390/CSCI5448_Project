package controllers;

import javax.print.DocFlavor.STRING;

public class systemFactory {

	public FSystem getSystem(String type)
	{
		FSystem fsystem = null;
		
		if(type.equals("Trainer"))
		{
			fsystem  = new TrainerSystem();
			System.out.println("trainer system");
		}
		else
		{
			System.out.println("null system");
		}
		return fsystem;
	}
}
