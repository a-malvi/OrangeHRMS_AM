package com.technocredits.orangeHRMS.pages;

import org.apache.commons.math3.util.Precision;

import com.technocredits.orangeHRMS.base.PredefinedMethods;

public class MyInfo_SalaryPage extends PredefinedMethods {

	public double getCTCValue() throws Exception {
		Thread.sleep(5000);
		//double value = Double.parseDouble(getElementText("xpath", "//div[@class='col s1 total'][contains(@ng-bind, 'costToCompany')]", true).replaceAll(",", ""));
		double value = Double.parseDouble(getElementText("xpath", "//div[@id='salary_details_tab']//div[3]/div[2]", true).replaceAll(",", ""));
		return value;
		//return Precision.round(value, 2);
	}
	
	public double getDeductionValue() {
		return Double.parseDouble(getElementText("xpath", "//div[@class='col s1 total'][contains(@ng-bind, 'deductions')]", true).replaceAll(",", ""));
	}
	
	public double getTotalPayableValue() {
		return Double.parseDouble(getElementText("xpath", "//div[@class='col s1 total'][contains(@ng-bind, 'totalPayment')]", true).replaceAll(",", ""));
	}
}
