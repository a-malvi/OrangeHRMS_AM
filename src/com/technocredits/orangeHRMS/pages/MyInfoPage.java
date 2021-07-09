package com.technocredits.orangeHRMS.pages;

import com.technocredits.orangeHRMS.base.PredefinedMethods;

public class MyInfoPage extends PredefinedMethods {
	
	public MyInfoPage clickOnMyInfo() {
		clickOnElement("xpath", "//span[@class='left-menu-title'][text()='My Info']", false);
		return new MyInfoPage();
	}

	public MyInfo_SalaryPage clickOnSalary() {
		clickOnElement("xpath", "//span[@class='material-icons topMenuPimIcons'][text()='ohrm_salary']", true);
		return new MyInfo_SalaryPage();
	}
	
	public String getFirstName(){
		return getElementAttribute("xpath", "//input[@id='firstName']","value", true);
	}
	
	public String getLastName(){
		return getElementAttribute("xpath", "//input[@id='lastName']","value", false);
	}
	
	public String getMyNameOnImage() {
		return getElementText("xpath", "//span[@id='account-name']", true);
		
	}
}
