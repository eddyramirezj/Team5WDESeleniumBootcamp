package testPom;

import base.DataReader;
import org.testng.Assert;
import org.testng.annotations.Test;
import testBase.TestBase;

import java.io.IOException;

public class TestContactUs extends TestBase {

    String path = System.getProperty("user.dir") + "/src/test/resources/testData/bmwTestData.xlsx";
    String sheetName = "number";

    @Test(enabled = true)
    public void validateContactUsNumbers() throws IOException {
        getRegister().navigateToContactUs();
        waitForElementToBeVisible(getContactUs().customerRelationsNumber);

        dataReader = new DataReader();
        String[][] testData = dataReader.fileReaderArrayStringArraysXSSF(path, sheetName);

        String actualResults = getContactUs().customerRelationsNumber.getText();
        String expectedResults = testData[0][0];

        Assert.assertEquals(actualResults, expectedResults);

    }


}
