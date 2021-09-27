package pom;

import base.BaseClass;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class StaysPage extends BaseClass {

    public StaysPage() {
        PageFactory.initElements(driver, this);
    }

    @FindBy(css="span._z5888n")
    public WebElement staysResults;

}
