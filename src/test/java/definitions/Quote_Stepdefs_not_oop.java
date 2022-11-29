package definitions;

import io.cucumber.java.en.*;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import java.util.Set;
import static org.assertj.core.api.Assertions.assertThat;
import static org.openqa.selenium.support.ui.ExpectedConditions.titleIs;
import static support.TestContext.getDriver;

public class Quote_Stepdefs_not_oop {
    private WebElement element;



    @And("I proceed to the page")
    public void iProceedToThePage() {
        WebElement advanceButton = getDriver().findElement(By.xpath("//button[contains(text(),'Advanced')]"));
        advanceButton.click();
        getDriver().findElement(By.xpath("//a[contains(text(),'Proceed to skryabin.com (unsafe)')]")).click();
    }


    @When("I maximize the window")
    public void iMaximizeTheWindow() {
        getDriver().manage().window().maximize();
    }

    @Then("I should see the page title as {string}")
    public void iShouldSeeThePageTitleAs(String pageTitle) {
        String title = getDriver().getTitle();
        assertThat(title).isEqualTo(pageTitle);
    }

    @When("I resize the window to {int} and {int}")
    public void iResizeTheWindowToAnd(int width, int height) {
        Dimension dimension = new Dimension(width,height);
        getDriver().manage().window().setSize(dimension);
    }

    @Then("the element with xpath {string} should be displayed")
    public void theElementWithXpathShouldBeDisplayed(String xpath) {
        element = getDriver().findElement(By.xpath(xpath));
        assertThat(element.isDisplayed()).isTrue();
    }

    @Then("the element with xpath {string} should contain text {string}")
    public void theElementWithXpathShouldContainText(String xpath, String text) {
        element = getDriver().findElement(By.xpath(xpath));
        assertThat(element.getText()).contains(text);
    }

    @Then("the element with xpath {string} should not be displayed")
    public void theElementWithXpathShouldNotBeDisplayed(String xpath) {
        element = getDriver().findElement(By.xpath(xpath));
        assertThat(element.isDisplayed()).isFalse();
    }

    @Then("the element with xpath {string} should not contain text {string}")
    public void theElementWithXpathShouldNotContainText(String xpath, String text) {
        element = getDriver().findElement(By.xpath(xpath));
        assertThat(element.getText().contains(text)).isFalse();
    }

    @When("I input {string} into the Username field")
    public void iInputIntoTheUsernameField(String username) {
        element = getDriver().findElement(By.xpath("//input[@name='username']"));
        element.sendKeys(username);
    }

    @And("I input {string} into the {string} field")
    public void iInputIntoTheField(String inputText, String fieldName) {
        element = getDriver().findElement(By.xpath("//label[contains(text(),'"+fieldName+"')]/following-sibling::input"));
        element.sendKeys(inputText);
    }

    @And("I click the submit button")
    public void iClickTheSubmitButton() {
        element = getDriver().findElement(By.xpath("//button[@id='formSubmit']"));
        element.click();
    }

    @Then("I see the error message {string}")
    public void iSeeTheErrorMessage(String errorText) {
        String elementText = getDriver().findElement(By.xpath("//*[contains(text(),'"+errorText+"')]")).getText();
        assertThat(elementText).isEqualTo(errorText);
    }

    @Then("I don't see the error message {string}")
    public void iDonTSeeTheErrorMessage(String errorText) {
        element = getDriver().findElement(By.xpath("//*[text()='"+errorText+"']"));
        assertThat(element.isDisplayed()).isFalse();
    }


    @Then("I don't see the error message")
    public void iDonTSeeTheErrorMessage() {
        element = getDriver().findElement(By.xpath("//*[@class='error'][text()='Please enter at least 5 characters.']"));
        assertThat(element.isDisplayed()).isFalse();
    }

    @When("I clear the {string} field")
    public void iClearTheField(String fieldName) {
        element = getDriver().findElement(By.xpath("//label[text()='"+fieldName+"']//following-sibling::input"));
        element.clear();
    }

    @Then("the confirm password field is disabled")
    public void theConfirmPasswordFieldIsDisabled() {
        element = getDriver().findElement(By.xpath("//input[@id='confirmPassword']"));
        assertThat(element.isEnabled()).isFalse();
    }

    @When("I click on the name field")
    public void iClickOnTheNameField() {
        WebElement nameField = getDriver().findElement(By.xpath("//*[@id='name']"));
        nameField.click();
    }

