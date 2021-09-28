package pom;

import base.BaseClass;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

import java.util.Arrays;
import java.util.List;

import static base.BaseClass.driver;

public class Homepage extends BaseClass {

    public Homepage() {
        PageFactory.initElements(driver, this);
    }

    @FindBy (css="a[href='/washington-dc/stays']")
    public WebElement navigateToWashingtonRentalsPageLink;

    @FindBy (css = "input#bigsearch-query-detached-query-input")
    public WebElement locationComboBox;

    @FindBy (css="ul._11dv6d8 li[data-index='0']")
    public WebElement selectFirstOptionFromLocationComboBox;

    @FindBy (xpath="//div[@class='_wtz1co' and text()='Check in']//following-sibling::div")
    public WebElement addCheckInDateButton;

    @FindBy (css="button._187sg6v[aria-label='Previous']")
    public WebElement goToPreviousMonthOnCalendarButton;

    @FindBy (css="button._187sg6v[aria-label='Next']")
    public WebElement goToNextMonthOnCalendarButton;

    @FindBy (css="button#tab--tabs--1")
    public WebElement imFlexibleButton;

    @FindBy (xpath="//div[text()='Flexible dates']")
    public WebElement flexibleDatesButton;

    @FindBy (xpath="//div[@class='_wtz1co' and text()='Check out']//following-sibling::div")
    public WebElement addCheckOutDateButton;

    @FindBy (xpath="//div[@class='_wtz1co' and text()='Guests']//following-sibling::div")
    public WebElement addGuestsButton;

    @FindBy (css="button._7hhhl3[data-testid='stepper-adults-increase-button']")
    public WebElement increaseAdultsButton;

    @FindBy (css="button._7hhhl3[data-testid='stepper-adults-increase-button'][disabled]")
    public WebElement increaseAdultsButtonDisabled;

    @FindBy (css="button._7hhhl3[data-testid='stepper-children-increase-button']")
    public WebElement increaseChildrenButton;

    @FindBy (css="button._7hhhl3[data-testid='stepper-children-increase-button'][disabled]")
    public WebElement increaseChildrenButtonDisabled;

    @FindBy (css="button._7hhhl3[data-testid='stepper-infants-increase-button']")
    public WebElement increaseInfantsButton;

    @FindBy (css="button._7hhhl3[data-testid='stepper-infants-increase-button'][disabled]")
    public WebElement increaseInfantsButtonDisabled;

    @FindBy (css="span[data-testid='stepper-adults-value']")
    public WebElement numOfAdultsSelected;

    @FindBy (css="span[data-testid='stepper-children-value']")
    public WebElement numOfChildrenSelected;

    @FindBy (css="span[data-testid='stepper-infants-value']")
    public WebElement numOfInfantsSelected;

    @FindBy (css="button._1mzhry13")
    public WebElement searchButton;

    public void searchForAPlaceToGoWithFlexibleDates(String location) {
        try {
        waitForElementToBeClickable(locationComboBox);
        sendKeysToInput(locationComboBox, location);
        waitForElementToBeVisible(selectFirstOptionFromLocationComboBox);
        clickOnElement(selectFirstOptionFromLocationComboBox);
        waitForElementToBeClickable(imFlexibleButton);
        clickOnElement(imFlexibleButton);
        waitForElementToBeClickable(flexibleDatesButton);
        clickOnElement(flexibleDatesButton);
        waitForElementToBeClickable(addGuestsButton);
        clickOnElement(addGuestsButton);
        waitForElementToBeClickable(increaseAdultsButton);
        clickOnElement(increaseAdultsButton);
        clickOnElement(addGuestsButton);
        waitForElementToBeVisible(searchButton);
        clickOnElement(searchButton);
        webDriverWait.until(ExpectedConditions.titleContains(location));

        }

        catch (NoSuchElementException e) {
            e.printStackTrace();
        }

    }

