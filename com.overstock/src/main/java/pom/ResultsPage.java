package pom;

import base.BaseClass;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ResultsPage extends BaseClass {

    public ResultsPage() {
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath="//span[text()='Shop All Beds on Sale']")
    public WebElement bedsOnSaleButton;

    @FindBy (css="p.result-count")
    public WebElement resultsCount;

    public String getNumberOfBedsOnSale() {
        Homepage homepage = new Homepage();
        homepage.searchForProductOnSearchBar("bed");
        waitForElementToBeClickable(bedsOnSaleButton);
        clickOnElement(bedsOnSaleButton);
        waitForElementToBeVisible(resultsCount);
        return resultsCount.getText();

    }

}
