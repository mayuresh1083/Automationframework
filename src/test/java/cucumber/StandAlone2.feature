
@tag
Feature: Title of your feature
  I want to use this template for my feature file

  Background:
  Given I landed on Ecommerce Page
  
  @tag2
  Scenario Outline: Positive of Submitting the order
    Given Logged in with username <name> and password <password>
    When I add product <productName> to Cart
    And Checkout <productName> add submit the order
    Then "THANKYOU FOR THE ORDER." message is displayed on ConfirmationPage

    Examples: 
      | name               | password       | productName     |
      | mayuresh@gmail.com | Monster@12     | ADIDAS ORIGINAL |
      
