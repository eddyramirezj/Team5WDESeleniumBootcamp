package testPom;

import org.testng.annotations.Test;
import pom.Homepage;
import testBase.TestBase;

public class TestHomepage extends TestBase {






    @Test(enabled = false)
    public void testReadExcel1(){
        Homepage homepage = new Homepage();
        homepage.getExcelData1();


    }

    @Test(enabled = false)
    public void testStaySearchFunction(){
        Homepage homepage = new Homepage();
        homepage.staySearchFunction();
        String errorMsg = homepage.errorMessage.getText();
        boolean b = errorMsg.contains("error");
        verifyTrue(b);

    }

    @Test(enabled = false)
    public void testDatePicker5(){
        Homepage homepage = new Homepage();
        homepage.selectDate4();
        String errorMsg = homepage.errorMessage.getText();
        boolean b = errorMsg.contains("error");
        verifyTrue(b);

    }

    @Test(enabled = false)
    public void testDatePicker4(){
        Homepage homepage = new Homepage();
        homepage.selectDate3();
        String errorMsg = homepage.errorMessage.getText();
        boolean b = errorMsg.contains("error");
        verifyTrue(b);

    }


    @Test(enabled = false)
    public void testDatePicker3(){
        Homepage homepage = new Homepage();
        homepage.selectDate2();
    }

    @Test(enabled = false)
    public void testDatePicker2(){
        Homepage homepage = new Homepage();
        homepage.selectDate1();
    }

    @Test(enabled = false)
    public void testDatePicker1(){
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
