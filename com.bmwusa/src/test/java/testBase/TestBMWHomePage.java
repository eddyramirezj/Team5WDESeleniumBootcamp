package testBase;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class TestBMWHomePage extends TestBase{

    @Test
    public void testHomePage() throws Exception {


        driver.get("www.bmwusa.com");
        WebElement dropDownMenu = driver.findElement(By.cssSelector("body > div:nth-child(3) > div > div > div.globalnav-container.bmw-grid-row.bmw-grid-middle-default > div.bmw-grid-col-default-21.bmw-grid-col-md-22.bmw-grid-col-lg-9.bmw-grid-col-xl-11.globalnav-primary-dealer > div > div.globalnav-primary-dealer__mobile-nav-btn-holder > button > div > span"));
        dropDownMenu.click();

        WebElement creditCardTypes = driver.findElement(By.cssSelector("#travelRewardsCards"));
        creditCardTypes.click();

        WebElement checkForOffers = driver.findElement(By.cssSelector("#checkForOffers"));
        checkForOffers.click();

        WebElement pricingOptions = driver.findElement(By.cssSelector("#pricingTermsSelection > div > label:nth-child(2) > div > div > div > div:nth-child(1)"));
        pricingOptions.click();

        WebElement continueWithoutSignIn = driver.findElement(By.cssSelector("#noSignIn"));
        continueWithoutSignIn.click();
    }

    @Test
    public void testAutoLoans() throws Exception {


        driver.get("www.bankofamerica.com");
        WebElement autoLoans = driver.findElement(By.cssSelector("#navAutoLoans > span.title"));
        autoLoans.click();

        WebElement autoLoanRates = driver.findElement(By.cssSelector("#autoLoanRates"));
        autoLoanRates.click();

        WebElement selectState = driver.findElement(By.cssSelector("#stateSelectModal"));
        selectState.click();

        WebElement selectorSubmit = driver.findElement(By.cssSelector("#stateSelectorSubmit"));
        selectorSubmit.click();

        WebElement applyNow = driver.findElement(By.cssSelector("#apply_now"));
        applyNow.click();
    }
}


