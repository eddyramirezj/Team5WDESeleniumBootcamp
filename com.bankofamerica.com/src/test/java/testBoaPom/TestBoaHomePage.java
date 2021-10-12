package testBoaPom;

import org.testng.annotations.Test;
import testBase.TestBase;

public class TestBoaHomePage extends TestBase {


@Test
    public void testBoaLogin(){

    BoaHomePage boaHomePage = new BoaHomePage();
    boaHomePage.testLogin("abcde", "12345#");


}


}
