package com.technocredits.orangeHRMS.base;

import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import net.bytebuddy.implementation.bytecode.Throw;

public class PredefinedMethods {
	protected static WebDriver driver;

	public static void launchBrowser(String URL) {
		System.setProperty("webdriver.chrome.driver", "F:\\New Beginning\\Eclipse Workspace\\SeleniumBasics\\resources\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get(URL);	
		driver.manage().window().maximize();
	}

	public static WebElement findWEBy(String strategy,String value) {

		if(strategy.equals("xpath")) {
			return driver.findElement(By.xpath(value));
		}
		else if(strategy.equals("id")) {
			return driver.findElement(By.id(value));
		}
		else if(strategy.equals("linkText")) {
			return driver.findElement(By.linkText(value));
		}
		else if(strategy.equals("className")) {
			return driver.findElement(By.className(value));
		}
		else if(strategy.equals("cssSelector")) {
			return driver.findElement(By.cssSelector(value));
		}
		else {
			return driver.findElement(By.partialLinkText(value));
		}		
	}

	public static void  tearDown() {
		driver.close();

	}
}
