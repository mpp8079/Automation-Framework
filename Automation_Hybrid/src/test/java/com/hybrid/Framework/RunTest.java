package com.hybrid.Framework;

import java.util.HashMap;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class RunTest extends CreateTest {

	
	
	@BeforeSuite
	public void StartSuite() {
		super.StartSuite();
	}

	@Test(dataProvider = "getTestCaseNamesAndEnvOptions",dataProviderClass = StaticMethods.class)
	public void runTest(String tcName ,String browser,String env)
	{
		
		
		HashMap<String, String> testParameters = new HashMap<>();
		String uniqeName =tcName.trim()+"_"+browser.trim();
		testParameters.put("tcName", tcName);
		testParameters.put("browser", browser);
		//testParameters.put("browser", browser);
		super.runtTest(tcName,uniqeName,env, "com.hybrid.Framework.ExecuteTests",testParameters);
		
	}

	@AfterSuite
	public void EndSuite() {
		super.EndSuite();
	}

}
