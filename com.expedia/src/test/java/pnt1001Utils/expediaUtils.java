package pnt1001Utils;

import base.BaseClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import pom.Homepage;

import java.util.Calendar;
import java.util.List;

public class expediaUtils extends BaseClass {
    Homepage homepage = new Homepage();

    /** ***************************************** Method pickCalendarDate started **************************************/

    public void pickCalendarDate(WebElement monthYearTitle, String mm_dd_yyyy){
        String calendarDate;

        String[] checkInDate_ = mm_dd_yyyy.split("/");

        String monthToBeSelected = getMonthName(Integer.parseInt(checkInDate_[0]));
        String dateToBeSelected = checkInDate_[1];
        String yearToBeSelected = checkInDate_[2];



        List<WebElement> rows, cols;



        while (!monthYearTitle.getText().toString().contains(yearToBeSelected)) {
            clickOnElement(homepage.nextButton);
            System.out.println("clicked on next button to select correct check in year");
        }

        while (!monthYearTitle.getText().toString().contains(monthToBeSelected)) {
            clickOnElement(homepage.nextButton);
            System.out.println("clicked on next button to select correct check in month");
        }

        waitForStaleElement(monthYearTitle, driver, 5);
        waitForElementToBeVisible(monthYearTitle);


        waitForElementToBeVisible(homepage.datePickerMonth);
        waitForStaleElement(homepage.datePickerMonth, driver, 5);

        rows = homepage.datePickerMonth.findElements(By.tagName("tr"));



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


/** ***************************************** Method findYearDifference started **************************************/

    public void findYearDifference(WebElement monthYearTitle, String mm_dd_yyyy) {

        String[] checkInDate_ = mm_dd_yyyy.split("/");

        String monthToBeSelected = getMonthName(Integer.parseInt(checkInDate_[0]));
        String dateToBeSelected = checkInDate_[1];
        String yearToBeSelected = checkInDate_[2];

        int iYearDifference = Integer.parseInt(yearToBeSelected) - Calendar.getInstance().get(Calendar.YEAR);
        System.out.println("Initial Year difference: " + iYearDifference);

        if (iYearDifference != 0) {

            //if you have to move next year

            if (iYearDifference > 0) {

                for (int i = 1; i < iYearDifference; i++) {

                    System.out.println("Year Difference :" + i);

                    clickOnElement(homepage.nextButton);

                    System.out.println("Clicked on next button.");

                }

            }

            //if you have to move previous year

            else if (iYearDifference < 0) {

                for (int i = 0; i < (iYearDifference * (-1)); i++) {

                    System.out.println("Year Difference :" + i);

                    clickOnElement(homepage.previousButton);

                    System.out.println("Clicked on previous button.");

                }

            }

        }

    }

    /** ***************************************** Method readDayOfTheDate started **************************************/

    public String readDayOfTheDate(String mm_dd_yyyy){
        String date = expediaOR.getProperty(mm_dd_yyyy);
        String[] date_ = date.split("/");
//        System.out.println(date_[1]);
        return date_[1];
    }

    /** ***************************************** Method readYearOfTheDate started **************************************/

    public String readYearOfTheDate(String mm_dd_yyyy){
        String date = expediaOR.getProperty(mm_dd_yyyy);
        String[] date_ = date.split("/");
//        System.out.println(date_[2]);
        return date_[2];
    }

    /** ***************************************** Method readMonthOfTheDate started **************************************/


    public String readMonthOfTheDate(String mm_dd_yyyy){
        String date = expediaOR.getProperty(mm_dd_yyyy);
        String[] date_ = date.split("/");

//        System.out.println(getMonthName(Integer.parseInt(date_[0])));
        return getMonthName(Integer.parseInt(date_[0]));
    }


    /** ***************************************** Method  started **************************************/





}
