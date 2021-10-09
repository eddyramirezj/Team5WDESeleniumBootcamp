package dataProviders;


import base.DataReader;
import base.MySQLConnection;
import org.testng.annotations.DataProvider;
import testBase.TestBase;

import java.io.IOException;
import java.sql.SQLException;

public class TestDataProviders extends TestBase {

    private static String path = System.getProperty("user.dir") + "/src/test/resources/testData/bmwRegisterTestData.xlsx";

    @DataProvider(name="registerValidTestData")
    public Object[][] registerValidTestDataDP() throws IOException {
        dataReader = new DataReader();
        String sheetName = "valid_credentials";

        Object[][] testData = dataReader.fileReaderArrayStringArraysXSSF(path, sheetName);
        return testData;
    }

    @DataProvider(name="invalidEmailTestData")
    public Object[][] invalidEmailTestDataDP() throws IOException {
        dataReader = new DataReader();
        String sheetName = "invalid_email";

        Object[][] testData = dataReader.fileReaderArrayStringArraysXSSF(path, sheetName);
        return testData;
    }

    @DataProvider(name="invalidPasswordTestData")
    public Object[][] invalidPasswordTestDataDP() throws IOException {
        dataReader = new DataReader();
        String sheetName = "invalid_password";

        Object[][] testData = dataReader.fileReaderArrayStringArraysXSSF(path, sheetName);
        return testData;
    }

    @DataProvider(name="differentPasswordTestData")
    public Object[][] differentPasswordTestDataDP() throws IOException {
        dataReader = new DataReader();
        String sheetName = "different_password";

        Object[][] testData = dataReader.fileReaderArrayStringArraysXSSF(path, sheetName);
        return testData;
    }

    @DataProvider(name="previouslyUsedPasswordTestData")
    public Object[][] previouslyUsedPasswordTestDataDP() throws IOException {
        dataReader = new DataReader();
        String sheetName = "used_password";

        Object[][] testData = dataReader.fileReaderArrayStringArraysXSSF(path, sheetName);
        return testData;
    }

    @DataProvider(name="validLoginTestData")
    public Object[][] validLoginTestDataDP() throws IOException {
        dataReader = new DataReader();
        String sheetName = "valid_login";

        Object[][] testData = dataReader.fileReaderArrayStringArraysXSSF(path, sheetName);
        return testData;
    }

    @DataProvider(name="invalidLoginTestData")
    public Object[][] invalidLoginTestDataDP() throws IOException {
        dataReader = new DataReader();
        String sheetName = "invalid_login";

        Object[][] testData = dataReader.fileReaderArrayStringArraysXSSF(path, sheetName);
        return testData;
    }

}
