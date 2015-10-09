package com.recommender.data;

import java.util.Date;

public class Record {

	private String itemName;
	private String itemLink;
	private String itemCategory;
	private Date clickedDate;
	private String user;
	
	public String getItemName() {
		return itemName;
	}
	public void setItemName(String itemName) {
		this.itemName = itemName;
	}
	public String getItemLink() {
		return itemLink;
	}
	public void setItemLink(String itemLink) {
		this.itemLink = itemLink;
	}
	public String getItemCategory() {
		return itemCategory;
	}
	public void setItemCategory(String itemCategory) {
		this.itemCategory = itemCategory;
	}
	public Date getClickedDate() {
		return clickedDate;
	}
	public void setClickedDate(Date clickedDate) {
		this.clickedDate = clickedDate;
	}
	public String getUser() {
		return user;
	}
	public void setUser(String user) {
		this.user = user;
	}
}