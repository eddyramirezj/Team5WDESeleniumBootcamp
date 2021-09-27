package testPom;

import base.DataReader;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;
import pom.Homepage;
import testBase.TestBase;

import java.io.IOException;

public class TestHomepage extends TestBase {


    @Test (enabled = false)
    public void testRegisterAccountWithValidData() throws IOException {

        String path = System.getProperty("user.dir") + "/src/test/resources/testData/registerPageTestData.xlsx";
        String sheetName = "testRegister";

        dataReader = new DataReader();
        String[][] testData = dataReader.fileReaderArrayStringArraysXSSF(path, sheetName);

        Homepage homepage = new Homepage();
        homepage.registerAnAccount(testData[0][0], testData[0][1]);



        WebElement loggedInConfirmation = homepage.loggedInConfirmation();

        Assert.assertTrue(loggedInConfirmation.isDisplayed());

    }


    @Test (enabled = false)
    public void testSignInWithValidData() throws IOException {

        String path = System.getProperty("user.dir") + "/src/test/resources/testData/signInPageTestData.xlsx";
        String sheetName = "testRegister";

        dataReader = new DataReader();
        String[][] testData = dataReader.fileReaderArrayStringArraysXSSF(path, sheetName);

        Homepage homepage = new Homepage();
        homepage.signIn(testData[0][0], testData[0][1]);

        WebElement loggedInConfirmation = homepage.loggedInConfirmation();

        Assert.assertTrue(loggedInConfirmation.isDisplayed());

    }

    @Test(dataProvider = "ProductsDataProvider", dataProviderClass = dataProviders.TestDataProviders.class, enabled = true)
    public void testSearchForProductOnSearchBar(String products, String title) {
        getHomepage().searchForProductOnSearchBar(products);

        String actualResults = driver.getTitle().toString();
        String expectedResults = title;

        Assert.assertEquals(actualResults, expectedResults);


    }


    @Test (enabled = false)
    public void testNavigateToYoutubeChannelOnAnotherTab() throws IOException {
        String path = System.getProperty("user.dir") + "/src/test/resources/testData/expectedConditionsTestData.xlsx";
        String sheetName = "expected_conditions";

        getHomepage().navigateToYoutubeChannel();

        dataReader = new DataReader();
        String[][] testData = dataReader.fileReaderArrayStringArraysXSSF(path, sheetName);

        String actualResults = driver.getTitle().toString();
        String expectedResults = testData[0][0];

        Assert.assertEquals(actualResults, expectedResults);

    }

}
