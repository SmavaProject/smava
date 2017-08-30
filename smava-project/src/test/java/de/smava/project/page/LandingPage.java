package de.smava.project.page;

import java.util.HashMap;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LandingPage extends AbstractPage{
	@FindBy(css="#myselect .search")
	public WebElement nettoKreditBetrag;
	
	@FindBy(css="div #myselect2 .search")
	private WebElement laufZeit;
	
	@FindBy(css=".ui.normal.dropdown.selection")
	private WebElement verwendung;
	
	@FindBy(css="*[data-value='2750']")
	private WebElement betrag2750;
	
	@FindBy (css="*[data-value='24']")
	private WebElement zeit24;
	
	@FindBy(css="*[data-value='886']")
	private WebElement verwendungWohnen;
	
	@FindBy(css="#forwardButtonswk")
	public WebElement weiterSWK;
	
	@FindBy(css=".item.login-popup.uppercase")
	private WebElement anmeldenButton;

	public LandingPage(WebDriver driver, WebDriverWait wait){
		super(driver, wait);
		nettoKreditBetragMap.put("2750", betrag2750);
		laufZeitMap.put("24 Monate", zeit24);
	}
	private HashMap<String, WebElement> nettoKreditBetragMap= new HashMap<String, WebElement>();
	private HashMap<String, WebElement> laufZeitMap= new HashMap<String, WebElement>();
	
	public LandingPage selectLoanGoalWohnen() {
		verwendung.click();
		wait.until(ExpectedConditions.visibilityOf(verwendungWohnen)).click(); 
		return this;
	}

	public LandingPage typeLoanAmount(String textToType) {
		nettoKreditBetrag.click();
		nettoKreditBetrag.sendKeys(textToType);
		wait.until(ExpectedConditions.visibilityOf(nettoKreditBetragMap.get(textToType))).click(); 
		return this;
	}
	public LandingPage typeLoanTime(String textToType) {
		laufZeit.click();
		laufZeit.sendKeys(textToType);
		wait.until(ExpectedConditions.visibilityOf(laufZeitMap.get(textToType))).click(); 
		return this;
	}
	public LoginPopup clickAnmelden() {
		anmeldenButton.click();
		return new LoginPopup(driver, wait);
	}
	
	public CompareCreditPage clickWeiter() {
		weiterSWK.click();
		return new CompareCreditPage(driver, wait);
	}

}
