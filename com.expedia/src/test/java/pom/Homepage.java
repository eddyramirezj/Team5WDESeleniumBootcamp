package pom;

import base.BaseClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import pnt1001Utils.ExcelReader;
import utilsPNT1001.Helpers;

import java.io.IOException;
import java.util.Calendar;
import java.util.List;

public class Homepage extends BaseClass {

    public Homepage() {
        PageFactory.initElements(driver, this);
    }

Helpers helpers = new Helpers();

    @FindBy(xpath = "//button[@id='d1-btn']")
    public WebElement checkInButton;

    //    @FindBy(xpath = "//div[@data-stid='date-picker-month']")
//    @FindBy(xpath = "//div[contains(@data-stid,'date-picker-month']")
    @FindBy(xpath = "//div[@class='uitk-calendar']/child::div[2]/div")
    public WebElement datePickerMonth;

    //    @FindBy(xpath = "//h2[@class='uitk-date-picker-month-name uitk-type-medium']")
    @FindBy(xpath = "//div[@data-stid='date-picker-month']/h2")
    public List<WebElement> calendarMonthName;

    @FindBy(xpath = "//table[@class='uitk-date-picker-weeks']")
    public WebElement tableDates;

    @FindBy(xpath = "//div[@class='uitk-flex uitk-flex-justify-content-space-between uitk-date-picker-menu-pagination-container']")
    public WebElement yearMonthTitle;

    @FindBy(xpath = "//div[@class='uitk-date-picker-menu-months-container']")
    public WebElement monthMenu;

    @FindBy(xpath = "//button[@data-stid='date-picker-paging']")
    public WebElement nextPreviousButton;

    @FindBy(xpath = "//div[@class='uitk-calendar']/child::div[1]/button[1]")
    public WebElement previousButton;

    @FindBy(xpath = "//div[@class='uitk-calendar']/child::div[1]/button[2]")
    public WebElement nextButton;


    @FindBy(xpath = "//div[@class='uitk-calendar']/descendant::h2[position()=1]")
    public WebElement firstMonthYearTitle;

    @FindBy(xpath = "//div[@class='uitk-calendar']/child::div[2]/div[1]/table")
    public WebElement firstTable;

    @FindBy(xpath = "//div[@class='uitk-calendar']/child::div[2]/div[1]/table/tbody/tr/td")
    public WebElement firstTableDates;

    @FindBy(xpath = "//button[@aria-label='Going to']")
    public WebElement goingToButton;

    @FindBy(xpath = "//input[@id='location-field-destination']")
    public WebElement goingToTextFiled;

    @FindBy(xpath = "//div[@class='uitk-flex uitk-date-picker-menu-footer']/button")
    public WebElement doneButton;

    @FindBy(xpath = "//button[@data-testid='submit-button']")
    public WebElement searchButton;

    @FindBy(xpath = "//div[@class='uitk-error-summary']/h3")
    public WebElement errorMessage;

    @FindBy(xpath = "//form[@id='wizard-hotel-pwa-v2-1']/descendant::input[12]")
    public WebElement addCarCheckbox;

    @FindBy(xpath = "//button[text()='Sign in']")
    public WebElement signInButton;

    @FindBy(xpath = "//a[text()='Sign in']")
    public WebElement signInLink;

    List<WebElement> dates;

ExcelReader excel = new ExcelReader(expediaExcelPath);

public void goToSignInpage(){
    if(signInLink.isDisplayed()) {
//        clickOnElement(signInLink);
        clickJScript(signInLink);
    }else {
        clickJScript(signInButton);
        clickJScript(signInLink);
    }

}

    public void getExcelData1(){

        System.out.println(excel.getCellData("expedia",0,1));
        System.out.println(excel.getCellData("expedia",1,1));
        System.out.println(excel.getCellData("expedia",2,1));

        System.out.println(excel.getCellData("expedia",0,2));
        System.out.println(excel.getCellData("expedia",1,2));
        System.out.println(excel.getCellData("expedia",2,2));

    }


