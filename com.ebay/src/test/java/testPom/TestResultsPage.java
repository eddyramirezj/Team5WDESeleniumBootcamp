package testPom;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;
import pom.ResultsPage;
import testBase.TestBase;

public class TestResultsPage extends TestBase {


    @Test (dataProvider = "ProductsTestData", dataProviderClass = dataProviders.TestDataProviders.class, enabled = false)
    public void testAddToWatchList(String test_id, String products) {
        ResultsPage resultsPage = new ResultsPage();

        getHomepage().searchOnSearchBar(products);
        resultsPage.addToWatchList(products);

        webDriverWait.until(ExpectedConditions.titleIs("Sign in or Register | eBay"));
        String actualResults = driver.getTitle().toString();
        String expectedResults = "Sign in or Register | eBay";

        Assert.assertEquals(actualResults, expectedResults);

    }

    @Test (dataProvider = "ProductsTestData", dataProviderClass = dataProviders.TestDataProviders.class, enabled = true)
    public void testAddToCart(String test_id, String products) {

        ResultsPage resultsPage = new ResultsPage();

        try {
            getHomepage().searchOnSearchBar(products);
            resultsPage.addToCart(products);

            fluentWaitForElementToBeVisible(driver.findElement(By.xpath("//h2[text()='1 item added to cart']")));
        }

        catch (NoSuchElementException e) {
            e.printStackTrace();
            throw e;

        }
        Assert.assertTrue(isElementPresent(driver.findElement(By.xpath("//h2[text()='1 item added to cart']"))));

    }

}
