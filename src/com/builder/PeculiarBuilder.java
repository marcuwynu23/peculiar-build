package com.builder; 


public class PeculiarBuilder{
	public static void main(String[] args){
		javax.swing.SwingUtilities.invokeLater(() ->{
			new com.view.View().showApp();
		});	
	}
} 