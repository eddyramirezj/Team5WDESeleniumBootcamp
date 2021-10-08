package testPom;

import base.DataReader;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import pom.CreditCardsPage;
import pom.Homepage;
import testBase.TestBase;

import java.io.IOException;

public class TestCreditCards extends TestBase {

    String path = System.getProperty("user.dir") + "/src/test/resources/testData/boATestData2.xlsx";
    String sheetName = "numOfCreditCards";
    CreditCardsPage creditCardsPage;

    @Test (enabled = false)
    public void testNumOfNoAnnualFeeCCs() throws IOException {
        creditCardsPage = new CreditCardsPage();
        getHomepage().navigateToCreditCardsPage();
        creditCardsPage.clickOnViewAllCardsTab();
        creditCardsPage.openFilterCardsDropMenu();
        waitForElementToBeClickable(creditCardsPage.noAnnualFeeCheckbox);
        clickOnElement(creditCardsPage.noAnnualFeeCheckbox);
        creditCardsPage.clickOnViewCardsBtn();
        waitForElementToBeVisible(creditCardsPage.filterCardsCount);

        dataReader = new DataReader();
        String[][] testData = dataReader.fileReaderArrayStringArraysXSSF(path, sheetName);

        String actualResults = creditCardsPage.filterCardsCount.getText();
        String[] numOfResults = testData[0][0].split(".0");
        String expectedResults = numOfResults[0];

        Assert.assertEquals(actualResults, expectedResults);


    }
    @Test (enabled = false)
    public void testNumOfNoForeignTransFeeCCs() throws IOException {
        creditCardsPage = new CreditCardsPage();
        getHomepage().navigateToCreditCardsPage();
        creditCardsPage.clickOnViewAllCardsTab();
        creditCardsPage.openFilterCardsDropMenu();
        waitForElementToBeClickable(creditCardsPage.noForeignTransactionFeeCheckbox);
        clickOnElement(creditCardsPage.noForeignTransactionFeeCheckbox);
        creditCardsPage.clickOnViewCardsBtn();
        waitForElementToBeVisible(creditCardsPage.filterCardsCount);

        dataReader = new DataReader();
        String[][] testData = dataReader.fileReaderArrayStringArraysXSSF(path, sheetName);

        String actualResults = creditCardsPage.filterCardsCount.getText();
        String[] numOfResults = testData[1][0].split(".0");
        String expectedResults = numOfResults[0];

        Assert.assertEquals(actualResults, expectedResults);

    }

    @Test (enabled = false)
    public void testNumOfLowAPROnBalanceCCs() throws IOException {
        creditCardsPage = new CreditCardsPage();
        getHomepage().navigateToCreditCardsPage();
        creditCardsPage.clickOnViewAllCardsTab();
        creditCardsPage.openFilterCardsDropMenu();
        waitForElementToBeClickable(creditCardsPage.lowIntroAPROnBalanceCheckbox);
        clickOnElement(creditCardsPage.lowIntroAPROnBalanceCheckbox);
        creditCardsPage.clickOnViewCardsBtn();
        waitForElementToBeVisible(creditCardsPage.filterCardsCount);

        dataReader = new DataReader();
        String[][] testData = dataReader.fileReaderArrayStringArraysXSSF(path, sheetName);

        String actualResults = creditCardsPage.filterCardsCount.getText();
        String[] numOfResults = testData[2][0].split(".0");
        String expectedResults = numOfResults[0];

        Assert.assertEquals(actualResults, expectedResults);

    }

    @Test (enabled = false)
    public void testNumOfLowAPROnPurchasesCCs() throws IOException {
        creditCardsPage = new CreditCardsPage();
        getHomepage().navigateToCreditCardsPage();
        creditCardsPage.clickOnViewAllCardsTab();
        creditCardsPage.openFilterCardsDropMenu();
        waitForElementToBeClickable(creditCardsPage.lowIntroAPROnPurchasesCheckbox);
        clickOnElement(creditCardsPage.lowIntroAPROnPurchasesCheckbox);
        creditCardsPage.clickOnViewCardsBtn();
        waitForElementToBeVisible(creditCardsPage.filterCardsCount);

        dataReader = new DataReader();
        String[][] testData = dataReader.fileReaderArrayStringArraysXSSF(path, sheetName);

        String actualResults = creditCardsPage.filterCardsCount.getText();
        String[] numOfResults = testData[3][0].split(".0");
        String expectedResults = numOfResults[0];

        Assert.assertEquals(actualResults, expectedResults);

    }

