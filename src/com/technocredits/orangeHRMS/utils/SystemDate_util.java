package com.technocredits.orangeHRMS.utils;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class SystemDate_util {
	static Date date = new Date();


	public static String getDateInFormate(String requiredDateFormate) {
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat(requiredDateFormate);
		return simpleDateFormat.format(date);	
	}

	public static int getDateOnly() {
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd");
		return Integer.parseInt(simpleDateFormat.format(date));

	}

	public static String getMonthOnly() {
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("MM");
		return simpleDateFormat.format(date);
	}

	public static int getYearOnly() {
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy");
		return Integer.parseInt(simpleDateFormat.format(date));	
	}

	public static String getMonthName(String monthIndex) {
		HashMap <String, String>monthNameHM = new HashMap<String, String>();
		monthNameHM.put("01", "January");
		monthNameHM.put("02", "February");
		monthNameHM.put("03", "March");
		monthNameHM.put("04", "April");
		monthNameHM.put("05", "May");
		monthNameHM.put("06", "June");
		monthNameHM.put("07", "July");
		monthNameHM.put("08", "August");
		monthNameHM.put("09", "September");
		monthNameHM.put("10", "October");
		monthNameHM.put("11", "November");
		monthNameHM.put("12", "December");
		

		return monthNameHM.get(monthIndex);  
	}
	public static void main(String[] args) {
		System.out.println(getMonthOnly());
	}
}

