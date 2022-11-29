package pages.Quote;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import pages.GenericPage;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;
import static support.TestContext.getDriver;



public class DocumentsPage extends GenericPage {

    private WebElement docName(String document){
        return getDriver().findElement(By.xpath("//li[text()='"+document+"']"));
    }

    public void  switchWindowAndSeeDoc(String docName){
        
        String parentHandle = getDriver().getWindowHandle();
        Set <String> allHandles = getDriver().getWindowHandles();

        for(String handle : allHandles){
            if(!handle.contains(parentHandle)){
                getDriver().switchTo().window(handle);
                break;
            }
        }
        assertThat(docName(docName).isDisplayed()).isTrue();

        getDriver().switchTo().window(parentHandle);
    }

    public WebElement seeDoc(String name){
        waitUntilVisible(docName(name));
        return docName(name);
    }
    public void back(){
        getDriver().navigate().back();
    }

}
