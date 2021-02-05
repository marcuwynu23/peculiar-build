package com.database;

import java.sql.*;

public class DatabaseManager{
	
	Connection conn = null;
	Statement stmt = null;
	ResultSet result=null;
	String databasename;
	
	public DatabaseManager(String databasename){
		this.databasename = databasename;
		try{
			Class.forName("org.sqlite.JDBC");
		    conn = DriverManager.getConnection("jdbc:sqlite:"+this.databasename+".sqlite");
			stmt = conn.createStatement();
			System.out.println("Database Connected Sucessfully!");
		}
		catch(Exception e){
		    e.printStackTrace();
		}
		
	}
	public DatabaseManager(){
		try{
			Class.forName("org.sqlite.JDBC");
		    conn = DriverManager.getConnection("jdbc:sqlite:test.sqlite");
			stmt = conn.createStatement();
			stmt.close();
			System.out.println("Database Connected Sucessfully!");
		}
		catch(Exception e){
		    e.printStackTrace();
		}
	}
}