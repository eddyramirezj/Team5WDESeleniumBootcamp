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
import java.lang.reflect.Method;
import java.util.Calendar;
import java.util.Date;
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

    @BeforeSuite (alwaysRun = true)
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

    @BeforeSuite (alwaysRun = true)
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

    @Parameters ({"browser", "url"})
    @BeforeMethod (alwaysRun = true)
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

    @AfterSuite (alwaysRun = true)
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

    public void clickJScript(WebElement element) {
        JavascriptExecutor js = (JavascriptExecutor)driver;
        js.executeScript("arguments[0].click();", element);
    }

    public void createJSAlert(String alertText) {
        JavascriptExecutor js = (JavascriptExecutor)driver;
        js.executeScript("alert('" + alertText + "');");
    }

    public void scrollJS(int numOfPixelsToScroll) {
        JavascriptExecutor js = (JavascriptExecutor)driver;
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


    public void log(String info){
        Reporter.log(info);
        System.out.println(info);
    }
    public boolean isPresent(WebElement element) {
        boolean flag = false;
        log("waiting for element " + element.toString() +"to be visible");
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



    public void verifyEquals(String actualValue, String expectedValue){
log("verifying if the ACTUAL result and EXPECTED results are equal.");
        try {
            Assert.assertEquals(actualValue, expectedValue );
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void verifyTrue(boolean conditionToBeTested){

        try {
            Assert.assertTrue(conditionToBeTested, "The condition is false.");
        } catch (Exception e) {
            e.printStackTrace();
            log("The boolean condition was tested and found to be false.");
        }

    }


    /******************    The above helper methods were added by PNT-1001     *******************************/

}