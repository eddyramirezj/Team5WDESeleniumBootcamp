package dataProviders;


import base.MySQLConnection;
import org.testng.annotations.DataProvider;
import testBase.TestBase;

import java.io.IOException;
import java.lang.reflect.Method;
import java.sql.SQLException;
import java.util.Hashtable;

public class TestDataProviders extends TestBase {


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

    @DataProvider(name = "excelData")
    public Object[][] getData(Method m) {

        String sheetName = m.getName();
        System.out.println(sheetName);
        int rows = boaExcel.getRowCount(sheetName);
        System.out.println(rows);
        int cols = boaExcel.getColumnCount(sheetName);
        System.out.println("columns: " + cols);

/***        Object[][] data = new Object[nInvocation][nParameters]; */
        Object[][] data = new Object[rows - 1][1];

        Hashtable<String, String> table = null;

        for (int rowNum = 2; rowNum <= rows; rowNum++) {

            table = new Hashtable<String, String>();

            for (int colNum = 0; colNum < cols; colNum++) {


                table.put(boaExcel.getCellData(sheetName, colNum, 1), boaExcel.getCellData(sheetName, colNum, rowNum));
                data[rowNum - 2][0] = table;


            }

        }

        return data;

    }


}
