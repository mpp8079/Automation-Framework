package com.hybrid.Constants;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class GlobalVar {
	
	public static int totalSuiteScripts;
	public static Map<String, HashMap<String, HashMap<String, String>>> assertionAndTestStep = new ConcurrentHashMap<String, HashMap<String, HashMap<String, String>>>(totalSuiteScripts);
	public static Map<String, HashMap<String, String>> masterHashMap = new ConcurrentHashMap<String, HashMap<String, String>>(totalSuiteScripts);
	public static Map<String, HashMap<String, ArrayList<String>>> cookieInformation = new ConcurrentHashMap<String, HashMap<String, ArrayList<String>>>(totalSuiteScripts);
	public static Map<String, HashMap<String, HashMap<String, String>>> finalOutput = new ConcurrentHashMap<String, HashMap<String, HashMap<String, String>>>(totalSuiteScripts);
	public static Map<String, HashMap<String, HashMap<String, String>>> searchPhraseInformation = new ConcurrentHashMap<String, HashMap<String, HashMap<String, String>>>(totalSuiteScripts);
	public static Map<String, Integer> browserPerm = new ConcurrentHashMap<String, Integer>();
	public static Map<String, HashMap<String, String>> gblMasterUserInfo = new ConcurrentHashMap<String, HashMap<String, String>>();
	public static Map<String, String> runEnvironment = new HashMap<String, String>();
}
