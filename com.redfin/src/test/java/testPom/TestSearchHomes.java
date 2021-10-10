package testPom;

import base.DataReader;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import pom.SearchHomes;
import testBase.TestBase;

import java.io.IOException;
import java.util.List;

public class TestSearchHomes extends TestBase {

    String path = System.getProperty("user.dir") + "/src/test/resources/testData/redfinTestData.xlsx";
    SearchHomes searchHomes;

    @Test(enabled = false)
    public void testSearchWith3bathsAndAllPropertyTypeFilters() throws IOException {
        String sheetName = "cities";
        searchHomes = new SearchHomes();
        dataReader = new DataReader();
        String[][] testData = dataReader.fileReaderArrayStringArraysXSSF(path, sheetName);

        getHomepage().searchForHomes(testData[0][0]);

        String initialResults = searchHomes.getCurrentHomeResults();

        searchHomes.clickOnMoreFiltersTab().addBaths().addBaths().addBaths().addBaths().addBaths()
                        .selectPropertyTypeHouse().selectPropertyTypeTownhouse().selectPropertyTypeCondo()
                        .selectPropertyTypeLand().selectPropertyTypeMultiFamily().selectPropertyTypeManufactured()
                        .selectPropertyTypeCoop().selectPropertyTypeOther().clickOnApplyFilters();

        String filteredResults = searchHomes.getCurrentHomeResults();
        String actualResults = "";

        while (filteredResults.equals(initialResults)) {
            filteredResults = searchHomes.getCurrentHomeResults();
            actualResults = searchHomes.getCurrentHomeResults() + ".0";
        }
        String sheetName2 = "filtered_results";
        String[][] testData2 = dataReader.fileReaderArrayStringArraysXSSF(path, sheetName2);
        String expectedResults = testData2[0][0];

        Assert.assertEquals(actualResults, expectedResults);

    }

    @Test(enabled = false)
    public void testSearchWitMaxBaths() throws IOException {
        String sheetName = "cities";
        searchHomes = new SearchHomes();
        dataReader = new DataReader();
        String[][] testData = dataReader.fileReaderArrayStringArraysXSSF(path, sheetName);

        getHomepage().searchForHomes(testData[0][0]);

        String initialResults = searchHomes.getCurrentHomeResults();

        searchHomes.clickOnMoreFiltersTab().addBaths().addBaths().addBaths().addBaths().addBaths()
                .addBaths().addBaths().addBaths().clickOnApplyFilters();

        String filteredResults = searchHomes.getCurrentHomeResults();
        String actualResults = "";

        while (filteredResults.equals(initialResults)) {
            filteredResults = searchHomes.getCurrentHomeResults();
            actualResults = searchHomes.getCurrentHomeResults() + ".0";
        }
        String sheetName2 = "filtered_results";
        String[][] testData2 = dataReader.fileReaderArrayStringArraysXSSF(path, sheetName2);
        String expectedResults = testData2[0][1];

        Assert.assertEquals(actualResults, expectedResults);

    }

