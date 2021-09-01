#Author: r.janikeh@gmail.com

Feature: SingUp
@test
  Scenario Outline:: Successful Sign up with Valid Data 
    Given User Launch The browser 
    When User opens URL
    And Click on Sign up
    And user enters Username  as <username> Email as <email>  and Password as  <password> 
    And Click on Sign up button.
    Then it should go the home page
    And close browser