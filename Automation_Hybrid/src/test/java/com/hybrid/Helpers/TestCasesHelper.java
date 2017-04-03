package com.hybrid.Helpers;

import java.util.ArrayList;
import java.util.List;

import com.hybrid.Actions.GetExcelData;
import com.hybrid.Automation.Utilities;

public class TestCasesHelper{
	private static GetExcelData driverData = new GetExcelData(Utilities.getWorkSpace() + SetupHelper.getDriverData());
	
	
	public List<String> retrieveTestCasesToExecute(){		
		List<String> listOfTests = new ArrayList<>();
		if(!SetupHelper.getTestCases().isEmpty()){
			String testCases = SetupHelper.getTestCases();
			if(testCases.contains(",")){
				String[] tCases = testCases.split(",");
				for(String tCase:tCases){					
					listOfTests.add(tCase.trim());
				}
			}else{
				listOfTests.add(testCases);
			}
			
		}
			
		
		
		
		return listOfTests;
		
	}

}
