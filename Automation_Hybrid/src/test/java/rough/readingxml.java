package rough;

import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.hybrid.Framework.ExecuteTests;

public class readingxml {
	
	WebDriver driver;
	Properties pro;
	public String name;
	@BeforeTest
	public void openBrowser() {
		String browser = "Chrome";
		if (browser.equals("Firefox")) {
			driver = new FirefoxDriver();
		} else if (browser.equals("Chrome")) {			
			System.setProperty("webdriver.chrome.driver","C:\\local\\MarshWorkplace\\Automation_Hybrid\\chromedriver.exe");
			driver= new ChromeDriver();
		} else if (browser.equals("IE")) {
			System.getProperty("webdriver.IE.driver", "‪C:\\local\\IEDriverServer.exe");
			driver = new InternetExplorerDriver();
		}else{
			Assert.fail("Invalid Browser");
		}
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
	}
	
	@Test
	public static void rr() {
		ExecuteTests ee = new ExecuteTests();
		ee.runTestCase("L1_Login_Logout","Chrome");
	}
	
	
	//Properties prop;
	//SetupHelper ed = new SetupHelper();
	//public static void main(String[]args) {
	
		//FrameworkHelper.runTests("L1_Login_Logout","Chrome");
	//NodeList ndd =Utilities.readTestCase("L1_Login_Logout_StandarUser.xml");
	//System.out.println(ndd);
	//}
	
	

}
