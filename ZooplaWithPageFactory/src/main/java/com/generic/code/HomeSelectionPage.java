package com.generic.code;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.config.BaseConfig;
import com.page.object.model.ProductPage;
import com.util.TakeAppScreenShot;

public class HomeSelectionPage extends BaseLogin {

	public static void main(String[] args) throws Throwable {


		getLogin();

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

			Collections.reverse(AllPrices);
			System.out.println("House Prices Sorted Desc: "+AllPrices);
			
			pf.getHomePrices().get(4).click();	//Index 4 gives 5th Property	
					
				
			if(pf.getLogo().isDisplayed()) {
				System.out.println("Logo is available, See Screen Shot");
			} else {
				System.out.println("Logo is not avaialble");
			}
			
			System.out.println("Agent Name is: "+pf.getAgentName().getText());
			System.out.println("Agent Phone#: "+pf.getAgentPhoneNum().getText());
			TakeAppScreenShot.captureScreenShot(driver, "Agent Info with Logo");
				
			driver.quit();	

	}

}
