Feature: I am automation functionality of Add Nationality in Orange HRM application
	
Background: Common step
    Given User launch chrome browser
    When User opens URL "https://opensource-demo.orangehrmlive.com/web/index.php/auth/login"

  Scenario: Successful Login with valid page
    And User enters username as "Admin" and password as "admin123"
    Then Create Nationality Record
					|Indian143|
					|Indian144|
					|Indian145|
    When Click on logout button
    Then Close Browser
    
    
    

    