    public void staySearchFunction() {
        addCarCheckbox.click();
        clickOnElement(goingToButton);
        sendKeysToInput(goingToTextFiled, excel.getCellData("expedia",0,2));
        pressEnter(goingToTextFiled);



        clickOnElement(checkInButton);

        pickCalendarDate(firstMonthYearTitle,excel.getCellData("expedia",1,2));
        pickCalendarDate(firstMonthYearTitle,excel.getCellData("expedia",2,2));


        clickOnElement(doneButton);
        System.out.println("Clicked on done button");

        clickOnElement(searchButton);
        System.out.println("Clicked on search button");



    }

    public void pickCalendarDate(WebElement monthYearTitle, String mm_dd_yyyy){
        String calendarDate;

        String[] checkInDate_ = mm_dd_yyyy.split("/");

        String monthToBeSelected = getMonthName(Integer.parseInt(checkInDate_[0]));
        String dateToBeSelected = checkInDate_[1];
        String yearToBeSelected = checkInDate_[2];

//        clickOnElement(pickDateButton);


        List<WebElement> rows, cols;



        while (!monthYearTitle.getText().toString().contains(yearToBeSelected)) {
            clickOnElement(nextButton);
            System.out.println("clicked on next button to select correct check in year");
        }

        while (!monthYearTitle.getText().toString().contains(monthToBeSelected)) {
            clickOnElement(nextButton);
            System.out.println("clicked on next button to select correct check in month");
        }

        waitForStaleElement(monthYearTitle, driver, 5);
        waitForElementToBeVisible(monthYearTitle);


        waitForElementToBeVisible(datePickerMonth);
        waitForStaleElement(datePickerMonth, driver, 5);

        rows = datePickerMonth.findElements(By.tagName("tr"));



        for (int i = 1; i < rows.size(); i++) {
            cols = rows.get(i).findElements(By.tagName("button"));



            for (int k = 0; k < cols.size(); k++) {
                calendarDate = cols.get(k).getAttribute("data-day");

                if (calendarDate.equals(dateToBeSelected)) {

                    clickOn(cols.get(k), driver, 5);

                    System.out.println("date " + calendarDate + " was selected successfully");
                    break;

                }

            }
        }
    }

    public void selectDate4() {

        clickOnElement(goingToButton);
        sendKeysToInput(goingToTextFiled, "Dhaka (DAC - Shahjalal Intl.)");
        pressEnter(goingToTextFiled);

        clickOnElement(checkInButton);

        pickCalendarDate(firstMonthYearTitle,helpers.expediaOR.getProperty("checkInDate"));
        pickCalendarDate(firstMonthYearTitle,helpers.expediaOR.getProperty("checkOutDate"));


        clickOnElement(doneButton);
        System.out.println("Clicked on done button");
        clickOnElement(searchButton);
        System.out.println("Clicked on search button");



    }


