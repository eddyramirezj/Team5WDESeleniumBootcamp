package testAttPOM;

import attPOM.AttHomePage;
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
    public void testAccountSignIn(){
        AttHomePage attHomePage = new AttHomePage();
        attHomePage.accountSignIn("TestUser1", "TestPassword1");
//        verifyTrue(attHomePage.signInErrorMsg.getText().toLowerCase().contains("reset your password"));
        verifyTrue(attHomePage.signInErrorMsg2.getText().toLowerCase().contains("something"));

    }

    @Test(enabled = false, dataProvider = "loginData", dataProviderClass = utilsPNT1001.TestDataProviders.class)
    public void testInvalidSignInApproach1(String userId, String password){
        AttHomePage attHomePage = new AttHomePage();
        attHomePage.accountSignIn(userId, password);
        verifyTrue(attHomePage.signInErrorMsg2.getText().toLowerCase().contains("something"));

    }

    @Test(enabled = true, dataProvider = "excelData", dataProviderClass = utilsPNT1001.TestDataProviders.class)
    public void testInvalidSignInApproach2(Hashtable<String, String> data){
//        NOTE: this testMethod name i.e. "testInvalidSignInApproach2" should be sheet name of the exel file.
        AttHomePage attHomePage = new AttHomePage();
        attHomePage.accountSignIn(data.get("userId"),data.get("password"));
        verifyTrue(attHomePage.signInErrorMsg2.getText().toLowerCase().contains("something"));

    }



}
