package com.hybrid.Framework;

import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.logging.LogType;
import org.openqa.selenium.logging.LoggingPreferences;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.ui.FluentWait;

import com.google.common.base.Function;
import com.hybrid.Constants.HashMapConstants;
import com.hybrid.Helpers.AssertionAndTestStep;
import com.hybrid.Helpers.MasterHashMap;

import io.appium.java_client.AppiumDriver;

public class SeleniumDrivers {

	
	    private ThreadLocal<WebDriver> webDriver = new ThreadLocal<WebDriver>();
	    private ThreadLocal<AppiumDriver<WebElement>> appiumDriver = new ThreadLocal<AppiumDriver<WebElement>>();	    
	    private static SeleniumDrivers instance = new SeleniumDrivers();
	    
	    
	    public static SeleniumDrivers getInstance(){
	    	return instance;
	    } 	
	
		private String getTestInformation(){
			return MasterHashMap.getValue(HashMapConstants.MasterConstant.TESTNAME) + " " + MasterHashMap.getValue(HashMapConstants.MasterConstant.BROWSER)
			+ " " + MasterHashMap.getValue(HashMapConstants.MasterConstant.BROWSER_VERSION) + " " + MasterHashMap.getValue(HashMapConstants.MasterConstant.OPERATING_SYSTEM);
		}
		
