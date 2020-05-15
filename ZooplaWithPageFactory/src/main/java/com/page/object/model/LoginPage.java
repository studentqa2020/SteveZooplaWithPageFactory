package com.page.object.model;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

	public LoginPage(WebDriver driver) {

		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//*[@class='ui-button-primary ui-cookie-accept-all-medium-large']")
	private WebElement cookies;
	@FindBy(xpath = "//*[@class= 'button button--tertiary-dark account-link__text']")
	private WebElement login;
	@FindBy(xpath = "//*[@id='signin_email']")
	private WebElement email;
	@FindBy(xpath = "//*[@id='signin_password']")
	private WebElement pass;
	@FindBy(xpath = "//*[@id='signin_submit']")
	private WebElement submit;

	
	public WebElement getCookies() {
		return cookies;
	}
	
	public WebElement getLogin() {
		return login;
	}

	public WebElement getEmail() {
		return email;
	}

	public WebElement getPass() {
		return pass;
	}

	public WebElement getSubmit() {
		return submit;
	}

	

}
