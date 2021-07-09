package com.technocredits.orangeHRMS.testscripts;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.technocredits.orangeHRMS.base.PredefinedMethods;
import com.technocredits.orangeHRMS.pages.HomePage;
import com.technocredits.orangeHRMS.pages.LoginPage;
import com.technocredits.orangeHRMS.utils.ExcelReader_Util;


public class Login_Test extends TestBase {
	//WebDriver driver;

	
	@Test(enabled=false)
	public void verifyUserSuccesfullLogin(){
		LoginPage loginPage = new LoginPage();
		HomePage homePage = loginPage.logOn("Admin", "Admin123");
		Assert.assertTrue(homePage.isLoginImageDisplayed());
		Assert.assertEquals(homePage.getWidgetCount(),11);
	}

	@Test(dataProvider= "LoginData")
	public void verifyLogins(String userName, String password, String message) {
		LoginPage loginPage = new LoginPage();
		loginPage.logOn(userName, password);
		Assert.assertTrue(loginPage.isLoginPageLabel());
		if(message.equals("Password cannot be empty")) {
			String actualMessage = loginPage.getErrorText("xpath", "//span[@id='spanMessage']", true);
			Assert.assertEquals("Password cannot be empty", actualMessage);
		}
		else if(message.equals("Username cannot be empty")) {
			String actualMessage = loginPage.getErrorText("xpath", "//span[@id='spanMessage']", true);
			Assert.assertEquals("Username cannot be empty", actualMessage);
		}
		else {
			Assert.assertTrue(loginPage.getPageURL().endsWith(message));	
		}
		
	}

	@DataProvider(name = "LoginData")
	public Object[][] getLoginDataFromExcel() throws IOException {
		return ExcelReader_Util.getSheetData("Login_TestData.xlsx", "LoginData" );

	}

}
