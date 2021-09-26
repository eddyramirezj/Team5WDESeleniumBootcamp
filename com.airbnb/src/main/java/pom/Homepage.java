package pom;

import base.BaseClass;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import static base.BaseClass.driver;

public class Homepage extends BaseClass {

    public Homepage() {
        PageFactory.initElements(driver, this);
    }

    @FindBy (css = "div._1sfnwgq>svg")
    public WebElement dropDownMenuLoginButton;

    @FindBy (css = "_1xq16jy")
    public WebElement locationTextField;

    @FindBy (css = "div._gor68n>div._wtz1co")
    public WebElement locationTextFieldButton;

    /****************************  The following locators and Methods were added by PNT-1001 ********************/

    //    @FindBy (css = "    body > div:nth-child(7) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > main:nth-child(1) > div:nth-child(1) > div:nth-child(1) > main:nth-child(3) > div:nth-child(1) > div:nth-child(1) > div:nth-child(2) > div:nth-child(1) > div:nth-child(2) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > div:nth-child(3) > div:nth-child(1) > div:nth-child(1) > div:nth-child(2) > a:nth-child(1) > span:nth-child(2) > span:nth-child(1) > b:nth-child(1)\n")
    @FindBy (css = "div[class='_1tfpcfm'] div[class='_16xcv07v'] span[class='_expepa']")
    public WebElement washingtonLink;


    public WashingtonPage goToWashingtonPage(){

        clickOnElement(washingtonLink);
        return new WashingtonPage();
    }

    public void testIfLinkIsPresent(){
        isPresent(washingtonLink);

    }
/****************************  The above locators were added by PNT-1001 ****************************/



}
