package de.smava.project.test;

import static org.junit.Assert.assertTrue;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import de.smava.project.page.*;

public class LoginTest extends AbstractTest {
	private static final String WRONG_EMAIL = "wrong_email@gmail.com"; 
	private static final String WRONG_PSW = "wrong_password";
	
	@Before
	public  void setup(){
		setupTest();
	}
	
	@Test
	public void anmendenFailed() {
		
		LandingPage landingPage = new LandingPage(driver, wait); 

		LoginPopup loginPopup = landingPage.clickAnmelden();
		
		loginPopup.wait(loginPopup.emailInpit);
		
		LoginFailedPage loginFailedPage = loginPopup.loginWithWrongCredentials(WRONG_EMAIL, WRONG_PSW);
		
		loginFailedPage.wait(loginFailedPage.warningBox);
		
		assertTrue(loginFailedPage.text(loginFailedPage.warningBox).contains(loginFailedPage.WARNING_MSG));
	}
	@After
	public void tearDown() {
		tearDownTest();
	}
}
