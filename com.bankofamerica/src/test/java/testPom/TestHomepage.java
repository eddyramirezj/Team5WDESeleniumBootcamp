package testPom;

import org.testng.Assert;
import org.testng.annotations.Test;
import testBase.TestBase;

public class TestHomepage extends TestBase {

//    @Test(dataProvider = "LocationsDataProvider", dataProviderClass = dataProviders.TestDataProviders.class, enabled = false)
//    public void testSearchForAPlaceToGoWithFlexibleDates(String location, String checkinDate, String checkoutDate) throws InterruptedException {
//
//        getHomepage().searchForAPlaceToGoWithFlexibleDates(location);
//
//        String actualResults = driver.getTitle();
//        String expectedResults = location + " · Stays · Airbnb";
//
//        Assert.assertEquals(actualResults, expectedResults);
//
//    }
    @Test
    public void testURLForCheckingAccountTab() {
        waitForElementToBeVisible(getHomepage().checkingAccountNavTab);
        String checkingURL = getHomepage().checkingAccountNavTab.getAttribute("href");
        String path = System.getProperty("user.dir") + "/src/test/resources/testData/boATestData.xls";
        writeIntoExcelFile(path,checkingURL);

    }

}
