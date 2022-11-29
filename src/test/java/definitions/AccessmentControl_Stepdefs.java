package definitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.When;
import pages.*;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import support.TestContext;

import java.awt.datatransfer.UnsupportedFlavorException;
import java.io.IOException;
import java.util.Map;
import static org.assertj.core.api.Assertions.assertThat;




public class AccessmentControl_Stepdefs {

    LoginPage loginPage = new LoginPage();
    HomePage_Teacher homeTeacherPage = new HomePage_Teacher();
    HomePage_Student homeStudentPage = new HomePage_Student();
    RegistrationPage registrationPage = new RegistrationPage();


    Map<String, String> studentData = TestContext
            .getDataByFileName("student");

    Map<String, String> teacherData = TestContext
            .getDataByFileName("teacher");


    @Given("I input the {string} into the Email text field")
    public void iInputTheIntoTheEmailTextField(String email) {
        loginPage.setEmail(email);
    }


    @Given("I click the Sign In button")
    public void iClickTheSignInButton() {
        loginPage.signIn();

    }

    @Given("I input a valid teacher password into the Password text field")
    public void iInputAValidTeacherPasswordIntoThePasswordTextField() {
        loginPage.setPassword(teacherData.get("password"));
    }

    @And("I input the {string} into the Password text field")
    public void iInputTheIntoThePasswordTextField(String password) {
        loginPage.setPassword(password);
    }


    @Then("I am not signed in")
    public void iAmNotSignedIn() {
        assertThat(loginPage.checkURL()).isTrue();
    }

    @Then("I am signed in and redirected to the teacher home page")
    public void iAmSignedInAndRedirectedToTheTeacherHomePage() {
        assertThat(homeTeacherPage.getTeacherHeader().isDisplayed()).isTrue();
    }

    @Then("I am signed in and redirected to the student home page")
    public void iAmSignedInAndRedirectedToTheStudentHomePage() {
        assertThat(homeStudentPage.getStudentHeader().isDisplayed()).isTrue();

    }

    @When("I copy the password")
    public void iCopyThePassword() {
        loginPage.copyPassword();
    }

    @When("I cut the password")
    public void iCutThePassword() {
        loginPage.cutPassword();
    }

    @Then("the clipboard is empty")
    public void theClipboardIsEmpty() throws IOException, UnsupportedFlavorException {
        assertThat(loginPage.checkClipboard()).isFalse();
    }

    @Then("the typed password is masked and appears in bullets")
    public void theTypedPasswordIsMaskedAndAppearsInBullets() {
        assertThat(loginPage.getPasswordField().getAttribute("type")).isEqualTo("password");
    }


    @Given("I click the {string} button")
    public void iClickTheButton(String buttonName) {
        loginPage.clickRegister(buttonName);
    }

    @When("I input a valid data into the required fields")
    public void iInputAValidDataIntoTheRequiredFields() {
        registrationPage.setFirstName(studentData.get("firstName"));
        registrationPage.setLastName(studentData.get("lastName"));
        registrationPage.setEmail(studentData.get("email"));
        registrationPage.setGroupCode(studentData.get("groupCode"));
        registrationPage.setPassword(studentData.get("password"));
    }

    @And("I click the Register Me button")
    public void iClickTheRegisterMeButton() {
        registrationPage.clickRegister();
    }

    @And("I click the Back to Log In Page button")
    public void iClickTheBackToLogInPageButton() {
    }

    @When("back on the login page, I input the valid email used for registration")
    public void backOnTheLoginPageIInputTheValidEmailUsedForRegistration() {
        loginPage.setEmail(studentData.get("email"));
    }

    @And("I input the valid password used for registration")
    public void iInputTheValidPasswordUsedForRegistration() {
        loginPage.setPassword(studentData.get("password"));
    }


    @When("I validate my email")
    public void iValidateMyEmail() {
    }


}







