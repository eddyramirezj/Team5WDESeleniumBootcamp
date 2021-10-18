package utilsPNT1001;


import base.BaseClass;
import base.MySQLConnection;
import org.testng.annotations.DataProvider;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Method;
import java.sql.SQLException;
import java.util.Hashtable;
import java.util.Properties;

public class TestDataProviders {

  /*  public static final String absPath = System.getProperty("user.dir");

    public String resourcesPath = absPath + "\\src\\test\\resources\\";
    public String boaORPath = absPath + "\\src\\test\\resources\\BoaOR.properties";
    //String excelPath=resourcesPath+"boaTestData.xlsx";
    public Properties boaOR = loadProp(boaORPath);
    String boaExcelPath=getProp("boaTestDataPath");
    public ExcelReader boaExcel = new ExcelReader(boaExcelPath);*/

    String attExcelPath ="C:\\Users\\nahid\\IdeaProjects\\Team5WDESeleniumBootcamp\\com.att\\src\\test\\resources\\attTestData.xlsx";
    public ExcelReader attExcel = new ExcelReader(attExcelPath);

 /*   public String getProp(String key){
        return boaOR.getProperty(key);

    }*/
    public Properties loadProp(String filePathWithExtension) {
        Properties prop = new Properties();
        try {
            InputStream ism = new FileInputStream(filePathWithExtension);
            prop.load(ism);
            ism.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return prop;
    }







    @DataProvider(name="MySQLDataProvider")
    public Object[][] feedDP() throws SQLException, IOException, ClassNotFoundException {
        MySQLConnection mySQL = new MySQLConnection();
        String[][] data = mySQL.getDBValues("seleniumbootcamp.test_data3");
        Object[][] testData = (Object[][]) data;
        return testData;
    }

    @DataProvider(name="loginData")
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



    /***        NOTE: sheetName must be same as the TestCase Method name */
    @DataProvider(name = "excelData")
    public Object[][] getData(Method m) {

        String sheetName = m.getName();
        System.out.println(sheetName);
        int rows = attExcel.getRowCount(sheetName);
        System.out.println(rows);
        int cols = attExcel.getColumnCount(sheetName);
        System.out.println("columns: " + cols);

/***        Object[][] data = new Object[nInvocation][nParameters]; */
        Object[][] data = new Object[rows - 1][1];

        Hashtable<String, String> table = null;

        for (int rowNum = 2; rowNum <= rows; rowNum++) {

            table = new Hashtable<String, String>();

            for (int colNum = 0; colNum < cols; colNum++) {


                table.put(attExcel.getCellData(sheetName, colNum, 1), attExcel.getCellData(sheetName, colNum, rowNum));
                data[rowNum - 2][0] = table;


            }

        }

        return data;

    }


}
