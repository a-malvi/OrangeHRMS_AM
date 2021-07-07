package com.technocredits.orangeHRMS.pages;

import com.technocredits.orangeHRMS.base.PredefinedMethods;

public class PunchInOutPage extends PredefinedMethods{
	
	public PunchInOutPage clickOnPunchInOut() {
		clickOnElement("xpath", "//span[@class='left-menu-title'][text()='Punch In/Out']", true);
		return new PunchInOutPage();
	}
	
	public PunchInOutPage ClickOnCalenderIcon(){
		clickOnElement("xpath", "//i[@class='material-icons action-icon date-picker-open-icon']", true);
		return this;
		
	}
	public PunchInOutPage setDateValue(int date, String month, int year) {
		ClickOnCalenderIcon();
		String dateValue = (date<10) ? String.valueOf(date) : String.valueOf(date);
		String dateFormated = String.valueOf(dateValue)+" "+month.substring(0,3)+" "+String.valueOf(year);
		clickOnElement("xpath", "//div[contains(@aria-label,'"+dateFormated+"')]", true);
		return this;
	}
	
	public PunchInOutPage clickOnIn() {
		clickOnElement("xpath", "//button[text()='In']", true);
		return this;
	}
	
	public PunchInOutPage clickOnOut() {
		clickOnElement("xpath", "//button[text()='Out']", true);
		return this;
	}
	
	public PunchInOutPage enterOutTime(String sendText) {
		
		enterText("xpath", "//input[@id='time']", true, sendText);
		return this;
	}

	public String getToastMessagetext() {
		return getElementText("xpath", "//div[@class='toast-message'] [text()='Successfully Saved']", true);
	}
}
