package com.example.transition;

import android.app.Application;

public class RollingStone extends Application{
	private static RollingStone instance;
	private String testString;
	
	public static RollingStone getInstance(){
		if(instance==null)
			instance = new RollingStone();
		
		return instance;
	}
	
	private RollingStone(){
		testString = "empty string bro, sorry...";
	}
	
	
	
	public void setString(String s){
		testString = s;
	}
	
	public String getString(){
		return testString;
	}
}