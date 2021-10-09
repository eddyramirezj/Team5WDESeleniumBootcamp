package pom;

import base.BaseClass;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContactUs extends BaseClass {

    public ContactUs() {
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath="//b[text()='Customer Relations']//following-sibling::b")
    public WebElement customerRelationsNumber;



}
