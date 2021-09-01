Feature: Create Article 

@test
Scenario: Successful create Article with data.
	Given user is already logged in in the Page
	When Click on New atricle button
	And User enters data on the fields
	And Click on Punlish Article button
  Then it should go the Article page detail
  When User enters comment and post
  And 	User delete the comment
  And 	close browser