    public void searchForAPlaceToGoWithSpecificDates(String location, String checkinDate, String checkoutDate) {
        try {
            waitForElementToBeClickable(locationComboBox);
            sendKeysToInput(locationComboBox, location);
            Thread.sleep(1000);
            waitForElementToBeVisible(selectFirstOptionFromLocationComboBox);
            clickOnElement(selectFirstOptionFromLocationComboBox);

            waitForElementToBeVisible(addCheckInDateButton);

            String[] dateOfCheckIn = dateFormatChange(checkinDate);

            List<WebElement> selectedCheckInMonth = (driver.findElements(By.xpath("//h2[text()='" + dateOfCheckIn[0] + " " + dateOfCheckIn[2] + "']")));

            while (selectedCheckInMonth.size() == 0) {
                waitForElementToBeClickable(goToNextMonthOnCalendarButton);
                clickOnElement(goToNextMonthOnCalendarButton);
                selectedCheckInMonth = (driver.findElements(By.xpath("//h2[text()='" + dateOfCheckIn[0] + " " + dateOfCheckIn[2] + "']")));
            }

            waitForElementToBeVisible(driver.findElement(By.xpath("//h2[text()='" + dateOfCheckIn[0] + " " + dateOfCheckIn[2] + "']//parent::div[@class='_gucugi']//following-sibling::table//td[@class='_12fun97']//div[text()= '" + dateOfCheckIn[1] + "']")));
            driver.findElement(By.xpath("//h2[text()='" + dateOfCheckIn[0] + " " + dateOfCheckIn[2] + "']//parent::div[@class='_gucugi']//following-sibling::table//td[@class='_12fun97']//div[text()= '" + dateOfCheckIn[1] + "']")).click();

            waitForElementToBeVisible(addCheckOutDateButton);

            String[] dateOfCheckOut = dateFormatChange(checkoutDate);

            List<WebElement> selectedCheckOutMonth = (driver.findElements(By.xpath("//h2[text()='" + dateOfCheckOut[0] + " " + dateOfCheckOut[2] + "']")));

            while (selectedCheckOutMonth.size() == 0) {
                waitForElementToBeClickable(goToNextMonthOnCalendarButton);
                clickOnElement(goToNextMonthOnCalendarButton);
                selectedCheckOutMonth = (driver.findElements(By.xpath("//h2[text()='" + dateOfCheckOut[0] + " " + dateOfCheckOut[2] + "']")));
            }

            waitForElementToBeVisible(driver.findElement(By.xpath("//h2[text()='" + dateOfCheckOut[0] + " " + dateOfCheckOut[2] + "']//parent::div[@class='_gucugi']//following-sibling::table//td[@class='_12fun97']//div[text()= '" + dateOfCheckOut[1] + "']")));
            driver.findElement(By.xpath("//h2[text()='" + dateOfCheckOut[0] + " " + dateOfCheckOut[2] + "']//parent::div[@class='_gucugi']//following-sibling::table//td[@class='_12fun97']//div[text()= '" + dateOfCheckOut[1] + "']")).click();

            waitForElementToBeClickable(addGuestsButton);
            clickOnElement(addGuestsButton);
            waitForElementToBeClickable(increaseAdultsButton);
            clickOnElement(increaseAdultsButton);
            clickOnElement(addGuestsButton);
            waitForElementToBeVisible(searchButton);
            clickOnElement(searchButton);
            webDriverWait.until(ExpectedConditions.titleContains(location));

        }

        catch (NoSuchElementException | InterruptedException e) {
            e.printStackTrace();
        }

    }

    public void navigateToWashingtonRentalsPage() {
        waitForElementToBeClickable(navigateToWashingtonRentalsPageLink);
        scrollJS(4000);
        clickOnElement(navigateToWashingtonRentalsPageLink);
        webDriverWait.until(ExpectedConditions.urlMatches("https://www.airbnb.com/washington-dc/stays"));
    }

    public Homepage sendLocationToLocationTextBox(String location) {
        try {
            waitForElementToBeClickable(locationComboBox);
            sendKeysToInput(locationComboBox, location);
            Thread.sleep(1000);
            waitForElementToBeVisible(selectFirstOptionFromLocationComboBox);
            clickOnElement(selectFirstOptionFromLocationComboBox);

        } catch (NoSuchElementException | InterruptedException e) {
            e.printStackTrace();
        }
        return new Homepage();
    }

        public Homepage selectFlexibleDates() {
            try {
                List<WebElement> checkInCalendarExpanded = driver.findElements(By.cssSelector("div._1akb2mdw[aria-expanded='false']"));

                while (checkInCalendarExpanded.size() > 1) {
                    waitForElementToBeClickable(addCheckInDateButton);
                    clickOnElement(addCheckInDateButton);
                    checkInCalendarExpanded = driver.findElements(By.cssSelector("div._1akb2mdw[aria-expanded='false']"));
                }

                waitForElementToBeClickable(imFlexibleButton);
                clickOnElement(imFlexibleButton);
                waitForElementToBeClickable(flexibleDatesButton);
                clickOnElement(flexibleDatesButton);

            }

            catch (NoSuchElementException e) {
                e.printStackTrace();
            }

            return new Homepage();

        }


