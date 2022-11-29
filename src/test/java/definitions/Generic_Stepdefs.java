package definitions;

import io.cucumber.java.en.Then;
import pages.IHasURL;
import pages.LoginPage;
import io.cucumber.java.en.Given;
import pages.Quote.Quote_HomePage;

public class Generic_Stepdefs  {
    @Given("I go to {string} page")
    public void iGoToPage(String pageName) {
        IHasURL iHasURL = null;
        switch (pageName){
            case "Assessment Control":
                /*#1 way
                we get the .openUrl() method here from the LoginPage, which in turn,
                inherits it from the genericPage.
                 */
                //new LoginPage().openUrl();

                /*
                #2 way
                we define an interface and the generic page implements that interface,
                and classes inherit the generic page

                 */
                iHasURL = new LoginPage();
                break;

            case "quote":
                iHasURL = new Quote_HomePage();
                break;
            default:
                throw new Error("Unsupported page " + pageName);
        }
        iHasURL.openUrl();
    }



}
