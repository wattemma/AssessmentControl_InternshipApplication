# Test Automation Exercise - Cucumber
#  https://jira.portnov.com/browse/ACD-559
#  Author: Emma Watt
@quote
Feature: Smoke steps
  Background:
  Given I go to "quote" page
#    And I proceed to the page
    Then I should see the page title as "Get a Quote"

  @quote1 @smoke
  Scenario: Validate responsive UI behavior.
#    maximize:
    When I maximize the window
    Then the element with xpath "//b[@id='location']" should be displayed
    Then the element with xpath "//b[@id='location']" should contain text "Los Altos, CA 94022"
#    desctop size:
    When I resize the window to 1920 and 1080
    Then the element with xpath "//b[@id='location']" should be displayed
    Then the element with xpath "//b[@id='location']" should contain text "Los Altos, CA 94022"
    #    ipad size:
    When I resize the window to 820 and 1180
    Then the element with xpath "//b[@id='location']" should be displayed
    Then the element with xpath "//b[@id='location']" should contain text "Los Altos, CA 94022"
    #    iphone size:
    When I resize the window to 375 and 667
    Then the element with xpath "//b[@id='location']" should not be displayed
    Then the element with xpath "//b[@id='location']" should not contain text "Los Altos, CA 94022"

  @quote2
  Scenario: Validate minimal “Username” field length requirement as 2 characters
    When I input "a" into the "Username" field
    And I click the submit button
    Then I see an error message for the "username" field
    When I clear the "Username" field
    And I input "ab" into the "Username" field
    And I click the submit button
    Then I don't see an error message for the "username" field


  @quote3
  Scenario:Validate that email field accepts only valid email addresses.
    When I input "testgmailcom" into the "Email" field
    And I click the submit button
    Then I see an error message for the "email" field
    When I clear the "Email" field
    And I input "test@gmail.com" into the "Email" field
    And I click the submit button
    Then I don't see an error message for the "email" field


  @quote4
  Scenario: Fill out and validate “Password” set of fields
#Validate that the required length is 5 chars
    When I input "1234" into the "Password" field
    And I click the submit button
    Then I see the error message "Please enter at least 5 characters."
    # Confirm Password is disabled if Password field is empty.
    When I clear the "Password" field
    Then the confirm password field is disabled

#
  @quote5
  Scenario: Validate “Name” field behavior
    When I click on the name field
    Then the dialog box appears
    When I fill out the the dialog box fields and submit
    Then the values are displayed correctly in the name field


  @quote6
  Scenario: Validate Accepting Privacy Policy field behavior
    When I click the submit button
    Then I see an error message for the "agreedToPrivacyPolicy" field
    When I check the privacy policy checkbox
    Then I don't see an error message for the "agreedToPrivacyPolicy" field


  @quote7
  Scenario: Entering all non-required fields in order
    When I input "007007007" into the "Phone Number" field
    And I select "France" as the country or origin
    And I select "Female" gender
    And I check the Allowed to Contact checkbox
    And I input "qa ville" into the Address text area
    And I input "01/01/1111" into the "Date of Birth" field
    And I select the car make "BMW"
    And I accept the third party agreement
    And I click the related documents button
    Then I verify "Document 1" is in the list
    And I click the view documents link
    Then I verify "Document 1" is in our list


  @quote8
  Scenario: Submit the form and verify the data
#    Note: documents link must be clicked first, because of a bug,
  #    that clears the name and password fields if they were filled out before clicking the link
    When I click on the view documents link
    Then I see "Document 1" is in our list

    When I click on the name field
    And I fill out the the dialog box fields and submit

    And I input "ems" into the "Username" field
    And I input "12345" into the "Password" field
    And I input "12345" into the "Confirm Password" field
    And I input "esfalj@gmail.com" into the "Email" field

    When I input "007007007" into the "Phone Number" field
    And I select "France" as the country or origin
    And I select "Female" gender
    And I check the Allowed to Contact checkbox
    And I input "qa ville" into the Address text area
    And I input "01/01/1111" into the "Date of Birth" field
    And I select the car make "BMW"
    And I accept the third party agreement
    And I click the related documents button
    Then I verify "Document 1" is in the list
    When I check the privacy policy checkbox
    And I click the submit button

    Then field "First Name" should contain the value "fnTest"
    Then field "Middle Name" should contain the value "mnTest"
    Then field "Last Name" should contain the value "lnTest"
    Then the password is masked
    Then field "Email" should contain the value "esfalj@gmail.com"
    Then field "Username" should contain the value "ems"

  @quote9
  Scenario: Submit the form and verify the data OOP
      #iframe:
    When I fill out additional Contact person name and phone

  #    Note: documents link must be clicked first, because of a bug
  #    that clears the name and password fields if they were filled out before clicking the link
    When I click on the view documents link
    Then I see "Document 1" is in our list

    When I click on the name field OOP
    And I fill out the the dialog box fields
    And I fill out the Password fields

    And I fill out the "Username" field
    And I fill out the Email field
    And I fill out the Phone Number field
    And I select option "France" as the country of origin
    And I select the car make
    And I select option "female" gender

###    And I check Allowed to Contact checkbox
###    And I fill out the the Address text area
###    And I fill out the Date of Birth field
#
    #alert:
    And I check accept third party agreement
    And I click on the related documents button
    Then I see "Document 1" is in the list
    When I click the privacy policy checkbox
    And I submit the form

    Then I verify the submitted fields
    And I verify that the password is masked





#  @quote10
#  Scenario: practice with asserts
#    When I input an invalid username into the "Username" field
#    And I click the submit button
#    Then I see an error message for the username field
#    When I clear the Username field
#    And I input a valid username into the "Username" field
#    And I click the submit button
#    Then I don't see an error message for the username field