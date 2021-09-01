Feature: Do favorite the Article 

@test
Scenario: Successful favorite the article.
 
	Given User Launch The browser and login
	When Click on tags from right side in the home page
	And Click on Favorite icon from a article
  And  The number should increase
  And close browser 