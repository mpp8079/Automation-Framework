package com.hybrid.Helpers;

import java.util.HashMap;

import com.hybrid.Constants.GlobalVar;

public class AssertionAndTestStep {
	
	
	public static void initialize(){
		long threadIdentifier = Thread.currentThread().getId();
		if(!GlobalVar.assertionAndTestStep.containsKey((Long.toString(threadIdentifier)))){
	       	GlobalVar.assertionAndTestStep.put(Long.toString(threadIdentifier), new HashMap<String, HashMap<String, String>>());
	    }
		GlobalVar.assertionAndTestStep.get(Long.toString(threadIdentifier)).put(getName(), new HashMap<String, String>());
	}
	
	public static String getValue(String key){
		long threadIdentifier = Thread.currentThread().getId();
		return GlobalVar.assertionAndTestStep.get(Long.toString(threadIdentifier)).get(getName()).get(key);
	}
	
	public static void setValue(String key, String val){
		long threadIdentifier = Thread.currentThread().getId();
		GlobalVar.assertionAndTestStep.get(Long.toString(threadIdentifier)).get(getName()).put(key, val);
	}
	
	public static boolean containsKey(String key){
		long threadIdentifier = Thread.currentThread().getId();
		if(GlobalVar.assertionAndTestStep.get(Long.toString(threadIdentifier)).get(getName()).containsKey(key))
			return true;
		else
			return false;
	}
	
	private static String getName(){
		return MasterHashMap.getValue("testCaseName");
	}

}
