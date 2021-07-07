package com.technocredits.orangeHRMS.testscripts;

import java.util.ArrayList;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.technocredits.orangeHRMS.base.PredefinedMethods;
import com.technocredits.orangeHRMS.pages.HomePage;
import com.technocredits.orangeHRMS.pages.LoginPage;
import com.technocredits.orangeHRMS.pages.MyInfoPage;
import com.technocredits.orangeHRMS.pages.MyInfo_SalaryPage;

public class VerifyPayableAmount_Test extends TestBase {
	
	
	@Test
	public void verifyTotalPayableAmount() throws Exception{
		LoginPage loginPage = new LoginPage();
		HomePage homePage = loginPage.logOn("Admin", "Admin123");
		
		MyInfoPage myInfoPage = homePage.clickOnMyInfo();
		MyInfo_SalaryPage salaryPage = myInfoPage.clickOnSalary();
		System.out.println(salaryPage.getCTCValue());
		//System.out.println(salaryPage.getDeductionValue());
		//System.out.println(salaryPage.getTotalPayableValue());
		Assert.assertFalse(salaryPage.getTotalPayableValue() == 0);
	}

	
}
