package testAttPOM;

import attPOM.AttHomePage;
import org.testng.annotations.Test;
import testBase.TestBase;
import utilsPNT1001.Helpers;

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





}
