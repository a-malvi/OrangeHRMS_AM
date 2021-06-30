package com.technocredits.orangeHRMS.pages;

import org.openqa.selenium.By;

import com.technocredits.orangeHRMS.base.PredefinedMethods;

public class LoginPage extends PredefinedMethods {

	public HomePage logOn(String userName, String password) {
		enterUsername(userName);
		enterpassword(password);
		clickOnLogin();
		return new HomePage();
	}

	public LoginPage enterUsername(String userName) {
		driver.findElement(By.xpath("//input[@id='txtUsername']")).sendKeys(userName);
		return this;
	}
	public LoginPage enterpassword(String password) {
		driver.findElement(By.xpath("//input[@id='txtPassword']")).sendKeys(password);
		return this;
	}
	public LoginPage clickOnLogin() {
		driver.findElement(By.xpath("//input[@id='btnLogin']")).click();
		return this;
	}
	
	public static void closePage() {
		tearDown();
	}

}
