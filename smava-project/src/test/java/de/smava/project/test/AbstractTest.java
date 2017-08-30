package de.smava.project.test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import de.smava.project.driver.WebDriverWrapper;

public abstract class AbstractTest{
	
	protected WebDriver driver;
	protected WebDriverWait wait;
	
	void setupTest() {
		WebDriverWrapper wrapper = new WebDriverWrapper();
		driver = wrapper.getDriver();
		wait = wrapper.getWait();
		driver.get("https://www.smava.de/");
		driver.manage().window().maximize();
	}

	void tearDownTest() {
		driver.quit();
	}
	
}

