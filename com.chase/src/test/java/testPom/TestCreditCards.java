package testPom;

import base.DataReader;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pom.CreditCards;
import testBase.TestBase;

import java.io.IOException;

public class TestCreditCards extends TestBase {

    String path = System.getProperty("user.dir") + "/src/test/resources/testData/chaseCCTestData.xlsx";

    CreditCards creditCards;

    @Test (enabled = true)
    public void testOfferAPRAndAnnualFeeOfSlateEdgeCC() throws IOException {
        String sheetName = "slate_edge";
        creditCards = new CreditCards();

        dataReader = new DataReader();
        String[][] testData = dataReader.fileReaderArrayStringArraysXSSF(path, sheetName);
        webDriverWait.until(ExpectedConditions.visibilityOf(creditCards.slateEdgeOffer));

        SoftAssert softAssert = new SoftAssert();

        String actualOffer = creditCards.slateEdgeOffer.getText();
        String expectedOffer = testData[0][0];
        softAssert.assertEquals(actualOffer, expectedOffer);

        String actualAPR = creditCards.slateEdgeAPR.getText();
        String expectedAPR = testData[0][1];
        softAssert.assertEquals(actualAPR, expectedAPR);

        String actualAnnualFee = creditCards.slateEdgeAnnualFee.getText();
        String expectedAnnualFee = testData[0][2];
        softAssert.assertEquals(actualAnnualFee, expectedAnnualFee);

        softAssert.assertAll();

    }

    @Test (enabled = true)
    public void testOfferAPRAndAnnualFeeOfFreedomUnlimitedCC() throws IOException {
        String sheetName = "freedom_unlimited";
        creditCards = new CreditCards();

        dataReader = new DataReader();
        String[][] testData = dataReader.fileReaderArrayStringArraysXSSF(path, sheetName);
        webDriverWait.until(ExpectedConditions.visibilityOf(creditCards.freeUnlimitedOffer));

        SoftAssert softAssert = new SoftAssert();

        String actualOffer = creditCards.freeUnlimitedOffer.getText();
        String expectedOffer = testData[0][0];
        softAssert.assertEquals(actualOffer, expectedOffer);

        String actualAPR = creditCards.freeUnlimitedAPR.getText();
        String expectedAPR = testData[0][1];
        softAssert.assertEquals(actualAPR, expectedAPR);

        String actualAnnualFee = creditCards.freeUnlimitedAnnualFee.getText();
        String expectedAnnualFee = testData[0][2];
        softAssert.assertEquals(actualAnnualFee, expectedAnnualFee);

        softAssert.assertAll();

    }

    @Test (enabled = true)
    public void testOfferAPRAndAnnualFeeOfFreedomFlexCC() throws IOException {
        String sheetName = "freedom_flex";
        creditCards = new CreditCards();

        dataReader = new DataReader();
        String[][] testData = dataReader.fileReaderArrayStringArraysXSSF(path, sheetName);
        webDriverWait.until(ExpectedConditions.visibilityOf(creditCards.freeFlexOffer));

        SoftAssert softAssert = new SoftAssert();

        String actualOffer = creditCards.freeFlexOffer.getText();
        String expectedOffer = testData[0][0];
        softAssert.assertEquals(actualOffer, expectedOffer);

        String actualAPR = creditCards.freeFlexAPR.getText();
        String expectedAPR = testData[0][1];
        softAssert.assertEquals(actualAPR, expectedAPR);

        String actualAnnualFee = creditCards.freeFlexAnnualFee.getText();
        String expectedAnnualFee = testData[0][2];
        softAssert.assertEquals(actualAnnualFee, expectedAnnualFee);

        softAssert.assertAll();

    }

    @Test (enabled = true)
    public void testOfferAPRAndAnnualFeeOfFreedomStudentCC() throws IOException {
        String sheetName = "freedom_student";
        creditCards = new CreditCards();

        dataReader = new DataReader();
        String[][] testData = dataReader.fileReaderArrayStringArraysXSSF(path, sheetName);
        webDriverWait.until(ExpectedConditions.visibilityOf(creditCards.freeStudOffer));

        SoftAssert softAssert = new SoftAssert();

        String actualOffer = creditCards.freeStudOffer.getText();
        String expectedOffer = testData[0][0];
        softAssert.assertEquals(actualOffer, expectedOffer);

        String actualAPR = creditCards.freeStudAPR.getText();
        String expectedAPR = testData[0][1];
        softAssert.assertEquals(actualAPR, expectedAPR);

        String actualAnnualFee = creditCards.freeStudAnnualFee.getText();
        String expectedAnnualFee = testData[0][2];
        softAssert.assertEquals(actualAnnualFee, expectedAnnualFee);

        softAssert.assertAll();

    }

    @Test (enabled = true)
    public void testOfferAPRAndAnnualFeeOfSaphirePreferredCC() throws IOException {
        String sheetName = "saphire_preferred";
        creditCards = new CreditCards();

        dataReader = new DataReader();
        String[][] testData = dataReader.fileReaderArrayStringArraysXSSF(path, sheetName);
        webDriverWait.until(ExpectedConditions.visibilityOf(creditCards.saphPrefOffer));

        SoftAssert softAssert = new SoftAssert();

        String actualOffer = creditCards.saphPrefOffer.getText();
        String expectedOffer = testData[0][0];
        softAssert.assertEquals(actualOffer, expectedOffer);

        String actualAPR = creditCards.saphPrefAPR.getText();
        String expectedAPR = testData[0][1];
        softAssert.assertEquals(actualAPR, expectedAPR);

        String actualAnnualFee = creditCards.saphPrefAnnualFee.getText();
        String expectedAnnualFee = testData[0][2];
        softAssert.assertEquals(actualAnnualFee, expectedAnnualFee);

        softAssert.assertAll();

    }

