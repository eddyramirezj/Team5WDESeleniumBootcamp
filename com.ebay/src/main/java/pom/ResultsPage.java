package pom;

import base.BaseClass;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ResultsPage extends BaseClass {

    public ResultsPage() {
        PageFactory.initElements(driver, this);
    }

    @FindBy (css = "a[title='My eBay']")
    public WebElement myEbayDropDownMenu;

    @FindBy (xpath = "//a[text()='register']")
    public WebElement headerRegisterButton;

    @FindBy (css="li[data-view='mi:1686|iid:2']")
    public WebElement secondItemOfResults;

    @FindBy (css="div#atc-area")
    public WebElement addToCartButton;

    @FindBy (xpath="//span[@class='srp-format-tabs-h2' and contains(text(), 'Buy It Now')]")
    public WebElement buyItNowButton;

    @FindBy (xpath="//span[@class='vi-atw-txt' and text()='Add to Watchlist']")
    public WebElement addToWatchList;

    @FindBy (css="select#msku-sel-1")
    public WebElement itemDescriptionColorDropMenu;

    public void navigateToRegisterPageFromResultsPage() {
        fluentWaitForElementToBeClickable(headerRegisterButton);
        clickOnElement(headerRegisterButton);

    }

    public void addToWatchList(String productToAdd) {
        fluentWaitForElementToBeClickable(buyItNowButton);
        buyItNowButton.click();
        fluentWaitForElementToBeClickable(driver.findElement(By.xpath("//h3[contains(text(), '" + productToAdd + "')]")));
        clickOnElement(driver.findElement(By.xpath("//h3[contains(text(), '" + productToAdd + "')]")));
        selectOptionFromDropDownMenuByIndex(itemDescriptionColorDropMenu, 3);
        fluentWaitForElementToBeClickable(addToWatchList);
        clickOnElement(addToWatchList);
    }

    public void addToCart(String productToAdd) {
        try {
            fluentWaitForElementToBeClickable(buyItNowButton);
            buyItNowButton.click();
            fluentWaitForElementToBeClickable(driver.findElement(By.xpath("//h3[contains(text(), '" + productToAdd + "')]")));
            clickOnElement(driver.findElement(By.xpath("//h3[contains(text(), '" + productToAdd + "')]")));
            try {
                selectOptionFromDropDownMenuByIndex(itemDescriptionColorDropMenu, 3);
            }
            catch (Exception e) {
                throw e;
            }
            fluentWaitForElementToBeClickable(addToCartButton);
            clickOnElement(addToCartButton);
        }

        catch (NoSuchElementException e) {
            e.printStackTrace();
        }

    }

}
