package dataProviders;


import base.MySQLConnection;
import org.testng.annotations.DataProvider;

import java.io.IOException;
import java.sql.SQLException;

public class TestDataProviders {


    @DataProvider(name="MySQLDataProvider")
    public Object[][] feedDP() throws SQLException, IOException, ClassNotFoundException {
        MySQLConnection mySQL = new MySQLConnection();
        String[][] data = mySQL.getDBValues("seleniumbootcamp.test_data3");
        Object[][] testData = (Object[][]) data;
        return testData;
    }

}
