package com.technocredits.orangeHRMS.testscripts;

import java.util.ArrayList;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.technocredits.orangeHRMS.pages.HomePage;

public class VerifyWidgetOrdering extends TestBase {

	@Test
	public void verifyWidgetOrderingForUser() throws InterruptedException {
		HomePage homePage = logMeIn();
		ArrayList<String> defaultWidgetList = homePage.getListOfWidgetHeading("xpath", "//span[@class='widget-header-text']", true);
		homePage.dragAndDrop("xpath", "//span[@class='widget-header-text'][text()='Quick Access']",
				"//span[text()='Employees on Leave Today']", true);
		
		ArrayList<String> alteredWidgetList = homePage.getListOfWidgetHeading("xpath", "//span[@class='widget-header-text']", true);
		System.out.println("defaultWidgetList"+defaultWidgetList);
		System.out.println("alteredWidgetList"+alteredWidgetList);
		LogOutUser();// need to check with Maulik
		tearDown();
		setUp();
		HomePage homePage2 = logMeIn();
		ArrayList<String> reloginWidgetList = homePage2.getListOfWidgetHeading("xpath", "//span[@class='widget-header-text']", true);
		System.out.println("reloginWidgetList"+reloginWidgetList);
		Assert.assertEquals(alteredWidgetList, reloginWidgetList);	
	}
}
