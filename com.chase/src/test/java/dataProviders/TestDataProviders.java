package dataProviders;


import base.DataReader;
import base.MySQLConnection;
import org.testng.annotations.DataProvider;
import testBase.TestBase;

import java.io.IOException;
import java.sql.SQLException;

public class TestDataProviders extends TestBase {


    private static String path = System.getProperty("user.dir") + "/src/test/resources/testData/chaseCCTestData.xlsx";

    @DataProvider(name="slateEdgeDP")
    public Object[][] slateEdgeDP() throws IOException {
        dataReader = new DataReader();
        String sheetName = "slate_edge";

        Object[][] testData = dataReader.fileReaderArrayStringArraysXSSF(path, sheetName);
        return testData;
    }

    @DataProvider(name="freedomUnlimitedDP")
    public Object[][] freedomUnlimitedDP() throws IOException {
        dataReader = new DataReader();
        String sheetName = "freedom_unlimited";

        Object[][] testData = dataReader.fileReaderArrayStringArraysXSSF(path, sheetName);
        return testData;
    }

    @DataProvider(name="freedomFlexDP")
    public Object[][] freedomFlexDP() throws IOException {
        dataReader = new DataReader();
        String sheetName = "freedom_flex";

        Object[][] testData = dataReader.fileReaderArrayStringArraysXSSF(path, sheetName);
        return testData;
    }

    @DataProvider(name="freedomStudentDP")
    public Object[][] freedomStudentDP() throws IOException {
        dataReader = new DataReader();
        String sheetName = "freedom_student";

        Object[][] testData = dataReader.fileReaderArrayStringArraysXSSF(path, sheetName);
        return testData;
    }

    @DataProvider(name="saphirePreferredDP")
    public Object[][] saphirePreferredDP() throws IOException {
        dataReader = new DataReader();
        String sheetName = "saphire_preferred";

        Object[][] testData = dataReader.fileReaderArrayStringArraysXSSF(path, sheetName);
        return testData;
    }

    @DataProvider(name="saphireReserveDP")
    public Object[][] saphireReserveDP() throws IOException {
        dataReader = new DataReader();
        String sheetName = "saphire_reserve";

        Object[][] testData = dataReader.fileReaderArrayStringArraysXSSF(path, sheetName);
        return testData;
    }

    @DataProvider(name="southwestPlusDP")
    public Object[][] southwestPlusDP() throws IOException {
        dataReader = new DataReader();
        String sheetName = "southwest_plus";

        Object[][] testData = dataReader.fileReaderArrayStringArraysXSSF(path, sheetName);
        return testData;
    }

    @DataProvider(name="southwestPriorityDP")
    public Object[][] southwestPriorityDP() throws IOException {
        dataReader = new DataReader();
        String sheetName = "southwest_priority";

        Object[][] testData = dataReader.fileReaderArrayStringArraysXSSF(path, sheetName);
        return testData;
    }

    @DataProvider(name="southwestPremierDP")
    public Object[][] southwestPremierDP() throws IOException {
        dataReader = new DataReader();
        String sheetName = "southwest_premier";

        Object[][] testData = dataReader.fileReaderArrayStringArraysXSSF(path, sheetName);
        return testData;
    }

    @DataProvider(name="unitedExplorerDP")
    public Object[][] unitedExplorerDP() throws IOException {
        dataReader = new DataReader();
        String sheetName = "united_explorer";

        Object[][] testData = dataReader.fileReaderArrayStringArraysXSSF(path, sheetName);
        return testData;
    }


}
