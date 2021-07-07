package com.technocredits.orangeHRMS.testscripts;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.technocredits.orangeHRMS.pages.HomePage;
import com.technocredits.orangeHRMS.pages.LoginPage;
import com.technocredits.orangeHRMS.pages.MyInfoPage;

public class VerifyMyInfoPersonalDetails_Test extends TestBase{
	
	@Test
	public void verifyMyInformation() {
		LoginPage loginPage = new LoginPage();
		loginPage.logOn("Admin", "Admin123");
		
		HomePage homepage = new HomePage();
		
		MyInfoPage myInfoPage = goto_MyInfo();
		
		String nameOnHomePage = myInfoPage.getMyNameOnImage();
		String nameOnMyInfo = myInfoPage.getFirstName() +" "+ myInfoPage.getLastName();
		System.out.println("On Home Page "+nameOnHomePage);
		System.out.println("On Home Page "+nameOnMyInfo);
		Assert.assertEquals(nameOnHomePage, nameOnMyInfo);
	}

}