    @Test (enabled = false)
    public void testNumOfPreferredRewardsCCs() throws IOException {
        creditCardsPage = new CreditCardsPage();
        getHomepage().navigateToCreditCardsPage();
        creditCardsPage.clickOnViewAllCardsTab();
        creditCardsPage.openFilterCardsDropMenu();
        waitForElementToBeClickable(creditCardsPage.preferredRewardsCheckbox);
        clickOnElement(creditCardsPage.preferredRewardsCheckbox);
        creditCardsPage.clickOnViewCardsBtn();
        waitForElementToBeVisible(creditCardsPage.filterCardsCount);

        dataReader = new DataReader();
        String[][] testData = dataReader.fileReaderArrayStringArraysXSSF(path, sheetName);

        String actualResults = creditCardsPage.filterCardsCount.getText() + ".0";

        String expectedResults = testData[4][0];

        Assert.assertEquals(actualResults, expectedResults);

    }

    @Test (enabled = false)
    public void testNumOfVisaCCs() throws IOException {
        creditCardsPage = new CreditCardsPage();
        getHomepage().navigateToCreditCardsPage();
        creditCardsPage.clickOnViewAllCardsTab();
        creditCardsPage.openFilterCardsDropMenu();
        waitForElementToBeClickable(creditCardsPage.visaRadioBtn);
        clickOnElement(creditCardsPage.visaRadioBtn);
        creditCardsPage.clickOnViewCardsBtn();
        waitForElementToBeVisible(creditCardsPage.filterCardsCount);

        dataReader = new DataReader();
        String[][] testData = dataReader.fileReaderArrayStringArraysXSSF(path, sheetName);

        String actualResults = creditCardsPage.filterCardsCount.getText();
        String[] numOfResults = testData[5][0].split(".0");
        String expectedResults = numOfResults[0];

        Assert.assertEquals(actualResults, expectedResults);

    }

    @Test (enabled = false)
    public void testNumOfMastercardCCs() throws IOException {
        creditCardsPage = new CreditCardsPage();
        getHomepage().navigateToCreditCardsPage();
        creditCardsPage.clickOnViewAllCardsTab();
        creditCardsPage.openFilterCardsDropMenu();
        waitForElementToBeClickable(creditCardsPage.mastercardRadioBtn);
        clickOnElement(creditCardsPage.mastercardRadioBtn);
        creditCardsPage.clickOnViewCardsBtn();
        waitForElementToBeVisible(creditCardsPage.filterCardsCount);

        dataReader = new DataReader();
        String[][] testData = dataReader.fileReaderArrayStringArraysXSSF(path, sheetName);

        String actualResults = creditCardsPage.filterCardsCount.getText();
        String[] numOfResults = testData[6][0].split(".0");
        String expectedResults = numOfResults[0];

        Assert.assertEquals(actualResults, expectedResults);

    }

    @Test (enabled = false)
    public void testSearchOnHeaderSearchBarFromCreditCardsPage() throws IOException {
        creditCardsPage = new CreditCardsPage();
        getHomepage().navigateToCreditCardsPage();
        String sheetName = "search";
        dataReader = new DataReader();
        String[][] testData = dataReader.fileReaderArrayStringArraysXSSF(path, sheetName);
        String search = testData[0][0];
        creditCardsPage.sendKeysToHeaderSearchBox(search);

        String actualResults = driver.findElement(By.cssSelector("a[name*='Search Module - Suggestion - "+ search + "']")).getAttribute("name");
        String expectedResults = "Search Module - Suggestion - credit cards";

        Assert.assertEquals(actualResults, expectedResults);

    }

    @Test (enabled = true)
    public void testChatBoxIsPresentOnCreditCardsPage() {
        creditCardsPage = new CreditCardsPage();
        getHomepage().navigateToCreditCardsPage();
        waitForElementToBeVisible(creditCardsPage.chatBox);
        Assert.assertTrue(isElementPresent(creditCardsPage.chatBox));
    }


}
