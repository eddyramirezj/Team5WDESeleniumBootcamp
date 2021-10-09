package dataProviders;


import base.DataReader;
import base.MySQLConnection;
import org.testng.annotations.DataProvider;
import testBase.TestBase;

import java.io.IOException;
import java.sql.SQLException;

import static base.BaseClass.dataReader;

public class TestDataProviders extends TestBase {


    private static String path = System.getProperty("user.dir") + "/src/test/resources/testData/xxxxxxxxxxxx.xlsx";

    @DataProvider(name="registerTestData")
    public Object[][] registerTestDataDP() throws IOException {
        dataReader = new DataReader();
        String sheetName = "register";

        Object[][] testData = dataReader.fileReaderArrayStringArraysXSSF(path, sheetName);
        return testData;
    }

}