    @Then("the dialog box appears")
    public void theDialogBoxAppears() {
        WebElement firstName = getDriver().findElement(By.xpath("//*[@id='firstName']"));

        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOf(firstName));
        assertThat(firstName.isDisplayed()).isTrue();
    }

    @When("I fill out the the dialog box fields and submit")
    public void iFillOutTheTheDialogBoxFieldsAndSubmit() {
        WebElement firstName = getDriver().findElement(By.xpath("//*[@id='firstName']"));
        WebElement lastName = getDriver().findElement(By.xpath("//*[@id='lastName']"));
        WebElement middleName = getDriver().findElement(By.xpath("//*[@id='middleName']"));

        firstName.sendKeys("fnTest");
        lastName.sendKeys("lnTest");
        middleName.sendKeys("mnTest");
        getDriver().findElement(By.xpath("//*[@class='ui-dialog-buttonset']/button[position()=1]")).click();
    }

    @Then("the values are displayed correctly in the name field")
    public void theValuesAreDisplayedCorrectlyInTheNameField() {
        WebElement firstName = getDriver().findElement(By.xpath("//*[@id='firstName']"));
        WebElement lastName = getDriver().findElement(By.xpath("//*[@id='lastName']"));
        WebElement middleName = getDriver().findElement(By.xpath("//*[@id='middleName']"));


        WebElement nameField = getDriver().findElement(By.xpath("//*[@id='name']"));
        String nameFieldText = nameField.getText();
       assertThat(nameFieldText).contains(firstName.getText(),lastName.getText(),middleName.getText());
    }

    @When("I check the privacy policy checkbox")
    public void iCheckThePrivacyPolicyCheckbox() {
        getDriver().findElement(By.xpath("//input[@name='agreedToPrivacyPolicy']")).click();
    }

    @And("I select {string} as the country or origin")
    public void iSelectAsTheCountryOrOrigin(String country) {
        WebElement countryOptions = getDriver().findElement(By.xpath("//select[@name='countryOfOrigin']"));
        Select select = new Select(countryOptions);
        select.selectByVisibleText(country);
    }

    @And("I select {string} gender")
    public void iSelectGender(String gender) {
        getDriver().findElement(By.xpath("//span[text()='Female']/preceding-sibling::input")).click();
    }

    @And("I check the Allowed to Contact checkbox")
    public void iCheckTheAllowedToContactCheckbox() {
        getDriver().findElement(By.xpath("//input[@name='allowedToContact']")).click();
    }

    @And("I select the car make {string}")
    public void iSelectTheCarMake(String carMake) {
        WebElement carOptions = getDriver().findElement(By.xpath("//select[@name='carMake']"));
        Select select = new Select(carOptions);
        select.selectByVisibleText(carMake);
    }

    @And("I accept the third party agreement")
    public void iAcceptTheThirdPartyAgreement() {
        getDriver().findElement(By.xpath("//button[@id='thirdPartyButton']")).click();
        getDriver().switchTo().alert().accept();
    }

    @And("I fill out the contact person information field")
    public void iFillOutTheContactPersonInformationField() {
        getDriver().switchTo().frame("additionalInfo");
        getDriver().findElement(By.xpath("//input[@id='contactPersonName']")).sendKeys("contactName");
        getDriver().findElement(By.xpath("//input[@id='contactPersonPhone']")).sendKeys("007007007");
        getDriver().switchTo().defaultContent();
    }

    @And("I click the related documents button")
    public void iClickTheRelatedDocumentsButton() {
        getDriver().findElement(By.xpath("//*[@id='relatedDocuments']/../button")).click();
    }

    @Then("I verify {string} is in the list")
    public void iVerifyIsInTheList(String docName) {
        String originalHandle = getDriver().getWindowHandle();
        Set<String> handles = getDriver().getWindowHandles();
        for(String handle : handles){
            if (!handle.equals(originalHandle)) {
                getDriver().switchTo().window(handle);
                break;
            }
        }
        WebDriverWait wait = new WebDriverWait(getDriver(),Duration.ofSeconds(5));
        wait.until(titleIs("Documents Page"));

        WebElement document = getDriver().findElement(By.xpath("//*[contains(text(),'"+docName+"')]"));
        assertThat(document.isDisplayed()).isTrue();

        getDriver().close();
        getDriver().switchTo().window(originalHandle);

    }

    @And("I click the view documents link")
    public void iClickTheViewDocumentsLink() {
        getDriver().findElement(By.xpath("//*[@id='link']")).click();

    }

    @Then("I verify {string} is in our list")
    public void iVerifyIsInOurList(String docName) {

        WebDriverWait wait = new WebDriverWait(getDriver(),Duration.ofSeconds(5));
        wait.until(titleIs("Documents Page"));

        WebElement document = getDriver().findElement(By.xpath("//*[contains(text(),'"+docName+"')]"));
        assertThat(document.isDisplayed()).isTrue();

        getDriver().navigate().back();

    }


    @Then("field {string} should contain {string}")
    public void fieldShouldContain(String fieldName, String value) {
        String field = getDriver().findElement(By.xpath("//span[contains(text(),'"+fieldName+"')]"))
                .getText();
        assertThat(field).contains(value);
    }

    @Then("the password is masked")
    public void thePasswordIsMasked() {
        String passw = getDriver().findElement(By.xpath("//*[@name='password']")).getText();
        assertThat(passw).contains("[entered]");
    }



    @Then("I see an error message for the {string} field")
    public void iSeeAnErrorMessageForTheField(String idAttribute) {
        WebElement error = getDriver().findElement(By.xpath("//*[@id='"+idAttribute+"-error']"));
        assertThat(error.isDisplayed()).isTrue();

    }


    @Then("I don't see an error message for the {string} field")
    public void iDonTSeeAnErrorMessageForTheField(String idAttribute) {
        WebElement error = getDriver().findElement(By.xpath("//*[@id='"+idAttribute+"-error']"));
        assertThat(error.isDisplayed()).isFalse();
    }

    @And("I input {string} into the Address text area")
    public void iInputIntoTheAddressTextArea(String input) {
        getDriver().findElement(By.xpath("//*[@id='address']")).sendKeys(input);
    }

    @Then("field {string} should contain the value {string}")
    public void fieldShouldContainTheValue(String field, String value) {
        String elementText = getDriver().findElement(By.xpath("//span[contains(text(),'"+field+"')]/following-sibling::b")).getText();
        assertThat(elementText).contains(value);
    }
}
