import models.*;
import controllers.*;
import views.*;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

import java.util.*;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;



public class driver  {
	
	
	public static void main(String[] args)
	{
		Model model = new Model();
		view view = new view();

		controller control = new controller(model,view);
		control.control();
		 
	}
	

}
