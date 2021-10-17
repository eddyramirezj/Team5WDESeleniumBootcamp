package testBoaPom;

import com.beust.jcommander.Parameter;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import testBase.TestBase;

import java.util.Hashtable;

public class TestBoaHomePage extends TestBase {

    /****** Following test cases are to test INVALID LOGIN using 7 different approaches: *****/

    @Test(enabled = false)
    public void testInvalidLoginApproach1(){

    BoaHomePage boaHomePage = new BoaHomePage();
    boaHomePage.testLogin("WXYZ", "12345#");

}

    @Test(enabled = true)
    @Parameters({"ID", "Password"})
    public void testInvalidLoginApproach2(String ID, String Password){

        BoaHomePage boaHomePage = new BoaHomePage();
        boaHomePage.testLogin(ID, Password);

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
    public void testInvalidLoginApproach3(String s1, String s2){

        BoaHomePage boaHomePage = new BoaHomePage();
        boaHomePage.testLogin(s1,s2);

    }

    @Test(enabled = false, dataProvider = "BoaData", dataProviderClass = dataProviders.TestDataProviders.class)
    public void testInvalidLoginApproach4(String s1, String s2){

        BoaHomePage boaHomePage = new BoaHomePage();
        boaHomePage.testLogin(s1,s2);

    }


    @Test(enabled = false)
    public void testInvalidLoginApproach5(){

        BoaHomePage boaHomePage = new BoaHomePage();
        boaHomePage.testLogin(getProp("onlineId"), getProp("Password"));

    }
    @Test(enabled = false)
    public void testInvalidLoginApproach6(){

        BoaHomePage boaHomePage = new BoaHomePage();
        boaHomePage.testLogin(
                boaExcel.getCellData("loginNegativeTest",0,2 ),
                boaExcel.getCellData("loginNegativeTest",1,2 )


        );

    }

    @Test(enabled = false, dataProvider="excelData", dataProviderClass = dataProviders.TestDataProviders.class)
    public void testInvalidLoginApproach7(Hashtable<String, String> data){

        BoaHomePage boaHomePage = new BoaHomePage();
        boaHomePage.testLogin(data.get("OnlineId"),data.get("Password"));

    }








}