	/****************************************************************************************************
	 * Method: createDriver
	 * Description: 
	 * @author 
	 * @return boolean
	 ***************************************************************************************************/
		public WebDriver getDriver(String tcName, String browser, String browserVersion, String osVersion, String executionEnv) {
			Platform curr = Platform.getCurrent();
			executionEnv = executionEnv.toLowerCase().trim();
			try {
				if (executionEnv.equalsIgnoreCase("remote") || 
						executionEnv.equalsIgnoreCase("remote parallel") 
						|| executionEnv.equalsIgnoreCase("remote gra1nger")
						|| executionEnv.equalsIgnoreCase("remote sequential")) {
					if(browser.equalsIgnoreCase("ios") || browser.equalsIgnoreCase("android")){
						//appiumDriver.set(createAppiumDriver(tcName, browser, browserVersion, osVersion));
					}else{
						//webDriver.set(createRemoteDriver(browser, browserVersion, osVersion, tcName));
					}
				} else if (executionEnv.equalsIgnoreCase("Internet Explorer")
						|| executionEnv.equalsIgnoreCase("Internet Explorer Parallel")) {
					System.setProperty("webdriver.ie.driver",ProjectProperties.getFilePath(ProjectProperties.INTERNET_EXPLORER_DRIVER));
					DesiredCapabilities capabilities = DesiredCapabilities.internetExplorer();
					capabilities.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS,true);
					webDriver.set(new InternetExplorerDriver(capabilities));
					//webDriver.set(new InternetExplorerDriver());

				
				} else if (executionEnv.equalsIgnoreCase("Chrome")
						|| executionEnv.equalsIgnoreCase("Chrome Parallel")){
					if (curr.equals(Platform.MAC)){
						//System.setProperty("webdriver.chrome.driver",ProjectProperties.getFilePath(ProjectProperties.CHROME_DRIVER_MAC));
					}else{
						System.setProperty("webdriver.chrome.driver",ProjectProperties.getFilePath(ProjectProperties.CHROME_DRIVER_WINDOWS));
					}
			        DesiredCapabilities capabilities = DesiredCapabilities.chrome();
			        LoggingPreferences loggingprefs = new LoggingPreferences();
			        loggingprefs.enable(LogType.BROWSER, Level.SEVERE);
			        capabilities.setCapability(CapabilityType.LOGGING_PREFS, loggingprefs);
					webDriver.set(new ChromeDriver(capabilities));
				} else if(executionEnv.equalsIgnoreCase("Safari")
						|| executionEnv.equalsIgnoreCase("Safari Parallel")){
						webDriver.set(new SafariDriver());
				}
				if(webDriver.get() != null){
					driverWait(webDriver.get());
					webDriver.get().manage().window().maximize();	
					Thread.sleep(2000);
					
					return webDriver.get();
				}else{
					driverWait(appiumDriver.get());
					appiumDriver.get().manage().window().maximize();	
					Thread.sleep(2000);					
					return appiumDriver.get();
				}
			} catch (Exception e) {
				e.printStackTrace();
				//sa.setGblPassFailMessage("fail", "Unable to create driver"
					//	+ e.getMessage());
				return null;
			}
		}
		
	/****************************************************************************************************
	 * Method: waitAndMaximizeWindow
	 * Description: 
	 * @author 
	 * @return 
	 ***************************************************************************************************/  	
		private void driverWait(WebDriver driver){
			try{
				driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
			}catch(WebDriverException e){
				
				throw(e);
			}
		}
		
	/****************************************************************************************************
	 * Method: getWebDriver
	 * Description: 
	 * @author 
	 * @return boolean
	 ***************************************************************************************************/  	
	    public WebDriver getWebDriver() {
	    	if(webDriver.get() != null){
	    		driverWait(webDriver.get());
	    		return webDriver.get();
	    	}else{
	    		driverWait(appiumDriver.get());
	    		return appiumDriver.get();
	    	}
	    }

	
	    public void setWebDriver(WebDriver driver) {
	    	webDriver.set(driver);
	    }
	    
	/****************************************************************************************************
	 * Method: removeDriver
	 * Description: 
	 * @author 
	 * @return boolean
	 ***************************************************************************************************/    
	    public void removeDriver(WebDriver dr, String tcName, Logger log){
	    	StringBuilder output = new StringBuilder();
	    	if(dr != null){
	    		output.append(System.getProperty("line.separator"));
	    		output.append("--------------------------------------Test-----------------------------------");
	    		output.append(System.getProperty("line.separator"));
	    		output.append("Ending Test: " + tcName);
	    		output.append(System.getProperty("line.separator"));
	    		output.append(Boolean.parseBoolean(AssertionAndTestStep.getValue(HashMapConstants.AssertionAndTestStepConstant.GBL_TEST_RESULT)) ? 
							tcName + " Result: Passed" : tcName + " Result: Failed");
				
	    		output.append(System.getProperty("line.separator"));
	    		output.append("Driver: "+ dr.toString());
	    		output.append(System.getProperty("line.separator"));
	    		output.append("Hash code: " + dr.hashCode());
	    		output.append(System.getProperty("line.separator"));
	    		output.append("Thread: " + Thread.currentThread().getId());
	    		output.append(System.getProperty("line.separator"));
	    		if(MasterHashMap.getValue(HashMapConstants.MasterConstant.DRIVER_CODE).equals(getTestInformation() + " " + dr.toString())){
	    			output.append("Test Ended with driver: " + MasterHashMap.getValue(HashMapConstants.MasterConstant.DRIVER_CODE));
	    		}else{
	    			output.append("Test started with driver: " + MasterHashMap.getValue(HashMapConstants.MasterConstant.DRIVER_CODE));
	    			output.append(System.getProperty("line.separator"));
	    			output.append("Test Ended with driver: " + getTestInformation() + " " + dr.toString());
	    		}
	    		output.append(System.getProperty("line.separator"));
	    		//SeleniumDrivers.getInstance().markJobAsFailedOrPassed(tcName, output);
	    		output.append("-----------------------------------------------------------------------------");
	    		output.append(System.getProperty("line.separator"));
	    		log.info(output.toString());
	    		dr.quit();
	    	}
	    } 

	/****************************************************************************************************
	 * Method: removeDriver
	 * Description: 
	 * @author 
	 * @return boolean
	 ***************************************************************************************************/    
	    public void removeDriver(String tcName){
	    	if(webDriver.get() != null){
	        	webDriver.get().quit();
	    	}else if(appiumDriver.get() != null){
	    		appiumDriver.get().quit();
	    	}
	    } 	    
	   
		public static WebElement fluentWaitFindElement(final WebDriver driver, final By locator, final int timeoutSeconds) {
		    FluentWait<WebDriver> wait = new FluentWait<WebDriver>(driver)
		            .withTimeout(timeoutSeconds, TimeUnit.SECONDS)
		            .pollingEvery(2, TimeUnit.SECONDS)
		            .ignoring(NoSuchElementException.class);
		    
		    return wait.until(new Function<WebDriver, WebElement>(){
		    	public WebElement apply(WebDriver wbDriver){
		    		return driver.findElement(locator);
		    	}
		    });
		}
	    
	    public static List<WebElement> fluentWaitFindElements(final WebDriver driver, final By locator, final int timeoutSeconds) {
	        FluentWait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(timeoutSeconds, TimeUnit.SECONDS)
	                .pollingEvery(2, TimeUnit.SECONDS).ignoring(NoSuchElementException.class);

	        return wait.until(new Function<WebDriver, List<WebElement>>() {
	            public List<WebElement> apply(WebDriver wbDriver) {
	                return driver.findElements(locator);
	            }
	        });
	    }
	    
		
	/****************************************************************************************************
	 * Method: fluentWaitFindElement
	 * Description: 
	 * @author 
	 * @return boolean
	 ****************************************************************************************************/	
		public static WebElement fluentWaitFindElement(final WebElement element, final By locator, final int timeoutSeconds) {
			WebDriver driver = SeleniumDrivers.getInstance().getWebDriver();
		    FluentWait<WebDriver> wait = new FluentWait<WebDriver>(driver)
		            .withTimeout(timeoutSeconds, TimeUnit.SECONDS)
		            .pollingEvery(2, TimeUnit.SECONDS)
		            .ignoring(NoSuchElementException.class);
		    
		    return wait.until(new Function<WebDriver, WebElement>(){
		    	public WebElement apply(WebDriver wbDriver){
		    		return element.findElement(locator);
		    	}
		    });
		}
		

	    /**
	     * Wrapper for WebDriver.findElements with a wait timeout
	     */
	    public static List<WebElement> fluentWaitFindElements(final WebElement element, final By locator, final int timeoutSeconds) {
	    	WebDriver driver = SeleniumDrivers.getInstance().getWebDriver();
	        FluentWait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(timeoutSeconds, TimeUnit.SECONDS)
	                .pollingEvery(2, TimeUnit.SECONDS).ignoring(NoSuchElementException.class);

	        return wait.until(new Function<WebDriver, List<WebElement>>() {
	            public List<WebElement> apply(WebDriver wbDriver) {
	                return element.findElements(locator);
	            }
	        });
	    }
	   
		
		
	
}
