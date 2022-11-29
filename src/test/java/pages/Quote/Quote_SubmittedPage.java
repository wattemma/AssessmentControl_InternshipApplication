package pages.Quote;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.GenericPage;

public class Quote_SubmittedPage  extends GenericPage {

    //@FindBy(xpath = "//*[@class='applicationResult']")
    @FindBy(xpath = "//*[@class='applicationResult']/following-sibling::section/div")
    private WebElement results;

    public String getResults(){
        waitUntilVisible(results);
        return results.getText();
    }


}
