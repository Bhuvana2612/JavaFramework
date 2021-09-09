package com.inetbaking.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
//import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	
	WebDriver ldriver;
	public LoginPage(WebDriver rdriver){
		ldriver=rdriver;
		PageFactory.initElements(rdriver, this);
		
	}
	@FindBy(name="uid")
	WebElement login_username;
	
	@FindBy(xpath="//input[@type='password']")
	WebElement login_pwd;
	
	@FindBy(xpath="//input[@name='btnLogin']")
	WebElement submit;
	
	@FindBy(linkText="Log out")
	WebElement logout;
	
	
	public void user(String usrname) {
		login_username.sendKeys(usrname);
	}
	
	public void pwd(String usrpwd) {
		login_pwd.sendKeys(usrpwd);
	}
	
	public void login_click() {
		submit.click();
	}
	
	public void logout() {
		logout.click();
	}

}
