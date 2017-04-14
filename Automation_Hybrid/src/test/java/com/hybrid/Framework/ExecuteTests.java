package com.hybrid.Framework;

import java.util.List;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.beust.jcommander.Parameter;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class ExecuteTests {
	//ExtentReports rep = ExtentManager.getInstance();
	
@Parameters({"tcName","browser"})
@BeforeMethod	
public static void OpenBrowser(String tcName , String browser){
	Driver.Initalize();
	Driver.Instance.get("http://www.rediff.com/");
}
	
@Parameters({"tcName","browser"})
@Test
public void runTestCase(String tcName,String browser){
//ExtentTest test  = rep.startTest(tcName);
	//test.log(LogStatus.INFO, tcName);
		//tcName = "L1_Login_Logout";
		//browser="Chrome";
		//tcName=;
		//browser=;
	tcName= tcName.trim();
	browser = browser.trim();
	
	FrameworkHelper.runTests(tcName,browser);
	//test.log(LogStatus.PASS,tcName);
	
	//	rep.endTest(test);
		//rep.flush();
	}

@AfterMethod
public static void closeBrowser(){
Driver.Instance.close();
}

}
