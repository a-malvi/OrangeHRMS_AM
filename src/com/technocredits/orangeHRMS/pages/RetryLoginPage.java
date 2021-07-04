package com.technocredits.orangeHRMS.pages;

import com.technocredits.orangeHRMS.base.PredefinedMethods;

public class RetryLoginPage extends PredefinedMethods {
	
	public String getPageUrl() {
		return driver.getCurrentUrl();
	}

}
