package com.technocredits.orangeHRMS.pages;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.technocredits.orangeHRMS.base.PredefinedMethods;

public class HomePage extends PredefinedMethods{
	
	public boolean isMainMenuDisplayed() {
		WebDriverWait wait = new WebDriverWait(driver, 3);
		return wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//ul[@id='mainMenuFirstLevelUnorderedList']"))).isDisplayed();	
	}
	public ArrayList<String> getMenuList() {
		List<WebElement> itemList = driver.findElements(By.xpath("//ul[@id='mainMenuFirstLevelUnorderedList']/li/a"));
		ArrayList<String> items = new ArrayList<String>();
	Iterator<WebElement> itr = itemList.iterator();
		while(itr.hasNext()) {
			items.add(itr.next().getText());
		}	
		return items;	
	}
}
