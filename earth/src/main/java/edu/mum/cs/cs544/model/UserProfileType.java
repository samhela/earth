package edu.mum.cs.cs544.model;

import java.io.Serializable;

public enum UserProfileType implements Serializable{
	USER("USER"),
	PROFESSOR("PROFESSOR"),
	STUDENT("STUDENT"),
	FACULITY("FACULITY"),
	ADMIN("ADMIN");
	
	String userProfileType;
	
	private UserProfileType(String userProfileType){
		this.userProfileType = userProfileType;
	}
	
	public String getUserProfileType(){
		return userProfileType;
	}
	
}
