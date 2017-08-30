package de.smava.project.test;

import static org.junit.Assert.assertTrue;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import de.smava.project.page.*;

public class CompareTest extends AbstractTest{
	@Before
	public void setup() {
		setupTest();
	}

	@Test
	public void loanSearch() {
		LandingPage landingPage = new LandingPage(driver, wait); // move to setup-???????
		
		landingPage.wait(landingPage.nettoKreditBetrag);
		
		landingPage.typeLoanAmount("2750");
		landingPage.typeLoanTime("24 Monate");
		landingPage.selectLoanGoalWohnen();
				
		landingPage.wait(landingPage.weiterSWK);
		
		CompareCreditPage compareCreditPage = landingPage.clickWeiter();
		
		assertTrue(compareCreditPage.isPageLoaded());	
	}

	@After
	public void tearDown() {
		tearDownTest();
	}

}
