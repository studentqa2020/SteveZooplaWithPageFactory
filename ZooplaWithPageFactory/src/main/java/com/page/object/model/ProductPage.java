package com.page.object.model;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductPage {

	public ProductPage(WebDriver driver) {
		PageFactory.initElements(driver, this);

	}
	
	@FindBy(xpath="//input[@id='search-input-location']")
	private WebElement searchBox;
	@FindBy(xpath = "//*[@value='Search']")
	private WebElement searchBtn;
	@FindBy(xpath = "//*[@class='listing-results-price text-price']")
	private List<WebElement> allHomePrices;
	@FindBy(xpath="//img[@class='js-lazy-loaded']")
	private WebElement logo;
	@FindBy(xpath="(//h4[@class='ui-agent__name'])[1]")
	private WebElement agentName;
	@FindBy(xpath="(//p[@class='ui-agent__tel ui-agent__text'])[1]")
	private WebElement agentPhoneNumber;
	@FindBy(xpath="//*[@id='header-account-panel__signed-in-link']")
	private WebElement zooplaSignOut;
	@FindBy(xpath="(//*[@class='notifications__item'])[5]")
	private WebElement signOut;
	
	//img[@alt='Parkmove'])[1] = Logo
	//*[@class='mnav__item']//span[contains(text(),'Sign out')] = Sign out
	
	public WebElement getsignOut() {
		return signOut;
		}
	
	public WebElement getzooplaSignOut() {
		return zooplaSignOut;
		}
	
	public WebElement getAgentPhoneNum() {
	return agentPhoneNumber;
	}
	
	public WebElement getLogo() {
		return logo;
	}
	

	public WebElement getAgentName() {
		return agentName;
	}
	
	public List<WebElement> getHomePrices() {
		return allHomePrices;
	}
	
	
	 public WebElement getSearchBtn() {
			return searchBtn;
		}
	 
	public WebElement getSearchBox() {
		return searchBox;
	}
	
	
}
