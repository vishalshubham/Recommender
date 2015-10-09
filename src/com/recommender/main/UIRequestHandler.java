package com.recommender.main;

import java.util.ArrayList;

import com.recommender.data.Record;
import com.recommender.recommender.Recommender;
import com.recommender.user.User;

public class UIRequestHandler {

	private String userId = null;
	private Recommender recommender;
	private User user;
	
	public UIRequestHandler(String userId){
		this.userId = userId;
		user = new User(userId);
		recommender = new Recommender();
	}
	
	public ArrayList<Record> getGeneralRec(){
		return recommender.getGeneralRec(getUserData());
	}
	
	public ArrayList<Record> getCategoryRec(){
		return recommender.getCategoryRec(getUserData());
	}
	
	public ArrayList<Record> getUserData(){
		return user.getUserData();
	}
	
	public boolean isLoggedIn(){
		return (userId!=null);
	}
}
