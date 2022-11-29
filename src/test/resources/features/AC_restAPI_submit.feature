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