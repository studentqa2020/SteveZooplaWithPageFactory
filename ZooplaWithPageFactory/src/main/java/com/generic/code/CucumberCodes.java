package com.generic.code;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;

import com.config.BaseConfig;
import com.page.object.model.LoginPage;
import com.page.object.model.ProductPage;
import com.util.TakeAppScreenShot;
import com.util.Wait;

public class CucumberCodes {
	
	static LoginPage login;
	static ProductPage pf;
		
public static WebDriver setup(WebDriver driver) throws Throwable {
		
		System.setProperty("webdriver.chrome.driver", "./Driver/chromedriver.exe");
		System.setProperty(ChromeDriverService.CHROME_DRIVER_SILENT_OUTPUT_PROPERTY, "true");
		Logger.getLogger("org.openqa.selenium").setLevel(Level.OFF);
		
		driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		return driver;
		
}

	public static void get_URL(WebDriver driver) throws Throwable {
		driver.get(BaseConfig.getconfig("URL"));
		
}
	public static void clickCookies (WebDriver driver) {
		login =new LoginPage(driver);
		
		System.out.println(driver.getTitle());
				
		login.getCookies().click();
		
	}
	
	public static void clickSignIn (WebDriver driver) {
		login.getLogin().click();
		
	}
	
	public static void sendUserName (WebDriver driver) throws Throwable {
		
		login.getEmail().sendKeys(BaseConfig.getconfig("email"));
	}
	
	public static void sendPassword (WebDriver driver) throws Throwable {
		
		login.getPass().sendKeys(BaseConfig.getconfig("pass"));
	}

	public static void clickSubmit (WebDriver driver){
		
		login.getSubmit().click();
	}
	
	public static void searchHomes (WebDriver driver) throws Throwable {
		//Thread.sleep(3000);		
		pf = new ProductPage(driver);
		Wait.getExplicitWaitClickable(driver, pf.getSearchBox());
		pf.getSearchBox().sendKeys(BaseConfig.getconfig("location"));
		
		pf.getSearchBtn().click();
		
	}
	
	public static void sortHomes (WebDriver driver) throws Throwable{
		
		pf.getHomePrices().forEach(price ->{
			
			System.out.println("Original Home price = "+ price.getText());
		});
				
			String [] Homeprice;
			List<Integer> AllPrices = new ArrayList<>();
			for(int i=0; i<pf.getHomePrices().size();i++) {
				
				Homeprice = pf.getHomePrices().get(i).getText().split(" ");
				AllPrices.add(Integer.parseInt(Homeprice[0].replace("£","").replace(",","").trim()));//.trim method removes white space
			}

			Collections.sort(AllPrices);
			Collections.reverse(AllPrices);
			System.out.println("Sorted Home Prices: "+AllPrices);
				
			Thread.sleep(3000);
	    
	}
		
	
	public static void select5th (WebDriver driver){
		
		pf.getHomePrices().get(4).click();	//Index 4 gives 5th Property
		
		new Wait().getExplicitWaitVisible(driver, pf.getAgentPhoneNum());
	}
	public static void getAgentInfo (WebDriver driver){
		
	Wait.getExplicitWaitVisible(driver, pf.getAgentName());
	System.out.println("Agent Name is: "+pf.getAgentName().getText());
	System.out.println("Agent Phone # is: "+pf.getAgentPhoneNum().getText());
	TakeAppScreenShot.captureScreenShot(driver, "Agent Info with Logo");
	System.out.println("Logo is available, See Screen Shot");
	
	TakeAppScreenShot.captureScreenShot(driver, "User has signed out");
	
	
	driver.quit();
}
}

