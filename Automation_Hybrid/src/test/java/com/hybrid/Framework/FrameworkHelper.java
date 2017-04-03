package com.hybrid.Framework;

import org.w3c.dom.NodeList;

import com.hybrid.Automation.Utilities;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class FrameworkHelper {
	static ExtentReports rep = ExtentManager.getInstance();

	
	public static boolean runTests(String tcName, String browser) {
		ExtentTest test  = rep.startTest(tcName);
		String testCaseName = tcName;
		test.log(LogStatus.INFO, testCaseName);
		new Utilities();
		com.hybrid.Automation.AllActions allactions = new com.hybrid.Automation.AllActions();
		NodeList keywords;
		
		keywords = Utilities.readTestCase(testCaseName.trim() + ".xml");
		allactions.executeKeywords(keywords);
		rep.flush();
		return false;
	}

	

}
