#Author: Amrut Raibagi
#Keywords Summary :
#Feature: Purchase Order the Order from Ecomerce Website
#Scenario: Purchase IPhone 14 pro from Product cart page

@Functional
#Feature is like the What action we are performing on which feature
Feature: Purchase Order from Ecomerce Website

	Background:
	Given User landed to login page

  @Functional
  #Scenario are like test cases one feature file can have as many as Scenario's
  #Scenario Outline is like DataProvider as we are passing in TestNG
  Scenario Outline: Title of your scenario outline
    Given Login to application with username <username> and pasword <password>
    When User add following products to cart:
    | IPHONE 13 PRO |
    | ZARA COAT 3   |
    And Checkout product <productname> and submit the order
    Then User verifies the success message "Order Placed Successfully" is displayed
    

    Examples: 
      |	 				username 		       | password			 |   productname 	|
      | amrutraibagi2018@gmail.com | Pappa@143   	 | IPHONE 13 PRO  |
      | amrutraibagi872@gmail.com  | Mummy@143   	 | ZARA COAT 3    |
