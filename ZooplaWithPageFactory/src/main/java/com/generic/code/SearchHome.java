package com.generic.code;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

import com.config.BaseConfig;
import com.page.object.model.ProductPage;
import com.util.TakeAppScreenShot;
import com.util.Wait;

public class SearchHome {

	
	public static WebDriver searhHomes(WebDriver driver) throws Throwable {

		ProductPage pf = new ProductPage(driver);
		
		pf.getSearchBox().sendKeys(BaseConfig.getconfig("location"));
		
		pf.getSearchBtn().click();
		
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
		
		pf.getHomePrices().get(4).click();	//Index 4 gives 5th Property
		
		new Wait().getExplicitWait(driver, pf.getAgentPhoneNum());
		
//		if(pf.getLogo().isDisplayed()) {
//			System.out.println("Logo is available, See Screen Shot");
//		} else {
//			System.out.println("Logo is not avaialble");
//		}
		
		System.out.println("Agent Name is: "+pf.getAgentName().getText());
		System.out.println("Agent Phone # is: "+pf.getAgentPhoneNum().getText());
		TakeAppScreenShot.captureScreenShot(driver, "Agent Info with Logo");
		System.out.println("Logo is available, See Screen Shot");
		pf.getzooplaSignOut().click();
		
		//pf.getsignOut().click();

		TakeAppScreenShot.captureScreenShot(driver, "User has signed out");
		
		
		//driver.quit();
		return driver;
		
	}	


		
		
}

