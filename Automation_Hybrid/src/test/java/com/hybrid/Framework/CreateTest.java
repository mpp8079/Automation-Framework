package com.hybrid.Framework;

import java.util.ArrayList;
import java.util.HashMap;

import org.testng.TestNG;
import org.testng.xml.XmlClass;
import org.testng.xml.XmlSuite;
import org.testng.xml.XmlTest;

import com.hybrid.Helpers.SetupHelper;

public class CreateTest {	
	
	private int threadCount;
	private TestNG allTest;
	private XmlSuite testSuite;
	private ArrayList<XmlSuite> suites;
	private String currTest;
	private String prevTest;
	private int count;
	private String envr;

	public String getEnvr() {
		return envr;
	}

	public void setEnvr(String envr) {
		this.envr = envr;
	}

	public int getThreadCount() {
		return threadCount;
	}

	public void setThreadCount(int threadCount) {
		this.threadCount = threadCount;
	}

	public TestNG getAllTest() {
		return allTest;
	}

	public void setAllTest(TestNG allTest) {
		this.allTest = allTest;
	}

	public XmlSuite getTestSuite() {
		return testSuite;
	}

	public void setTestSuite(XmlSuite testSuite) {
		this.testSuite = testSuite;
	}

	public ArrayList<XmlSuite> getSuites() {
		return suites;
	}

	public void setSuites(ArrayList<XmlSuite> suites) {
		this.suites = suites;
	}

	public String getCurrTest() {
		return currTest;
	}

	public void setCurrTest(String currTest) {
		this.currTest = currTest;
	}

	public String getPrevTest() {
		return prevTest;
	}

	public void setPrevTest(String prevTest) {
		this.prevTest = prevTest;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public void StartSuite() {		
		
		setAllTest(new TestNG());
		setTestSuite(new XmlSuite());
		setPrevTest("");
		setCurrTest("");
		setThreadCount(0);
		setCount(1);
		try{
		setEnvr(SetupHelper.getRunEnvironemnt());
		}catch(Exception e){
			e.printStackTrace();
		}
	
	}

	public void runtTest(String tcName, String uniqueTestName,String env ,String className,HashMap<String,String> testParameters) {
		ArrayList<XmlClass> classes = new ArrayList<XmlClass>();
		XmlTest test = new XmlTest(getTestSuite());
		setCurrTest(tcName);
		if (!getPrevTest().equals(getCurrTest()) || getPrevTest().equals(""))
			setCount(1);
		else
			setCount(getCount() + 1);
		test.setName(uniqueTestName);
		test.setParameters(testParameters);
		classes.add(new XmlClass(className));
		test.setXmlClasses(classes);
		setThreadCount(getThreadCount() + 1);
		setEnvr(env);
		setPrevTest(getCurrTest());
		
		
		//FrameworkHelper.runTests(tcName,env);
		// FrameworkHelper.runTestCase(tcName,pro.getProperty("RunningEnviroment"))
		//execute.runTestCase(tcName,driver.pro.getProperty("RunningEnviroment"));
		
		
	}

	public void EndSuite() {
		setSuites(new ArrayList<XmlSuite>());
		getSuites().add(getTestSuite());
		getAllTest().setXmlSuites(getSuites());
		//GlobalVar.scriptExecutionStartTime = System.currentTimeMillis();
		getAllTest().run();
	}

}
