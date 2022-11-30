@restAPI
Feature: REST API CRUD
  #http://ask-internship.portnov.com/api-doc/#/
  #base url: http://ask-internship.portnov.com/api/v1


  @rest1
  Scenario: Quiz API (Teachers only) , REST API CRUD
    Given I sign in as a teacher
    And I get all the quizzes
    And I create a new quiz
    Then I assert the new quiz was created
    When I update the new quiz
    Then I assert the new quiz was updated
    When I delete the new quiz
    Then I assert the new quiz was deleted

  @rest2
      #Authorization API
  Scenario: Authorization API , REST API CRUD
#    Given I sigh up for a new student account
    #connecting to the DB
#    Then I get the activation token from the db for user "email"
#    And I activate the user account with token

    #And I GET activate student
#    And I sign in as a student

## other:
#    When I submit request to reset my password
#    And I reset my password
#    Then I confirm my password is reset



  @rest3
#      User API (Teachers only)
  Scenario: User API (Teachers only) , REST API CRUD
    Given I sign in as a teacher
    When I get all users
    And I change a user's name
#    Then I assert the name was changed
    When I change a user's group
#    Then I assert the group was changed
    When I change a user's role
#    Then I assert the role was changed
#    When I delete a user
#    Then I assert the user was deleted

#  @rest4
#      #Settings API
#  Scenario: Settings API , REST API CRUD
#    Given I change my own name
#    Then I assert the name was changed
#    When I change my own password
#    Then I assert the password was changed


#  @rest5
#      #Assignment API (Teachers only)
#  Scenario: Assignment API (Teachers only) , REST API CRUD
#    Given I sign in as a teacher
#    When I get all assignments
#    #create quiz
#    ##smth wrong with format of create an assignment
#    And  I create a new assignment
#    Then I assert the assignment was created
#    ##sign in as student
    ##submit assignment
#    When I grade the assignment
#    Then I assert the assignment was graded
#    When I delete the assignment
#    Then I assert the assignment was deleted

#  @rest6
#      #Student API (Students only)
#  Scenario: Student API (Students only) , REST API CRUD
#    Given I sign in as a student
#    When I get all my assignments
#    When I submit my assignment
#    Then I assert the name was submitted
#    When I get all my grades

#  @rest7
#  Scenario: clean up
#    Given I delete the student account