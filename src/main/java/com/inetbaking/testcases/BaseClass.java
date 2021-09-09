package com.inetbaking.testcases;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.*;

import com.inetbaking.utilities.ReadConfig;

public class BaseClass {

	ReadConfig fig = new ReadConfig();

	WebDriver driver;
	public String username = ReadConfig.getusername();
	public String pwd = ReadConfig.getpassword();
	public static Logger l;
	
    @Parameters("browser")
	@BeforeClass
	public void setup(String Browser) {

		l = Logger.getLogger("EBanking");
		PropertyConfigurator.configure("log4j.properties");
		
		if (Browser.equalsIgnoreCase("Chrome"))
		{
			System.setProperty("webdriver.chrome.driver", ReadConfig.getChromedriver());
			driver = new ChromeDriver();
		} else
		{
			System.setProperty("webdriver.chrome.driver", ReadConfig.getFirefoxdriver());
			driver = new FirefoxDriver();
		}
         driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		 driver.get(ReadConfig.getApplicationurl());
	}
    
    public void capturescreenshot(WebDriver driver, String tname) throws IOException {
    	
    	TakesScreenshot screen=(TakesScreenshot) driver;
    	File src=screen.getScreenshotAs(OutputType.FILE);
    	File desc=new File(System.getProperty("user.dir")+"/screenshot/"+tname+".png");
    	
			FileUtils.copyFile(src, desc);
			System.out.println("Screen Shot is taken");
		
    	
    }
    
    public boolean isAlertPresent() {
    	try {
    	driver.switchTo().alert();
    	return true;
    	}catch(NoAlertPresentException e) {
    		return false;
    }
    	
    }

	public void teardown() {
		driver.quit();
	}
}
