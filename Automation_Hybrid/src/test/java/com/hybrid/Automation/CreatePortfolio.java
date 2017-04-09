package com.hybrid.Automation;

import org.openqa.selenium.By;

import com.hybrid.Constants.ObjectRepostiory;
import com.hybrid.Framework.Driver;

public class CreatePortfolio {

	
	public boolean newPortfolio(String name){
		Driver.Instance.findElement(By.id(ObjectRepostiory.Create_Frotfolio_ID)).click();
		Driver.Instance.findElement(By.name(ObjectRepostiory.Clean_Frotfolio_NAME)).clear();
		Driver.Instance.findElement(By.name(ObjectRepostiory.Clean_Frotfolio_NAME)).sendKeys(name);
		Driver.Instance.findElement(By.id(ObjectRepostiory.Create_Frotfolio_Submit_Button_ID)).click();
		return false;
		
	}
	
}
