package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class HomePage_Teacher extends GenericPage{

    @FindBy(xpath = "//*[contains(text(), 'TEACHER')]")
    private WebElement teacherHeader;

    public WebElement getTeacherHeader(){
        getWait().until(ExpectedConditions.visibilityOf(teacherHeader));
        return teacherHeader;
    }



}
