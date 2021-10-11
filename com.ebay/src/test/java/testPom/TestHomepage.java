package testPom;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import testBase.TestBase;

public class TestHomepage extends TestBase {



    @Test(dataProvider = "MySQLDataProvider", dataProviderClass = dataProviders.TestDataProviders.class, enabled = true)
        public void testSearchOnSearchBar(String test_id, String products) {
        getHomepage().searchOnSearchBar(products);


    }

}
