package com.controller;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import com.view.*;
import com.model.Model;
import com.peculiar.app.*;
import com.peculiar.app.auth.*;


public class Controller implements ActionListener{
	
	private AppAuthForm authView;
	private View view;
	private Model model;
	public Controller(View view,Model model){
		this.view = view;
		this.authView = authView;
		this.model = model;
		setComponents();
		setActionListener();
	}
	private void setComponents(){
		authView = new AppAuthForm();
	
	}
	private void setActionListener(){
		
	}
	public void actionPerformed(ActionEvent ev){
		
		
	}
	public void start(){
		authView.setAuthenticate(view, new ArrayList<UserModel>());
		authView.showApp();
	}
}