Feature: Calculator
  In order to avoid silly mistakes As a math idiot I want to be told the sum of two numbers

  Background:
    Given I have navigated to the website

  Scenario: Add two numbers
    Given I have entered 70 into the calculator
    And I have also entered 50 into the calculator
    When I press add
    Then the result should be 120 on the screen

