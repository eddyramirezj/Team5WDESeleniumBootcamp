package testBase;

import base.BaseClass;
import org.openqa.selenium.ElementNotVisibleException;
import org.openqa.selenium.WebElement;

import java.util.Properties;


public class TestBase extends BaseClass {

//    public Homepage getHomepage() {
//        return new Homepage();
//    }
    public static final String absPath = System.getProperty("user.dir");
    public String resourcesPath = absPath + "\\src\\test\\resources\\";
    public String attORPath = absPath + "\\src\\test\\resources\\attOR.properties";
    public Properties attOR = loadProp(attORPath);


    public String getProp(String key){
        return attOR.getProperty(key);

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