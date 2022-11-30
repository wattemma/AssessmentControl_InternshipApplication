package definitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import support.DB_ConnectionHelper;
import support.TestContext;

import java.sql.*;
import java.util.Map;

import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import static io.restassured.RestAssured.given;
import static org.assertj.core.api.Assertions.assertThat;


public class StudentRestStepDefs_needDB {


    Map<String, String> apiData = TestContext.getDataByFileName("apiData");

    private String baseUri = "http://ask-internship.portnov.com/api/v1";




//    @Given("I sigh up for a new student account")
//    public void iSighUpForANewStudentAccount() {
//        signUpStudent();
//    }
//
//    private void signUpStudent() {
////
//        String requestBody = apiData.get("signUpStudentCredentials");
//
//        RequestSpecification request =
//                given()
//                        .baseUri(baseUri)
//                        .header("Content-Type", "application/json")
//                        .body(requestBody)
//                        .log().all();
//        Response response = request
//                .when()
//                .post("/sign-up");
//
//        response
//                .then()
//                .log().all()
//                .statusCode(200);
//
//    }



}
