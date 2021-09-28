package testPom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;
import pom.Homepage;
import testBase.TestBase;

import java.util.List;

public class TestHomepage extends TestBase {


    @Test (dataProvider = "LocationsDataProvider", dataProviderClass = dataProviders.TestDataProviders.class, enabled = false)
    public void testSearchForAPlaceToGoWithFlexibleDates(String location, String checkinDate, String checkoutDate) throws InterruptedException {

        getHomepage().searchForAPlaceToGoWithFlexibleDates(location);

        String actualResults = driver.getTitle();
        String expectedResults = location + " · Stays · Airbnb";

        Assert.assertEquals(actualResults, expectedResults);

    }

    @Test (dataProvider = "LocationsDataProvider", dataProviderClass = dataProviders.TestDataProviders.class, enabled = false)
    public void testSearchForAPlaceToGoWithSpecificDates(String location, String checkinDate, String checkoutDate) throws InterruptedException {

        getHomepage().searchForAPlaceToGoWithSpecificDates(location, checkinDate, checkoutDate);

        String actualResults = driver.getTitle();
        String expectedResults = location + " · Stays · Airbnb";

        Assert.assertEquals(actualResults, expectedResults);

    }

    @Test (dataProvider = "LocationsDataProvider", dataProviderClass = dataProviders.TestDataProviders.class, enabled = false)
    public void testMaximumNumberOfAdultsToAdd(String location, String checkinDate, String checkoutDate) {
        Homepage homepage = new Homepage();

        homepage.sendLocationToLocationTextBox(location).selectFlexibleDates();

        int x = 0;
        do  {
            if (x>=1) {
                clickOnElement(homepage.addGuestsButton);
            }
            x++;
            homepage.addAdultsByOne();
            clickOnElement(homepage.addGuestsButton);
            List<WebElement> addGuestsButtonDisabled = driver.findElements(By.cssSelector("button._7hhhl3[data-testid='stepper-adults-increase-button'][disabled]"));

            if (addGuestsButtonDisabled.size() > 0) {
             break;
            }
        }
            while (Integer.valueOf(homepage.numOfAdultsSelected.getText().toString()) <= 30);

        String actualResults = homepage.numOfAdultsSelected.getText().toString();
        String expectedResults = "16";

        Assert.assertEquals(actualResults, expectedResults);

    }

    @Test (dataProvider = "LocationsDataProvider", dataProviderClass = dataProviders.TestDataProviders.class, enabled = false)
    public void testSearchForAPlaceWithNoGuests(String location, String checkinDate, String checkoutDate) throws InterruptedException {

        getHomepage().sendLocationToLocationTextBox(location).selectFlexibleDates().clickOnSearchButtonFor(location);

        String actualResults = driver.getTitle();
        String expectedResults = location + " · Stays · Airbnb";

        Assert.assertEquals(actualResults, expectedResults);

    }

    @Test (dataProvider = "LocationsDataProvider", dataProviderClass = dataProviders.TestDataProviders.class, enabled = false)
    public void testSearchForAPlaceWithoutProvidingLocation(String location, String checkinDate, String checkoutDate) throws InterruptedException {

        getHomepage().selectFlexibleDates().addAdultsByOne().clickOnSearchButton();
        webDriverWait.until(ExpectedConditions.visibilityOf(driver.findElement(By.cssSelector("label._qldsp30"))));
        Assert.assertTrue(isElementPresent(driver.findElement(By.cssSelector("label._qldsp30"))));

    }

    @Test (dataProvider = "LocationsDataProvider", dataProviderClass = dataProviders.TestDataProviders.class, enabled = false)
    public void testSearchForAPlaceWithNoDates(String location, String checkinDate, String checkoutDate) throws InterruptedException {

        getHomepage().sendLocationToLocationTextBox(location).addAdultsByOne().clickOnSearchButtonFor(location);

        String actualResults = driver.getTitle();
        String expectedResults = location + " · Stays · Airbnb";

        Assert.assertEquals(actualResults, expectedResults);

    }

    @Test (dataProvider = "LocationsDataProvider", dataProviderClass = dataProviders.TestDataProviders.class, enabled = true)
    public void testMaximumNumberOfChildrenToAdd(String location, String checkinDate, String checkoutDate) {
        Homepage homepage = new Homepage();

        homepage.sendLocationToLocationTextBox(location).selectFlexibleDates();

        int x = 0;
        do  {
            if (x>=1) {
                clickOnElement(homepage.addGuestsButton);
            }
            x++;
            homepage.addChildrenByOne();
            clickOnElement(homepage.addGuestsButton);
            List<WebElement> addGuestsButtonDisabled = driver.findElements(By.cssSelector("button._7hhhl3[data-testid='stepper-children-increase-button'][disabled]"));

            if (addGuestsButtonDisabled.size() > 0) {
                break;
            }
        }
        while (Integer.valueOf(homepage.numOfChildrenSelected.getText().toString()) <= 30);

        String actualResults = homepage.numOfChildrenSelected.getText().toString();
        String expectedResults = "5";

        Assert.assertEquals(actualResults, expectedResults);

    }
    @Test (dataProvider = "LocationsDataProvider", dataProviderClass = dataProviders.TestDataProviders.class, enabled = true)
    public void testMaximumNumberOfInfantsToAdd(String location, String checkinDate, String checkoutDate) {
        Homepage homepage = new Homepage();

        homepage.sendLocationToLocationTextBox(location).selectFlexibleDates();

        int x = 0;
        do  {
            if (x>=1) {
                clickOnElement(homepage.addGuestsButton);
            }
            x++;
            homepage.addInfantsByOne();
            clickOnElement(homepage.addGuestsButton);
            List<WebElement> addGuestsButtonDisabled = driver.findElements(By.cssSelector("button._7hhhl3[data-testid='stepper-infants-increase-button'][disabled]"));

            if (addGuestsButtonDisabled.size() > 0) {
                break;
            }
        }
        while (Integer.valueOf(homepage.numOfInfantsSelected.getText().toString()) <= 30);

        String actualResults = homepage.numOfInfantsSelected.getText().toString();
        String expectedResults = "5";

        Assert.assertEquals(actualResults, expectedResults);

    }



    }


