package com.inetbaking.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class AddNewCustomer {
	WebDriver ldriver;
	
	public AddNewCustomer(WebDriver rdriver){
		ldriver=rdriver;
		PageFactory.initElements(rdriver,this);
	}
	
	@FindBy(linkText="New Customer")
	WebElement AddNewCustomer;
	
	@FindBy(xpath="//input[@type='text']")
	WebElement cust_name;
	
	@FindBy(name="rad1")
	WebElement gender;
	
	@FindBy(id="dob")
	WebElement dob;
	
	@FindBy(how=How.NAME, using="addr")
	WebElement address;
	
	@FindBy(how=How.NAME, using="city")
	WebElement city;
	
	@FindBy(name="state")
	WebElement state;
	
	@FindBy(name="pinno")
	WebElement pin_no;
	
	@FindBy(name="telephoneno")
	WebElement tele_no;
	
	@FindBy(name="emailid")
	WebElement email_id;
	
	@FindBy(name="sub")
	WebElement submit;
	
	public void new_link() {
		AddNewCustomer.click();
	}

	public void Cust_name(String cname) {
		cust_name.sendKeys(cname);
	}
	
	public void Gender() {
		gender.click();
	}
	
	public void DOB(String dd,String mm,String yyyy) {
		dob.sendKeys(dd);
		dob.sendKeys(mm);
		dob.sendKeys(yyyy);
	}
	
	public void Address(String addr) {
		address.sendKeys(addr);
	}
	
	public void City(String c) {
		city.sendKeys(c);
	}
	
	public void State(String S) {
		state.sendKeys(S);
	}
	
	public void Pin(int p) {
		pin_no.sendKeys(String.valueOf(p));//coverting integer to String
	}
	
	public void tele(int p) {
		tele_no.sendKeys(String.valueOf(p));//coverting integer to String
	}
	
	public void Email(String E) {
		email_id.sendKeys(E);
	}
	
	public void submit() {
		submit.click();
	}
	
	
}
