package testPom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import pom.Homepage;
import testBase.TestBase;


public class TestHomepage extends TestBase {


    @Test(description = "02941", enabled = false)
    public void testCityNamesInExploreNearbySection() throws Exception {
        Homepage homepage = new Homepage();

        String path = System.getProperty("user.dir") + "/src/test/resources/AirbnbTestData.xlsx";
        String sheetName = "ExploreNearbyCityNames";

    }

    @Test(enabled = true)
    public void testCityURLsInExploreNearbySection() throws Exception {
        Homepage homepage = new Homepage();

        String path = System.getProperty("user.dir") + "/src/test/resources/AirbnbTestData.xlsx";
        String sheetName = "ExploreNearbyCityNamesLinks";

    }

    @Test
    public void testLogInPage() throws Exception {
        Homepage homepage = new Homepage();

        driver.get("www.airbnb.com");
        WebElement dropDown = driver.findElement(By.cssSelector("#field-guide-toggle > div._3hmsj > svg"));
        dropDown.click();

        WebElement logIn = driver.findElement(By.cssSelector("#field-guide-toggle"));
        logIn.click();

        WebElement phoneNumber = driver.findElement(By.cssSelector("#phoneInputphoneNumber"));
        phoneNumber.sendKeys("123456789");

        WebElement continueButton = driver.findElement(By.cssSelector("body > div:nth-child(24) > section > div > div > div._z4lmgp > div > div._12kfhdn > div > form > div > div._1n35162 > button > span._163rr5i > span"));
        continueButton.click();
    }

    @Test(enabled = true)
    public void testLasVegasStays() {


        driver.get("www.airbnb.com");
        WebElement exploreNearby = driver.findElement(By.cssSelector("#site-content > div > div > div:nth-child(2) > div > div:nth-child(2) > div > div > div > div:nth-child(3) > div > div > div:nth-child(3) > a > span._14aq8wg > div > picture > img"));
        exploreNearby.click();

        WebElement rooms = driver.findElement(By.cssSelector("#ExploreLayoutController > div._fninp > div:nth-child(1) > div._twmmpk > div > div:nth-child(2) > div > div > div:nth-child(3) > div > div > div > div > div:nth-child(12) > div > div > div._1e541ba5 > div > div > div > div._8s3ctt > a"));
        rooms.click();

        WebElement checkInDate = driver.findElement(By.cssSelector("<div class=\"_6gi1qsw notranslate\" data-testid=\"calendar-day-10/14/2021\" data-is-day-blocked=\"false\" style=\"width: 40px; height: 40px;\">14</div>"));
        checkInDate.click();

        WebElement checkOutDate = driver.findElement(By.cssSelector("#site-content > div > div:nth-child(1) > div:nth-child(3) > div > div._1s21a6e2 > div > div > div:nth-child(1) > div > div > div > div > div > div > div > div._p03egf > div > div:nth-child(2) > div > div._lxs2pm2 > div > div:nth-child(1) > div > div > div > div > div._14676s3 > div._1foj6yps > div > div:nth-child(2) > div > table > tbody > tr:nth-child(3) > td._xzo51qd > div"));
        checkOutDate.click();

        WebElement guestsPerRoom = driver.findElement(By.cssSelector("#GuestPicker-book_it-form-adults-stepper > button:nth-child(3) > span > svg > path"));
        guestsPerRoom.click();

        WebElement reserveRoom = driver.findElement(By.cssSelector("#site-content > div > div:nth-child(1) > div:nth-child(3) > div > div._1s21a6e2 > div > div > div:nth-child(1) > div > div > div > div > div > div > div._wgmchy > div._fz3zdn > form > button > span._163rr5i > span"));
        reserveRoom.click();


    }

