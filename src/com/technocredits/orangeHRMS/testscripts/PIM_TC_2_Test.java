package com.technocredits.orangeHRMS.testscripts;

import java.util.ArrayList;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.technocredits.orangeHRMS.base.PredefinedMethods;
import com.technocredits.orangeHRMS.pages.HomePage;
import com.technocredits.orangeHRMS.pages.LoginPage;

public class PIM_TC_2_Test {
	
	@BeforeMethod
	public void setUp() {
		PredefinedMethods.launchBrowser("https://tcohrms-trials71.orangehrmlive.com/");
	}
	@Test
	public void verifyEmployeeCount(){
		LoginPage loginPage = new LoginPage();
		HomePage homePage = loginPage.logOn("Admin", "Admin123");
		homePage.clickOnArrowButton();
		ArrayList<String> menuList = homePage.getListOfMenuText();
		System.out.println(menuList);
		homePage.clickOnAbout();
		int employeeCount = Integer.valueOf(homePage.getDetailsOnAboutPage().get("Employees").split(" ")[0]);
		System.out.println(employeeCount);
		Assert.assertFalse(employeeCount==0);

	}

	@AfterMethod
	public void tearDown() {
		PredefinedMethods.tearDown();
	}
}
