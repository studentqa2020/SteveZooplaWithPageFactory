package com.runner;

import org.testng.annotations.BeforeTest;

import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;

	@CucumberOptions(plugin = { "pretty", 
			"html:target/site/cucumber-pretty", 
			"rerun:target/rerun.txt",
			"json:target/cucumber.json"},

features = {"Feature Files/ZooplaLogin.feature"},
glue = { "com.stepdef" },
monochrome = true,
dryRun =false,
strict = true

)

	public class zooplaRunner extends AbstractTestNGCucumberTests {

@BeforeTest(alwaysRun = true)
public void setupExtentsReport() throws Exception {


}

}
	

