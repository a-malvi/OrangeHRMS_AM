package com.technocredits.orangeHRMS.base;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


import com.technocredits.orangeHRMS.constants.ConstantPath;

public class PredefinedMethods {
	protected static WebDriver driver;
	protected static WebDriverWait wait;

	// Method to launch browser
	public static void launchBrowser(String URL) {
		System.setProperty(ConstantPath.CHROMEDRIVER, ConstantPath.CHROMEDRIVEREXE);
		driver = new ChromeDriver();
		driver.get(URL);
		driver.manage().window().maximize();
		wait = new WebDriverWait(driver, ConstantPath.AVGWAIT);
	}

	// Method to get Web Element from locator
	protected WebElement getElement(String locatorType, String locator, boolean isWaitRequired) {
		WebElement element;
		switch (locatorType.toUpperCase()) {
		case "XPATH":
			if (isWaitRequired)
				element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(locator)));
			else
				element = driver.findElement(By.xpath(locator));
			break;

		case "ID":
			if (isWaitRequired)
				element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(locator)));
			else
				element = driver.findElement(By.id(locator));
			break;

		case "CSSSELECTOR":
			if (isWaitRequired)
				element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(locator)));
			else
				element = driver.findElement(By.cssSelector(locator));
			break;

		case "CLASSNAME":
			if (isWaitRequired)
				element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.className(locator)));
			else
				element = driver.findElement(By.className(locator));
			break;

		case "LINKTEXT":
			if (isWaitRequired)
				element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText(locator)));
			else
				element = driver.findElement(By.linkText(locator));
			break;

		case "PARILALLINKTEXT":
			if (isWaitRequired)
				element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.partialLinkText(locator)));
			else
				element = driver.findElement(By.partialLinkText(locator));
			break;

		case "TAGNAME":
			if (isWaitRequired)
				element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.tagName(locator)));
			else
				element = driver.findElement(By.tagName(locator));
			break;

		case "NAME":
			if (isWaitRequired)
				element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name(locator)));
			else
				element = driver.findElement(By.name(locator));
			break;

		default:
			System.out.println("Invalid Locator Type");
			element = null;
		}
		return element;
	}

	// Method to get WebElement list
	protected List<WebElement> getElements(String locatorType, String locator, boolean isWaitRequired) {
		List<WebElement> elementList;
		switch (locatorType.toUpperCase()) {
		case "XPATH":
			if (isWaitRequired)
				elementList = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath(locator)));
			else
				elementList = driver.findElements(By.xpath(locator));
			break;

		case "ID":
			if (isWaitRequired)
				elementList = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.id(locator)));
			else
				elementList = driver.findElements(By.id(locator));
			break;

		case "CSSSELECTOR":
			if (isWaitRequired)
				elementList = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.cssSelector(locator)));
			else
				elementList = driver.findElements(By.cssSelector(locator));
			break;

		case "CLASSNAME":
			if (isWaitRequired)
				elementList = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.className(locator)));
			else
				elementList = driver.findElements(By.className(locator));
			break;

		case "LINKTEXT":
			if (isWaitRequired)
				elementList = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.linkText(locator)));
			else
				elementList = driver.findElements(By.linkText(locator));
			break;

		case "PARILALLINKTEXT":
			if (isWaitRequired)
				elementList = wait
						.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.partialLinkText(locator)));
			else
				elementList = driver.findElements(By.partialLinkText(locator));
			break;

		case "TAGNAME":
			if (isWaitRequired)
				elementList = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.tagName(locator)));
			else
				elementList = driver.findElements(By.tagName(locator));
			break;

		case "NAME":
			if (isWaitRequired)
				elementList = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.name(locator)));
			else
				elementList = driver.findElements(By.name(locator));
			break;

		default:
			System.out.println("Invalid Locator Type");
			elementList = null;
		}
		return elementList;
	}

	// Method to scroll screen to particular web element
	protected void scrollToElement(WebElement element) {
		if (!element.isDisplayed()) {
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].scrollIntoView(true)", element);
		}
	}
	
	//Overloaded Method to scroll
	protected void scrollToElement(String locatorType, String locator, boolean isWaitRequired) {
		WebElement element = getElement(locatorType, locator, isWaitRequired);
		if (!element.isDisplayed()) {
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].scrollIntoView(true)", element);
		}
	}
	// Method to check if element is displayed
	protected boolean isElementDisplayed(WebElement element) {
		if (element.isDisplayed()) {
			return true;
		} else {
			scrollToElement(element);
			return element.isDisplayed();
		}
	}

	// Override method to check of Web Element is displayed
	protected boolean isElementDisplayed(String locatorType, String locator, boolean isWaitRequired) {
		try {
			WebElement element = getElement(locatorType, locator, isWaitRequired);
			return isElementDisplayed(element);
		} catch (Exception e) {
			return false;
		}
	}

	// Method to get Text of element
	protected String getElementText(WebElement element) {
		scrollToElement(element);
		return element.getText();
	}

	// Override method to get text of web element
	protected String getElementText(String locatorType, String locator, boolean isWaitRequired) {
		return getElement(locatorType, locator, isWaitRequired).getText();
	}

	// Method to get Elements Text in List
	protected ArrayList<String> getElementsText(List<WebElement> listWE) {
		ArrayList<String> textListWE = new ArrayList<String>();
		Iterator<WebElement> itr = listWE.iterator();
		while (itr.hasNext()) {
			textListWE.add(itr.next().toString());
		}
		return textListWE;
	}

	// Override method to get text of web elements in list
	protected ArrayList<String> getElementsText(String locatorType, String locator, boolean isWaitRequired) {
		List<WebElement> listWE = getElements(locatorType, locator, isWaitRequired);
		ArrayList<String> textListWE = new ArrayList<String>();
		Iterator<WebElement> itr = listWE.iterator();
		while (itr.hasNext()) {
			textListWE.add(itr.next().getText());
		}
		return textListWE;
	}

	// Method to enter Text
	protected void enterText(String locatorType, String locator, boolean isWaitRequired, String text) {
		WebElement element = getElement(locatorType, locator, isWaitRequired);
		element.clear();
		if (element.isEnabled())
			element.sendKeys(text);
		else {
			// throw new ElementNotEnabled("Element was not enabled for Locator Type "
			// +locatorType+ " for locator value "+locator);
			System.out.println(
					"Element was not enabled for Locator Type " + locatorType + " for locator value " + locator);
		}
	}

	// Method to click on element
	protected void clickOnElement(String locatorType, String locator, boolean isWaitRequired) {
		WebElement element = getElement(locatorType, locator, isWaitRequired);
		try{	
			wait.until(ExpectedConditions.elementToBeClickable(element));
			element.click();
		}catch(ElementClickInterceptedException ecie) {
			scrollToElement(locatorType, locator, isWaitRequired);
			element.click();
		}
	}

	// Method to get element attribute
	protected String getElementAttribute(String locatorType, String locator, String attribute, boolean isWaitRequired) {
		WebElement element = getElement(locatorType, locator, isWaitRequired);
		return element.getAttribute(attribute);
	}

	// Method to Drag and Drop an element
	protected void moveElementFromTo(String LocatorType, String targetLocator, String toLocator, boolean isWaitRequired) {
		Actions actions = new Actions(driver);
		WebElement targetElement = getElement(LocatorType, targetLocator, isWaitRequired);
		WebElement toElement = getElement(LocatorType, toLocator, isWaitRequired);
		actions.clickAndHold(targetElement)
				.dragAndDrop(targetElement,	toElement)
				.build().perform();
	}

	//Method to take screenshot
	protected static void takeScreenShot(String testCasename) {
		TakesScreenshot screenShot = (TakesScreenshot) driver;
		File file = screenShot.getScreenshotAs(OutputType.FILE);
		try {
			FileUtils.copyFile(file, new File(ConstantPath.SCREENSHOTFOLDER + testCasename + System.currentTimeMillis() + ".jpeg"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void tearDown() {
		driver.close();
	}
}
