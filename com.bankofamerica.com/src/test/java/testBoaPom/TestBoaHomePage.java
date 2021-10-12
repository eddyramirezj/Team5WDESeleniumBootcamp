package testBoaPom;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import testBase.TestBase;

public class TestBoaHomePage extends TestBase {

    @Test(enabled = false)
    public void testBoaLogin1(){

    BoaHomePage boaHomePage = new BoaHomePage();
    boaHomePage.testLogin("WXYZ", "12345#");

}

    @DataProvider(name="BoaData")
    public Object[][] getLoginData(){

        Object[][] obj = new Object[3][2];

        obj[0][0] = "ABCDE";
        obj[0][1] = "1234#";

        obj[1][0] = "FGHIJK";
        obj[1][1] = "5678#";

        obj[2][0] = "LMNOP";
        obj[2][1] = "98765#";


        return obj;
    }

    @Test(enabled = false, dataProvider = "BoaData")
    public void testBoaLogin2(String s1, String s2){

        BoaHomePage boaHomePage = new BoaHomePage();
        boaHomePage.testLogin(s1,s2);

    }

    @Test(enabled = false, dataProvider = "BoaData", dataProviderClass = dataProviders.TestDataProviders.class)
    public void testBoaLogin3(String s1, String s2){

        BoaHomePage boaHomePage = new BoaHomePage();
        boaHomePage.testLogin(s1,s2);

    }


    @Test(enabled = false)
    public void testBoaLogin4(){

        BoaHomePage boaHomePage = new BoaHomePage();
        boaHomePage.testLogin(getProp("onlineId"), getProp("Password"));

    }
    @Test(enabled = true)
    public void testBoaLogin5(){

        BoaHomePage boaHomePage = new BoaHomePage();
        boaHomePage.testLogin(
                boaExcel.getCellData("loginNegativeTest",0,2 ),
                boaExcel.getCellData("loginNegativeTest",1,2 )


        );

    }








}