    public void selectDate3() {

        String calendarDate;
        String checkInDate = helpers.expediaOR.getProperty("checkInDate");
        String[] checkInDate_ = checkInDate.split("/");

        String monthToBeSelected = getMonthName(Integer.parseInt(checkInDate_[0]));
        String dateToBeSelected = checkInDate_[1];
        String yearToBeSelected = checkInDate_[2];


        String checkOutDate = helpers.expediaOR.getProperty("checkOutDate");
        String[] checkOutDate_ = checkOutDate.split("/");

        String checkOutMonthToBeSelected = getMonthName(Integer.parseInt(checkOutDate_[0]));
        String checkOutDateToBeSelected = checkOutDate_[1];
        String checkOutYearToBeSelected = checkOutDate_[2];

        clickOnElement(goingToButton);
sendKeysToInput(goingToTextFiled, "Dhaka (DAC - Shahjalal Intl.)");
pressEnter(goingToTextFiled);

        clickOnElement(checkInButton);


        List<WebElement> rows, cols, rows2, cols2;



        while (!firstMonthYearTitle.getText().toString().contains(yearToBeSelected)) {
            clickOnElement(nextButton);
            System.out.println("clicked on next button to select correct check in year");
        }

        while (!firstMonthYearTitle.getText().toString().contains(monthToBeSelected)) {
            clickOnElement(nextButton);
            System.out.println("clicked on next button to select correct check in month");
        }

        waitForStaleElement(firstMonthYearTitle, driver, 5);
        waitForElementToBeVisible(firstMonthYearTitle);

        System.out.println(firstMonthYearTitle.getText().toString());

        waitForElementToBeVisible(datePickerMonth);

        waitForStaleElement(datePickerMonth, driver, 5);

        rows = datePickerMonth.findElements(By.tagName("tr"));



        for (int i = 1; i < rows.size(); i++) {
            cols = rows.get(i).findElements(By.tagName("button"));



            for (int k = 0; k < cols.size(); k++) {
                calendarDate = cols.get(k).getAttribute("data-day");

                if (calendarDate.equals(dateToBeSelected)) {

                    clickOn(cols.get(k), driver, 5);

                    System.out.println("date " + calendarDate + " was selected successfully");
                    break;

                }

            }
        }



        while (!firstMonthYearTitle.getText().toString().contains(checkOutYearToBeSelected)) {
            clickOnElement(nextButton);
            System.out.println("clicked on next button to select correct check out year");
        }

        while (!firstMonthYearTitle.getText().toString().contains(checkOutMonthToBeSelected)) {
            clickOnElement(nextButton);
            System.out.println("clicked on next button to select correct check out month");
        }

        waitForStaleElement(firstMonthYearTitle, driver, 5);
        waitForElementToBeVisible(firstMonthYearTitle);

        System.out.println(firstMonthYearTitle.getText().toString());

        waitForElementToBeVisible(datePickerMonth);

        waitForStaleElement(datePickerMonth, driver, 5);

        rows2 = datePickerMonth.findElements(By.tagName("tr"));



        for (int i = 1; i < rows2.size(); i++) {
            cols2 = rows2.get(i).findElements(By.tagName("button"));



            for (int k = 0; k < cols2.size(); k++) {
                calendarDate = cols2.get(k).getAttribute("data-day");

                if (calendarDate.equals(checkOutDateToBeSelected)) {

                    clickOn(cols2.get(k), driver, 5);

                    System.out.println("date " + calendarDate + " was selected successfully");
                    break;

                }

            }
        }

        clickOnElement(doneButton);
        System.out.println("Clicked on done button");
clickOnElement(searchButton);
        System.out.println("Clicked on search button");



    }




    public void selectDate2() {

        String calendarDate;
        String checkInDate = helpers.expediaOR.getProperty("checkInDate");
        String[] checkInDate_ = checkInDate.split("/");

        String monthToBeSelected = getMonthName(Integer.parseInt(checkInDate_[0]));
        String dateToBeSelected = checkInDate_[1];
        String yearToBeSelected = checkInDate_[2];


        String checkOutDate = helpers.expediaOR.getProperty("checkOutDate");
        String[] checkOutDate_ = checkOutDate.split("/");

        String checkOutMonthToBeSelected = getMonthName(Integer.parseInt(checkOutDate_[0]));
        String checkOutDateToBeSelected = checkOutDate_[1];
        String checkOutYearToBeSelected = checkOutDate_[2];


        clickOnElement(checkInButton);


        List<WebElement> rows, cols, rows2, cols2;



        while (!firstMonthYearTitle.getText().toString().contains(yearToBeSelected)) {
            clickOnElement(nextButton);
            System.out.println("clicked on next button to select correct check in year");
        }

        while (!firstMonthYearTitle.getText().toString().contains(monthToBeSelected)) {
            clickOnElement(nextButton);
            System.out.println("clicked on next button to select correct check in month");
        }

        waitForStaleElement(firstMonthYearTitle, driver, 5);
        waitForElementToBeVisible(firstMonthYearTitle);

        System.out.println(firstMonthYearTitle.getText().toString());

        waitForElementToBeVisible(datePickerMonth);

        waitForStaleElement(datePickerMonth, driver, 5);

        rows = datePickerMonth.findElements(By.tagName("tr"));



        for (int i = 1; i < rows.size(); i++) {
            cols = rows.get(i).findElements(By.tagName("button"));



            for (int k = 0; k < cols.size(); k++) {
                calendarDate = cols.get(k).getAttribute("data-day");

                if (calendarDate.equals(dateToBeSelected)) {

                    clickOn(cols.get(k), driver, 5);

                    System.out.println("date " + calendarDate + " was selected successfully");
                    break;

                }

            }
        }



        while (!firstMonthYearTitle.getText().toString().contains(checkOutYearToBeSelected)) {
            clickOnElement(nextButton);
            System.out.println("clicked on next button to select correct check out year");
        }

        while (!firstMonthYearTitle.getText().toString().contains(checkOutMonthToBeSelected)) {
            clickOnElement(nextButton);
            System.out.println("clicked on next button to select correct check out month");
        }

        waitForStaleElement(firstMonthYearTitle, driver, 5);
        waitForElementToBeVisible(firstMonthYearTitle);

        System.out.println(firstMonthYearTitle.getText().toString());

        waitForElementToBeVisible(datePickerMonth);

        waitForStaleElement(datePickerMonth, driver, 5);

        rows2 = datePickerMonth.findElements(By.tagName("tr"));



        for (int i = 1; i < rows2.size(); i++) {
            cols2 = rows2.get(i).findElements(By.tagName("button"));



            for (int k = 0; k < cols2.size(); k++) {
                calendarDate = cols2.get(k).getAttribute("data-day");

                if (calendarDate.equals(checkOutDateToBeSelected)) {

                    clickOn(cols2.get(k), driver, 5);

                    System.out.println("date " + calendarDate + " was selected successfully");
                    break;

                }

            }
        }


    }



