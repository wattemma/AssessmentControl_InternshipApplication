package definitions;

import io.cucumber.java.en.Given;
import support.TestContext;
import java.util.Map;

import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import static io.restassured.RestAssured.given;
import static org.assertj.core.api.Assertions.assertThat;


public class StudentRestStepDefs_needDB {


    Map<String, String> apiData = TestContext.getDataByFileName("apiData");

    private String baseUri = "http://ask-internship.portnov.com/api/v1";




    @Given("I sigh up for a new student account")
    public void iSighUpForANewStudentAccount() {
        signUpStudent();
    }

    private void signUpStudent() {
//
        String requestBody = apiData.get("signUpStudentCredentials");

        RequestSpecification request =
                given()
                        .baseUri(baseUri)
                        .header("Content-Type", "application/json")
                        .body(requestBody)
                        .log().all();
        Response response = request
                .when()
                .post("/sign-up");

        response
                .then()
                .log().all()
                .statusCode(200);

    }



    //ISSUES WITH THIS STEP, IT'S JUST NOT EXECUTED
    /*
    @And("I do GET db request")
    public void iDoGETDbRequest() throws Exception {
        setUp();
        test();
        tearDown();
    }

    // Connection object
    static Connection con = null;
    // Statement object
    private static Statement stmt;
    // Constant for Database URL
    public static String DB_URL = "jdbc:mysql://44.198.158.182:3306/application";
    //Database Username
    public static String DB_USER = "testuser";
    // Database Password
    public static String DB_PASSWORD = "password";


    public void setUp() throws Exception {
        try {
// Database connection
            String dbClass = "com.mysql.cj.jdbc.Driver";
            Class.forName(dbClass).newInstance();
// Get connection to DB
            Connection con = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
// Statement object to send the SQL statement to the Database
            stmt = con.createStatement();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void test() {
        try {
            String query = "SELECT * FROM users WHERE email = 'jon.snow@gameofthronesssf.com'";
// Get the contents of userinfo table from DB
            ResultSet res = stmt.executeQuery(query);
// Print the result untill all the records are printed
// res.next() returns true if there is any next record else returns false
            while (res.next()) {
                System.out.print(res.getString(1));
                System.out.print(" " + res.getString(2));
                System.out.print(" " + res.getString(3));
                System.out.println(" " + res.getString(4));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void tearDown() throws Exception {
// Close DB connection
        if (con != null) {
            con.close();
        }
    }

    @And("I GET activate student")
    public void iGETActivateStudent() {
        activateStudent();
    }


    private String activateStudent() {
        RequestSpecification request =
                given()
                        .baseUri(baseUri)
                        .header("Content-Type", "application/json")
                        .log()
                        .all();
        Response response = request
                .when()
                .get("/activate/" + "6733/" + "91edcba480842bea3b122e1744cee38ee528e9c5");

        Map<String, Object> map = response
                .then()
                .log().all()
                .statusCode(200)
                .extract()
                .jsonPath()
                .getMap("");

        String studentAuthToken = (String) map.get("token");
        return studentAuthToken;
    }



    @And("I sign in as a student")
    public void iSignInAsAStudent() {
        signInStudent();
    }

    private void signInStudent() {

        String requestBody = apiData.get("studentCredentials");


        RequestSpecification request =
                given()
                        .baseUri(baseUri)
                        //.auth().oauth2(studentAuthToken)
                        .header("Content-Type", "application/json")
                        .body(requestBody)
                        .log().all();
        Response response = request
                .when()
                .post("/sign-in");

        response
                .then()
                .log().all()
                .statusCode(200);


    }

*/



}
