package com.stepdef;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.config.BaseConfig;
import com.generic.code.BaseLogin;
import com.generic.code.CucumberCodes;
import com.page.object.model.LoginPage;
import com.page.object.model.ProductPage;
import com.util.Highlighter;
import com.util.TakeAppScreenShot;
import com.util.Wait;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

	
public class zooplaStepDef {
	
	WebDriver driver;
	LoginPage login;
	ProductPage pf;
	
	@Given("open a browser")
	public void open_a_browser() throws Throwable {
		driver = CucumberCodes.setup(driver);
						
	}

	@Given("Put URL")
	public void put_URL() throws Throwable {
		
		CucumberCodes.get_URL(driver);
			
			    
	}
	
	@When("Accept Cookies")
	public void accept_Cookies() {
		CucumberCodes.clickCookies(driver);
		
				
	}
	

	@When("Click Signin")
	public void click_Signin() {
	    
		CucumberCodes.clickSignIn(driver);
		
	}

	@When("put valid user name")
	public void put_valid_user_name() throws Throwable {
	    
		CucumberCodes.sendUserName(driver);

	}

	@When("put valid password")
	public void put_valid_password() throws Throwable {
	    
		CucumberCodes.sendPassword(driver);
	    
	}

	@When("click sign in button")
	public void click_sign_in_button() {
	    
		CucumberCodes.clickSubmit(driver);

		System.out.println(driver.getTitle());
		
	    }

	@When("search for properties in New York, Linconshire")
	public void search_for_properties_in_New_York_Linconshire() throws Throwable {
	
		CucumberCodes.searchHomes(driver);
	
	}

	@When("Sort the properties by Descending Order")
	public void sort_the_properties_by_Descending_Order() throws Throwable {
	    
		CucumberCodes.sortHomes(driver);
	    
	}

	@When("select the {int}th Property")
	public void select_the_th_Property(Integer int1) {
		CucumberCodes.select5th(driver);
	    
	}

	@Then("Validate login was success\\(sign out btn)")
	public void validate_login_was_success_sign_out_btn() {
	    
		CucumberCodes.getAgentInfo(driver);

	}

}
