package pom;

import base.BaseClass;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class BuyPhones extends BaseClass {

    public BuyPhones() {
        PageFactory.initElements(driver, this);
    }

    @FindBy (xpath="//div[text()='iPhone 13 Pro Max']/parent::a/parent::div/following-sibling::div//span[@class='type-md line-h-sm _1eRtY _D4P5S color-ui-black font-medium']")
    public WebElement iPhone13ProMaxPrice;

    @FindBy (xpath="//div[text()='iPhone 13 Pro']/parent::a/parent::div/following-sibling::div//span[@class='type-md line-h-sm _1eRtY _D4P5S color-ui-black font-medium']")
    public WebElement iPhone13ProPrice;

    @FindBy (xpath="//div[text()='iPhone 13']/parent::a/parent::div/following-sibling::div//span[@class='type-md line-h-sm _1eRtY _D4P5S color-ui-black font-medium']")
    public WebElement iPhone13Price;

    @FindBy (xpath="//div[text()='iPhone 13 mini']/parent::a/parent::div/following-sibling::div//span[@class='type-md line-h-sm _1eRtY _D4P5S color-ui-black font-medium']")
    public WebElement iPhone13miniPrice;

    @FindBy (xpath="//div[text()='Galaxy Z Fold3 5G']/parent::a/parent::div/following-sibling::div//span[@class='type-md line-h-sm _1eRtY _D4P5S color-ui-black font-medium']")
    public WebElement galaxyZFold3G5Price;

    @FindBy (xpath="//div[text()='Galaxy Z Flip3 5G']/parent::a/parent::div/following-sibling::div//span[@class='type-md line-h-sm _1eRtY _D4P5S color-ui-black font-medium']")
    public WebElement galaxyZFlip35GPrice;

    @FindBy (xpath="//div[text()='iPhone 12 Pro Max']/parent::a/parent::div/following-sibling::div//span[@class='type-md line-h-sm _1eRtY _D4P5S color-ui-black font-medium']")
    public WebElement iPhone12ProMaxPrice;

    @FindBy (xpath="//div[text()='iPhone 11']/parent::a/parent::div/following-sibling::div//span[@class='type-md line-h-sm _1eRtY _D4P5S color-ui-black font-medium']")
    public WebElement iPhone11Price;

    @FindBy (xpath="//div[text()='iPhone 12']/parent::a/parent::div/following-sibling::div//span[@class='type-md line-h-sm _1eRtY _D4P5S color-ui-black font-medium']")
    public WebElement iPhone12Price;

    @FindBy (xpath="//div[text()='Galaxy S21 Ultra 5G']/parent::a/parent::div/following-sibling::div//span[@class='type-md line-h-sm _1eRtY _D4P5S color-ui-black font-medium']")
    public WebElement galaxyS21Ultra5GPrice;

    @FindBy (css="input._32uz9")
    public WebElement showPricesForTradeInSwitch;

    @FindBy (xpath="//input[@class='_32uz9']/following-sibling::span")
    public WebElement showPricesForTradeInSwitchOnOff;

    public void clickOnShowPricesForTradeInSwitch() {
        waitForElementToBeClickable(showPricesForTradeInSwitch);
        clickJScript(showPricesForTradeInSwitch);
        waitForElementToBeVisible(showPricesForTradeInSwitchOnOff);
    }


}
