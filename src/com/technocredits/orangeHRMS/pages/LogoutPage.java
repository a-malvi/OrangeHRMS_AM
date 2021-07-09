package com.technocredits.orangeHRMS.pages;

import com.technocredits.orangeHRMS.base.PredefinedMethods;

public class LogoutPage extends PredefinedMethods{

	public LoginPage logOut() {
		clickOnArrowIcon();
		clickOnElement("xpath", "//a[text()='Logout']", true);
		return new LoginPage();	
	}

	public void clickOnArrowIcon() {
		clickOnElement("xpath", "//i[text()='keyboard_arrow_down']", false);	}
}
