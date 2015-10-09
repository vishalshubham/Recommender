package com.recommender.data;

import java.util.ArrayList;

public class RecordBulk implements Cloneable{

	private ArrayList<Record> recordsList;
	
	public RecordBulk(ArrayList<Record> recordsList){
		this.recordsList = recordsList;
	}
	
	public ArrayList<Record> getRecordsList() {
		return recordsList;
	}

	public void setRecordsList(ArrayList<Record> recordsList) {
		this.recordsList = recordsList;
	}

	@Override
	public Object clone(){
		Object clone = null;
		
		try{
			clone = super.clone();
		}
		catch(CloneNotSupportedException e){
			e.printStackTrace();
		}
		return clone;
	}

	
}
