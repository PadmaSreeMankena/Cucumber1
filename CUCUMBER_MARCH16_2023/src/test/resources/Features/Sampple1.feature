Feature: I am automation functionality of Add Nationality,Add Jobs in Orange HRM application
	
Background: Common step
    Given User launch chrome browser
    When User opens URL "https://opensource-demo.orangehrmlive.com/web/index.php/auth/login"

  Scenario: Creating Nationality Record
    And User enters username as "Admin" and password as "admin123"
    Then Go to Nationality Page
    When Add Nationality record as "Indian147" 
    When Click on logout button
    Then Close Browser
  
    Scenario: Creating Job Record
    And User entersss usernamed as "Admin" and password as "admin123"
    Then Go to Jobs Page
    When Create Job record as JobTitle "Sales51" JobDescr "Sales51 descr" JobNote "Sales51 Note" 
    When Click on logout button
    Then Close Browser  