Feature: follow other users

@test
Scenario: Successful follow other users.
 
	Given user is already logged in in the Page
	When Click on tags from right side in the home page
	And  Click on name of the users from the article
	And  Click on Fllow User button in user s detail page
  Then The text of button should chnage to unfollow user
  And close browser 