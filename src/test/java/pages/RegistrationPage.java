package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class RegistrationPage extends GenericPage{
    @FindBy (xpath = "//*[@formcontrolname='firstName']")
    private WebElement firstName;

    @FindBy (xpath = "//*[@formcontrolname='email']")
    private WebElement email;

    @FindBy (xpath = "//*[@formcontrolname='lastName']")
    private WebElement lastName;

    @FindBy (xpath = "//*[@formcontrolname='group']")
    private WebElement groupCode;

    @FindBy (xpath = "//*[@formcontrolname='password']")
    private WebElement password;

    @FindBy (xpath = "//*[@formcontrolname='confirmPassword']")
    private WebElement confirmPassword;

    @FindBy(xpath = "//button[@type='submit']")
    private WebElement registerButton;



    public void setFirstName(String fName){
        firstName.sendKeys(fName);
    }

    public void setLastName(String lName){
        lastName.sendKeys(lName);
    }

    public void setEmail(String theEmail){
        email.sendKeys(theEmail);
    }

    public void setGroupCode(String code){
        groupCode.sendKeys(code);
    }

    public void setPassword(String thePassword){
        password.sendKeys(thePassword);
        confirmPassword.sendKeys(thePassword);
    }

    public void clickRegister(){
        registerButton.click();
        waitUntilInVisible(registerButton);
    }

}