    @Test(enabled = true)
    public void testSearchForPropertyTypeHouse() throws IOException {
        String sheetName = "cities";
        searchHomes = new SearchHomes();
        dataReader = new DataReader();
        String[][] testData = dataReader.fileReaderArrayStringArraysXSSF(path, sheetName);

        getHomepage().searchForHomes(testData[0][0]);

        String initialResults = searchHomes.getCurrentHomeResults();

        searchHomes.clickOnMoreFiltersTab().selectPropertyTypeHouse().clickOnApplyFilters();

        String filteredResults = searchHomes.getCurrentHomeResults();
        String actualResults = "";

        while (filteredResults.equals(initialResults)) {
            filteredResults = searchHomes.getCurrentHomeResults();
            actualResults = searchHomes.getCurrentHomeResults();
        }
        String sheetName2 = "filtered_results";
        String[][] testData2 = dataReader.fileReaderArrayStringArraysXSSF(path, sheetName2);
        String expectedResults = testData2[0][2];

        Assert.assertEquals(actualResults, expectedResults);

    }
    @Test(enabled = true)
    public void testSearchForPropertyTypeTownhouse() throws IOException {
        String sheetName = "cities";
        searchHomes = new SearchHomes();
        dataReader = new DataReader();
        String[][] testData = dataReader.fileReaderArrayStringArraysXSSF(path, sheetName);

        getHomepage().searchForHomes(testData[0][0]);

        String initialResults = searchHomes.getCurrentHomeResults();

        searchHomes.clickOnMoreFiltersTab().selectPropertyTypeTownhouse().clickOnApplyFilters();

        String filteredResults = searchHomes.getCurrentHomeResults();
        String actualResults = "";

        while (filteredResults.equals(initialResults)) {
            filteredResults = searchHomes.getCurrentHomeResults();
            actualResults = searchHomes.getCurrentHomeResults();
        }
        String sheetName2 = "filtered_results";
        String[][] testData2 = dataReader.fileReaderArrayStringArraysXSSF(path, sheetName2);
        String expectedResults = testData2[0][3];

        Assert.assertEquals(actualResults, expectedResults);

    }
    @Test(enabled = true)
    public void testSearchForPropertyTypeCondo() throws IOException {
        String sheetName = "cities";
        searchHomes = new SearchHomes();
        dataReader = new DataReader();
        String[][] testData = dataReader.fileReaderArrayStringArraysXSSF(path, sheetName);

        getHomepage().searchForHomes(testData[0][0]);

        String initialResults = searchHomes.getCurrentHomeResults();

        searchHomes.clickOnMoreFiltersTab().selectPropertyTypeCondo().clickOnApplyFilters();

        String filteredResults = searchHomes.getCurrentHomeResults();
        String actualResults = "";

        while (filteredResults.equals(initialResults)) {
            filteredResults = searchHomes.getCurrentHomeResults();
            actualResults = searchHomes.getCurrentHomeResults();
        }
        String sheetName2 = "filtered_results";
        String[][] testData2 = dataReader.fileReaderArrayStringArraysXSSF(path, sheetName2);
        String expectedResults = testData2[0][4];

        Assert.assertEquals(actualResults, expectedResults);

    }
    @Test(enabled = true)
    public void testSearchForPropertyTypeLand() throws IOException {
        String sheetName = "cities";
        searchHomes = new SearchHomes();
        dataReader = new DataReader();
        String[][] testData = dataReader.fileReaderArrayStringArraysXSSF(path, sheetName);

        getHomepage().searchForHomes(testData[0][0]);

        String initialResults = searchHomes.getCurrentHomeResults();

        searchHomes.clickOnMoreFiltersTab().selectPropertyTypeLand().clickOnApplyFilters();

        String filteredResults = searchHomes.getCurrentHomeResults();
        String actualResults = "";

        while (filteredResults.equals(initialResults)) {
            filteredResults = searchHomes.getCurrentHomeResults();
            actualResults = searchHomes.getCurrentHomeResults();
        }
        String sheetName2 = "filtered_results";
        String[][] testData2 = dataReader.fileReaderArrayStringArraysXSSF(path, sheetName2);
        String expectedResults = testData2[0][5];

        Assert.assertEquals(actualResults, expectedResults);

    }
    @Test(enabled = true)
    public void testSearchForPropertyTypeMultiFamily() throws IOException {
        String sheetName = "cities";
        searchHomes = new SearchHomes();
        dataReader = new DataReader();
        String[][] testData = dataReader.fileReaderArrayStringArraysXSSF(path, sheetName);

        getHomepage().searchForHomes(testData[0][0]);

        String initialResults = searchHomes.getCurrentHomeResults();

        searchHomes.clickOnMoreFiltersTab().selectPropertyTypeMultiFamily().clickOnApplyFilters();

        String filteredResults = searchHomes.getCurrentHomeResults();
        String actualResults = "";

        while (filteredResults.equals(initialResults)) {
            filteredResults = searchHomes.getCurrentHomeResults();
            actualResults = searchHomes.getCurrentHomeResults();
        }
        String sheetName2 = "filtered_results";
        String[][] testData2 = dataReader.fileReaderArrayStringArraysXSSF(path, sheetName2);
        String expectedResults = testData2[0][6];

        Assert.assertEquals(actualResults, expectedResults);

    }
    @Test(enabled = true)
    public void testSearchForPropertyTypeManufactured() throws IOException {
        String sheetName = "cities";
        searchHomes = new SearchHomes();
        dataReader = new DataReader();
        String[][] testData = dataReader.fileReaderArrayStringArraysXSSF(path, sheetName);

        getHomepage().searchForHomes(testData[0][0]);

        String initialResults = searchHomes.getCurrentHomeResults();

        searchHomes.clickOnMoreFiltersTab().selectPropertyTypeManufactured().clickOnApplyFilters();

        String filteredResults = searchHomes.getCurrentHomeResults();
        String actualResults = "";

        while (filteredResults.equals(initialResults)) {
            filteredResults = searchHomes.getCurrentHomeResults();
            actualResults = searchHomes.getCurrentHomeResults();
        }
        String sheetName2 = "filtered_results";
        String[][] testData2 = dataReader.fileReaderArrayStringArraysXSSF(path, sheetName2);
        String expectedResults = testData2[0][7];

        Assert.assertEquals(actualResults, expectedResults);

    }
    @Test(enabled = true)
    public void testSearchForPropertyTypeCoop() throws IOException {
        String sheetName = "cities";
        searchHomes = new SearchHomes();
        dataReader = new DataReader();
        String[][] testData = dataReader.fileReaderArrayStringArraysXSSF(path, sheetName);

        getHomepage().searchForHomes(testData[0][0]);

        String initialResults = searchHomes.getCurrentHomeResults();

        searchHomes.clickOnMoreFiltersTab().selectPropertyTypeCoop().clickOnApplyFilters();

        String filteredResults = searchHomes.getCurrentHomeResults();
        String actualResults = "";

        while (filteredResults.equals(initialResults)) {
            filteredResults = searchHomes.getCurrentHomeResults();
            actualResults = searchHomes.getCurrentHomeResults();
        }
        String sheetName2 = "filtered_results";
        String[][] testData2 = dataReader.fileReaderArrayStringArraysXSSF(path, sheetName2);
        String expectedResults = testData2[0][8];

        Assert.assertEquals(actualResults, expectedResults);

    }
    @Test(enabled = true)
    public void testSearchForPropertyTypeOther() throws IOException {
        String sheetName = "cities";
        searchHomes = new SearchHomes();
        dataReader = new DataReader();
        String[][] testData = dataReader.fileReaderArrayStringArraysXSSF(path, sheetName);

        getHomepage().searchForHomes(testData[0][0]);

        String initialResults = searchHomes.getCurrentHomeResults();

        searchHomes.clickOnMoreFiltersTab().selectPropertyTypeOther().clickOnApplyFilters();

        String filteredResults = searchHomes.getCurrentHomeResults();
        String actualResults = "";

        while (filteredResults.equals(initialResults)) {
            filteredResults = searchHomes.getCurrentHomeResults();
            actualResults = searchHomes.getCurrentHomeResults();
        }
        String sheetName2 = "filtered_results";
        String[][] testData2 = dataReader.fileReaderArrayStringArraysXSSF(path, sheetName2);
        String expectedResults = testData2[0][9];

        Assert.assertEquals(actualResults, expectedResults);

    }


}
