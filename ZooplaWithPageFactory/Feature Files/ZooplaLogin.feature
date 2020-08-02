Feature: Zoopla login and search feature 
	Description : Go to Zoopla site, Login with Valid Credentials, Search for homes in New York Lincolshire, sort prices, and select 5th Property.
	
Scenario: As a Zoopla user , I can login successfully with valid user name and password, perform search, and sort properties 
	Given open a browser 
	And Put URL 
	When Accept Cookies
	When Click Signin 
	And put valid user name 
	And put valid password 
	And click sign in button
	And search for properties in New York, Linconshire
	And Sort the properties by Descending Order
	And select the 5th Property  
	Then Validate login was success(sign out btn) 

#1) Go to this url - https://www.zoopla.co.uk/
#2) Click on Login Button, enter valid credential & Submit login button. 
#3) You will get a home page; on that page verify website title. 
#4) Enter location (New York, Lincolnshire) & Search it
#4) Print all the price values in sorted order (descending order) on the console
#5) I need to select the fifth property on that list (it is changing every minute, so it is dynamic) 
#6) On the next page, Verify there is a logo, name and telephone no of the agent & logout