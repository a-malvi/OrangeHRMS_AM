package com.technocredits.orangeHRMS.testscripts;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import com.technocredits.orangeHRMS.base.PredefinedMethods;
import com.technocredits.orangeHRMS.pages.AttendencePage;
import com.technocredits.orangeHRMS.pages.HomePage;
import com.technocredits.orangeHRMS.pages.LeavePage;
import com.technocredits.orangeHRMS.pages.LoginPage;
import com.technocredits.orangeHRMS.pages.LogoutPage;
import com.technocredits.orangeHRMS.pages.MyInfoPage;
import com.technocredits.orangeHRMS.pages.PIMPage;
import com.technocredits.orangeHRMS.pages.PunchInOutPage;

public class TestBase {
	
	@BeforeClass
	public void setUp() {
		PredefinedMethods.launchBrowser("https://tcohrms-trials71.orangehrmlive.com/");
	}
	
	//@AfterClass
	public void tearDown() {
		PredefinedMethods.tearDown();
	}
	
	
	HomePage logMeIn() {
		LoginPage loginPage = new LoginPage();
		loginPage.logOn("Admin", "Admin123");
		return new HomePage();
	}
	
	MyInfoPage goto_MyInfo() {
		MyInfoPage myInfoPage = new MyInfoPage();
		myInfoPage.clickOnMyInfo();
		return myInfoPage;
	}
	
	PIMPage goto_PIM() {
		PIMPage pimPage = new PIMPage();
		pimPage.clickOnPIM();
		return pimPage;
	}
	
	LeavePage goto_Leave() {
		LeavePage leavePage = new LeavePage();
		leavePage.clickOnLeave();
		return leavePage;
		
	}
	 AttendencePage goto_AttendencePage() {
		 AttendencePage attendencePage = new AttendencePage();
		 attendencePage.clickOnAttendence();
		 return new AttendencePage();	 
	 }
	 
	 LoginPage LogOutUser() {
		 LogoutPage logoutPage = new LogoutPage();
		 return logoutPage.logOut();
	 }
	 
	 void navigateToUrl() {
		 
		 
	 }
}
