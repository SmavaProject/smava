package de.smava.project.page;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.JavascriptExecutor;

public abstract class AbstractPage {
	
	protected WebDriverWait wait;
	protected WebDriver driver;
	
	AbstractPage(WebDriver driver, WebDriverWait wait){
		PageFactory.initElements(driver, this);
		this.driver = driver;
		this.wait = wait;
	}
	
	public void wait(WebElement element) {
		wait.until(ExpectedConditions.visibilityOf(element));
	}
	
	public String text (WebElement element){
		return element.getText();
	}
		
	public boolean isPageLoaded() {
		try{
			JavascriptExecutor js;
			if (driver instanceof JavascriptExecutor) {
				js = (JavascriptExecutor)driver;
				js.executeScript("return document.readyState");
			}
			return true;
		}catch (Exception e) {
			return false;
		}
	}
}
