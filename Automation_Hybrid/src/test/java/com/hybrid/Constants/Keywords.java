package com.hybrid.Constants;

import com.hybrid.Automation.Login;
import com.hybrid.Automation.PortfolioAction;

public enum Keywords {
		
	//Login on Money Page
	Empty(),
	LOGIN(Login.class, "Description"),
	VERIFYLOGIN(Login.class, "Description"),
	LOGOUT(Login.class, "Description"),
	VERIFYLOGOUT(Login.class, "Description"),
	NEWPORTFOLIO(PortfolioAction.class, "Description"),
	SELECTPORTFOLIO(PortfolioAction.class, "Description"),
	DELETEPORTFOLIO(PortfolioAction.class, "Description");

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
