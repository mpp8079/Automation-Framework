package com.hybrid.Framework;

import java.util.Properties;

import com.hybrid.Automation.Utilities;

public enum ProjectProperties {
	
	RESOURCES("/src/test/resources"),
	
	XSD(RESOURCES.getPath()+"/xsd/xmlValidation.xsd"),
	CONFIG_PROP(RESOURCES.getPath()+"/properties/config.properties"),
	ENVIRONMENT_PROP(RESOURCES.getPath()+"/properties/environmentVariables.properties"),
	
	LOG4J_PROP(RESOURCES.getPath()+"/properties/log4j.properties"),	
	QA_PROP(RESOURCES.getPath()+"/properties/qa.properties"),	

	CHROME_DRIVER_WINDOWS("\\chromedriver\\chromedriver.exe"),
	INTERNET_EXPLORER_DRIVER("\\iedriver\\IEDriverServer.exe");
	
	
	private String path;
	private ProjectProperties(String path){
		this.path = path;
	}
	public String getPath(){
		return this.path;
	}
	public static String getFilePath(ProjectProperties resource){
		return Utilities.getWorkSpace()+resource.getPath();
	}

}
