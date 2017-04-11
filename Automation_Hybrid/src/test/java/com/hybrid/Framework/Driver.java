package com.hybrid.Framework;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class Driver {
	
	public static WebDriver Instance=null;
	private static String browser="chrome";
	private static Driver instance = new Driver();
	  private ThreadLocal<WebDriver> webDriver = new ThreadLocal<WebDriver>();
	public static Driver getInstance(){
		return instance;
		
	}
	
	private void driverWait(WebDriver driver){
		try{
			driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
		}catch(WebDriverException e){
			e.getMessage();
			throw(e);
		}
	}
	
	 public WebDriver getWebDriver() {
	    	if(webDriver.get() != null)
	    		driverWait(webDriver.get());
	    		return webDriver.get();
	    	
	    }
	
	public static void Initalize(){
		
			if(browser.equalsIgnoreCase("FireFox"))
				Instance = new FirefoxDriver();
			
			else if(browser.equalsIgnoreCase("Chrome")){
			System.setProperty("webdriver.chrome.driver", "C:\\local\\MarshWorkplace\\Automation_Hybrid\\chromedriver.exe");
			Instance = new ChromeDriver();
			
			}else if(browser.equalsIgnoreCase("IE")){
			System.setProperty("webdriver.IE.driver", "C:\\local\\MarshWorkplace\\Automation_Hybrid\\chromedriver.exe");
			Instance = new InternetExplorerDriver();
		
			}
		
			//Instance.manage().window().maximize();
			Instance.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
		
	}
	
	public static void click(String x_path){
		WebElement ele =Instance.findElement(By.xpath(x_path));
		ele.click();
	}
	
	public static void inputt(String x_path , String data){
		WebElement ele =Instance.findElement(By.xpath(x_path));
		ele.sendKeys(data);
	}
	
	public static void close(){
		Instance.close();
	}
	
	public static void quit(){
		Instance.quit();
	}
	
	public static void Wait(){
		Instance.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		
	}
	
	
	public static void waitAndClick(String elementToClick, String elementVisable){
		for(int i=0;i<5;i++){
			Instance.findElement(By.xpath(elementToClick)).click();
			
			try {
				Thread.sleep(3000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			if(isElementPresent(elementToClick)|| Instance.findElement(By.xpath(elementVisable)).isDisplayed());
		}
	}
	
	
	
	
	public static boolean isElementPresent(String XPath){
		int getSize = Driver.Instance.findElements(By.xpath(XPath)).size();
		Driver.Instance.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		if(getSize < 0)
		return true;
		else			
		return false;
	}
	
	
	
	
	
}