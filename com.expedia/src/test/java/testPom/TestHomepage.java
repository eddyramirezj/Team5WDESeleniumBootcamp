package testPom;

import org.testng.annotations.Test;
import pom.Homepage;
import testBase.TestBase;

public class TestHomepage extends TestBase {




    @Test(enabled = true)
    public void testStayFunctionality(){
        Homepage homepage = new Homepage();
        homepage.selectDate();

    }

/*    @Test(enabled = true)
    public void testerMethod(){
        Homepage homepage = new Homepage();
        String s = homepage.calendarMonthName.getText().toString();
        System.out.println(s);
    }*/
}
