package com.technocredits.orangeHRMS.pages;

import com.technocredits.orangeHRMS.base.PredefinedMethods;

public class LeavePage extends PredefinedMethods {
	
	public LeavePage clickOnLeave() {
		clickOnElement("xpath", "//span[@class='left-menu-title'][text()='Leave']", false);
		return new LeavePage();
	}
	
	public PunchInOutPage clickOnPunchInOut() {
		clickOnElement("xpath", "//span[@class='left-menu-title'][text()='Punch In/Out']", true);
		return new PunchInOutPage();
	}
}
