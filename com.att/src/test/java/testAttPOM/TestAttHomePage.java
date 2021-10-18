package testAttPOM;

import attPOM.AttHomePage;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import testBase.TestBase;
import utilsPNT1001.Helpers;
import utilsPNT1001.TestDataProviders;

import java.util.Hashtable;

public class TestAttHomePage extends TestBase {
    Helpers helpers = new Helpers();



    @Test(enabled = false)
    public void testCellPhoneSearch(){
        AttHomePage attHomePage = new AttHomePage();
        String searchResult_ = attHomePage.cellPhoneSearch("iPhone 13");
        verifyTrue(searchResult_.contains("Showing 1-"));

    }

    @Test(enabled = false)
    public void testCheckInternetService(){
        AttHomePage attHomePage = new AttHomePage();
       attHomePage.checkInternetService(getProp("addressToCheck"));
//       waitForElementToBeVisible(attHomePage.addressChecked);
//       waitForElementToContainText(attHomePage.addressChecked, getProp("addressToCheck"));
        verifyTrue(attHomePage.addressChecked.getText().toLowerCase().contains("3904"));
    }

    @Test(enabled = false)
    public void testCheckPrepaidAlert(){
        AttHomePage attHomePage = new AttHomePage();
        attHomePage.prepaidOffer();
        verifyTrue(attHomePage.selectedPlanText.getText().toLowerCase().contains("8gb 12-month"));

    }

    @Test(enabled = false)
    public void testWirelessOffer(){
        AttHomePage attHomePage = new AttHomePage();
        attHomePage.wirelessOffer();
        verifyTrue(attHomePage.dialogBoxText.getText().toLowerCase().contains("what do you want"));

    }
    @Test(enabled = false)
    public void testInvalidSignInApproach1(){
        AttHomePage attHomePage = new AttHomePage();
        attHomePage.accountSignIn("TestUser1", "TestPassword1");
//        verifyTrue(attHomePage.signInErrorMsg.getText().toLowerCase().contains("reset your password"));
        verifyTrue(attHomePage.signInErrorMsg2.getText().toLowerCase().contains("something"));
    }

    @Test(enabled = false)
    public void testInvalidSignInApproach2(){
        AttHomePage attHomePage = new AttHomePage();
        attHomePage.accountSignIn(getProp("userId"), getProp("password"));
    }

    @Parameters({"userId", "password"})
    @Test(enabled = false)
    public void testInvalidSignInApproach3(String userId, String password){
        AttHomePage attHomePage = new AttHomePage();
        attHomePage.accountSignIn(userId, password);
        verifyTrue(attHomePage.signInErrorMsg2.getText().toLowerCase().contains("something"));
    }

    @Test(enabled = true, dataProvider = "sameClassDP_LoginData")
    public void testInvalidSignInApproach4(String userId, String password){
        AttHomePage attHomePage = new AttHomePage();
        attHomePage.accountSignIn(userId, password);
        verifyTrue(attHomePage.signInErrorMsg2.getText().toLowerCase().contains("something"));

    }

    @DataProvider(name="sameClassDP_LoginData")
    public Object[][] getLoginData(){

        Object[][] obj = new Object[3][2];

        obj[0][0] = "userIdSameClassDP1";
        obj[0][1] = "passwordSameClassDP1";

        obj[1][0] = "userIdSameClassDP2";
        obj[1][1] = "passwordSameClassDP2#";

        obj[2][0] = "userIdSameClassDP3";
        obj[2][1] = "passwordSameClassDP3#";


        return obj;
    }

    @Test(enabled = false, dataProvider = "loginData", dataProviderClass = utilsPNT1001.TestDataProviders.class)
    public void testInvalidSignInApproach5(String userId, String password){
        AttHomePage attHomePage = new AttHomePage();
        attHomePage.accountSignIn(userId, password);
        verifyTrue(attHomePage.signInErrorMsg2.getText().toLowerCase().contains("something"));

    }

    @Test(enabled = false)
    public void testInvalidSignInApproach6(){
        AttHomePage attHomePage = new AttHomePage();
        TestDataProviders testDataProviders = new TestDataProviders();
        attHomePage.accountSignIn(
                testDataProviders.attExcel.getCellData("testInvalidSignInApproach2",0,3 ),
                testDataProviders.attExcel.getCellData("testInvalidSignInApproach2",1,3 )


        );
    }

    @Test(enabled = false, dataProvider = "excelData", dataProviderClass = utilsPNT1001.TestDataProviders.class)
    public void testInvalidSignInApproach7(Hashtable<String, String> data){
//        NOTE: this testMethod name i.e. "testInvalidSignInApproach2" should be sheet name of the exel file.
        AttHomePage attHomePage = new AttHomePage();
        attHomePage.accountSignIn(data.get("userId"),data.get("password"));
        verifyTrue(attHomePage.signInErrorMsg2.getText().toLowerCase().contains("something"));
    }



}
