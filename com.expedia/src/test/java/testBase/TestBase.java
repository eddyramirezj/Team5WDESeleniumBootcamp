package testBase;

import base.BaseClass;
import org.openqa.selenium.ElementNotVisibleException;
import org.openqa.selenium.WebElement;
import pom.Homepage;
import pom.SignInpage;

import java.util.Properties;


public class TestBase extends BaseClass {

//    C:\Users\nahid\IdeaProjects\Team5WDESeleniumBootcamp\com.expedia

//    public String expediaORPath = absPath + "\\src\\test\\resources\\ExpediaRepo.properties";
//    public Properties expediaOR = loadProp(expediaORPath);

//    public Homepage getHomepage() {
//        return new Homepage();
//    }
public Homepage homepage = new Homepage();
public SignInpage signInpage = new SignInpage();



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