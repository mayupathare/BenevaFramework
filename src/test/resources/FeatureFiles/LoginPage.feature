Feature: Login Page feature
  I want to use this template for my feature file
@LoginScenrio
  Scenario: Title of your scenario
    Given User is on Login Page
    When User enters username  "student"
    And User enters password  "Password123"
    And User click on SignIn Button
    Then User should get title of Page
@LogoutScenrio
  Scenario: Login into Application successfully
   	Given User is on Login Page
    When User enters username  "student"
    And User enters password  "Password123"
    And User click on SignIn Button
    Then User should be able to Login Successfully
    Then User click on Logout Button
