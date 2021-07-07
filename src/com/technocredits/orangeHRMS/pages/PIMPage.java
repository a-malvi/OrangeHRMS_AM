package com.technocredits.orangeHRMS.pages;

import com.technocredits.orangeHRMS.base.PredefinedMethods;

public class PIMPage extends PredefinedMethods {
	
	public void clickOnPIM() {
		clickOnElement("xpath", "//span[@class='left-menu-title'][text()='PIM']", false);
	}
		
}
