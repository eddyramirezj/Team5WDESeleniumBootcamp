package testBase;

import base.BaseClass;
import org.openqa.selenium.ElementNotVisibleException;
import org.openqa.selenium.WebElement;
import pom.Homepage;
import pom.HomepageLosAngeles;

public class TestBase extends BaseClass {

    public static Homepage getHomepage() {
        return new Homepage();
    }

    public HomepageLosAngeles getStaysPage() {
        return new HomepageLosAngeles();
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