    public void selectDate1() {

        String calendarDate;
        String checkInDate = helpers.expediaOR.getProperty("checkInDate");
        String[] checkInDate_ = checkInDate.split("/");

        String monthToBeSelected = getMonthName(Integer.parseInt(checkInDate_[0]));
        String dateToBeSelected = checkInDate_[1];
        String yearToBeSelected = checkInDate_[2];

        clickOnElement(checkInButton);


        List<WebElement> rows, cols;



        while (!firstMonthYearTitle.getText().toString().contains(yearToBeSelected)) {
            clickOnElement(nextButton);
            System.out.println("clicked on next button to select correct year");
        }

        while (!firstMonthYearTitle.getText().toString().contains(monthToBeSelected)) {
            clickOnElement(nextButton);
            System.out.println("clicked on next button to select correct month");
        }

         waitForStaleElement(firstMonthYearTitle, driver, 5);
        waitForElementToBeVisible(firstMonthYearTitle);

        System.out.println(firstMonthYearTitle.getText().toString());

            waitForElementToBeVisible(datePickerMonth);

        waitForStaleElement(datePickerMonth, driver, 5);

            rows = datePickerMonth.findElements(By.tagName("tr"));



            for (int i = 1; i < rows.size(); i++) {
                cols = rows.get(i).findElements(By.tagName("button"));



                for (int k = 0; k < cols.size(); k++) {
                    calendarDate = cols.get(k).getAttribute("data-day");

                    if (calendarDate.equals(dateToBeSelected)) {

                    clickOn(cols.get(k), driver, 5);

                        System.out.println("date " + calendarDate + " was selected successfully");
                        break;

                    }

                }
            }


        }


    public void selectDate() {
        String calendarDate;
        String checkInDate = helpers.expediaOR.getProperty("checkInDate");
        String[] checkInDate_ = checkInDate.split("/");

        String dateToBeSelected = checkInDate_[1];
        String monthToBeSelected = checkInDate_[0];
        String yearToBeSelected = checkInDate_[2];

        clickOnElement(checkInButton);
        List<WebElement> rows, cols;

        rows = datePickerMonth.findElements(By.tagName("tr"));

        for (int i = 1; i < rows.size(); i++) {
            cols = rows.get(i).findElements(By.tagName("button"));

            for (int k = 0; k < cols.size(); k++) {
                calendarDate = cols.get(k).getAttribute("data-day");

                if (calendarDate.equals(dateToBeSelected)) {
                    cols.get(k).click();
                    System.out.println("date " + calendarDate + " was selected successfully");
                    break;
                }
            }


        }

    }










}