package com.technocredits.orangeHRMS.testscripts;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.technocredits.orangeHRMS.base.PredefinedMethods;
import com.technocredits.orangeHRMS.pages.HomePage;
import com.technocredits.orangeHRMS.pages.LoginPage;


public class Login_Test {
	WebDriver driver;

	@BeforeClass
	public void setUp() {
		PredefinedMethods.launchBrowser("https://opensource-demo.orangehrmlive.com/");
	}

	@Test 
	public void verifyUserlogin(){
		LoginPage loginPage = new LoginPage();
		HomePage homePage = loginPage.logOn("Admin", "admin123");
		Assert.assertTrue(homePage.isMainMenuDisplayed());
		System.out.println(homePage.getMenuList());
	}

	@AfterClass
	public void tearDown() {
		
	}
}
