package testBase;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class TestBofAHomepage extends TestBase{


    @Test
    public void testHomePage() throws Exception {


        driver.get("www.bankofamerica.com");
        WebElement creditCards = driver.findElement(By.cssSelector("#navCreditCards > span.title"));
        creditCards.click();

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


