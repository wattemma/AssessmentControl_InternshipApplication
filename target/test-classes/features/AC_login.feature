# Automate test set "Log In"
# https://jira.portnov.com/browse/ACD-606
#  Author: Emma Watt

@login
Feature: Testing the login functionality

  Background:
    Given I go to "Assessment Control" page

  @login1
    Scenario Outline: The teacher can login with valid credentials
    Given I input the "<email>" into the Email text field
    And I input the "<password>" into the Password text field
    And I click the Sign In button
    Then I am signed in and redirected to the teacher home page
    Examples:
    |          email       |     password     |
    |rekew35061@24rumen.com|abc123SDET        |
    |REKEW35061@24RUMEN.com|abc123SDET        |

    @login2
    Scenario Outline: The teacher can not login with invalid credentials
      Given I input the <email> into the Email text field
      And I input the <password> into the Password text field
      And I click the Sign In button
      Then I am not signed in
      Examples:
        |          email             |    password         |
        |"rekew35061@24rumen.com"    |  "wrongPassword"    |
        |"wrongEmail@gmail.com"      |  "abc123SDET"       |
        |"rekew35061@24rumen.com"    |  "12345"            |
        |"annapcsteacher@gmail.com"  | "abc123SDET"        |
        |"  rekew35061@24rumen.com"  |  "  abc123SDET"     |
        |"rekew35061@24rumen.com  "  |  "abc123SDET  "     |
        |"rekew35061@24rumen.com"    |  "abc123sdet"       |
        |"rekew35061@24rumen.com"    |  "ABC123SDET"       |


  @login3
  Scenario: The user cannot log in if the email and password fields are left blank
    Given I click the Sign In button
    Then I am not signed in

  @login4
  Scenario: The user's password is displayed in bullets
    Given I input a valid teacher password into the Password text field
    Then the typed password is masked and appears in bullets

  @login5
  Scenario: The user cannot copy the password from the password text field
    Given I input a valid teacher password into the Password text field
    When I copy the password
    Then the clipboard is empty

  @login6
  Scenario: The user cannot cut the password from the password text field
    Given I input a valid teacher password into the Password text field
    When I cut the password
    Then the clipboard is empty


    #STUDENT:

  @login7
  Scenario Outline: The student can login with valid credentials
    Given I input the "<email>" into the Email text field
    And I input the "<password>" into the Password text field
    And I click the Sign In button
    Then I am signed in and redirected to the student home page
    Examples:
      |          email       |     password      |
      |witole4139@rubeshi.com|  GameOfThrones    |
      |WITOLE4139@RUBESHI.COM|  GameOfThrones    |

  @login8
  Scenario Outline: The student can not login with invalid credentials
    Given I input the <email> into the Email text field
    And I input the <password> into the Password text field
    And I click the Sign In button
    Then I am not signed in
    Examples:
      |          email             |    password         |
      |"witole4139@rubeshi.com"    |  "wrongPassword"    |
      |"wrongEmail@gmail.com"      |  "student123SDET"   |
      |"witole4139@rubeshi.com"    |  "12345Abc"         |
      |"student2@gmail.com"        | "student123SDET"    |
      |"  witole4139@rubeshi.com"  |  "  student123SDET" |
      |"witole4139@rubeshi.com  "  |  "student123SDET  " |
      |"witole4139@rubeshi.com"    |  "student123sdet"   |
      |"witole4139@rubeshi.com"    |  "STUDENT123SDET"   |
