package pom;

import base.BaseClass;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Homepage extends BaseClass {

    public Homepage() {
        PageFactory.initElements(driver, this);
    }

    @FindBy(css="input[type='search'][placeholder='City, Address, School, Agent, ZIP']")
    public WebElement searchCityBox;

    @FindBy (css="button[data-rf-test-name='searchButton'][tabindex='0']")
    public WebElement searchHomeBtn;

    @FindBy (xpath="//div[text()='Places']//parent::div[@class='expanded-row-content']/div[2]")
    public WebElement selectFirstOption;

    @FindBy(xpath ="//span[@class='homesText']")
    public WebElement searchHomesMsg;

    public SearchHomes searchForHomes(String city) {
        waitForElementToBeVisible(searchCityBox);
        sendKeysToInput(searchCityBox, city);
        waitForElementToBeVisible(selectFirstOption);
        clickJScript(selectFirstOption);
        waitForElementToBeVisible(searchHomesMsg);
        return new SearchHomes();
    }

}
