package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.awt.*;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.io.IOException;

import static org.assertj.core.api.Assertions.assertThat;
import static support.TestContext.getDriver;


public class LoginPage extends GenericPage {
    public LoginPage(){
        PageFactory.initElements(getDriver(), this);
        url = "http://ask-internship.portnov.com/#/login";
    }
    //private attributes
    @FindBy(xpath = "//input[@formcontrolname='email']")
    private WebElement emailTextField;

    @FindBy(xpath = "//input[@type = 'password']")
    private WebElement passwordTextField;

    @FindBy(xpath = "//button[@type='submit']")
    private WebElement signInButton;

    private WebElement getButton(String buttonName) {
        return getDriver().findElement(By.xpath("//button/span[contains(text(),'"+ buttonName +"')]"));

    }


    //public methods

    public void setEmail(String email){
        emailTextField.sendKeys(email);
    }

    public void setPassword(String password){
        passwordTextField.sendKeys(password);
    }

    public void signIn(){
        signInButton.click();
    }

    public boolean checkURL(){
        customWait(3);
        if(getUrl().equals(url)){
            return true;
        }else{
            return false;
        }
    }

    public WebElement getPasswordField(){
        return passwordTextField;
    }

    //checking if password can be copied or cut
    public void copyPassword(){

        actions.moveToElement(passwordTextField).doubleClick().perform();

        actions.keyDown(Keys.COMMAND).sendKeys("c").perform();

    }

    public void cutPassword(){
        actions.moveToElement(passwordTextField).doubleClick().perform();

        actions.keyDown(Keys.COMMAND).sendKeys("x").perform();

    }

        public boolean checkClipboard() throws IOException, UnsupportedFlavorException {
            //Verify get clipboard text
            Toolkit toolkit = Toolkit.getDefaultToolkit();
            Clipboard clipboard = toolkit.getSystemClipboard();
            String actualCopedText = (String) clipboard.getData(DataFlavor.stringFlavor);
            System.out.println("String from Clipboard:" + actualCopedText);


            if(actualCopedText.equals(passwordTextField.getText())){
                return true;
            }
            else{
                return false;
            }
    }

    public void clickRegister(String name){
        getButton(name).click();
        //waitUntilInVisible(getRegisterButton(name));
    }


}
