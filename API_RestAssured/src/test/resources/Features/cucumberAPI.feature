#Author: your.email@your.domain.com
#Keywords Summary :
#Feature: List of scenarios.
#Scenario: Business rule through list of steps with arguments.
#Given: Some precondition step
#When: Some key actions
#Then: To observe outcomes or validation
#And,But: To enumerate more Given,When,Then steps
#Scenario Outline: List of steps for data-driven as an Examples and <placeholder>
#Examples: Container for s table
#Background: List of steps run before each of the scenarios
#""" (Doc Strings)
#| (Data Tables)
#@ (Tags/Labels):To group Scenarios
#<> (placeholder)
#""
## (Comments)
#Sample Feature Definition Template
Feature: verify post, get, update and delete in API

 #Background: user is set to authorization
 #When user logging in with "username" and "password"

  Scenario: User will be able to create user, get all users, update and delete with the given URL
  
      #GetAllUsers
      # Given user is given base url  
      #When User make a GET request to get all users with endpoint
      #Then User get response with all the users with staus code
      
       
      #create an user1
       Given Admin create 1st user with base url
      When user make a post request with end point "/createusers"    
      Then user should get response body and status code 
      
         
      #getuserbyuserId
       Given user is given base url
      When user make a get request using ID with end point 
      Then user should get status code and responsebody 
        
      #getuserbyuserFirstName
       Given user is given base url
      When user make a get request using FirstName with end point 
      Then user should get status code and response
      
     #@updateuserbyuserId
   Given user is given base url
    When User make a PUT request to update program by using userId(update 1st user) with endpoint 
    Then User should get status code and updated response body
    
   
     #@DeleteuserbyuserFirstname
      Given user is given base url
       When User make a DELETE request using FirstName with end point  
      Then User gets status code and user will be deleted
   
     #@DeleteuserbyuserId
    Given user is given base url
       When User make a DELETE request using ID with end point 
      Then User gets status code with message
   
 