    @Test (enabled = true)
    public void testOfferAPRAndAnnualFeeOfSaphireReserveCC() throws IOException {
        String sheetName = "saphire_reserve";
        creditCards = new CreditCards();

        dataReader = new DataReader();
        String[][] testData = dataReader.fileReaderArrayStringArraysXSSF(path, sheetName);
        webDriverWait.until(ExpectedConditions.visibilityOf(creditCards.saphResOffer));

        SoftAssert softAssert = new SoftAssert();

        String actualOffer = creditCards.saphResOffer.getText();
        String expectedOffer = testData[0][0];
        softAssert.assertEquals(actualOffer, expectedOffer);

        String actualAPR = creditCards.saphResAPR.getText();
        String expectedAPR = testData[0][1];
        softAssert.assertEquals(actualAPR, expectedAPR);

        String actualAnnualFee = creditCards.saphResAnnualFee.getText();
        String expectedAnnualFee = testData[0][2];
        softAssert.assertEquals(actualAnnualFee, expectedAnnualFee);

        softAssert.assertAll();

    }

    @Test (enabled = true)
    public void testOfferAPRAndAnnualFeeOfSouthwestPlusCC() throws IOException, InterruptedException {
        String sheetName = "southwest_plus";
        creditCards = new CreditCards();
//        Thread.sleep(50000);
        dataReader = new DataReader();
        String[][] testData = dataReader.fileReaderArrayStringArraysXSSF(path, sheetName);
        webDriverWait.until(ExpectedConditions.visibilityOf(creditCards.southPlusOffer));

        SoftAssert softAssert = new SoftAssert();

        String actualOffer = creditCards.southPlusOffer.getText();
        String expectedOffer = testData[0][0];
        softAssert.assertEquals(actualOffer, expectedOffer);

        String actualAPR = creditCards.southPlusAPR.getText();
        String expectedAPR = testData[0][1];
        softAssert.assertEquals(actualAPR, expectedAPR);

        String actualAnnualFee = creditCards.southPlusAnnualFee.getText();
        String expectedAnnualFee = testData[0][2];
        softAssert.assertEquals(actualAnnualFee, expectedAnnualFee);

        softAssert.assertAll();

    }

    @Test (enabled = true)
    public void testOfferAPRAndAnnualFeeOfSouthwestPriorityCC() throws IOException {
        String sheetName = "southwest_priority";
        creditCards = new CreditCards();

        dataReader = new DataReader();
        String[][] testData = dataReader.fileReaderArrayStringArraysXSSF(path, sheetName);
        webDriverWait.until(ExpectedConditions.visibilityOf(creditCards.southPriorOffer));

        SoftAssert softAssert = new SoftAssert();

        String actualOffer = creditCards.southPriorOffer.getText();
        String expectedOffer = testData[0][0];
        softAssert.assertEquals(actualOffer, expectedOffer);

        String actualAPR = creditCards.southPriorAPR.getText();
        String expectedAPR = testData[0][1];
        softAssert.assertEquals(actualAPR, expectedAPR);

        String actualAnnualFee = creditCards.southPriorAnnualFee.getText();
        String expectedAnnualFee = testData[0][2];
        softAssert.assertEquals(actualAnnualFee, expectedAnnualFee);

        softAssert.assertAll();

    }

    @Test (enabled = true)
    public void testOfferAPRAndAnnualFeeOfSouthwestPremierCC() throws IOException {
        String sheetName = "southwest_premier";
        creditCards = new CreditCards();

        dataReader = new DataReader();
        String[][] testData = dataReader.fileReaderArrayStringArraysXSSF(path, sheetName);
        webDriverWait.until(ExpectedConditions.visibilityOf(creditCards.southPremOffer));

        SoftAssert softAssert = new SoftAssert();

        String actualOffer = creditCards.southPremOffer.getText();
        String expectedOffer = testData[0][0];
        softAssert.assertEquals(actualOffer, expectedOffer);

        String actualAPR = creditCards.southPremAPR.getText();
        String expectedAPR = testData[0][1];
        softAssert.assertEquals(actualAPR, expectedAPR);

        String actualAnnualFee = creditCards.southPremAnnualFee.getText();
        String expectedAnnualFee = testData[0][2];
        softAssert.assertEquals(actualAnnualFee, expectedAnnualFee);

        softAssert.assertAll();

    }

    @Test (enabled = true)
    public void testOfferAPRAndAnnualFeeOfUnitedExplorerCC() throws IOException {
        String sheetName = "united_explorer";
        creditCards = new CreditCards();

        dataReader = new DataReader();
        String[][] testData = dataReader.fileReaderArrayStringArraysXSSF(path, sheetName);
        webDriverWait.until(ExpectedConditions.visibilityOf(creditCards.unitedExplorOffer));

        SoftAssert softAssert = new SoftAssert();

        String actualOffer = creditCards.unitedExplorOffer.getText();
        String expectedOffer = testData[0][0];
        softAssert.assertEquals(actualOffer, expectedOffer);

        String actualAPR = creditCards.unitedExplorAPR.getText();
        String expectedAPR = testData[0][1];
        softAssert.assertEquals(actualAPR, expectedAPR);

        String actualAnnualFee = creditCards.unitedExplorAnnualFee.getText();
        String expectedAnnualFee = testData[0][2];
        softAssert.assertEquals(actualAnnualFee, expectedAnnualFee);

        softAssert.assertAll();

    }


}
