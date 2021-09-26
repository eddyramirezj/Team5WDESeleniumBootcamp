package testPom;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import testBase.TestBase;

public class TestHomepage extends TestBase {



    @Test(dataProvider = "ProductsTestData", dataProviderClass = dataProviders.TestDataProviders.class, enabled = true)
        public void testSearchOnSearchBar(String test_id, String products) {
        getHomepage().searchOnSearchBar(products);

        String actualResults = driver.getTitle().toString();
        String expectedResults = products + " | eBay";

        Assert.assertEquals(actualResults, expectedResults);

    }

}
