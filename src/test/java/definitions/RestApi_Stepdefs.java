package definitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import support.TestContext;
import java.util.List;
import java.util.Map;
import static io.restassured.RestAssured.given;
import static org.assertj.core.api.Assertions.assertThat;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;




public class RestApi_Stepdefs {

    Map<String, String> apiData = TestContext.getDataByFileName("apiData");

    private String baseUri = "http://ask-internship.portnov.com/api/v1";

    private String studentID = "6758";

    //private String activationCode = dbRequest();

    private String teacherAuthToken = signInTeacher();
    //private String studentAuthToken = signInStudent();

    private Integer newQuizId = createNewQuiz();
//    private Integer newAssignmentID = createNewAssignment();

    private String updatedQuizData = updateQuiz();
    private String updatedStudentRole = updateStudentRole();
    private String updatedStudentGroup = updateStudentGroup();
    private String updatedStudentName = updateStudentName();
    //private String sighUpStudentID = signUpStudent();
//
//
    @Given("I sign in as a teacher")
    public void iSignInAsATeacher() {
        signInTeacher();
    }


    private String signInTeacher() {
        ////        >>>>>>CAN ALSO DO THIS WAY, or can connect to a .yml file.
        //        //in any case, copy the string from the swagger documentation
        String requestBody_Teacher = "{\n" +
                "  \"email\": \"rekew35061@24rumen.com\",\n" +
                "  \"password\": \"abc123SDET\"\n" +
                "}";

        RequestSpecification request =
                given()
                        .baseUri(baseUri)
                        .header("Content-Type", "application/json")
                        .body(requestBody_Teacher)
                        .log().all();
        Response response = request
                .when()
                .post("/sign-in");

        Map<String, Object> map = response
                .then()
                .log().all()
                .statusCode(200)
                .extract()
                .jsonPath()
                .getMap("");

        String authToken_Teacher = (String) map.get("token");
        return authToken_Teacher;


    }


    @And("I get all the quizzes")
    public void iGetAllTheQuizzes() {
        getAllQuizzes();
    }

    private List<Map<String, Object>> getAllQuizzes() {
        RequestSpecification request =
                given()
                        .baseUri(baseUri)
                        .auth().oauth2(teacherAuthToken)
                        .header("Content-Type", "application/json")
                        .log()
                        .all();
        Response response = request
                .when()
                .get("/quizzes");

        List<Map<String, Object>> list = response
                .then()
                .log().all()
                .statusCode(200)
                .extract()
                .jsonPath()
                .getList("");

        return list;
    }


    @And("I create a new quiz")
    public void iCreateANewQuiz() {
        createNewQuiz();
    }


    private Integer createNewQuiz() {

        String requestBody_newQuiz = apiData.get("newQuiz");

        RequestSpecification request =
                given()
                        .baseUri(baseUri)
                        .auth().oauth2(teacherAuthToken)
                        .header("Content-Type", "application/json").body(requestBody_newQuiz)
                        .log().all();
        Response response = request
                .when()
                .post("/quiz");

        Map<String, Object> map = response
                .then()
                .log().all()
                .statusCode(200)
                .extract()
                .jsonPath()
                .getMap("");

        int quizID = (Integer) map.get("id");
        return quizID;
    }


    @When("I update the new quiz")
    public void iUpdateTheNewQuiz() {
        updateQuiz();
    }

    private String updateQuiz() {
        String requestBody_newQuiz = apiData.get("newQuiz_Updated");

        RequestSpecification request =
                given()
                        .baseUri(baseUri)
                        .auth().oauth2(teacherAuthToken)
                        .header("Content-Type", "application/json")
                        .body(requestBody_newQuiz)
                        .log().all();
        Response response = request
                .when()
                .post("/quiz");

        Map<String, Object> map = response
                .then()
                .log().all()
                .statusCode(200)
                .extract()
                .jsonPath()
                .getMap("");

        String newQuizName = (String) map.get("name");
        return newQuizName;
    }

    @When("I delete the new quiz")
    public void iDeleteTheNewQuiz() {
        deleteQuiz();
    }

    private void deleteQuiz() {

        RequestSpecification request =
                given()
                        .baseUri(baseUri)
                        .auth().oauth2(teacherAuthToken)
                        .header("Content-Type", "application/json")
                        .log().all();
        Response response = request
                .when()
                .delete("/quiz/" + newQuizId);

        response
                .then()
                .log().all()
                .statusCode(200);

    }

    @Then("I assert the new quiz was created")
    public void iAssertTheNewQuizWasCreated() {
        List<Map<String, Object>> list = getAllQuizzes();//list of all quizzes

        boolean isFound = false;

        for (Map<String, Object> quiz : list) {
            int quizID = (Integer) quiz.get("id");
            if (quizID == newQuizId) {
                isFound = true;
                break;
            }
        }
        //assertion
        assertThat(isFound).isTrue();

    }

    @Then("I assert the new quiz was deleted")
    public void iAssertTheNewQuizWasDeleted() {
        //Assert that new quiz Id is in not the list (deleted)

        List<Map<String, Object>> listAfterDelete = getAllQuizzes();

        boolean isFoundAfterDelete = false;

        for (Map<String, Object> quiz : listAfterDelete) {
            int quizID = (Integer) quiz.get("id");
            if (quizID == newQuizId) {
                isFoundAfterDelete = true;
                break;
            }
        }
        assertThat(isFoundAfterDelete).isFalse();

    }

