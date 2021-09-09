package com.inetbaking.testcases;

import java.io.IOException;


import org.testng.Assert;
import org.testng.annotations.*;


import com.inetbaking.pageobjects.LoginPage;
import com.inetbaking.utilities.XlUtils;

public class TC_loginDDT_001 extends BaseClass {

	@Test(dataProvider="loginData")
	public void login(String username,String pwd) throws InterruptedException {
		LoginPage lp=new LoginPage(driver);
		l.info("UserName Provided");
		lp.user(username);
		l.info("Password is Provided");
		lp.pwd(pwd);
		lp.login_click();
		Thread.sleep(1000);
		if(isAlertPresent()==true) {
			driver.switchTo().alert().accept();
			driver.switchTo().defaultContent();
			Assert.assertTrue(false);
			l.warn("Enter the correct username & password");
			
		}else{
			Assert.assertTrue(true);
			l.info("Login Passed");
			lp.logout();
			Thread.sleep(1000);
			driver.switchTo().alert().accept();
		    driver.switchTo().defaultContent();
			}
		teardown();
	}

	@DataProvider(name = "loginData")

	String[][] getData() throws IOException {
	
		String path = System.getProperty("user.dir") + "\\src\\main\\java\\com\\inetbaking\\testdata\\login_bank.xlsx";

		int rownum = XlUtils.getRowCount(path, "Sheet1");
		int colcount = XlUtils.getCellCount(path, "Sheet1", 1);

		String logindata[][] = new String[rownum][colcount];

		for (int i = 1; i <= rownum; i++) {
			for (int j = 0; j < colcount; j++) {
				logindata[i - 1][j] = XlUtils.getCellData(path, "Sheet1", i, j);// 1 0
			}

		}
		return logindata;
	}

}
