package com.generic.code;

import java.util.logging.Level;
import java.util.logging.Logger;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import com.config.BaseConfig;
import com.page.object.model.LoginPage;
import com.util.Highlighter;
import com.util.TakeAppScreenShot;
import com.util.Wait;

public class BaseLogin {

	protected static WebDriver driver;
	
	public static WebDriver getLogin() throws Throwable {
		
		System.setProperty("webdriver.chrome.driver", "./Driver/chromedriver.exe");
		System.setProperty(ChromeDriverService.CHROME_DRIVER_SILENT_OUTPUT_PROPERTY, "true");
		Logger.getLogger("org.openqa.selenium").setLevel(Level.OFF);
		
		driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		
		driver.get(BaseConfig.getconfig("URL"));
		
		LoginPage login =new LoginPage(driver);
		
		System.out.println(driver.getTitle());
		new Highlighter().getcolor(driver, login.getLogin());
		//TakeAppScreenShot.captureScreenShot(driver, "Cookies page");
		
		login.getCookies().click();
		
		login.getLogin().click();
		System.out.println(driver.getCurrentUrl());
		System.out.println(driver.getTitle());

		Wait.getExplicitWaitClickable(driver, login.getEmail());
		new Highlighter().getcolor(driver, login.getEmail(), "green");
		login.getEmail().sendKeys(BaseConfig.getconfig("email"));
		//TakeAppScreenShot.captureScreenShot(driver, "Email success");
		
		
		new Highlighter().getcolor(driver, login.getPass(),"blue");
		login.getPass().sendKeys(BaseConfig.getconfig("pass"));
		//TakeAppScreenShot.captureScreenShot(driver, "Password success");
		Thread.sleep(3000);

		login.getSubmit().click();
		TakeAppScreenShot.captureScreenShot(driver, "Login success");
		System.out.println(driver.getTitle());
		
		return driver;
		//driver.quit();
		
	}

}
