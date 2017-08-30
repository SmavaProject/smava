package de.smava.project.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPopup extends AbstractPage {
	
	@FindBy(css=".ui.left.icon.fluid.input:nth-child(1) input")
	public WebElement emailInpit;

	@FindBy(css=".ui.left.icon.fluid.input:nth-child(2) input")
	private WebElement passwordInput;
	
	@FindBy(css=".ui.right.labeled.icon.fluid.button")
	private WebElement anmelden;


	public LoginPopup(WebDriver driver, WebDriverWait wait){
		super(driver, wait);
	}
	
	void typeInInput(WebElement input, String textToType) {
		input.sendKeys(textToType);
	}
	
	public LoginPopup typeEmail (String email) {
		emailInpit.sendKeys(email);
		return this;
	}
	public LoginPopup typePassword(String password) {
		passwordInput.sendKeys(password);
		return this;
	}
	public LoginFailedPage loginWithWrongCredentials (String wrongEmail, String wrongPassword) {
		typeEmail(wrongEmail);
		typePassword(wrongPassword);
		anmelden.click();
		return new LoginFailedPage(driver, wait);
	}
}
