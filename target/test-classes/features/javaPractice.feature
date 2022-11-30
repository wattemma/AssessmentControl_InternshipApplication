#Java Coding Practice
#https://jira.portnov.com/browse/ACD-596
#  Author: Emma Watt

Feature: Java coding practice
#Write the code that prints out the result of converting
#Expected result: 1 foot equals  30.48  centimeters
  #(Formula C to F: (0°C × 9/5) + 32 = 32°F)
Scenario: Converter
Given I convert 1 foot to centimeters
And I convert 1 US gallon to liters
And I convert 0 Celsius to Fahrenheit

#2. Use if/else statements in the following step:
#Expected Output: Number 12 is even / Number 11 is odd
And I check if number 12 is odd or even

  #3
  Scenario: test grade
Given I got 89 percent on my test

#4.
Scenario: Calculating cost of fruit
Given I find the cost of 4 pounds of "cherries"

  #5	Use a for loop to print out all elements in the array:
#String[] week = {“Monday”, “Tuesday”, “Wednesday”,
#“Thursday”, “Friday”, “Saturday”, “Sunday”};
  Scenario: days of the week for loop
Given I print out all elements in the array
