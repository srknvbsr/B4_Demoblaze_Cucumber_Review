Feature: The user should be able to place order from the website


  @wip
  Scenario: Placing a succesful order
    Given The user is on the login page
    When The user logs in using "maho@hotmail.com" and "Maho123456789"
    And The user adds "Samsung galaxy s6" from "Phones"
    And The user adds "Sony vaio i5" from "Laptops"
    And The user adds "MacBook Pro" from "Laptops"
    And The user adds "Apple monitor 24" from "Monitors"
    And The user removes "Sony vaio i5" from cart
   And The user places order and captures and log amounts
    Then The user verifies purchase amount