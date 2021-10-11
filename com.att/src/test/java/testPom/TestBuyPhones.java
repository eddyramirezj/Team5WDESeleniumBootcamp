package testPom;

import base.DataReader;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pom.BuyPhones;
import testBase.TestBase;

import java.io.IOException;

public class TestBuyPhones extends TestBase {

    String path = System.getProperty("user.dir") + "/src/test/resources/testData/attTestData.xlsx";

    @Test(enabled = false)
    public void testDisplayedPriceOfiPhone13ProMax() throws IOException {
        String sheetName = "phone_prices";

        dataReader = new DataReader();
        String[][] testData = dataReader.fileReaderArrayStringArraysXSSF(path, sheetName);
        getBuyPhones().clickOnShowPricesForTradeInSwitch();
        webDriverWait.until(ExpectedConditions.visibilityOf(getBuyPhones().iPhone13ProMaxPrice));

        String actualPrice = getBuyPhones().iPhone13ProMaxPrice.getText();
        String expectedPrice = testData[0][0];

        Assert.assertEquals(actualPrice, expectedPrice);

    }

    @Test(enabled = false)
    public void testDisplayedPriceOfiPhone13Pro() throws IOException {
        String sheetName = "phone_prices";

        dataReader = new DataReader();
        String[][] testData = dataReader.fileReaderArrayStringArraysXSSF(path, sheetName);
        getBuyPhones().clickOnShowPricesForTradeInSwitch();
        webDriverWait.until(ExpectedConditions.visibilityOf(getBuyPhones().iPhone13ProPrice));

        String actualPrice = getBuyPhones().iPhone13ProPrice.getText();
        String expectedPrice = testData[0][1];

        Assert.assertEquals(actualPrice, expectedPrice);

    }

    @Test(enabled = false)
    public void testDisplayedPriceOfiPhone13() throws IOException {
        String sheetName = "phone_prices";

        dataReader = new DataReader();
        String[][] testData = dataReader.fileReaderArrayStringArraysXSSF(path, sheetName);
        getBuyPhones().clickOnShowPricesForTradeInSwitch();
        webDriverWait.until(ExpectedConditions.visibilityOf(getBuyPhones().iPhone13Price));

        String actualPrice = getBuyPhones().iPhone13Price.getText();
        String expectedPrice = testData[0][2];

        Assert.assertEquals(actualPrice, expectedPrice);

    }

    @Test(enabled = false)
    public void testDisplayedPriceOfiPhone13mini() throws IOException {
        String sheetName = "phone_prices";

        dataReader = new DataReader();
        String[][] testData = dataReader.fileReaderArrayStringArraysXSSF(path, sheetName);
        getBuyPhones().clickOnShowPricesForTradeInSwitch();
        webDriverWait.until(ExpectedConditions.visibilityOf(getBuyPhones().iPhone13miniPrice));

        String actualPrice = getBuyPhones().iPhone13miniPrice.getText();
        String expectedPrice = testData[0][3];

        Assert.assertEquals(actualPrice, expectedPrice);

    }

    @Test(enabled = false)
    public void testDisplayedPriceOfGalaxyZFold35G() throws IOException {
        String sheetName = "phone_prices";

        dataReader = new DataReader();
        String[][] testData = dataReader.fileReaderArrayStringArraysXSSF(path, sheetName);
        getBuyPhones().clickOnShowPricesForTradeInSwitch();
        webDriverWait.until(ExpectedConditions.visibilityOf(getBuyPhones().galaxyZFold3G5Price));

        String actualPrice = getBuyPhones().galaxyZFold3G5Price.getText();
        String expectedPrice = testData[0][4];

        Assert.assertEquals(actualPrice, expectedPrice);

    }

    @Test(enabled = false)
    public void testDisplayedPriceOfGalaxyZFlip35G() throws IOException {
        String sheetName = "phone_prices";

        dataReader = new DataReader();
        String[][] testData = dataReader.fileReaderArrayStringArraysXSSF(path, sheetName);
        getBuyPhones().clickOnShowPricesForTradeInSwitch();
        webDriverWait.until(ExpectedConditions.visibilityOf(getBuyPhones().galaxyZFlip35GPrice));

        String actualPrice = getBuyPhones().galaxyZFlip35GPrice.getText();
        String expectedPrice = testData[0][5];

        Assert.assertEquals(actualPrice, expectedPrice);

    }

    @Test(enabled = false)
    public void testDisplayedPriceOfiPhone12ProMax() throws IOException {
        String sheetName = "phone_prices";

        dataReader = new DataReader();
        String[][] testData = dataReader.fileReaderArrayStringArraysXSSF(path, sheetName);
        getBuyPhones().clickOnShowPricesForTradeInSwitch();
        webDriverWait.until(ExpectedConditions.visibilityOf(getBuyPhones().iPhone12ProMaxPrice));

        String actualPrice = getBuyPhones().iPhone12ProMaxPrice.getText();
        String expectedPrice = testData[0][6];

        Assert.assertEquals(actualPrice, expectedPrice);

    }

    @Test(enabled = true)
    public void testDisplayedPriceOfiPhone11() throws IOException {
        String sheetName = "phone_prices";

        dataReader = new DataReader();
        String[][] testData = dataReader.fileReaderArrayStringArraysXSSF(path, sheetName);
        getBuyPhones().clickOnShowPricesForTradeInSwitch();
        scrollJS(1000);
        webDriverWait.until(ExpectedConditions.visibilityOf(getBuyPhones().iPhone11Price));

        String actualPrice = getBuyPhones().iPhone11Price.getText();
        String expectedPrice = testData[0][7];

        Assert.assertEquals(actualPrice, expectedPrice);

    }

    @Test(enabled = false)
    public void testDisplayedPriceOfiPhone12() throws IOException {
        String sheetName = "phone_prices";

        dataReader = new DataReader();
        String[][] testData = dataReader.fileReaderArrayStringArraysXSSF(path, sheetName);
        getBuyPhones().clickOnShowPricesForTradeInSwitch();
        webDriverWait.until(ExpectedConditions.visibilityOf(getBuyPhones().iPhone12Price));

        String actualPrice = getBuyPhones().iPhone12Price.getText();
        String expectedPrice = testData[0][8];

        Assert.assertEquals(actualPrice, expectedPrice);

    }

    @Test(enabled = true)
    public void testDisplayedPriceOfGalaxyS21Ultra5G() throws IOException {
        String sheetName = "phone_prices";

        dataReader = new DataReader();
        String[][] testData = dataReader.fileReaderArrayStringArraysXSSF(path, sheetName);
        getBuyPhones().clickOnShowPricesForTradeInSwitch();
        scrollJS(1000);
        webDriverWait.until(ExpectedConditions.visibilityOf(getBuyPhones().galaxyS21Ultra5GPrice));

        String actualPrice = getBuyPhones().galaxyS21Ultra5GPrice.getText();
        String expectedPrice = testData[0][9];

        Assert.assertEquals(actualPrice, expectedPrice);

    }

}
