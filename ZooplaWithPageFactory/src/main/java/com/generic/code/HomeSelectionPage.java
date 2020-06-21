package com.generic.code;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.openqa.selenium.interactions.Actions;
import com.config.BaseConfig;
import com.page.object.model.ProductPage;
import com.util.TakeAppScreenShot;
import com.util.Wait;

public class HomeSelectionPage extends BaseLogin {

	public static void main(String[] args) throws Throwable {
	
		HomeSelectionPage.homePage();
	}
	public static void homePage() throws Throwable {

		
		//getLogin();

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
			
			new Wait().getExplicitWait(driver, pf.getAgentName());
			
			if(pf.getLogo().isDisplayed()) {
				System.out.println("Logo is available, See Screen Shot");
			} else {
				System.out.println("Logo is not avaialble");
			}
			
			System.out.println("Agent Name is: "+pf.getAgentName().getText());
			System.out.println("Agent Phone # is: "+pf.getAgentPhoneNum().getText());
			TakeAppScreenShot.captureScreenShot(driver, "Agent Info with Logo");
			
			Actions signOut = new Actions(driver);
			signOut.moveToElement(pf.getzooplaSignOut()).build().perform();
			signOut.moveToElement(pf.getzooplaSignOut()).build().perform();
			TakeAppScreenShot.captureScreenShot(driver, "User has signed out");
			pf.getsignOut().click();
			
			driver.quit();	

	}

}
