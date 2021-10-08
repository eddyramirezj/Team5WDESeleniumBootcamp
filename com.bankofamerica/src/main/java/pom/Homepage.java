package pom;

import base.BaseClass;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class Homepage extends BaseClass {

    public Homepage() {
        PageFactory.initElements(driver, this);
    }

    @FindBy(css="div.large-12 ul.main-nav-links a#navChecking")
    public WebElement checkingAccountNavTab;

    @FindBy(css="#navCreditCards")
    public WebElement creditCardsBtn;

    @FindBy(css="#btnCompareCreditCards")
    public WebElement shopAllCreditCardsBtn;


    public CreditCardsPage navigateToCreditCardsPage() {
        waitForElementToBeClickable(creditCardsBtn);
        clickOnElement(creditCardsBtn);
        waitForElementToBeClickable(shopAllCreditCardsBtn);
        clickOnElement(shopAllCreditCardsBtn);
        return new CreditCardsPage();
    }


}
