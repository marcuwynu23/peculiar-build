package com.view;

import java.awt.Color;
import java.awt.Font; 
import java.awt.BorderLayout;
import javax.swing.border.Border;
import java.awt.Component;
import javax.swing.UIManager;
import javax.swing.BorderFactory;


public class Constants{
	protected static final String 		APP_TITLE					= "Student Project Management System";
	protected static final String 		APP_LOGO_URL 				= "assets/logos/peculiar.png"; 
	protected static final String 		APP_LOOKS					= UIManager.getSystemLookAndFeelClassName();
	// protected static final String 		APP_LOOKS			= "javax.swing.plaf.nimbus.NimbusLookAndFeel";
	protected static final int 		APP_WIDTH 			    		= 1300;
	protected static final int 		APP_HEIGHT 						= 700;
	protected static final int 		APP_CLOSE_OPERATION 			= 3;
	protected static final Component 	APP_LOCATION 				= null;
	protected static final BorderLayout APP_LAYOUT					= new BorderLayout();
	protected static final int 		FIELD_SIZE 						= 15;
}