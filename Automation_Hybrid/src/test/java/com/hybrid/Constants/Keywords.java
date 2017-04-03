package com.hybrid.Constants;

import com.hybrid.Automation.Login;

public enum Keywords {
	
	//Login on Main Page
	
	MAINPAGELOGIN(Login.class, "Description"),
	
	
	
	
	
	
	//Login on Money Page
	Empty(),
	LOGIN(Login.class, "Description"),
	VERIFYLOGIN(Login.class, "Description"),
	LOGOUT(Login.class, "Description"),
	VERIFYLOGOUT(Login.class, "Description");

	private final Class<?> className;
	private final String description;

	public static Keywords getKeyword(String kw) {
		try {

			return Keywords.valueOf(kw);
		} catch (Exception e) {
			e.getMessage();
			return null;
		}
	}
	
	
	public Class<?> getClassName(){
		return className;
		
	}
	
	
	public String getDescription(){
		return description;
		
	}
	
	private Keywords(Class<?> className, String description){
		this.className=className;
		this.description=description;
	}
	
	private Keywords(){
		this.className=null;
		this.description= "No description";
	}

}
