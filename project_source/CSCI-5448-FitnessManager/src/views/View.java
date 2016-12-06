package views;

import controllers.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class View {
	protected Controller controller;
	
	public View (Controller control)
	{
		this.controller = control;
	}
	public Controller getController() {
		return controller;
	}
	
	public void setController(Controller controller) {
		this.controller = controller;
	}
	
	public void setVisible(Boolean visiblity)
	{
		;
	}
}

