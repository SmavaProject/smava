package de.smava.project.driver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WebDriverWrapper {
	private WebDriver driver;
	private WebDriverWait wait;
	public int waitTimeSec = 5;
	
	public static final String PATH = "C://Program Files (x86)//Selenium//geckodriver-v0.15.0-win64//geckodriver.exe";
	
	public WebDriverWrapper(){
		System.setProperty("webdriver.gecko.driver", PATH);
		driver = new FirefoxDriver();
		wait = new WebDriverWait(driver, waitTimeSec);
	}
	public WebDriver getDriver() { 
		return driver;
	}
	public WebDriverWait getWait() {
		return wait;
	}

}
