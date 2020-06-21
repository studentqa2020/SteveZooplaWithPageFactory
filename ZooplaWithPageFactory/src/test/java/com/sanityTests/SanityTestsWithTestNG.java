package com.sanityTests;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import com.generic.code.BaseLogin;
import com.generic.code.HomeSelectionPage;
import com.generic.code.SearchHome;

public class SanityTestsWithTestNG {
	
	WebDriver driver;
	
	@BeforeTest
	
	public void login() throws Throwable {
		
		driver =BaseLogin.getLogin();
	}
	
	@Test
	
	public void searchforHome() throws Throwable {
		
		SearchHome.searhHomes(driver);
				
	}
	
	
	@AfterTest

	public void teardown() {
	
		driver.quit();
}
}
