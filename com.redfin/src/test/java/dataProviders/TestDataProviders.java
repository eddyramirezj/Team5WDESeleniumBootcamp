package dataProviders;


import base.DataReader;
import base.MySQLConnection;
import org.testng.annotations.DataProvider;
import testBase.TestBase;

import java.io.IOException;
import java.sql.SQLException;

public class TestDataProviders extends TestBase {


    private static String path = System.getProperty("user.dir") + "/src/test/resources/testData/redfinTestData.xlsx";

    @DataProvider(name="citiesDP")
    public Object[][] citiesDP() throws IOException {
        dataReader = new DataReader();
        String sheetName = "cities";

        Object[][] testData = dataReader.fileReaderArrayStringArraysXSSF(path, sheetName);
        return testData;
    }


}
