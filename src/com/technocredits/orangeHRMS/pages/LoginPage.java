package com.technocredits.orangeHRMS.pages;

import org.openqa.selenium.By;

import com.technocredits.orangeHRMS.base.PredefinedMethods;

public class LoginPage extends PredefinedMethods {

	public boolean isLogoDisplayed() {
		return isElementDisplayed("id", "divLogo", false);
	}
	
	public HomePage logOn(String userName, String password) {
		enterUsername(userName);
		enterPassword(password);
		clickOnLogin();
		return new HomePage();
	}

	public LoginPage enterUsername(String userName) {
		enterText("xpath", "//input[@id='txtUsername']", false, userName);
		return this;
	}
	public LoginPage enterPassword(String password) {
		enterText("xpath", "//input[@id='txtPassword']", false, password);
		return this;
	}
	public LoginPage clickOnLogin() {
		clickOnElement("xpath", "//input[@id='btnLogin']", true);
		return this;
	}
	
	public String getErrorText(String locatorType,String locator,boolean isWaitRequired) {
		return getElementText(locatorType, locator, isWaitRequired);
		
	}
	
	public String getPageURL() {
		return driver.getCurrentUrl();
	}
	
	public void closePage() {
		tearDown();
	}

}
