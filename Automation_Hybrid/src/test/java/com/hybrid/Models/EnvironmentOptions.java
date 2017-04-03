package com.hybrid.Models;

public class EnvironmentOptions {
	private String platform;
	private String platformVersion;
	private String osVersion;
	
	
	public EnvironmentOptions(String platform, String platformVersion, String osVersion) {
		this.platform=platform;
		this.platformVersion = platformVersion;
		this.osVersion = osVersion;
	}


	public String getPlatform() {
		return platform;
	}


	public void setPlatform(String platform) {
		this.platform = platform;
	}


	public String getPlatformVersion() {
		return platformVersion;
	}


	public void setPlatformVersion(String platformVersion) {
		this.platformVersion = platformVersion;
	}


	public String getOsVersion() {
		return osVersion;
	}


	public void setOsVersion(String osVersion) {
		this.osVersion = osVersion;
	}
	
	

}
