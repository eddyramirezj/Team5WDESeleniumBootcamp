package pom;

import base.BaseClass;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class WashingtonPage extends BaseClass {

    public WashingtonPage() {

        PageFactory.initElements(driver, this);

    }

/***************************************  LOCATORS  ***********************************/
    @FindBy(css = "h1._14i3z6h")
    public WebElement stayWashingtonLink;

    @FindBy(id = "field-guide-toggle")
    public WebElement fieldGuideButton;


/***************************************  PAGE METHODS  ***********************************/

public String expectedTitle = "Airbnb: Vacation Rentals, Cabins, Beach Houses, Unique Homes & Experiences";

public String expectedTitleContaining = "Airbnb: Vacation Rentals";
public String actualTitle(){ return driver.getTitle().toString();}

public boolean isTitleCorrect(){
    return actualTitle().equalsIgnoreCase(expectedTitle);
}

    public boolean isTitleCorrect_(){
        return actualTitle().contains(expectedTitleContaining);
    }

public void unitTest(){
    clickOnElement(fieldGuideButton);

}












}
