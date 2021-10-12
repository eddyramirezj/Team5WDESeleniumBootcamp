package testPom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import testBase.TestBase;

public class TestHomepage extends TestBase {



    @Test(dataProvider = "MySQLDataProvider", dataProviderClass = dataProviders.TestDataProviders.class, enabled = true)
        public void testSearchOnSearchBar(String test_id, String products) {
        getHomepage().searchOnSearchBar(products);

    }
        @Test
        public void testFashionPage() {

            driver.get("www.ebay.com");
            WebElement dropDown = driver.findElement(By.cssSelector("#mainContent > div.hl-cat-nav > ul > li:nth-child(4) > a"));
            dropDown.click();

            WebElement handbagsAndAccessories = driver.findElement(By.cssSelector("#mainContent > section.b-module.b-visualnav > div.b-visualnav__grid > a:nth-child(8) > div.b-visualnav__title"));
            handbagsAndAccessories.click();

            WebElement gucci = driver.findElement(By.cssSelector("#mainContent > section:nth-child(6) > div.b-visualnav__grid > a:nth-child(2) > div.b-visualnav__title"));
            gucci.click();

            WebElement shoulderBag = driver.findElement(By.cssSelector("#s0-27-9-0-1\\[1\\]-0-0-18-list > li:nth-child(3) > a > p"));
            shoulderBag.click();

            WebElement marmontBag = driver.findElement(By.cssSelector("#mainContent > section.b-module.b-module-related-event-listings.clearfix > ul > li:nth-child(5) > a > div.b-info > div.b-info__title"));
            marmontBag.click();

            WebElement buyItNow = driver.findElement(By.cssSelector("#binBtn_btn"));
            buyItNow.click();



        }

    @Test
    public void testSearchFunction() {

        driver.get("www.ebay.com");
        WebElement searchFunction = driver.findElement(By.cssSelector("#gh-ac"));
        searchFunction.sendKeys("PS5");

        WebElement enterSearch = driver.findElement(By.cssSelector("#gh-btn"));
        enterSearch.click();

        WebElement ps5 = driver.findElement(By.cssSelector("#srp-river-results > ul > li:nth-child(3) > div > div.s-item__info.clearfix > a > h3"));
        ps5.click();

        WebElement buyItNowOption = driver.findElement(By.cssSelector("#binBtn_btn"));
        buyItNowOption.click();


    }

    }
