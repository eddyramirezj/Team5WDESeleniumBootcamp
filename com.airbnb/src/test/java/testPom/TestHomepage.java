package testPom;

import org.testng.Assert;
import org.testng.annotations.Test;
import pom.Homepage;
import pom.StaysPage;
import testBase.TestBase;

public class TestHomepage extends TestBase {


    @Test (dataProvider = "LocationsDataProvider", dataProviderClass = dataProviders.TestDataProviders.class, enabled = false)
    public void testSearchForAPlaceToGoWithFlexibleDates(String location, String checkinDate, String checkoutDate) throws InterruptedException {

        getHomepage().searchForAPlaceToGoWithFlexibleDates(location);

        String actualResults = driver.getTitle();
        String expectedResults = location + " · Stays · Airbnb";

        Assert.assertEquals(actualResults, expectedResults);

    }

    @Test (dataProvider = "LocationsDataProvider", dataProviderClass = dataProviders.TestDataProviders.class, enabled = true)
    public void testSearchForAPlaceToGoWithSpecificDates(String location, String checkinDate, String checkoutDate) throws InterruptedException {

        getHomepage().searchForAPlaceToGoWithSpecificDates(location, checkinDate, checkoutDate);

        String actualResults = driver.getTitle();
        String expectedResults = location + " · Stays · Airbnb";

        Assert.assertEquals(actualResults, expectedResults);

    }

    }