    @Then("I assert the new quiz was updated")
    public void iAssertTheNewQuizWasUpdated() {
        // Assert that fields of updated position have updated successfully
        // (compare fieldsToUpdate fields with updatedPosition)
        assertThat(updatedQuizData).isNotEqualTo("eQuiz Automation");

    }

    @When("I get all users")
    public void iGetAllUsers() {
        getAllUsers();
    }

    private List<Map<String, Object>> getAllUsers() {
        RequestSpecification request =
                given()
                        .baseUri(baseUri)
                        .auth().oauth2(teacherAuthToken)
                        .header("Content-Type", "application/json")
                        .log()
                        .all();
        Response response = request
                .when()
                .get("/users");

        List<Map<String, Object>> list = response
                .then()
                .log().all()
                .statusCode(200)
                .extract()
                .jsonPath()
                .getList("");

        return list;
    }

    @And("I change a user's name")
    public void iChangeAUserSName() {
        updateStudentName();
    }

    private String updateStudentName() {
        String requestBody = apiData.get("newStudentName");

        RequestSpecification request =
                given()
                        .baseUri(baseUri)
                        .auth().oauth2(teacherAuthToken)
                        .header("Content-Type", "application/json")
                        .body(requestBody)
                        .log().all();
        Response response = request
                .when()
                .put("/users/change-name/" + studentID);

        Map<String, Object> map = response
                .then()
                .log().all()
                .statusCode(200)
                .extract()
                .jsonPath()
                .getMap("");

        String newUserName = (String) map.get("name");
        return newUserName;
    }

    @When("I change a user's group")
    public void iChangeAUserSGroup() {
        updateStudentGroup();
    }

    private String updateStudentGroup() {
        String requestBody_newGroup = apiData.get("newStudentGroup");

        RequestSpecification request =
                given()
                        .baseUri(baseUri)
                        .auth().oauth2(teacherAuthToken)
                        .header("Content-Type", "application/json")
                        .body(requestBody_newGroup)
                        .log().all();
        Response response = request
                .when()
                .put("/users/change-group/" + studentID);

        Map<String, Object> map = response
                .then()
                .log().all()
                .statusCode(200)
                .extract()
                .jsonPath()
                .getMap("");

        String newUserGroup = (String) map.get("group");
        return newUserGroup;
    }

    @When("I change a user's role")
    public void iChangeAUserSRole() {
        updateStudentRole();
    }

    private String updateStudentRole() {
        String requestBody_newGroup = apiData.get("newStudentRole");

        RequestSpecification request =
                given()
                        .baseUri(baseUri)
                        .auth().oauth2(teacherAuthToken)
                        .header("Content-Type", "application/json")
                        .body(requestBody_newGroup)
                        .log().all();
        Response response = request
                .when()
                .put("/users/change-role/" + studentID);

        Map<String, Object> map = response
                .then()
                .log().all()
                .statusCode(200)
                .extract()
                .jsonPath()
                .getMap("");

        String newUserRole = (String) map.get("role");
        return newUserRole;
    }




    @When("I get all assignments")
    public void iGetAllAssignments() {
        getAllAssignments();
    }
    private List<Map<String, Object>> getAllAssignments() {
        RequestSpecification request =
                given()
                        .baseUri(baseUri)
                        .auth().oauth2(teacherAuthToken)
                        .header("Content-Type", "application/json")
                        .log()
                        .all();
        Response response = request
                .when()
                .get("/assignments");

        List<Map<String, Object>> list = response
                .then()
                .log().all()
                .statusCode(200)
                .extract()
                .jsonPath()
                .getList("");

        return list;
    }

//    @And("I create a new assignment")
//    public void iCreateANewAssignment() {
//        createNewAssignment();
//    }
//
//    private Integer createNewAssignment() {
//
//        String requestBody_newQuiz = "{\n" +
//                "  \"quizId\": 12,\n" +
//                "  \"userIds\": \"[6758]\"\n" +
//                "}\n";
//
//        RequestSpecification request =
//                given()
//                        .baseUri(baseUri)
//                        .auth().oauth2(teacherAuthToken)
//                        .header("Content-Type", "application/json").body(requestBody_newQuiz)
//                        .log().all();
//        Response response = request
//                .when()
//                .post("/assignment");
//
//        Map<String, Object> map = response
//                .then()
//                .log().all()
//                .statusCode(200)
//                .extract()
//                .jsonPath()
//                .getMap("");
//
//        int assignmentID = (Integer) map.get("id");
//        return assignmentID;
//    }

//    @Then("I assert the assignment was created")
//    public void iAssertTheAssignmentWasCreated() {
//        List<Map<String, Object>> list = getAllAssignments();//list of all quizzes
//
//        boolean isFound = false;
//
//        for (Map<String, Object> assignment : list) {
//            int assignmentID = (Integer) assignment.get("id");
//            if (assignmentID == newAssignmentID) {
//                isFound = true;
//                break;
//            }
//        }
//        //assertion
//        assertThat(isFound).isTrue();
//
//    }


    @Given("I change my own name")
    public void iChangeMyOwnName() {
        updateOwnName();
    }
    private String updateOwnName() {
        String requestBody = apiData.get("newTeacherName");

        RequestSpecification request =
                given()
                        .baseUri(baseUri)
                        .auth().oauth2(teacherAuthToken)
                        .header("Content-Type", "application/json")
                        .body(requestBody)
                        .log().all();
        Response response = request
                .when()
                .post("/settings/change-name");

        Map<String, Object> map = response
                .then()
                .log().all()
                .statusCode(200)
                .extract()
                .jsonPath()
                .getMap("");

        String newTeacherName = (String) map.get("newName");
        return newTeacherName;
    }
}


