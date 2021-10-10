package pom;

import base.BaseClass;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SearchHomes extends BaseClass {

    public SearchHomes() {
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath ="//span[@class='homesText']")
    public WebElement homesMsg;

    @FindBy (css="div.homes.summary")
    public WebElement numOfHomesResults;

    @FindBy (css="span.field.select.Select.quickMinPrice>span.input")
    public WebElement minPriceBox;

    @FindBy (css="span.field.select.Select.quickMaxPrice>span.input")
    public WebElement maxPriceBox;

    @FindBy (css="select[name='quickMinPrice']")
    public WebElement minPriceListOfPrices;

    @FindBy (css="select[name='quickMaxPrice']")
    public WebElement maxPriceListOfPrices;

    @FindBy (css="button[class='button Button wideSidepaneFilterButton v3 compact text']")
    public WebElement moreFiltersTab;

    @FindBy (css="button[class='button Button applyButton buttonBorder primary']")
    public WebElement applyFiltersBtn;

    @FindBy (xpath="//div[text()='Baths']/parent::div//span[@class='step-up']")
    public WebElement addBathsBtn;

    @FindBy (xpath="//div[text()='Baths']/parent::div//span[@class='step-down']")
    public WebElement decreaseBathsBtn;

    @FindBy (css="button[data-rf-test-name='uipt1']")
    public WebElement selectPropertyTypeHouseBtn;

    @FindBy (css="button[data-rf-test-name='uipt2']")
    public WebElement selectPropertyTypeCondoBtn;

    @FindBy (css="button[data-rf-test-name='uipt3']")
    public WebElement selectPropertyTypeTownhouseBtn;

    @FindBy (css="button[data-rf-test-name='uipt4']")
    public WebElement selectPropertyTypeMultiFamilyBtn;

    @FindBy (css="button[data-rf-test-name='uipt5']")
    public WebElement selectPropertyTypeLandBtn;

    @FindBy (css="button[data-rf-test-name='uipt6']")
    public WebElement selectPropertyTypeManufacturedBtn;

    @FindBy (css="button[data-rf-test-name='uipt7']")
    public WebElement selectPropertyTypeCoopBtn;

    @FindBy (css="button[data-rf-test-name='uipt8']")
    public WebElement selectPropertyTypeOtherBtn;

    @FindBy (css="select[name='minBeds']")
    public WebElement minBedsDropDownList;

    @FindBy (css="select[name='maxBeds']")
    public WebElement maxBedsDropDownList;

    public SearchHomes clickOnMoreFiltersTab() {
        waitForElementToBeClickable(moreFiltersTab);
        clickOnElement(moreFiltersTab);
        waitForElementToBeVisible(applyFiltersBtn);
        return new SearchHomes();
    }

    public SearchHomes addBaths() {
        waitForElementToBeClickable(addBathsBtn);
        clickOnElement(addBathsBtn);
        waitForElementToBeVisible(applyFiltersBtn);
        return new SearchHomes();
    }

    public SearchHomes decreaseBaths() {
        waitForElementToBeClickable(decreaseBathsBtn);
        clickOnElement(decreaseBathsBtn);
        waitForElementToBeVisible(applyFiltersBtn);
        return new SearchHomes();
    }

    public SearchHomes clickOnApplyFilters() {
        waitForElementToBeClickable(applyFiltersBtn);
        clickOnElement(applyFiltersBtn);
        waitForElementToBeVisible(numOfHomesResults);
        return new SearchHomes();
    }

    public SearchHomes selectPropertyTypeHouse() {
        waitForElementToBeClickable(selectPropertyTypeHouseBtn);
        clickOnElement(selectPropertyTypeHouseBtn);
        waitForElementToBeVisible(applyFiltersBtn);
        return new SearchHomes();
    }

    public SearchHomes selectPropertyTypeTownhouse() {
        waitForElementToBeClickable(selectPropertyTypeTownhouseBtn);
        clickOnElement(selectPropertyTypeTownhouseBtn);
        waitForElementToBeVisible(applyFiltersBtn);
        return new SearchHomes();
    }

    public SearchHomes selectPropertyTypeCondo() {
        waitForElementToBeClickable(selectPropertyTypeCondoBtn);
        clickOnElement(selectPropertyTypeCondoBtn);
        waitForElementToBeVisible(applyFiltersBtn);
        return new SearchHomes();
    }

    public SearchHomes selectPropertyTypeLand() {
        waitForElementToBeClickable(selectPropertyTypeLandBtn);
        clickOnElement(selectPropertyTypeLandBtn);
        waitForElementToBeVisible(applyFiltersBtn);
        return new SearchHomes();
    }

    public SearchHomes selectPropertyTypeMultiFamily() {
        waitForElementToBeClickable(selectPropertyTypeMultiFamilyBtn);
        clickOnElement(selectPropertyTypeMultiFamilyBtn);
        waitForElementToBeVisible(applyFiltersBtn);
        return new SearchHomes();
    }

    public SearchHomes selectPropertyTypeManufactured() {
        waitForElementToBeClickable(selectPropertyTypeManufacturedBtn);
        clickOnElement(selectPropertyTypeManufacturedBtn);
        waitForElementToBeVisible(applyFiltersBtn);
        return new SearchHomes();
    }

    public SearchHomes selectPropertyTypeCoop() {
        waitForElementToBeClickable(selectPropertyTypeCoopBtn);
        clickOnElement(selectPropertyTypeCoopBtn);
        waitForElementToBeVisible(applyFiltersBtn);
        return new SearchHomes();
    }

    public SearchHomes selectPropertyTypeOther() {
        waitForElementToBeClickable(selectPropertyTypeOtherBtn);
        clickOnElement(selectPropertyTypeOtherBtn);
        waitForElementToBeVisible(applyFiltersBtn);
        return new SearchHomes();
    }

    public String getCurrentHomeResults() {
        String[] results = this.numOfHomesResults.getText().split(" ");
        if (results.length == 2) {
            return results[0];
        }
        else {
            return results[2];
        }

    }

}



//    public SearchHomes selectMinBeds(String option) {
//        waitForElementToBeVisible(minBedsDropDownList);
//        Select select = new Select(minBedsDropDownList);
//        select.selectByIndex(2);
//        waitForElementToBeVisible(applyFiltersBtn);
//        return new SearchHomes();
//    }
//
//    public SearchHomes selectMaxBeds(String option) {
//        waitForElementToBeVisible(maxBedsDropDownList);
//        Select select = new Select(maxBedsDropDownList);
//        select.selectByIndex(2);
//        waitForElementToBeVisible(applyFiltersBtn);
//        return new SearchHomes();
//    }