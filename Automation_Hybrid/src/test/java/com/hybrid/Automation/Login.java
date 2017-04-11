package com.hybrid.Automation;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.hybrid.Constants.ObjectRepostiory;
import com.hybrid.Framework.Driver;
import com.hybrid.Framework.ExtentManager;

public class Login {
	
	private ExtentManager myAssert;
	//WebDriver driver = Driver.getInstance().getWebDriver();	
	
	

	
	public  boolean login(String username,String password ,String confirmpassword){
	//WebDriver driver = Driver.getInstance().getWebDriver();	
	Driver.Instance.findElement(By.xpath(ObjectRepostiory.Money_Page_Link_XPATH)).click();
	Driver.Instance.findElement(By.xpath(".//*[@id='signin_info']/a[1]")).click();
	Driver.Instance.findElement(By.xpath(".//*[@id='useremail']")).sendKeys(username);		
	Driver.Instance.findElement(By.xpath(".//*[@id='emailsubmit']")).click();
	Driver.Instance.findElement(By.xpath(".//*[@id='userpass']")).sendKeys(password);		
	Driver.Instance.findElement(By.xpath(".//*[@id='loginsubmit']")).click();
		
		return false;
	}
	

	public boolean verifyLogin(){	
		System.out.println("Jay Swaminarayan Tame Mahan chho");
		return false;
		
	}
	
	public boolean logout(){
		System.out.println("Jay Laxmi Mata Tame Mahan chho");
		return false;
		
	}
	
	public boolean verifyLogout(){
		System.out.println("Jay Ganesh Mata Tame Mahan chho");
		return false;
		
	}
	
	
		
	
}
