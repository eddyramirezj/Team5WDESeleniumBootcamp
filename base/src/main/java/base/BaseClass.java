package base;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.LogStatus;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.*;
import reporting.ExtentManager;
import reporting.ExtentTestManager;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Method;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class BaseClass {

    public static WebDriver driver;
    public static WebDriverWait webDriverWait;
    public static ExtentReports extent;

    public static DataReader dataReader;
    public MySQLConnection database;

    private Properties properties;
    public final String ABSOLUTE_PATH = System.getProperty("user.dir");
    public final String PROPERTIES_RELATIVE_PATH = "/src/main/resources/secret.properties";
    private final String PROP_FILE_PATH = ABSOLUTE_PATH + PROPERTIES_RELATIVE_PATH;


    public String expediaExcelPath = "C:\\Users\\nahid\\IdeaProjects\\Team5WDESeleniumBootcamp\\com.expedia\\src\\test\\resources\\testData.xlsx";

    @BeforeSuite(alwaysRun = true)
    public void beforeSuiteExtentSetup(ITestContext context) {
        ExtentManager.setOutputDirectory(context);
        extent = ExtentManager.getInstance();
    }

//    @BeforeMethod (alwaysRun = true)
//    public static void beforeEachMethodExtentInit(Method method) {
//        String className = method.getDeclaringClass().getSimpleName();
//        String methodName = method.getName();
//
//        ExtentTestManager.startTest(methodName);
//        ExtentTestManager.getTest().assignCategory(className);
//
//        System.out.println("\n\t***" + methodName + "***\n");
//    }

    @BeforeSuite(alwaysRun = true)
    public void setUp() {
        try {
            properties = new Properties();
            FileInputStream fis = new FileInputStream(PROP_FILE_PATH);
            properties.load(fis);
        } catch (Exception e) {
            e.printStackTrace();
        }

        try {
            dataReader = new DataReader();
        } catch (Exception e) {
            e.printStackTrace();
        }

        try {
            database = new MySQLConnection();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Parameters({"browser", "url"})
    @BeforeMethod(alwaysRun = true)
    public void driverSetup(@Optional("chrome") String browser, String url) {
        driver = initDriver(browser);
        webDriverWait = new WebDriverWait(driver, 10);

        driver.get(url);
        driver.manage().deleteAllCookies();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }

//    @AfterMethod
//    public void extentFlush(ITestResult result) {
//        ExtentTestManager.getTest().getTest().setStartedTime(getTime(result.getStartMillis()));
//        ExtentTestManager.getTest().getTest().setEndedTime(getTime(result.getEndMillis()));
//
//        for (String group : result.getMethod().getGroups()) {
//            ExtentTestManager.getTest().assignCategory(group);
//        }
//
//        if (result.getStatus() == ITestResult.FAILURE) {
//            ExtentTestManager.getTest().log(LogStatus.FAIL, "TEST CASE FAILED: " + result.getName());
//            ExtentTestManager.getTest().log(LogStatus.FAIL, result.getThrowable());
//            captureScreenshot(driver, result.getName());
//        } else if (result.getStatus() == ITestResult.SKIP) {
//            ExtentTestManager.getTest().log(LogStatus.SKIP, "TEST CASE SKIPPED: " + result.getName());
//        } else if (result.getStatus() == ITestResult.SUCCESS) {
//            ExtentTestManager.getTest().log(LogStatus.PASS, "TEST CASE PASSED: " + result.getName());
//        }
//
//        ExtentTestManager.endTest();
//        extent.flush();
//    }

    @AfterMethod
    public void driverClose() {
        driver.close();
    }

    @AfterSuite(alwaysRun = true)
    private void afterSuiteTearDown() {
        driver.quit();
        extent.close();
    }

    public WebDriver initDriver(String browser) {
        switch (browser.toLowerCase().trim()) {
            case "chrome":
                WebDriverManager.chromedriver().setup();
                driver = new ChromeDriver();
                break;
            case "firefox":
                WebDriverManager.firefoxdriver().setup();
                driver = new FirefoxDriver();
                break;
            case "edge":
                WebDriverManager.edgedriver().setup();
                driver = new EdgeDriver();
                break;
        }
        return driver;
    }

//    private Date getTime(long millis) {
//        Calendar calendar = Calendar.getInstance();
//        calendar.setTimeInMillis(millis);
//        return calendar.getTime();
//    }

//    private static void captureScreenshot(WebDriver driver, String testName) {
//        String fileName = testName + ".png";
//        File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
//        File newScreenshotFile = new File(System.getProperty("user.dir") + File.separator + "src" + File.separator +
//                "main" + File.separator + "java" + File.separator + "reporting" + File.separator + fileName);
//
//        try {
//            FileHandler.copy(screenshot, newScreenshotFile);
//            System.out.println("SCREENSHOT TAKEN");
//        } catch (Exception e) {
//            System.out.println("ERROR TAKING SCREENSHOT: " + e.getMessage());
//        }
//    }

    /*
    Selenium Helper Methods
     */

    public WebElement safeFindElement(By by) {
        return driver.findElement(by);
    }

    public void dismissAlert() {
        driver.switchTo().alert().dismiss();
    }

    public void confirmAlert() {
        driver.switchTo().alert().accept();
    }

    public String getTextFromAlert() {
        return driver.switchTo().alert().getText();
    }

    public void sendKeysToInput(WebElement element, String keys) {
        webDriverWait.until(ExpectedConditions.visibilityOf(element));
        element.clear();
        element.sendKeys(keys);
    }

    public void dropdownSelectByVisibleText(WebElement element, String visibleText) {
        webDriverWait.until(ExpectedConditions.visibilityOf(element));

        Select select = new Select(element);
        select.selectByVisibleText(visibleText);
    }

    public void clickOnElement(WebElement element) {
        try {
            webDriverWait.until(ExpectedConditions.elementToBeClickable(element));
        } catch (StaleElementReferenceException e1) {
            e1.printStackTrace();
        }

        try {
            element.click();
        } catch (Exception e1) {
            clickJScript(element);
        }
    }

    public void pressEnter(WebElement element){

        element.sendKeys(Keys.ENTER);
    }

    public void clickJScript(WebElement element) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click();", element);
    }

    public void createJSAlert(String alertText) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("alert('" + alertText + "');");
    }

    public void scrollJS(int numOfPixelsToScroll) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0," + numOfPixelsToScroll + ")");
    }

    public void hoverOverElement(WebElement element) {
        Actions action = new Actions(driver);
        action.moveToElement(element).build().perform();

    }

    /*
    SYNC Methods
     */
    public void waitForElementToBeVisible(WebElement element) {
        try {
            webDriverWait.until(ExpectedConditions.visibilityOf(element));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void waitForElementToContainText(WebElement element, String text) {
        try {
            webDriverWait.until(ExpectedConditions.textToBePresentInElement(element, text));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void waitForElementToBeClickable(WebElement element) {
        try {
            webDriverWait.until(ExpectedConditions.elementToBeClickable(element));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void waitForElementToBeSelected(WebElement element) {
        try {
            webDriverWait.until(ExpectedConditions.elementToBeSelected(element));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public void waitForTitleOfPageToContain(String title) {
        try {
            webDriverWait.until(ExpectedConditions.titleContains(title));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    /******************    The below helper methods were added by PNT-1001     *******************************/
    public static final String absPath = System.getProperty("user.dir");
    //    C:\Users\nahid\IdeaProjects\Team5WDESeleniumBootcamp\com.expedia


    /*public String airbnbORPath = absPath + "\\src\\test\\resources\\airbnbRepo.properties";
    public Properties airbnbOR = loadProp(airbnbORPath);*/
//    C:\Users\nahid\IdeaProjects\Team5WDESeleniumBootcamp\com.expedia\src\test\resources\ExpediaRepo.properties
    public String expediaORPath = absPath + "\\src\\test\\resources\\ExpediaRepo.properties";
    public Properties expediaOR = loadProp(expediaORPath);

    public Properties loadProp(String filePathWithExtension) {
        Properties prop = new Properties();
        try {
            InputStream ism = new FileInputStream(filePathWithExtension);
            prop.load(ism);
            ism.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return prop;
    }

    public void selectCheckbox(WebElement element){
        waitForElementToBeSelected(element);
        if(!element.isSelected())
            clickOnElement(element);
    }

    public void clickOn(By locator, WebDriver driver, int timeout)
    {
        final WebDriverWait wait = new WebDriverWait(driver, timeout);
        wait.until(ExpectedConditions.refreshed(
                ExpectedConditions.elementToBeClickable(locator)));
        driver.findElement(locator).click();
    }

    public void clickOn(WebElement element, WebDriver driver, int timeout)
    {
        final WebDriverWait wait = new WebDriverWait(driver, timeout);
        wait.until(ExpectedConditions.refreshed(
                ExpectedConditions.elementToBeClickable(element)));
        element.click();
    }

    public void waitForStaleElement(WebElement element, WebDriver driver, int timeout)
    {
        final WebDriverWait wait = new WebDriverWait(driver, timeout);
        wait.until(ExpectedConditions.refreshed(
                ExpectedConditions.elementToBeClickable(element)));

    }


    public String getMonthName(int monthIndex){
        String monthName=null;

       switch (monthIndex) {
           case 1:
               monthName = "January";
               break;
           case 2:
               monthName = "February";
               break;
           case 3:
               monthName = "March";
               break;
           case 4:
               monthName = "April";
               break;
           case 5:
               monthName = "May";
               break;
           case 6:
               monthName = "June";
               break;
           case 7:
               monthName = "July";
               break;
           case 8:
               monthName = "August";
               break;
           case 9:
               monthName = "September";
               break;
           case 10:
               monthName = "October";
               break;
           case 11:
               monthName = "November";
               break;
           case 12:
               monthName = "December";
               break;

       }
       return monthName;
    }







    public void log(String info) {
        Reporter.log(info);
        System.out.println(info);
    }

    public static void waitForElementPresence(String locator) {

        WebDriverWait wait = new WebDriverWait(driver, 30);

        boolean flag = false;
        if(locator.contains("/"))
            flag = true;
        if(driver.findElements(By.id(locator)).size() >= 1){
            wait.until(ExpectedConditions.presenceOfElementLocated(By.id(locator)));
            return;
        }else if(driver.findElements(By.name(locator)).size() >= 1 ){
            wait.until(ExpectedConditions.presenceOfElementLocated(By.name(locator)));
            return;
        }else if(!flag && driver.findElements(By.cssSelector(locator)).size() >= 1){
            wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(locator)));
            return;
        }else if(driver.findElements(By.xpath(locator)).size() >= 1){
            wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(locator)));
            return;
        }else
            throw new NoSuchElementException("Element Not Found : " + locator);

    }
    public static boolean isElementPresent(String locator) {
        boolean status = false;

        boolean flag = false;
        if(locator.contains("/"))
            flag = true;
        if(driver.findElements(By.id(locator)).size() >= 1){
            status = true;
        }else if(driver.findElements(By.name(locator)).size() >= 1 ){
            status = true;
        }else if(!flag && driver.findElements(By.cssSelector(locator)).size() >= 1){
            status = true;
        }else if(driver.findElements(By.xpath(locator)).size() >= 1){
            status = true;
        }else
            status = false;
        return status;
    }

    public boolean isPresent(WebElement element) {
        boolean flag = false;
        log("waiting for element " + element.toString() + "to be visible");
        waitForElementToBeVisible(element);

        try {
            if (element.isDisplayed()) {
                flag = true;
                System.out.println("Element found: " + element);
            }
        } catch (ElementNotVisibleException e) {
            e.printStackTrace();
            System.out.println("Element NOT found: " + element);
        }
        return flag;
    }


    public void verifyEquals(String actualValue, String expectedValue) {
        log("verifying if the ACTUAL result and EXPECTED results are equal.");
        try {
            Assert.assertEquals(actualValue, expectedValue);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void verifyTrue(boolean conditionToBeTested) {

        try {
            Assert.assertTrue(conditionToBeTested);
        } catch (Exception e) {
            e.printStackTrace();
            log("The boolean condition was found false.");
        }

    }

    public static final String getContainsTextXpath(String tagName, String textToSearch) {
        String xpath = "//" + tagName + "[contains(text(), '" + textToSearch + "')]";
        return xpath;
    }

    public static final String getContainsAttributeXpath(String tagName, String attribute , String attributeValue) {
        String xpath = "//" + tagName + "[contains(@" + attribute + ", '" + attributeValue + "')]";

        return xpath;
    }
    public static final String getAttributeXpath(String tagName, String attribute , String attributeValue) {
        String xpath = "//" + tagName + "[@" +attribute + "= '" + attributeValue + "']";
        return xpath;
    }


    public WebElement getDynamicElement(String dynamicXpath) {
        return driver.findElement(By.xpath(dynamicXpath));
    }



    public static void selectLinkDate(WebElement calenderFocus, String dateToBeSelected) {
        try {

            List<WebElement> columns = calenderFocus.findElements(By.tagName("li"));

            for (WebElement cell : columns) {
                if (cell.getText().equals(dateToBeSelected)) {
                    cell.findElement(By.linkText(dateToBeSelected)).click();
                    break;
                }
            }
        } catch (Exception e) {

            e.printStackTrace();
        }

    }
    public  WebElement getElement(String locator) {
        WebElement element = null;
 /*       try {
            waitForElementToBeVisible(getElement(locator));
        } catch (Exception e) {
            e.printStackTrace();
        }*/

        if (locator.endsWith("_CSS")) {
            element = driver.findElement(By.cssSelector(locator));
        } else if (locator.endsWith("_XPATH")) {
            element = driver.findElement(By.xpath(locator));
        } else if (locator.endsWith("_ID")) {
            element = driver.findElement(By.id(locator));
        }else if (locator.endsWith("_CLASSNAME")) {
            element = driver.findElement(By.id(locator));
        }else if (locator.endsWith("_NAME")) {
            element = driver.findElement(By.id(locator));
        }else if (locator.endsWith("_LINKTEXT")) {
            element = driver.findElement(By.id(locator));
        }else if (locator.endsWith("_PARTIALTEXT")) {
            element = driver.findElement(By.id(locator));
        }else
            throw new NoSuchElementException("No Such Element : " + locator);
        return element;

    }
    public List<WebElement> getElements(String sLocator) {
        try {
            waitForElementToBeVisible(getElement(sLocator));
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (sLocator.endsWith("_CSS")) {
            return driver.findElements(By.cssSelector(sLocator));
        } else if (sLocator.endsWith("_XPATH")) {
            return driver.findElements(By.xpath(sLocator));
        } else if (sLocator.endsWith("_ID")) {
            return driver.findElements(By.id(sLocator));
        } else if (sLocator.endsWith("_CLASSNAME")) {
            return driver.findElements(By.className(sLocator));
        } else if (sLocator.endsWith("_NAME")) {
            return driver.findElements(By.name(sLocator));
        } else if (sLocator.endsWith("_LINKTEXT")) {
            return driver.findElements(By.linkText(sLocator));
        } else if (sLocator.endsWith("_PARTIALTEXT")) {
            return driver.findElements(By.partialLinkText(sLocator));
        } else
            throw new NoSuchElementException("No Such Element : " + sLocator);
    }

    public  List<WebElement> getCalanderItems(String calanderLocator,
                                                    String tagName) {
        List<WebElement> listOfElements = null;
        try {
//            listOfElements = getElement(calanderLocator).findElements(By.tagName(optionName));
            listOfElements = getElement(calanderLocator).findElements(By.tagName(tagName));
            if (listOfElements.size() != 0)
                System.out.println("No of Dropdown list element found : " + listOfElements.size());
        } catch (NoSuchElementException e) {
            e.printStackTrace();
        }
        return listOfElements;
    }

    public void selectFromElementList(List<WebElement> list, String valueToBeSelected){

        for(WebElement x :list){

            if(x.getText().equalsIgnoreCase(valueToBeSelected))
                x.click();

        }

    }




        /******************    The above helper methods were added by PNT-1001     *******************************/


}