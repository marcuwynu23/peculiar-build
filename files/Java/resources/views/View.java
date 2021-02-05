
package com.view;

import com.peculiar.constants.*;
import com.peculiar.components.*;
import com.peculiar.app.Application;
import com.peculiar.app.SetApp;


public class View extends Application implements SetApp{
	private final Strings strs = new Strings();
	private final Constants con = new Constants();
	

	public View(){
		setApp();
	}	
	private void setApp(){
		setAppInit();
		setAppComponents();
		setAppUI();
		setAppAction();
	}
	public void setAppInit(){
		setAppLayout(AppLayout.BORDER);
	}
	public void setAppComponents(){
	
	}
	public void setAppUI(){

	}
	public void setAppAction(){

	}
}
