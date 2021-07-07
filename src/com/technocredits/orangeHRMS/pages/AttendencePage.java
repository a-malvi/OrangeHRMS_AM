package com.technocredits.orangeHRMS.pages;

import com.technocredits.orangeHRMS.base.PredefinedMethods;

public class AttendencePage extends PredefinedMethods {
	
	public AttendencePage clickOnAttendence() {
		clickOnElement("xpath", "//span[@class='left-menu-title'][text()='Attendance']", false);
		return new AttendencePage();
	}
	
	public PunchInOutPage goto_PunchInOutPage(){
		PunchInOutPage punchInOutPage = new PunchInOutPage();
		return punchInOutPage.clickOnPunchInOut();
	}
}
