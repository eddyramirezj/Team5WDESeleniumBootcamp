package testPom;

import base.BaseClass;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;
import pom.Homepage;
import pom.WashingtonPage;
import testBase.TestBase;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class TestUnitTester extends TestBase {

    public TestUnitTester() {

        PageFactory.initElements(driver, this);

    }

    public static final String  absPath = System.getProperty("user.dir");
    public static final String  resourcesPath = absPath +"\\com.airbnb\\src\\main\\resources\\";





    public static void main(String[] args) {



    }

@Test(enabled = true)
public void testAFunctionality(){
    Homepage homepage = new Homepage();

    homepage.locationSearch();


}











/*    public static Properties loadProp(String fileName) {
        Properties prop = new Properties();
        try {
            InputStream ism = new FileInputStream(resourcesPath + fileName + ".properties");
            prop.load(ism);
            ism.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return prop;
    }*/





}
