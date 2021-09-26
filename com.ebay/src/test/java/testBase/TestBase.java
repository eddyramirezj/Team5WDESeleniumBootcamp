package testBase;

import base.BaseClass;
import org.openqa.selenium.ElementNotVisibleException;
import org.openqa.selenium.WebElement;
import pom.Homepage;
import pom.RegisterPage;
import pom.ResultsPage;


public class TestBase extends BaseClass {

    public Homepage getHomepage() {
        return new Homepage();
    }

    public ResultsPage getResultsPage() {
        return new ResultsPage();
    }

    public RegisterPage getRegisterPage() {
        return new RegisterPage();
    }


    public boolean isElementPresent(WebElement element) {
        boolean flag = false;

        try {
            if (element.isDisplayed()){
                flag = true;
            }
        } catch (ElementNotVisibleException e) {
            System.out.println("UNABLE TO LOCATE ELEMENT");
        }

        return flag;
    }
}