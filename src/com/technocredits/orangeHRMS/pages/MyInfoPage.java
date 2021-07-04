package com.technocredits.orangeHRMS.pages;

import com.technocredits.orangeHRMS.base.PredefinedMethods;

public class MyInfoPage extends PredefinedMethods {

	public MyInfo_SalaryPage clickOnSalary() {
		clickOnElement("xpath", "//span[@class='material-icons topMenuPimIcons'][text()='ohrm_salary']", true);
		return new MyInfo_SalaryPage();
	}

}
