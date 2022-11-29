package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class HomePage_Student extends GenericPage {

    @FindBy(xpath = "//*[contains(text(), 'STUDENT')]")
    private WebElement studentHeader;

    public WebElement getStudentHeader(){
        getWait().until(ExpectedConditions.visibilityOf(studentHeader));
        return studentHeader;
    }
}
