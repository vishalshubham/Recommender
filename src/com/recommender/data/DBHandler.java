package com.recommender.data;

import java.io.BufferedReader;
import java.io.FileReader;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class DBHandler {
	
	private String user;
	
	public DBHandler(String user){
		this.user = user;
	}

	public ArrayList<Record> getDataForUser(){
		return getData();
	}
	
	private ArrayList<Record> getData(){
		try{
			// Use user to get only data related to user;
			BufferedReader dataBuffer = new BufferedReader(new FileReader("E:/Java/programs/Recommender/src/com/recommender/data/data.txt"));
	        ArrayList<Record> records = new ArrayList<>();
	        String nextRecord = null;

	        while(true){
	        	nextRecord = dataBuffer.readLine();
	            if(nextRecord == null){  
	            	break; 
	            }
	            else{
	            	String[] recordDataArray = nextRecord.split("\t");
	            	Record record = new Record();
	            	record.setItemName(recordDataArray[0]);
	            	record.setItemLink(recordDataArray[1]);
	            	record.setItemCategory(recordDataArray[2]);
	            	record.setUser(recordDataArray[4]);
	            	SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy"); //dd-MMM-yyyy for 7-Jun-2013-- MMM dd, yyyy for Jun 7, 2013-- E, MMM dd yyyy for Fri, June 7 2013-- EEEE, MMM dd, yyyy HH:mm:ss a for Friday, Jun 7, 2013 12:10:56 PM 
	            	Date date = formatter.parse(recordDataArray[3]);
	            	record.setClickedDate(date);
	            	records.add(record);
	            }
	        }
	        
	        dataBuffer.close();
	        return records;

	    }catch(Exception e){
	        e.printStackTrace();
	    }
	    return null;
	}
}
