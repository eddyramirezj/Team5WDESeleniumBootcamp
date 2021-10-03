package utilsPNT1001;

import base.BaseClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.time.LocalDate;
import java.util.Calendar;
import java.util.List;
import java.util.TimeZone;

public class DatePicker extends BaseClass {


    public static String getCurrentDay() {
        //Create a Calendar Object
        Calendar calendar = Calendar.getInstance(TimeZone.getDefault());
        //Get Current Day as a number
        int todayInt = calendar.get(Calendar.DAY_OF_MONTH);
        System.out.println("Today Int: " + todayInt + "\n");
        //Integer to String Conversion
        String todayStr = Integer.toString(todayInt);
        System.out.println("Today Str: " + todayStr + "\n");
        return todayStr;
    }

    //Get The Current Day plus days. You can change this method based on your needs.
    public static String getCurrentDayPlus(int days) {
        LocalDate currentDate = LocalDate.now();
        int dayOfWeekPlus = currentDate.getDayOfWeek().plus(days).getValue();
        return Integer.toString(dayOfWeekPlus);
    }

    //Click to given day
    public static void clickGivenDay(List<WebElement> elementList, String day) {
        //DatePicker is a table. Thus we can navigate to each cell
        //and if a cell matches with the current date then we will click it.
        /**Functional JAVA version of this method.*/
        elementList.stream()
                .filter(element -> element.getText().contains(day))
                .findFirst()
                .ifPresent(WebElement::click);
        /**Non-functional JAVA version of this method.*/
        //for (
        //    WebElement cell : elementList) {
        //    String cellText = cell.getText();
        //    if (cellText.contains(day)) {
        //        cell.click();
        //        break;
        //    }
        //}
    }


    public static void selectDate() {

        String dot = "15/10/2021";
        String date, month, year;
        String caldt, calmonth, calyear;
        /*
         * Spliting the String into String Array
         */
        String dateArray[] = dot.split("/");
        date = dateArray[0];
        month = dateArray[1];
        year = dateArray[2];


        driver.findElement(By.id("DepartDate")).click();

        WebElement cal;
        cal = driver.findElement(By.className("calendar"));
        calyear = driver.findElement(By.className("ui-datepicker-year")).getText();
/**
 * Select the year
 */
        while (!calyear.equals(year)) {
            driver.findElement(By.className("nextMonth")).click();
            calyear = driver.findElement(By.className("ui-datepicker-year")).getText();
            System.out.println("The Displayed Year::" + calyear);
        }

        calmonth = driver.findElement(By.className("ui-datepicker-month")).getText();
/**
 * Select the Month
 */
        while (!calmonth.equalsIgnoreCase(month)) {
            driver.findElement(By.className("nextMonth ")).click();
            calmonth = driver.findElement(By.className("ui-datepicker-month")).getText();
        }

        cal = driver.findElement(By.className("calendar"));
/**
 * Select the Date
 */
        List<WebElement> rows, cols;
        rows = cal.findElements(By.tagName("tr"));
        for (int i = 1; i < rows.size(); i++) {
            cols = rows.get(i).findElements(By.tagName("td"));
            for (int k = 0; k < cols.size(); k++) {
                caldt = cols.get(k).getText();
                if (caldt.equals(date)) {
                    cols.get(k).click();
                    break;
                }
            }
        }
    }
}