    @Test(enabled = true)
    public void testLosAngelesStays() {


        driver.get("www.airbnb.com");
        WebElement exploreNearby = driver.findElement(By.cssSelector("#site-content > div > div > div:nth-child(2) > div > div:nth-child(2) > div > div > div > div:nth-child(3) > div > div > div:nth-child(1) > a > span._14aq8wg > div > picture > img"));
        exploreNearby.click();

        WebElement rooms = driver.findElement(By.cssSelector("#ExploreLayoutController > div._fninp > div:nth-child(1) > div._twmmpk > div > div:nth-child(2) > div > div > div:nth-child(3) > div > div > div > div > div:nth-child(3) > div > div > div._1e541ba5 > div > div > div > div._8s3ctt > div._1nz9l7j > div > div._e296pg > div._1mx6kqf > div > span > div > a"));
        rooms.click();

        WebElement checkInDate = driver.findElement(By.cssSelector("<div class=\"_6gi1qsw notranslate\" data-testid=\"calendar-day-10/14/2021\" data-is-day-blocked=\"false\" style=\"width: 40px; height: 40px;\">14</div>"));
        checkInDate.click();

        WebElement checkOutDate = driver.findElement(By.cssSelector("#site-content > div > div:nth-child(1) > div:nth-child(3) > div > div._1s21a6e2 > div > div > div:nth-child(1) > div > div > div > div > div > div > div > div._p03egf > div > div:nth-child(2) > div > div._lxs2pm2 > div > div:nth-child(1) > div > div > div > div > div._14676s3 > div._1foj6yps > div > div:nth-child(2) > div > table > tbody > tr:nth-child(3) > td._xzo51qd > div"));
        checkOutDate.click();

        WebElement guestsPerRoom = driver.findElement(By.cssSelector("#GuestPicker-book_it-form-adults-stepper > button:nth-child(3) > span > svg > path"));
        guestsPerRoom.click();

        WebElement reserveRoom = driver.findElement(By.cssSelector("#site-content > div > div:nth-child(1) > div:nth-child(3) > div > div._1s21a6e2 > div > div > div:nth-child(1) > div > div > div > div > div > div > div._wgmchy > div._fz3zdn > form > button > span._163rr5i > span"));
        reserveRoom.click();


    }
    @Test (enabled = true)
    public void testSanDiegoStays() {


        driver.get("www.airbnb.com");
        WebElement exploreNearby = driver.findElement(By.cssSelector("#site-content > div:nth-child(3) > div > div > div > div > div > div > div._1gw6tte > div > div > div > div:nth-child(3) > div > div > div:nth-child(2) > a > span._14aq8wg > div > picture > img"));
        exploreNearby.click();

        WebElement rooms = driver.findElement(By.cssSelector("#site-content > div:nth-child(5) > div > div > div > div > div > div > div._1gw6tte > div > div > div > div > div > div > div:nth-child(6) > div > div > div._1e541ba5 > div > div > div > div._8s3ctt > a"));
        rooms.click();

        WebElement checkInDate = driver.findElement(By.cssSelector("<div class=\"_6gi1qsw notranslate\" data-testid=\"calendar-day-10/14/2021\" data-is-day-blocked=\"false\" style=\"width: 40px; height: 40px;\">14</div>"));
        checkInDate.click();

        WebElement checkOutDate = driver.findElement(By.cssSelector("#site-content > div > div:nth-child(1) > div:nth-child(3) > div > div._1s21a6e2 > div > div > div:nth-child(1) > div > div > div > div > div > div > div > div._p03egf > div > div:nth-child(2) > div > div._lxs2pm2 > div > div:nth-child(1) > div > div > div > div > div._14676s3 > div._1foj6yps > div > div:nth-child(2) > div > table > tbody > tr:nth-child(3) > td._xzo51qd > div"));
        checkOutDate.click();

        WebElement guestsPerRoom = driver.findElement(By.cssSelector("#GuestPicker-book_it-form-adults-stepper > button:nth-child(3) > span > svg > path"));
        guestsPerRoom.click();

        WebElement reserveRoom = driver.findElement(By.cssSelector("#site-content > div > div:nth-child(1) > div:nth-child(3) > div > div._1s21a6e2 > div > div > div:nth-child(1) > div > div > div > div > div > div > div._wgmchy > div._fz3zdn > form > button > span._163rr5i > span"));
        reserveRoom.click();

    }
    }



