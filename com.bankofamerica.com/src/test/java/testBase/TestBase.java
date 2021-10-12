package testBase;

import base.BaseClass;
import boaPnt1001Utils.ExcelReader;
import org.openqa.selenium.ElementNotVisibleException;
import org.openqa.selenium.WebElement;

import java.util.Properties;


public class TestBase extends BaseClass {

//    public Homepage getHomepage() {
//        return new Homepage();
//    }

//   public BoaHomePage boaHomePage = new BoaHomePage();

public static final String absPath = System.getProperty("user.dir");

public String resourcesPath = absPath + "\\src\\test\\resources\\";
public String boaORPath = absPath + "\\src\\test\\resources\\BoaOR.properties";
//String excelPath=resourcesPath+"boaTestData.xlsx";
public Properties boaOR = loadProp(boaORPath);
String boaExcelPath=getProp("boaTestDataPath");
public ExcelReader boaExcel = new ExcelReader(boaExcelPath);

public String getProp(String key){
    return boaOR.getProperty(key);

}


    public boolean isElementPresent(WebElement element) {
        boolean flag = false;

        try {
            if (element.isDisplayed()){
                flag = true;
            }
        } catch (ElementNotVisibleException e) {
            System.out.println("UNABLE TO LOCATE ELEMENT");
        }

        return flag;
    }
}