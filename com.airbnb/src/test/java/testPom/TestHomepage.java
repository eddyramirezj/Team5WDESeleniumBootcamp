package testPom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import pom.Homepage;
import pom.StaysPage;
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

    @Test (dataProvider = "LocationsDataProvider", dataProviderClass = dataProviders.TestDataProviders.class, enabled = true)
    public void testMaximumNumberOfGuestsToAdd(String location, String checkinDate, String checkoutDate) throws InterruptedException {
        Homepage homepage = new Homepage();

        homepage.sendLocationToLocationTextBox(location).selectFlexibleDates();

        int x = 0;
        do  {
            if (x>=1) {
                clickOnElement(homepage.addGuestsButton);
            }
            x++;
            homepage.addGuestsByOne();
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

    }


