package com.technocredits.orangeHRMS.testscripts;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.technocredits.orangeHRMS.pages.LoginPage;
import com.technocredits.orangeHRMS.utils.SystemDate_util;

public class VerifyPunchinForToday extends TestBase {
	
	
	@Test
	public void verifyTodaysIn() {
		LoginPage loginPage = new LoginPage();
		loginPage.logOn("Admin", "Admin123");
		int date = SystemDate_util.getDateOnly();
		String month = SystemDate_util.getMonthName(SystemDate_util.getMonthOnly());
		int year = SystemDate_util.getYearOnly();
		System.out.println(month + " "+date+ " "+ year );
		String actualToastMessage = goto_AttendencePage().goto_PunchInOutPage()
							 .setDateValue(date, month, year)
							 .clickOnIn()
							 .clickOnOut()
							 .enterOutTime("23:00")
							 .getToastMessagetext();
		Assert.assertEquals(actualToastMessage, "Successfully Saved");
	} 
}
