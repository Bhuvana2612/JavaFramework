package com.inetbaking.testcases;


import org.testng.annotations.Test;

import com.inetbaking.pageobjects.AddNewCustomer;
import com.inetbaking.pageobjects.LoginPage;


public class TC_addCustomer_002 extends BaseClass {
	
	@Test
	public void login() throws InterruptedException {
		LoginPage lp=new LoginPage(driver);
		l.info("UserName Provided");
		lp.user(username);
		l.info("Password is Provided");
		lp.pwd(pwd);
		lp.login_click();
		Thread.sleep(1000);
		
		AddNewCustomer add=new AddNewCustomer(driver);
		add.new_link();
		add.Cust_name("sample");
		add.Gender();
		add.DOB("11","11","2000");
		Thread.sleep(1000);
		add.Address("sample");
		add.City("chennai");
		add.State("TamilNadu");
		add.Pin(123123);
		add.tele(123456);
		add.Email("sample@gmail.com");
		add.submit();
		Thread.sleep(1000);
		teardown();
	} 	
	
}

