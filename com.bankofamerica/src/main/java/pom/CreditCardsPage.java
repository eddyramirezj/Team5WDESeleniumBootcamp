package pom;

import base.BaseClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

public class CreditCardsPage extends BaseClass {

    public CreditCardsPage() {
        PageFactory.initElements(driver, this);
    }

    @FindBy(css="#all-cards-tab")
    public WebElement allCardsTab;

    @FindBy(css="#all-cards-tab.active")
    public WebElement allCardsTabActive;

    @FindBy(css="a[class='filter-trigger']")
    public WebElement filterCardsDropMenu;

    @FindBy(css="a[class='filter-trigger active']")
    public WebElement filterCardsDropMenuOpen;

    @FindBy(css="a[id='searchCards'][disabled='disabled']")
    public WebElement viewCardsBtnDisabled;

    @FindBy(css="a[id='searchCards']")
    public WebElement viewCardsBtnEnabled;

    @FindBy(css="a[id='noAnnFee']")
    public WebElement noAnnualFeeCheckbox;

    @FindBy(css="a[id='noFrnTxFee']")
    public WebElement noForeignTransactionFeeCheckbox;

    @FindBy(css="a[id='lowIntroBT']")
    public WebElement lowIntroAPROnBalanceCheckbox;

    @FindBy(css="a[id='lowIntro']")
    public WebElement lowIntroAPROnPurchasesCheckbox;

    @FindBy(css="a[id='preferredRewardsCategoryLink']")
    public WebElement preferredRewardsCheckbox;

    @FindBy(css="a[id='visaCategoryLink']")
    public WebElement visaRadioBtn;

    @FindBy(css="a[id='mastercard']")
    public WebElement mastercardRadioBtn;

    @FindBy(css="span[class='count']")
    public WebElement filterCardsCount;

    @FindBy(css="input.search-query")
    public WebElement headerSearchBox;

    @FindBy(css="input.submit")
    public WebElement searchBtn;

    @FindBy(css="button[class='chat__button js-chat-minimize spa-btn fadeIn']")
    public WebElement chatBox;

    public void clickOnViewAllCardsTab() {
        waitForElementToBeClickable(allCardsTab);
        clickOnElement(allCardsTab);
        waitForElementToBeVisible(allCardsTabActive);
    }

    public void openFilterCardsDropMenu() {
        waitForElementToBeClickable(filterCardsDropMenu);
        clickOnElement(filterCardsDropMenu);
        waitForElementToBeVisible(filterCardsDropMenuOpen);
        waitForElementToBeVisible(viewCardsBtnDisabled);
    }

    public void clickOnViewCardsBtn() {
        List<WebElement> isViewCardsBtnEnabled = driver.findElements(By.cssSelector("a[id='searchCards']"));
        if (isViewCardsBtnEnabled.size() == 1) {
            waitForElementToBeVisible(viewCardsBtnEnabled);
            clickOnElement(viewCardsBtnEnabled);
        }

        List<WebElement> isFilterCardsDropMenuClosed = driver.findElements(By.cssSelector("a[class='filter-trigger active']"));
        if (isFilterCardsDropMenuClosed.size() != 0) {
            clickOnElement(viewCardsBtnEnabled);
        }
    }

    public void sendKeysToHeaderSearchBox(String input) {
        waitForElementToBeVisible(headerSearchBox);
        clickOnElement(headerSearchBox);
        sendKeysToInput(headerSearchBox, input);
        webDriverWait.until(ExpectedConditions.numberOfElementsToBe((By.cssSelector("a.track-me")), 5));
    }

}
