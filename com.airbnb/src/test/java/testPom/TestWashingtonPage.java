package testPom;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import pom.Homepage;
import pom.WashingtonPage;
import testBase.TestBase;
//@Listeners(utilsPNT1001.CustomListeners.class)
//@Listeners(value=TestngReporter.class)


public class TestWashingtonPage extends TestBase {
    WashingtonPage washingtonPage = getWashingtonPage();
    Homepage homepage = getHomepage();




    public void testTitleIsCorrect() throws InterruptedException {
    Thread.sleep(4000);
    scrollJS(300);
    Thread.sleep(4000);

    homepage.goToWashingtonPage();
   verifyTrue(washingtonPage.verifyTitleIsCorrect_());

}

    @Test(alwaysRun = true)
    public void testIfElementPresent() throws InterruptedException {
        Thread.sleep(3000);
        scrollJS(300);
        Thread.sleep(3000);
        homepage.testIfLinkIsPresent();

//        isPresent(homepage.washingtonLink);
//homepage.testIfLinkIsPresent();
     /*   homepage.goToWashingtonPage();
        verifyTrue(washingtonPage.verifyTitleIsCorrect_());*/

    }







}
