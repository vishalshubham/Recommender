package com.recommender.user;

import java.util.ArrayList;

import com.recommender.data.DBHandler;
import com.recommender.data.Record;
import com.recommender.data.RecordBulk;
import com.recommender.data.RecordCache;

public class User {

	private String userId;
	private String userName;
	private String userCountry;
	
	public User(String userId){
		this.userId = userId;
		getUserInformation();
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserCountry() {
		return userCountry;
	}

	public void setUserCountry(String userCountry) {
		this.userCountry = userCountry;
	}
	
	public void getUserInformation(){
		// use userId and populate userName and Country etc
	}
	
	public ArrayList<Record> getUserData(){
		if(RecordCache.hasKey(userId)){
			RecordBulk recordBulk = RecordCache.getRecordBulk(userId);
			System.out.println("Data fetched from Cache!!!");
			return recordBulk.getRecordsList();
		}
		else{
			DBHandler dbHandler = new DBHandler(userId);
			ArrayList<Record> records = dbHandler.getDataForUser();
			RecordCache.loadCache(userId, new RecordBulk(records));
			System.out.println("Data fetched from DB and pushed into Cache!!!");
			return records;
		}
	}
}
