package testBase;

import base.BaseClass;
import org.openqa.selenium.ElementNotVisibleException;
import org.openqa.selenium.WebElement;
import pom.Homepage;
import pom.StaysPage;


public class TestBase extends BaseClass {

    public Homepage getHomepage() {
        return new Homepage();
    }

    public StaysPage getStaysPage() {
        return new StaysPage();
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