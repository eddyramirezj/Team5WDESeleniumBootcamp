package pom;

import base.BaseClass;
import org.openqa.selenium.support.PageFactory;

public class WashingtonPage extends BaseClass {

    public WashingtonPage() {

        PageFactory.initElements(driver, this);

    }



public String expectedTitle = "Washington.Stays.Airbnb";
public String expectedTitleContains = "Washington";
public String actualTitle(){ return driver.getTitle();}

public boolean verifyTitleIsCorrect(){
    return actualTitle().equalsIgnoreCase(expectedTitle);
}

    public boolean verifyTitleIsCorrect_(){
        return actualTitle().contains(expectedTitleContains);
    }














}