    public Homepage addAdultsByOne() {

        try {

            List<WebElement> addAdultsButtonDisabled = driver.findElements(By.cssSelector("button._7hhhl3[data-testid='stepper-adults-increase-button'][disabled]"));

            if (addAdultsButtonDisabled.size() < 1) {
                fluentWaitForElementToBeClickable(addGuestsButton);
                clickOnElement(addGuestsButton);
                waitForElementToBeClickable(increaseAdultsButton);
                clickOnElement(increaseAdultsButton);
                clickOnElement(addGuestsButton);
            }
            else
            {
                System.out.println("MAXIMUM ADULTS ALLOWANCE REACHED");
            }
        }

        catch (NoSuchElementException e) {
            e.printStackTrace();
        }
        return new Homepage();
    }

    public Homepage addChildrenByOne() {
        try {

            List<WebElement> addChildrenButtonDisabled = driver.findElements(By.cssSelector("button._7hhhl3[data-testid='stepper-children-increase-button'][disabled]"));

            if (addChildrenButtonDisabled.size() < 1) {
                fluentWaitForElementToBeClickable(addGuestsButton);
                clickOnElement(addGuestsButton);
                waitForElementToBeClickable(increaseChildrenButton);
                clickOnElement(increaseChildrenButton);
                clickOnElement(addGuestsButton);
            }
            else
            {
                System.out.println("MAXIMUM CHILDREN ALLOWANCE REACHED");
            }
        }

        catch (NoSuchElementException e) {
            e.printStackTrace();
        }
        return new Homepage();
    }

    public Homepage addInfantsByOne() {
        try {

            List<WebElement> addInfantsButtonDisabled = driver.findElements(By.cssSelector("button._7hhhl3[data-testid='stepper-infants-increase-button'][disabled]"));

            if (addInfantsButtonDisabled.size() < 1) {
                fluentWaitForElementToBeClickable(addGuestsButton);
                clickOnElement(addGuestsButton);
                waitForElementToBeClickable(increaseInfantsButton);
                clickOnElement(increaseInfantsButton);
                clickOnElement(addGuestsButton);
            }
            else
            {
                System.out.println("MAXIMUM INFANTS ALLOWANCE REACHED");
            }
        }

        catch (NoSuchElementException e) {
            e.printStackTrace();
        }
        return new Homepage();
    }

    public Homepage clickOnSearchButton() {
        try {

            waitForElementToBeVisible(searchButton);
            clickOnElement(searchButton);

        } catch (NoSuchElementException e) {
            e.printStackTrace();
        }
        return new Homepage();
    }
        public Homepage clickOnSearchButtonFor(String location) {
            try {

                waitForElementToBeVisible(searchButton);
                clickOnElement(searchButton);
                webDriverWait.until(ExpectedConditions.titleContains(location));

            }

        catch (NoSuchElementException e) {
            e.printStackTrace();
        }
        return new Homepage();
    }







/*
    HELPER METHODS
 */
    public String[] dateFormatChange(String date) {
        String[] monthDayYear = date.split("/");

        int[] dates = new int[monthDayYear.length];

        for(int i = 0; i < monthDayYear.length; i++)
        {
            dates[i] = Integer.parseInt(monthDayYear[i].trim());
        }

        String[] formatMonthDayYear = new String[3];

        switch (dates[0]) {
            case 1:
                formatMonthDayYear[0] = "January";
                break;
            case 2:
                formatMonthDayYear[0] = "February";
                break;
            case 3:
                formatMonthDayYear[0] = "March";
                break;
            case 4:
                formatMonthDayYear[0] = "April";
                break;
            case 5:
                formatMonthDayYear[0] = "May";
                break;
            case 6:
                formatMonthDayYear[0] = "June";
                break;
            case 7:
                formatMonthDayYear[0] = "July";
                break;
            case 8:
                formatMonthDayYear[0] = "August";
                break;
            case 9:
                formatMonthDayYear[0] = "September";
                break;
            case 10:
                formatMonthDayYear[0] = "October";
                break;
            case 11:
                formatMonthDayYear[0] = "November";
                break;
            case 12:
                formatMonthDayYear[0] = "December";
                break;

        }

        formatMonthDayYear[1] = monthDayYear[1];
        formatMonthDayYear[2] = monthDayYear[2];

        return formatMonthDayYear;

    }
}
