package utilsPNT1001;

//import jdk.jfr.internal.Repository;
import org.openqa.selenium.*;
import org.testng.Assert;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class Helpers {



   static WebDriver driver;
//   public Properties prop = new Properties();
//    public static FileInputStream fis;

    public static Properties loadProperties() throws IOException {
        Properties prop = new Properties();
        InputStream ism = new FileInputStream("src/resources/data.properties");
        prop.load(ism);
        ism.close();
        return prop;
    }

//    C:\Users\nahid\IdeaProjects\Team5WDESeleniumBootcamp\base\src\main\resources\secret.properties

    public static Properties loadProperties(String fileName) throws IOException {
        Properties prop = new Properties();
        InputStream ism = new FileInputStream("src/main/java/base/resources/" + fileName + ".properties");
        prop.load(ism);
        ism.close();
        return prop;
    }
    public static Properties OR;
    {
        try {
            OR = loadProperties("Repository");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static final String absPath = System.getProperty("user.dir");
    public static final String resourcesPath = absPath + "\\com.airbnb\\src\\main\\resources\\";




    public static WebElement getWebElement(String locator){


        String[] tokens = locator.split("_");
        String locatorType = tokens[tokens.length-1];
        String strlocator = OR.getProperty(locator).trim();
        WebElement webElement = null;

        try{

            if(locatorType.equalsIgnoreCase("XPATH")){

                webElement = driver.findElement(By.xpath(strlocator));

            }else if(locatorType.equalsIgnoreCase("ID")){

                webElement = driver.findElement(By.id(strlocator));

            }else if(locatorType.equalsIgnoreCase("NAME")){

                webElement = driver.findElement(By.name(strlocator));

            }else if(locatorType.equalsIgnoreCase("CSS")){

                webElement = driver.findElement(By.cssSelector(strlocator));

            }else if(locatorType.equalsIgnoreCase("LINKTEXT")){

                webElement = driver.findElement(By.linkText(strlocator));
            }

        }catch(NoSuchElementException e){

            e.printStackTrace();
//            log.error(strlocator + " Element not found");
//            Assert.fail(strlocator + " Element not found");

        }

        return webElement;

    }



    public static void buttonClick(String locator, String name){

        try{

            if(getWebElement(locator).isEnabled()){

                getWebElement(locator).click();
//                log.info("Clicked on "+"'"+name+"'"+ " button");

            }else{

//                log.error("'"+name+"'" + " : Button is not enabled");
//                Assert.fail("'"+name+"'" + " : Button is not enabled");
            }

        }catch(NoSuchElementException e){

            e.printStackTrace();
//            log.error(locator + " : Button not found");
            Assert.fail(locator + " : Button not found");

        }catch(ElementNotVisibleException e){

            e.printStackTrace();
//            log.error(locator + " : Button not visible");
            Assert.fail(locator + " : Button not visible");

        }
    }
}
