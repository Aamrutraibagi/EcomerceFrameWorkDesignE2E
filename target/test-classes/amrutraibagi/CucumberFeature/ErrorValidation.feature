#Author: Amrut Raibagi
#Keywords Summary :
#Feature: Purchase Order the Order from Ecomerce Website
#Scenario: Purchase IPhone 14 pro from Product cart page

@ErrorValidation
#Feature is like the What action we are performing on which feature
Feature: Validate Login Page

	Background:
	Given User landed to login page

  @ErrorValidation
  #Scenario are like test cases one feature file can have as many as Scenario's
  #Scenario Outline is like DataProvider as we are passing in TestNG
  Scenario Outline: User validate Error message on putting incorrect username and password
    Given Login to application with username <username> and pasword <password>
    Then User verifies the Error message "Incorrect email or password." is displayed 
    

    Examples: 
      |	 				username 		       | password			 |   productname 	|
      | amrutraibagi2018@gmail.c | Pappa@143   	 | IPHONE 13 PRO  |
