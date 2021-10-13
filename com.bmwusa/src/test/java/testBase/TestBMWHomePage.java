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

        WebElement models = driver.findElement(By.cssSelector("body > div:nth-child(3) > div > div > div.globalnav-container.bmw-grid-row.bmw-grid-middle-default > div.bmw-grid-col-default-25.bmw-grid-col-lg-14.bmw-grid-col-xl-12.globalnav-primary__bar.globalnav-primary__bar--active > div > nav > ul > li:nth-child(1) > button > span"));
        models.click();

        WebElement x7 = driver.findElement(By.cssSelector("body > div:nth-child(3) > div > div > div.globalnav-primary-drop-down-nav-holder.globalnav-primary-drop-down-nav-holder--active > div.globalnav-primary-drop-down-nav__wrapper > div > div > div.vehicles.aem-GridColumn.aem-GridColumn--default--12.mobile--open-dropdown-mobile > div > div > div.globalnav-primary-vehicles__content-holder > div > div.globalnav-primary-vehicles__tab.globalnav-primary-vehicles__tab--active > div.globalnav-primary-vehicles__cars > div:nth-child(7) > a > div"));
        x7.click();

        WebElement alpinaXB7 = driver.findElement(By.cssSelector("#animation-container-47c7ab6a-bce8-4a87-a7c0-86a94b5ef1ab > div > div > div > div > div > div > a > div.standalone-vehicle-tile-cmp__cta-link > div"));
        alpinaXB7.click();

        WebElement testDrive = driver.findElement(By.cssSelector("body > div.content-footer__container > div.page-par.bmw-standard-page--no-offsets > div > div > div.localnav.aem-GridColumn--default--none.aem-GridColumn.aem-GridColumn--default--25.aem-GridColumn--offset--default--0 > div > div.globalnav-local__fixed-shell > div > div.globalnav-local__cta.standalone-cta > div > section > a"));
        testDrive.click();
    }

    @Test
    public void testBuildYourOwnOption() throws Exception {


        driver.get("www.bmwusa.com");
        WebElement buildYourOwnOption = driver.findElement(By.cssSelector("#animation-container-9e708801-276a-4497-81d5-579a4e205722 > div > div > div > div > div > div > section > a"));
        buildYourOwnOption.click();

        WebElement alpinaB8 = driver.findElement(By.cssSelector("#byo > div.byo-container-fluid > div:nth-child(16) > div:nth-child(5) > div > a"));
        alpinaB8.click();

        WebElement design = driver.findElement(By.cssSelector("#byo > div.model-variant > div.core-models > div > div:nth-child(2) > div.fuel-type-models.byo-col-default-offset-2.byo-col-default-19.byo-col-md-offset-1.byo-col-md-21.byo-col-lg-16 > div > div:nth-child(3) > div > a"));
        design.click();

        WebElement color = driver.findElement(By.cssSelector("#byo-studio-rail-exterior > div.byo-rail-list-view-items > div:nth-child(2) > div > div > div > div > div > div.byo-rail-option-selector__details > div.name.byo-core-type.label-2.theme-core"));
        color.click();

        WebElement wheels = driver.findElement(By.cssSelector("#byo-studio-rail-exterior > div.byo-rail-list-view-items > div > div.byo-rail-option-base.selected > div > div > div.byo-rail-option-selector__details > div.name.byo-core-type.label-2.theme-core"));
        wheels.click();

        WebElement upholstery = driver.findElement(By.cssSelector("#byo-studio-rail-interior > div.byo-rail-list-view-items > div > div > div:nth-child(4) > div > div > div.byo-rail-option-selector__details > div"));
        upholstery.click();

        WebElement trim = driver.findElement(By.cssSelector("#byo-studio-rail-interior > div.byo-rail-list-view-items > div > div.byo-rail-option-base.selected > div > div > div.byo-rail-option-selector__details > div.name.byo-core-type.label-2.theme-core"));
        trim.click();

        WebElement getYourQuote = driver.findElement(By.cssSelector("#Studio > div.byo-row.absolute-stage.canScroll > div > div.stage-container.summary > div:nth-child(1) > div > div > div.byo-summary-rail.byo-col-default-23.byo-col-md-10.byo-col-lg-8.dealer-alt > div.column-bottom > div:nth-child(2) > a"));
        getYourQuote.click();

    }
}


