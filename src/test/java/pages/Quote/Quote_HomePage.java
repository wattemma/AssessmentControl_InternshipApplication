package pages.Quote;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import pages.GenericPage;

import static support.TestContext.getDriver;

public class Quote_HomePage extends GenericPage {


    public Quote_HomePage() {
        PageFactory.initElements(getDriver(), this);
        url = "https://skryabin.com/market/quote.html";
    }

    @FindBy(xpath = "//input[@id='name']")
    private WebElement nameField;

    @FindBy(xpath = "//*[@id='firstName']")
    private WebElement firstName;

    @FindBy(xpath = "//*[@id='middleName']")
    private WebElement middleName;

    @FindBy(xpath = "//*[@id='lastName']")
    private WebElement lastName;

    @FindBy(xpath = "//*[@class='ui-dialog-buttonset']//button[position()=1]")
    private WebElement saveButton;

    private WebElement usernameField(String fieldLabel) {
        return getDriver().findElement(By.xpath("//label[contains(text(),'" + fieldLabel + "')]/following-sibling::input"));
    }

    @FindBy(xpath = "//input[@id='password']")
    private WebElement passwordField;

    @FindBy(xpath = "//input[@id='confirmPassword']")
    private WebElement confirmPassw;

    @FindBy(xpath = "//input[@type='email']")
    private WebElement email;

    @FindBy(xpath = "//input[@name='phone']")
    private WebElement phone;

    @FindBy(xpath = "//select[@name='countryOfOrigin']")
    private WebElement countryField;


    @FindBy(xpath = "//*[@name='carMake']")
    private WebElement mySelection;

    private WebElement gender(String myGender) {
        return getDriver().findElement(By.xpath("//input[@type='radio'][@value='" + myGender + "']"));
    }

    @FindBy(xpath = "//button[@id='thirdPartyButton']")
    private WebElement thirdPartyButton;

    @FindBy(xpath = "//button[contains(text(),'Related documents')]")
    private WebElement relatedDocsButton;

    @FindBy(xpath = "//a[@id='link']")
    private WebElement viewDocsLink;

    @FindBy(xpath = "//*[@name='agreedToPrivacyPolicy']")
    private WebElement privacyPolicy;

    @FindBy(xpath = "//*[@id='contactPersonName']")
    private WebElement contactName;

    @FindBy(xpath = "//*[@id='contactPersonPhone']")
    private WebElement contactPhone;

    @FindBy(xpath = "//*[@id='formSubmit']")
    private WebElement formSubmit;

    public void submit(){
        formSubmit.click();
    }

    public void setContactName(String nContact, String pContact){
        getDriver().switchTo().frame("additionalInfo");
        contactName.sendKeys(nContact);
        contactPhone.sendKeys(pContact);
        getDriver().switchTo().defaultContent();
    }


    public void setPrivacyPolicy(){
        privacyPolicy.click();
    }


    public void seeDocsLink(){
        viewDocsLink.click();
    }

    public void seeRelatedDocs(){
        relatedDocsButton.click();
    }

    public void acceptThirdParty(){
        thirdPartyButton.click();
        getDriver().switchTo().alert().accept();
    }

    public void clickNameField() {
        nameField.click();
    }

    public void setNameFields(String fName, String mName, String lName) {
        waitUntilVisible(firstName);
        firstName.sendKeys(fName);
        middleName.sendKeys(mName);
        lastName.sendKeys(lName);
    }

    public void hitSave() {
        saveButton.click();
        waitUntilInVisible(saveButton);
    }

    public void fillOutField(String fieldName, String input) {
        usernameField(fieldName).sendKeys(input);
    }

    public void setPassw(String passw) {
        passwordField.sendKeys(passw);
        confirmPassw.sendKeys(passw);
    }

    public void setEmail(String myEmail) {
        email.sendKeys(myEmail);
    }

    public void setPhone(String phoneNum) {
        phone.sendKeys(phoneNum);
    }




    public void setCarMake(String desiredCarMake) {
        Select select = new Select(mySelection);
        select.selectByVisibleText(desiredCarMake);
    }

    public void setGender(String desiredGender) {
        gender(desiredGender).click();
    }

    public void setCountry(String country){
        Select select = new Select(countryField);
        select.selectByVisibleText(country);
    }

}
