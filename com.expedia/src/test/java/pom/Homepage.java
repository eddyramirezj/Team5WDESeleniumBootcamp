package pom;

import base.BaseClass;
import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.Calendar;
import java.util.List;

public class Homepage extends BaseClass {

    public Homepage() {
        PageFactory.initElements(driver, this);
    }



    @FindBy(xpath = "//button[@id='d1-btn']")
    public WebElement openDatePicker;

    @FindBy(xpath = "//div[@data-stid='date-picker-month']")
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

//    uitk-date-picker-month-name uitk-type-medium
//      uitk-date-picker-month-name uitk-type-medium

public void selectDate(){
    String calendarDate;
    String checkInDate = expediaOR.getProperty("checkInDate");
    String[] checkInDate_ = checkInDate.split("/");

    String monthToBeSelected = getMonthName(Integer.parseInt(checkInDate_[0]));
    String dateToBeSelected = checkInDate_[1];
    String yearToBeSelected = checkInDate_[2];

    clickOnElement(openDatePicker);



    List<WebElement> rows,cols, nextPreviousBtn, allMonths;

    nextPreviousBtn = yearMonthTitle.findElements(By.tagName("button"));
    int noOfButtons = nextPreviousBtn.size();
    System.out.println("no of buttons: " + noOfButtons);



    allMonths = monthMenu.findElements(By.tagName("h2"));
    int noOfMonths = allMonths.size();
    System.out.println("no of months: " + noOfMonths);
    System.out.println(allMonths.get(1).getText().toString());
    System.out.println(allMonths.get(0).getText().toString());


    int iYearDifference = Integer.parseInt(yearToBeSelected)- Calendar.getInstance().get(Calendar.YEAR);


    if(iYearDifference!=0){

        //if you have to move next year

        if(iYearDifference>0){

            for(int i=0;i< iYearDifference;i++){

                System.out.println("Year Difference :"+i);

                nextPreviousBtn.get(1).click();

            }

        }

        //if you have to move previous year

        else if(iYearDifference<0){

            for(int i=0;i< (iYearDifference*(-1));i++){

                System.out.println("Year Difference :"+i);

                nextPreviousBtn.get(0).click();

            }

        }

    }

  /*  while (!allMonths.get(0).getText().toString().contains(yearToBeSelected)) {
        nextPreviousBtn.get(1).click();
    }*/
    while(!allMonths.get(0).getText().toString().contains(monthToBeSelected)) {


        try {
            clickOnElement(nextPreviousBtn.get(1));
            System.out.println("clicked on next button");
        } catch (StaleElementReferenceException e) {
            e.printStackTrace();
        }
    }

    try {
        Thread.sleep(5000);
    } catch (InterruptedException e) {
        e.printStackTrace();
    }


    waitForElementToBeVisible(datePickerMonth);
    rows=datePickerMonth.findElements(By.tagName("tr"));
//    System.out.println("size of rows in Date Picker Month: " + rows.size());

    for (int i = 1; i < rows.size(); i++)
    {
//        cols=rows.get(i).findElements(By.tagName("td"));
        cols=rows.get(i).findElements(By.tagName("button"));


//        System.out.println("Row# or Week#: " + i + " and Days/column size: " + cols.size());

        for (int k = 0; k < cols.size(); k++)
        {
            calendarDate=cols.get(k).getAttribute("data-day");



//            System.out.println("date found" +calendarDate);

            if (calendarDate.equals(dateToBeSelected))
            {
//                System.out.println(calendarDate);
                cols.get(k).click();


                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }


                System.out.println("date " + calendarDate + " was selected successfully");
                break;

            }

        }
    }



}






/*
public void selectDate(){
String calendarDate;
String checkInDate = expediaOR.getProperty("checkInDate");
String[] checkInDate_ = checkInDate.split("/");

String dateToBeSelected = checkInDate_[1];
String monthToBeSelected = checkInDate_[0];
String yearToBeSelected = checkInDate_[2];

    clickOnElement(openDatePicker);



    List<WebElement> rows,cols;

    rows=datePickerMonth.findElements(By.tagName("tr"));
//    System.out.println("size of rows in Date Picker Month: " + rows.size());

    for (int i = 1; i < rows.size(); i++)
    {
//        cols=rows.get(i).findElements(By.tagName("td"));
        cols=rows.get(i).findElements(By.tagName("button"));


//        System.out.println("Row# or Week#: " + i + " and Days/column size: " + cols.size());

        for (int k = 0; k < cols.size(); k++)
        {
            calendarDate=cols.get(k).getAttribute("data-day");



//            System.out.println("date found" +calendarDate);

            if (calendarDate.equals(dateToBeSelected))
            {
//                System.out.println(calendarDate);
                cols.get(k).click();


          *//*      try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }*//*


                System.out.println("date " + calendarDate + " was selected successfully");
                break;

            }

        }
    }



}*/

}
