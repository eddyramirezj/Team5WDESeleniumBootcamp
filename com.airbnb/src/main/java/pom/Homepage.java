package pom;

import base.BaseClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.Calendar;
import java.util.List;

public class Homepage extends BaseClass {

    public Homepage() {
        PageFactory.initElements(driver, this);
    }

    @FindBy (css = "div._1sfnwgq>svg")
    public WebElement dropDownMenuLoginButton;

    @FindBy (css = "_1xq16jy")
    public WebElement locationTextField;

    @FindBy (css = "div._gor68n>div._wtz1co")
    public WebElement locationTextFieldButton;

    /****************************  The following locators and Methods were added by PNT-1001 ********************/




    @FindBy (css = "#bigsearch-query-detached-query-input")
    public WebElement locationTextBox;


/*    public static final String OPTION_DHAKA_BD = getContainsTextXpath("div", "Dhaka, Bangladesh");
    @FindBy (xpath = OPTION_DHAKA_BD)*/

    @FindBy (xpath = "//div[contains(text(),'Dhaka, Bangladesh')]")
    public WebElement LocationOptionDhaka;




    @FindBy (xpath = "//div[@data-testid='structured-search-input-field-split-dates-0']")
    public WebElement checkInDateBtn;




    @FindBy (xpath = "//div[@data-testid='structured-search-input-field-split-dates-1']")
    public WebElement checkOutDateBtn;



    @FindBy (xpath = "//div[normalize-space()='Add guests']")
    public WebElement guestsBtn;


    //div[@class='_vuaqekp']
    //div[@data-testid='datepicker-day-2021-09-30']

    //td[@aria-label="Choose Thursday, September 30, 2021 as your start date. It's available."]
    //div[@class='_k5mfsv'][normalize-space()='30']

//div[normalize-space()='Add dates']
//div[@class='_vuaqekp']



   /* @FindBy (css = "a[href='/washington-dc/stays']")
    public WebElement washingtonLink;*/

    @FindBy (xpath = "//*[contains(text(), 'Washington')]")
    public WebElement washingtonLink;

    public WashingtonPage goToWashingtonPage(){
        waitForElementToBeClickable(washingtonLink);
        clickOnElement(washingtonLink);
        System.out.println("SUCCESSFULLY landed to WashingtonPage.");
        return new WashingtonPage();
    }

    public void testIfLinkIsPresent(){
        isPresent(washingtonLink);

    }

    @FindBy(xpath = "//button[@aria-label='Next']")
    WebElement GoToNextMonthBtn;

    @FindBy(xpath = "//button[@aria-label='Previous']")
    WebElement GoToPreviousMonthBtn;

  /*  @FindBy(xpath = "//table[@class='_cvkwaj']")
    WebElement tableOfDates;*/


public void locationSearch(){
    try {
//        Thread.sleep(3000);
        waitForElementToBeVisible(locationTextBox);
        sendKeysToInput(locationTextBox,"Dhaka");
        Thread.sleep(1000);
        String selectDhakaBD = getContainsTextXpath("div", "Dhaka, Bangladesh");
        clickOnElement(getDynamicElement(selectDhakaBD));
        Thread.sleep(1000);

        clickOnElement(checkInDateBtn);
        System.out.println("clicked on check-in button");
        Thread.sleep(1000);


        String calYear_XPATH = "//h2[@class='_116xafi']";
        WebElement calendar = getElements(calYear_XPATH).get(0);
        System.out.println(calendar);


     /*   while (!calmonth.equalsIgnoreCase(month))
        {
            driver.findElement(By.className("nextMonth ")).click();
            calmonth=driver.findElement(By.className("ui-datepicker-month")).getText();
        }

        cal=driver.findElement(By.className("calendar"));
*//**
 * Select the Date
 *//*
        List<WebElement> rows,cols;
        rows=cal.findElements(By.tagName("tr"));
        for (int i = 1; i < rows.size(); i++) {
            cols = rows.get(i).findElements(By.tagName("td"));
            for (int k = 0; k < cols.size(); k++) {
                caldt = cols.get(k).getText();
                if (caldt.equals(date)) {
                    cols.get(k).click();
                    break;
                }
            }
        }*/

      /*  String dates_XPATH = "//table[@class='_cvkwaj']//td";
        List<WebElement> allDates = getElements(dates_XPATH);

        for(WebElement ele:allDates)
        {

            String date=ele.getText();

            // once date is 28 then click and break
            if(date.equalsIgnoreCase("13"))
            {
                ele.click();
                break;
            }

        }*/

     /*   String tableOfDates_XPATH= "//table[@class='_cvkwaj']";
        WebElement tableOfDates = getElement(tableOfDates_XPATH);
        System.out.println("table of dates found.");*/
//        String table_XPATH = "//table[@class='_cvkwaj']";
//div[@class='_her4moe']

       /* WebElement tableOfDates=webDriverWait.until(ExpectedConditions.visibilityOfAllElements(getElements(table_XPATH))).get(0);
        List<WebElement> dates = tableOfDates.findElements(By.tagName("td"));*/

    /*    Thread.sleep(2000);

        WebElement tableOfDates= webDriverWait.until(
                ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//table[@class='_cvkwaj']"))).get(0);
        List<WebElement> dates = tableOfDates.findElements(By.tagName("td"));
        System.out.println("list of date collected.");*/



/*


        selectFromElementList( dates, "13");
        System.out.println("clicked on the date to be selected.");
*/




      /*  String dateToBeSelected_XPATH = getContainsAttributeXpath("div", "data-testid","2021-11-14");
        clickOnElement(getElement(dateToBeSelected_XPATH));
        System.out.println("clicked on the date to be selected.");*/



/*
        String checkInDate ="01/07/2022";
        String checkOutDate ="01/15/2022";
        String checkInDate_dd_MM_yyyy[] =checkInDate.split("/");
        String checkOutDate_dd_MM_yyyy[] =checkOutDate.split("/");
*/

//        int yearDiff = Integer.parseInt(checkInDate_dd_MM_yyyy[2])- Calendar.getInstance().get(Calendar.YEAR);

    /*    if(yearDiff!=0){

            //if you have to move next year

            if(yearDiff>0){

                for(int i=0;i< yearDiff;i++){

                    System.out.println("Year Diff = "+i);

                    GoToNextMonthBtn.click();

                }

            } else if(yearDiff<0){

                for(int i=0;i< (yearDiff*(-1));i++){

                    System.out.println("Year Diff = "+i);

                    GoToPreviousMonthBtn.click();

                }

            }

        }
*/





        //        String date = "//div[contains(@data-testid, '2021-11-14')]";

//        String selectCalender_XPATH = getAttributeXpath("div", "class", "_her4moe");
//        List<WebElement> calander = getCalanderItems(selectCalender_XPATH, "_116xafi");
//        List<WebElement> calander = getCalanderItems(selectCalender_XPATH, "td");


    /*    selectFromElementList(calander, "13");
        System.out.println("selected month");
        Thread.sleep(2000);*/


       /* String selectMonth_XPATH = getContainsTextXpath("*", "December 2021");
        getElement(selectMonth_XPATH).click();
*/



//        selectLinkDate(getElement(selectCalender_XPATH), "10");
//        Thread.sleep(2000);



    } catch (InterruptedException e) {
        e.printStackTrace();
    }

}



/****************************  The above locators were added by PNT-1001 ****************************/



}
