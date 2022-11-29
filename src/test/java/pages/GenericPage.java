package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import support.TestContext;

import java.time.Duration;

import static support.TestContext.getDriver;

public class GenericPage implements IHasURL{
    protected String url;
    protected String title;

    public GenericPage(){
        PageFactory
                .initElements(getDriver(), this);
    }
    public String getUrl (){
        String currentUrl = getDriver().getCurrentUrl();
        return currentUrl;
    }

    public String getTitle (){
        String title = getDriver().getTitle();
        return title;
    }

    public void openUrl(){
        getDriver().get(url);
    }


    //waits:
    public WebDriverWait getWait(){
        WebDriverWait wait  = new WebDriverWait(getDriver(), Duration.ofSeconds(5));
        return wait;
    }

    //customized getWai
    public WebDriverWait customWait(int sec){
        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(sec));
        return wait;
    }

    public void waitUntilVisible(WebElement element) {
        getWait().until(ExpectedConditions.visibilityOf(element));
    }
    public void waitUntilInVisible(WebElement element) {
        getWait().until(ExpectedConditions.invisibilityOf(element));
    }

    //actions
    Actions actions = new Actions(getDriver());


}
