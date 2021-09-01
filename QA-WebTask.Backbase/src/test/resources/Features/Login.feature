Feature: Login 

@test
Scenario Outline: Login Data Driven 
	Given User Launch Chrome browser 
	When User opens URL 
	And User enters Email as <email> and Password as <password>
	And Click on Login 
	Then it should go the home page
	And close browser 
	
	Examples: 
		| email | password |
		|r.janikeh1@mailinator.com|	123456 |