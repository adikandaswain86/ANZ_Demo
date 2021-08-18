

Feature: Demo Smoke test execution
    
     
  @SmokeTestSuite1
    Scenario Outline: User sign up on Sephora.com 
    
    When User hovers and clicks on create account link
    And User enters first name "<First Name>",last name"<Last Name>",emailid"<emailid>",password"<password>",month "<month>" and day "<day>"
    And User clicks on join now
    Then sign up should be successful
		
 
    Examples:
    
    | First Name|Last Name |emailid|password|month|day|
    | Adikanda |Swain|adi.swain@yopmail.com|Adikant.99|August|10|
    
@SmokeTestSuite1
    Scenario Outline: User login and checking out a product  
    
    Given User logs in using valid username and password
    And login is successfull with the username "<First Name>"
    When user selects and adds product to cart and checksout
    And User lands on my basket page
    Then validate selected product is available in my basket
    
 
    Examples:
    
    |First Name|
    |Adikanda|
    
    
    
    
  