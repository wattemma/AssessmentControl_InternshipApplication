package definitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.Quote.DocumentsPage;
import pages.Quote.Quote_HomePage;
import pages.Quote.Quote_SubmittedPage;
import support.TestContext;

import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

public class QuoteOOP_Stepdefs {

    Quote_HomePage quote_homePage = new Quote_HomePage();
    DocumentsPage documentsPage = new DocumentsPage();
    Quote_SubmittedPage quote_submittedPage = new Quote_SubmittedPage();

    Map<String, String> quoteData = TestContext.getDataByFileName("quoteData");

    @Then("I should see my page title as {string}")
    public void iShouldSeeMyPageTitleAs(String title) {
        assertThat(quote_homePage.getTitle()).contains(title);
    }

    @When("I click on the name field OOP")
    public void iClickOnTheNameFieldOOP() {
        quote_homePage.clickNameField();
    }

    @And("I fill out the the dialog box fields")
    public void iFillOutTheTheDialogBoxFields() {

        quote_homePage.setNameFields(quoteData.get("fName"),quoteData.get("mName"),quoteData.get("lName"));
        quote_homePage.hitSave();
    }

    @And("I fill out the {string} field")
    public void iFillOutTheField(String fieldName) {
        quote_homePage.fillOutField(fieldName,quoteData.get("username"));
    }

    @And("I fill out the Password fields")
    public void iFillOutThePasswordFields() {
        quote_homePage.setPassw(quoteData.get("password"));
    }

    @And("I fill out the Email field")
    public void iFillOutTheEmailField() {
        quote_homePage.setEmail(quoteData.get("email"));
    }

    @And("I fill out the Phone Number field")
    public void iFillOutThePhoneNumberField() {
        quote_homePage.setPhone(quoteData.get("phoneNumber"));
    }

    @And("I select option {string} as the country of origin")
    public void iSelectOptionAsTheCountryOfOrigin(String country) {
        quote_homePage.setCountry(country);
    }


    @And("I select the car make")
    public void iSelectTheCarMake() {
        quote_homePage.setCarMake(quoteData.get("carMake"));

    }

    @And("I select option {string} gender")
    public void iSelectOptionGender(String gender) {
        quote_homePage.setGender(gender);
    }


    @And("I check accept third party agreement")
    public void iCheckAcceptThirdPartyAgreement() {
        quote_homePage.acceptThirdParty();

    }

    @And("I click on the related documents button")
    public void iClickOnTheRelatedDocumentsButton() {
        quote_homePage.seeRelatedDocs();
    }

    @Then("I see {string} is in the list")
    public void iSeeIsInTheList(String docName) {
        documentsPage.switchWindowAndSeeDoc(docName);
    }

    @And("I click on the view documents link")
    public void iClickOnTheViewDocumentsLink() {
        quote_homePage.seeDocsLink();
    }

    @Then("I see {string} is in our list")
    public void iSeeIsInOurList(String docName) {
        documentsPage.seeDoc(docName);
        documentsPage.back();
    }

    @When("I click the privacy policy checkbox")
    public void iClickThePrivacyPolicyCheckbox() {
    quote_homePage.setPrivacyPolicy();
    }

    @When("I fill out additional Contact person name and phone")
    public void iFillOutAdditionalContactPersonNameAndPhone() {
        quote_homePage.setContactName(quoteData.get("nContact"), quoteData.get("pContact"));
    }

    @And("I submit the form")
    public void iSubmitTheForm() {
    quote_homePage.submit();
    }

    @Then("I verify the submitted fields")
    public void iVerifyTheSubmittedFields() {
        assertThat(quote_submittedPage.getResults() ).contains(
                quoteData.get("fName"),
                quoteData.get("lName"),
                quoteData.get("mName"));
        //etc
    }

    @And("I verify that the password is masked")
    public void iVerifyThatThePasswordIsMasked() {
        assertThat(quote_submittedPage.getResults()).doesNotContain(quoteData.get("password"));
    }



}
