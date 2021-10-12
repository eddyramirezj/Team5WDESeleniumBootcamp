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

    @DataProvider(name="BoaData")
    public Object[][] getLoginData(){

        Object[][] obj = new Object[3][2];

        obj[0][0] = "abcde";
        obj[0][1] = "1234#";

        obj[1][0] = "fghij";
        obj[1][1] = "5678#";

        obj[2][0] = "pqrst";
        obj[2][1] = "98765#";


        return obj;
    }


}
