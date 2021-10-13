package testBase;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class TestATTHomepage extends TestBase {


    @Test
    public void testHomePage() throws Exception {


        driver.get("www.att.com");
        WebElement shopNowOption = driver.findElement(By.cssSelector("#MOSAIC-GROUP-2-CTAS-container > a > span"));
        shopNowOption.click();

        WebElement choosePhoneGB = driver.findElement(By.cssSelector("#Capacity > div > div:nth-child(2) > label > div > div > div"));
        choosePhoneGB.click();

        WebElement choosePhoneColor = driver.findElement(By.cssSelector("#SierraBlue"));
        choosePhoneColor.click();

        WebElement pricingOptions = driver.findElement(By.cssSelector("#pricingTermsSelection > div > label:nth-child(2) > div > div > div > div:nth-child(1)"));
        pricingOptions.click();

        WebElement continueButton = driver.findElement(By.cssSelector("#pageContainer > div.jsx-253060046.jsx-2988516313.sticky-cta > div > div > div > div:nth-child(1) > div > div > button"));
        continueButton.click();
    }

    @Test
    public void testInternetPage() throws Exception {


        driver.get("www.att.com");
        WebElement internet = driver.findElement(By.cssSelector("#z1-tier1Nav > a:nth-child(3) > span"));
        internet.click();

        WebElement plansAndPricing = driver.findElement(By.cssSelector("#HEADBAND01 > span > a > div > svg > path"));
        plansAndPricing.click();

        WebElement shopInternet = driver.findElement(By.cssSelector("#HERO_PANEL22 > div > div.container.flex.hero-panel._2105J.\\}.undefined > div > div > span > a"));
        shopInternet.click();

        WebElement checkForService = driver.findElement(By.cssSelector("#streetAddrComboBox > div > div > div:nth-child(1) > div > input"));
        checkForService.sendKeys("123 Street Name, City, State, 01234");

        WebElement checkAvailability = driver.findElement(By.cssSelector("body > div:nth-child(38) > div:nth-child(2) > div > div > div._VhnE3 > div:nth-child(2) > div > div > div._382d1 > div._1hNID > button"));
        checkAvailability.click();
    }
}

