package com.builder;


import java.io.File;
import java.io.FileOutputStream;
import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class ConfigFileHandler {
	private String fileName;
	private String[] array;

	public ConfigFileHandler(String fileName){
		this.fileName = fileName;
	}
	public void setConfigToFile(String[] array){
		this.array = array;
		try{
		    var os = new FileOutputStream(new File(fileName));
			var oos = new ObjectOutputStream(os);
			oos.writeObject(array);
		}catch(Exception e){
		    e.printStackTrace();
		}
	}
	public String[] getConfigFromFile(){
		try{
		    var is = new FileInputStream(new File(fileName));
			var iis = new ObjectInputStream(is);
			array = (String[]) iis.readObject();
		}catch(Exception e){
		    e.printStackTrace();
		}
		return array;
	}
}
