package com.inetbaking.testcases;



import org.testng.Assert;
import org.testng.annotations.*;

import com.inetbaking.pageobjects.LoginPage;

public class TC_logintest extends BaseClass{
	
	@Test
	public void login() throws Exception {
		LoginPage lp=new LoginPage(driver);
		l.info("Enter Name");
		lp.user(username);
		l.info("Password Entered");
		lp.pwd(pwd);
		lp.login_click();
		
		if(driver.getTitle().equalsIgnoreCase("http://demo.guru99.com/V1/html/Managerhome.php"))
			Assert.assertTrue(true);
		else
			capturescreenshot(driver, "TC_logintest");
			Assert.assertTrue(false);
	
		teardown();
		
	}

	
}
