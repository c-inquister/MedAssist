package com.deloitte.google.medassist.data;

public class User {

	public String username;
	public String password;
	public String type;

	public User(String username, String password, String type) {
		super();
		this.username = username;
		this.password = password;
		this.type = type;
	};
	
	public User(String data){
		setDataFromSharedPref(data);
	}
	
	public String getUserInfoToSaveToSharedPref(){
		return this.username + "|" + this.password + "|" + this.type; 
	} 
	
	public void setDataFromSharedPref(String encString){
		String[] data = encString.split("|");
		this.username = data[0];
		this.password = data[1];
		this.type = data[2];
	}
	
}
