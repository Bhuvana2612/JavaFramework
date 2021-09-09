package com.inetbaking.utilities;

import java.io.*;
import java.util.Properties;

public class ReadConfig {
	
	static Properties prop;
	
	public ReadConfig(){
		File src= new File("./configuration//config.properties");
		
		try {
			FileInputStream fis=new FileInputStream(src);
			prop=new Properties();
			prop.load(fis);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
	}
	
	public static String getApplicationurl() {
		String url=prop.getProperty("baseURL");
		return url;
	}
	
	public static String getusername() {
		String UserName=prop.getProperty("username");
		return UserName;
	}
	
	public static String getpassword() {
		String UserPassword=prop.getProperty("password");
		return UserPassword;
	}
	
	public static String getChromedriver() {
		String userDriver=prop.getProperty("chromepath");
		return userDriver;
	}
	public static String getFirefoxdriver() {
		String userDriver=prop.getProperty("firefoxpath");
		return userDriver;
	}
}
