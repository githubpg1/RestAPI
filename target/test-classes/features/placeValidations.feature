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
Feature: Validating Place API's

@Regression
Scenario Outline: Verify if place is successfully getting added using AddPlaceAPI
	Given Add place payload "<name>" "<language>" "<address>"
	When user calls "AddPlaceAPI" with "POST" https request
	Then the API called is success with status code 200
	And "status" in Response Body is "OK"
	And "scope" in Response Body is "APP"
	And verify if place_Id created, maps to "<name>" using "GetPlaceAPI"
	
Examples:
		|name     | language |address 		|
		|Prer21ana  | English	 |MOD MOD       |
		|Neer22ja	  | Hindui   |Omaxe         |
		
@DeletePlace
Scenario: Verify if the DeletePlace functionlity is working fine

	Given DeletePlace Payload
	When user calls "DeletePlaceAPI" with "POST" https request
	Then the API called is success with status code 200
	And "status" in Response Body is "OK"