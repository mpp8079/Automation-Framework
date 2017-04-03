package com.hybrid.Helpers;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Iterator;
import java.util.List;
import java.util.Properties;

import com.hybrid.Framework.ProjectProperties;
import com.hybrid.Models.EnvironmentOptions;

import edu.emory.mathcs.backport.java.util.Arrays;

public class SetupHelper {
	public static Properties configProp = null;
	
	public SetupHelper() {
		SetupHelper.getConfigProperties();
	}
	
	public static String getDriverData(){
		return "//Data//DriverData.xlsx";
		
	}
	public static String getTestCases() {
		return getConfigProperties().getProperty("testCase");

	}

	public static String getRunEnvironemnt() {
		String[] validEnv = { "FIREFOX", "IE", "CHROME" };
		if (Arrays.asList(validEnv)
				.contains(SetupHelper.getConfigProperties().getProperty("RunningEnviroment").toUpperCase())) {
			return getConfigProperties().getProperty("RunningEnviroment");
		}
		return "notvalid";
	}

	public static String getProperty(String prop) {
		try {
			return configProp.getProperty(prop).toString();
		} catch (Exception e) {

			return "";
		}
	}

	public static Properties getConfigProperties() {
		Properties prop = new Properties();
		InputStream input = null;
		try {
			input = new FileInputStream(ProjectProperties.getFilePath(ProjectProperties.CONFIG_PROP));
			prop.load(input);
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} finally {
			if (input != null) {
				try {
					input.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}

		return prop;
	}

	public static Object[][] getParameters(List<String> tcName,String Browser) {
		String env=null;
		env=getRunEnvironemnt();
		//int noOfBrowsers = getNu
		Object[][]testParameters = new Object[tcName.size()][3];
		int count=0;
		for(int j=0;j<tcName.size();j++){
			testParameters[count][0]=tcName.get(j);	
			testParameters[count][1]=Browser;
			testParameters[count][2]=env;
			count+=1;
		}
		return  testParameters;
	}
	
	
	private static int getNumberOfBrowsers(List<EnvironmentOptions> EOValues, String env){
	int noOfBrowser=1;
	env = env.trim();
	if(env.equals("Remote")){
		noOfBrowser = EOValues.size();
	}
	return noOfBrowser;
	
	}
}
