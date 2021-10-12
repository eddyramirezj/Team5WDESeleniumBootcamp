package testBase;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class TestHomepageExpedia extends TestBase {


    @Test
    public void testLogInPage() {

        driver.get("www.expedia.com");
        WebElement dropDown = driver.findElement(By.cssSelector("#location-field-destination-menu > div.uitk-menu-container.uitk-menu-open.uitk-menu-pos-left.uitk-menu-container-text-nowrap > ul > li:nth-child(1) > button > div > div:nth-child(1) > span > strong"));
        dropDown.click();

        WebElement checkInDate = driver.findElement(By.cssSelector("#wizard-hotel-pwa-v2-1 > div.uitk-layout-grid.uitk-layout-grid-gap-three.uitk-layout-grid-columns-small-2.uitk-layout-grid-columns-large-12.all-t-margin-three > div.uitk-layout-grid-item.uitk-layout-grid-item-columnspan-small-2.uitk-layout-grid-item-columnspan-large-5 > div > div > div:nth-child(1) > div > div.uitk-date-picker-menu-container.uitk-date-picker-menu-container-double.uitk-menu-container.uitk-menu-open.uitk-menu-pos-left.uitk-menu-container-autoposition.uitk-menu-container-text-nowrap > div > div.uitk-calendar > div.uitk-date-picker-menu-months-container > div:nth-child(1) > table > tbody > tr:nth-child(5) > td.uitk-date-picker-day-number.start.startSelected > button"));
       checkInDate.click();

        WebElement checkOutDate = driver.findElement(By.cssSelector("#wizard-hotel-pwa-v2-1 > div.uitk-layout-grid.uitk-layout-grid-gap-three.uitk-layout-grid-columns-small-2.uitk-layout-grid-columns-large-12.all-t-margin-three > div.uitk-layout-grid-item.uitk-layout-grid-item-columnspan-small-2.uitk-layout-grid-item-columnspan-large-5 > div > div > div:nth-child(1) > div > div.uitk-date-picker-menu-container.uitk-date-picker-menu-container-double.uitk-menu-container.uitk-menu-open.uitk-menu-pos-left.uitk-menu-container-autoposition.uitk-menu-container-text-nowrap > div > div.uitk-calendar > div.uitk-date-picker-menu-months-container > div:nth-child(1) > table > tbody > tr:nth-child(5) > td.uitk-date-picker-day-number.end.endSelected > button"));
        checkOutDate.click();

        WebElement doneButton = driver.findElement(By.cssSelector("#wizard-hotel-pwa-v2-1 > div.uitk-layout-grid.uitk-layout-grid-gap-three.uitk-layout-grid-columns-small-2.uitk-layout-grid-columns-large-12.all-t-margin-three > div.uitk-layout-grid-item.uitk-layout-grid-item-columnspan-small-2.uitk-layout-grid-item-columnspan-large-5 > div > div > div:nth-child(1) > div > div.uitk-date-picker-menu-container.uitk-date-picker-menu-container-double.uitk-menu-container.uitk-menu-open.uitk-menu-pos-left.uitk-menu-container-autoposition.uitk-menu-container-text-nowrap > div > div.uitk-flex.uitk-date-picker-menu-footer > button"));
        doneButton.click();

        WebElement searchButton = driver.findElement(By.cssSelector("#wizard-hotel-pwa-v2-1 > div.uitk-layout-grid.uitk-layout-grid-gap-three.uitk-layout-grid-columns-small-1.uitk-layout-grid-columns-medium-8.uitk-layout-grid-columns-large-12.uitk-spacing.uitk-spacing-padding-small-blockstart-three.uitk-spacing-padding-small-blockend-six.uitk-spacing-padding-medium-blockstart-three > div.uitk-layout-grid-item.uitk-layout-grid-item-columnspan-small-1.uitk-layout-grid-item-columnspan-medium-2.uitk-layout-grid-item-columnspan-large-2 > button"));
        searchButton.click();

        WebElement rooms = driver.findElement(By.cssSelector("#app-layer-base > div > main > div > div > div > section > div.uitk-spacing.search-results-listing.uitk-spacing-padding-small-block-three.uitk-spacing-padding-medium-blockstart-one.uitk-spacing-padding-large-blockstart-three > div > div.uitk-layout-grid-item.uitk-layout-grid-item-columnspan-3 > section.results > ol > li:nth-child(8) > div > a"));
        rooms.click();

        WebElement reserveRoom = driver.findElement(By.cssSelector("#app-layer-base > div > main > div > div > div > section > div.infosite__content.infosite__content--details > section.navigation-region.navigation-bar-region.constrained > div:nth-child(2) > div > div > div > div > button"));
        reserveRoom.click();


    }

    @Test
    public void testPackagesPage() {
        driver.get("www.expedia.com");

        WebElement packagesTab = driver.findElement(By.cssSelector("#wizardMainRegionV2 > div > div > div.uitk-layout-grid.uitk-layout-grid-columns-small-2.uitk-layout-grid-columns-large-12.wizardCard.all-t-padding-twelve.all-x-padding-six.s-x-padding-zero.s-t-padding-zero.SimpleContainer > div > div > ul > li.uitk-tab.active > a > span"));
        packagesTab.click();

        WebElement leavingFromTab = driver.findElement(By.cssSelector("#location-field-origin"));
        leavingFromTab.click();

        WebElement location = driver.findElement(By.cssSelector("#location-field-origin"));
        location.sendKeys("Los Angeles");

        WebElement goingToLocation = driver.findElement(By.cssSelector("#location-field-destination"));
        goingToLocation.sendKeys("New York");

        WebElement departureDate = driver.findElement(By.cssSelector("#wizard-package-pwa-1 > div.uitk-layout-grid.uitk-layout-grid-gap-three.uitk-layout-grid-columns-small-2.uitk-layout-grid-columns-medium-12.uitk-layout-grid-columns-large-12.uitk-spacing.uitk-spacing-margin-small-blockstart-three > div.uitk-layout-grid-item.uitk-layout-grid-item-columnspan-small-2.uitk-layout-grid-item-columnspan-medium-12.uitk-layout-grid-item-columnspan-large-4 > div > div > div:nth-child(1) > div > div.uitk-date-picker-menu-container.uitk-date-picker-menu-container-double.uitk-menu-container.uitk-menu-open.uitk-menu-pos-left.uitk-menu-container-autoposition.uitk-menu-container-text-nowrap > div > div.uitk-calendar > div.uitk-date-picker-menu-months-container > div:nth-child(1) > table > tbody > tr:nth-child(5) > td.uitk-date-picker-day-number.start.startSelected > button"));
        departureDate.click();

        WebElement returnDate = driver.findElement(By.cssSelector("#wizard-package-pwa-1 > div.uitk-layout-grid.uitk-layout-grid-gap-three.uitk-layout-grid-columns-small-2.uitk-layout-grid-columns-medium-12.uitk-layout-grid-columns-large-12.uitk-spacing.uitk-spacing-margin-small-blockstart-three > div.uitk-layout-grid-item.uitk-layout-grid-item-columnspan-small-2.uitk-layout-grid-item-columnspan-medium-12.uitk-layout-grid-item-columnspan-large-4 > div > div > div:nth-child(2) > div > div.uitk-date-picker-menu-container.uitk-date-picker-menu-container-double.uitk-menu-container.uitk-menu-open.uitk-menu-pos-left.uitk-menu-container-autoposition.uitk-menu-container-text-nowrap > div > div.uitk-calendar > div.uitk-date-picker-menu-months-container > div:nth-child(2) > table > tbody > tr:nth-child(1) > td.uitk-date-picker-day-number.end.endSelected.uitk-date-picker-first-of-month > button"));
        returnDate.click();

        WebElement searchButton = driver.findElement(By.cssSelector("#wizard-package-pwa-1 > div.uitk-layout-grid.uitk-layout-grid-gap-three.uitk-layout-grid-columns-small-1.uitk-layout-grid-columns-medium-8.uitk-layout-grid-columns-large-12.uitk-spacing.uitk-spacing-padding-small-blockstart-three.uitk-spacing-padding-small-blockend-six.uitk-spacing-padding-medium-blockstart-three > div.uitk-layout-grid-item.uitk-layout-grid-item-columnspan-small-1.uitk-layout-grid-item-columnspan-medium-2.uitk-layout-grid-item-columnspan-large-2 > button"));
        searchButton.click();


    }
}
