package com.technocredits.orangeHRMS.pages;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.openqa.selenium.WebElement;

import com.technocredits.orangeHRMS.base.PredefinedMethods;

public class HomePage extends PredefinedMethods{

	public boolean isLoginImageDisplayed() {
		return isElementDisplayed("xpath", "//div[@id='main-menu']", true);
	}


	public List<WebElement> getWidgetList() {
		List<WebElement> itemList = getElements("xpath", "//div[@class='dashboard-widget-container']", true);
		return itemList;	
	}

	public int getWidgetCount() {
		return getWidgetList().size();
	}

	public HomePage clickOnArrowButton() {
		clickOnElement("xpath", "//span[@id='account-job']/i", true);
		return this;
	}

	public List<WebElement> getListOfUserMenu() {
		return getElements("xpath", "//ul[@id='user_menu']/li/a", true);
	}

	public ArrayList<String> getListOfMenuText(){
		return getElementsText("xpath", "//ul[@id='user_menu']/li/a", true);
	}	

	public void clickOnAbout() {
		clickOnElement("xpath", "//ul[@id='user_menu']/li/a[text()='About']", false);
	}

	public void clickOnChangePassword() {
		clickOnElement("xpath", "//ul[@id='user_menu']/li/a[text()='Change Password']", false);
	}

	public void clickOnLogout() {
		clickOnElement("xpath", "//ul[@id='user_menu']/li/a[text()='Logout']", false);
	}

	public HashMap<String,String> getDetailsOnAboutPage() {
		HashMap<String, String> aboutDetailsHM = new HashMap<String,String>();
		ArrayList<String> aboutDetailsTextList  = getElementsText("xpath", "//div[@id='displayAbout']//p", true);
		for(String itemAboutDetail :  aboutDetailsTextList) {
			String[] itemStrArr = itemAboutDetail.split(":");
			aboutDetailsHM.put(itemStrArr[0].trim(), itemStrArr[1].trim());
		}
		return aboutDetailsHM;
	}
	
	public MyInfoPage clickOnMyInfo() {
		clickOnElement("xpath", "//span[@combinedmenutitle='My Info']", true);
		return new MyInfoPage();
	}
}
