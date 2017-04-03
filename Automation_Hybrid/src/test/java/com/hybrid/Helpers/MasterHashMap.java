package com.hybrid.Helpers;

import java.util.HashMap;

import com.hybrid.Constants.GlobalVar;



public class MasterHashMap {
	public static void initialize(){
		long threadIdentifier = Thread.currentThread().getId();
		if(!GlobalVar.masterHashMap.containsKey((Long.toString(threadIdentifier)))){
	       	GlobalVar.masterHashMap.put(Long.toString(threadIdentifier), new HashMap<String, String>());
	   
		}
	}
	
	public static String getValue(String key){
		long threadIdentifier = Thread.currentThread().getId();
		return containsKey(key) ? GlobalVar.masterHashMap.get(Long.toString(threadIdentifier)).get(key) : "";
	}
	
	public static void setValue(String key, String val){
		long threadIdentifier = Thread.currentThread().getId();
		GlobalVar.masterHashMap.get(Long.toString(threadIdentifier)).put(key, val);
	}
	
	public static boolean containsKey(String key){
		long threadIdentifier = Thread.currentThread().getId();
		if(GlobalVar.masterHashMap.get(Long.toString(threadIdentifier)).containsKey(key))
			return true;
		else
			return false;
	}
	
	public static String printMasterMap() {
		StringBuffer sb = new StringBuffer();
		for(String thread: GlobalVar.masterHashMap.keySet()){
			for(String key: GlobalVar.masterHashMap.get(thread).keySet()){
				sb.append("Thread: " + thread + " Key: " + key + " Value: " + GlobalVar.masterHashMap.get(thread).get(key));
				sb.append(System.lineSeparator());
			}
		}
		return sb.toString();
	}

}
