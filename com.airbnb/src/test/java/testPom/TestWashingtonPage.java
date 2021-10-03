package testPom;

import org.testng.Assert;
import org.testng.annotations.Test;
import pom.Homepage;
import pom.WashingtonPage;
import testBase.TestBase;
//@Listeners(utilsPNT1001.CustomListeners.class)
//@Listeners(value=TestngReporter.class)


public class TestWashingtonPage extends TestBase {



    @Test(enabled = false)
    public void testNavigateToWashingtonPage() throws InterruptedException {
        scrollJS(300);
        Homepage homepage = new Homepage();
        homepage.goToWashingtonPage();
//        Thread.sleep(3000);
    }

    @Test(enabled = false)
    public void testTitleIsCorrect() throws InterruptedException {
        Homepage homepage = new Homepage();
        homepage.goToWashingtonPage();

        WashingtonPage washingtonPage = new WashingtonPage();
        Assert.assertTrue(washingtonPage.isTitleCorrect());

}

    @Test(enabled = false)
    public void testPrintTitle() throws InterruptedException {
        Homepage homepage = new Homepage();
        homepage.goToWashingtonPage();

        WashingtonPage washingtonPage = new WashingtonPage();
        verifyTrue(washingtonPage.isTitleCorrect_());

    }


    @Test(enabled = false)
    public void testClickOnButton() throws InterruptedException {
        Homepage homepage = new Homepage();
        homepage.goToWashingtonPage();

        WashingtonPage washingtonPage = new WashingtonPage();
        washingtonPage.unitTest();
        Thread.sleep(2000);
    }






}
