package controllers;

import javax.print.DocFlavor.STRING;

public class systemFactory {

	public FSystem getSystem(String type)
	{
		FSystem fsystem = null;
		
		if(type.equals("trainer"))
		{
			fsystem  = new TrainerSystem();
			System.out.println("trainer system");
		}
		System.out.println("null system");
		return fsystem;
	}
}
