import models.*;
import controllers.*;
import views.*;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

import java.util.*;





public class driver  {
	
	
	public static void main(String[] args)
	{
		Model model = new Model();
		//view view = new loginView();
		//view view = new createTrainerProfileView();
		view view = new startupView();

		
		controller control = new controller(model,view);
		control.control();
		 
	}
	

}
