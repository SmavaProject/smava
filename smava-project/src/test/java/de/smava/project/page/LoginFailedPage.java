package de.smava.project.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginFailedPage extends AbstractPage {
	@FindBy(css=".inner>p")
	public WebElement warningBox;
	
	public final String WARNING_MSG = "Sie m�chten auf einen Bereich zugreifen, der nur f�r angemeldete Nutzer zug�nglich ist";

	public LoginFailedPage(WebDriver driver, WebDriverWait wait) {
		super(driver, wait);
	}

}
