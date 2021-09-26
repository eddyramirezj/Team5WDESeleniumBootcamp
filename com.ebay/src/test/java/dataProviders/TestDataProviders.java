package dataProviders;


import base.MySQLConnection;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.IOException;
import java.sql.SQLException;

public class TestDataProviders {


    @DataProvider(name="ProductsTestData")
    public Object[][] productsTestData() throws SQLException, IOException, ClassNotFoundException {
        MySQLConnection mySQL = new MySQLConnection();
        String[][] data = mySQL.getDBValues("seleniumbootcamp.test_data3");
        Object[][] testData = (Object[][]) data;
        return testData;
    }

    @DataProvider(name="RegisterInvalidTestData")
    public Object[][] registerInvalidTestData() throws SQLException, IOException, ClassNotFoundException {
        MySQLConnection mySQL = new MySQLConnection();
        String[][] data = mySQL.getDBValues("seleniumbootcamp.test_data4");
        Object[][] testData = (Object[][]) data;
        return testData;
    }

    @DataProvider(name="RegisterValidTestData")
    public Object[][] registerValidTestData() throws SQLException, IOException, ClassNotFoundException {
        MySQLConnection mySQL = new MySQLConnection();
        String[][] data = mySQL.getDBValues("seleniumbootcamp.test_data1");
        Object[][] testData = (Object[][]) data;
        return testData;
    }

    @DataProvider(name="RegisterBusinessAccountInvalidTestData")
    public Object[][] registerBusinessAccountWithInvalidTestData() throws SQLException, IOException, ClassNotFoundException {
        MySQLConnection mySQL = new MySQLConnection();
        String[][] data = mySQL.getDBValues("seleniumbootcamp.test_data6");
        Object[][] testData = (Object[][]) data;
        return testData;
    }

    @DataProvider(name="RegisterBusinessAccountValidTestData")
    public Object[][] registerBusinessAccountWithValidTestData() throws SQLException, IOException, ClassNotFoundException {
        MySQLConnection mySQL = new MySQLConnection();
        String[][] data = mySQL.getDBValues("seleniumbootcamp.test_data5");
        Object[][] testData = (Object[][]) data;
        return testData;
    }

}
