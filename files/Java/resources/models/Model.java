
package com.model;

import javax.swing.table.AbstractTableModel;
import java.util.ArrayList;

public class Model extends AbstractTableModel{
	//get numbers of rows
	public int getRowCount(){	return 0; }
    //get number of columns
    public int getColumnCount() { return 0;}
	//get name of column by index
	public String getColumnName(int index) {     return null; }
    
	//get a value form the table
    public Object getValueAt(int rowIndex, int columnIndex) {    return null;}
}

/* 
Example:

import javax.swing.table.AbstractTableModel;
import java.util.ArrayList;


public class Model extends AbstractTableModel{
	private String[] col={"Id","Name","Gender","Address"};
	private ArrayList<Person> data;
	
	//add data to the Data Array
	public void addData(ArrayList<Person> person){ 
	
	this.data = data;
	}
	//get numbers of rows
	public int getRowCount(){
		return data.size();
	}
    //get number of columns
    public int getColumnCount() {
		return col.length;
	}
	//get name of column by index
	public String getColumnName(int index) { 
	    return col[index]; 
	}
    
	//get a value form the table
    public Object getValueAt(int rowIndex, int columnIndex) {
		Person person = data.get(rowIndex);
		if (columnIndex == 0) return person.getId();
        if (columnIndex == 1) return person.getName();
		if (columnIndex == 2) return person.getGender();
		if (columnIndex == 3) return person.getAddress();
        return null;
    }
    
	//set value at a particular cell 
    public void setValueAt(Person person, int row, int column) {
       
	    When setting a Value in the table
		Example:
		data.add(row, person);
        fireTableCellUpdated(row, column);
    }
} */