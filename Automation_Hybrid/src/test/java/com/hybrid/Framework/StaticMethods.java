package com.hybrid.Framework;

import java.util.Iterator;
import java.util.List;

import org.apache.xml.utils.StylesheetPIHandler;
import org.testng.annotations.DataProvider;

import com.hybrid.Helpers.SetupHelper;
import com.hybrid.Helpers.TestCasesHelper;

public class StaticMethods {
	
	@DataProvider()
	public static Object[][] getTestCaseNamesAndEnvOptions(){
		//new TestCasesHelper();
		return SetupHelper.getParameters(new TestCasesHelper().retrieveTestCasesToExecute(),SetupHelper.getRunEnvironemnt());
		
	}

}
